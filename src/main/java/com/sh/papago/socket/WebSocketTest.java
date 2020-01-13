package com.sh.papago.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.sh.papago.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebSocketTest extends TextWebSocketHandler{
	private static List<WebSocketSession> ssList= new ArrayList<>();
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception{
		Map<String, Object> attrs = session.getAttributes();
		HttpSession hs = (HttpSession)attrs.get("session");
		UserVo uv = (UserVo) attrs.get("uv");

		String str = uv.getUiName()+"님 환영합니다";
		TextMessage tm = new TextMessage(str);
		
		if(ssList.indexOf(session)==-1) {
			ssList.add(session);
		}
		session.sendMessage(tm);
		log.info("webSession=>{}", session.getId());
		log.info("httpSession=>{}",hs.getId());
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		for(WebSocketSession wss:ssList) {
			try {
				UserVo uv = (UserVo) session.getAttributes().get("uv");
				String str = uv.getUiName() +" : "+ message.getPayload();
				TextMessage tm = new TextMessage(str);
				wss.sendMessage(tm);
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		ssList.remove(session);
		log.debug("ssList=>{}",ssList);
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		log.info("error=>{}",session);
	}
}
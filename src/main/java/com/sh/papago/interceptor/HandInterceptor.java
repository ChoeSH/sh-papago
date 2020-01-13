package com.sh.papago.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

public class HandInterceptor extends HttpSessionHandshakeInterceptor{
	@Override
	public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
		WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception{
		ServletServerHttpRequest sshr = (ServletServerHttpRequest)request;
		HttpServletRequest req = sshr.getServletRequest();
		attributes.put("session", req.getSession());
		
		return super.beforeHandshake(request, response, wsHandler, attributes);
	}
}

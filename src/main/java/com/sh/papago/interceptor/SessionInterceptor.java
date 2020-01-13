package com.sh.papago.interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.papago.service.UserService;
import com.sh.papago.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class SessionInterceptor extends HandlerInterceptorAdapter {

	@Resource
	private UserService us;
	@Value("${project.mod}")
	private String projectMod;
	
	private ObjectMapper om = new ObjectMapper();
	
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res,Object handler) throws IOException {
		String uri = req.getRequestURI();
		log.info("uri=>{}",uri);
		HttpSession hs = req.getSession();
		if(hs.getAttribute("uv")==null) {
			/*if("DEV".equals(projectMod)) {	//개발용 로그인
				UserVo uv = new UserVo();
				uv.setUiId("f123");
				uv.setUiPwd("12345");
				us.doLogin(uv, hs);
				return true;
			}*/
			String isAjax = req.getHeader("x-ajax");
			if(isAjax!=null) {
				Map<String,String> map = new HashMap<>();
				map.put("msg", "로그인 실패");
				res.setContentType("application/json;charset=utf-8");
				PrintWriter pw = res.getWriter();
				pw.write(om.writeValueAsString(map));
				return false;
			}
			res.sendRedirect("/views/error/session-error");
			return false;
		}
		return true;
	}
}

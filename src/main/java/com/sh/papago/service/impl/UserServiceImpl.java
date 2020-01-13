package com.sh.papago.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.sh.papago.dao.UserDao;
import com.sh.papago.service.UserService;
import com.sh.papago.vo.UserVo;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao udao;
	@Override
	public Map<String, Object> doLogin(UserVo uv, HttpSession hs) {
		uv=udao.doLogin(uv);
		Map<String, Object> rMap = new HashMap<>();
		if(uv==null) {
			rMap.put("msg", "아이디나 비밀번호가 올바르지 않습니다.");
		}else {
			rMap.put("msg", "로그인 성공");
			rMap.put("url", "/views/papago/main");
			rMap.put("uv", uv);
			hs.setAttribute("uv",uv);
		}
		return rMap;
	}
	@Override
	public Map<String, Object> joinUser(UserVo uv) {
		int cnt = udao.insertUser(uv);
		Map<String,Object> rMap = new HashMap<>();
		if(uv==null) {
			rMap.put("msg", "회원가입 실패");
		}else {
			rMap.put("msg", "회원가입성공");
			rMap.put("url", "/views/user/login");
			rMap.put("cnt", cnt);
			rMap.put("uv",uv);
		}
		return rMap;
	}

}

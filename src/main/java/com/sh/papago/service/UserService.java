package com.sh.papago.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.sh.papago.vo.UserVo;


public interface UserService {
	public Map<String,Object> doLogin(UserVo uv, HttpSession hs);
	public Map<String,Object> joinUser(UserVo uv);
}

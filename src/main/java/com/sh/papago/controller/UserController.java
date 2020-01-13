package com.sh.papago.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sh.papago.service.UserService;
import com.sh.papago.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class UserController {
	@Resource
	private UserService us;
	
	@PostMapping("/login")
	public Map<String,Object> doLogin(@RequestBody UserVo uv, HttpSession hs){
		log.info("session=>{}",hs);
		log.info("user=>{}",uv);
		return us.doLogin(uv, hs);
	}
	
	@PostMapping("/join")
	public Map<String,Object> join(@ModelAttribute UserVo uv){
		log.info("user=>{}",uv);
		return us.joinUser(uv);
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(@ModelAttribute UserVo uv, HttpSession hs){
		hs.removeAttribute("uv");
		log.info("uv=>{}",uv);
		ModelAndView mav = new ModelAndView("user/logout");
		mav.addObject("msg","로그아웃 되었습니다");
		return mav;
	}
	
}

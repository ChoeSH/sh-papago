package com.sh.papago.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.papago.service.PapagoService;
import com.sh.papago.vo.Message;
import com.sh.papago.vo.PapagoInfo;
import com.sh.papago.vo.Trans;
import com.sh.papago.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PapagoController {
	@Resource
	private PapagoService ps;
	
	@PostMapping("/papago")
	public Message doTranslate(@ModelAttribute Trans tr,HttpSession hs) {
		UserVo uv = (UserVo)hs.getAttribute("uv");
		tr.setUiNum(uv.getUiNum());
		log.info("tr =>{}",tr);
		return ps.doTranslate(tr);
	}
	
	@GetMapping("/papago")
	public List<PapagoInfo> getPapagoInfoList(@ModelAttribute PapagoInfo pi){
		return ps.getPapagoInfoList(pi);
	}
	
	@PostMapping("/papago/select")
	public PapagoInfo selectPapago(@ModelAttribute PapagoInfo pi) {
		return ps.selectPapago(pi);
	}
	
	@PostMapping("/papago/insert")
	public int insertPapago(@ModelAttribute PapagoInfo pi) {
		return ps.insertPapago(pi);
	}
}

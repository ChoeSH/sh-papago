package com.sh.papago.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sh.papago.service.PapagoStatsService;
import com.sh.papago.vo.PapagoStatsVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PapagoStatsController {
	@Resource
	private PapagoStatsService papagoStatsService;
	
	@GetMapping("/papago/stats")
	public Map<String,Object> getPapagoStatsList(PapagoStatsVo ps){
		return papagoStatsService.selectPapagoStats(ps);
	}
}

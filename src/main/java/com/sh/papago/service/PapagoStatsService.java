package com.sh.papago.service;

import java.util.Map;

import com.sh.papago.vo.PapagoStatsVo;

public interface PapagoStatsService {
	public Map<String,Object> selectPapagoStats(PapagoStatsVo ps);
	public Map<String,Object> insertPapagoStats(PapagoStatsVo ps);
}

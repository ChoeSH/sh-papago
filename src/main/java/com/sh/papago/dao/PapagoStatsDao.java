package com.sh.papago.dao;

import java.util.List;

import com.sh.papago.vo.PapagoStatsVo;

public interface PapagoStatsDao {
	public List<PapagoStatsVo> selectPapagoStats(PapagoStatsVo ps);
	public int insertPapagoStats(PapagoStatsVo ps);
	public Integer totalTestInfoCount(PapagoStatsVo ps);
}

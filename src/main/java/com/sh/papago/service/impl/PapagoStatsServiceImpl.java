package com.sh.papago.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.sh.papago.dao.PapagoStatsDao;
import com.sh.papago.service.PapagoStatsService;
import com.sh.papago.vo.Pagination;
import com.sh.papago.vo.PapagoStatsVo;

@Service
public class PapagoStatsServiceImpl implements PapagoStatsService {
	@Resource
	private PapagoStatsDao psdao;
	
	@Override
	public Map<String,Object> selectPapagoStats(PapagoStatsVo ps) {
		int startNum = ps.getPage().getPage() *10-10;
		ps.getPage().setStartNum(startNum);
		Integer totalCount = psdao.totalTestInfoCount(ps);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("list", psdao.selectPapagoStats(ps));
		Pagination page = ps.getPage();
		page.setTotalCount(totalCount);
		rMap.put("page", page);
		return rMap;
	}

	@Override
	public Map<String, Object> insertPapagoStats(PapagoStatsVo ps) {
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg", "입력 실패");
		int cnt = psdao.insertPapagoStats(ps);
		if(cnt==1) {
			rMap.put("msg", "입력 성공");
		}
		rMap.put("cnt", cnt);
		return null;
	}
}

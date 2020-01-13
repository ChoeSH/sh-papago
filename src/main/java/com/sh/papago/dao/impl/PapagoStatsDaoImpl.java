package com.sh.papago.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.sh.papago.dao.PapagoStatsDao;
import com.sh.papago.vo.PapagoStatsVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class PapagoStatsDaoImpl implements PapagoStatsDao {
	@Resource
	private SqlSessionFactory ssf;
	
	@Override
	public List<PapagoStatsVo> selectPapagoStats(PapagoStatsVo ps) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.selectList("com.sh.papago.dao.PapagoStatsMapper2.selectPapagoStats",ps);
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public int insertPapagoStats(PapagoStatsVo ps) {
		SqlSession ss = ssf.openSession(false);
		try {
			int cnt= ss.insert("com.sh.papago.dao.PapagoStatsMapper2.insertPapagoStats",ps);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			ss.rollback();
			log.error(e.getMessage());
		}finally {
			ss.close();
		}
		return 0;
	}

	@Override
	public Integer totalTestInfoCount(PapagoStatsVo ps) {
		SqlSession ss = ssf.openSession(false);
		try {
			int cnt= ss.selectOne("com.sh.papago.dao.PapagoStatsMapper2.totalTestInfoCount",ps);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			ss.rollback();
			log.error(e.getMessage());
		}finally {
			ss.close();
		}
		return 0;
	}
}

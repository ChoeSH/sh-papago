package com.sh.papago.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.sh.papago.dao.PapagoDao;
import com.sh.papago.vo.PapagoInfo;

@Repository
public class PapagoDaoImpl implements PapagoDao{
	
	@Resource
	private SqlSessionFactory ssf;
	
	@Override
	public List<PapagoInfo> selectPapagoInfoList(PapagoInfo pvo) {
		SqlSession ss = ssf.openSession(false);
		try {
			return ss.selectList("com.sh.papago.dao.PapagoInfoMapper2.selectPapagoInfoList");
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public PapagoInfo selectPapagoInfo(PapagoInfo pvo) {
		SqlSession ss = ssf.openSession(false);
		try {
			return ss.selectOne("com.sh.papago.dao.PapagoInfoMapper2.selectPapagoInfo", pvo);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			ss.close();
		}
		return null;
	}

	@Override
	public int insertPapagoInfo(PapagoInfo pvo) {
		SqlSession ss = ssf.openSession(false);
		try {
			int cnt= ss.insert("com.sh.papago.dao.PapagoInfoMapper2.insertPapagoInfo", pvo);
			ss.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			ss.close();	
		}
		return 0;
	}

	@Override
	public int updatePapagoInfo(PapagoInfo pvo) {
		SqlSession ss = ssf.openSession(false);
		try {
			int cnt= ss.update("com.sh.papago.dao.PapagoInfoMapper2.updatePapagoInfo", pvo);
			ss.commit();
			return cnt;
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			ss.close();	
		}
		return 0;
	}
}

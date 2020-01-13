package com.sh.papago.dao.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import com.sh.papago.dao.UserDao;
import com.sh.papago.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class UserDaoImpl implements UserDao {

	@Resource
	private SqlSessionFactory ssf;
	@Override
	public UserVo doLogin(UserVo uv) {
		SqlSession ss = ssf.openSession();
		try {
			return ss.selectOne("com.sh.papago.dao.UserInfoMapper2.doLogin", uv);
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			ss.close();
		}
		log.info("ssf=>{}",ssf);
		return null;
	}
	@Override
	public int insertUser(UserVo uv) {
		SqlSession ss = ssf.openSession();
		try {
			int cnt = ss.insert("com.sh.papago.dao.UserInfoMapper2.insertUserInfo", uv);
			ss.commit();
			return cnt;
		}catch(Exception e) {
			log.error(e.getMessage());
		}finally {
			ss.close();
		}
		
		return 0;
	}
}

/*package com.sh.papago;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sh.papago.dao.UserDao;
import com.sh.papago.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
		"file:src/main/webapp/WEB-INF/spring/root-context.xml"
	})
@Slf4j
public class UserDaoTest {
	@Resource
	private UserDao udao;
	@Test
	public void test() {
		UserVo uv = new UserVo();
		uv.setUiId("f123");
		uv.setUiPwd("12345");
		uv = udao.doLogin(uv);
		log.info("uv=>{}",uv);
		Assert.isNull(uv, "로그인이 되지 않는다.");
	}
}
*/
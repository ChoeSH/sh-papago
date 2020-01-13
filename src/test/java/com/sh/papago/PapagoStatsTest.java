/*package com.sh.papago;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sh.papago.dao.PapagoStatsDao;
import com.sh.papago.vo.PapagoStatsVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Slf4j
public class PapagoStatsTest {
	@Resource
	private PapagoStatsDao psdao;
	
	@Test
	public void test() {
		List<PapagoStatsVo> psList = psdao.selectPapagoStats(null);
		Assert.isTrue(psList.size()==0,"조회는됨");
		log.debug("psList=>{}",psList);
	}

	@Test
	public void insert() {
		PapagoStatsVo ps = new PapagoStatsVo();
		ps.setUiNum(102);
		ps.setPiNum(27);
		int cnt = psdao.insertPapagoStats(ps);
		Assert.isTrue(cnt==1,"cnt가 1이다.");
		
	}
}
*/

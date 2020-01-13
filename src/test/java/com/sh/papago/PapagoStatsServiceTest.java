/*package com.sh.papago;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sh.papago.service.PapagoStatsService;
import com.sh.papago.vo.PapagoStatsVo;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Slf4j
public class PapagoStatsServiceTest {

	@Resource
	private PapagoStatsService pss;
	@Test
	public void test() {
		insert();
		List<PapagoStatsVo> psList=select();
		Assert.isTrue(psList.size()==3, "입력과 조회 됨");
	}
	public Map<String,Object> insert(){
		PapagoStatsVo ps = new PapagoStatsVo();
		ps.setUiNum(102);
		ps.setPiNum(26);
		return pss.insertPapagoStats(ps);
	}
	public List<PapagoStatsVo> select(){
		return pss.selectPapagoStats(null);
	}
}
*/

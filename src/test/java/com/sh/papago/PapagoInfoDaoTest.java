/*package com.sh.papago;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.sh.papago.dao.PapagoDao;
import com.sh.papago.vo.PapagoInfo;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {
	"file:src/main/webapp/WEB-INF/spring/root-context.xml"
})
@Slf4j
public class PapagoInfoDaoTest {

	@Resource
	private PapagoDao pdao;
	@Test
	public void test() {
		Assert.notNull("pdao", "null이면 안됨");		//",의 뒤는 주석이다."
		List<PapagoInfo> piList = pdao.selectPapagoInfoList(null);
		Assert.isTrue(piList.size()==1,"사이즈가 1이면 안됨");
		log.debug("piList=>",piList);
	}
}
*/
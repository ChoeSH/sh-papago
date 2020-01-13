package com.sh.papago.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sh.papago.dao.PapagoDao;
import com.sh.papago.dao.PapagoStatsDao;
import com.sh.papago.service.PapagoService;
import com.sh.papago.vo.Message;
import com.sh.papago.vo.PapagoInfo;
import com.sh.papago.vo.PapagoStatsVo;
import com.sh.papago.vo.Result;
import com.sh.papago.vo.Trans;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PapagoServiceImpl implements PapagoService {
	
	@Resource
	private PapagoDao pidao;
	@Resource
	private PapagoStatsDao psdao;
	
	@Value("${client.id}")
	private String id;
	
	@Value("${client.secret}")
	private String secret;
	
	@Value("${client.api.url}")
	private String apiUrl;
	
	private ObjectMapper om = new ObjectMapper()
			.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
	@Override
	public Message doTranslate(Trans tr) {
		try {
			PapagoStatsVo ps = new PapagoStatsVo();
			ps.setUiNum(tr.getUiNum());
			PapagoInfo pi = new PapagoInfo();
			pi.setPiSource(tr.getSource());
			pi.setPiTarget(tr.getTarget());
			pi.setPiText(tr.getText());
			pi= pidao.selectPapagoInfo(pi);
			if(pi!=null) {
				Result result = new Result();
				result.setSrcLangType(pi.getPiSource());
				result.setTarLangType(pi.getPiTarget());
				result.setTranslatedText(pi.getPiResult());
				Message m = new Message();
				m.setResult(result);
				pidao.updatePapagoInfo(pi);
				ps.setPiNum(pi.getPiNum());
				psdao.insertPapagoStats(ps);
				return m;
			}
			String text=URLEncoder.encode(tr.getText(),"UTF-8");
			URL url = new URL(apiUrl);
			HttpURLConnection hc = (HttpURLConnection)url.openConnection();
			hc.setRequestMethod("POST");
			hc.setRequestProperty("content-type", "application/x-www-form-urlencoded; charset=UTF-8");
			hc.setRequestProperty("X-Naver-Client-Id", id);
			hc.setRequestProperty("X-Naver-Client-Secret", secret);
			String param = "source="+tr.getSource()+"&target="+tr.getTarget()+"&text="+text;
			hc.setDoOutput(true);
			DataOutputStream dos = new DataOutputStream(hc.getOutputStream());
			dos.writeBytes(param);
			dos.flush();
			dos.close();
			
			int status = hc.getResponseCode();
			InputStreamReader isr = new InputStreamReader(hc.getInputStream(), "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			StringBuffer res = new StringBuffer();
			String str = null;
			while((str=br.readLine())!=null) {
				res.append(str);
			}
			br.close();
			log.debug("res>{}",res);
			Trans resultTvo = om.readValue(res.toString(), Trans.class);
			Result result = resultTvo.getMessage().getResult();
			pi=new PapagoInfo();
			pi.setPiSource(result.getSrcLangType());
			pi.setPiTarget(result.getTarLangType());
			pi.setPiResult(result.getTranslatedText());
			pi.setPiText(tr.getText());
			pidao.insertPapagoInfo(pi);
			ps.setPiNum(pi.getPiNum());
			psdao.insertPapagoStats(ps);
			return resultTvo.getMessage();
			
		}catch (MalformedURLException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<PapagoInfo> getPapagoInfoList(PapagoInfo pi){
		return pidao.selectPapagoInfoList(pi);
	}

	@Override
	public PapagoInfo selectPapago(PapagoInfo pi) {	
		return pidao.selectPapagoInfo(pi);
	}
	@Override
	public int insertPapago(PapagoInfo pi) {	
		return pidao.updatePapagoInfo(pi);
	}
}

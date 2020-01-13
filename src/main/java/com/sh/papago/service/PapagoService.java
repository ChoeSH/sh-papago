package com.sh.papago.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sh.papago.vo.Message;
import com.sh.papago.vo.PapagoInfo;
import com.sh.papago.vo.Trans;

@Service
public interface PapagoService {
	public Message doTranslate(Trans tr);
	public List<PapagoInfo> getPapagoInfoList(PapagoInfo pi);
	public PapagoInfo selectPapago(PapagoInfo pi);
	public int insertPapago(PapagoInfo pi);
}

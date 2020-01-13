package com.sh.papago.dao;

import java.util.List;

import com.sh.papago.vo.PapagoInfo;

public interface PapagoDao {
	public List<PapagoInfo> selectPapagoInfoList(PapagoInfo pvo);
	public PapagoInfo selectPapagoInfo(PapagoInfo pvo);
	public int insertPapagoInfo(PapagoInfo pvo);
	public int updatePapagoInfo(PapagoInfo pvo);
}

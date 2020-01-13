package com.sh.papago.vo;

import lombok.Data;

@Data
public class PapagoStatsVo {	
	private Integer psNum;
	private Integer uiNum;
	private Integer piNum;
	private Integer credat;
	private String order;
	private String uiId;
	private Pagination page = new Pagination();
}
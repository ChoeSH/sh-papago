package com.sh.papago.vo;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class UserVo {
	private String uiName;
	private String active;
	private String uiId;
	private Integer uiNum;
	private String moddat;
	private String modtim;
	private String credat;
	private String cretim;
	private String uiPwd;
	private String[] search;
	private String searchStr;
}

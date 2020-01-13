package com.sh.papago.vo;

import lombok.Data;

@Data
public class Pagination {
	private Integer startNum=0;
	private Integer page=1;
	private Integer totalCount;
	private Integer pageSize=10;
}
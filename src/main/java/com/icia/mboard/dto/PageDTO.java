package com.icia.mboard.dto;

import lombok.Data;

@Data
public class PageDTO {
	private int page;
	private int maxPage; // 최대페이지
	private int startPage; // 시작페이지
	private int endPage; // 끝 페이지
}

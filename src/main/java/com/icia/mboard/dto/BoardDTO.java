package com.icia.mboard.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardDTO {
	private long b_number;
	private String b_title;
	private String m_id;
	private String b_contents;
	private String b_hits;
	private Date b_date;
	private MultipartFile b_file;
	private String b_filename;
}

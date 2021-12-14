package com.icia.mboard.service;

import java.util.List;

import com.icia.mboard.dto.CommentDTO;

public interface CommentService {


	void commentSave(CommentDTO comment);

	List<CommentDTO> findAll(long l);

	void delete(long b_number);

	

}

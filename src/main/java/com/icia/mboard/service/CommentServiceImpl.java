package com.icia.mboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.mboard.dto.CommentDTO;
import com.icia.mboard.repository.CommentRepository;

@Service
public class CommentServiceImpl implements CommentService {

	
	@Autowired
	private CommentRepository cr;

	// 댓글저장
	@Override
	public void commentSave(CommentDTO comment) {
		cr.commentSave(comment);
		
	}
	// 댓글목록 조회
	@Override
	public List<CommentDTO> findAll(long b_number) {
		
		return cr.findAll(b_number);
	}

	// 게시글 삭제시 댓글도 삭제
	@Override
	public void delete(long b_number) {
		cr.delete(b_number);
	}
	
	
}

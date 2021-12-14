package com.icia.mboard.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mboard.dto.CommentDTO;
@Repository
public class CommentRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	public void commentSave(CommentDTO comment) {
		sql.insert("comment.commentSave", comment);
		
	}

	public List<CommentDTO> findAll(long b_number) {
		
		return sql.selectList("comment.findAll",b_number);
	}

	public Object delete(long b_number) {
		return sql.delete("comment.delete", b_number);
	}

}

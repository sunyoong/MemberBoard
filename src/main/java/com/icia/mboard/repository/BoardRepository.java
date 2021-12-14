package com.icia.mboard.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mboard.dto.BoardDTO;
@Repository
public class BoardRepository {

	@Autowired
	private SqlSessionTemplate sql;
	
	// List<BoardDTO> 타입의 pagingList1 DB에서 가져오기.
	public List<BoardDTO> pagingList1(Map<String, Integer> pagingParam) {
		
		return sql.selectList("board.pagingList1", pagingParam);
	}

	// 전체 글개수
	public int boardCount() {
	
		return sql.selectOne("board.count");
	}

	public BoardDTO findById(long b_number) {
		return sql.selectOne("board.findById", b_number);
	}

	// 조회수
	public void hitsNo(long b_number) {
		 sql.update("board.hitsNo", b_number);
		
	}

	// 글 전체목록
	public List<BoardDTO> findAll(BoardDTO board) {
		return sql.selectList("board.findAll", board);
	}

	// 게시글 저장
	public void save(BoardDTO board) {
		sql.insert("board.save",board);
		
	}
	
		
	// 글 삭제
	public void delete(long b_number) {
		sql.delete("board.delete", b_number);
		
	}



	
	
	// 글 수정
	public void update(BoardDTO board) {
		sql.update("board.update", board);
	}


	public List<BoardDTO> search(Map<String, String> searchParam) {
		
		return sql.selectList("board.search", searchParam);
	}
	
}

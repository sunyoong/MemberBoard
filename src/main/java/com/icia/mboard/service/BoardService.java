package com.icia.mboard.service;

import java.io.IOException;
import java.util.List;

import com.icia.mboard.dto.BoardDTO;
import com.icia.mboard.dto.PageDTO;

public interface BoardService {

	PageDTO paging(int page);

	List<BoardDTO> pagingList(int page);

	BoardDTO findById(long b_number);

	void hitsNo(long b_number);

	List<BoardDTO> findAll(BoardDTO board);

	 // 게시글저장
	void save(BoardDTO board) throws IllegalStateException, IOException;


	// 게시글 삭제
	void delete(long b_number);


	List<BoardDTO> search(String searchtype, String keyword);

	void update(BoardDTO board);

	// 게시글 수정


	


}

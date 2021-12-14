package com.icia.mboard.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.icia.mboard.dto.BoardDTO;
import com.icia.mboard.dto.PageDTO;
import com.icia.mboard.repository.BoardRepository;
import com.icia.mboard.repository.MemberRepository;

@Service
public class BoardServiceImple implements BoardService {

	@Autowired
	private BoardRepository br;
	
	@Autowired
	private MemberRepository mr;
	
	// 페이징처리
	private static final int PAGE_LIMIT=5; // 글개수
	private static final int BLOCK_LIMIT=3; // 페이지개수
	
	@Override
	public List<BoardDTO> pagingList(int page) {
		// pagingList는 b_number를 기준으로. 
		// DB로 Map에 담은 pagingParam을 들고가서 DB에서 b_number로 selectList를 해서 
		// BoardDTO 형식의 pagingList에 새로 담아서 리턴함.
		int pagingStart = (page-1)*PAGE_LIMIT;
		Map<String, Integer> pagingParam = new HashMap<String, Integer>();
		pagingParam.put("start", pagingStart);
		pagingParam.put("limit", PAGE_LIMIT);
		// pagingParam에 담긴건 글이 몇갠지, 몇번부터 시작하는지.. 
		List<BoardDTO> pagingList = br.pagingList1(pagingParam);
		return pagingList;
	}
	
	// pageDTO에 전체 글개수, 최대페이지, 시작페이지, 마지막페이지 값을 계산식을 세워서 담는다.
	@Override
	public PageDTO paging(int page) {
		int boardCount = br.boardCount(); // 전체 글 조회
		int maxPage = (int)(Math.ceil((double)boardCount/PAGE_LIMIT));
		int startPage = (((int)(Math.ceil((double)page/BLOCK_LIMIT)))-1) * BLOCK_LIMIT + 1;
		int endPage = startPage + BLOCK_LIMIT - 1;
		
		if(endPage > maxPage)
			endPage = maxPage;
		PageDTO paging = new PageDTO();
		paging.setPage(page);
		paging.setMaxPage(maxPage);
		paging.setStartPage(startPage);
		paging.setEndPage(endPage);
		
		System.out.println("paging.toString() : " + paging.toString());
		
		return paging;
	}

	// 전체목록 조회
	@Override
	public List<BoardDTO> findAll(BoardDTO board) {
		List<BoardDTO> boardList = br.findAll(board);
		return boardList;
	}
	
	// 게시글 상세조회
	@Override
	public BoardDTO findById(long b_number) {
		BoardDTO board = br.findById(b_number);
		return board;
	}
	// 조회수
	@Override
	public void hitsNo(long b_number) {
		br.hitsNo(b_number);
		
	}
	// 글쓰기 저장(save)  + 파일첨부도 같이

	@Override
	public void save(BoardDTO board) throws IllegalStateException, IOException {
		MultipartFile b_file = board.getB_file();
		String b_filename = b_file.getOriginalFilename();
		b_filename = System.currentTimeMillis() + b_filename; // 구분하기 위한 현재 시간값을 붙여서 다시 b_filename으로 담는다
		String savePath = "C:\\development_psy\\source\\spring_sts\\MemberBoard\\src\\main\\webapp\\resources\\board\\upload\\" + b_filename;
		if(!b_file.isEmpty()) {
			b_file.transferTo(new File(savePath));
		}
		
		board.setB_filename(b_filename);
		br.save(board);
		
	}

	// 글 삭제(delete)
	@Override
	public void delete(long b_number) {
		br.delete(b_number);
		
		
		
		
	}
	// 글 수정(update)

	@Override
	public void update(BoardDTO board) {
		br.update(board);
		
	}

	// 검색(search)
	@Override
	public List<BoardDTO> search(String searchtype, String keyword) {
		Map<String, String> searchParam = new HashMap<String,String>();
		searchParam.put("type", searchtype);
		searchParam.put("word", keyword);
		List<BoardDTO> searchResult = br.search(searchParam);
		return searchResult;
	}



	




	






}

package com.icia.mboard.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.mboard.dto.BoardDTO;
import com.icia.mboard.dto.CommentDTO;
import com.icia.mboard.dto.PageDTO;
import com.icia.mboard.service.BoardService;
import com.icia.mboard.service.CommentService;
import com.icia.mboard.service.MemberService;

@Controller
@RequestMapping("/board/*")
public class BoardController {
	@Autowired
	private BoardService bs;
	
	@Autowired
	private MemberService ms;
	
	@Autowired
	private CommentService cs;
	
	
	// 처음화면
	@RequestMapping(value="index", method=RequestMethod.GET)
	public String index() {
		return "board/b-index";
	}
	
	// 글쓰기(save) 받아오기
	@RequestMapping(value="save", method=RequestMethod.GET)
	public String saveform(@RequestParam("m_id") String m_id, Model model) {
		String memberId = ms.memberId(m_id);
		model.addAttribute("m_id", memberId);
		System.out.println(memberId);
		return "board/b-save";
	}
	
	// 글쓰기 저장(save)
	@RequestMapping(value="save", method=RequestMethod.POST)
	public String save(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		System.out.println(board);
		bs.save(board);		
		return "redirect:/board/paging";
	}
	
	// 검색기능(search)
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(@RequestParam("searchtype") String searchtype, @RequestParam("keyword") String keyword, Model model) {
		List<BoardDTO> searchParam = bs.search(searchtype,keyword);
		model.addAttribute("boardList", searchParam);
		return "/board/b-findAll";
	}
	
	
	// 전체목록조회(findALL)
	@RequestMapping(value="findAll", method=RequestMethod.GET)
	public String findAll(@RequestParam(value="page", required=false, defaultValue="1")int page, @ModelAttribute BoardDTO board, Model model) {
		List<BoardDTO> boardList = bs.findAll(board);
		model.addAttribute("boardList", boardList);
		model.addAttribute("page", page);
		
		System.out.println("findAll에서 boardList" + boardList + "page" + page);
		
		return "board/b-findAll";
	}
	
	// 게시판 페이징처리(paging)
	@RequestMapping(value="paging", method=RequestMethod.GET)
	public String paging(@ModelAttribute BoardDTO board, @RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		PageDTO paging = bs.paging(page);
		// paging에는 시작페이지, 마지막페이지, 최대페이지, 현재페이지가 담겨있음
		List<BoardDTO> boardList = bs.pagingList(page);
		// boardList에는 한페이지에 보여지는 시작페이지~마지막페이지의 리스트들이 담겨있음
		
		 model.addAttribute("paging", paging); model.addAttribute("boardList", boardList);
		 
		// boardList에 담긴거는 pagingList(page)에서 가져온 
		//#{start}, #{limit} 값이다.
		// #{start} = 시작페이지값
		// #{limit} = 보여질 글 개수( 앞에서 변수로 설정했음.)
		// 즉, 시작페이지~한페이지에 보여지는 마지막페이지 까지의 리스트? 인것같음
		// 이 두개의 값을 jsp로 보내서 출력한다.
		System.out.println("paging에서 페이지 : " + paging + "보드리스트" + boardList);
		return "board/b-findAll";
		
		
	}
	
	
	// 상세조회(detail.jsp) 받아오기
	@RequestMapping(value="detail", method=RequestMethod.GET)
	public String detail(@RequestParam("b_number") long b_number, Model model) {
		bs.hitsNo(b_number);
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		List<CommentDTO> cList = cs.findAll(b_number);
		model.addAttribute("commentList", cList);
		
		return "board/b-detail";
	}
	
	// 글 삭제(delete) 
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String delete(@RequestParam("b_number") long b_number, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		cs.delete(b_number);
		bs.delete(b_number);
	return "redirect:/board/paging?page=" + page;
	
}
	
	// 글 수정화면 요청(update)해서 창에 띄우기
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateform(@RequestParam("b_number") long b_number, @RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		BoardDTO board = bs.findById(b_number);
		model.addAttribute("board", board);
		model.addAttribute("page", page);
		return "board/b-update";
	}
	
	// 글 수정처리(udpate)해서 다시 db로 보내기
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(@ModelAttribute BoardDTO board, @RequestParam(value="page", required=false, defaultValue="1")int page) {
		bs.update(board);
		return "redirect:/board/paging?b_number=" + board.getB_number() + "&page=" + page;
	}


	
}	


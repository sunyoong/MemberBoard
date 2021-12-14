package com.icia.mboard.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.mboard.dto.MemberDTO;
import com.icia.mboard.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {

		@Autowired
		private MemberService ms;
		

		// 처음화면 
		@RequestMapping(value="index", method=RequestMethod.GET)
		public String member(Model model) {
			List<MemberDTO> member = ms.findAll();
			model.addAttribute("member", member);
			return "member/m-index";
		}
		
		
	
		// 회원가입 (insert.jsp로 보내기)
		
		  @RequestMapping(value="save", method=RequestMethod.GET)
		  public String join() {
		  
			  return "member/m-save";
		  
		  }
		 
		// 회원가입 (m-insert에서 받아서 db에 insert, 파일첨부 포함!)
		@RequestMapping(value="save", method=RequestMethod.POST)
		public String join(@ModelAttribute MemberDTO member) {
			ms.save(member);
			return "member/m-index";
		}
		
		
		
		
		
		// 아이디 중복체크
		@RequestMapping(value="idCheck", method=RequestMethod.POST)
		public @ResponseBody String idCheck(@RequestParam("m_id") String m_id)  {
			String result = ms.idCheck(m_id);
			return result;
			
		}
		
		
		// 로그인 불러오기
		@RequestMapping(value="login", method=RequestMethod.GET)
		public String loginform() {
			return "member/m-login";
		}
		
		// 로그인 처리
		@RequestMapping(value="login", method=RequestMethod.POST)
		public String login(@ModelAttribute MemberDTO member) {
			String result = ms.login(member);
			/* model.addAttribute("m_id", member.getM_id()); */
			System.out.println("memberId :" + member.getM_id());
			return result;
}
		
		
		// 로그아웃 불러오기
		@RequestMapping(value="logout", method=RequestMethod.GET)
		public String logout(HttpSession session) {
			session.invalidate();
			return "index";
		}
		
		
		// 관리자 admin.jsp로 보내기.
		@RequestMapping(value="admin", method=RequestMethod.GET)
		public String admin() {
			return "member/m-admin";
		}
	

		
		
		
		
		
		// 회원 전체목록 조회 (findAll)
		@RequestMapping(value="findAll", method=RequestMethod.GET)
		public String findAll(Model model) {
			List<MemberDTO> memberList = ms.findAll();
			model.addAttribute("memberList", memberList);
			return "member/m-findAll";
		}
		
		// 회원 상세 조회(detail)
		@RequestMapping(value="detail", method=RequestMethod.GET)
		public String findById(@RequestParam("m_number") long m_number, Model model) {
			MemberDTO member = ms.findById(m_number);
			model.addAttribute("member", member);
			System.out.println("Controller. detail에서 member : " + member);
			return "member/m-detail";
		}
		
		// 회원삭제(delete)
		@RequestMapping(value="delete", method=RequestMethod.GET)
		public String deleteId(@RequestParam("m_number") long m_number) {
			ms.deleteId(m_number);
			return "redirect:/member/findAll";
		}
		

		// 마이페이지(mypage) - update
		@RequestMapping(value="mypage", method=RequestMethod.GET)
		public String mypage(@RequestParam("m_number") long m_number, Model model) {
			MemberDTO member= ms.findById(m_number);
			model.addAttribute("member", member);
			return "member/m-mypage"; 
		}
		
		// 마이페이지에서 수정
		
		  //기존 db에 있던 정보 불러오기
		  
		  @RequestMapping(value="updateform", method=RequestMethod.POST) 
		  public String updateform(@RequestParam("m_number") long m_number, Model model) { 
			  MemberDTO member = ms.findById(m_number); 
			  System.out.println("updateform 컨트롤러에서 member : " + member);
			  model.addAttribute("member", member);
		  return "member/m-update"; 
		  }
		 
		
		// 수정 내용 db에 보내기
		
		 @RequestMapping(value="update", method=RequestMethod.POST)
		 public String update(@ModelAttribute MemberDTO member, Model model) {
			 ms.update(member);
			 System.out.println("update컨트롤러 : " + member);
			 model.addAttribute("member", member);
			 
			 return "redirect:/member/detail?m_number=" + member.getM_number();
		 }
		
		 // 수정하기 전 비밀번호 확인
		 @RequestMapping(value="pwCheck", method=RequestMethod.GET)
		 public String pwCheck(@RequestParam("m_number")long m_number, Model model) {
			MemberDTO member = ms.findById(m_number);
			model.addAttribute("member", member);
			return "member/m-pwCheck";
		 }
		 
		 
			/*
			 * @RequestMapping(value="pwCheck2", method=RequestMethod.POST) public String
			 * pwCheck2() { return "member/m-update"; }
			 */
}

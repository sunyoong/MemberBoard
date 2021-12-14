package com.icia.mboard.service;

import java.lang.reflect.Member;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.icia.mboard.dto.MemberDTO;
import com.icia.mboard.repository.MemberRepository;

@Service
public class MemberServiceImple implements MemberService {
	
	
	
	@Autowired
	private MemberRepository mr;
	@Autowired
	private HttpSession session;
	
	
	@Override
	public void save(MemberDTO member) {
		mr.save(member);
		
	}

	// 아이디 중복체크
	@Override
	public String idCheck(String m_id) {
		String result = mr.idCheck(m_id);
		if(result == null) {
			return "o";
		}
		else {
			return "x";
		}
		
			
	}
	
	// 전체목록조회
	@Override
	public List<MemberDTO> findAll() {
		List<MemberDTO> memberList = mr.findAll();
		return memberList;
	}

	//로그인처리
	@Override
	public String login(MemberDTO member) {
		MemberDTO loginMember = mr.login(member);
		
		if(loginMember != null) {
			session.setAttribute("loginId", member.getM_id());
			session.setAttribute("loginNumber", loginMember.getM_number());
			session.setAttribute("loginMember", loginMember);
			System.out.println("회원번호" + loginMember.getM_number() + "로그인 id" + member.getM_id() + "로그인회원번호 : " + loginMember.getM_number() );
			return "member/m-index";
			
		} else {
			return "member/m-login";
		}
		
	}

	// 회원삭제
	@Override
	public void deleteId(long m_number) {
		mr.deleteId(m_number);
		
	}
	
	// 상세회원 조회(detail)
	@Override
	public MemberDTO findById(long m_number) {
		MemberDTO member = mr.findById(m_number);
		return member;
	}

	// 글쓰기에서 아이디.
	@Override
	public String memberId(String m_id) {
		return mr.memberId(m_id);



}
	// 마이페이지 내에서 정보수정(불러오기)

	
	// 비밀번호 확인(update.jsp에서)
	/*
	 * @Override public String pwCheck(MemberDTO member) { String DBpw =
	 * mr.pwCheck(member); if(DBpw!=null) { return "/member/m-update"; } else {
	 * return "/member/m-mypage"; }
	 * 
	 * }
	 */
	// 수정처리 후 db에 저장하기
	@Override
	public void update(MemberDTO member) {
		mr.update(member);
		
	}





}

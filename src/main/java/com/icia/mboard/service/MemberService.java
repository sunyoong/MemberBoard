package com.icia.mboard.service;

import java.util.List;

import org.springframework.ui.Model;

import com.icia.mboard.dto.MemberDTO;

public interface MemberService {
	// 회원가입
	void save(MemberDTO member);
	// 아이디 중복체크
	String idCheck(String m_id);
	// 회원 전체조회
	List<MemberDTO> findAll();
	// 회원삭제
	void deleteId(long m_number);
	// 상세회원조회
	MemberDTO findById(long m_number);
	// 글쓰기에서 작성자
	String memberId(String m_id);
	// 회원정보수정
	void update(MemberDTO member);
	// 로그인
	String login(MemberDTO member);




	


}

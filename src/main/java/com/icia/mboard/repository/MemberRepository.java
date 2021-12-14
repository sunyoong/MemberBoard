package com.icia.mboard.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.mboard.dto.MemberDTO;

@Repository
public class MemberRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	// 회원가입
	public void save(MemberDTO member) {
		sql.insert("member.save", member);
		
	}

	// 아이디 중복확인
	public String idCheck(String m_id) {
		return sql.selectOne("member.idCheck", m_id);
	}

	//전체목록 조회
	public List<MemberDTO> findAll() {
		return sql.selectList("member.findAll");
		
	}
	
	
	// 로그인
	public MemberDTO login(MemberDTO member) {
		return sql.selectOne("member.login", member);
	}

	// 삭제
	public void deleteId(long m_number) {
		sql.delete("member.deleteId", m_number);
	}
	
	// 상세 회원 조회
	public MemberDTO findById(long m_number) {
		return sql.selectOne("member.findById", m_number);
	}
	// 글쓰기 작성자
	public String memberId(String m_id) {
		return sql.selectOne("member.memberId", m_id);
	}

	/*
	 * public String pwCheck(MemberDTO member) { return
	 * sql.selectOne("member.pwCheck", member); }
	 */

	// 회원정보 수정
	public void update(MemberDTO member) {
		sql.update("member.update",member);
		
	}


	

	
	
	
}

package com.naver.choch92.domain;

import java.util.Map;

public interface MemberDao {
	// 아이디 중복검사를 수행해주는 메소드 - 데이터 조회
	public String idCheck(String id);
	
	// 회원가입을 처리하는 메소드 - 데이터 삽입
	public int insertMember(Member member);
	
	// 로그인을 처리하는 메소드
	// 로그인을 하려면 아이디와 비밀번호가 필요하여 매개변수가 id, pw 두개 설정
	// public Member login(String id, String pw);
	
	// 하지만 위와 같은 경우는 id, pw 순서를 알고 있어야 되서, Map을 사용해서 두개를 묶는다
	public Member login(Map<String, Object> map);
}

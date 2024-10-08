package com.yedam.service;

import java.util.List;

import com.yedam.vo.MemberVO;

public interface MemberService {
	List<MemberVO> getMembers(); // 목록
	boolean addMember(MemberVO member); // 추가
	boolean removeMember(String memberId); // 삭제
	boolean modifyMember(MemberVO member); // 수정
	MemberVO getMember(String memberId); // 단건 조회
	
	MemberVO loginCheck(String id, String pw);
}

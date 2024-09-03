package com.yedam.common;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.yedam.mapper.MemberMapper;
import com.yedam.vo.MemberVO;

public class AppTest {
	public static void main(String[] args) {
		MemberVO mvo = new MemberVO();
		mvo.setMemberId("user05");
		mvo.setMemberName("alice");
		mvo.setPassword("1111");
		mvo.setEmail("alice@google.com");

		SqlSessionFactory factory = DataSource.getInstance();
		SqlSession session = factory.openSession();
		MemberMapper mapper = session.getMapper(MemberMapper.class);
		
		if(mapper.insertMember(mvo) == 1) {
			session.commit();
		}
		
		List<MemberVO> list = mapper.memberList();
		list.forEach(member -> {
			System.out.println(member.toString());
		});
	}
}

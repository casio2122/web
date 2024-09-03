package com.yedam.vo;

import java.util.Date;

import lombok.Data;

// lombok library : getter, setter, toString 메소드 생성
// lombok 설치, 관련 라이브러리 pom 위치에 추가

@Data // getter, setter, toString 등 전부 생성

public class MemberVO {
	private String memberId;
	private String memberName;
	private String password;
	private String email;
	private String authority;
	private Date creationDate;
}

package com.yedam.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class AddMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		
		String id = request.getParameter("id"); // 사용자의 요청정보중에서 id 값을 읽도록 함
		String name = request.getParameter("name");
		String pw = request.getParameter("pass");
		String mail = request.getParameter("email");

		MemberVO mvo = new MemberVO();
		mvo.setMemberId(id);
		mvo.setMemberName(name);
		mvo.setPassword(pw);
		mvo.setEmail(mail);

		MemberService svc = new MemberServiceImpl();
		// 회원 등록이 정상적일 경우 -> 회원 목록 페이지 출력
		// 회원 등록이 비정상적일 경우 -> 회원 등록 페이지 이동 (메세지 전달)
		// 현재 페이지 : addMember.do -> 페이지 재지정 방식 1) forwarding : 파라미터 전달 2) redirect : 파라미터 전달 불가

		if (svc.addMember(mvo)) {
			// PrintWriter out = response.getWriter(); // 출력스트림을 반환
			// out.print("등록됨"); // 웹브라우저에 전달
			response.sendRedirect("memberList.do");
		} else {
			request.setAttribute("message", "등록중 오류가 발생했습니다.");
			request.getRequestDispatcher("WEB-INF/html/addForm.jsp").forward(request, response);
		}
	}

}

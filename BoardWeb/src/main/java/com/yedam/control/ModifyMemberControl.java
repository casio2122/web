package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class ModifyMemberControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터 4개 값을 읽어서 db 반영 -> 목록으로 이동
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

		if (svc.modifyMember(mvo)) {
			response.sendRedirect("memberList.do");
		} else {
			request.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(request, response);
		}
	}

}

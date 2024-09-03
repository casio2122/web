package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class ModifyFormControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 아이디 파라미터 : id
		String id = request.getParameter("id");
				
		// 조회한 정보를 jsp 페이지에 전달
		MemberService svc = new MemberServiceImpl();
		MemberVO mvo = svc.getMember(id);
				
		request.setAttribute("memberInfo", mvo);
				
		request.getRequestDispatcher("WEB-INF/html/modifyForm.jsp").forward(request, response);
	}

}

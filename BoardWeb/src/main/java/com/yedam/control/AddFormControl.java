package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class AddFormControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// addForm.do 요청 -> 요청 재지정(WEB-INF/html/addForm.jsp)
		request.setAttribute("msg", "Message");
		request.getRequestDispatcher("WEB-INF/html/addForm.jsp").forward(request, response);
		
		// 커밋테스트 수정

	}

}

package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class ModifyBoardControl implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		String title = request.getParameter("title"); 
		String content = request.getParameter("content");
		String bno = request.getParameter("bno");
		String page = request.getParameter("page");

		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);

		BoardService bvc = new BoardServiceImpl();
		request.setAttribute("board", bvo);
		request.setAttribute("page", page);

		if (bvc.modifyBoard(bvo)) {
			response.sendRedirect("boardList.do");
		} else {
			request.getRequestDispatcher("WEB-INF/board/modifyBoard.jsp").forward(request, response);
		}

	}

}

package com.yedam.web;

import java.util.HashMap;
import java.util.Map;

import com.yedam.common.Control;
import com.yedam.control.AddBoardControl;
import com.yedam.control.BoardFormControl;
import com.yedam.control.BoardListControl;
import com.yedam.control.GetBoardControl;
import com.yedam.control.ModifyBoardControl;
import com.yedam.control.RemoveControl;

// 게시글 관련 메뉴와 컨트롤 등록, 팀원 1
public class MenuBoard {
	
	private static MenuBoard instance = new MenuBoard();
	
	private MenuBoard() {}
	
	public static MenuBoard getInstance() {
		return instance;
	}
	
	public Map<String, Control> menuMap(){
		Map<String, Control> menu = new HashMap<>();
		
		// 기능 등록
		menu.put("/boardList.do", new BoardListControl());
		
		// 단건 조회
		menu.put("/getBoard.do", new GetBoardControl());
		
		// 게시물 수정
		menu.put("/modifyBoard.do", new ModifyBoardControl());
		menu.put("/removeBoard.do", new RemoveControl());
		
		// 등록
		menu.put("/addBoardForm.do", new BoardFormControl());
		menu.put("/addBoard.do", new AddBoardControl());
		
		return menu;
	}

}

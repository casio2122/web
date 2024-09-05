<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>
<h3>게시물 수정</h3>
<%
	BoardVO board = (BoardVO) request.getAttribute("board");
%>
<form action="boardList.do">
	<input type="hidden" name="id" value="<%=board.getBoardNo()%>">
	<table class="table">
		<tr>
			<th>글번호</th><td><%=board.getBoardNo()%></td>
		</tr>
		
		<tr>
			<th>제목</th><td><input class="form-control" type="text" name="title" value="<%=board.getTitle()%>"><%=board.getTitle()%></td>
		</tr>
		<tr>
			<th>작성자</th><td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일시</th><td><%=board.getCreationDate()%></td>
		</tr>
		<tr>
			<th>내용</th><td><input class="form-control" type="text" name="content" value="<%=board.getContent()%>"><%=board.getContent()%></td>
		</tr>
		<tr>
			<td colspan="3">
				<button class="btn btn-info"
					onclick="location.href='boardList.do?page=<%=request.getAttribute("page")%>'">목록으로</button>
				<button class="btn btn-info"
					onclick="location.href='modifyBoard.do?id=<%=board.getBoardNo()%>'">수정</button>
				<button class="btn btn-danger"
					onclick="location.href='removeBoard.do?id=<%=board.getBoardNo()%>'">삭제</button>
		</tr>
	</table>
</form>
<jsp:include page="../includes/footer.jsp"></jsp:include>
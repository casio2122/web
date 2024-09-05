<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>글 상세 페이지</h3>
<p>searchCondition : ${sc}, keyword : ${kw}</p>

<%
BoardVO board = (BoardVO) request.getAttribute("board");
%>

<form action="removeBoard.do" name="actForm">
	<input type="hidden" name="keyword" value="${kw}">
	<input type="hidden" name="searchCondition" value="${sc}">
	<input type="hidden" name="page" value="${page}">
	<input type="hidden" name="bno" value="${board.boardNo}">
</form>

<script>
	// 매개값으로 이동할 컨트롤을 받아서 파라미터를 전달하는 함수
	function form_submit(uri) {
		document.forms.actForm.action = uri;
		document.forms.actForm.submit();
	}
</script>

<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<td><%=board.getBoardNo()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><b><%=board.getTitle()%></b></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td><%=board.getWriter()%></td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td><%=board.getCreationDate()%></td>
		</tr>
		<tr>
			
		</tr>
	</thead>
	<tbody>
		<tr>
			<th>내용</th>
			<td><%=board.getContent()%></td>
		</tr>
		<tr>
			<td colspan="3">
			<c:if test="${!empty board.image}">
				<img width="200px" src="images/${board.image}">
			</c:if>
			</td>
		</tr>
		<tr>
			<td colspan="3">
				<a class="btn btn-info"
					onclick="form_submit('boardList.do')">목록으로</a>
				<a class="btn btn-info ${board.writer ne logid ? 'disabled' : ''}"
					onclick="form_submit('modifyBoard.do')">수정</a>
				<a class="btn btn-danger"
					onclick="form_submit('removeBoard.do')">삭제</a>
				<c:if test="${!empty message}">
					<span style="color : red;">${message}</span>
				</c:if>
			</td>
		</tr>
		
	</tbody>
</table>



<jsp:include page="../includes/footer.jsp"></jsp:include>
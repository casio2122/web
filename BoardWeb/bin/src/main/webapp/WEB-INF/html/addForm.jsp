<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp"></jsp:include>

	<%
	String message = (String) request.getAttribute("message");
	%>
	<%if (message != null) {%>
	<p style="color : red;"><%=message %></p>
	<%} %>
	<form action="addMember.do" method="post">
	<%// post 메소드는 주소창에 정보가 표시되지 않도록 함, post 방식은 한글이 기입되지 않음%>
	<table class="table">
		<tr><th>회원아이디:</th> <td><input class="form-control" type="text" name="id"></td> 
		<tr><th>회원이름:</th> <td><input class="form-control" type="text" name="name"></td> 
		<tr><th>비밀번호:</th> <td><input class="form-control" type="password" name="pass"></td>
		<tr><th>이메일:</th> <td><input class="form-control" type="email" name="email"></td>
		<tr><td colspan="2" align="center">
			<input class="col-sm-3 btn btn-primary" type="submit">
			<input class="col-sm-3 btn btn-danger" type="reset">
		</td></tr>
	</table>
	</form>
	
<jsp:include page="../includes/footer.jsp"></jsp:include>
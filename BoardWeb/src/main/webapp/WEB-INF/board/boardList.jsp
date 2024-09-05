<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<jsp:include page="../includes/header.jsp"></jsp:include>

<h3>게시글 목록</h3>
<div class="center">
	<form action="boardList.do">
		<div class="row">
			<div class="col-sm-4">
				<select name="searchCondition" class="form-control">
					<option value="">선택하세요</option>
					<option value="T" ${sc eq 'T' ? 'selected' : ''}>제목</option>
					<option value="W" ${sc eq 'W' ? 'selected' : ''}>작성자</option>
					<option value="TW" ${sc eq 'TW' ? 'selected' : ''}>제목 & 작성자</option>
				</select>
			</div>
			<div class="col-sm-5">
				<input type="text" name="keyword" value="${kw}" class="form-control">
			</div>
			<div class="col-sm-2">
				<input type="submit" value="조회" class="btn btn-primary">
			</div>
		</div>
	</form>
</div>

<c:choose>
	<c:when test="${!empty message}">
		<p>${message}</p>
	</c:when>
	<c:otherwise>
		<table class="table">
			<thead>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일시</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="board" items="${list}">
					<tr>
						<td><c:out value="${board.boardNo}" /></td>
						<td><a
							href="getBoard.do?keyword=${kw}&searchCondition=${sc}&page=${paging.page}&bno=${board.boardNo}">${board.title}</a></td>
						<td>${board.writer}</td>
						<td><fmt:formatDate value="${board.creationDate}"
								pattern="yyyy.MM.dd HH:mm:ss" /></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<nav aria-label="...">
			<ul class="pagination">
				<li class="page-item ${paging.prev ? '' : 'disabled'}"><a
					class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${paging.startPage - 1}">Previous</a>
				</li>
				<c:forEach var="pg" begin="${paging.startPage}"
					end="${paging.endPage}">
					<c:choose>
						<c:when test="${paging.page == pg}">
							<li class="page-item active" aria-current="page"><a
								class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${pg}">${pg}</a></li>
						</c:when>
						<c:otherwise>
							<li class="page-item"><a class="page-link"
								href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${pg}">${pg}</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
				<li class="page-item ${paging.next ? '' : 'disabled'}"><a
					class="page-link" href="boardList.do?keyword=${kw}&searchCondition=${sc}&page=${paging.endPage + 1}">Next</a>
				</li>
			</ul>
		</nav>
	</c:otherwise>
</c:choose>

<jsp:include page="../includes/footer.jsp"></jsp:include>
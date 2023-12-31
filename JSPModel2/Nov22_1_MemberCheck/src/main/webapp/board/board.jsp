<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board/board.jsp</title>
</head>
<body>
	<%--
		 게시글 작성 부분
		 BoardWriteController get방식
		 1.로그인이 되어야 글을 쓸수잇도록
		 2.글쓸수잇는 부분이 보여야 + 버튼 <->controller 
	--%>
	<c:if test="${sessionScope.loginMember != null }">
		<form action="BoardWriteController">
			<table id="writeBoardTbl" border="1">
				<tr>
					<td>
						<input name="token" value="${generatedToken }" type="hidden">
						<textarea placeholder="작성" class="writeArea" autocomplete="off"
						 autofocus="autofocus"	maxlength="200" name="b_text">
						 </textarea>
					</td>
					<td>
						<button>등록</button>
					</td>
				</tr>
			</table>
		</form>
	</c:if>
	<form action="BoardSearchController">
		<table id="searchTbl">
			<tr>
				<td><input autocomplete="off" name="search" id="searchinput"></td>
				<td><button>검색</button></td>
			</tr>
		</table>
	</form>
	
 	<%--페이지처리 --%>
 	<c:if test="${pageNo != 1 }">
 		<a href="BoardPageController?p=${pageNo-1 }" id="boardL">&lt;</a>
 	</c:if>
 	<c:if test="${pageNo != pageCount }">
 		<a href="BoardPageController?p=${pageNo+1 }" id="boardR">&gt;</a>
 	</c:if>
 	
	<%-- 게시글 출력 부분 --%>
	<c:forEach var="board" items="${boards }">
		<table class="boardContentTbl">
		
		<form action="BoardUpdateController" method="post">
			<tr>
				<td valign="top" align="center" rowspan="3" class="boardPhoto">
					<img src="img/${board.m_photo }">
				</td>
				<td class="boardWriter"> -${board.b_writer }-</td>
			</tr>
			<tr>
				<td align="center" class="boardWhen">
					<%--input의 타입이 hidden이면 맵에서는 안보이나 내부적으로는 정보전달 가능 --%>
					<input name="b_no" value="${board.b_no }" type="hidden"><p>
					<fmt:formatDate value="${board.b_when }" type="both"
					 dateStyle="long" timeStyle="short" />
				</td>
			</tr>
			<tr>
				<td class="boardText"><textarea name="b_text">${board.b_text }</textarea></td>
			</tr>
			<c:if test="${board.b_writer == sessionScope.loginMember.m_id }">
			<tr>
				<td align="right" colspan="2">
					<button onclick="boardUpdate(${board.b_no});">수정</button>
		</form>
					<button onclick="boardDelete(${board.b_no});">삭제</button>
				</td>
			</tr>
			</c:if>
		</table>
	</c:forEach>

</body>
</html>
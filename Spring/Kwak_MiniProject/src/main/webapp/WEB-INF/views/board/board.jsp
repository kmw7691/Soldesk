<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board.jsp</title>
</head>
<body>
	<c:if test="${curPage != 1 }">
		<table id="snsL">
			<tr>
				<td align="center" onclick="snsPageChange(${curPage-1})">&lt;</td>
			</tr>
		</table>
	</c:if>
	
	<c:if test="${curPage != allPageCount }">
		<table id="snsR">
			<tr>
				<td align="center" onclick="snsPageChange(${curPage + 1 });">&gt;</td>
			</tr>
		</table>
	</c:if>
	
	<c:if test="${sessionScope.loginMember != null }">
		<table id="snsWriteArea">
			<tr>
				<td>
					<form action="board.search" name="snsSearchForm"
						onsubmit="return snsSearchCheck();" method="post">
						<table id="snsSearchTable">
							<tr>
								<td id="sstTd1"><input name="search" maxlength="10"
									autocomplete="off" placeholder="게시글 찾기"></td>
								<td id="sstTd2"><input type="image"
									src="resources/img/search.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
					<td id="snsWriteAreaSummoner" align="center" rowspan="2"
					style="background-color: #F44336; border-radius: 0px 20px 20px 0px; cursor: pointer;">
					<img src="resources/img/menu.png"></td>
			</tr>
			<tr>
				<td align="center">
					<form action="board.write" name="snsWriteForm"
						onsubmit="return snsWriteCheck();" method="post">
						<input name="token" value="${token }" type="hidden">
						<table id="snsWriteTable">
							<tr>
								<td id="swtTd1"><textarea name="s_text" placeholder="게시글 쓰기"
										maxlength="250"></textarea></td>
								<td id="swtTd2"><input type="image"
									src="resources/img/write.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</c:if>
	
	
	<c:forEach var="sm" items="${msgs }">
		<table class="sm">
			<tr>
				<td rowspan="5" align="center" valign="top" style="width: 95px;">
					<img class="smPhoto" src="resources/img/${sm.photo }">
				</td>
				<td class="smOwner">${sm.id }</td>
			</tr>
			<tr>
				<td class="smDate" align="right"><fmt:formatDate
						value="${sm.s_when }" type="both" dateStyle="long"
						timeStyle="short" /></td>
			</tr>
			<tr>
				<td class="smTxt"><textarea id="formerTxt">${sm.s_text }</textarea></td>
			</tr>
			<tr>
				<td id="smReplyArea"><c:forEach var="sr"
						items="${sm.s_replys }">
						<c:choose>
							<c:when test="${sr.sr_writer == sessionScope.loginMember.id }">
								<span ondblclick="snsReplyDelete('${sr.sr_no}');"
									class="smReplyID">${sr.sr_writer }</span>
							</c:when>
							<c:otherwise>
								<span class="smReplyID">${sr.sr_writer }</span>
							</c:otherwise>
						</c:choose>
						${sr.sr_text }(<fmt:formatDate value="${sr.sr_when }" type="both"
							dateStyle="short" timeStyle="short" />)<br>
					</c:forEach> <c:if test="${sessionScope.loginMember != null }">
						<hr>
						<form action="board.reply.write" method="post"
							onsubmit="return snsReplyWriteCheck(this);">
							<input name="token" value="${token }" type="hidden"> <input
								name="sr_s_no" value="${sm.s_no }" type="hidden"> <span
								class="smReplyID">${sessionScope.loginMember.id }</span>
							<input name="sr_text"
								maxlength="100"
								placeholder="댓" autocomplete="off">
							<button style="font-weight:900;">쓰기</button>
						</form>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><c:if
						test="${sm.id == sessionScope.loginMember.id }">
						<button onclick="snsMsgUpdate(${sm.s_no}, '${sm.s_text }');"
							 id="updateBtn">수정</button>
						<button onclick="snsMsgDelete(${sm.s_no});">삭제</button>
					</c:if></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${curPage != 1 }">
		<table id="snsL">
			<tr>
				<td align="center" onclick="snsPageChange(${curPage - 1 });">&lt;</td>
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
					<form action="sns.search" name="snsSearchForm"
						onsubmit="return snsSearchCheck();" method="post">
						<table id="snsSearchTable">
							<tr>
								<td id="sstTd1"><input name="search" maxlength="10"
									autocomplete="off" placeholder="찾기"></td>
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
					<form action="sns.write" name="snsWriteForm"
						onsubmit="return snsWriteCheck();" method="post">
						<input name="token" value="${token }" type="hidden">
						<table id="snsWriteTable">
							<tr>
								<td id="swtTd1"><textarea name="c_txt" placeholder="뭐"
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
		<table class="sm" style="box-shadow: 5px 5px 5px ${sm.c_color};">
			<tr>
				<td rowspan="5" align="center" valign="top" style="width: 95px;">
					<img class="smPhoto" src="resources/img/${sm.c_photo }"
					style="box-shadow: 3px 3px 3px ${sm.c_color};">
				</td>
				<td class="smOwner" style="color: ${sm.c_color};">${sm.c_id }</td>
			</tr>
			<tr>
				<td class="smDate" align="right"><fmt:formatDate
						value="${sm.c_when }" type="both" dateStyle="long"
						timeStyle="short" /></td>
			</tr>
			<tr>
				<td class="smTxt"><textarea id="formerTxt">${sm.c_txt }</textarea></td>
			</tr>
			<tr>
				<td id="smReplyArea"><c:forEach var="sr"
						items="${sm.c_replys }">
						<c:choose>
							<c:when test="${sr.cr_owner == sessionScope.loginMember.c_id }">
								<span ondblclick="snsReplyDelete('${sr.cr_no}');"
									class="smReplyID" style="color:${sm.c_color}; cursor:pointer;">${sr.cr_owner }</span>
							</c:when>
							<c:otherwise>
								<span class="smReplyID" style="color:${sm.c_color}">${sr.cr_owner }</span>
							</c:otherwise>
						</c:choose>
						${sr.cr_txt }(<fmt:formatDate value="${sr.cr_when }" type="both"
							dateStyle="short" timeStyle="short" />)<br>
					</c:forEach> <c:if test="${sessionScope.loginMember != null }">
						<hr color="${sm.c_color }">
						<form action="sns.reply.write" method="post"
							onsubmit="return snsReplyWriteCheck(this);">
							<input name="token" value="${token }" type="hidden"> <input
								name="cr_c_no" value="${sm.c_no }" type="hidden"> <span
								class="smReplyID" style="color:${sm.c_color}">${sessionScope.loginMember.c_id }</span>
							<input name="cr_txt"
								style="border-bottom:${sm.c_color} solid 2px;" maxlength="100"
								placeholder="댓" autocomplete="off">
							<button style="color: ${sm.c_color}; font-weight:900;">쓰기</button>
						</form>
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><c:if
						test="${sm.c_id == sessionScope.loginMember.c_id }">
						<button onclick="snsMsgUpdate(${sm.c_no}, '${sm.c_txt }');"
							style="color: ${sm.c_color};" id="updateBtn">수정</button>
						<button onclick="snsMsgDelete(${sm.c_no});"
							style="color: ${sm.c_color};">삭제</button>
					</c:if></td>
			</tr>
		</table>
	</c:forEach>
</body>
</html>
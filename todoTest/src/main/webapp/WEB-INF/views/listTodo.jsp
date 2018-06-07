<%@page import="org.webapp.dao.TodoDAOImpl"%>
<%@page import="org.webapp.dao.TodoService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	TodoService service = new TodoDAOImpl();
	String id = (String) session.getAttribute("user_id");
%>
<body>
	<jsp:include page="/link.html" flush="false" />
	<br>
	<div>${error }</div>
	<c:if test="${!empty list }">
		<table>
			<tr>
				<th>할 일</th>
				<th>목표 날짜</th>
				<th>생성 날짜</th>
				<th>해결 여부</th>
				<th>카테고리</th>
				<th>삭제하기</th>
				<th>수정하기</th>
			</tr>
			<c:forEach var="list" items="${list}">
				<tr>
					<td>${list.content}</td>
					<td>${list.targetDate}</td>
					<td>${list.createDate}</td>
					<td>${list.done}</td>
					<td>${list.ctgName}</td>
					<td>삭제하기</td>
					<td>수정하기</td>
				</tr>
			</c:forEach>
		</table>
		<div></div>
	</c:if>
	<c:if test="${empty list }">
		<p>일정이 없습니다.</p>
	</c:if>
</body>
</html>
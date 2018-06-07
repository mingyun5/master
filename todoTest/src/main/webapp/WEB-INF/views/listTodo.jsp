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
<% TodoService service = new TodoDAOImpl();
 	String id = (String)session.getAttribute("user_id");
 %>
</head>
<jsp:include page="/link.html" flush="false"/>
<body>
	<c:if test="${!empty list }">
	<table>
		<tr>
			<th>할 일</th>
			<th>목표 날짜</th>
			<th>생성 날짜</th>
			<th>해결 여부</th>
			<th>카테고리</th>
			<th colspan="2">삭제하기</th>
			<th colspan="2">수정하기</th>
		</tr>
		<c:forEach var="todoList" items="${list}" >
     	<tr>
     		<th>${todoList.content }</th>
     		<td>${todoList.targetDate }</td>
     		<td>${todoList.createDate }</td>
     		<td>${todoList.done }</td>
     		<td>${todoList.ctgName }</td>
     		<td colspan="2"><a href="/deleteServlet2?idx=${t.idx }&page=${page}" onclick="return check()">삭제하기</a></td>
 			<td colspan="2"><a href="/updateServlet?idx=${t.idx }">수정하기</a></td>
     	</tr>
  		</c:forEach>
	</table>
	<div>
		<% 
		int a=Integer.parseInt(request.getParameter("page"));
		int pagestart=1+((a-1)/10)*10;
		if(pagestart!=1){%>
		<a href="/listTodoServlet?page=<%=pagestart-1%>">&lt;</a>
		<%}
		for(int i=pagestart;i<pagestart+10&&i<=service.maxpage(id);i++){ %>
		   <a href="/listTodoServlet?page=<%=i%>" class="pageidx"><%=i%></a>
		<%} 
		if(pagestart+10<service.maxpage(id)){%>
		<a href="/listTodoServlet?page=<%=pagestart+10%>">&gt;</a>
		<%} %>
	</div>
	</c:if>
	<c:if test="${empty list }">
		<p>일정이 없습니다</p>
	</c:if>
</body>
</html>
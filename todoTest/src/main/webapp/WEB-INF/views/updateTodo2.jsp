<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="/link.html" flush="false" />
	<br>
	<div>${error }</div>
	<table>
		<thead>
			<tr>
				<th colspan="2">일정수정</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>할일</th>
				<td>${modifyTodo.content }</td>
			</tr>
			<tr>
				<th>목표 날짜</th>
				<td>${modifyTodo.targetDate }</td>
			</tr>
			<tr>
				<th>카테고리:</th>
				<td>${modifyTodo.ctgName }</td>
			</tr>
			<tr>
				<th>해결 여부</th>
				<td>${modifyTodo.done }</td>
			</tr>
		</tbody>
	</table>
	</form>
</body>
</html>
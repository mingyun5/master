<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="link.html" flush="false"/>
	<form action="/joinServlet" method="post">
		<thead>
			<tr>
				<th colspan="2">회원가입</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>아이디</th>
				<td>
					<input type="text" name="id" />
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<th>이름</th>
				<td>
					<input type="text" name="name">
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<input type="submit" value="가입">
					<input type="reset" value="취소">
				</td>
			</tr>
		</tfoot>
	</form>
</body>
</html>
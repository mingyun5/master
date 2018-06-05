<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="/link.html" flush="false"/>
<br>
	<form action="/loginServlet" method="POST">
		<table>
			<tr>
				<th>ID : </th>
				<td>
					<input type="text" name="id" />
				</td>
			</tr>
			<tr>
				<th>PW : </th>
				<td>
					<input type="password" name="password"/>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit"/>
				</td>
			</tr>
		</table>
	</form>
	<div>
		${error }
	</div>
</body>
</html>
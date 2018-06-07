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
<div>
	${error }
</div>
<form action="addTodoServlet" method="post">
	<table>
		<thead>
			<tr>
				<th colspan="2">일정 추가</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>할일</th>
				<td>
					<input type="text" name="content" id="content"/>
				</td>
			</tr>
			<tr>
				<th>목표 날짜</th>
				<td>
					<input type="date" name="date" id="date"/>
				</td>
			</tr>
			<tr>
				<th>카테고리:</th>
				<td>
					<select name="category" >
						<option value="1">공부</option>
						<option value="2">운동</option>
						<option value="3">약속</option>
						<option value="4">test</option>
					</select>
				</td>
			</tr>
		</tbody>
		<tfoot>
			<tr>
				<td>
					<input type="submit" value="등록"/>
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</tfoot>
	</table>
</form>
</body>
</html>
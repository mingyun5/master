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
<form action="UpdateTodoServlet" method="post">
	<input type="hidden" name="idx" value="${modify.idx }"/>
	<table>
		<thead>
			<tr>
				<th colspan="2">일정수정</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>할일</th>
				<td>
					<input type="text" name="content" id="content" value="${modify.content }"/>
				</td>
			</tr>
			<tr>
				<th>목표 날짜</th>
				<td>
					<input type="date" name="date" id="date" value="${modify.targetDate }"/>
				</td>
			</tr>
			<tr>
				<th>카테고리:</th>
				<td>
					<select name="category" id="category">
						<option value="1">공부</option>
						<option value="2">운동</option>
						<option value="3">약속</option>
						<option value="4">test</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>해결 여부</th>
				<td>
					<input type="radio" name="done" value="true" id="rad1"><label for="rad1">O</label>&nbsp;
					<input type="radio" name="done" value="false" id="rad2"><label for="rad2">X</label>
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
	<script>
	$("#category").val("${modify.category}").prop("selected", true);
	$('input:radio[name="done"][value="${modify.done}"]').prop('checked', true);
	</script>
</body>
</html>
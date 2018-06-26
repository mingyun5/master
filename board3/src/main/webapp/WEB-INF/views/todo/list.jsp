<%@ page language="java" contentType="text/html;charset=UTF-8" 
		pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf" %>
<%@ include file="../common/navigation.jspf" %>
<h3>리스트</h3>
<table class="table table-striped">
	<tr>
		<th>BNO</th>
		<th>TITLE</th>
		<th>REGDATE</th>
		<th>TARGETDATE</th>
	</tr>
	<c:forEach items="${list }" var="todoVO">
		<tr>
			<td>${todoVO.bno }</td>
			<td>
				<a href="/todo/read?bno=${todoVO.bno }">${todoVO.title }</a>
			</td>
			<td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${todoVO.createDate }" /></td>
			<td>${todoVO.targetDate }</td>
		</tr>	
	</c:forEach>
	<tr>
		<td colspan="4">
			<button type="submit" class="btn btn-primary">add todo</button>
		</td>
	</tr>
</table>


<%@ include file="../common/footer.jspf" %>


<script>
	$(document).ready(function(){
		$(".btn-primary").on('click',function(){
			self.location="/todo/register";
		})
	})
</script>

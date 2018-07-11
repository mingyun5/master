<%@ page language="java" contentType="text/html;charset=UTF-8" 
		pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../common/header.jspf" %>
<h3>리스트</h3>
<form id="jobForm">
	<input type='hidden' name="page" value=${pageMaker.cri.page }>
	<input type='hidden' name="perPageNum" value=${pageMaker.cri.perPageNum }>
</form>

<table class="table table-striped">
	<tr>
		<th>BNO</th>
		<th>TITLE</th>
		<th>REGDATE</th>
		<th>TARGETDATE</th>
		<th>result</th>
	</tr>
	<c:forEach items="${list }" var="todoVO">
		<tr>
			<td>${todoVO.bno }</td>
			<td>
				<a href='/todo/read?bno=${todoVO.bno}&page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}'>${todoVO.title }</a>
			</td>
			<td><fmt:formatDate pattern="yy-MM-dd HH:mm" value="${todoVO.create_date }" /></td>
			<td>${todoVO.target_date}</td>
			<td>${todoVO.done }</td>
		</tr>	
	</c:forEach>
	<tr>
		<td colspan="5">
			<button type="submit" class="btn btn-primary">add todo</button>
		</td>
	</tr>
</table>


<div class="text-center">
	<ul class="pagination">
		
		<c:if test="${pageMaker.prev }">
			<li><a href="listPage?page=${pageMaker.startPage -1 }">&laquo;</a></li>
		</c:if>
		
		<c:forEach begin="${pageMaker.startPage  }"
			end="${pageMaker.endPage }" var="idx">
			<li
				<c:out value="${pageMaker.cri.page == idx?'class = active' : '' }"/>>
				<a href="listPage?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a>
			</li>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
			<li><a href="listPage?page=${pageMaker.endPage + 1 }">&raquo;</a></li>
		</c:if>
		
	</ul>
</div>

<%@ include file="../common/footer.jspf" %>


<script>
	$(document).ready(function(){
		$(".btn-primary").on('click',function(){
			self.location="/todo/register";
		})
	})
</script>

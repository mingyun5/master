<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../common/header.jspf"%>
<style>
.table{width: 100%}
th, td{ text-align: left; padding: 10px 0;border-top: 1px solid #eee}
</style>
<!-- Content-->
<div class="wil-content">
	<!-- Section -->
	<section class="awe-section">
		<div class="container">

			<!-- page-title -->
			<div class="page-title pb-40">
				<h2 class="page-title__title">Todo List</h2>
				<p class="page-title__text">Sed ante nisl, fermentum et
					facilisis in</p>
				<div class="page-title__divider"></div>
			</div>
			<!-- End / page-title -->

		</div>
	</section>
	<!-- End / Section -->


	<!-- Section -->
	<section class="awe-section bg-gray">
		<div class="container">
			<div class="row">
				<form id="jobForm">
					<input type='hidden' name="page" value=${pageMaker.cri.page }>
					<input type='hidden' name="perPageNum"
						value=${pageMaker.cri.perPageNum }>
				</form>

				<table class="table table-striped">
					<tr>
						<th style="width: 10px">BNO</th>
						<th>TITLE</th>
						<th>WRITER</th>
						<th>REGDATE</th>
						<th style="width: 40px">VIEWCNT</th>
					</tr>
					<c:forEach items="${list }" var="boardVO">
						<tr>
							<td>${boardVO.bno }</td>
							<td><a
								href='/board/read?bno=${boardVO.bno}&page=${pageMaker.cri.page}&perPageNum=${pageMaker.cri.perPageNum}'>${boardVO.title }</a></td>
							<td>${boardVO.writer }</td>
							<%-- <td><fmt:formatDate pattern="yy-MM-dd HH:mm"
									value="${boardVO.regdate }" /></td> --%>
							<td>${boardVO.regdate }</td>
							<td>${boardVO.viewcnt }</td>
						</tr>
					</c:forEach>
					<tr>
						<td colspan="5">
							<button type="submit" class="btn btn-primary">add</button>
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
								<a
								href="listPage?page=${idx}&perPageNum=${pageMaker.cri.perPageNum}">${idx}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0 }">
							<li><a href="listPage?page=${pageMaker.endPage + 1 }">&raquo;</a></li>
						</c:if>

					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- End / Section -->

</div>
<!-- End / Content-->



<%@ include file="../common/footer.jspf"%>

<script>
	var result = '${result}';

	if (result == 'success') {
		alert("처리가 완료되었습니다.")
	}
	
	$(document).ready(function() {
		$(".btn-primary").on('click', function() {
			self.location = "/board/register";
		})
	})
	// 	$(".pagination li a").on("click", function(event) {
	// 		event.preventDefault();
	// 		var targetPage = $(this).attr("href");
	// 		var jobForm = ${"#jobForm"}
	// 		jobForm.find("[name='page']").val(targetPage);
	// 		jobForm.attr("action","/board/listPage").attr("method", "get");
	// 		jobForm.submit();
	// 	});
</script>
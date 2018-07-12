<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
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

				<form role='form' method='post'>
					<input type='hidden' name='bno' value="${todoVO.bno }" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<input type='hidden' name='page' value='${cri.page }'> <input
						type='hidden' name='perPageNum' value='${cri.perPageNum }'>
				</form>
				<div class="box-body">
					<div class="form-group">
						<label>Title</label> <input type="text" name="title"
							class="form-control" value="${todoVO.title }" readonly="readonly" />
					</div>
					<div class="form-group">
						<label>Content</label>
						<textarea class="form-control" name="content" rows="3"
							readonly="readonly">${todoVO.content }</textarea>
					</div>
					<div class="form-group">
						<label>Date</label> <input type="text" name="target_date"
							class="form-control" readonly="readonly"
							value="${todoVO.target_date }" />
					</div>
					<div class="form-group">
						<div>해결 여부</div>
						<div class="form-control">${todoVO.done }</div>
					</div>
				</div>
				<div class="box-footer">
					<button type='submit' class="btn btn-warning">Modify</button>
					<button type='submit' class="btn btn-danger">Remove</button>
					<button type='submit' class="btn btn-primary">List All</button>
				</div>
			</div>
		</div>
	</section>
	<!-- End / Section -->

</div>
<!-- End / Content-->


<%@ include file="../common/footer.jspf"%>

<script>
	$(document)
			.ready(
					function() {
						var formObj = $("form[role='form']");

						$(".btn-warning").on('click', function() {
							formObj.attr("action", "/todo/modify");
							formObj.attr("method", "get");
							formObj.submit();
						});

						$(".btn-danger").on('click', function() {
							formObj.attr("action", "/todo/delete");
							formObj.submit();
						});

						$(".btn-primary")
								.on(
										'click',
										function() {
											self.location = "/todo/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
										});
					});
</script>
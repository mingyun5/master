<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
				<form:errors path="TodoVO.*" cssClass="error">
				</form:errors>
				<form role='form' method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" /> <input type='hidden' name='page'
						value='${cri.page}'> <input type='hidden'
						name='perPageNum' value='${cri.perPageNum }'> <input
						type="hidden" name="bno" value="${todoVO.bno }" />
					<div class="box-body">
						<div class="form-group">
							<label>Title</label> <input type="text" name="title"
								class="form-control" value="${todoVO.title }" />
						</div>
						<div class="form-group">
							<label>Content</label>
							<textarea class="form-control" name="content" rows="3">${todoVO.content }</textarea>
						</div>
						<div class="form-group">
							<label>Date</label> <input type="date" name="target_date"
								class="form-control" value="${todoVO.target_date }" />
						</div>
						<div class="form-group">
							<label>result</label>
							<div>
								<input type="radio" name="done" value="true" id="rad1"><label
									for="rad1">O</label>&nbsp; <input type="radio" name="done"
									value="false" id="rad2"><label for="rad2">X</label>
							</div>
						</div>
					</div>
					<div class="box-footer">
						<button type='submit' class='btn btn-primary'>SAVE</button>
						<button type='submit' class='btn btn-warning'>CANCEL</button>
					</div>
				</form>
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
						$(".btn-primary").on("click", function() {
							formObj.attr("action", "/todo/modify");
							formObj.submit();
						});

						$(".btn-warning")
								.on(
										"click",
										function() {
											self.location = "/todo/listPage?page=${cri.page}&perPageNum=${cri.perPageNum}";
										});
					});
</script>
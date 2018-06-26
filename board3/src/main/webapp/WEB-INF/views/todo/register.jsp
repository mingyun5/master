<%@ page language="java" contentType="text/html;charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<form action="/todo/register" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	
	<div class="box-body">
		<div class="form-group">
			<label>Title</label>
			<input type="text" name="title" class="form-control" placeholder="Enter Title"/>
		</div>
		<div class="form-group">
			<label>Content</label>
			<textarea class="form-control" name="content" rows="3" placeholder="Enter..."></textarea>
		</div>
		<div class="form-group">
			<label>Date</label>
			<input type="date" name="targetDate" class="form-control"/>
		</div>
	</div>
	<div class="box-footer">
		<button type="submit" class="btn btn-primary">Submit</button>
	</div>
</form>
<%@ include file="../common/footer.jspf"%>
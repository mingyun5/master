<%@ page language="java" contentType="text/html;charset=UTF-8" 
		pageEncoding="UTF-8" %>

<%@ include file="./common/header.jspf" %>
<%@ include file="./common/navigation.jspf" %>
<h1>
	Login page
</h1>

<p style="color: red">${error }</p>

<form name="loginForm" action='/login' method="POST">
	<input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
	<table class="table">
		<tr>
			<th>USER:</th>
			<td>
				<input type="text" name="username"/>
			</td>
		</tr>
		<tr>
			<th>PASSWORD:</th>
			<td>
				<input type="password" name="password"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="login"/>
				<input type="reset" value="reset" />
			</td>
		</tr>
	</table>
</form>
<P>  The time on the server is ${serverTime}. </P>
<%@ include file="./common/footer.jspf" %>




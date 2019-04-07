<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
<head>
	<title>Login</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
		
</head>
<body>
	<div id="container" >
		<fieldset>
			<legend>Login</legend>
			<form:form action="processLogin" modelAttribute="client" method="POST">
					<table>
						<tbody>
							<tr>
								<td><label>Email:</label></td>
								<td><form:input path="email" /></td>
							</tr>
							<tr>
								<td><label>Password:</label></td>
								<td><form:input path="password" type="password"/></td>
							</tr>
							<tr>
								<td><label></label></td>
								<td><input type="submit" value="Save" class="save" /></td>
							</tr>
						
						</tbody>		
					</table>
			</form:form>
		</fieldset>
	</div>
	<br><br>
	<div style="clear; both;"></div>
	<p>
		<a href="${pageContext.request.contextPath}">Back to welcome page</a>
	</p>
</body>

</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>

	<title>Hello</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>
		<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
		
</head>

<body >
	<div id="wrapper">
		<div id="header">
			<h2 >Welcome ${transferData.loggedClient.firstName} ${transferData.loggedClient.lastName}</h2 >
			
		</div>
		<header><label class="balancelabel" > Balance: ${transferData.loggedClient.balance} </label></header>
	</div>
	<br><br>
	
	<input type ="button" value="Log Out" 
		onclick="window.location.href='login'; return false;"
		class="add-button"/>
	
	<br><br>
		<fieldset>
			<legend>Transfer Money</legend>
				<form:form action="transferMoney" modelAttribute="transferData" method="POST" >
					<form:hidden path="loggedClient.firstName" value="${loggedClient.firstName}"/> 
	    			<form:hidden path="loggedClient.lastName"  value="${loggedClient.lastName}" />
	    			<form:hidden path="loggedClient.id" value="${loggedClient.id}" /> 
	    			<form:hidden path="loggedClient.balance" value="${loggedClient.balance}" />
	    			<form:hidden path="loggedClient.email" value="${loggedClient.email}" /> 
	    			<form:hidden path="loggedClient.password" value="${loggedClient.password}"/>
	    			
						<table>
							<tbody>
								<tr>
									<td><label>Recipients Email:</label></td>
									<td><form:input path="mail" /></td>
								</tr>
								<tr>
									<td><label>Amount :</label></td>
									<td><form:input path="amount" /></td>
								</tr>
								<tr>
									<td><label></label></td>
									<td><input type="submit" value="Send Transfer" class="save" /></td>
								</tr>
							</tbody>		
						</table>
				</form:form>
		</fieldset>
	<div id="container">
		
		<div id="content">
		
			<table>
			
				<tr>
					<th>From</th>
					<th>To</th>
					<th>Amount</th>		
					<th>Timestamp</th>
					<!-- <th></th> -->
				</tr>
				
				<c:forEach var="tempTransfer" items="${transferData.transferList}" >
					
					<tr>
						<td>${tempTransfer.sender.lastName} ${tempTransfer.sender.firstName} </td>
						<td>${tempTransfer.receiver.lastName} ${tempTransfer.receiver.firstName}</td>
						<td>${tempTransfer.amount}</td>
						<td>${tempTransfer.timestamp}</td>
						
					
					</tr>
			
				</c:forEach>
				
			</table>
		
		</div>
		
		<br><br>
	
	</div>


</body>

</html>
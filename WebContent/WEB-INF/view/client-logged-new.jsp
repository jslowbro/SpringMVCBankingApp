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
		
		<!-- <style>
			.balance{font-size: 15px; font-weight: bold}
		</style>  -->
</head>

<body >
	<div id="wrapper">
		<div id="header">
			<h2 >Welcome ${transferData.loggedClient.firstName} ${transferData.loggedClient.lastName}</h2 >
			
		</div>
		<header><label class="balancelabel" > Balance: ${transferData.loggedClient.balance} </label></header>
	</div>
	<br><br>
	
	<input type ="button" value="Add Client" 
		onclick="window.location.href='showFormforNewTransfer'; return false;"
		class="add-button"/>
		
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
						<td>${tempTransfer.sender.lastName}</td>
						<td>${tempTransfer.receiver.lastName}</td>
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
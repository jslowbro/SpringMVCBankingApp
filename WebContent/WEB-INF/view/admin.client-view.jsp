<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Client View</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>


</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>Transaction List of ${client.firstName} ${client.lastName}</h2>
		
		
		</div>
	</div>
	
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
				
				<c:forEach var="tempTransfer" items="${transferList}">
					<%-- <c:url var="showClientViewLink" value="/banking/clientView">
						<c:param name="Id" value="${tempClient.id}"></c:param>
						<c:param name="firstName" value="${tempClient.firstName}"></c:param>
						<c:param name="lastName" value="${tempClient.lastName}"></c:param>
					</c:url> --%>
					<tr>
						<td>${tempTransfer.sender.lastName} ${tempTransfer.sender.firstName} </td>
						<td>${tempTransfer.receiver.lastName} ${tempTransfer.receiver.firstName}</td>
						<td>${tempTransfer.amount}</td>
						<td>${tempTransfer.timestamp}</td>
						<%-- <td>
							<a href="${showClientViewLink}">Show Client View</a>
						</td> --%>
					
					</tr>
			
				</c:forEach>
				
			</table>
		
		</div>
		
		<br><br>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}/admin/showAdminView">Back to client list</a>
		</p>
	
	</div>
	

</body>


</html>
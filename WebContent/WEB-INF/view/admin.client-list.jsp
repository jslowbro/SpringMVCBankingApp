<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>Client list</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>


</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>List of Clients</h2>
		
		
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<table>
			
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>		
					<th>Balance</th>
					<th>Action</th>
				</tr>
				
				<c:forEach var="tempClient" items="${clientList}">
					<c:url var="showClientViewLink" value="/admin/clientView">
						<c:param name="Id" value="${tempClient.id}"></c:param>
						<c:param name="firstName" value="${tempClient.firstName}"></c:param>
						<c:param name="lastName" value="${tempClient.lastName}"></c:param>
					</c:url>
					<tr>
						<td>${tempClient.firstName}</td>
						<td>${tempClient.lastName}</td>
						<td>${tempClient.email}</td>
						<td>${tempClient.balance}</td>
						<td>
							<a href="${showClientViewLink}">Show Details</a>
						
						</td>
					
					</tr>
			
				</c:forEach>
				
			</table>
			
			
		
		</div>
		
		<br><br>
		
		<input type ="button" value="Show List of All Transactions" 
		onclick="window.location.href='showAllTransfers'; return false;"
		class="showList-button"/>
		       
		<input type ="button" value="Add Client" 
		onclick="window.location.href='showFormforAdd'; return false;"
		class="add-button"/>
		
		<br><br>
		<div style="clear; both;"></div>
		<p>
			<a href="${pageContext.request.contextPath}">Back to welcome page</a>
		</p>
		
	</div>
	
	

</body>


</html>
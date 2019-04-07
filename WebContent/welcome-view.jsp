<!DOCTYPE html>
<html>

<head>

	<title>Welcome View</title>
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>
	<div id="header">
		<h2>Welcome to banking application</h2>
		<br><br>
		<input type ="button" value="Admin View" 
		onclick="window.location.href='admin/showAdminView'; return false;"
		class="add-button"/>
		<br><br>
		<input type ="button" value="Client View" 
		onclick="window.location.href='client/login'; return false;"
		class="add-button"/>
			
	
	</div>

</body>

</html>
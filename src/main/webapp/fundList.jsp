<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Fund List</title>
	</head>
	<body>
		<h2>Fund List</h2>
		<table>
			<c:forEach var="fund" items="${fundList}">
					<tr><td>${fund}</td></tr>
			</c:forEach>
		</table>
			
	</body>
</html>
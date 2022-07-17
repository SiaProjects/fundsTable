<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Menu</title>
	</head>
	<body>
		<h2>Menu</h2>
		<a href='<c:url value="/expenses-table" />'>Expenses Table</a><br>
		<a href='<c:url value="/fund-list" />'>Funds List</a><br>
		<a href='<c:url value="/connection" />'>Check connection DB</a><br>
	</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Edit data table</title>
	</head>
	<body>
		<h3>Edit data table</h3>
		<p>Date: ${tableData.getDate()}</p>
		<p>Fund name: ${tableData.getLLFundName()}</p>
		<form method="post">
			<input type="hidden" value="${tableData.getDate()}" name="date" />
			<input type="hidden" value="${tableData.getLLFundName()}" name="fund" />
			<label>Expense value</label>
			<input value="${tableData.getExpenseValue()}" name="new-value" type="number" min="0" /><br><br>
			<input type="submit" value="Send" />
		</form>
	</body>
</html>
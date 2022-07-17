<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.Month" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Expenses Table</title>
		<style><%@include file="/warp-style.css"%></style>
	</head>
	<body>
		<h2>Expenses Table</h2>
		<c:forEach var="monthNum" begin="1" end="12">
			<a href='<c:url value="/expenses-table?month=${monthNum}" />'>${Month.of(monthNum)}</a>
		</c:forEach>
		
		<table>
			<tr>
				<th>Date</th>
				<c:forEach var="fundName" items="${listAllFunds}">
					<th>${fundName}</th>
				</c:forEach>
			</tr>
			
			<c:forEach var="expenses" items="${expensesTable}">
				<tr>
					<td>${expenses.getKey()}</td>
					<c:forEach var="expense" items="${expenses.getValue()}">
						<td>
							<a href='<c:url value="/edit-data-table?value=${expense.getExpenseValue()}&fund=${expense.getLLFundName()}&day=${expenses.getKey()}&month=${monthNumber}" />'>
								${expense.getExpenseValue()}
							</a>
						</td>
					</c:forEach>
				</tr>
			</c:forEach>
		</table>
		
	</body>
</html>
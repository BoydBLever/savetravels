<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expense Dashboard</title>
</head>
<body>
<h1>Expense Dashboard</h1>
<p> <a href="/expenses/new"> New Expense</a></p>
<table>
	<thead>
		<tr>
			<th>Expense</th>
			<th>Amount</th>
			<th>Vendor</th>
			<th>Actions</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="eachExpense" items="${expenseList }">
			<tr>
				<td> <a href="/expenses/${eachExpense.id }">${eachExpense.expenseName}</a></td>
				<td> <c:out value="${eachExpense.amount }"/></td>
				<td> <c:out value="${eachExpense.vendor }"/></td>
				<td> <a href="/expenses/edit/${eachExpense.id }">Edit</a></td>
				<td> <a href="/expenses/delete/${eachExpense.id }">Delete</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>
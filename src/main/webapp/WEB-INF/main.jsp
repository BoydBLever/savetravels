<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 style="blue">Save Travels</h1>
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
<br>
<br>
<form:form action="/expenses/new" method="POST" modelAttribute="newExpense">
  <p>
        <form:label path="expenseName">Expense Name:</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
     <p>
        <form:label path="amount">Amount:($)</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
     <p>
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
     <p>
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"></form:textarea>
    </p>
    <button type="submit">Add new expense</button>
</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<br>
<br>
<title>Save Travels</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<br>
<h1 style="blue">Save Travels</h1>
<table class="table table-hover">
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
  <div class="form-group mx-sm-3 mb-2">
        <form:label for="exampleExpenseName" path="expenseName">Expense Name:</form:label>
        <form:errors path="expenseName"/>
        <form:input class="form-control" placeholder="Room & Board" path="expenseName"/>
     </div>
     <div class="form-group mx-sm-3 mb-2">
        <form:label path="amount">Amount:</form:label>
        <form:errors path="amount"/>
        <form:input type="number" class="form-control" placeholder="$250" path="amount"/>
    </div>
     <div class="form-group mx-sm-3 mb-2">
        <form:label path="vendor">Vendor:</form:label>
        <form:errors path="vendor"/>
        <form:input class="form-control" placeholder="Holiday Inn Express" path="vendor"/>
    </div>
     <div class="form-group mx-sm-3 mb-2"">
        <form:label path="description">Description:</form:label>
        <form:errors path="description"/>
        <form:textarea class="form-control" placeholder="Weekend staycation at an affordable hotel!" path="description"></form:textarea>
    </div>
    <button class="btn btn-primary" type="submit">Add expense</button>
</form:form>

</body>
</html>
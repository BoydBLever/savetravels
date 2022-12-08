<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Expense</title>
</head>
<body>
<h1>New Expense</h1>
<form:form action="/expenses/new" method="POST" modelAttribute="newExpense">
  <p>
        <form:label path="expenseName">Expense Name:</form:label>
        <form:errors path="expenseName"/>
        <form:input path="expenseName"/>
    </p>
     <p>
        <form:label path="amount">Amount:</form:label>
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
 <p> <a href="/expenses"> Go Back</a></p>
</body>
</html>
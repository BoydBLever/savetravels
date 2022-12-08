<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<h1>Expense Details</h1>
<h2>Expense Name: <c:out value="${expense.expenseName }"/></h2>
<h2>Vendor: <c:out value="${expense.vendor }"/></h2>
<h2>Amount: <c:out value="${expense.amount }"/></h2>
<h2>Description: <c:out value="${expense.description }"/></h2>
<p> <a href="/expenses"> Go Back</a></p>
</body>
</html>
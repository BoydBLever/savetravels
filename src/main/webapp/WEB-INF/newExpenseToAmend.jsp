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
	<h1>New Expense</h1>
	<form action="/expenses2/new" method="POST">
			<div>
				<label> Expense name:</label>
				<input type="text" name="expenseName"/>
			</div>
			<div>
				<label> Amount:</label>
				<input type="number" name="amount"/>
			</div>
			<div>
				<label> Vendor:</label>
				<input type="text" name="vendor"/>
			</div>
			<div>
				<label> Description:</label>
				<textarea name="description"></textarea>
		    </div>
		    	<button type="submit">Add a new expense</button>
	</form>
</body>
</html>
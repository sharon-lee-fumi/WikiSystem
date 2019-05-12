<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
<title>Add an Item</title>
</head>
<body class="alert alert-success" role="alert">
	<h1> Hope is a great thing! </h1><br/>
	<c:url value="/deleteItem/${item.id}" var="deleteUrl" />
	<a href="${deleteUrl}">Go back to home page</a><br/><br/>
	
	<c:url var="url" value="/createPage/${item.id}" />
	<form:form modelAttribute="item" method="POST" action="${url}">
		<form:hidden path="id" />		
		
		<div style="color:red">${title}</div>
		Title: <form:input path="title" /><br/><br/>
		<div style="color:red">${category}</div>
		Category: <form:select path="category" items="${item.CATEGORYS}"/><br/><br/>
		<div style="color:red">${summary}</div>
		Summary: <form:textarea path="summary" cols="70"/><br/><br/>

		Contents: <form:textarea path="contents.content" rows="6" cols="70"/><br/><br/>
		<div style="color:red">${contents_referenceLink}</div>
		Reference Links: <form:textarea path="contents.referenceLink" cols="70"/><br/><br/>
		
		<input type="submit" value="Save!" />
	</form:form>
	
	<br/>
 	<a class="nav-link" href="#">Go to Top</a>
</body>
</html>
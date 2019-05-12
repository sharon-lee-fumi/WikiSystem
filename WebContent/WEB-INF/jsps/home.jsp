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
<style>
div{
    word-wrap: break-word;
}
</style>
<title>Sharon's Wiki</title>
</head>
<body class="alert alert-success" role="alert">
	<div class="alert alert-success" role="alert">
		<h1>Every Day is a New Day!</h1>
		<br />
		<c:url value="/createItem" var="createUrl" />
		<p><a href="${createUrl}">Create New Item</a></p>
	
		<c:url value="/searchItem" var="searchUrl" />
		<form method="GET" action="${searchUrl}">
			Search key words in title, category or summary: <input name="word" />
			
			<input type="submit" value="Search" />
		</form>
	</div>
	<div class="alert alert-success" role="alert">
		<h3>List Items</h3>
		
		<c:forEach items="${itemList}" var="item">
			<c:url value="/displayPage/${item.id}" var="pageUrl" />
			<p><a href="${pageUrl}">${item.title}</a></p>
		</c:forEach>
	</div>
	
 	<a class="nav-link" href="#">Go to Top</a>
</body>
</html>
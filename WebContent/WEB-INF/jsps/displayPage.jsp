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
<title>Display the Page</title>
</head>
<body class="alert alert-success" role="alert">
	<div class="alert alert-success" role="alert">
		<h1> What we think, we become. </h1>
		<br />
		<c:url value="/" var="homeUrl" />
			<a href="${homeUrl}">Go to home page</a><br />
	</div>
	
	<div class="alert alert-success" role="alert">
		<c:url value="/editItem/${item.id}" var="editUrl" />
		<a href="${editUrl}">Edit Item</a><br /><br />
		<p>Title: ${item.title} <br />
			Category: ${item.category} <br />
			Summary: ${item.summary} <br />
			Contents: ${item.contents.content} <br /><br />
			Reference Links: ${item.contents.referenceLink} <br /><br />
	
		<c:url value="/deleteItem/${item.id}" var="deleteUrl" />
			<a href="${deleteUrl}">Delete Item</a>
			</p>
	</div>
	
 	<a class="nav-link" href="#">Go to Top</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All Dishes</h1>
<table class="table table-striped">
	<tr><th>Dish ID</th><th>Dish Name</th><th>Dish Description</th><th>Dish Price</th><th>Dish Qty</th></tr>
	<c:forEach var="d" items="${dishes }">
		<tr>
			<td>${d.dishId }</td>
			<td>${d.name }</td>
			<td>${d.description }</td>
			<td>${d.price }</td>
			<td>${d.qty }</td>
		</tr>
	</c:forEach>	
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>Merchants List</h1>

<table class="table table-striped">
	<tr><th>ID</th><th>Merchant Name</th><th>Age</th><th>Gender</th><th>Shop Name</th><th>Register Time</th><th>Address</th><th>Shop Picture</th></tr>
	<c:forEach var="m" items="${merchantsInfos }">
		<tr>
			<td>${m.id }</td>
			<td><a href="listMyDishes?id=${m.id }">${m.merchantName }</a></td>
			<td>${m.age}</td>
			<td>${m.gender}</td>
			<td>${m.shopName}</td>
			<td>${m.registerTime }</td>				
			<td>${m.address }</td>	
			<td>${m.shopPicUrl }</td>				
		
		</tr>
	</c:forEach>	
</table>

</body>
</html>
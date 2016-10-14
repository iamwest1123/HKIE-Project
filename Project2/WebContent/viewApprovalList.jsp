<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Pending Approval</h1>
<table class="table table-striped">
	<tr><th>Logo</th><th>Merchant Name</th><th>Age</th><th>Gender</th><th>Shop Name</th><th>Tel</th><th>Address</th><th>Register Time</th><th>Approve</th><th>Reject</th></tr>
	<c:forEach var="m" items="${infoList}">
		<tr>
			<td><img src="${m.shopPicUrl}" alt="${m.shopName}'s logo"></td>
			<td>${m.merchantName}</td>
			<td>${m.age}</td>
			<td>${m.gender}</td>
			<td>${m.shopName}</td>
			<td>${m.telNum}</td>
			<td>${m.address}</td>	
			<td>${m.registerTime}</td>						
			<td><a class="btn btn-primary" href="approve?id=${m.id}">Approve</a></td>
			<td><a class="btn btn-primary" href="reject?id=${m.id}">Reject</a></td>
		</tr>
	</c:forEach>	
</table>
</body>
</html>
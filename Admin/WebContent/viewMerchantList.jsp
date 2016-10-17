<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant List</title>
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<style>
body{
  background-color: #f6f6f6;
  font-family: Arial, Helvetica;
  font-size: 1.5em;
  padding: 30px 120px 50px 120px;
}
h1 {
  margin-bottom: 20px;
  font-size: 30px;
  font-weight: 600;
}
table {
  width: 100%;
  max-width: 100%;
  margin-bottom: 20px;
}
</style>
</head>
<body>
<div>
<h1>Merchant List</h1>
<table class="table table-striped" >
	<tr>
		<!--  <th>Logo</th>-->
		<th>Merchant Name</th>
		<th>Age</th>
		<th>Gender</th>
		<th>Shop Name</th>
		<th>Tel</th>
		<th>Address</th>
		<th>Register Time</th>
		<th>Status</th>
		<th>Action</th>
	</tr>
	<c:forEach var="m" items="${merchantsList}">
		<tr>
			<!--  <td><img src="${m.key.shopPicUrl}" alt="${m.key.shopName}'s logo"></td>-->
			<td>${m.key.merchantName}</td>
			<td>${m.key.age}</td>
			<td>${m.key.gender}</td>
			<td>${m.key.shopName}</td>
			<td>${m.key.telNum}</td>
			<td>${m.key.address}</td>	
			<td>${m.key.registerTime}</td>		
			<td><pre>${m.value.status}</pre></td>		
			<td>			
			<c:choose>
				<c:when test="${m.value.status.equals('UnderReview')}">
					<a class="btn btn-primary btn-sm" href="approve?id=${m.key.id}">Approve</a>
					<a class="btn btn-warning btn-sm" href="reject?id=${m.key.id}">Reject</a>
				</c:when>
				<c:when test="${m.value.status.equals('Accepted')}">
					<a class="btn btn-primary btn-sm" href="addBlacklist?id=${m.key.id}">blacklist</a>
				</c:when>
				<c:when test="${m.value.status.equals('Rejected')}">
					<a class="btn btn-primary btn-sm" href="approve?id=${m.key.id}">Approve</a>
				</c:when>
				<c:when test="${m.value.status.equals('Forzen')}">
					<a class="btn btn-primary btn-sm" href="removeBlacklist?id=${m.key.id}">Back to normal</a>
				</c:when>
			</c:choose>
			<c:choose>
				<c:when test="${!m.value.status.equals('Deleted')}">
				<a class="btn btn-danger btn-sm" href="deleteMerchant?id=${m.key.id}">delete</a>
				</c:when>
			</c:choose>
			</td>
		</tr>
	</c:forEach>	
</table>
</div>

</body>
</html>
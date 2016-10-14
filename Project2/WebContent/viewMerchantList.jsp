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
<table class="table table-condensed" >
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
					<a class="btn btn-secondary btn-sm" href="reject?id=${m.key.id}">Reject</a>
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
			<a class="btn btn-danger btn-sm" href="deleteMerchant?id=${m.key.id}">delete</a></td>
		</tr>
	</c:forEach>	
</table>


</body>
</html>
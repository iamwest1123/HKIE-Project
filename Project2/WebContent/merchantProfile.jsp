<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Merchant Profile</title>
<style>
body{
  background-color: #f6f6f6;
  font-family: Arial, Helvetica;
  font-size: 1.5em;
  padding: 30px 120px 50px 120px;
  overflow: scroll;
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
	<h1>Merchant Profile</h1>
	<table class="table table-striped">
	<tr><th>ID</th><th>Merchant Name</th><th>Age</th><th>Gender</th><th>Shop Name</th><th>Register Time</th><th>Address</th><th>Shop Picture</th><th>My Dishes</th><th>Add Dish</th><th>Edit</th></tr>
		<tr>
			<td>${m.id }</td>
			<td>${m.merchantName }</td>
			<td>${m.age}</td>
			<td>${m.gender}</td>
			<td>${m.shopName}</td>
			<td>${m.registerTime }</td>
			<td>${m.address }</td>
			<td><img src="${m.shopPicUrl }" style="width: 50px; height: 50px"/></td>			
			<td><a class="btn btn-primary" href="listMyDishes">my dishes</a></td>
			<td><a class="btn btn-primary" href="addDish.jsp">add dish</a></td>
			<td><a class="btn btn-primary" href="EditMerchant">edit</a></td>
		</tr>	
	</table>
	</div>
</body>
</html>
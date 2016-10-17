<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>

<meta charset="ISO-8859-1">
<title>Edit Dishes</title>
<style>
body {
  background-color: #f6f6f6;
  font-family: Arial, Helvetica;
  font-size: 1.5em;
  overflow: scroll;
  padding: 0px 0px 50px 0px;
}
div {
  left: 40%;
  position:relative;
}
h1 {
  margin-bottom: 20px;
  font-size: 40px;
  font-weight: 600;
}
input {
  width: 250px;
  padding: 15px 12px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-bottom: 2px solid #ddd;
  background: #f2f2f2;
  color: #555;
}

</style>
</head>
<body>
<div>
<h1>Edit Dishes</h1>
<img src="ad3.jpg" alt="ad" style="width:400px;height:200px;margin-bottom:100px;">
<form  action="updateDish" method="post">

	<input type="hidden" name="merchantId" value="${d.merchantId }">
	<input type="hidden" name="dishId" value="${d.dishId }">

  <p>	
    <label>Dish Name</label>
    <input type="text" class="form-control" name="dishName" placeholder="${d.name }" value="${d.name }">
  </p>
  <p>
    <label>Dish Description</label>
    <input type="text" class="form-control" name="description" placeholder="${d.description }" value="${d.description }">
  </p> 
  <p>
    <label>Price</label>
    <input type="text" class="form-control" name="price" placeholder="${d.price }" value="${d.price }">
  </p>
  <p>
    <label>Qty</label>
    <input type="text" class="form-control" name="qty" placeholder="${d.qty }" value="${d.qty }">
  </p> 
	
	<button type="submit" class="btn btn-primary" >Submit</button>
	</form>
	</div>
</body>
</html>

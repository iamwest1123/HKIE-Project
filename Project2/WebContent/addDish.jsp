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
<title>Add Dish</title>
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
<h1>Add Dishes</h1>
<img src="ad3.jpg" alt="ad" style="width:400px;height:200px;margin-bottom:50px;">
<form action="addDish" method="post">
  <p>	
    <label >Dish Name</label><br>
      <input type="text"  name="dishName" placeholder="Dish Name">
  </p>
  <p class="form-group">
    <label >Dish Description</label><br>
      <input type="text"  name="description" placeholder="Dish Description">
  </p> 
  <p class="form-group">
    <label >Price</label><br>
      <input type="text"  name="price" placeholder="Price">
  </p>
  <p class="form-group">
    <label >Qty</label><br>
      <input type="text"  name="qty" placeholder="Qty">
  </p> 
	  <p class="form-group">
    <label >  </label><br>
      <input class="btn btn-primary" type="submit" value="Add Dish !" />
  </p> 
	
	</form>
</div>	
</body>
</html>
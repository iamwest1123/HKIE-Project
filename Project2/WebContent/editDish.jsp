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
<title>Insert title here</title>
</head>
<body>

<form class="form-horizontal" action="updateDish" method="post">

	<input type="hidden" name="merchantId" value="${d.merchantId }">
	<input type="hidden" name="dishId" value="${d.dishId }">

  <div class="form-group">	
    <label class="col-sm-2 control-label">Dish Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="dishName" placeholder="${d.name }" value="${d.name }">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">Dish Description</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="description" placeholder="${d.description }" value="${d.description }">
    </div>
  </div> 
  <div class="form-group">
    <label class="col-sm-2 control-label">Price</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="price" placeholder="${d.price }" value="${d.price }">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">Qty</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="qty" placeholder="${d.qty }" value="${d.qty }">
    </div>
  </div> 
	
	<input class="btn btn-primary" type="submit" />
	</form>
</body>
</html>

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

<form class="form-horizontal" action="updateUser" method="post">

	<input type="hidden" name="id" value="${u.id }">

  <div class="form-group">
    <label class="col-sm-2 control-label">User Name</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="uname" name="uname" placeholder="User Name">
    </div>
  </div>
  <div class="form-group">
    <label class="col-sm-2 control-label">User Age</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="age" name="age" placeholder="User Age">
    </div>
  </div> 
	
	<input class="btn btn-primary" type="submit" />
	</form>
</body>
</html>
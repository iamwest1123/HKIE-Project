<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Merchant</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<body>
  <h1>Register Merchant</h1>
  <c:if test="${!isSuccess}"><label>${failReason}</label></c:if>
  <form action="register" method="post">
    <div class="form-group">
      <label for="username">Merchant Name</label>
      <input type="text" class="form-control" id="mname" placeholder="Merchant Name" name="mname" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Password</label>
      <input type="password" class="form-control" id="password" placeholder="Password" name="password" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Age</label>
      <input type="password" class="form-control" id="age" placeholder="Age" name="age" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Gender</label>
      <input type="password" class="form-control" id="gender" placeholder="Gender" name="gender" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Shop Name</label>
      <input type="password" class="form-control" id="sname" placeholder="Shop Name" name="sname" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Shop logo</label>
      <input type="password" class="form-control" id="logo" placeholder="Shop logo" name="logo" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Shop Tel</label>
      <input type="password" class="form-control" id="tel" placeholder="Shop Tel" name="tel" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="password">Shop Address</label>
      <input type="password" class="form-control" id="addr" placeholder="Shop Address" name="addr" style="max-width:400px">
    </div>
    
    <button type="submit" class="btn btn-primary" href="">Register</button>
  </form>
</body>
</html>
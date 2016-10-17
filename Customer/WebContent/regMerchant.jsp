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
  <h1>Register</h1>
  <c:if test="${!isSuccess}"><label>${failReason}</label></c:if>
  <form action="regMerchant" method="post">
    <p>
      <label for="mname">Merchant Name</label><br>
      <input type="text" id="mname" placeholder="Merchant Name" name="mname" style="max-width:400px">
    </p>
    <p>
      <label for="password">Password</label><br>
      <input type="password" id="password" placeholder="Password" name="password" style="max-width:400px">
    </p>
    <p>
      <label for="age">Age</label><br>
      <input type="text" id="age" placeholder="Age" name="age" style="max-width:400px">
    </p>
    <p>
      <label for="gender">Gender</label><br>
      <input type="text" id="gender" placeholder="Gender" name="gender" style="max-width:400px" maxlength="1">
    </p>
    <p>
      <label for="sname">Shop Name</label><br>
      <input type="text" id="sname" placeholder="Shop Name" name="sname" style="max-width:400px">
    </p>
    <p>
      <label for="logo">Shop logo URL Link</label><br>
      <input type="text" id="logo" placeholder="Shop logo" name="logo" style="max-width:400px">
    </p>
    <p>
      <label for="tel">Shop Tel</label><br>
      <input type="text" id="tel" placeholder="Shop Tel" name="tel" style="max-width:400px">
    </p>
    <p>
      <label for="addr">Shop Address</label><br>
      <input type="text" id="addr" placeholder="Shop Address" name="addr" style="max-width:400px">
    </p>
    
    <button type="submit" class="btn btn-primary" >Register</button>
  </form>
  </div>
</body>
</html>
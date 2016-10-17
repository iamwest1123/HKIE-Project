<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Log in as ${userType}</title>
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
  padding:0px 0px 30px 0px;
}
div {
  margin: 0 auto;
  text-align: center;
}
h1 {
  margin-bottom: 20px;
  font-size: 30px;
  font-weight: 600;
}
p {
 position: relative; 
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
form label { 
  position: absolute;
  left:-9999px;
  text-indent: -9999px;
}
</style>

</head>
<body>
<div>
<img src="ad.jpg" alt="ad" style="width:1550px;height:400px;">
  <h1>Log In as ${userType}</h1>
  <c:if test="${!isSuccess}"><label>${failReason}</label></c:if>
  <form action="login" method="post">
    <input type="hidden"name="userType" value="${userType}">
    <p>
      <label for="username">User Name</label>
      <input type="text" id="username" placeholder="name" name="username" >
    </p>
    <p>
      <label for="password">Password</label>
      <input type="password" id="password" placeholder="password" name="password" >
    </p>
    <p>
	  <button type="submit" class="btn btn-primary">Log In</button>
	  <a class="btn btn-default" href="regMerchant.jsp">Register</a>
	<p>
  </form>
  </div>
</body>
</html>
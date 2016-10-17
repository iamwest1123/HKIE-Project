<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css">
<link rel="stylesheet" href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap-theme.min.css">
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<title>Update</title>
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
<h1>Update</h1>
 <form action="UpdateMerchant" method="post">
 <input type="hidden"  id="id" value="${u.id }" name="id" />
    <p>
      <label for="merchantName">Merchant Name</label><br>
      <input type="text"  id="merchantName" value="${u.merchantName }" name="merchantName"  readonly>
    </p>
    <p>
      <label for="age">Age</label><br>
      <input type="text"  id="age" value="${u.age }" name="age"  readonly>
    </p>
    <p>
      <label for="gender">Gender</label><br>
      <input type="text"  id="gender" value="${u.gender }" name="gender"  readonly>
    </p>
    <p >
      <label for="registerTime">Register Time</label><br>
      <input type="text"  id="registerTime" value="${u.registerTime }" name="registerTime"   readonly>
    </p>
    <p >
      <label for="shopName">Shop Name</label><br>
      <input type="text" id="shopName" value="${u.shopName } " name="shopName" >
    </p>
    <p >
      <label for="telNum">Tel no.</label><br>
      <input type="text"  id="telNum" value="${u.telNum }" name="telNum" >
    </p>
    <p >
      <label for="address">Address</label><br>
      <input type="text"  id="address" value="${u.address }" name="address">
    </p>
    <p >
      <label for="shopPicUrl">Shop Logo</label><br>
      <input type="text" id="shopPicUrl" value="${u.shopPicUrl }" name="shopPicUrl">
    </p>
    
    <button type="submit" class="btn btn-primary" >Submit</button>
  </form>
  </div>
</body>
</html>
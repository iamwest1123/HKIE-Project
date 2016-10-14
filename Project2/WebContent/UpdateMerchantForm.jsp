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
<title>Insert title here</title>
</head>
<body>
 <form action="UpdateMerchant" method="post">
 
 <input type="hidden" class="form-control" id="id" value="${u.id }" name="id" />
 
    <div class="form-group">
      <label for="merchantName">Merchant Name</label>
      <input type="text" class="form-control" id="merchantName" value="${u.merchantName }" name="merchantName" style="max-width:400px"  readonly>
    </div>
    <div class="form-group">
      <label for="age">Age</label>
      <input type="text" class="form-control" id="age" value="${u.age }" name="age" style="max-width:400px" readonly>
    </div>
    <div class="form-group">
      <label for="gender">Gender</label>
      <input type="text" class="form-control" id="gender" value="${u.gender }" name="gender" style="max-width:400px" readonly>
    </div>
    <div class="form-group">
      <label for="registerTime">Register Time</label>
      <input type="text" class="form-control" id="registerTime" value="${u.registerTime }" name="registerTime" style="max-width:400px"  readonly>
    </div>
    <div class="form-group">
      <label for="shopName">Shop Name</label>
      <input type="text" class="form-control" id="shopName" value="${u.shopName } " name="shopName" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="telNum">Tel no.</label>
      <input type="text" class="form-control" id="telNum" value="${u.telNum }" name="telNum" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="address">Address</label>
      <input type="text" class="form-control" id="address" value="${u.address }" name="address" style="max-width:400px">
    </div>
    <div class="form-group">
      <label for="shopPicUrl">Shop Logo</label>
      <input type="text" class="form-control" id="shopPicUrl" value="${u.shopPicUrl }" name="shopPicUrl" style="max-width:400px">
    </div>
    
    <button type="submit" class="btn btn-primary" >Submit</button>
  </form>
</body>
</html>
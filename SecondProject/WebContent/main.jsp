<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<%@include file="./../common/top.jsp" %>
	
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Main_Page</title>
</head>
<body>
	<div class="row col-sm-offset-2 col-sm-8" style="margin-top:80px; margin-bottom:20px">
   	<h3> 이달의 인기 도서 </h3>
   	</div>
<div class="container">
  <div class="row"  style="margin-top:100px;">
   <div class="col-sm-2">
      <div class="alert alert-danger" align="center" style="width:100px;">1위</div>
      <img class="img-thumbnail" src="<%=contextPath%>/images/conan1.jpg" alt='a'
      style="width:200px;height:250px">
    </div>

    <div class="col-sm-2">
      <div class="alert alert-success" align="center" style="width:100px;">2위</div>
      <img class="img-thumbnail" src="<%=contextPath%>/images/conan2.jpg" alt='a'
      style="width:200px;height:250px">
    </div>

    <div class="col-sm-2">
      <div class="alert alert-success" align="center" style="width:100px;">3위</div>
      <img class="img-thumbnail" src="<%=contextPath%>/images/conan3.jpg" alt='a'
      style="width:200px;height:250px">
    </div>
    
    <div class="col-sm-2">
      <div class="alert alert-success" align="center" style="width:100px;">4위</div>
      <img class="img-thumbnail" src="<%=contextPath%>/images/conan3.jpg" alt='a'
      style="width:200px;height:250px">
    </div>
    
    <div class="col-sm-2">
      <div class="alert alert-success" align="center" style="width:100px;">5위</div>
      <img class="img-thumbnail" src="<%=contextPath%>/images/conan3.jpg" alt='a'
      style="width:200px;height:250px">
    </div>

  </div>

<hr>
  
</div>
</body>
</html>
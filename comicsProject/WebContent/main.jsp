<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<% 
	String message = (String)request.getAttribute("message");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/nav.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="myCarousel" class="carousel slide" data-ride="carousel" align="center">
    	<!-- Indicators -->
    	<ol class="carousel-indicators">
      		<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
     		<li data-target="#myCarousel" data-slide-to="1"></li>
   		    <li data-target="#myCarousel" data-slide-to="2"></li>
    	</ol>

    	<!-- Wrapper for slides -->
   		<div class="carousel-inner" role="listbox">
      		<div class="item active">
        		<img src="<%=imageFolder%>back01.jpg" alt="back01" width="1200" height="675">
        		<div class="carousel-caption">
          			<h3>Angel Beats</h3>
          			<p></p>
        		</div>      
      		</div>

      <div class="item">
        <img src="<%=imageFolder%>back02.jpg" alt="back02" width="1200" height="675">
        <div class="carousel-caption">
          <h3>Love Live</h3>
          <p></p>
        </div>      
      </div>
    
      <div class="item">
        <img src="<%=imageFolder%>back03.jpg" alt="back03" width="1200" height="675">
        <div class="carousel-caption">
          <h3>5cm/s</h3>
          <p></p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>

<div class="container text-center">
  <h3>★만화 도서관★</h3>
  <p><em>만화 도서관에 오신것을 환영합니다!</em></p>
  <p>재밌고 신나고 슬프고 무서운 만화들이 여러분들을 위해 있습니다.</p>
  <br>
  <div class="row">
    <div class="col-sm-4">
      <p class="text-center"><strong>명탐정 코난 88</strong></p><br>
      <a href="#demo" data-toggle="collapse">
        <img src="<%=imageFolder%>명탐정 코난 88.jpg" class="img-rounded person" alt="Random Name" width="280" height="400">
      </a>
      <div id="demo" class="collapse">
        <p>드디어 88권 발매</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>원피스 81</strong></p><br>
      <a href="#demo2" data-toggle="collapse">
        <img src="<%=imageFolder%>원피스 81.jpg" class="img-rounded person" alt="Random Name" width="280" height="400">
      </a>
      <div id="demo2" class="collapse">
        <p>그만 나올때도 되지 않았나</p>
      </div>
    </div>
    <div class="col-sm-4">
      <p class="text-center"><strong>나의 히어로 아카데미아 8</strong></p><br>
      <a href="#demo3" data-toggle="collapse">
        <img src="<%=imageFolder%>나의 히어로 아카데미아 8.jpg" class="img-rounded person" alt="Random Name" width="280" height="400">
      </a>
      <div id="demo3" class="collapse">
        <p>이게 요즘 핫하다던데</p>
      </div>
    </div>
  </div>
</div>


<input type="hidden" value="<%=message%>" id="message" name="message">
<c:if test="${not empty requestScope.message}">
		<script type="text/javascript">
		var url = './common/message.jsp';
		var sw  = screen.availWidth ;
		var sh  = screen.availHeight ;
		var px=(sw - 150)/2 ;
		var py=(sh - 100)/2 ;
		var set  = 'top=' + py + ',left=' + px ;
		 set += ',width=' + 150 + ',height=' + 100 + ',scrollbars=no,status=no,toolbar=no,resizable=no,location=no,menu=no';

		window.open(url, "mywin", set) ;
		</script>
	</c:if>
</body>
</html>
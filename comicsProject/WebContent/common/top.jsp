<%@ page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();
	String servPath = "/ComicsCtrl";
	String MyCtrlCommand = context + servPath +"?command=";
	//out.print(MyCtrlCommand);
%>
<%  
	int whologin = 0;
	try{
		Member loginfo = (Member)session.getAttribute("loginfo");
		if(loginfo.getId() == null || session.getAttribute("loginfo") == null){
			whologin = 0; //노 접속
			}else{
				if(loginfo.getId().equals("admin")){
					whologin = 2; //관리자 로그인
				}else{
					whologin = 1; //일반 유저 로그인
				}
			}
		session.setAttribute("whologin", whologin);	  
	}catch(NullPointerException e){
		
	}
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<link rel="stylesheet" type="text/css" href="./css/nav.css">
<title>## 만화책 도서관 ##</title>
</head>
<body>
<div style="margin-top:20px; margin-left:600px">
 <form class="form-group" role="search""
            	action="#">
              <div class="form-inline">
                <input type="text" class="form-control" placeholder="Search" style="width:400px;" />
                <button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
              </div>
            </form>
</div>
<div class="container-fluid" style="margin-top:20px">
<nav class="navbar navbar-inverse">
 	<div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1"></button>
          <a class="navbar-brand" href="main.jsp">All About Comics</a>
    </div>
    <ul class="nav navbar-nav" style="margin-left:100px;">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원(로그인시)
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><a href="#">회원 리스트(관리자)</a></li>
          <li><a href="#">정보 수정</a></li>
          <li><a href="#">아이디/비밀번호 찾기</a></li> 
          <li><a href="#">회원 탈퇴</a></li>
          <li><a href="#">로그 아웃</a></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">도서 목록
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><a href="#">전체 도서</a></li>
          <li><a href="#">신간 도서</a></li>
          <li><a href="#">인기 도서</a></li>
          <li><a href="#">도서 등록(관리자)</a></li>
          <li><a href="#">도서 수정(관리자) </a></li> 
          <li><a href="#">도서 삭제(관리자)</a></li>   
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">나의도서(로그인시)
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><a href="#">대여중인 도서</a></li>
          <li><a href="#">예약한 도서</a></li>
          <li><a href="#">히스토리</a></li> 
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><a href="#">공지사항</a></li>
          <li><a href="#">리뷰</a></li>
          <li><a href="#">자유 게시판</a></li> 
        </ul>
      </li>
    </ul>
		<div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
             <c:if test="${empty sessionScope.loginfo }">
             <li>
              <a class="btn btn-default btn-outline btn-circle collapsed" href="<%=MyCtrlCommand%>meJoinForm" aria-expanded="false">Join us</a>
            </li>
            </c:if>
            <c:if test="${not empty sessionScope.loginfo }">
            <li>
            <div style="margin-top:12px">
            	 <font color="white" size="3px">${sessionScope.loginfo.id}님 환영합니다.</font>
            </div>
            </li>
            </c:if>
            <c:if test="${empty sessionScope.loginfo }">
             <li>
              <a class="btn btn-default btn-outline btn-circle collapsed" data-toggle="collapse" href="#nav-collapse2" aria-expanded="false" aria-controls="nav-collapse2">Sign in</a>
            </li>
            </c:if>
            <c:if test="${not empty sessionScope.loginfo }">
            <li>
            <a href="<%=MyCtrlCommand%>meLogout">로그 아웃<span
								class="glyphicon glyphicon-log-in"></span>
							</a>
            </li>
            </c:if>
          </ul>
          <ul class="collapse nav navbar-nav nav-collapse" id="nav-collapse2">
            <form class="navbar-form navbar-right form-inline" role="form"
            	action="<%=MyCtrlCommand%>meLogin" method="post">
              <div class="form-group">
                <label class="sr-only" for="ID">ID</label>
                <input type="text" class="form-control" name="id" id="id" style="width:120px;" placeholder="id" autofocus required />
              </div>
              <div class="form-group">
                <label class="sr-only" for="Password">Password</label>
                <input type="password" class="form-control" name="password" id="password" style="width:120px;" placeholder="Password" required />
              </div>
              <button type="submit" class="btn btn-success">Sign in</button>
            </form>
          </ul>
          </div>
</nav>
</div>

</body>
</html>

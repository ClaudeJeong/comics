<%@page import="mypkg.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	int twelve = 12;
	int myoffset = 1;
	int mygrid = twelve - (myoffset * 2);
%>
<%
	String contextPath = request.getContextPath();
	String commandName = "/comics";
	String MyCtrlByForm = contextPath + commandName;
	String myCtrlCommand = contextPath + commandName + "?command=";
%>
<% 
	Member loginfo = (Member)session.getAttribute("loginfo");
	String log  = "";
	int whologin = 0; //0:미로그인, 1:회원 로그인, 2:관리자 로그인
	
	if( loginfo == null ){
		whologin = 0;
	}else{
		if( loginfo.getId().equals("admin")){
			whologin = 2;
		}else{
			whologin = 1;
		}
	}
	
	session.setAttribute("whologin", whologin);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>top_Page</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script   
	src="https://code.jquery.com/ui/1.12.0/jquery-ui.min.js">
</script>	
</head>
<body>
	<div class="container row col-sm-offset-<%=myoffset%> col-sm-<%=mygrid%>"
		style="margin-top: 10px;">
		<nav class="navbar navbar-default">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">All about comics</a>
		</div>
		<ul class="nav navbar-nav">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">회원<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<c:if test="${whologin == 0}">
					<li><a href="<%=myCtrlCommand%>meLoginForm">로그인</a></li>
					<li><a href="<%=myCtrlCommand%>meJoinForm">회원가입</a></li>
					<li><a href="<%=myCtrlCommand%>meIdPasswordForm">아이디/비밀번호 찾기</a></li>
					</c:if>
					<c:if test="${whologin == 1 }">
					<li><a href="#">정보 수정</a></li>
					<c:if test="${whologin == 1  }">
					<li><a href="<%=myCtrlCommand%>meDelete">회원 탈퇴</a></li>
					</c:if>
					<li><a href="<%=myCtrlCommand%>meLogout">로그아웃</a></li>
					</c:if>
					<c:if test="${whologin == 2  }">
					<li><a href="<%=myCtrlCommand%>meLogout">로그아웃</a></li>
					<li><a href="<%=myCtrlCommand%>meList">회원리스트</a></li>
					</c:if>
				</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">도서 목록<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">전체 도서</a></li>
					<li><a href="#">신간 도서</a></li>
					<li><a href="#">인기 도서</a></li>
				<c:if test="${whologin == 2 }">
				<li><a href="#">도서 등록</a></li>
				</c:if>	
				</ul></li>
				<c:if test="${whologin != 0}">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">나의 도서<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">대여중인 도서</a></li>
					<li><a href="#">예약한 도서</a></li>
					<li><a href="#">히스토리</a></li>
					<c:if test="${whologin == 2}">
					<li><a href="#">대여/예약도서 리스트</a></li>
					</c:if>
				</ul></li>
				</c:if>
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">커뮤니티<span class="caret"></span></a>
				<ul class="dropdown-menu">
					<li><a href="#">공지사항</a></li>
					<li><a href="#">리뷰</a></li>
					<li><a href="#">자유 게시판</a></li>
				</ul></li>
		</ul>
		<ul class="nav navbar-nav navbar-right">
					<li><c:if test="${empty sessionScope.loginfo}">
							<a href="<%=myCtrlCommand%>meLoginForm">로그인<span
								class="glyphicon glyphicon-log-in"> </span>
							</a>
						</c:if> <c:if test="${not empty sessionScope.loginfo}">
							<a href="<%=myCtrlCommand%>meLogout">로그 아웃<span
								class="glyphicon glyphicon-log-out"></span>
							</a>
						</c:if></li>
				</ul>
		</nav>
	</div>
	<c:if test="${not empty requestScope.errmsg}">
		<script type="text/javascript">
			alert('${requestScope.errmsg}');
		</script>
	</c:if>
</body>
</html>
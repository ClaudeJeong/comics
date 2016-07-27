<%@ page import="mypkg.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int twelve = 12 ; //그리드 시스템의 숫자 값
%>  
<%
	String context = request.getContextPath();
	String servPath = "/ComicsCtrl";
	String MyCtrlCommand = context + servPath +"?command=";
%>
<%
	//가정 : 현재 어플리케이션 이름이 SpringShop이고, 이미지 업로드 폴더가 upload라고 가정하면
	//웹 서버의 이미지를 올릴 경로는 다음과 같이 구한다.
	//변수 url은 여러 군데서 사용되고 있어서 사용하지 못함
	String myurl = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	int idx = myurl.indexOf(uri);

	//웹 서버의 이미지를 올릴 경로
	String imagePath = "/images/";
	String imageFolder = myurl.substring(0, idx) + context
			+ imagePath;
	
	String realPath = application.getRealPath(imagePath);
%>
<%  
	int whologin = 0;
	try{
		Member loginfo = (Member)session.getAttribute("loginfo");
		
		if(loginfo == null){
			whologin = 0; //노 접속
			}else{
				if(loginfo.getId().equals("comics")){
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
		<form class="form-inline" role="form" name="myform" action="<%=MyCtrlCommand%>bkList" method="post">
			<div class="form-group">
				<select class="form-control" name="mode2" id="mode2">
					<option value="all">---검색---
					<option value="name" selected="selected">책 제목
					<option value="writer">작가
					<option value="publisher">출판사						
				</select>
			</div>
			<div class="form-group">
				<input type="text" class="form-control" name="keyword"
										id="keyword" placeholder="Search" style="width:400px;" >
			</div>	
			<button type="submit" class="btn btn-danger"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
			
		</form>
	</div>
<div class="container-fluid" style="margin-top:20px">
<nav class="navbar navbar-inverse">
 	<div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse-1"></button>
          <a class="navbar-brand" href="main.jsp">만화 도서관</a>
    </div>
    <ul class="nav navbar-nav" style="margin-left:100px;">
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">회원
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><c:if test="${whologin == 2}">
          	<a href="<%=MyCtrlCommand%>meList">회원 리스트(관리자)</a>
          </c:if></li>
          <li><c:if test="${whologin != 0}">
          	<a href="<%=MyCtrlCommand%>meUpdateForm&id=${sessionScope.loginfo.id}">정보 수정</a>
          </c:if></li>
          <li><c:if test="${whologin == 0}">
         	 <a href="<%=MyCtrlCommand%>meFindIdPassForm">아이디/비밀번호 찾기</a>
          </c:if></li> 
          <li><c:if test="${whologin == 1}">
         	 <a href="<%=MyCtrlCommand%>meDelete" onclick="return byeMember()">회원 탈퇴</a>
          </c:if></li>
          <li><c:if test="${whologin != 0}">
          	<a href="<%=MyCtrlCommand%>meLogout">로그 아웃</a>
          </c:if></li>
        </ul>
      </li>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">도서 목록
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><a href="<%=MyCtrlCommand%>bkList">전체 도서</a></li>
          <li><a href="<%=MyCtrlCommand%>bkNewList">신간 도서</a></li>
          <li><a href="<%=MyCtrlCommand%>bkHitList">인기 도서</a></li>
          <li><c:if test="${whologin == 2}">
          	<a href="<%=MyCtrlCommand%>bkInsertForm">도서 등록(관리자)</a>
          </c:if></li>
        </ul>
      </li>
      <c:if test="${whologin == 1}">
      	<li class="dropdown">
       	 <a class="dropdown-toggle" data-toggle="dropdown" href="#">나의도서
       	 <span class="caret"></span></a>
       	  <ul class="dropdown-menu">
       	   <li><a href="<%=MyCtrlCommand%>rcPersonalList&mid=${sessionScope.loginfo.id}">대여중인 도서</a></li>
       	   <li><a href="<%=MyCtrlCommand%>rcPersonalHistory&mid=${sessionScope.loginfo.id}">히스토리</a></li> 
       	 </ul>
      	</li>
      </c:if>
      <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">커뮤니티
        <span class="caret"></span></a>
         <ul class="dropdown-menu">
          <li><a href="<%=MyCtrlCommand%>boList">공지사항</a></li>
          <li><a href="<%=MyCtrlCommand%>boReList">리뷰</a></li>
          <li><a href="<%=MyCtrlCommand%>boFreeList">자유 게시판</a></li> 
        </ul>
      </li>
      <c:if test="${whologin == 2}">
      	<li class="dropdown">
        	<a class="dropdown-toggle" data-toggle="dropdown" href="#">도서 대여
        		<span class="caret"></span></a>
         	<ul class="dropdown-menu">
          		<li><a href="<%=MyCtrlCommand%>rcManage">대여 관리(관리자)</a></li>
          		<li><a href="<%=MyCtrlCommand%>rcList">총 대여 목록(관리자)</a></li>
        	</ul>
      	</li>
      </c:if>
    </ul>
		<div class="collapse navbar-collapse" id="navbar-collapse-2">
          <ul class="nav navbar-nav navbar-right">
             <c:if test="${empty sessionScope.loginfo}">
             <li>
              <a class="btn btn-default btn-outline btn-circle collapsed" href="<%=MyCtrlCommand%>meJoinForm" aria-expanded="false">회원 가입</a>
            </li>
            </c:if>
            <c:if test="${not empty sessionScope.loginfo}">
            <li>
            <div style="margin-top:12px">
            	 <font color="white" size="3px">${sessionScope.loginfo.nickname}님 환영합니다.</font>
            </div>
            </li>
            </c:if>
            <c:if test="${empty sessionScope.loginfo}">
             <li>
              <a class="btn btn-default btn-outline btn-circle collapsed" data-toggle="collapse" href="#nav-collapse2" aria-expanded="false" aria-controls="nav-collapse2">로그인</a>
            </li>
            </c:if>
            <c:if test="${not empty sessionScope.loginfo}">
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
               <div style="margin-right: 20px;">
              <div class="form-group">
                <label class="sr-only" for="ID">ID</label>
                <input type="text" class="form-control" name="id" id="id" style="width:120px;" placeholder="id" autofocus required />
              </div>
              <div class="form-group">
                <label class="sr-only" for="Password">Password</label>
                <input type="password" class="form-control" name="password" id="password" style="width:120px;" placeholder="Password" required />
              </div>
              <button type="submit" class="btn btn-success">로그인</button>
            </div>
            </form>
           
          </ul>
          </div>
</nav>
</div>
<script type="text/javascript">
/* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
$('#mode option').each(function (index){
	if( $(this).val() == '${requestScope.mode}' ){
		$(this).attr('selected', 'selected') ;
	}
});	
/* 이전에 넣었던 값 그대로 보존 */
$('#keyword').val( '${requestScope.keyword}' ) ;	


function byeMember(){
	if(confirm("정말 탈퇴할꺼에요?ㅠㅠ")){
	var popOptions = "dialogWidth: 300px; dialogHeight: 350px; center: yes; resizable: yes; status: no; scroll: no;";
	var url='<%=MyCtrlCommand%>meDeleteForm';
	var vReturn = window.showModalDialog(url, window, popOptions);

	if (vReturn == 'ok') {
		return true;

	} else {
		return false;

	}
		}else{
			return false;
	} 
}
</script>
</body>
</html>


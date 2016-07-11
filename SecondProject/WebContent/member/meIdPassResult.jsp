<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container row clo-sm-3">
	
	<c:if test="${not empty requestScope.email}">
		${requestScope.bean.nickname}님의 아이디는 ${requestScope.bean.id} 입니다.
	</c:if>
	<c:if test="${not empty requestScope.id}">
		${requestScope.bean.id}님의 비밀번호는 ${requestScope.bean.password} 입니다.
	</c:if>
	
</div>
</body>
</html>
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
<div class="row col-sm-4">
여기가 메인입니다.<br>
메인 메인 메인
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
		 set += ',width=' + 250 + ',height=' + 100 + ',scrollbars=no,status=no,toolbar=no,resizable=no,location=no,menu=no';

		window.open(url, "mywin", set) ;
		</script>
	</c:if>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@include file="./../common/top.jsp"%>
<%
	int meoffset = 2;
	int myset = 12 - (myoffset * 2);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 보기</title>
</head>
<body>
	<div
		class="container row col-sm-offset-<%=myoffset%> col-sm-<%=myset%>">

		<div class="panel panel-default">
			<div class="panel-heading">
				<h4>회원 목록</h4>
			</div>
	<table class="table table-condensed table-hover">
		<thead>
			<tr>
				<td>아이디</td>
				<td>이름</td>
				<td>별명</td>
				<td>생일</td>
				<td>성별</td>
				<td>전화번호</td>
				<td>가입일</td>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="member" items="${requestScope.lists}">
		<tr>
			<td>${member.id}</td>
			<td>
				<a href="<%=myCtrlCommand%>meDetailView&id=${member.id}"> 
							${member.name}</a>
			</td>
			<td>${member.nickname}</td>
			<td>${member.birth}</td>
			<td>${member.gender}</td>
			<td>${member.phone1}-${member.phone2}-${member.phone3}</td>
			<td>${member.regDate}</td>
		</tr>	
		</c:forEach>
		</tbody>
	</table>
		</div>
	</div>
</body>
</html>
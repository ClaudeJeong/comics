<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="./../common/top.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
					<td colspan="10" align="center">
						<form class="form-inline" role="form" name="myform" action="<%=contextPath%>/List.bo" method="get">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="-" selected="selected">-- 선택하세요---------
									<option value="subject">아이디
									<option value="content">이름									
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
							<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<p class="form-control-static">${requestScope.pagingStatus}</p>
						</form>
					</td>
				</tr>
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
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>
		</div>	
		</div>
	</div>
</body>
</html>
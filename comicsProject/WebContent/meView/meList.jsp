<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-warning">
			<div class="panel-heading"><h4>회원 목록</h4></div>
			<table class="table table-striped table-hover">
				<thead>
				<tr>
					<td colspan="10" align="center">
						<form class="form-inline" role="form" name="myform" action="#" method="post">
							<div class="form-group">
								<select class="form-control" name="mode" id="mode">
									<option value="-" selected="selected">-- 선택하세요---------
									<option value="id">아이디
									<option value="name">이름									
								</select>
							</div>
							<div class="form-group">
								<input type="text" class="form-control btn-xs" name="keyword"
									id="keyword" placeholder="검색 키워드">
							</div>
							<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
							<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
								<p class="form-control-static">${requestScope.pagingStatus}</p>
						</form>
					</td>
				</tr>
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>닉네임</th>
						<th>성별</th>
						<th>전화번호</th>
						<th>이메일<th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr>
						<td>${bean.id}</td>
						<td>
							<a href="<%=MyCtrlCommand%>meDetailView&id=${bean.id}">
								${bean.name}
							</a>
						</td>
						<td>${bean.salary}</td>
						<td>${bean.hiredate}</td>
						<td>${bean.gender}</td>
						<td>${bean.hobby}</td>
						<td>${bean.job}</td>
						<td>${bean.address1}</td>
						<td>${bean.address2}</td>
						<td>${bean.mpoint}</td>
					</tr>
				</c:forEach>				
			</table>
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>
		</div>		
	</div>
	<c:if test="${not empty requestScope.message}">
		<script type="text/javascript">
			alert('${requestScope.message}');
		</script>
	</c:if>
</body>
</html>
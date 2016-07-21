<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootStrap Sample</title>
<style type="text/css">
/*.panel-body{ margin-bottom: -30px;}*/
.form-group {
	margin-bottom: 3px;
}
.form-control {
	height: 25px;
}
</style>
</head>
<%
	int myoffset = 1; //전체 외관의 옵셋
	int mywidth = twelve - 2 * myoffset;
	int leftside = 4; //판넬의 좌측
	int rightside = twelve - leftside; //판넬의 우측
%>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title" align="left" ><b>대여 관리</b></div>
			</div>
			<div class="panel-body">
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>">
					<table class="table table-hover table-condensed">
						<tr>
							<th>회원 정보</th>
						</tr>
						<tr>
							<td width="25%" align="center">닉네임(ID)</td>
							<td width="75%" align="left">하드코딩 대여맨</td>
						</tr>
						<tr>
							<td width="25%" align="center">이름</td>
							<td width="75%" align="left">대여네임</td>
						</tr>
						<tr>
							<td width="25%" align="center">전화 번호</td>
							<td width="75%" align="left">010-0101-0101</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-condensed table-hover">
					<thead>
						<tr>
							<td colspan="10" align="center">
								<form class="form-inline" role="form" name="myform" action="<%=MyCtrlCommand%>bkList" method="post">
									<div class="form-group">
										<select class="form-control" name="mode" id="mode">
											<option value="all" selected="selected">-- 보류---------
											<option value="name">책
											<option value="company">책2
											<option value="category">책3								
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
							<th>북코드</th>
							<th>책 제목</th>
							<th>작가</th>
							<th>대여 일자</th>
							<th>반납 예정일</th>
							<th>연체 여부</th>
						</tr>
					</thead>
					<c:forEach var="bean" items="${requestScope.lists}">
						<tr>
							<td>${bean.record.bcode}</td>
							<td>${bean.book.name}</td>
							<td>${bean.book.writer}</td>
							<td>${bean.record.lenddate}</td>
							<td>${bean.record.lenddate} + ${bean.record.period}</td>
							<td>${bean.record.period}</td>
						</tr>
					</c:forEach>			
				</table>
			</div>
			<!-- end panel-body -->
		</div>
	</div>

	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>
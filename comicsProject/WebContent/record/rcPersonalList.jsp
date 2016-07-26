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
				<div class="panel-title" align="left" ><b>${sessionScope.loginfo.nickname}님의 대여 현황</b></div>
			</div>  
			<div class="panel-body">
				<table class="table table-condensed table-hover">
					<thead>
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
							<td>${bean.bcode}</td>
							<td>${bean.bname} ${bean.volume}권</td>
							<td>${bean.writer}</td>
							<td>${bean.lenddate}</td>
							<td>${bean.duedate}</td>
							<td>${bean.overdue}일</td>
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
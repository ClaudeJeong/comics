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
	int myoffset = 2; //전체 외관의 옵셋
	int mywidth = twelve - 2 * myoffset;
	int leftside = 4; //판넬의 좌측
	int rightside = twelve - leftside; //판넬의 우측
%>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading">
				<div class="panel-title" align="left" ><b>${bean.name} ${bean.volume}권</b></div>
				&nbsp;&nbsp;&nbsp;${bean.writer}   |   ${bean.publisher}   |   ${bean.pubdate}
			</div>
			<div class="panel-body">
				<div class="col-sm-<%=leftside%> col-sm-<%=leftside%>">
					<table>
						<tr>
							<td><img src="#${bean.image}"
								class="img-circle" width="200" height="200"></td>
						</tr>
					</table>
				</div>
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>">
					<table class="table table-hover table-condensed">
						<tr>
							<td width="25%" align="center">장르</td>
							<td width="75%" align="left">${bean.genre}</td>
						</tr>
						<tr>
							<td width="25%" align="center">북코드</td>
							<td width="75%" align="left">${bean.bookcode}</td>
						</tr>
						<tr>
							<td width="25%" align="center">대여 상태</td>
							<td width="75%" align="left">${bean.bookstat}</td>
						</tr>
					</table>
				</div>
				<hr>
				<div class="col-sm-offset-5 col-sm-4">
					<button class="btn btn-default" onclick="history.back();">
						예약 하기</button>
					<button class="btn btn-default" onclick="history.back();">
						돌아 가기</button>
				</div>
			</div>
			<div class="panel-body">
				<table class="table table-hover table-condensed">
						<tr>
							<th>시리즈</th>
						</tr>
						<tr>
							<td>뭐 1권  뭐 2권</td>
						</tr>
				</table>
				<table class="table table-hover table-condensed">
						<tr>
							<th>줄거리</th>
						</tr>
						<tr>
							<td>${bean.bookstory}</td>
						</tr>
				</table>
				<table class="table table-hover table-condensed">
						<tr>
							<th>작품 리뷰</th>
						</tr>
						<tr>
							<td>재밌냐</td>
						</tr>
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
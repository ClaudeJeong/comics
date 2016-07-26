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
				<div class="panel-title" align="left" ><b>대여 상세 관리</b></div>
			</div>  
			<div class="panel-body">
				<div class="col-sm-<%=rightside%> col-sm-<%=rightside%>">
					<table class="table table-hover table-condensed">
						<tr>
							<th>회원 정보</th>
						</tr>
						<tr>
							<td width="25%" align="center">닉네임(ID)</td>
							<td width="75%" align="left">${bean.nickname}(${bean.id})</td>
						</tr>
						<tr>
							<td width="25%" align="center">이름</td>
							<td width="75%" align="left">${bean.name}</td>
						</tr>
						<tr>
							<td width="25%" align="center">성별</td>
							<td width="75%" align="left">${bean.gender}</td>
						</tr>
						<tr>
							<td width="25%" align="center">생일</td>
							<td width="75%" align="left">${bean.birth}</td>
						</tr>
						<tr>
							<td width="25%" align="center">전화 번호</td>
							<td width="75%" align="left">${bean.phone1}-${bean.phone2}-${bean.phone3}</td>
						</tr>
					</table>
				</div>
			</div>
			<div class="panel-body" align="right">
				<input type="button" value="도서 검색"
					class="btn btn-sm btn-primary" onclick="booksearch()"> 
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
							<th>반납</th>
						</tr>
					</thead>
					<c:forEach var="bean2" items="${requestScope.lists}">
						<tr>
							<td>${bean2.bcode}</td>
							<td>${bean2.bname} ${bean2.volume}권</td>
							<td>${bean2.writer}</td>
							<td>${bean2.lenddate}</td>
							<td>${bean2.duedate}</td>
							<td>${bean2.overdue}일</td>
							<td>
								<form class="form-inline" role="form" method="post" action="<%=MyCtrlCommand%>rcUpdate&mid=${bean.id}">
									<div class="form-group">
										<input type="text" hidden="hidden" name="bcode" value="${bean2.bcode}" >
									</div>
									<button type="submit" class="btn btn-xs btn-default">반납</button>
								</form>
							</td>
						</tr>
					</c:forEach>			
				</table>
			</div>
			<!-- end panel-body -->
		</div>
	</div>
	<script type="text/javascript">
		function booksearch(){
			var url='<%=MyCtrlCommand%>rcBookSearch&mid=${bean.id}';
			//var modalOptions = "dialogWidth: 600px; dialogHeight: 720px; center: yes; resizable: yes; status: no; scroll: no;";
			//window.showModalDialog(url, window, modalOptions);
			window.open(url, 'mywin', 'height=600,width=720,status=yes,scrollbars=yes,resizable=no');
		}
	</script>
	<script>
		$(document).ready(function() {
			$('[data-toggle="popover"]').popover();
		});
	</script>
</body>
</html>
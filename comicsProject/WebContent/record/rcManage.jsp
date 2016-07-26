<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootStrap Sample</title>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading"><h4>회원 목록</h4></div>
			<table class="table table-condensed table-hover">
				<thead>
					<tr>
						<td colspan="12" align="center">
							<form class="form-inline" role="form" name="myform" action="<%=MyCtrlCommand%>rcManage" method="post">
								<div class="form-group">
									<select class="form-control" name="mode" id="mode">
										<option value="all" selected="selected">-- 선택하세요---------
										<option value="nickname">닉네임
										<option value="id">아이디
										<option value="name">이름	
										<option value="phone3">핸드폰									
									</select>
								</div>
								<div class="form-group">
									<input type="text" class="form-control btn-xs" name="keyword"
										id="keyword" placeholder="검색 키워드">
								</div>
								<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
								<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 목록보기</button>
								<p class="form-control-static">${requestScope.pagingStatus}</p>
							</form>
						</td>
					</tr>					
					<tr>
						<th style="text-align: center;">닉네임(아이디)</th>
						<th style="text-align: center;">이름</th>
						<th style="text-align: center;">성별</th>
						<th style="text-align: center;">전화번호</th>
						<th style="text-align: center;">이메일</th>
						<th style="text-align: center;">생일</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
					<tr align="center">
						<td>
							<a href="<%=MyCtrlCommand%>rcManageDetail&mid=${bean.id}">${bean.nickname}(${bean.id})</a>
						</td>
						<td>${bean.name}</td>
						<td>${bean.gender}</td>
						<td>${bean.phone1}-${bean.phone2}-${bean.phone3}</td>
						<td>${bean.email1}@${bean.email2}</td>
						<td>${bean.birth}</td>
					</tr>
				</c:forEach>		
			</table>
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>
		</div>		
	</div>
	<br><br><br><br>
	<script type="text/javascript">
	   /* 방금 전 선택한 콤보 박스를 그대로 보여 주기 */ 
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		/* 이전에 넣었던 값 그대로 보존 */
		$('#keyword').val( '${requestScope.keyword}' ) ;	
		
		function search(){
			if( $('#mode').val() == 'all' ){
				alert('검색 목록을 선택해주세요') ;
			}else{
			}
		}
		function searchAll(){
			location.href='<%=MyCtrlCommand%>rcManage';
		}
	</script>	
</body>
</html>
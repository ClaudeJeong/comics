<%@page import="mypkg.model.BookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<%
	int myoffset = 1;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootStrap Sample</title>
<script type="text/javascript">
	function insertForm(){
			location.href='<%=MyCtrlCommand%>prInsertForm';
	}
	function search(){
		if( $('#mode').val() == '-' ){
			alert('검색 목록을 선택해주세요') ;
			//$('#mode').focus();
		}else{
			//alert('하하') ;
		}
		//alert( $('#mode').val() );
	}
	function searchAll(){
		//$('#mode').val('-');
		//$('#keyword').val('');
		location.href='<%=MyCtrlCommand%>bkList';
	}
</script>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading"><h4>도서 목록</h4></div>
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
						<th>표지</th>
						<th>제목</th>
						<th>작가</th>
						<th>출판사</th>
						<th>출판일</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
				<tr>
					<td>
						<img src="cinqueterre.jpg" class="img-rounded" alt="Cinque Terre" width="304" height="236">${bean.image}
					</td>
					<td>
						<a href="<%=MyCtrlCommand%>bkDetailView&bookcode=${bean.bookcode}">
								${bean.name} ${bean.volume}권
						</a>
					</td>
					<td>${bean.writer}</td>
					<td>${bean.publisher}</td>
					<td>${bean.pubdate}</td>
				</tr>
				</c:forEach>			
			</table>
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>			
		</div>		
	</div>
</body>
</html>
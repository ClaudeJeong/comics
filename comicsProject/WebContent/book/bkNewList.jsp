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
			<div class="panel-heading"><h4>신간 도서 목록</h4></div>
			<table class="table table-condensed table-hover">
				<thead>
					<tr>
						<th>표지</th>
						<th>제목</th>
						<th>작가</th>
						<th>출판사</th>
						<th>출판일</th>
						<th>대출 상태</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
				<tr>
					<td>
						<img src="<%=imageFolder%>${bean.image}" class="img-rounded" width="70" height="100">
					</td>
					<td>
						<a href="<%=MyCtrlCommand%>bkDetailView&bookcode=${bean.bookcode}&name=${bean.name}&writer=${bean.writer}">
								${bean.name} ${bean.volume}권
						</a>
					</td>
					<td>${bean.writer}</td>
					<td>${bean.publisher}</td>
					<td>${bean.pubdate}</td>
					<td>${bean.bookstat}</td>
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
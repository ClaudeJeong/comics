<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	int myoffset = 1;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading"><h2>리뷰게시판</h2></div>
			<table class="table table-condensed table-hover">
				<thead>
					<tr>
						<td colspan="10" align="center">
							<form class="form-inline" role="form" name="myform" action="<%=MyCtrlCommand%>boReList" method="post">
								<input type="hidden" name="command" value="boReList">
								<div class="form-group">
									<select class="form-control" name="mode" id="mode">
										<option value="all" selected="selected">---선택하세요---
										<option value="subject">제목
										<option value="writer">글쓴이
										<option value="content">내용								
									</select>
								</div>
								<div class="form-group">
									<input type="text" class="form-control btn-xs" name="keyword"
										id="keyword" placeholder="검색 키워드">
								</div>
								<button class="btn btn-default btn-warning" type="submit" onclick="search();">검색</button>
								<button class="btn btn-default btn-warning" type="button" onclick="searchAll();">전체 검색</button>
								<button class="btn btn-default btn-info" type="button"
									onclick="writeForm();">글 쓰기</button>
									&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<p class="form-control-static">${requestScope.pagingStatus}</p>
							</form>
						</td>
					</tr>
					<tr>
						<th>이미지</th>
						<th>내용</th>
						<th>제목</th>
						<th>작성자</th>
						<th>등록일</th>
					</tr>
				</thead>
				<c:forEach var="bean" items="${requestScope.lists}">
				<tr>
					<td width="20%">
						<img src="<%=imageFolder%>${bean.image}" class="img-rounded" width="120" height="120">
					</td>
					<td>
							${bean.content}
					</td>
					<td>
								${bean.subject}
					</td>
					<td>${bean.writer}</td>
					<td>${bean.regDate}</td>
				</tr>
				</c:forEach>			
			</table>
		</div>
		<div align="center">
			<footer>${requestScope.pagingHtml}</footer>			
		</div>		
	</div>
	<script type="text/javascript">
		$('#mode option').each(function (index){
			if( $(this).val() == '${requestScope.mode}' ){
				$(this).attr('selected', 'selected') ;
			}
		});	
		
		$('#keyword').val( '${requestScope.keyword}' ) ;
		
		function search(){
			if( $('#mode').val() == 'all' ){
				alert('검색 목록을 선택해주세요') ;
			}
		}
		
		function searchAll(){
			location.href='<%=MyCtrlCommand%>boReList';
		}
		
		function writeForm(){
			location.href='<%=MyCtrlCommand%>boReWriteForm&boardtype=${requestScope.boardtype}';
		}
	</script>
</body>
</html>
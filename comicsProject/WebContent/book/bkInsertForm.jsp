<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 2 ;
	int formright = twelve - formleft ; 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BootStrap Sample</title>
	<style type="text/css">
		.form-group{ margin-bottom : 3px; }
	</style>
</head>
<body>
	<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default">
			<div class="panel-heading"><h4>도서 등록</h4></div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=MyCtrlCommand%>bkInsert" 
				name="bkInsert" id="bkInsert" method="post">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="name">도서명</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="name" id="name"								
								placeholder="도서명" value="우리들의 일그러진 영웅 만화판">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="pubdate">권</label>
						<div class="col-sm-2">
							<input type="number" class="form-control" name="volume"
								id="volume" placeholder="권" value="1">
						</div>
						<label class="control-label col-sm-<%=formleft%>" for="pubdate">출판일</label>
						<div class="col-sm-3">
							<input type="date" class="form-control" name="pubdate"
								id="pubdate" placeholder="출판일" value="2015/05/05">
						</div>
						<div class="col-sm-3">
							<button type="button" class="btn btn-default" onclick="btn1();">추가</button>
						</div>
					</div>	
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="company">작가</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="writer" id="writer"								
								placeholder="작가" value="이문열">
						</div>
					</div>					
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="publisher">출판사</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="publisher" id="publisher" 
								placeholder="출판사" value="창훈컴퍼니">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="genre">장르</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="genre"
								id="genre" placeholder="장르" value="스릴 서스펜스">
						</div>
					</div>			
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="bookstory">줄거리</label>
						<div class="col-sm-<%=formright%>">
							<textarea name="bookstory" id="bookstory" rows="5" cols="" 
								placeholder="줄거리" class="form-control">엄석대가 사실은!!!</textarea>								
						</div>
					</div>					
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-default" type="submit">도서 등록</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">뒤로 가기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
	<script>
		$(document).ready(function(){
    		$('[data-toggle="tooltip"]').tooltip();
		});
	</script>
	
</body>
</html>
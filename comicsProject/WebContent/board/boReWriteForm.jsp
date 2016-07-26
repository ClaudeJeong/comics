<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int myoffset = 2;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3 ;
	int formright = twelve - formleft ; 
%>
<%
	String contextPath = request.getContextPath() ; //현재 진행 중인 프로젝트 이름 
	String CommandName = "/ComicsCtrl"  ; //요청을 위한 url 패턴 이름
	String MyCtrlByForm = contextPath +  CommandName ; //폼이 있는 경우에 사용된다. 
%>
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
			<div class="panel-heading"><h4>리뷰 등록</h4></div>
			<div class="panel-body">
				<form class="form-horizontal" role="form" action="<%=MyCtrlByForm%>" method="post" enctype="multipart/form-data">
					<input type="hidden" name="command" value="boReWrite">
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="subject">제목</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="subject" id="subject"								
								placeholder="제목">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="image">이미지</label>
						<div class="col-sm-<%=formright%>">
							<input type="file" class="form-control" name="image"
								id="image">
						</div>
					</div>
					<br>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="stock">분류</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="boardtype"
								id="boardtype" readonly="readonly" value='리뷰'>
						</div>
					</div>
					<br>	
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="stock">작성자</label>
						<div class="col-sm-<%=formright%>">
							<input type="text" class="form-control" name="writer"
								id="writer" readonly="readonly" value='${sessionScope.loginfo.nickname}'>
						</div>
					</div>	
					<br>
					<div class="form-group">
						<label class="control-label col-sm-<%=formleft%>" for="contents">리뷰</label>
						<div class="col-sm-<%=formright%>">
							<textarea name="content" id="content" rows="20" 
								placeholder="리뷰를 써주세요" class="form-control">   								
							</textarea>								
						</div>
					</div>	
					<div class="form-group">
						<div align="center" class="col-sm-offset-3 col-sm-6">
							<button class="btn btn-default" type="submit">등록하기</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<button class="btn btn-default" type="reset">취소</button>
						</div>
					</div>				
				</form>
			</div>
		</div>
	</div>
</body>
</html>
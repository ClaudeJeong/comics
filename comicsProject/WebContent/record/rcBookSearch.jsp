<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	int twelve = 12;
	int myoffset = 3;
	int mywidth = twelve - 2 * myoffset;
	int formleft = 3;
	int formright = twelve - formleft;
%>
<%
	String contextPath = request.getContextPath(); //현재 진행 중인 프로젝트 이름 
	String CommandName = "/ComicsCtrl"; //요청을 위한 url 패턴 이름
	String MyCtrlCommand = contextPath + CommandName + "?command=";
%>
<!DOCTYPE html>
<html>
<head>
<base target="_self">
<title>우편번호 검색</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript">
function mybooksearch() {
	var finddata = document.myform.name.value;
	if(finddata.length < 2){
		alert('책 이름을 2글자 이상 입력해 주세요');
		document.myform.name.focus();
		return false;
	}
	var url = '<%=MyCtrlCommand%>rcBookSearch';
	//self.location.assign(url);
	window.open(url, 'mywin', 'height=150,width=300') ;
	
}
function selfClose() {
		self.close();
		
}
</script>	
</head>
<body>
<div class="container col-sm-offset-<%=myoffset%> col-sm-<%=mywidth%>">
		<div class="panel panel-default panel-info" style="margin-top:30px">
			<div class="panel-heading">도서 검색</div>
			<div class="panel-body">
				<form name="myform" class="form-inline" role="form" method="post">
					<table class="table table-striped table-hover table-condensed">
						<tr>
							<td colspan="2" align="center">
								<p class="form-control-static">책 이름 입력 :</p>

								<div class="form-group">
									<input type="text" class="form-control" name="name" id="name"
										placeholder="찾을 책 이름   예)명탐정 코난">
								</div>
								<button class="btn btn-default" type="submit" onclick="mybooksearch()">검색</button>
							</td>
						</tr>
						<c:forEach items="${lists}" var="oneitem">
							<c:set var="bookname"
								value="${fn:trim(oneitem.name)} ${fn:trim(oneitem.volume)}권" />
							<tr>
								<td width="60%" align="center">${bookname}</td>
								<td width="20%" align="left">${oneitem.bookstat}</td>
								<td width="20%" align="left">
									<c:if test="${oneitem.bookstat == '대출 가능'}">
										<form class="form-inline" role="form" method="post" action="<%=MyCtrlCommand%>rcInsert">
										<div class="form-group">
											<input type="text" hidden="hidden" name="bcode" value="${oneitem.bookcode}" >
											<input type="text" hidden="hidden" name="mid" value="${param.mid}" >
										</div>
										<button type="submit" class="btn btn-xs btn-default" onclick="selfClose()">대여</button>
										</form>									
									</c:if>
								</td>
							</tr>
						</c:forEach>
					</table>
				</form>
				<div class="row" align="center">
					<button class="btn btn-primary" type="button" onclick="selfClose()">
						닫&nbsp;&nbsp;기</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
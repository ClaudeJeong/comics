<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int meoffset = 2;
	int mywidth = twelve - 2 * meoffset;
%>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">	
	<title>BootStrap</title>
	<style type="text/css">
		/*.panel-body{ margin-bottom: -30px;}*/
	</style>
</head>
<body>
	<div class="container col-md-offset-<%=meoffset%> col-md-<%=mywidth%>" align="right">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h1 class="panel-title" align="left">회원 정보 상세 보기</h1>
			</div>
			<div class="panel-body" align="left">
				<div class="col-md-12">
					<table class="table table-condendes table-striped" >
						<tr>
							<td width="25%">아이디</td>
							<td width="75%">${bean.id}</td>
						</tr>
						<tr>
							<td width="25%">이름</td>
							<td width="75%">${bean.name}</td>
						</tr>		
						<tr>
							<td width="25%">별병</td>
							<td width="75%">${bean.nickname}</td>
						</tr>
						<tr>
							<td width="25%">이메일</td>
							<td width="75%">${bean.email1}${bean.email2}</td>
						</tr>
						<tr>
							<td width="25%">생일</td>
							<td width="75%">${bean.birth}</td>
						</tr>
						<tr>
							<td width="25%">성별</td>
							<td width="75%">${bean.gender}</td>
						</tr>
						<tr>
							<td width="25%">전화번호</td>
							<td width="75%">${bean.phone1}-${bean.phone2}-${bean.phone3}</td>
						</tr>
						<tr>
							<td width="25%">우편번호</td>
							<td width="75%">${bean.zipCode}</td>
						</tr>
						<tr>
							<td width="25%">주소</td>
							<td width="75%">${bean.address1}</td>
						</tr>	
						<tr>
							<td width="25%">세부 주소</td>
							<td width="75%">${bean.address2}</td>
						</tr>
						<tr>
							<td width="25%">가입일</td>
							<td width="75%">${bean.regDate}</td>
						</tr>	
					</table>				
				</div>
				<hr>
				<div class="col-md-offset-5 col-md-4">
					<button class="btn btn-primary" onclick="history.back();">돌아 가기</button>
				</div>
			</div><!-- end panel-body -->
		</div>		
	</div>		
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<% 
	String message = (String)request.getAttribute("message");
	String gotochange = (String)request.getAttribute("gotochange");
	String id = (String)request.getAttribute("id");
	String name = (String)request.getAttribute("name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.colorgraph {
  height: 5px;
  border-top: 0;
  background: #c4e17f;
  border-radius: 5px;
  background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
  background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>아이디 비번찾기</title>
</head>
<body>
<div class="container">
<div class="row" style="margin-top:20px;">
    <div class="col-sm-4 col-sm-offset-4">
		<form role="form" action="<%=MyCtrlCommand%>meFindId" method="post">
			<fieldset>
				<h3>아이디 찾기</h3>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="text" name="name" id="name" class="form-control input-lg" placeholder="이름을 입력하세요">
				</div>
				<div class="form-group">
                    <input type="text" name="email" id="email" class="form-control input-lg" placeholder="등록한 메일주소를 입력하세요">
				</div>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-md btn-success btn-block" value="아이디찾기">
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	
</div>
</div>
<div class="container">
<div class="row" style="margin-top:20px;">
    <div class="col-sm-4 col-sm-offset-4">
		<form role="form" action="<%=MyCtrlCommand%>meFindPassword" method="post" name="myform" id="myform">
			<fieldset>
				<h3>비밀번호 찾기</h3>
				<hr class="colorgraph">
				<div class="form-group">
                    <input type="text" name="id" id="id" class="form-control input-lg" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
                    <input type="text" name="name2" id="name2" class="form-control input-lg" placeholder="이름을 입력하세요">
				</div>
				<hr class="colorgraph">
				<div class="row">
					<div class="col-xs-6 col-sm-6 col-md-6">
                        <input type="submit" class="btn btn-md btn-success btn-block" value="비밀번호 찾기">
					</div>
				</div>
			</fieldset>
		</form>
	</div>
	<div>
</div>
</div>
<input type="hidden" value="<%=message%>" id="message" name="message">
<input type="hidden" value="<%=gotochange%>" id="gotochange" name="gotochange">
<input type="hidden" value="<%=id%>" id="passid" name="passid">
<input type="hidden" value="<%=name%>" id="passname" name="passname">
<c:if test="${not empty requestScope.message}">
		<script type="text/javascript">
		var url = './common/message.jsp';
		var sw  = screen.availWidth ;
		var sh  = screen.availHeight ;
		var px=(sw - 150)/2 ;
		var py=(sh - 100)/2 ;
		var set  = 'top=' + py + ',left=' + px ;
		 set += ',width=' + 150 + ',height=' + 100 + ',scrollbars=no,status=no,toolbar=no,resizable=no,location=no,menu=no';

		window.open(url, "mywin", set) ;
		</script>
	</c:if>
	<c:if test="${not empty requestScope.gotochange}">
		<script type="text/javascript">
		var url = './meView/meChangePassForm.jsp';
		var sw  = screen.availWidth ;
		var sh  = screen.availHeight ;
		var px=(sw - 500)/2 ;
		var py=(sh - 600)/2 ;
		var set  = 'top=' + py + ',left=' + px ;
		 set += ',width=' + 500 + ',height=' + 600 + ',scrollbars=no,status=no,toolbar=no,resizable=no,location=no,menu=no';
		
		 var args = { 'id' : $("#passid").val(), 'name' : $("#passname").val() }; 
		window.showModalDialog(url, args, set);
		</script>
	</c:if>
</body>
</html>
<%@page import="mypkg.model.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<% 
	Board bean = (Board)request.getAttribute("bean");
	String con = bean.getContent();
	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="./editor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript" src="//cdnjs.cloudflare.com/ajax/libs/jquery/1.9.0/jquery.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container col-sm-offset-1 col-sm-10" style="margin-top: 50px;">
 <form id="myform" name="myform" action="<%=MyCtrlCommand%>boNoticeUpdate&no=${bean.no}&boardtype=${bean.boardType}&${requestScope.parameters}" method="post" class="form-horizontal" role="form">
    <div class="form-group">
      <label class="control-label col-sm-2" for="email">제목:</label>
      <div class="col-sm-10">
        <input class="form-control" style="width: 70%;" type="text" id="subject" name="subject"
				placeholder="제목을 입력하세요" value="${bean.subject}">
				
				
      </div>
    </div>
    <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">작성자:</label>
      <div class="col-sm-10 form-inline">          
				 <input class="form-control" style="width: 20%;" type="text" id="writer" name="writer"
				readonly="readonly" value="${bean.writer}">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>분류:</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				 <input class="form-control" style="width: 20%;" type="text" id="boardtype" name="boardtype"
				readonly="readonly" value="${bean.boardType}">
      </div>
      
      </div>
       <div class="form-group">
      <label class="control-label col-sm-2" for="pwd">내용:</label>
      <div class="col-sm-10">          
         <textarea rows="10" cols="30" id="content" name="content" style="width:900px; height:612px; "></textarea>
      </div>
      </div>
    </div>
     <div class="form-group">
      <div class="col-sm-10" align="center" style="margin-left: 145px; margin-top:10px;">          
         <input class="btn btn-info  btn-md" type="button" id="save" name="save" value="수정하기">
         &nbsp;&nbsp;&nbsp;
		<input class="btn btn-info  btn-md" type="button" value="취소하기" onclick="history.back()">
      </div>
      </div>
<script type="text/javascript">
var oEditors = [];
$(function(){
					nhn.husky.EZCreator.createInIFrame({
						oAppRef: oEditors,
						elPlaceHolder: "content",
						//SmartEditor2Skin.html 파일이 존재하는 경로
						sSkinURI: "./editor/SmartEditor2Skin.html",	
						htParams : {
							// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseToolbar : true,				
							// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
							bUseVerticalResizer : true,		
							// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
							bUseModeChanger : true,			
							fOnBeforeUnload : function(){
								
							}
						}, 
						fOnAppLoad : function(){
							//기존 저장된 내용의 text 내용을 에디터상에 뿌려주고자 할때 사용
							oEditors.getById["content"].exec("PASTE_HTML", ['<%=con%>']);
						},
						fCreator: "createSEditor2"
					});
					$("#save").click(function(){
						if($('#subject').val().length == 0){
							alert("제목을 입력해주세요");
						}else{
							oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);
							$("#myform").submit();
						}
						
					})

});
</script>
</body>
</html>
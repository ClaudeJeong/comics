<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./../common/top.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int totalGrid = 12;
	int myOffset = 3;
	int mySetGrid = totalGrid - (myOffset * 2);
%>
<html>
<head>
<meta name = "viewport" content = "width=device-width, initial-scale = 1">
<link rel = "stylesheet" href = "ui/jquery.mobile-1.2.0.min.css" />
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<style type="text/css">
.colorgraph {
	height: 5px;
	border-top: 0;
	background: #c4e17f;
	border-radius: 5px;
	background-image: -webkit-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -moz-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%,
		#f7fdca 25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%,
		#db9dbe 50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%,
		#669ae1 87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: -o-linear-gradient(left, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
	background-image: linear-gradient(to right, #c4e17f, #c4e17f 12.5%, #f7fdca 12.5%, #f7fdca
		25%, #fecf71 25%, #fecf71 37.5%, #f0776c 37.5%, #f0776c 50%, #db9dbe
		50%, #db9dbe 62.5%, #c49cde 62.5%, #c49cde 75%, #669ae1 75%, #669ae1
		87.5%, #62c2e4 87.5%, #62c2e4);
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="row col-sm-offset-<%=myOffset%> col-sm-<%=mySetGrid%>"
		style="margin-top: 30px;">
		<form action="<%=MyCtrlCommand%>meJoin" name="form" id="form" method="post">
		<input type="hidden" id="falseid" name="falseid" value="false">
		<input type="hidden" id="falsename" name="falsename" value="false">
		<input type="hidden" id="falsepass" name="falsepass" value="false">
		<input type="hidden" id="falserepass" name="falserepass" value="false">
		<input type="hidden" id="falsenickname" name="falsenickname" value="false">
		<input type="hidden" id="falsephone2" name="falsephone2" value="false">
		<input type="hidden" id="falsephone3" name="falsephone3" value="false">
			<div class="panel">
				<div class="panel-body">
					<div style="margin-top: -10px;">
						<hr class="colorgraph">
					</div>
					
						<div class="form-inline">
						<input type="text" class="form-control"
							style="border-color: black; width: 30%;" placeholder="아이디"
							name="id1" id="id1">
							&nbsp;&nbsp;
							<span id="idcheck"></span>
						</div>
					<br>
					
					<div class="form-inline">
						<input type="text" class="form-control"
							style="border-color: black; width: 30%;" placeholder="이름"
							name="name" id="name">
							&nbsp;&nbsp;
							<span id="namecheck"></span>
					</div>
					<br>
					
					<div class="form-inline">
						<input type="password" class="form-control"
							style="border-color: black; width: 30%;" placeholder="비밀번호"
							name="password1" id="password1">
							&nbsp;&nbsp;
							<span id="passwordcheck"></span>
					</div>
					<br>
					
					<div class="form-inline">
						<input type="password" class="form-control"
							style="border-color: black; width: 30%;" placeholder="비밀번호확인"
							name="repassword" id="repassword">
							&nbsp;&nbsp;
							<span id="repasswordcheck"></span>
					</div>
					<br>
					<div class="form-inline">
						<input type="text" class="form-control"
							style="border-color: black; width: 30%;" placeholder="닉네임"
							name="nickname" id="nickname">
							&nbsp;&nbsp;
							<span id="nicknamecheck"></span>
					</div>
					
					<br>
					<div class="form-inline">
						<input type="text" class="form-control"
							style="border-color: black; width: 30%;" placeholder="생일입력"
							name="birth" id="birth" readonly="readonly">
							&nbsp;&nbsp;
							<span id="birthcheck"></span>
					</div>
					
					<div style="margin-bottom: -10px;">
						<hr class="colorgraph">
					</div>
					
					<div class="form-inline">
						<input type="radio" class="radio-inline" id="gender" name="gender"
							value="남자">남자 
						<input type="radio" class="radio-inline"
							id="gender" name="gender" value="여자">여자
							&nbsp;&nbsp;
							<span id="gendercheck"></span>
					</div>
					<br>
					
					<div class="form-inline">
						<input type="text" class="form-control"
							style="border-color: black; width: 15%;" placeholder="이메일"
							name="email1" id="email1"> &nbsp;@&nbsp; 
							<select
							class="form-control" id="email2" name="email2"
							style="border-color: black;" onchange="changeEmail()">
							<option value="all">선택하세요
							<option value="naver.com">naver.com
							<option value="gmail.com">gmail.com
							<option value="daum.net">daum.net
							<option value="selfwrite">직접입력
						</select>
						<input type="text" class="form-control" style="border-color: black; width: 15%; display: none"
							name="email3" id="email3">
							<span id="emailcheck"></span>
					</div>
					<br>
					<div class="form-inline">
						<input type="text" size="5" class="form-control" id="phone1"
							name="phone1" value="010" style="border-color: black;"> -
						<input type="text" size="5" class="form-control" id="phone2"
							name="phone2" style="border-color: black;"> - <input
							type="text" size="5" class="form-control" id="phone3"
							name="phone3" style="border-color: black;">
							&nbsp;&nbsp;
							<span id="phonecheck"></span>
					</div>
					<br>
					
					<div class="form-inline">
						<input type="text" size="8" class="form-control" id="zipcode"
							name="zipcode" style="border-color: black;"
							placeholder="우편번호" readonly="readonly">
							&nbsp;&nbsp;&nbsp; 
							<input type="button" value="우편번호 찾기"
							class="btn btn-sm btn-primary" onclick="zipCheck()"> 
							<span id="zipcodecheck"></span>
					</div>
					<br>
					
					<div class="form-inline">
						<input type="text" size="40%" class="form-control"
							id="address1" name="address1"
							style="border-color: black;" readonly="readonly" placeholder="주소">
							<span id="address1check"></span>
					</div>
					<br>
					
					<div class="form-inline">
						<input type="text" size="40%" class="form-control" id="address2"
							name="address2" placeholder="상세주소" style="border-color: black;">
					</div>
					&nbsp;&nbsp;
							<span id="address2check"></span>
					<div style="margin-bottom: -10px;">
						<hr class="colorgraph">
					</div>
				
				</div>
			</div>
			<div class="row col-sm-offset-6">
				<div class="form-group">
					<button type="submit" class="btn btn-success btn-lg" onclick="return finallCheck();">가입하기</button>
				</div>
				</div>
		</form>
	</div>
<script type="text/javascript">
function changeEmail(){
	if(document.form.email2.value == "selfwrite"){
	document.form.email3.style.visibility='visible';
	document.form.email3.style.display=''
	document.form.email2.style.visibility='hidden';
	document.form.email2.style.display='none';
	document.form.email3.focus();
}
}

function zipCheck(){
	var url='<%=MyCtrlCommand%>meZipCheck';
	//var modalOptions = "dialogWidth: 600px; dialogHeight: 720px; center: yes; resizable: yes; status: no; scroll: no;";
	//window.showModalDialog(url, null, modalOptions);
	window.open(url, 'mywin', 'height=600,width=720,status=yes,scrollbars=yes,resizable=no');
}
$(document).ready(function() {
	var reg = "";
	$('#id1').keyup(function() {
		if ( $('#id1').val().length < 4 || $('#id1').val().length > 11 ) {
			$('#idcheck').html("<span class='alert-danger'>4글자 이상 10글자 이하로 입력하세요</span>");
			$("#falseid").val(false);
	}else{
		reg=/^[a-zA-Z0-9]*$/;
		if($('#id1').val().search(reg) == -1){
			$('#idcheck').html("<span class='alert-danger'>영문과 숫자로만 입력하세요</span>");
			$("#falseid").val(false);
		}else{
			$.ajax({
				type : "post",
				url : "<%=MyCtrlCommand%>meIdCheck",
				dataType : "JSON",
				data : {
					"id1" : $("#id1").val(),
				},
				success : function(result) {
					if(result.check) {
						$("#idcheck").html("<span class='alert-success'>사용 가능한 아이디입니다.</span>");
						$("#falseid").val(true);
					} else {
						$("#idcheck").html("<span class='alert-danger'>이미 사용중인 아이디입니다</span>");
						$("#falseid").val(false);
					}
				
				}
			});
			
		}
	}
});
});

$(document).ready(function() {
	$('#name').keyup(function() {
		if ($('#name').val().length < 2 || $('#name').val().length > 11) {
		$('#namecheck').html("<span class='alert-danger'>2글자 이상 10글자 이하 입력하세요</span>");
		$("#falsename").val(false);
	}else{
		var reg=/^[가-힣]+$/;
		if($('#name').val().search(reg) == -1){
			$('#namecheck').html("<span class='alert-danger'>공백없이 한글만 입력하세요</span>");
			$("#falsename").val(false);
		}else{
			$('#namecheck').html("<span class='alert-danger'> </span>");
			$("#falsename").val(true);
		}
		
	}
});
});
	
$(document).ready(function() {	
	$('#password1').keyup(function() {
		if ( $('#password1').val().length < 6 || $('#password1').val().length > 16 ) {
		$('#passwordcheck').html("<span class='alert-danger'>6글자 이상 15글자 이하로 입력하세요</span>");
		$("#falsepass").val(false);
		}else{
		$('#passwordcheck').html("<span class='alert-danger'> </span>");
		$("#falsepass").val(true);
}
});
});
	
$(document).ready(function() {	
	$('#repassword').keyup(function() {
		if ($('#password1').val() == $('#repassword').val() ) {
			$('#repasswordcheck').html("<span class='alert-danger'> </span>");
			$("#falserepass").val(true);
		}else{
			$('#repasswordcheck').html("<span class='alert-danger'>다시 한 번 비밀번호를 입력하세요</span>");
			$("#falserepass").val(false);
}
});
});

$(document).ready(function() {
	$('#nickname').keyup(function() {
		if ( $('#nickname').val().length < 2 || $('#nickname').val().length > 11 ) {
			$('#nicknamecheck').html("<span class='alert-danger'>2글자 이상 10글자 이하로 입력하세요</span>");
			$("#falsenickname").val(false);
	}else{
		var reg=/^[^\s]+$/;
		if($('#nickname').val().search(reg) == -1){
			$('#nicknamecheck').html("<span class='alert-danger'>공백안대여</span>");
			$("#falsenickname").val(false);
		}else{
			$.ajax({
				
				type : "post",
				url : "<%=MyCtrlCommand%>meNickNameCheck",
				dataType : "JSON",
				data : {
					"nickname" : $("#nickname").val(),
				},
				success : function(result) {
					if(result.check) {
						$("#nicknamecheck").html("<span class='alert-success'>사용 가능한 닉네임입니다</span>");
						$("#falsenickname").val(true);
					} else {
						$("#nicknamecheck").html("<span class='alert-danger'>이미 사용중인 닉네임입니다</span>");
						$("#falsenickname").val(false);
					}
				
				}
			});
			
		}
	}
		
	});

});

$(document).ready(function() {
	$('#email1').keyup(function() {
		if($('#email1').val().length < 4 || $('#email1').val().length > 12){
				$('#emailcheck').html("<span class='alert-danger'>4자 이상 12자 이하로 입력하세요</span>");
		}else{
			var reg =/^[a-zA-Z0-9]*$/;
			if($('#email1').val().search(reg) == -1){
				$('#emailcheck').html("<span class='alert-danger'>영문과 숫자로만 입력하세요</span>");
			}else{
				$('#emailcheck').html("<span class='alert-danger'></span>");
			}
			
		}
	
});
	});
	
$(document).ready(function() {
	$('#email3').keyup(function() {
		if($('#email3').val().length < 4 || $('#email3').val().length > 11){
				$('#emailcheck').html("<span class='alert-danger'>4자 이상 10자 이하로 입력하세요</span>");
		}else{
			var reg =/^[a-zA-Z0-9-]+(\.[com|net]+)$/;
			if($('#email3').val().search(reg) == -1){
				$('#emailcheck').html("<span class='alert-danger'>영문, 숫자, 이메일 형식으로 쓰세요</span>");
			}else{
				$('#emailcheck').html("<span class='alert-danger'></span>");
			}
			
		}
	
});
	});	

$(document).ready(function() {	
	$('#phone2').keyup(function() {
		reg=/^\d{3,4}$/;
		if($('#phone2').val().length == 0 || $('#phone2').val().search(reg) == -1 ){
			$('#phonecheck').html("<span class='alert-danger'>숫자를 입력해 주세요</span>");
			$("#falsephone2").val(false);
		}else{
			$('#phonecheck').html("<span class='alert-danger'> </span>");
			$("#falsephone2").val(true);
		}

});
});

$(document).ready(function() {	
	$('#phone3').keyup(function() {
		reg=/^\d{4}$/;
		if($('#phone3').val().search(reg) == -1){
			$('#phonecheck').html("<span class='alert-danger'>숫자를 입력해 주세요</span>");
			$("#falsephone3").val(false);
		}else{
				$('#phonecheck').html("<span class='alert-danger'> </span>");
				$("#falsephone3").val(true);
		}	
});
});

function finallCheck(){
	var falseid = document.form.falseid.value;
	var falsepass = document.form.falsepass.value;
	var falserepass = document.form.falserepass.value;
	var falsename = document.form.falsename.value;
	var falsenickname = document.form.falsenickname.value;
	var falsephone2 = document.form.falsephone2.value;
	var falsephone3 = document.form.falsephone3.value;
	if(falseid == "true" && falsepass == "true" && falserepass == "true" && falsename == "true" && falsenickname == "true" && falsephone2 == "true" && falsephone3 == "true"){
	    var gender = document.form.gender ;
        if( gender[0].checked == true || gender[1].checked == true ){
        	$('#gendercheck').html("<span class='alert-danger'></span>");
        }else{
        	$('#gendercheck').html("<span class='alert-danger'>성별을 하나 선택하세요</span>");
        	return false;
        }
		var address2 =  document.form.address2.value;
		var zipcode =  document.form.zipcode.value;
		//alert(zipcode);
		if(zipcode.length == 0){
			//alert("여기집코드");
			$('#zipcodecheck').html("<span class='alert-danger'>우편번호를 검색해 주세요</span>");
			$('#address1check').html("<span class='alert-danger'>주소를 검색해 주세요</span>");
			return false;
		}else{
			$('#zipcodecheck').html("<span class='alert-danger'></span>");
			$('#address1check').html("<span class='alert-danger'></span>");
		}	
		if(address2.length == 0){
			$('#address2check').html("<span class='alert-danger'>상세주소를 입력해 주세요</span>");
			return false;
		}else{
			$('#address2check').html("<span class='alert-danger'></span>");
		}
		var password =  document.form.password1.value;
		var repassword =  document.form.repassword.value;
		//alert(zipcode);
		if( password != repassword){
			alert("비밀번호 다시 확인 해 주세요");
			return false;
		}
	}else{
		alert("제대로 입력하시지 말입니다");
		return false;
	}
		return true;
}
	
</script>

<script language = "javascript" type = "text/javascript">
$(document).ready(function() {
  var clareCalendar = {
   monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
   dayNamesMin: ['일','월','화','수','목','금','토'],
   weekHeader: 'Wk',
   dateFormat: 'yy/mm/dd', //형식(20120303)
   autoSize: false, //오토리사이즈(body등 상위태그의 설정에 따른다)
   changeMonth: true, //월변경가능
   changeYear: true, //년변경가능
   showMonthAfterYear: true, //년 뒤에 월 표시
   buttonImageOnly: true, //이미지표시
   buttonText: '달력선택', //버튼 텍스트 표시
   buttonImage: './images/cale_bg.jpg', //이미지주소
   showOn: "both", //엘리먼트와 이미지 동시 사용(both,button)
   yearRange: '1950:2016' //1950년부터 2016년까지
  };
  $("#birth").datepicker(clareCalendar);
  $("img.ui-datepicker-trigger").attr("style","margin-left:5px; vertical-align:middle; cursor:pointer;"); //이미지버튼 style적용
  $("#ui-datepicker-div").hide(); //자동으로 생성되는 div객체 숨김  
 });
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method=POST action="test.php" name=form0 enctype="multipart/form-data">
<input name="m_email_1" type="text" size="10" style="border-width:1px; border-color:rgb(204,204,204); border-style:solid;"><span style="font-size:10pt;">@</span><input name="m_email_2" type="text" class="1border" size="10"  style="border-width:1px; border-color:rgb(204,204,204); border-style:solid;">

  <select name="lstMail"  onchange="document.form0.m_email_2.focus();document.form0.m_email_2.value=document.form0.lstMail[document.form0.lstMail.selectedIndex].value;">
    <option value=""> - 직접입력 - </option>
    <option value="hanmail.net">hanmail.net</option>
    <option value="lycos.co.kr">lycos.co.kr</option>
    <option value="yahoo.co.kr">yahoo.co.kr</option>
    <option value="hotmail.com">hotmail.com</option>
    <option value="netian.com">netian.com</option>
    <option value="hanmir.com">hanmir.com</option>
    <option value="unitel.co.kr">unitel.co.kr</option>
    <option value="dreamwiz.com">dreamwiz.com</option>
    <option value="naver.com">naver.com</option>
    <option value="hitel.net">hitel.net</option>
    <option value="freechal.com">freechal.com</option>
    <option value="kebi.com">kebi.com</option>
    <option value="empal.com">empal.com</option>
    <option value="hanafos.com">hanafos.com</option>
    <option value="paran.com">paran.com</option>
</select>
</form>

<input id="email2" name="email2" value="" style="width: 92px; display: none;" type="text">
<select id="email3" name="email3" style="width: 100px;">
<option value="">naver.com
</select>
<input name="umail_direct" id="umail_direct" value="1" maxlength="30" type="checkbox">직접입력

<form name="form" method="post">
<input name="email1" type="text" class="box" id="email1" size="15"> @ <input name="email2" type="text" class="box" id="email2" size="20">
<select name="email_select" class="box" id="email_select" onChange="checkemailaddy();">
    <option value="" selected>선택하세요</option>
    <option value="naver.com">naver.com</option>
    <option value="hotmail.com">hotmail.com</option>
    <option value="hanmail.com">hanmail.com</option>
    <option value="yahoo.co.kr">yahoo.co.kr</option>
    <option value="1">직접입력</option>
</select>
</form>

<div>
<form name=fom method=post action="">

<SELECT name=email2 onchange="email_chk()"> 
<OPTION>선택하세요</OPTION> 
<OPTION value="daum.net">다음</OPTION> 
<OPTION value="hanmail.net">한메일</OPTION> 
<OPTION value="nate.com">네이트</OPTION>
<OPTION value="직접입력">기타[직접입력]</OPTION>
</SELECT> 


<INPUT class=input style="DISPLAY: none" size=15 name=email3>

</form>   
</div>
<script language="javascript">
function email_chk() {
if(document.fom.email2.value=="직접입력"){
document.fom.email3.style.visibility='visible'; 
document.fom.email3.style.display=''
document.fom.email2.style.visibility='hidden'; 
document.fom.email2.style.display='none';
document.fom.email3.focus();
}
}
</script>


<script type="text/javascript">
$(document).ready(function() {
 if($('#email3').val() == ""){
  $('#email2').css('display', '');
  $('#email3').css('display', 'none');
  $('#umail_direct').attr('checked','checked')
 }
 $('#umail_direct').click(function(){
  if(this.checked == true){
   $('#email2').css('display', '');
   $('#email3').css('display', 'none');
  }else{
   $('#email2').css('display', 'none');
   $('#email3').css('display', '');
  }
 });
});


 </script>
 <script language="Javascript">
function checkemailaddy(){
        if (form.email_select.value == '1') {
            form.email2.readonly = false;
            form.email2.value = '';
            form.email2.focus();
        }
        else {
            form.email2.readonly = true;
            form.email2.value = form.email_select.value;
        }
    }
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset = utf-8">
<title>������ �޷¸����</title>
<meta name = "viewport" content = "width=device-width, initial-scale = 1">
<link rel = "stylesheet" href = "ui/jquery.mobile-1.2.0.min.css" />
<link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
<script language = "javascript" type = "text/javascript">
$(document).ready(function() {
 
  //******************************************************************************
  // �󼼰˻� �޷� ��ũ��Ʈ
  //******************************************************************************
  var clareCalendar = {
   monthNamesShort: ['1��','2��','3��','4��','5��','6��','7��','8��','9��','10��','11��','12��'],
   dayNamesMin: ['��','��','ȭ','��','��','��','��'],
   weekHeader: 'Wk',
   dateFormat: 'yy/mm/dd', //����(20120303)
   autoSize: false, //���丮������(body�� �����±��� ������ ������)
   changeMonth: true, //�����氡��
   changeYear: true, //�⺯�氡��
   showMonthAfterYear: true, //�� �ڿ� �� ǥ��
   buttonImageOnly: true, //�̹���ǥ��
   buttonText: '�޷¼���', //��ư �ؽ�Ʈ ǥ��
   buttonImage: 'cale_bg.jpg', //�̹����ּ�
   showOn: "both", //������Ʈ�� �̹��� ���� ���(both,button)
   yearRange: '1950:2030' //1990����� 2020�����
   
  };
  $("#birth").datepicker(clareCalendar);
  $("img.ui-datepicker-trigger").attr("style","margin-left:5px; vertical-align:middle; cursor:pointer;"); //�̹�����ư style����
  $("#ui-datepicker-div").hide(); //�ڵ����� �����Ǵ� div��ü ����  
 });
</script>
</head>
<body>
<table border = "0">
<tr>
<td ><input name="birth" id="birth" size="8" maxlength="8"></td>
</tr>
</table>
</body>
</html>

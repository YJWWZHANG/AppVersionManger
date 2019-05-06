<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
<link type="text/css" rel="stylesheet" href="../css/main.css"/>
<style type="text/css">
body{width:100%;height:100%;background-color: #FFFFFF;text-align: center;}
.input_txt{width:200px;height:20px;line-height:20px;}
.info{height:40px;line-height:40px;}
.info th{text-align: right;width:95px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="appFileUpload.html"  name="userForm" id="userForm" method="post"  target="result"  enctype="multipart/form-data" onsubmit="return checkInfo();"  >
	 <input id="appKey" type="hidden" name="appKey" value="${appKey }" >
	 <table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>app文件:</th>
			<td><input id="apple1" type="file" name="file" ></td>
		</tr>
	 </table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','上传文件',function(){
				$("#userForm").submit();
			});
			
		});

		function checkInfo(){
			 var is=true;
			  var filename = document.getElementById("apple1").value;
			  if(filename!=""){
			      var postf=filename.substring(filename.lastIndexOf(".")+1,filename.length);//后缀名  
			      if(!(postf=="apk"||postf=="ipa")){
			    	  is=false;
					  alert("文件格式错误，上传正确的文件");
			       }
			  }else{
				  is=false;
				  alert("请选择文件后在上传！"); 
			   }
			return is;
		}
		function success(){
			if(dg.curWin.document.forms[0]){
				dg.curWin.document.forms[0].action = dg.curWin.location+"";
				dg.curWin.document.forms[0].submit();
			}else{
				dg.curWin.location.reload();
			}
			dg.cancel();
		}
		
</script>
	</body>
</html>
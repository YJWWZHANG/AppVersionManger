<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="com.manager.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>文件上传</title>
<script type="text/javascript" src="./js/jquery-1.5.1.min.js"></script>
</head>
<body>
	<h2>上传多个文件 实例 </h2>

	<form  action="AllUploadFile.html"  method="post" enctype="multipart/form-data" onsubmit="return check()">
		<p>
			苹果 APP 选择文件:<input id="apple1" type="file" name="files" >
		</p><span id="apk" ></span>
		<p>
			安卓 APP 选择文件:<input id="apple2" type="file" name="files">
		</p><span id="ipa" ></span>
			<input type="submit" value="提交" id="submit" >
	</form>
		<script type="text/javascript">
	function check() {
		  var is=true;
		  var filename = document.getElementById("apple1").value;
		  var filename2 = document.getElementById("apple2").value;
		  if(filename!=""){
		      var postf=filename.substring(filename.lastIndexOf(".")+1,filename.length);//后缀名  
		      if(postf!="apk"){
		    	  is=false;
				alert("文件格式 有误 请上传安卓安装文件");
		       }
		  }else{
			  is=false;
			  alert("请选择文件后在上传！"); 
		   }


		  if(filename2!=""){
		      var postf=filename2.substring(filename2.lastIndexOf(".")+1,filename2.length);//后缀名  
		      if(postf!="ipa"){
		    	 is=false;
		    	 alert("文件格式 有误 请上传苹果安装文件");
		       }
		  }else{
			  is=false;
			  alert("请选择文件后在上传！"); 
		   }
		return is;
	}
</script>
	</body>

</html>
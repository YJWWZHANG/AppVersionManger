<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<base href="<%=basePath%>">

	<title>My JSF 'test.jsp' starting page</title>
	
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>
  
<body>
		<form id="uploadForm">
			<p>
				指定文件名：
				<input type="text" name="filename" value="" />
			</p>
			<p>
				上传文件：
				<input type="file" name="file" />
				</ p>
				<input type="button" value="上传" onclick="doUpload()" />
		</form>
		<script type="text/javascript">
			function doUpload() {
				var formData = new FormData($("#uploadForm")[0]);
				$.ajax( {
					url : 'http://localhost:8080/xiaochangwei/file/upload',
					type : 'POST',
					data : formData,
					async : false,
					cache : false,
					contentType : false,
					processData : false,
					success : function(returndata) {
						alert(returndata);
					},
					error : function(returndata) {
						alert(returndata);
					}
				});
	}
</script>


	</body>
</html>
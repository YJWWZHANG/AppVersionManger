<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
<title>上传文件</title>
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="this is my page">
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
<body>
<script type="text/javascript">

        function UpladFile() {
            var fileObj = document.getElementById("file").files[0]; // js 获取文件对象
            var FileController = "upload.html";                    // 接收上传文件的后台地址 

            // FormData 对象
            var form = new FormData($("#uploadForm" )[0]);

            // XMLHttpRequest 对象
            var xhr = new XMLHttpRequest();
            xhr.open("post", FileController, true);
            xhr.onload = function () {
               // alert("上传完成!");
            };
            xhr.upload.addEventListener("progress", progressFunction, false);
            xhr.send(form);
        }
        function progressFunction(evt) {
            var progressBar = document.getElementById("progressBar");
            var percentageDiv = document.getElementById("percentage");
            if (evt.lengthComputable) {
                progressBar.max = evt.total;
                progressBar.value = evt.loaded;
                percentageDiv.innerHTML = Math.round(evt.loaded / evt.total * 100) + "%";
                if(evt.loaded==evt.total){
                    alert("上传完成100%");
                }
            }
        }  

    </script>
    

    <progress id="progressBar" value="0" max="100"></progress>
    <span id="percentage"></span>

<form id= "uploadForm">

    <input type="file" id="file" name="myfile" />
    <input type="button" onclick="UpladFile()" value="上传" />

</form>
</body>
</html>
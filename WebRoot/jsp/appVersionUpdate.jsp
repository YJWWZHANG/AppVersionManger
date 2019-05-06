<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Test</title>
    <link rel="shortcut icon" href="./images/favicon.ico" type="image/x-icon" /> 
<link type="text/css" rel="stylesheet" href="css/main.css"/>
</head>
<body>
	<form action="#" method="post" name="userForm" id="userForm">
	<table width="100%" border="1" cellpadding="0" cellspacing="0" class="main_table" style="word-break:break-all;overflow:auto;" >
		<tr class="main_head" >
			<th style="width:5%;white-space: nowrap;">APP名称</th>
			<th style="width:5%;white-space: nowrap;">APP版本</th>
			<th style="width:5%;white-space: nowrap;">APP类型</th>
			<th style="width:15%;white-space: nowrap;">文件下载地址</th>
			<th style="width:15%;white-space:normal;">二维码下载地址</th>
			<th style="width:15%;white-space: nowrap;">版本更新提示语</th>
			<th style="width:10%;white-space: nowrap;" >更新时间</th>
			<th style="width:5%;white-space: nowrap;">可更新状态</th>
			<th style="width:5%;white-space: nowrap;">文件大小</th>
			<th style="width:5%;white-space: nowrap;">强制更新</th>
			<th style="width:10%;white-space: nowrap;"> 操作</th>
		</tr>
		<c:choose>
			<c:when test="${not empty listVersion}">
				<c:forEach items="${listVersion}" var="user" varStatus="vs">
				<tr class="main_info">
				<td>${user.appName }</td>
				<td>${user.version }</td>
				<td>${user.applicationType }</td>
				<td>${user.updatePackagePath }</td>
				<td>${user.appUrl }</td>
				<td>${user.updateLog }</td>
				<td><fmt:formatDate value="${user.updateTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td>
				<c:choose>
				   <c:when test="${user.state==true}">是</c:when>
				   <c:otherwise>否</c:otherwise>
				</c:choose>
				</td>
				<td>${user.targetSize }</td>
				<td><c:choose>
				   <c:when test="${user.constraints==true}">是</c:when>
				   <c:otherwise>否</c:otherwise>
				</c:choose>
				</td>
				<td><a href="javascript:editUser('${user.appKey}');">修改</a>|<a href="javascript:uploadFile('${user.appKey}');">文件上传</a></td>
				</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr class="main_info">
					<td colspan="11">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
	</form>
	<script type="text/javascript" src="js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript" src="js/datePicker/WdatePicker.js"></script>
	<script type="text/javascript" src="js/lhgdialog/lhgdialog.min.js?t=self&s=areo_blue"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(".main_info:even").addClass("main_table_even");
		});
		
		
		function editUser(appKey){
			var dg = new $.dialog({
				title:'修改版本信息',
				id:'user_edit',
				width:380,
				height:380,
				iconTitle:false,
				cover:false,
				maxBtn:false,
				resize:false,
				page:'appVersionManager/edit.html?appKey='+appKey
				});
    		dg.ShowDialog();
		}


		function uploadFile(appKey){
			var dg = new $.dialog({
				title:'文件上传',
				id:'upload_file',
				width:350,
				height:200,
				iconTitle:false,
				cover:false,
				maxBtn:false,
				resize:false,
				page:'appVersionManager/upload.html?appKey='+appKey
				});
    		dg.ShowDialog();
		}
		
		function search(){
			$("#userForm").submit();
		}
		
	</script>
</body>
</html>
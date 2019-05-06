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
	<form action="modify.html" name="userForm" id="userForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="appKey" id="appKey" value="${versions.appKey }"/>
		<!-- <input type="hidden" name="updateTime" id="updateTime" value="${versions.updateTime }"> -->
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>APP名称:</th>
			<td><input type="text" name="appName" id="appName" class="input_txt" value="${versions.appName}"/></td>
		</tr>
		<tr class="info">
			<th>APP版本:</th>
			<td><input type="text" name="version" id="version" class="input_txt" value="${versions.version}"/></td>
		</tr>
		<tr class="info">
			<th>APP类型:</th>
			<td><input type="text" name="applicationType" id="applicationType" class="input_txt" value="${versions.applicationType}"/></td>
		</tr>
		
		<tr class="info">
			<th>文件下载地址:</th>
			<td><input type="text" name="updatePackagePath" id="updatePackagePath" class="input_txt" value="${versions.updatePackagePath }"/></td>
		</tr>
		<tr class="info">
			<th>扫码地址:</th>
			<td><input type="text" name="appUrl" id="appUrl" class="input_txt" value="${versions.appUrl}"/></td>
		</tr>
		<tr class="info">
			<th>版本提示语:</th>
			<!-- <input type="text" name="updateLog" id="updateLog" class="input_txt" value="${versions.updateLog}"/> -->
			<td>
			<textarea name="updateLog" cols="30" rows="4"  style="width:200px;height: 200px;max-width: 220px;max-height: 220px;font-size: 15px;">${versions.updateLog}</textarea>
			</td>
		</tr>
		<tr class="info">
			<th>可更新状态:</th>
			<td>
			    <select name="state" id="state" class="input_txt">
					<option value="">请选择</option>
					<option value="true" <c:if test="${versions.state==true}">selected</c:if>>是</option>
					<option value="false" <c:if test="${versions.state==false}">selected</c:if>>否</option>
				</select>
			</td>
		</tr>
		<tr class="info">
			<th>文件大小(M):</th>
			<td><input type="text" name="targetSize" id="targetSize" class="input_txt" value="${versions.targetSize}"/></td>
		</tr>
		<tr class="info">
			<th>强制更新:</th>
			<td>
			    <select name="constraints" id="constraints" class="input_txt">
					<option value="">请选择</option>
					<option value="true" <c:if test="${versions.constraints==true}">selected</c:if>>是</option>
					<option value="false" <c:if test="${versions.constraints==false}">selected</c:if>>否</option>
				</select>
			</td>
			
		</tr>
		
	</table>
	</form>
	<iframe name="result" id="result" src="about:blank" frameborder="0" width="0" height="0"></iframe>
	
	<script type="text/javascript" src="../js/jquery-1.5.1.min.js"></script>
	<script type="text/javascript">
		var dg;
		$(document).ready(function(){
			dg = frameElement.lhgDG;
			dg.addBtn('ok','保存',function(){
				$("#userForm").submit();
			});
			if($("#appName").val()!=""){
				$("#appName").attr("readonly","readonly");
				$("#appName").css("color","gray");
			}
			if($("#applicationType").val()!=""){
				$("#applicationType").attr("readonly","readonly");
				$("#applicationType").css("color","gray");
			}
			if($("#updatePackagePath").val()!=""){
				$("#updatePackagePath").attr("readonly","readonly");
				$("#updatePackagePath").css("color","gray");
			}
			if($("#appUrl").val()!=""){
				$("#appUrl").attr("readonly","readonly");
				$("#appUrl").css("color","gray");
			}
		});
		
		function checkInfo(){
			if($("#appName").val()==""){
				alert("应用明不能为空!");
				$("#appName").focus();
				return false;
			}
			if($("#version").val()==""){//新增
				alert("版本信息必填!");
				$("#version").focus();
				return false;
			}
			if($("#applicationType").val()==""){
				alert("APP类型!");
				$("#applicationType").focus();
				return false;
			}
			if($("#updatePackagePath").val()==""){
				alert("文件下载地址不能为空!");
				$("#updatePackagePath").focus();
				return false;
			}
			if($("#updateLog").val()==""){
				alert("版本提示语不能为空!");
				$("#updateLog").focus();
				return false;
			}
			if($("#state").val()==""){
				alert("更新状态值不能为空!");
				$("#state").focus();
				return false;
			}
			if($("#appUrl").val()==""){
				alert("扫码不能为空!");
				$("#appUrl").focus();
				return false;
			}
			if($("#targetSize").val()==""){
				alert("文件大小不能为空!");
				$("#targetSize").focus();
				return false;
			}
			if($("#constraints").val()==""){
				alert("强制更新不能为空!");
				$("#constraints").focus();
				return false;
			}
			return true;
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
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
.info th{text-align: right;width:65px;color: #4f4f4f;padding-right:5px;font-size: 13px;}
.info td{text-align:left;}
</style>
</head>
<body>
	<form action="save.html" name="userForm" id="userForm" target="result" method="post" onsubmit="return checkInfo();">
		<input type="hidden" name="userId" id="userId" value="${user.userId }"/>
	<table border="0" cellpadding="0" cellspacing="0">
		<tr class="info">
			<th>用户名:</th>
			<td><input type="text" name="loginname" id="loginname" class="input_txt" value="${user.loginname }"/></td>
		</tr>
		<tr class="info">
			<th>密　码:</th>
			<td><input type="password" name="password" id="password"  placeholder="字母开头,字母、数字4-16位" class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>确认密码:</th>
			<td><input type="password" name="chkpwd" id="chkpwd" placeholder="字母开头,字母、数字4-16位"  class="input_txt"/></td>
		</tr>
		<tr class="info">
			<th>名　称:</th>
			<td><input type="text" name="username" id="username" class="input_txt" value="${user.username }"/></td>
		</tr>
		<tr class="info">
			<th>角　色:</th>
			<td>
			<select name="roleId" id="roleId" class="input_txt">
				<option value="">请选择</option>
			<c:forEach items="${roleList}" var="role">
				<option value="${role.roleId }">${role.roleName }</option>
			</c:forEach>
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
			if($("#userId").val()!=""){
				$("#loginname").attr("readonly","readonly");
				$("#loginname").css("color","gray");
				var roleId = "${user.roleId}";
				if(roleId!=""){
					$("#roleId").val(roleId);
				}
			}
		});
		
		function checkInfo(){
			if($("#loginname").val()==""){
				alert("请输入用户名!");
				$("#loginname").focus();
				return false;
			}
			if($("#userId").val()=="" && $("#password").val()==""){//新增
				alert("请输入密码!");
				$("#password").focus();
				return false;
			}
			if($("#password").val()!=$("#chkpwd").val()){
				alert("请确认密码!");
				$("#password").focus();
				return false;
			}else{
				 var re = /^[a-zA-z]\w{3,15}$/;
			    if(!re.test($("#password").val())){
			        alert("请重新设置密码！");
			       return false;
			    }
			   
			}
			if($("#username").val()==""){
				alert("请输入名称!");
				$("#username").focus();
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
		
		function failed(){
			alert("新增失败，该用户名已存在！");
			$("#loginname").select();
			$("#loginname").focus();
		}
	</script>
</body>
</html>
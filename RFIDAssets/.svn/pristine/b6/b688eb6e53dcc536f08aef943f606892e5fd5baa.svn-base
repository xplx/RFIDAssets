<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>用户登陆界面</title>
</head>
<body>

${result }
${msg }
${info }

		<h1>登陆操作</h1>
		<hr>
		<form action="RegisterUserInfo" method="post">
			<table align="center" border="1">
				<tr>

					<td colspan="2"><font color="red">用户登陆</font></td>
				</tr>
				<tr>
					<td><font color="blue">账户：</font></td>
					<td><input type="text" name="account"></td>
				</tr>
				<tr>
					<td><font color="blue">账户名：</font></td>
					<td><input type="text" name="user_Name"></td>
				</tr>
				<tr>
					<td><font color="blue">密码：</font></td>
					<td><input type="text" name="password"></td>
					<!--class="botton1"调用css写的代码  -->
				</tr>
				<tr>
					<td><font color="blue">权限角色：</font></td>
					<td><input type="text" name="role"></td>
				</tr>
				<tr>
					<td><font color="blue">部门：</font></td>
					<td><input type="text" name="department"></td>
					<!--class="botton1"调用css写的代码  -->
				</tr>
				<tr>
					<td><font color="blue">电话：</font></td>
					<td><input type="text" name="phone"></td>
				</tr>
				<tr>
					<td><font color="blue">邮箱：</font></td>
					<td><input type="text" name="mail"></td>
					<!--class="botton1"调用css写的代码  -->
				</tr>				
				<tr>
					<td colspan="2"><input class="botton1" type="submit"
						value="登陆"> <input class="botton1" type="reset" value="重置">
					</td>
				</tr>
			</table>
		</form>
</html>
<%@page import="model.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>注册</title>

<script type="text/javascript">
	function auth() {
		var pass = document.forms[0]["password"].value;
		var passre = document.forms[0]["passwordRe"].value;
		if (!pass) {
			document.getElementById("err").innerHTML = "密码不能为空";
			return false;
		}
		if (pass.value != passre.value) {
			document.getElementById("err").innerHTML = "两次输入的密码不匹配";
			return false;
		} else {
			document.getElementById("err").innerHTML = "";
			return true;
		}
	}
</script>
</head>

<body>
	<h1>注册</h1>
	<form action="register_bean.jsp" method="post" onsubmit="return auth()">
		<table>
			<tr>
				<td>学号：</td>
				<td><input type="text" name="id" value="13"></td>
			</tr>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="name" value="tys"></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="password" name="password"
					placeholder="6-8位的字母和数字" pattern="^[\w\d]{0,8}$" onchange="auth()"
					title="6-8位的字母和数字"></td>
			</tr>
			<tr>
				<td>再次输入密码：</td>
				<td><input type="password" name="passwordRe" onchange="auth()"></td>
			</tr>
			<tr>
				<td>专业：</td>
				<td><input type="text" name="major" value="SE"></td>
			</tr>
		</table>
		<br> <input type="submit" value="注册" name="register">
	</form>
	<p id="err" style="color: red"></p>
</body>

</html>
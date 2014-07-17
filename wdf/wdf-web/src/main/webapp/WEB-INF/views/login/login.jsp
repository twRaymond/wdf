<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link type="text/css" rel="stylesheet" href="html/css/common-style.css">
<link type="text/css" rel="stylesheet" href="html/css/common-button.css">
<link type="text/css" rel="stylesheet" href="html/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script src="html/js/jQuery/jquery-1.11.1.min.js" ></script>
<title></title>
</head>
<body>
	<div class="div-login">
		<form>
		<fieldset>
			<legend>Login Application Bean</legend>
			<ul>
				<li><label for="name">Account  :<em>*</em></label><input type="text" id="account" name="account" value="" /></li>
				<li><label for="name">Password :<em>*</em></label><input type="password" id="accountPwd" name="accountPwd" value="" /></li>
				<li>
					<div align="right">
						<input type="submit" id="loginBtn" name="loginBtn" value="Login"> 
						<input type="button" id="CancelBtn" name="CancelBtn" value="Cancel">
					</div>
				</li>
				<li>
					<div align="right">
						<input type="button" id="missPwdBtn" name="missPwdBtn" value=" I forgot password  ">
					</div>
				</li>
			</ul>
		</fieldset>
		</form>
	</div>
</body>
</html>
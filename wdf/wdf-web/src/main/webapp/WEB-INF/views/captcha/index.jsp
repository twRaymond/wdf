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
<script src="html/js/jQuery/jquery.form.js" ></script>
<title></title>
<script>
$(document).ready(function(){
	var imageObj;
	$("#reCaptcha").click( function() {
		var options = {
			id		: 'captchaForm',
			url 	: 'captcha.reCaptcha',
			dataType: 'json',
 			success	: function(obj) {
 				imageObj = obj;
 				$("#captcha").attr('src', 'data:image/png;base64, ' + obj.base64Code);
			}
		};
		$("#captchaForm").ajaxSubmit(options);
	});
	
	$("#pImg").click(function() {
		var options = {
			id		: 'captchaForm',
			url 	: 'captcha.process?tmpCapId=' + imageObj.Id,
			dataType: 'json',
 			success	: function(obj) {
 				$("#captchaP").attr('src', 'data:image/png;base64, ' + obj.base64Code);
			}
		};
		$("#captchaForm").ajaxSubmit(options);
	});
});

</script>
</head>
<body>
	<div>
		<form>
		<fieldset>
			<legend>CAPTCHA Some Control</legend>
			<form:form id="captchaForm" name="captchaForm" action="/captcha.process" method="GET">
			<ul>
				<li>
					<div id="oldImg"><img id="captcha" name="captcha" src="" /></div>
					<div id="processImg"><img id="captchaP" name="captchaP" src="" /></div></li>
				<li>
					<input type="button" id="reCaptcha" name="reCaptcha" value="Re CAPTCHA" /></li>
				<li>
					<input type="button" id="pImg" name="pImg" value="Process Img" /><li>
			</ul>
			</form:form>
		</fieldset>
		</form>
	</div>
</body>
</html>
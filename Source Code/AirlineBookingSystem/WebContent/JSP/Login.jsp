<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<script type="text/javascript" src="js/script.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<link rel="stylesheet" href="CSS/main.css">
<link rel="stylesheet" href="CSS/login.css">
<script type="text/javascript" src="search.js"></script>
</head>
<body>

	<script type="text/javascript">
		$(document).ready(function() {
			toggleRegister();
		});
	</script>
	<div id="header">
		<img id="header_logo" src="Pictures/logo.jpg" />
		<h3 id="header_text">Airline Booking System</h3>
	</div>

	<img src="Pictures/IMG1.JPG" id="background_image"></img>
	<div id="the_circle"></div>
	<div id="content">
		<img src="Pictures/user2.jpg" class="user_image" />
		<div class="box" id="login_box">
			<h1 class="box_heading">Login</h1>
			<s:form action="loginUser.action" theme="simple" id="login_form">
				<s:fielderror name="username"/>
				<div><s:textfield class="input_field" placeholder="Username"
					name="username" /></div>
				<div><s:password class="input_field" placeholder="Password"
					name="password" value="hej123" /></div>
				<s:submit id="login_button" value="Login"
					class="mybuttons" />
				<p onClick="toggleBoth()" id="toggle_button">Register New
				User</p>
			</s:form>
			
			<s:form action="registerUser.action" theme="simple" id="register_form">
				<s:fielderror name="username"/>
				<div><s:textfield class="input_field" placeholder="Username"
					name="username" /></div>
				<div><s:password class="input_field" placeholder="Password"
					name="password" /></div>
				<div><s:password class="input_field"
					placeholder="Repeat Password" name="passwordRepeat"
					id="password_repeat" /><div/>
				<div><s:textfield class="input_field"
					placeholder="email" name="email" id="email" /></div>
					<s:hidden name="admin" value="false"/>
				<s:submit id="login_button" value="Register"
					class="mybuttons" />
				<p onClick="toggleBoth()" id="toggle_button">Login</p>
			</s:form>
			
		</div>

	</div>
</body>
</html>
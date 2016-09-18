<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="../CSS/main.css">
<link rel="stylesheet" href="../CSS/adminpage.css">
</head>
<body>
	<div id="header">
		<img id="header_logo" src="../Pictures/logo.jpg" />
		<h3 id="header_text">Airline Booking System</h3>
		<s:form action="logoutUser" namespace="/" theme="simple">
			<s:submit style="float:right" value="Logout" class="admin_mybuttons"></s:submit>
		</s:form>
	</div>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
	%>

	<img src="../Pictures/IMG1.JPG" id="background_image"></img>
	<div id="the_circle"></div>
	<div id="content">
		<div id="report_box" class="admin_box">
		<h1 class="admin_box_heading">Create Report</h1>
			<s:form namespace="/admin" action="getReport" theme="simple">
			<s:textfield name="flightId.flightId" placeholder="Flight ID" class="admin_input_field"/>
			<s:textfield name="flightId.date" placeholder="yyyy-mm-dd" class="admin_input_field"/>
			<s:hidden name="typeOfEntity" value="Passenger"/>
			<s:submit value="Get Passengers" class="admin_mybuttons"/>
			</s:form>
			
			<s:form namespace="/admin" action="getReport" theme="simple">
			<s:textfield placeholder="No Input Needed" disabled="true" class="admin_input_field"/>
			<s:hidden name="typeOfEntity" value="User"/>
			<s:submit value="Get All users" class="admin_mybuttons"/>
			</s:form>
		</div>
		<div id="manage_box" class="admin_box">
		<h1 class="admin_box_heading">Add Flight</h1>
		<s:form action="addFlight.action" theme="simple">
		<div>
			<s:textfield name="flightId" placeholder="Flight ID" class="admin_input_field"/>
			<s:textfield name="date" placeholder="Date of Flight" class="admin_input_field"/>
		</div>
		<div>
			<s:textfield name="departureTime" placeholder="Departure Time" class="admin_input_field"/>
			<s:textfield name="duration" placeholder="Duration of Flight" class="admin_input_field"/>
		</div>
		<div>
			<s:textfield name="origin" placeholder="Origin Airport" class="admin_input_field"/>
			<s:textfield name="destination" placeholder="Destination Airport" class="admin_input_field"/>
		</div>
		<div>
			<s:textfield name="price" placeholder="Ticket Price" class="admin_input_field"/>
			<s:textfield name="capacity" placeholder="Capacity" class="admin_input_field"/>
		</div>
			<s:submit value="Add Flight" class="admin_mybuttons"/>
		</s:form>
		</div>
		
		<div id="create_user_box" class="admin_box">
		<h1 class="admin_box_heading">Create New Admin</h1>
			<s:form action="registerUser" namespace="/" theme="simple">
				<s:fielderror name="username"/>
				<div><s:textfield class="admin_input_field" placeholder="Username"
					name="username" /><s:password class="admin_input_field" placeholder="Password"
					name="password" /></div>
				<div><s:password class="admin_input_field"
					placeholder="Repeat Password" name="passwordRepeat"
					id="password_repeat" /><s:textfield class="admin_input_field"
					placeholder="email" name="email" id="email" /></div>
					<s:hidden name="admin" value="true"/>
				<s:submit id="login_button" value="Register"
					class="admin_mybuttons" />
			</s:form>
		</div>
		
		<div id="add_promotion_box" class="admin_box">
			<h1 class="admin_box_heading">Create Route Promotion</h1>
			<s:form action="setPromotion.action" theme="simple">
				<s:textfield name="originId" placeholder="Origin Airport (XXX)" class="admin_input_field"/>
				<s:textfield name="destinationId" placeholder="Destination Airport (XXX)" class="admin_input_field"/>
				<s:hidden name="value" value="Yes"/>
				<div>
				<s:submit value="Add Promotion" class="admin_mybuttons"/>
				</div>
			</s:form>
		</div>
		
		<div id="current_promotions_box" class="admin_box">
			<h1 class="admin_box_heading">Current Promotions</h1>
				<s:iterator value="listOfPromotions">
					<div class="admin_list_element">
					<s:form action="setPromotion.action" theme="simple">
						<div style="display:inline-block">
						<s:hidden name="originId" value="%{id.originId}"/>
						<s:hidden name="destinationId" value="%{id.destinationId}"/>
						<s:hidden name="value" value="No"/>
						<s:property/>
						</div>
						<s:submit value="Delete" class="delete_button"/>
					</s:form>
					</div>
			</s:iterator>			
		</div>
	</div>
</body>
</html>
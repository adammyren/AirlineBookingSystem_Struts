<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select Flight</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="CSS/main.css">
<link rel="stylesheet" href="CSS/selectflight.css">

</head>
<body>
	<div id="header">
		<img id="header_logo" src="Pictures/logo.jpg" />
		<h3 id="header_text">Airline Booking System</h3>
	</div>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.
	%>

	<img src="Pictures/IMG1.JPG" id="background_image"></img>
	<div id="the_circle"></div>
	<div id="content">
		<div id="display_flights_box" class="box booking_box">
			<h1 class="box_heading">Flight Out</h1>
			<s:form action="selectFlight.action" theme="simple">
				<s:iterator value="listOfFlights">
					<div class="list_element">
						<s:radio name="flightOut" list="%{top.id}"></s:radio> - 
						<s:property/>
					</div>
				</s:iterator>
				<h1 class="box_heading">Return Flight</h1>
				<s:iterator value="listOfReturns">
					<div class="list_element">
						<s:radio name="returnFlight" list="%{top.id}" value="'top.id'"></s:radio> - 
						<s:property/>
					</div>
				</s:iterator>
				<s:submit value="Next" class="mybuttons next_button" />
			</s:form>
			<s:form action="exitBooking.action" theme="simple">
				<s:submit value="Cancel" class="mybuttons cancel_booking_button"/>
			</s:form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm Booking</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="CSS/main.css">
<link rel="stylesheet" href="CSS/confirmbooking.css">
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
		<div id="bookings_display" class="box">
			<h1 class="box_heading">Booking Information</h1>
			
			<s:iterator var="passenger" value="#session.listOfPassengers">
				<s:iterator value="#session.flightsToBook" status="itStatus">
					<div class="list_element">
						<div class="list_element_left">
							<s:property value="#passenger.firstname"/><br/>
							<s:property value="#passenger.lastname"/>
						</div>
						<s:property value="#session.flightsToBook[#itStatus.index]"/>
						<s:property value="#session.flightInformation[#itStatus.index]"/>
					</div>
				</s:iterator>
			</s:iterator>
			<h1 class="admin_box_heading">Total Price: <s:property value="#session.totalPrice"/> SGD</h1>
		</div>
		
		<div id="payment_box" class="box booking_box">
			<h1 class="box_heading">Payment Details</h1>
			<s:form action="bookFlights.action" theme="simple">
			<div>
				<s:textfield type="text" class="input_field" placeholder="XXXX-XXXX-XXXX-XXXX"/>
			</div>
			<s:textfield type="text" class="small_input_field" placeholder="CVC"/>
			<s:textfield type="text" class="small_input_field" placeholder="YY-MM"/>
			<div>
				<s:radio class="radio" name ="typeOfCard" list="{'Mastercard', 'Visa'}"></s:radio>
			</div>
			<div>
				<s:submit value="Confirm" class="mybuttons next_button"/>
			</div>
			</s:form>
			<s:form action="exitBooking.action" theme="simple">
				<s:submit value="Cancel" class="mybuttons cancel_booking_button"/>
			</s:form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Enter Passenger Information</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="CSS/main.css">
<link rel="stylesheet" href="CSS/putinformation.css">

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
		<div id="flight_information_box" class="box booking_box">
			<h1 class="box_heading">Please Enter Passenger Information</h1>
			<s:form action="savePassengerInformation.action" theme="simple">
				<s:iterator begin="0" step="1" status="iteratorStatus" end="#session['nrOfTickets'] - 1">
					<h2>Passenger <s:property value="#iteratorStatus.count"/></h2>
					<div>
						<s:textfield class="input_field" name="firstname"
							placeholder="Firstname" />
						<s:textfield class="input_field" name="lastname"
							placeholder="Lastname" />
					</div>
					<div>
						<s:fielderror name ="dateOfBirth"/>
						<s:textfield class="input_field" name="dateOfBirth"
							placeholder="Date of Birth" />
						<s:textfield class="input_field" name="passportNr"
							placeholder="Passport Number" />
					</div>
					<div>
						<s:fielderror name ="passportInf" id="inf_error"/>
						<s:textfield class="input_field" name="passportExp"
							placeholder="Passport Expire" />
						<s:textfield class="input_field" name="passportIsh"
							placeholder="Passport Issued" />
					</div>
				</s:iterator>
				<s:submit class="mybuttons next_button" value="Next" />
			</s:form>
			<s:form action="exitBooking.action" theme="simple">
				<s:submit value="Cancel" class="mybuttons cancel_booking_button" />
			</s:form>
		</div>
	</div>
</body>
</html>
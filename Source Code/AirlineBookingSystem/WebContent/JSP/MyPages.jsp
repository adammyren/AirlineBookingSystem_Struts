<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Pages</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="CSS/main.css">
<link rel="stylesheet" href="CSS/mypages.css">
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

		<img src="Pictures/user_adam.jpg" class="user_image" />
		<div>
		<s:form action="logoutUser.action" theme="simple">
			<s:submit class="mybuttons" id="login_logout_button" value="Logout" />
		</s:form>
		</div>
		<div id="searchbox" class="box">
			
				<s:form action="searchFlight.action" theme="simple" id="search_form"
					theme="simple">
					<div id="search_input">
					<s:fielderror></s:fielderror>
					<s:select name="origin" class="input_field"
						list="{'Travel From','Stockholm - ARN','Kopenhamn - CPH','Beijing - PEK','Dubai - DBX','Tokyo - HND','Hong Kong - HKG','Singapore - SIN','Kuala Lumpur - KUL'}">
					</s:select>
					<s:select name="destination" class="input_field"
						list="{'Travel To','Stockholm - ARN','Kopenhamn - CPH','Beijing - PEK','Dubai - DBX','Tokyo - HND','Hong Kong - HKG','Singapore - SIN','Kuala Lumpur - KUL'}">
					</s:select>
					<s:textfield name="flightDate" class="input_field"
						placeholder="yyyy-mm-dd" />
					<s:textfield name="returnDate" id="return_date"
						class="input_field" placeholder="yyyy-mm-dd" />
					<s:select name="nrOfTickets" list="{'1 Passenger','2 Passengers','3 Passengers','4 Passengers','5 Passengers','6 Passengers','7 Passengers','8 Passengers'}"
						class="medium_input_field" />
					<s:submit class="mybuttons" value="Search" />
			</div>
			<div id="radio_buttons" align="left">
				<s:radio name="typeOfTrip" list="{'One-Way','Return'}"
					value="'Return'" onclick="toggleReturn()" />
			</div>
			</s:form>
		</div>

		<div id="information_box" class="box">
			<h1 class="box_heading">My Flights</h1>
			<s:iterator value="bookingElements">
			<s:form action="cancelBooking.action" class="list_element" theme="simple">
				<div class="list_element_left">
				<s:property value="top.id.firstname"/><br/>
				<s:property value="top.id.lastname"/>
				</div>
				<s:property/>
				<s:hidden name="bookingId.flightId" value="%{top.id.flightId}"></s:hidden>
				<s:hidden name="bookingId.passenger" value="%{top.id.passportNr}"></s:hidden>
				<s:hidden name="bookingId.date" value="%{top.id.date}"></s:hidden>
				<s:submit value="Cancel" class="delete_button"/>
			</s:form>
			</s:iterator>	
		</div>
	</div>
</body>
</html>
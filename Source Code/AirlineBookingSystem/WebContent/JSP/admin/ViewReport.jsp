<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link rel="stylesheet" href="../CSS/main.css">
<link rel="stylesheet" href="../CSS/viewreport.css">
</head>
<body>
	<div id="header">
		<img id="header_logo" src="../Pictures/logo.jpg" />
		<h3 id="header_text">Airline Booking System</h3>
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
		<h1 class="admin_box_heading"><s:property value="heading"/></h1>
			<s:iterator value="listOfEntities">
			<div class="admin_list_element">
				<s:property/>
			</div>
			</s:iterator>
			<s:form action="displayAdmin" theme="simple">
			<s:submit value="Back" class="admin_mybuttons"/>
			</s:form>
			<s:form action="downloadXML" namespace="/admin" theme="simple">
				<s:submit value="Download as XML" class="admin_mybuttons"/>
			</s:form>
		</div>
	</div>
</body>
</html>
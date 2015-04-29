<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Huma Products</title>
</head>
<body>
<form:form method="Post" action="registrationform.html"
	commandName="registration">
	<table>
		<tr>
			<td>Enter the following data</td>
		</tr>
		
		<tr>
			
		</tr>
		<tr>
			
		</tr>
		
		<tr>
			<td>Product Name:<FONT color="red"><form:errors
				path="userName" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="userName" /></td>
		</tr>

		<tr>
			<td>Product Type:<FONT color="red"><form:errors
				path="type" /></FONT></td>
		</tr>
		<tr>
			<td><form:input path="type" /></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
		<tr>
		
		
		</tr>
		
		<tr>
		<td> <a href="success">Back</a></td>
		<td><a href="logout">logout</a></td>
		</tr>
	</table>
</form:form>
</body>
</html>
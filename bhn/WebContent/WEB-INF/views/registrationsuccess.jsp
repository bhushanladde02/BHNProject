<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome Registration Successfully.</h3>
<table>
	<tr>
		<td>Product Name :</td>
		<td><core:out value="${registration.userName}" /></td>
	</tr>
	<tr>
		<td>Type :</td>
		<td><core:out value="${registration.type}" /></td>
	</tr>
	<tr>
	<td> <a href="success">Back</a></td>
	<td><a href="logout">logout</a></td>
	</tr>
</table>

</body>
</html>
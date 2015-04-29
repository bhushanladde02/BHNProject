<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head>
<body>
<h1>Products List</h1>
 <a href="success">Back</a>
 <a href="logout">logout</a>
<p></p>
   <table style="width:60%">
 
   <tr>
	    <td><b>ID</b></td>
		<td><b>Name</b></td> 
		<td><b>Image Name</b></td>
		<td><b>SDS Name</b></td>
		<td><b>Type of Product</b></td>
		<td><b>Remove Record</b></td>
		<td><b>Update</b></td>
	</tr>
	<c:forEach items="${productList}" var="product">
	<tr>
	    <td>${product.id}</td>
		<td>${product.name}</td> 
		<td>${product.imageurl}</td>
		<td>${product.sdfPath}</td>
		<td>${product.type}</td>
		<td><a href="<c:url value="service/products/delete/${product.id}"/>">Delete</a> </td>
		<td><a href="<c:url value="service/products/update/${product.id}"/>">Update</a> </td>
	</tr>
	</c:forEach>
	
	 </table>
 </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script language="javascript" type="text/javascript">
 function pass(){
	
  var id =document.getElementById('id');
  var name =document.getElementById('name');
  var type =document.getElementById('type');
  if(name.value=='')
  {
	  alert("Product name is mandetory");
	  return;
  }
  if(type.value=='')
  {
	  alert("Product type is mandetory");
	  return;
  }
  window.location.href = "save/"+id.value+"~~"+name.value+"~~"+type.value;
 }
</script>

<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
</head>
<body>

<h1>Update Product</h1>
 <a href="success">Back</a>
 <a href="logout">logout</a>
<p></p>
   <table style="width:60%">
 
   <tr>
   		<td><b>Instruction</b></td>
	    <td><b>ID</b></td>
		<td><b>Name</b></td> 
		
		<td><b>Type of Product</b></td>
		
	</tr>
	<tr>
		<td><b>Enter Updated VALUE</b></td>
	    <td><input id="id" name="id" value="${product.id}" readonly="readonly"/></td>
		<td><input id="name" name="name" value="${product.name}" /></td> 
		<td><input id="type" name="type" value="${product.type}" /></td>
	</tr>
	</table>
	<br/>
	
	 <input type="button"  value="Submit" onclick="pass()" />
 
 </body>
</html>
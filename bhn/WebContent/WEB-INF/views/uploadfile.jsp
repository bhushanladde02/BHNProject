<%@page contentType="text/html;charset=UTF-8"%>
<%@page pageEncoding="UTF-8"%>
<%@ page session="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>

<META http-equiv="Content-Type" content="text/html;charset=UTF-8">

<title>Upload Image for Product</title>
<style>
.error {
	color: #ff0000;
}
 
.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
<script language="JavaScript">
				function Validate()
				  {
					 var image =document.getElementById("image").value;
					 if(image!=''){
						  var checkimg = image.toLowerCase();
						  if (!checkimg.match(/(\.jpg|\.png|\.JPG|\.PNG|\.jpeg|\.JPEG)$/)){
							  alert("Please enter  Image  File Extensions .jpg,.png,.jpeg");
							  document.getElementById("image").focus();
							  return false;
						    }
						 }
					 return true;
				 }			
</script>
</head>
<body>
<form:form modelAttribute="uploadItem" name="frm" method="post"
	enctype="multipart/form-data" onSubmit="return Validate();">
	<fieldset><legend>Product Image Upload</legend>

        
	<table>
	<tr>
	<td>Select Product :</td>
				<td>
					  <form:select path="productList" size="30" style="min-width:600px">
					  <form:option value="NONE" label="  (Select Product --- Product Type) " />
					  <form:options items="${list}" />
					  
				      </form:select>
                </td>
                <td><form:errors path="productList" cssClass="error" /></td>
                
          
		
			<td><form:label for="fileData" path="fileData">Choose Image(Size<1,00,00,000 byte):</form:label><br />
			</td>
			<td><form:input path="fileData" id="image" type="file" /></td>
		
			<td><form:label for="fileData1" path="fileData1">Choose SDS Pdf(Size<10,00,00,000 byte):</form:label><br />
			</td>
			<td><form:input path="fileData1" id="image1" type="file"/></td>
			
			
			
			<td><input type="submit" value="Upload" align="left"/></td>
		   
		
	</tr>
		<tr>
		
		
			 
		
		
		</tr>
		
		<tr>
		<td> <a href="success">Back</a></td>
		<td><a href="logout">logout</a></td>
		</tr>	
	</table>
	</fieldset>
</form:form>
</body>
</html>
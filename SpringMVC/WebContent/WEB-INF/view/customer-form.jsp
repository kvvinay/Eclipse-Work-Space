<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
	<head>
		<title>Customer Registration Page</title>
		<style>
			.error {color:red}
		</style>
	</head>
<body>
	<h1>Customer Registration Form</h1>
	<br><br>
	<form:form action="processForm" modelAttribute="customer" >
	
		First Name(*): <form:input path="firstName" />
		<form:errors path="firstName" cssClass="error" />
		<br><br>
		 Last Name   : <form:input path="lastName" />
		<br><br>
		Free Passes:  <form:input path="freePasses" />
		<form:errors path="freePasses" cssClass="error" />
		<br><br>
		Pincode: <form:input path="pinCode" />
		<form:errors path="pinCode" cssClass="error" />
		<br><br>
		<input type="submit" value="Register" />

	</form:form>
	
	
</body>

</html>
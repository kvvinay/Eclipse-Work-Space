<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>

<head>
	<title>Student Registration Form</title>
	
	<style>
		.error{color.red}
	</style>
</head>

<body>

	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
	
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		Country: <form:select path="country">
					<form:options items="${student.map}" />
				</form:select>
		
		<br><br>
	
		Programming Language:
			 JAVA<form:radiobutton path="language" value="Java"/>
		     C#<form:radiobutton path="language" value="C#"/>
			 Python<form:radiobutton path="language" value="Python"/>
		     PHP<form:radiobutton path="language" value="Php" />
	
		<br><br>
		
		Operating Systems: Windows<form:checkbox path="os" value="Windows" />
						   Mac IOS<form:checkbox path="os" value="Mac IOS" />
						   Unix<form:checkbox path="os" value="Unix" />
						   Red Hat<form:checkbox path="os" value="Red Hat" />
		
		<br><br>
		<input type="submit" value="Lets GO!" />
	
	</form:form>


</body>

</html>













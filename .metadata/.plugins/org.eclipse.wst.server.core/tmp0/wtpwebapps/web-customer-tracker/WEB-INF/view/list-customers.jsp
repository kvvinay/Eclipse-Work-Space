<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<link type="text/css" 
			rel="stylesheet" 
			href="${pageContext.request.contextPath}/resources/css/style.css" />

	
</head>

<body>

	<div id="wrapper" > 
		<div id="header">
			<h2>CRM - Customer Relationship management</h2>
		</div>
	</div>
	
	<div id="container" >
		<div id="content">
		
	<input type="button" value="Add Customer" onclick="window.location.href='ShowFormForAdd'; return false;" class="add-button" />
		
	</div>
			<table>
				<tr>
					<th> First Name</th>
					<th> Last Name</th>
					<th> Email</th>
					<th> Action </th>
				</tr>
				
				<c:forEach var="tempC" items="${customer}" >
					
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customer" value="${tempC.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customer" value="${tempC.id}" />
					</c:url>
					
					<tr>
						<td>${tempC.firstName} </td>
						<td>${tempC.lastName} </td>
						<td>${tempC.email} </td>
						<td>
							<a href="${updateLink}" >Update</a>
							|
							<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this customer?')))return false">Delete</a>
							
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>










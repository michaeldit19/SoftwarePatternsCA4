<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Online Store</title>
</head>
<body>

	<h1>Welcome ${sessionScope.customers.firstname}</h1>
	
	<tr>
		<td>${message4}</td>
	</tr>

	<p>
		<a href="view_items_cust" data-toggle="tooltip" title="View Items">View
			Items</a>
	</p>
	<p>
		<a href="view_cart" data-toggle="tooltip" title="View Cart">View
			Cart</a>
	</p>
	<a href="/">Logout</a>

</body>
</html>
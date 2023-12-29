<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<%@ include file="bootstrap.jsp"%>
</head>
<body class="bg-light" >
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">
							<b>Add Customer</b>
						</p>
						
						<c:if test="${not empty succMsg}">
						<p class="text-center test-success">${succMsg}</p>
						<c:remove var="succMsg"/>
						</c:if>
						
						<c:if test="${not empty errorMsg}">
						<p class="text-center text-error">${errorMsg}</p>
						<c:remove var="errorMsg"/>
						</c:if>
						
						
						<form action="register" method="post">
						<div class="mb-3">
								<label class="form-label">Customer_ID</label> <input
									type="text" name="id" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">First Name</label> <input
									type="text" name="firstName" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Last Name</label> <input
									type="text" name="lastName" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email address</label> <input
									type="email" name="email" class="form-control">
							</div>
							
							
							<button type="submit" class="btn btn-danger col-md-12 ">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
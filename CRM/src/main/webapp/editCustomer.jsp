<%@page import="com.zuntech.crm.Customer"%>
<%@page import="com.zuntech.crm.CrmDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
<%@ include file="bootstrap.jsp"%>
</head>
<body class="bg-light">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">
							<b>Edit Customer</b>
						</p>
						
						
						<%
						String idStr=request.getParameter("id");
						int id=Integer.parseInt(idStr) ;
						
						CrmDao crmDao=CrmDao.getCrmDao();
						Customer c=crmDao.getCustomer(id);
						
						
						
						
						%>
						
						
						<form action="update" method="post">
						<div class="mb-3">
								<label class="form-label">Customer_ID</label> <input
									type="text" value="<%=c.getId()%>" name="id" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">First Name</label> <input
									type="text" value="<%=c.getFirstName()%>" name="firstName" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Last Name</label> <input
									type="text" value="<%=c.getLastName()%>" name="lastName" class="form-control">
							</div>
							<div class="mb-3">
								<label class="form-label">Email address</label> <input
									type="email" value="<%=c.getEmail()%>" name="email" class="form-control">
							</div>
							
							
							<button type="submit" class="btn btn-warning col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
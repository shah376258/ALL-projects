<%@page import="com.zuntech.crm.Customer"%>
<%@page import="java.util.List"%>
<%@page import="com.zuntech.crm.CrmDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Relationship Manager</title>
<%@ include file="bootstrap.jsp"%>
</head>
<body class="bg-light">


	<%@include file="navbar.jsp"%>

	<%-- <% CrmDao dao=CrmDao.getCrmDao();
	out.print(dao) ;%> --%>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">
				<h2 class="text-center ">Customer Details</h2>

				<c:if test="${not empty succMsg}">
					<p class="text-center test-success">${succMsg}</p>
					<c:remove var="succMsg" />
				</c:if>

				<c:if test="${not empty errorMsg}">
					<p class="text-center text-error">${errorMsg}</p>
					<c:remove var="errorMsg" />
				</c:if>

				<table class="table">
					<thead>
						<tr>
							<th scope="col">Customer_ID</th>
							<th scope="col">First Name</th>
							<th scope="col">Last Name</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>

						<%
						CrmDao crmDao = CrmDao.getCrmDao();
						List<Customer> customers = crmDao.getCustomers();

						for(Customer c : customers) {
						%>

						<tr>
							<td><%=c.getId()%></td>
							<td><%=c.getFirstName()%></td>
							<td><%=c.getLastName()%></td>
							<td><%=c.getEmail()%></td>
							<td>
								<a href="editCustomer.jsp?id=<%=c.getId()%>"
								class="btn btn-sm btn-warning">Edit</a>
								 <a href="delete?id=<%=c.getId()%>"
								class="btn btn-sm btn-danger ms-2">Delete</a>
							</td>
						</tr>

						<%
						}
						%>




					</tbody>
				</table>
			</div>

		</div>
	</div>



</body>
</html>
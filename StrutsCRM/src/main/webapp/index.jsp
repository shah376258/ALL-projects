<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="java.util.List"%>
<%@page import="com.zuntech.bean.Customer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Relationship Manager</title>
<%@ include file="bootstrap.jsp"%>
</head>
<body style="background-color: #41FFFF">
	<%@include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="card">
			<div class="card-body">
				<h2 class="text-center ">Customer Details</h2>

				<s:if test="succMsg != null">
					<p class="text-center test-success">
						<s:property value="succMsg" />
					</p>
					<s:set var="succMsg" value="null" />
				</s:if>

				<s:if test="errorMsg != null">
					<p class="text-center text-error">
						<s:property value="errorMsg" />
					</p>
					<s:set var="errorMsg" value="null" />
				</s:if>



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

						<%-- <%
						CrmDao crmDao = CrmDao.getCrmDao();
						List<Customer> customers = crmDao.getCustomers();
						%> --%>
						<s:iterator value="customerList">
							<tr>
								<td><s:property value="id" /></td>
								<td><s:property value="firstName" /></td>
								<td><s:property value="lastName" /></td>
								<td><s:property value="email" /></td>
								<td><a
									href=" editCustomer.action?id=<s:property value="id" /> "
									class="btn btn-sm btn-warning">Edit</a> <a
									href="deleteCustomer.action?id=<s:property value="id" />"
									class="btn btn-sm btn-danger ms-2">Delete</a></td>
							</tr>
						</s:iterator>





					</tbody>
				</table>
			</div>

		</div>
	</div>

</body>
</html>
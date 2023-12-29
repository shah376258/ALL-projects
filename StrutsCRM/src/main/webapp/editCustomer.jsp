<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
<%@ include file="bootstrap.jsp"%>
</head>
<body style="background-color: #41FFFF">
	<%@include file="navbar.jsp"%>

	<div class="container p-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">
							<b>Edit Customer</b>
						</p>

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

						<s:form action="updateCustomer" method="post" >
							<div class="mb-3">
								<label class="form-label">Customer_ID</label>
								<s:textfield name="customer.id"  class="form-control" required="required" readonly="readonly"  />
							</div>
							<div class="mb-3">
								<label class="form-label">First Name</label>
								<s:textfield name="customer.firstName"  class="form-control" required="required" />
							</div>
							<div class="mb-3">
								<label class="form-label">Last Name</label>
								<s:textfield name="customer.lastName"  class="form-control" required="required" />
							</div>
							<div class="mb-3">
								<label class="form-label">Email address</label>
								<s:textfield name="customer.email"   class="form-control" required="required" />
							</div>


							<button type="submit" class="btn btn-danger col-md-12">Edit</button>
						</s:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>

<spring:url value="/css/bootstrap-3.1.1.min.css" var="bootstrap3" />
<spring:url value="/js/jquery.min.js" var="jquery" />
<spring:url value="/js/bootstrap.min.js" var="bootstrapmin" />
<link href="${bootstrap3}" rel="stylesheet" />
<script src="${jquery}"></script>
<script src="${bootstrapmin}"></script>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Spring Boot</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">Home</a></li>
					<li><a href="#about">About</a></li>
					<li><a href="testcontroller/test">Test Link</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="col-md-offset-1 col-md-10">
			<h2>Test App</h2>
			<hr />

			<input type="button" value="Add Test"
				onclick="window.location.href='showTestForm'; return false;"
				class="btn btn-primary" /> <br />
			<br />
			<div class="panel panel-info">
				<div class="panel-heading">
					<div class="panel-title">Test List</div>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-bordered">
						<tr>
							<th>First Attribute</th>
							<th>Second Attribute</th>
							<th>Action</th>
						</tr>

						<!-- loop over and print our customers -->
						<c:forEach var="tempTest" items="${testList}">

							<!-- construct an "update" link with customer id -->
							<c:url var="updateLink" value="/testcontroller/updateTestForm">
								<c:param name="seq" value="${tempTest.seq}" />
							</c:url>

							<!-- construct an "delete" link with customer id -->
							<c:url var="deleteLink" value="/tectcontroller/delete">
								<c:param name="seq" value="${tempTest.seq}" />
							</c:url>

							<tr>
								<td>${tempTest.attr1}</td>
								<td>${tempTest.attr2}</td>

								<td>
									<!-- display the update link --> <a href="${updateLink}">Update</a>
									| <a href="${deleteLink}"
									onclick="if (!(confirm('Are you sure you want to delete this test?'))) return false">Delete</a>
								</td>

							</tr>

						</c:forEach>

					</table>

				</div>
			</div>
		</div>

	</div>

	<!-- /.container -->

</body>

</html>

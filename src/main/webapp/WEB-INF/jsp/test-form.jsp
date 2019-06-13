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

		<div class="panel panel-info">
			<div class="panel-heading">
				<div class="panel-title"><spring:message code="lbl.testform"/> </div>
			</div>
			<div class="panel-body">
				<form:form action="saveTest" cssClass="form-horizontal"
					method="post" modelAttribute="testModel">

					<!-- need to associate this data with test model id -->
					<form:hidden path="seq" />

					<div class="form-group">
						<label for="attr1" class="col-md-3 control-label">First
							Attribute</label>
						<div class="col-md-9">
							<form:input path="attr1" cssClass="form-control" />
						</div>
					</div>
					<div class="form-group">
						<label for="attr2" class="col-md-3 control-label">Second
							Attribute</label>
						<div class="col-md-9">
							<form:input path="attr2" cssClass="form-control" />
						</div>
					</div>

					<div class="form-group">
						<!-- Button -->
						<div class="col-md-offset-3 col-md-9">
							<form:button cssClass="btn btn-primary"><spring:message code="button_submit"/></form:button>
						</div>
					</div>

				</form:form>
			</div>
		</div>
	</div>

	<!-- /.container -->

</body>

</html>

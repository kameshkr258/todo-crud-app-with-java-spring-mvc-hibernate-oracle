<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Todo</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
.error {
	color: #ff0000;
}
</style>

</head>

<body>
	<div class="container">
		<h2>Update <b>${todoTask.title}</b> Todo</h2>

		<c:if test="${not empty error}">
			<div class="alert alert-danger" role="alert">${error}</div>
		</c:if>
		<hr />
		<form:form method="POST" modelAttribute="todoTask"
			cssClass="form-horizontal">
			<form:input type="hidden" path="id" id="id" />

			<div class="form-group">
				<label for="Title">Title</label>
				<form:input path="title" id="title" cssClass="form-control" />
				<form:errors path="title" cssClass="error" />
			</div>

			<div class="form-group">
				<label for="Description">Description</label>
				<form:input path="description" id="description" cssClass="form-control" />
				<form:errors path="description" cssClass="error" />
			</div>
			
			<div class="form-group">
				<label for="Status">Status</label>
				<form:select path="status" id="status" cssClass="form-control">
					<option value="" >--Select--</option>
					<c:forEach var="record" items="${todoStatusList}">
					${status}${record}${status == record}
						<option value="${record}" <c:if test="${status == record}">selected</c:if>>${record}</option>
					</c:forEach>
				</form:select>
				<form:errors path="status" cssClass="error" />
			</div>

			<div class="form-group">
				<label for="Completion Date">Completion Date</label>
				<form:input path="completionDate" type="date" id="completionDate" cssClass="form-control" />
				<form:errors path="completionDate" cssClass="error" />
			</div>
			<hr />
			
			<button type="submit" class="btn btn-primary">Submit</button>

			<a class="btn btn-secondary" href="<c:url value='/list' />">Todo List</a>

		</form:form>
	</div>
</body>
</html>
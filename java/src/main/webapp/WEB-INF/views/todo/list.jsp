<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Todo Task List</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style type="text/css">
tr:first-child {
	font-weignt: bold;
	background-color: #c6c9c4
}
</style>
</head>
<body>
	<div class="container">
		<h2>All Todo Tasks</h2>
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>

		<hr />
		<table class="table">
			<thead class="thead-dark">
				<tr>
					<td>Todo Id</td>
					<td>Title</td>
					<td>Description</td>
					<td>Status</td>
					<td>Created Date</td>
					<td>Completion Date</td>
					<td>Update</td>
					<td>Delete</td>
				</tr>
				<c:forEach items="${todoTaskList}" var="todoTask">
					<tr>
						<td>${todoTask.id}</td>
						<td>${todoTask.title}</td>
						<td>${todoTask.description}</td>
						<td>${todoTask.status}</td>
						<td><fmt:formatDate pattern = "dd-MMM-yyyy" value = "${todoTask.createdDate}"/> </td>
						<td><fmt:formatDate pattern = "dd-MMM-yyyy" value = "${todoTask.completionDate}"/> </td>
						<td><a href="<c:url value='/edit/${todoTask.id}' />">Update</a></td>
						<td><a href="<c:url value='/delete/${todoTask.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
		</table>
		<hr />
		<div class="form-group">
			<a class="btn btn-secondary" href="<c:url value='/create' />">Create Todo</a>
		</div>
	</div>
</body>
</html>
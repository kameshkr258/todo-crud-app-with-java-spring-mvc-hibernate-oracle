<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<jsp:include page="../fragments/header.jsp" />

<body>
	<div class="container">
		<h2>Todo List</h2>
		<c:if test="${not empty message}">
			<div class="alert alert-success" role="alert">${message}</div>
		</c:if>

		<hr />
		<table id="todoListTable" class="table">
			<thead class="thead-dark">
				<tr>
					<td>Id</td>
					<td>Title</td>
					<td>Description</td>
					<td>Status</td>
					<td>Created Date</td>
					<td>Completion Date</td>
					<td>Update</td>
					<td>Delete</td>
				</tr>
			</thead>
			<tbody>
				<c:set var="completedTodoCount" value="0"></c:set>
				<c:choose>
					<c:when test="${todoTaskList.size() > 0 }">
						<c:forEach items="${todoTaskList}" var="todoTask">
							<c:if test="${todoTask.status == 'Completed'}">
								<c:set var="completedTodoCount" value="${completedTodoCount+1}"></c:set>
							</c:if>
							
							<tr>
								<td>${todoTask.id}</td>
								<td class="title">${todoTask.title}</td>
								<td class="description">
									<textarea id="descriptionArea" name="descriptionArea" rows="1" cols="35" disabled="disabled">${todoTask.description}</textarea>
								</td>
								<td>${todoTask.status}</td>
								<td><fmt:formatDate pattern = "dd-MMM-yyyy" value = "${todoTask.createdDate}"/> </td>
								<td><fmt:formatDate pattern = "dd-MMM-yyyy" value = "${todoTask.completionDate}"/> </td>
								<td><a href="<c:url value='/edit/${todoTask.id}' />">Update</a></td>
								<td><a href="<c:url value='/delete/${todoTask.id}' />">Delete</a></td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<tr><td colspan="8">No To-do found. <a href="<c:url value= '/create' />">Lets create some </a></td></tr>				
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr><td colspan="8">Completed ${completedTodoCount} out of ${todoTaskList.size()} todo.</td></tr>
			</tfoot>
		</table>
		<hr />
		<div class="form-group">
			<a class="btn btn-secondary" href="<c:url value='/create' />">Create Todo</a>
			<a class="btn btn-secondary" href="<c:url value='/list' />">Refresh Page</a>
			<a class="btn btn-secondary" href="<c:url value='/deleteByStatus/Completed' />">Delete Completed</a>
		</div>
	</div>
</body>

<jsp:include page="../fragments/footer.jsp" />

</html>
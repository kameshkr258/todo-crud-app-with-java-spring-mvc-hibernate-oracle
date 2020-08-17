<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="container">
	<hr>
	<footer>
	<div class="form-group">
		<div id="aboutDevContent" >&copy; Kameshkr258<a id="aboutDevHref" href="<c:url value='/about/dev' />">About Developer</a></div>
		<a id="homePage" href="<c:url value='/list' />">Home Page</a>
	</div>
		 
	</footer>
</div>

<spring:url value="/resources/javascript/app.js" var="javascript" />
<script src="${javascript}"></script>

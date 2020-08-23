<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<spring:url value="/resources/javascript/linkedin-profile.js" var="linkedInJS" />
		<spring:url value="/resources/javascript/gh-profile-card.min.js" var="githubJS" />
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />

		<script type="text/javascript" src="${linkedInJS}"></script>
		<script type="text/javascript" src="${githubJS}"></script>
		<link href="${bootstrapCss}" rel="stylesheet" />
		
		
		<spring:url value="/resources/css/bootstrap.min.css" var="bootstrapCss" />
		<link href="${bootstrapCss}" rel="stylesheet" />
		<spring:url value="/resources/css/styles.css" var="css" />
		<link href="${css}" rel="stylesheet" />
	</head>
	<body id="aboutDev">
	
		<div class="container">
		
			<h1>Kamesh Rathore</h1>
			<hr>
			
			<h3>Full Stack Software Developer</h3>
			<h5>I have serious passion for Web Development, MERN Stack, Java EE, Database Design, System Architecture. </h5>
			<h5><a href= "https://www.upwork.com/o/profiles/users/~01032e46097ee1ce10/" >Lets make something special.</a></h5>
			
			<div class="row">
			  <div class="column">
			    <div class="content">
					<div id="github-card" data-username="kameshkr258"></div>
			    </div>
			  </div>
			</div>
		</div>
	</body>
	<jsp:include page="../fragments/footer.jsp" />
	
</html>

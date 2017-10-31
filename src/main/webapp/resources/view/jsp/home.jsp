<!DOCTYPE html>
<html ng-app="frshep">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/view/bootstrap/css/bootstrap.css"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/bootstrap/js/bootstrap.js"></script>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/angular.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/angular-route.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/app.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/app.route.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/controller/loginController.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/controller/signupController.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/controller/AddressController.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/view/js/util/util.js"></script>


<base href="/">
	<title> frshep | newsfeed </title>
</head>
<body>
<!-- <div ng-include="'${pageContext.request.contextPath}/resources/view/jsp/navbar.jsp'"></div>
<div ng-include="'${pageContext.request.contextPath}/resources/view/jsp/signup.jsp'"></div>
<br> -->
<div ng-include="'${pageContext.request.contextPath}/resources/view/jsp/addressRegistration.jsp'"></div>
</body>
</html>
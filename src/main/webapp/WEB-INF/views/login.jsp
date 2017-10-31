<!DOCTYPE html>
<html ng-app="loginModule">
<head>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/angular.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/login.js"></script>
</head>

<body ng-controller="loginController" >
    <div>
	  Email: <input type="text" ng-model="user.email" /><br>
      Password: <input type="password" ng-model="user.password" /><br>
      {{user}}<br>
      <button type="button" ng-click="ajaxCall()">Login</button>
        {{myWelcome.status}}
    </div>
    <div ng-include="'${pageContext.request.contextPath}/resources/error.html'">
    </div>
</body>
</html>
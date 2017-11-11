
<div id="loginDiv" class="text-primary" ng-controller="loginController" >
<h1 class="text-primary">Please Login</h1>
    Email : <input type="text" ng-model="loginCred.email"><br>
    Password : <input type="password" ng-model="loginCred.password"><br>
    <button type="button" ng-click="doLogin()">Submit</button>
</div>
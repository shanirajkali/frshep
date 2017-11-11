
<div id="signupDiv" class="text-primary" ng-controller="signupController" >
<h1 class="text-primary">Please Register</h1>
    Name: <input type="text" ng-model="user.name"><br>
    Email : <input type="text" ng-model="user.email"><br>
    UserName: <input type="text" ng-model="user.username"><br>
    Phone No. : <input type="number" ng-model="user.mobile"><br>
    DOB : <input type="date" ng-model="user.dob"><br>
  <!--   <button id="addAddress" type="button" ng-click="addAddress()">++ Address</button> -->
    Password : <input type="password" ng-model="user.password"><br>
    Re-Password : <input type="password" ng-model="user.password"><br>
    <button type="button" ng-click="submit()">Submit</button>
</div>
var loginApp = angular.module("loginModule",[]);

loginApp.controller("loginController", function($scope, $http){
    $scope.massage="frshep HI;;";
    var user={
        email:"shani",
        password:"rajkali"
    };
    $scope.user=user;
    $scope.ajaxCall=function(){
          $http({
              method: "POST",
              url: "http://localhost:9000/frshep/account/login",
              data: user
          })
            .then(function(response) {
              console.log("klsdjfkl");
                $scope.myWelcome = response.data;
                }, function(response){
                    $scope.myWelcome=response.data;
                    }
            );
    }
   
})
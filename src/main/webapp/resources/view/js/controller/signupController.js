angular.module('signupController', [])
    .controller('signupController', function($scope, $http ,$route, $rootScope, $location){
        var user={
        		email  : "",
        		username : "",
        		name : "",
        		mobile : "",
        		address : {
        			state : "up",
        			district : "meerut",
        			tahsil : "mawana",
        			pin : 250001,
        			locale : "tihai"
        		},
        		street : "",
        		dob : ""
            
        };
    $scope.user=user;
    console.log(user);
    $scope.submit=function(){
    	console.log(user);
        $http({
            method: "POST",
            url: "http://localhost:9000/frshep/account/create",
            data: user
        })
          .then(function(response) {
            console.log("console on receiving");
              $scope.myWelcome = response.data;
              console.log(response.data);
              }, function(response){
                  $scope.myWelcome=response.data;
                  console.log(response.data);
                  }
          );
  }
    
    
    
    })
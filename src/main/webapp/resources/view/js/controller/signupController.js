angular.module('signupController', [])
    .controller('signupController', function($scope, $http ,$route, $rootScope, $location,$compile){
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
            url: urlName.userSignup,
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
    
    $scope.addAddress=function(){
    	console.log("called");
    	
//
//   	 var newEle = angular.element('<ng-include src="http://localhost:9003/frshep/addressView"></ng-include>');
//   	    var target = document.getElementById('signupDiv');
//   	    angular.element(target).append(newEle);
//   	    console.log(newEle);
    	
    //	$("#signupDiv").append();
//    	var element = document.getElementById("signupDiv");
//    	var newDirective = angular.element('');
//    	element.append(newDirective);
    //	$compile(newDirective)($scope);
    }
})
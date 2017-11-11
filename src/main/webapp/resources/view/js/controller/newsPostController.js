angular.module('newsPostController', [])
    .controller('newsPostController', function($scope ,$route, $rootScope, $location){
        var loginCred={
           email : "",
           password : ""
        };
    $scope.loginCred=loginCred;
    
    $scope.doLogin=function(){
    	var result;
    	console.log("loginFront");
  	  	$.ajax({	url: urlName.userLogin,
  				type: 'post', async: false,  data:angular.toJson($scope.loginCred),
  				success: function(content) {
  					result=content;
  				}
  			});
  	  	console.log(result);
  	 return result;
    }
    
})
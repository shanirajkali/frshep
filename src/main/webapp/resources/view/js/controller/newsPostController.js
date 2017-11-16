angular.module('newsPostController', [])
    .controller('newsPostController', function($scope ,$route, $rootScope, $location){
        var loginCred={
           email : "",
           password : ""
        };
        
        var tagModel={
        		tagSuper:"ss",
        		tagSub0:"",
        		tagSub1:"",
        		tagSub2:"",
        		tagSub3:"",
        		tagSuperValues:[],
        		tagSub0Values:[],
        		tagSub1Values:[],
        		tagSub2Values:[],
        		tagSub3Values:[]
        }
        
        $scope.tagModel=tagModel;
        
	    $scope.loginCred=loginCred;
	    
	    $scope.doLogin=function(){
	    	var result;
	    	$.ajax({	url: urlName.userLogin,
	  				type: 'post', async: false,  data:angular.toJson($scope.loginCred),
	  				success: function(content) {
	  					result=content;
	  				}
	  			});
	  	 return result;
	    }
	    
	    $scope.getTag={
	    		allSuperTag: function(){
	    			console.log("in getTag.allSuper()");
	    		var dat=	$.ajax({	url: "http://localhost:9000/frshep/tag/super/getAll",
	      				type: 'post', async: false,  data:"",
	      				success: function(content) {
	      					result=content;
	      					return content;
	      				}
	      			});
	    		return dat.responseText;
	    		},
	    		
	    		allSub0TagByTagSuperName: function(tagSuperName){
	    			var dat=	$.ajax({	url: urlTag.getAllSub0ByTagSuperName,
	      				type: 'post', async: false,  data:angular.toJson({"tagSuperName":tagSuperName}),
	      				success: function(content) {
	      					result=content;
	      					return content;
	      				}
	      			});
	    			return dat.responseText;
	    		},
	    		
	    		allSub1TagByTagSub0Name: function(tagSub0Name){
	    			var dat=$.ajax({	url: "http://localhost:9000/frshep/tag/sub1/getAll",
	      				type: 'post', async: false,  data:angular.toJson({"tagSub0Name":tagSub0Name}),
	      				success: function(content) {
	      					result=content;
	      					return content;
	      				}
	      			});
	    			return dat.responseText;
	    		},
	    		
	    		allSub2TagByTagSub1Name: function(tagSub1Name){
	    			var dat=$.ajax({	url: "http://localhost:9000/frshep/tag/sub2/getAll",
	      				type: 'post', async: false,  data:angular.toJson({"tagSub1Name":tagSub1Name}),
	      				success: function(content) {
	      					result=content;
	      					return content;
	      				}
	      			});
	    			return dat.responseText;
	    		},
	    		
	    		allSub3TagByTagSub2Name: function(tagSub2Name){
	    			var dat=$.ajax({	url: "http://localhost:9000/frshep/tag/sub3/getAll",
	      				type: 'post', async: false,  data:angular.toJson({"tagSub2Name":tagSub2Name}),
	      				success: function(content) {
	      					result=content;
	      					return content;
	      				}
	      			});
	    			return dat.responseText;
	    		}
	    }
	    
	    var tagSuper=document.getElementById("tag_super");
		var tagSub0=document.getElementById("tag_sub0");
		var tagSub1=document.getElementById("tag_sub1");
		var tagSub2=document.getElementById("tag_sub2");
		var tagSub3=document.getElementById("tag_sub2");
	    $scope.fun=function(){
	    	
			if(tagSuper.style.display=="none"){
				tagSuper.style.display="block";
				$scope.tagModel.tagSuperValues=angular.fromJson($scope.getTag.allSuperTag());
				//util.addListToSelect("tag_super",angular.fromJson($scope.getTag.allSuperTag()));
				//	console.log("tagSuper: "+$scope.tagModel.tagSuper);
				//	$scope.tagModel.tagSuper = tagSuper.options[tagSuper.selectedIndex].text;
			}
			else if(tagSub0.style.display=="none"){
				$scope.tagModel.tagSub0Values=angular.fromJson($scope.getTag.allSub0TagByTagSuperName($scope.tagModel.tagSuper));
				tagSub0.style.display="block";
				console.log("tagSuper: "+$scope.tagModel.tagSub0Values+"  "+$scope.tagModel.tagSub0);
			}
			else if(tagSub1.style.display=="none"){
				$scope.tagModel.tagSub1Values=angular.fromJson($scope.getTag.allSub1TagByTagSub0Name($scope.tagModel.tagSub0));
				tagSub1.style.display="block";
				console.log("tagSuper: "+$scope.tagModel.tagSub1Values);
			}
			else if(tagSub2.style.display=="none"){
				$scope.tagModel.tagSub2Values=angular.fromJson($scope.getTag.allSub2TagByTagSub1Name($scope.tagModel.tagSub1));
				tagSub2.style.display="block";
				console.log("tagSuper: "+$scope.tagModel.tagSub2Values);
			}
			else if(tagSub3.style.display=="none"){
				$scope.tagModel.tagSub3Values=angular.fromJson($scope.getTag.allSub3TagByTagSub2Name($scope.tagModel.tagSub2));
				tagSub3.style.display="block";
				console.log("tagSuper: "+$scope.tagModel.tagSub3Values);
			}
			
			
			//ele.style.cssText="display:block";
			//	var tagDiv=document.getElementById("tag_div");
			//console.log("tag_div size "+tagDiv.children.length);
		}
	    
})
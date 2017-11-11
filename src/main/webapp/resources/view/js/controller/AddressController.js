angular.module('AddressController', [])
    .controller('AddressController', function($scope, $http ,$route, $rootScope, $location){
   
        var address={
        			state : "",
        			district : "",
        			tahsil : "",
        			pin : 0,
        			locale : ""
        		 };
        
        $scope.address=address;
        
        $scope.addressSubmit=function(){
        	var result;
      	  	$.ajax({	url: urlName.saveAddress,
      				type: 'post', async: false,  data:angular.toJson($scope.address),
      				success: function(content) {
      					result=angular.fromJson(content);
      				}
      			});
      	 return result;
        }
       
    
        $scope.getDistrict=function(){
        	var result;
      	  	$.ajax({	url: urlName.getDistrict,
      				type: 'post', async: false,  data:angular.toJson($scope.address),
      				success: function(content) {
      					result=angular.fromJson(content);
      				}
      			});
      	 return result;
        }
    
        $scope.getTahsil=function(){
        	var result;
      	  	$.ajax({	url: urlName.getTahsil,
      				type: 'post', async: false,  data:angular.toJson($scope.address),
      				success: function(content) {
      					result=angular.fromJson(content);
      				}
      			});
      	 return result;
        	
        }
        
        $scope.getLocale=function(){
        	var result;
      	  	$.ajax({	url: urlName.getLocale,
      				type: 'post', async: false,  data:angular.toJson($scope.address),
      				success: function(content) {
      					result=angular.fromJson(content);
      				}
      			});
      	 return result;
        	
        }
    
        $scope.hideAddAddressPanel=function(){
        	$("#addAddressPanel").hide();
        }
        
        $scope.showAddAddressPanel=function(){
        	$("#addAddressPanel").show();
        	console.log("clicked");
        }
        
      
        $scope.getState=function(){
        	var result;
        	console.log("in getState()");
        	  $.ajax({	url: urlName.getState,
        				type: 'post', async: false, data:angular.toJson($scope.address),
        				success: function(content) {
        					result=angular.fromJson(content);
        				}
        			});
        	 return result;
        }
        
        $scope.setStateToSelect=function(){
        	util.addListToSelect('stateList',$scope.getState().state,"address.state");
        	 $scope.setDistrictToSelect();
        	
        	}
        
        $scope.setDistrictToSelect=function(){
        	$scope.address.state=document.getElementById("stateList").value;
        var dd=	$scope.getDistrict();
        	util.addListToSelect('districtList',dd,"address.district");
        	console.log(angular.toJson($scope.address));
        	$scope.setTahsilToSelect();
        }
        
        $scope.setTahsilToSelect=function(){
        	$scope.address.district=document.getElementById("districtList").value;
        	util.addListToSelect('tahsilList',$scope.getTahsil(),"address.tahsil");
        	$scope.setLocaleToSelect();
        //	setTimeout(function(){console.log("in wait"+mydat);console.log("scope data on waiting "+$scope.mydata);},1000);
        }
    
        $scope.setLocaleToSelect=function(){
        	$scope.address.tahsil=document.getElementById("tahsilList").value;
        	util.addListToSelect('localeList',$scope.getLocale(),"address.locale");
        	$scope.address.locale=document.getElementById("localeList").value;
        	 }        
    })
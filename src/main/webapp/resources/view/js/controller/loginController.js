angular.module('loginController', [])
    .controller('loginController', function($scope ,$route, $rootScope, $location){
        var employee={
            name: "shani",
            roll: "student"
        };
    $scope.employee=employee;
    })
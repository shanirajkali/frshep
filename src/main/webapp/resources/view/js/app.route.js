angular.module('frshepRoutes',['ngRoute'])
    .config(function($routeProvider, $locationProvider){
            $routeProvider
                .when('/home',{
                        templateUrl: '/resources/view/jsp/hh.html',
                    })
    
                .when('/register',{
                        templateUrl: 'resources/html/register.html'
                    })
                $locationProvider.html5Mode(true);
                
            })
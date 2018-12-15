var myApp=angular.module("myApp",['ngRoute'],['ngCookies']);
myApp.config(function($routeProvider){
	alert("Route Provider");
	$routeProvider.when("/", {templateUrl: "index.html"})
				  .when("/login", {templateUrl: "views/c_User/login.html"})
				  .when("/register", {templateUrl: "views/c_User/register.html"})
				  
				  
});
var myApp=angular.module("myApp", [ 'ngRoute' ]);
myApp.config(function($routeProvider) {

	alert("Route Provider");
	$routeProvider.when("/", {
		templateUrl : "/index.html"
	}).when("/AddBlog", {
		templateUrl : "c_Blog/AddBlog.html"
	}).when("/showBlogs", {
		templateUrl : "c_Blog/showBlogs.html"
	})
});
var myApp = angular.module("myApp", ['ngRoute']);
myApp.config(function($routeProvider) {
	alert("Route Provider");
	$routeProvider.when("/", {
		templateUrl : "index.html"
	}).when('/addBlog', {
		templateUrl : "web/c_Blog/AddBlog.html"
	}).when('/AdminBlog', {
		templateUrl : "web/c_Blog/AdminBlog.html"
	}).when('/showBlogs', {
		templateUrl : "web/c_Blog/showBlogs.html"
	}).when('/login', {
		templateUrl : "web/c_User/login.html"
	}).when('/register', {
		templateUrl : "web/c_User/signup.html"
	}).when("/userhome", {
		templateUrl : "web/c_User/userhome.html"
	}).when("/profilepicture", {
		templateUrl : "web/c_User/profilepicture.html"
	}).when("/logout", {
		templateUrl : "web/c_User/logout.html"
	}).when("/showfriendlist", {
		templateUrl : "web/c_Friend/showfriendlist.html"
	}).when("/pendingrequest", {
		templateUrl : "web/c_Friend/pendingfriendrequest.html"
	}).when("/suggestionlist", {
		templateUrl : "web/c_Friend/suggestionlist.html"
	}).when("/chat", {
		templateUrl : "web/c_chat/Chat.html"
	}).when("/forum", {
		templateUrl : "web/c_Forum/forum.html"
	}).when("/AddForum", {
		templateUrl : "web/c_Forum/ManageForum.html"
	})
.otherwise({templateUrl:'web/home.html'})
});
/*myApp.run(function($rootScope, $cookieStore) {
	console.log('I am in run Function');

	console.log($rootScope.currentUser);

	if ($rootScope.currentUser == undefined) {
		console.log($cookieStore.get('userDetails'));
		$rootScope.currentUser = $cookieStore.get('userDetails');
	}
});*/
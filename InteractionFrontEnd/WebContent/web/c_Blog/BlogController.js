myApp.controller("BlogController", function($scope, $http, $location, $route) {
	$scope.blog = {
		'blogid' : 0,
		'blogname' : '',
		'blogdesc' : '',
		'createDate' : '',
		'username' : '',
		'status' : '',
		'likes' : 0,
		'dislikes' : 0
	};

	$scope.blogdata;

	function listBlog() {
		console.log("List Blog Method");
		$http.get("http://localhost:8084/InteractionMiddleWare/showBlogs")
		.then(function(response) {
			
					console.log(response.data);
			$scope.blogdata = response.data;
		});
	}

	$scope.addBlog = function() {
		console.log("Adding Blog Information");

		$http.post("http://localhost:8084/InteractionMiddleWare/AddBlog",
				$scope.blog).then(function(response) {
					console.log('Status text:' + response.statusText);
					console.log('in addBlog method')
			$location.path("/AddBlog");
		});
	}

	$scope.approve = function(blogid) {
		console.log("Approving the Blog");
		$http.get(
				"http://localhost:8084/InteractionMiddleWare/approveBlog"
						+ blogid).then(function(response) {

		});
	}

	$scope.reject = function(blogid) {
		console.log("Rejecting the Blog");
		$http.get(
				"http://localhost:8084/InteractionMiddleWare/rejectBlog"
						+ blogid).then(function(response) {

		});
	}

	$scope.incrementLikes = function(blogid) {
		console.log("Increment Likes");
		$http.get(
				"http://localhost:8084/InteractionMiddleWare/incrementLikes"
						+ blogid).then(function(response) {
			$route.reload();
		});
	}

	$scope.incrementDislikes = function(blogid) {
		console.log("Increment Dislikes");
		$http.get(
				"http://localhost:8084/InteractionMiddleWare/incrementDislikes"
						+ blogid).then(function(response) {

		});
	}

	listBlog();
});
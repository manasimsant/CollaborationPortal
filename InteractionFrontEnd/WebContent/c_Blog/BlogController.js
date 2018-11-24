myApp.controller("BlogController",function($scope,$http,$location,$route)
{
	$scope.blog={'blogid':0,'blogName':'','blogdesc':'','createDate':'','loginame':'','status':'','likes':0,'dislikes':0};
	
	$scope.blogdata;
	
	function listBlog()
	{
		console.log('List Blog Method');
		$http.get('http://localhost:8041/InteractionMiddleware/showBlogs')
		.then(function(response)
				{
				console.log(response.data);
				$scope.blogdata=response.data;
				});
	}
	
	$scope.addBlog=function()
	{
		console.log('Adding Blog Information');
		
		$http.post('http://localhost:8041/InteractionMiddleware/AddBlog',$scope.blog)
		.then(function(response){
			$location.path("/AddBlog");
		});
	}
	
	$scope.approve=function(blogid)
	{
		console.log('Approving the Blog')
		$http.get('http://localhost:8041/InteractionMiddleware/approveBlog/'+blogid)
		.then(function(response){
			
		});
	}
	
	$scope.reject=function(blogid)
	{
		console.log('Rejecting the Blog')
		$http.get('http://localhost:8041/InteractionMiddleware/rejectBlog/'+blogid)
		.then(function(response){
			
		});
	}
	
	$scope.incrementLikes=function(blogid)
	{
		console.log('Increment Likes');
		$http.get('http://localhost:8041/InteractionMiddleware/incrementLikes/'+blogid)
		.then(function(response){
			$route.reload();
		});
	}
	
	$scope.incrementDisLikes=function(blogid)
	{
		console.log('Increment DisLikes');
		$http.get('http://localhost:8041/InteractionMiddleware/incrementDisLikes/'+blogid)
		.then(function(response){
			
		});
	}
	
	
	listBlog();
});
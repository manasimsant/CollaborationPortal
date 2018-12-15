myApp.controller("UserController", function($scope, $http, $location,
		$rootScope) {

	$scope.User = {
		'loginname' : '',
		'password' : '',
		'username' : '',
		'email' : '',
		'mobileno' : '',
		'address' : '',
		'role' : ''

	};

	$scope.register = function() {
		console.log('Enter the Register Function');
		$scope.User.role = 'ROLE_USER';
		$http.post('http://localhost:8083/InteractionMiddleware/registerUser',
				$scope.User).then(function(response) {
			console.log("Registered");
			$location.path("/login");
		});
	}

	$scope.logincheck = function() {
		console.log('Enter the Login Check Function')
		$http.post('http://localhost:8083/InteractionMiddleware/checkUser',
				$scope.User).then(function(response) {
			console.log('Login Checked');
			$scope.User = response.data;
			$rootScope.currentUser = response.data;
			/*$cookieStore.put('user', response.data);*/
			console.log($rootScope.currentUser);
			$location.path("/userhome");
		});
	}

	$scope.logout = function() {
		console.log('I am in logout Function');
		delete $rootScope.currentUser;
		/*$cookieStore.remove('user');*/
		$location.path("/logout");
	}

});
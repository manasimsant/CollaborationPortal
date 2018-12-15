/**
 * 
 */
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
		console.log("Enter the register function");
		$scope.User.role = 'ROLE_USER';
		$http.post('http://localhost:8084/InteractionMiddleWare/registerUser',
				$scope.User).then(function(response) {
			console.log('User Registered')
			$location.path("/login")
		});
	}

	$scope.logincheck = function() {
		console.log("Enter loginchech() function");
		$http.post('http://localhost:8084/InteractionMiddleWare/checkUser',
				$scope.User).then(function(response) {
			console.log("Login checked");
			$scope.User = response.data;
			$rootScope.currentUser = response.data;
			$cookieStore.put('userDetails', response.data);
			console.log($rootScope.User);
			$location.path("/userhome");
		});

	}

	$scope.logout = function() {
		console.log("I am in a logout() function");
		delete $rootScope.currentUser;
		$cookieStore.remove('userDetails');
		$location.path("/logout");
	}

});
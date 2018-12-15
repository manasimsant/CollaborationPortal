/*myApp.controller("ChatController", function($scope, $rootScope, chatService) {

	console.log("Starting Chat Controller");

	$scope.messages = [];
	$scope.message = "";
	$scope.max = 140;

	$Scope.addMessage = function() {

		console.log('Adding message method');
		chatService.send($rootScope.currentUser.loginname + ":"
				+ $scope.message);
		$scope.message = "";
	};

	chatService.receive().then(null, null, function(message) {
		console.log('receive method');
		$scope.messages.push(message);
	});

});*/
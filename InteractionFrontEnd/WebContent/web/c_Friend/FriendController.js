myApp
		.controller(
				"FriendController",
				function($scope, $http, $location, $rootScope) {

					$scope.friend = {
						"friendid" : 0,
						"loginname" : '',
						"friendloginname" : '',
						"status" : ''
					};

					$scope.showfriendlist;
					$scope.pendingfriendrequest;
					$scope.suggestionlist;
		
		//---------------------------------------friendlist funtion------------------------------
					function showfriendlist() {
						console.log("Entered into the showAllFriend() method");
						loginname=$rootScope.currentUser.loginname;
						console.log(loginname);
						$http.get('http://localhost:8083/InteractionMiddleWare/showfriendlist'+loginname)
								.then(function(response) {
											$scope.showfriendlist = response.data;
											console.log('Fetched data :'
													+ $scope.showfriendlist);
										});
					}
	//--------------------------------pending friend requests-----------------------------------------------
					function pendingfriendrequest() {
						console.log("Entered into the pendingFriendRequest() method");
						loginname=$rootScope.currentUser.loginname;
						$http.get('http://localhost:8083/InteractionMiddleWare/pendingfriendrequest'+loginname)
								.then(function(response) {
											$scope.pendinfriendreuqest=response.data;
											console.log($scope.suggestionlist)
								});
					}
	//---------------------------------------------suggested friend list---------------------------------------------
					function suggestionlist() {
						console.log("Entered into the suggestedlist() method");
						$http.get('http://localhost:8083/InteractionMiddleWare/suggestionlist')
								.then(function(response) {
											$scope.suggestionlist = response.data;
											console.log($Scope.pendingFriendRequest);
										});
					}
					
					//---------------------------accept friend data-------------------------------------------
					$scope.unfriend = function(friendid) {
						console.log("Entered into the acceptFriendRequest() method");
						$http.get('http://localhost:8041/InteractionMiddleWare/acceptfriendrequest'+ friendid)
						.then(function(response) {
							console.log(response.statusText);
							$location.path("/showfriendlist")
						});
					}
			//--------------------delete friend data--------------------------------------------------------
					$scope.accept = function(friendid) {
						console.log("Entered into the acceptFriendRequest() method");
						$http.get('http://localhost:8041/InteractionMiddleWare/acceptfriendrequest'+ friendid)
						.then(function(response) {
							console.log(response.statusText);
							$location.path("/showfriendlist")
						});
					}
					
		//----------------------------------------sending friend request------------------------------------
					$scope.sendfriendrequest = function(loginname1) {
						$scope.friend.loginname=$rootScope.currentUser.loginname;
						$scope.friend.friendloginname=loginname1;
						
						$http.post('http://localhost:8041/InteractionMiddleWare/sendfriendrequest'+ $scope.friend)
						.then (function(response) {
									console.log('sending request to'+ loginname + '..!!');
								});
					}

					suggestionlist();
					pendingfriendrequest();
					showfriendlist();

				});

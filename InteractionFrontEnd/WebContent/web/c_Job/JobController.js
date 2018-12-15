myApp.controller("JobController", function($scope, $http, $location, $route) {

	$scope.job = {

		'id' : 0,
		'jobTitle' : '',
		'jobDescription' : '',
		'skillsRequired' : '',
		'salary' : '',
		'location' : '',
		'companyName' : 0,
	};

	$scope.jobdata;

	function ShowAllJobs() {
		console.log("List Job Method");
		$http.get("http://localhost:8083/InteractionMiddleWare/ShowAllJobs",
				$scope.job).then(function(response) {

			console.log(response.data);
			$scope.jobdata = response.data;
		});

	}

	function ApplyJob() {
		console.log("Apply Job method")
		$http.get("http://localhost:8083/InteractionMiddleWare/ApplyJob",
				$scope.job).then(function(response) {

			console.log(response.data);
			$scope.jobdata = response.data;

		});
	}

	function AddJob() {
		console.log("Add Job Method")
		$http.get("http://localhost:8083/InteractionMiddleWare/AddJob",
				$scope.job).then(function(response) {

			console.log(response.data);
			$scope.jobdata = response.data;
		});
	}
});
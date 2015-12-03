var app = angular.module('myApp01', []);

app.run(function($rootScope) {
	$rootScope.name = "Test User";
	$rootScope.clickCounter = -5;
});

app.controller('PersonController', function($scope) {
	$scope.person = {
		firstName : "first name",
		sureName : "sure name",
		age : 34
	};
});

app.controller('StudentController', function($scope, $http) {
	var url="http://localhost:8080/mf-restfull-server/mpfactory/hello/firstCityJson";
	$http.get(url).success( function(response) {
		$scope.students = response;
		});
});

app.controller('CitiesController', function($scope, $http) {
	var url="http://localhost:8080/mf-restfull-server/data.txt";
	$http.get(url).success( function(response) {
		$scope.cities = response;
		});
});

app.controller('CitiesJsonController', function($scope, $http) {
	var url="http://localhost:8080/mf-restfull-server/mpfactory/hello/citiesJson";
	$http.get(url).success( function(response) {
		$scope.cities = response;
		});
});

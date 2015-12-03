var app = angular.module('appCity', [ ]);

app.controller('CityController', function($scope, $http) {
	var url = "http://localhost:8080/mf-restfull-server/mpfactory/city/cities";
	$http.get(url).success(function(response) {
		$scope.cities = response;
	});
	
	$scope.ecity = {
			name : "City name",
			id : -22,
			ord : -99
		};
	
	$scope.getCity = function(Edata){
		var url = "http://localhost:8080/mf-restfull-server/mpfactory/city/cities/" + Edata.id;
		$http.get(url).success(
			function(response){
				$scope.ecity = response;
			}
		).error(function(response, status, headers, config){
			alert(data.summary);
		})
	}

});

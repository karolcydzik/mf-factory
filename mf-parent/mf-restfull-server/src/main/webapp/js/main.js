var app = angular.module('myApp', []);

app.run(function($rootScope) {
	$rootScope.name = "Ari Lerner";
});

app.controller('MyController', function($scope) {
	$scope.person = {
		namep : "Ari Lerner01",
		age : 34
	};
});

app.controller('ParentController', function($scope) {
	$scope.person = {
		greeted : false
	};
});

app.controller('ChildController', function($scope) {
	$scope.sayHello = function() {
		$scope.person.greeted = true;
	}
});

app.controller('PlayerController', [ '$scope', function($scope) {
	$scope.audio = document.createElement('audio');
} ]);

app.controller('RelatedController', [ '$scope', function($scope) {
} ]);

app.controller('MyController01', function($scope) {
	$scope.person = {
		name : "Ari Lerner"
	};
	var updateClock = function() {
		$scope.clock = new Date();
	};
	var timer = setInterval(function() {
		$scope.$apply(updateClock);
	}, 1000);
	updateClock();
});
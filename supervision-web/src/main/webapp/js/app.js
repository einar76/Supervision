
app.controller('SupervisionCtrl', function($scope, $http, $translate) {

	$scope.title = "Supervision";
	$scope.requestsTitle = "Requêtes";
	$scope.sessionsTitle = "Sessions";
	$scope.resourcesTitle = "Resources";
	$scope.indicatorsTitle = "Indicateurs";

	$scope.updateIndicators = function() {
		$http.get("supervision/indicator/informations").success(
				function(data, status, headers, config) {
					$scope.indicators = data;
				});
	};
	$scope.updateRequests = function() {
		$http.get("supervision/request/stat").success(
				function(data, status, headers, config) {
					$scope.nbTotalReq = data.nbTotal;
					$scope.nbOkReq = data.nbOk;
					$scope.errorRatioReq = data.errorRatio;
					$scope.minDurationReq = data.minDuration;
					$scope.maxDurationReq = data.maxDuration;
					$scope.avgDurationReq = data.avgDuration;
				});
	};
	$scope.updateSessions = function() {
		$http.get("supervision/session/stat").success(
				function(data, status, headers, config) {
					$scope.nbTotalSes = data.nbTotal;
					$scope.nbOpenedSes = data.nbOpened;
					$scope.minDurationSes = data.minDuration;
					$scope.maxDurationSes = data.maxDuration;
					$scope.avgDurationSes = data.avgDuration;
				});
	};
	$scope.updateResources = function() {
		$http.get("supervision/resource/informations").success(
				function(data, status, headers, config) {
					$scope.resources = data;
				});
	};

	$scope.changeLanguage = function(key) {
		sessionStorage.setItem('lang',key);
		$translate.use(key);
	};

	$scope.updateIndicators();
	$scope.updateRequests();
	$scope.updateSessions();
	$scope.updateResources();

});

app.filter('booleanFilter', function() {
	return function(ok) {
		return ok ? 'OK' : 'KO';
	}
})
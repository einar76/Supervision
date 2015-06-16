
app.config([ '$locationProvider', function AppConfig($locationProvider) {
	$locationProvider.html5Mode(true);
} ]);

app.controller('resourceChartsCtrl', function($scope, $http, $location) {

	var id = $location.search().id;

	var options = optionsLigneBleu;

	var dataExecution = ligneBleu;
	var dataError = barreRouge;

	var ctx = document.getElementById("myExecutionChart").getContext("2d");
	var ctx2 = document.getElementById("myErrorChart").getContext("2d");

	var myNewChart;
	var myNewChart2;

	$scope.updateDetails = function() {
		$http.get("supervision/resource/detail?id=" + id).success(
		// $http.get("./js/dummy/resource.json").success(
		function(data, status, headers, config) {

			$scope.resourceName=data.name;
			
			var x = [];
			var y1 = [];
			var y2 = [];

			var indice = Math.floor(data.executions.length / 9);
			for ( var key in data.executions) {

				var objet = data.executions[key];
				var d = new Date(objet.date);

				var ko = 0;
				if (!objet.state) {
					ko = 1;
				}

				var legend = "";
				if (key % indice === 0) {
					legend = d.getHours() + "h" + d.getMinutes();
					if (d.getMinutes() < 10) {
						legend = d.getHours() + "h0" + d.getMinutes();
					}
				}

				x.push(legend);
				y1.push(objet.time);
				y2.push(ko);
			}

			dataExecution.labels = x;
			dataExecution.datasets[0].data = y1;
			dataError.labels = x;
			dataError.datasets[0].data = y2;

			myNewChart = new Chart(ctx).Line(dataExecution, options);
			myNewChart2 = new Chart(ctx2).Bar(dataError, options);

		});
	};

	$scope.updateDetails();

});
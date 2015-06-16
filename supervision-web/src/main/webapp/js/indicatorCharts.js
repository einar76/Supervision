
app.config([ '$locationProvider', function AppConfig($locationProvider) {
	$locationProvider.html5Mode(true);
} ]);

app.controller('indicatorChartsCtrl', function($scope, $http, $location) {

	var id = $location.search().id;

	$scope.title = 'INDICATOR_TITLE';

	var options = optionsLigneBleu;
	var dataExecution = ligneBleu;

	var ctx = document.getElementById("myChart").getContext("2d");
	var myNewChart;

	$scope.updateIndicator = function(mode, datedebut) {

		var start = "";
		var end = "";
		
		if (mode!=undefined) {
			
			if (datedebut==undefined) {
				var d = new Date();
				d.setHours(0);
				d.setMinutes(0);
				d.setSeconds(0);
				d.setMilliseconds(0);
				start="&start="+d.getTime();
			}
			
			if (mode=='WEEK') {
				var d = new Date();
				d.setTime(datedebut);
				d.setDate(d.getDate()+7);
				end="&end="+d.getTime();
			}
			else if (mode=='MONTH') {
				var d = new Date();
				d.setTime(datedebut);
				d.setDate(d.getDate()+31);
				end="&end="+d.getTime();
			}
		}
		else {
			var d = new Date();
			d.setHours(0);
			d.setMinutes(0);
			d.setSeconds(0);
			d.setMilliseconds(0);
			start="&start="+d.getTime();
		}
		
		$http.get("supervision/indicator/detail?id=" + id+start+end).success(
		// $http.get("./js/dummy/indicator.json").success(
		function(data, status, headers, config) {

			$scope.indicatorName = data.name;
			
			var x = [];
			var y = [];

			var indice = Math.floor(data.informations.length / 9);
			for ( var key in data.informations) {

				var objet = data.informations[key];
				var d = new Date(objet.date);

				var legend = "";
				if (key % indice === 0) {
					legend = d.getHours() + "h" + d.getMinutes();
					if (d.getMinutes() < 10) {
						legend = d.getHours() + "h0" + d.getMinutes();
					}
				}

				x.push(legend);
				y.push(objet.value);

			}

			dataExecution.labels = x;
			dataExecution.datasets[0].data = y;

			myNewChart = new Chart(ctx).Line(dataExecution, options);

		});
	};

	$scope.updateIndicator();

});

app.controller('sessionsChartsCtrl', function($scope, $http, $translate) {
	
	var options = optionsBarreVertEtRouge;
	var dataBar = barreVertEtRouge;
	
	$translate('SESSION_LABEL1')
    .then(function (translatedValue) {
    	dataBar.datasets[0].label = translatedValue;
    });

	$translate('SESSION_LABEL2')
    .then(function (translatedValue) {
    	dataBar.datasets[1].label = translatedValue;
    });
	
	var ctx = document.getElementById("myChart").getContext("2d");
	var myNewChart;

	$scope.updateHistorisation = function() {
//		$http.get("supervision/session/historisation").success(
		 $http.get("./js/dummy/sessions.json").success(
		function(data, status, headers, config) {

			var x = [];
			var y1 = [];
			var y2 = [];

			var total = 0;
			for ( var key in data.creations) {
				total++;
			}

			var i = 0;
			var indice = Math.floor(total / 9);
			for ( var key in data.creations) {

				var ok = data.creations[key];
				var ko = data.destructions[key];

				var legend = "";
				if (i % indice === 0) {
					var d = new Date(key * data.interval);
					legend = d.getHours() + "h" + d.getMinutes();
					if (d.getMinutes() < 10) {
						legend = d.getHours() + "h0" + d.getMinutes();
					}
				}

				x.push(legend);
				y1.push(ok);
				y2.push(ko);

				i++;
			}

			dataBar.labels = x;
			dataBar.datasets[0].data = y1;
			dataBar.datasets[1].data = y2;

			myNewChart = new Chart(ctx).Bar(dataBar, options);
			document.getElementById('legend').innerHTML = myNewChart.generateLegend();

		});
	};

	$scope.updateHistorisation();

});
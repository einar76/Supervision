
app.controller('requestsChartsCtrl', function($scope, $http, $translate) {

	var options = optionsBarreVertEtRouge;
	var dataBar = barreVertEtRouge;
	var dataDonut = [];

	$translate('REQUEST_LABEL1')
	    .then(function (translatedValue) {
	    	dataBar.datasets[0].label = translatedValue;
	    });

	$translate('REQUEST_LABEL2')
	    .then(function (translatedValue) {
	    	dataBar.datasets[1].label = translatedValue;
	    });

	
	var ctx = document.getElementById("myChart").getContext("2d");
	var myNewChart;
	var ctx2 = document.getElementById("myDonutChart").getContext("2d");
	var myPieChart = new Chart(ctx2).Pie(dataDonut, options);

	$scope.updateHistorisation = function() {
		$http.get("supervision/request/historisation").success(
		// $http.get("./js/dummy/requests.json").success(
		function(data, status, headers, config) {
			
			var x = [];
			var y1 = [];
			var y2 = [];

			myPieChart.removeData();
			myPieChart.removeData();

			var total = 0;
			var totalKos = 0;
			for ( var key in data.kos) {
				total++;
				if (data.kos[key] > 0) {
					totalKos++;
				}
			}

			myPieChart.addData({
				value : total - totalKos,
				color : "#46BFBD",
				highlight : "#5AD3D1",
				label : dataBar.datasets[0].label
			});

			myPieChart.addData({
				value : totalKos,
				color : "#F7464A",
				highlight : "#FF5A5E",
				label : dataBar.datasets[1].label
			});

			var i = 0;
			var indice = Math.floor(total / 9);
			for ( var key in data.oks) {

				var ok = data.oks[key];
				var ko = data.kos[key];

				var legend = "";
				if (i % indice === 0) {
					var d = new Date(key * data.interval);
					legend = d.getHours() + "h" + d.getMinutes();
					if (d.getMinutes() < 10) {
						legend = d.getHours() + "h0" + d.getMinutes();
					}
				}

				if (ko != 0) {
					x.push(legend);
					y1.push(ok);
					y2.push(ko);
				} else {
					x.push(legend);
					y1.push(ok);
					y2.push("");
				}

				i++;
			}

			dataBar.labels = x;
			dataBar.datasets[0].data = y1;
			dataBar.datasets[1].data = y2;

			myNewChart = new Chart(ctx).Bar(dataBar, options);
			document.getElementById('legend1').innerHTML = myNewChart.generateLegend();
			document.getElementById('legend2').innerHTML = myPieChart.generateLegend();

		});
	};

	$scope.updateHistorisation();

});
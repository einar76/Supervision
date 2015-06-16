var ligneBleu = {
	labels : [],
	datasets : [ {
		label : "Data",
		fillColor : "rgba(99,184,255,0.2)",
		strokeColor : "rgba(99,184,255,1)",
		pointColor : "rgba(99,184,255,1)",
		pointStrokeColor : "#fff",
		pointHighlightFill : "#fff",
		pointHighlightStroke : "rgba(99,184,255,1)",
		data : []
	} ]
};

var barreRouge = {
	labels : [],
	datasets : [ {
		label : "Data",
		fillColor : "rgba(255,0,0,0.2)",
		strokeColor : "rgba(255,0,0,1)",
		pointColor : "rgba(255,0,0,1)",
		pointStrokeColor : "#fff",
		pointHighlightFill : "#fff",
		pointHighlightStroke : "rgba(255,0,0,1)",
		data : []
	} ]
};

var barreVertEtRouge = {
	labels : [],
	datasets : [ {
		label : "Requests",
		fillColor : "rgba(70,191,189,0.2)",
		strokeColor : "rgba(70,191,189,1)",
		highlightFill : "rgba(70,191,189,1)",
		highlightStroke : "rgba(70,191,189,1)",
		data : []
	}, {
		label : "Error",
		fillColor : "rgba(255,0,0,0.2)",
		strokeColor : "rgba(255,0,0,1)",
		highlightFill : "rgba(255,0,0,1)",
		highlightStroke : "rgba(255,0,0,1)",
		data : []
	} ]
};

var optionsLigneBleu = {
	animation : false,
	scaleShowVerticalLines : false,
	scaleGridLineColor : "rgba(0,0,0,.1)",
	scaleLineColor : "rgba(0,0,0,.5)",
	pointDot : false,
	pointDotRadius : 4,
	pointDotStrokeWidth : 1,
	bezierCurve : true,
	bezierCurveTension : 0.2,
	showTooltips: false,
};

var optionsBarreVertEtRouge = {
	animation : false,
	scaleShowVerticalLines : false,
	scaleGridLineColor : "rgba(0,0,0,.1)",
	scaleLineColor : "rgba(0,0,0,.5)",
	barValueSpacing : 1,
	showTooltips: false,
};
var app = angular.module('app', ['ui.router']);

app.config(function($stateProvider, $urlRouterProvider) {
    
    $urlRouterProvider.otherwise('/welcome');
    
    $stateProvider
        .state('welcome', {
            url: '/welcome',
            templateUrl: '../page/welcome.html',
            controller: 'WelcomeCtrl'
        })
        .state('F1', {  
            url: '/F1',
            templateUrl: '../page/F1.html',
            controller: 'F1Ctrl'
        })
        .state('F2', {  
            url: '/F2',
            templateUrl: '../page/F2.html',
            controller: 'F2Ctrl'
        });
        
});

app.controller('TilesCtrl', function($scope, $http, $location) {
	
});
app.controller('WelcomeCtrl', function($scope,$rootScope) {
	
	
});
app.controller('F1Ctrl', function($scope,$rootScope) {

	$scope.imageN=[{"src":"http://media.allhtml.com/resources/HTML5_Logo_256.png","alt":"PNG"},{"src":"https://tv-wordpress.s3.amazonaws.com/a/wp-content/uploads/html.gif","alt":"GIF"}];
	$scope.firstname="Mon Nom";
	$scope.lastname="Mon Prenom";
	
});
app.controller('F2Ctrl', function($scope,$rootScope) {

	$scope.paragraphe="contenu de paragraphe variable ...";
	$scope.tableauMN={"colonnes":["Colonne 1","Colonne 2"],"data":[{"x":"10","y":"100"},{"x":"150","y":"1000"},{"x":"2","y":"3"}]};
	$scope.tableau2N=[{"x":"10","y":"100"},{"x":"10","y":"100"},{"x":"10","y":"100"}];
	$scope.listN=["element1","element2","element3","element4"];
	
});

app.controller('EmptyCtrl', function($scope, $http, $location) {});
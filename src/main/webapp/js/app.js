
var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider){
    
    $routeProvider
    .when('/', {
        templateUrl: '/views/accueil.html',controller: 'HomeCtrl'})
       
           
    .when('/Geeks', {
        templateUrl: '/views/GetLesGeeks.html',
        controller: 'AllGeeks'})
        
     .when('/search', {
        templateUrl: '/views/search.html',controller: 'HomeCtrl'}) 
        
     .when('/Geeks/:sexe/:interet', {
    	 templateUrl: '/views/GetLesGeeks.html',
         controller: 'GetGeekBySexeAndInteret'})
         
    .when('/Geeks/:sexe', {
        templateUrl: '/views/GetLesGeeksBySexe.html',
        controller: 'GeeksBySexe'})
        
    .when('/GeeksById/:id', {
        templateUrl: '/views/LeGeek.html',
        controller: 'LeGeek'})
        
});

app.controller('LeGeek', function($scope, $http, $routeParams) {
	
	$http({url: '/Geeks/' +$routeParams.id,method: 'GET'
	}).success(function(geekToShow) {
    	$scope.LeGeek = geekToShow;});	
	
	 $http.get('/Consultation/'+$routeParams.id).success(function(history) {
	        $scope.visite = history;
	    });
})


app.controller('GeeksBySexe', function($scope, $http, $routeParams) {
	 $http.get('/Geeks' ,{params:{sexe:$routeParams.sexe}} ).success(function(Geeks) {
	        $scope.Geeks = Geeks;
	 });

		    
});

app.controller('AllGeeks', function($scope, $http) {
	
	 $http.get('/Geeks').success(function(Geeks) {
	        $scope.Geeks = Geeks;
	 });
	 $scope.interets = {};
	$http.get('/interet').success(function(data) {
	   $scope.interets = data;
	 });
	    
	 
});

app.controller('GetGeekBySexeAndInteret', function($scope, $http,$routeParams) {
	$http({
		url: '/Geeks/' +$routeParams.sexe+'/'+$routeParams.interet,
		method: 'GET'
	}).success(function(geeksToShow) {
		$scope.Geeks = geeksToShow;
    });	

});

app.controller('HomeCtrl', function($scope, $http, $location) {
	$scope.interets = {};
	$scope.sexe = "m";
	$scope.monInteret = "";
	
	$scope.cacher = true;
		
    $http.get('/interet').success(function(data) {
        $scope.interets = data;
    });
    
    $scope.rechercher = function () {
    	if($scope.monInteret== ""){
    		$scope.cacher = false;
    	} else {
    		$scope.cacher = true;
    		$location.url("/Geeks/"+$scope.sexe+'/'+$scope.monInteret.nom);
    	}
    };
});
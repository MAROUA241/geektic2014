
var app = angular.module("geektic", ['ngRoute']);

app.config(function($routeProvider){
    
    $routeProvider
    .when('/', {
        templateUrl: '/views/accueil.html'})     
});


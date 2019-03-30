angular.module("chaApp", ['ngRoute', 'ngMaterial', 'ngMessages'])
    .config(function($routeProvider){
        var routeConfig = $routeProvider;

            routeConfig.when("/",{
                controller: 'InicioController',
                templateUrl: 'templates/inicio.html'
            })
                .when("/igrejas", {
                    controller: 'IgrejaController',
                    templateUrl: 'templates/igreja.html'
                })
                .otherwise("/");
        })

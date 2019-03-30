angular.module("chaApp").controller("IgrejaController", ['$scope', '$http', function($scope, $http){
    $http.get("/igrejas").then(function (value) {
        $scope.igrejas = value.data;
    })
}])
(function() {

    var app = angular.module('interviewQs');
    app.controller('QuestionController', ['$http', '$scope', function($http, $scope) {
        $http.get("/problems").
            then(function(response) {
            $scope.qs = response.data;
            console.log($scope.qs);
        })
    }]);
});

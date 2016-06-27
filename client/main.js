(function() {
	var app = angular.module('interviewQs', ['ngFileUpload']);

	app.controller('QuestionController', ['$http', '$scope', function($http, $scope) {

		$http.get("/problems").
            then(function(response) {
                $scope.qs = response.data;
                $scope.isValid = true;
        })
	}]);

	var server = "http://127.0.0.1:3030";
    app.controller('fileUploader', ['$scope', 'Upload', '$timeout', function ($scope, Upload, $timeout) {

        // upload
        $scope.uploadFiles = function(file,errFiles,problem) {

            $scope.file = file;
            $scope.errFiles = errFiles;
            if (file) {
                file.upload = Upload.upload({
                    url: server + "/file",
                    type: 'POST',
                    data: {file: file, problem: problem}
                });

                file.upload.then(function (response) {
                    $timeout(function () {
                        file.result = response.data;

                        // if else block controls return diplay
                        var ret = response.data;
                        $scope.attempt = true;
                        $scope.status = ret.status;
                        $scope.text = ret.text;
                    });
                }, function (response) {
                    if (response.status > 0)
                        $scope.errorMsg = response.status + ': ' + response.data;
                }, function (evt) {
                    file.progress = Math.min(100, parseInt(100.0 * 
                        evt.loaded / evt.total));
                });
            }   
        }
    }]);
})();

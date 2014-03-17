'use strict';


/* Controllers */
angular.module('myApp.controllers', []).
  controller('echoServiceController', ['$scope', 'echo_client',function($scope, echo_client) {
	  $scope.input = {text : "Hello World"};
	  $scope.output = {text : ""};
	  
	  $scope.echo = function() {
		  echo_client.echo($scope.input.text).then(function(message){
			  $scope.output.text = message;
			  if(!$scope.$$phase) {
				  $scope.$apply();
			  }
		  });
		  		  
      };
 }]);
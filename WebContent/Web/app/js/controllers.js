'use strict';


/* Controllers */
angular.module('myApp.controllers', []).
  controller('echoServiceController', ['$scope','echo_client',function($scope, echo_client) {
	  $scope.input = {text : "Hello World"};
	  $scope.output = {text : ""};
	  
	  $scope.echo = function() {		  
		  $scope.output.text = echo_client.echo($scope.input.text);		  
      };
 }]);
'use strict';

/* Services */
angular.module('myApp.services', []).
factory('echo_client',function($window) {		
	var EchoClient = $window.EchoClient;
    return {
        echo: function(message) {     	
        	var result = EchoClient.echo(message);
            return result;
        }
    };
  return EchoClient;
});

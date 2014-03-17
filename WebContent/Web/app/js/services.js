'use strict';

/* Services */
angular.module('myApp.services', []).
factory('echo_client',function($window, $q) {		
	var EchoClient = $window.EchoClient;
    return {
        echo: function(message) {     	
        	var defered = $q.defer();
        	var result = EchoClient.echo(message);
        	defered.resolve(result);
        	
            return defered.promise;
        }
    };
  return EchoClient;
});

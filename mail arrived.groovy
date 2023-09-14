rule "mail arrived.groovy"

	device accelerationSensor : accelerationSensor;
	output send : string;

	accelerationSensor.pushNotification [ .~>currentPushNotification ];
	
		currentPushNotification == false;
		send ( "not arrived mail" );

  	      | currentPushNotification == true;
		send ( "arrived mail" );

end
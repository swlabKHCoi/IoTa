mail-arrived 코드는 우편함 문에 센서가 설치되어 있고 해당 센서가 활성화될 때 알림을 보내는 기능을 수행합니다.

accelerationActiveHandler() 함수: 센서에서 활성화 이벤트가 발생하면 호출되는 함수입니다. 이 함수는 일정 시간 동안 활성화 이벤트를 추적하여 중복 알림을 방지하고, 설정된 대상에게 알림을 보냅니다.

```
rule "mail when arrived"
		accelerationSensor.acceleration [ .~>active ];
		true;
		send ( "arrived mail" )
	end

	rule "mail not arrived"
		accelerationSensor.acceleration [ .~>inactive ];
		true;
		send ( "not arrived mail" )
	end
```
메일이 왔을 때 안 왔을때를 나눠서 메세지를 보내는 상황을 나눴습니다.

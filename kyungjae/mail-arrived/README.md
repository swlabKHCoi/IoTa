<h3>#기능</h3>
mail-arrived 코드는 우편함 문에 센서가 설치되어 있고 해당 센서가 활성화될 때 알림을 보내는 기능을 수행합니다.

<h3>#구현</h3>
accelerationActiveHandler() 함수
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

<h3>#문제점</h3>


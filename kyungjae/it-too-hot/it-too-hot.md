it-too-hot.groovy 코드의 기능은 온도를 감지하고, 설정된 온도를 초과하면 사용자에게 알림을 보내고 설정된 스위치를 작동시킵니다.

위의  기능을 수행하는 함수는 def temperatureHandler(evt) 입니다.

currentTemperature ≥ temperature;
		send (”temperature too low”),
		switch1.switch := off;

	| currentTemperature < temperature;
		send (”temperature too high”),
		switch1.switch := on;

최저 온도와 최대 온도를 설정해서 그 구간을 넘어갈시  동작을 수행하도록 번역하였습니다.


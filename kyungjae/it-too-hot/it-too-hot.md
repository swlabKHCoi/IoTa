<h3>#기능</h3>
it-too-hot.groovy 코드의 기능은 온도를 감지하고, 설정된 온도를 초과하면 사용자에게 알림을 보내고 설정된 스위치를 작동시킵니다.
<br/>
<h3>#구현</h3>
def temperatureHandler(evt) 

```
currentTemperature ≥ temperature;
		send (”temperature too low”),
		switch1.switch := off;

	| currentTemperature < temperature;
		send (”temperature too high”),
		switch1.switch := on;
```
<h3>#문제점</h3>


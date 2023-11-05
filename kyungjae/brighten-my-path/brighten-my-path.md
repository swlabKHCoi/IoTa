brighten-my-path 코드는 움직임이 감지되면 조명을 켭니다.

motionActiveHandler(evt) 함수: 이 함수는 움직임 감지 이벤트가 발생할 때 호출됩니다. 이벤트에 따라 설정된 스위치를 켭니다. switch1.on()을 호출하여 설정된 스위치를 활성화합니다.

```
motion1.motion [ .~> active ];
light == true;
switch1:= on
```
이렇게 해석을 했고 switch1가 multple이 true 상태라 여러개의 switch값을 어떻게 정할지 이야기가 필요할 것 같습니다.

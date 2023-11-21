<h3>#기능</h3>
brighten-my-path 코드는 움직임이 감지되면 조명을 켭니다.

<h3>#구현</h3>
def motionActiveHandler(evt) 함수

```
motion1.motion [ .~> active ];
light == true;
switch1:= on
```

<h3>문제점</h3>

```
input "switch1", "capability.switch", multiple: true
```

multiple을 구현할 방법을 모르겠다.

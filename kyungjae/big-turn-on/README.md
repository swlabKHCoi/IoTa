<h3>#기능</h3>
big-turn-on 코드는 SmartApp이 탭되거나 활성화될 때 지정된 스위치를 켜는 것을 목
적으로 합니다.

<h3>#기능</h3>
def changedLocationMode(evt) 함수
```
device switches : switch;
    input television : bool; -> 기기를 input값으로 하나하나 선언했는데 이를 한번
에 저장하면 좋을 것 같습니다.
    input airconditional : bool;

    switches.switch [ .~> on ];

    television == true;
    switch := on

  | airconditional == true;
    switch := on
```

<h3>#문제점</h3>
```
input "switches", "capability.switch", multiple: true
```
multiple을 구현할 방법을 모르겠다.

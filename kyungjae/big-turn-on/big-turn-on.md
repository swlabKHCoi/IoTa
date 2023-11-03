big-turn-off 코드는 SmartApp이 탭되거나 활성화될 때 지정된 스위치를 키는 것을 목적으로 합니다.

changedLocationMode 함수: 위치 모드 변경 이벤트가 발생할 때 호출되며, 선택한 스위치를 키도록 설정합니다.

여기서 지정된 기기가 여러개일수 있는데 이것을 한번에 저장할 방법을 모르겠습니다.

```
 device switches : switch;
    input television : bool;     -> 해당 기기들을 한번에 저장할 수 있는 타입이 있으면 좋을 것 같습니다.
    input airconditional : bool; ->

    switches.switch [ .~> on ];

    television == true;
    switches := on

  | airconditional == true;
    switches := on
```

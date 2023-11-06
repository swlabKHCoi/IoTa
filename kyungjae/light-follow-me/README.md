<h3>#기능</h3>
light-follow-me.groovy 코드는 움직임 감지를 통해 조명을 자동으로 제어하는 기능을 한다.

<h3>#구현</h3>
def motionHandler(evt) 함수 - motion1 ~> active 상태일때</br>
def scheduleCheck() 함수 - motion1 ~> inactive 상태일때 일정 시간이 지나고 스위치를 끔

```
 rule "motionSensor active"

        motion1.motion [ .~> active ];
        true;
        switch := on

    end

    rule "motionSensor inactive"

        myTimer [ .~> timer ];
        timer == minutes1;
        stop myTimer;
        switch := off,
        start myTimer at 0;

    end
```

<h3>#문제점</h3>

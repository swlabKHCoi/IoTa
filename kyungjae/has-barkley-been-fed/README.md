<h3>#기능</h3>
has-barkley-been-fed.groovy 코드는 반려동물에게 먹이를 주는 일정을 설정하고, 사용자에게 알림을 보내준다.

<h3>#구현</h3>
def scheduleCheck() 함수 - 먹이를 줄 시간에 feeder가 열려있지 않으면 알림을 보내고 아니면 아무 행동 하지 않는다.
```
 rule "timer start"

     time1 [ .~> ];
     true;
     start time1 at 0

end

rule "feeder close"

     feeder1.contact [ .~>closed ];
     time1 == 60 && feeder1 == closed;
     send ("feeder is closed"),
     stop time1

end
```

<h3>문제점</h3>
```
def feederEvents = feeder1.eventsBetween(midnight, now)
```
eventsBetween이 내장함수같고 따라서 자정과 현재 시간을 비교하는 로직을 가져오는 것에 어려움이 있다.

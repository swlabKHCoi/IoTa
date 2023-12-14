<h3>#기능</h3>
once-a-day.groovy 코드는사용자가 설정한 시간에 스위치를 자동으로 제어할 수 있게 해주는 기능이다.

<h3>#구현</h3>
def startTimerCallback() - 시작 시간과 타이머가 동일하면 switch on</br>
def stopTimerCallback() - 끝나는 시간과 타이머가 동일하면 switch off

```
rule "start timer"

	timer [ .~> ];
	true;
	start switch_timer at 0
    end

rule "switch on when start time"

    switches.switch [ .~> on ];
    switch_timer == startTime;
	switch := on
end

rule "switch off when stop time"

    switches.switch [ .~> off ];
    switch_timer == stopTime;
	switch := off
end
```

<h3>#문제점</h3>

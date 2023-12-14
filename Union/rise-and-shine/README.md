<h3>#기능</h3>
rise-and-shine.groovy 코드는 아침에 일어나면 일련의 동작을 수행하는 기능을 한다.

<h3>#구현</h3>
def initialize() 함수 - motion이 active가 되면 def modeActiveHandler(evt) 호출, 모드가 변경되면  motionActiveHandler(evt) 을 호출한다.</br>
def modeChangeHandler(evt) - 모드가 변경될 때 호출, 모드가 변경된 시간을 기록한다.
def motionActiveHandler(evt) - 조건이 맞으면 기능을 수행한다.

```
rule "start timer"

	motionSensors.motion [ .~>active ];
	start_time == null;
	start flowing_time at 0

end

rule "set timer"

	flowing_time [ .~> ];
	true;
	start_time = ??,
	end_time = ??

end

rule "increment the timer"

        flowing_time [ .~> ];
	flowing_time < end_time;
	tick flowing_time

    end

rule "start a morning routine"

    flowing_time [ .~> ];
	flowing_time >= start_time && flowing_time <= end_time && location.mode != newMode;
	send("Good morning! SmartThings changed the mode to '$newMode'"),
	switches.switch := on,
	stop flowing_time

end
```

<h3>#문제점</h3>
start_time, end_time의 초기값 설정 어려움</br>
location.mode 처리


# 기능
- 스위치를 켜면 지정한 시간(분) 후 자동으로 다시 끈다.

# 괜찮은지?
- timer switch_timer; 로 타이머 구현
- def turnOffSwitch() {
	    theSwitch.off()      => theSwitch.switch := off 로 구현, 함수 사용 x => 처음에 정의해야하는지?
    }


# 기능 구현 x
	runIn(delay, turnOffSwitch) 사용 x 
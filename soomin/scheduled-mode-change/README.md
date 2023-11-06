# 기능
- 하루의 특정 시간에 모드를 변경한다.

# 괜찮은지?
- sendNotificationToContacts,sendSms 대신 send 함수 사용 => phone, recipients 필요 없음

# 문제점
-     location.mode != newMode;                                  => 여기서 newMode가 location.mode에 있는 것 중에 하나라면 여기에 들어가야하는데, 
        .                                                            처음꺼랑 같지 않으면 아래 조건으로 들어가버림
        send ( "tried to change to undefined mode :" + newNode )   
    
        |                   
        send ( "change the mode to " + newMode )

# 기능 구현x

def installed() {
	initialize()
}

def updated() {
	unschedule()
	initialize()
}

def initialize() {
	schedule(time, changeMode)
}


-----------

private getLabel() {
	app.label ?: "SmartThings"
}

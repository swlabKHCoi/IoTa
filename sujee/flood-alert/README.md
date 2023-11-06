# 기능
- 1초 동안 waterSensor가 젖는 일이 일어난다면, 알람을 보낸다.

# 문제점
- timer의 선언을 통해서 해결 가능
- sendSms, sendPush, sendNotifiactionToContacts 등 다양한 send 함수에 대한 분화 없음
    - output sendSms : String 등으로 해결 가능할수도?

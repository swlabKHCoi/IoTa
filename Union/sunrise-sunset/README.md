해당 지역 일출, 일몰 시간을 기반으로 모드 변경 및 조명 제어를 한다.

- **`sunriseTimeHandler()`** 및 **`sunsetTimeHandler()`** 함수는 일출 및 일몰 시간 변화를 감지하여 처리한다.
- **`scheduleWithOffset()`** 함수는 설정된 시간에 따라 이벤트 핸들러를 스케줄링한다.
- **`sunriseHandler()`** 및 **`sunsetHandler()`** 함수는 일출 및 일몰 이벤트를 처리하고, 설정된 작업을 실행한다.

설정한 시간에 원하는 작업을 수행하고, 사용자에게 알림을 보낸다.

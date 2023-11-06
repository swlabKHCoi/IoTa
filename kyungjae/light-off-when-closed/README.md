<h3>#기능</h3>
light-off-when-closed.groovy 코드는 문 또는 창문과 연결된 개폐 센서가 닫힐 때 조명을 꺼주는 기능을 한다.

<h3>#구현</h3>
def contactClosedHandler(evt) 함수
```
contact1.contact [ .~>close ];
true;
switch1.switch := off
```

<h3>#문제점</h3>

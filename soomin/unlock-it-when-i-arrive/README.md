# 기능
- 특정위치에 도착하면 문을 연다.

# 괜찮은지?
- lock1.count{it.currentLock == "unlocked"} != lock1.size()    <- 이 부분을 단순히
  currentLock == "locked";                                     <- 이렇게 표현해도 괜찮은지

  //현재 lock이 열렸는지를 count를 세서 size랑 같지 않은지 보는게 다 열려있는지 않는 경우를 확인하려는 거라고 생각해서 저렇게 단순화 함
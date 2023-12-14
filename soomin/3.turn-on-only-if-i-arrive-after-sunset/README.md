#기능

- 해가 진 후에 도착한 경우에만 무엇인가를 켜고 떠날 때마다 꺼집니다

#문제점

- def sunTime = getSunriseAndSunset(); 해당 함수 없음

def presenceHandler(evt)
{
def now = new Date()
def sunTime = getSunriseAndSunset();

    log.debug "nowTime: $now"
    log.debug "riseTime: $sunTime.sunrise"
    log.debug "setTime: $sunTime.sunset"
    log.debug "presenceHandler $evt.name: $evt.value"

    def current = presence1.currentValue("presence")
    log.debug current
    def presenceValue = presence1.find{it.currentPresence == "present"}
    log.debug presenceValue
    if(presenceValue && (now > sunTime.sunset)) {
    	switch1.on()
    	log.debug "Welcome home at night!"
    }
    else if(presenceValue && (now < sunTime.sunset)) {
    	log.debug "Welcome home at daytime!"
    }
    else {
    	switch1.off()
    	log.debug "Everyone's away."
    }

}

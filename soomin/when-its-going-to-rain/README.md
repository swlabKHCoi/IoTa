# 기능
- 특정 시간에 입력한 우편번호 위치에 stromy가 있는지 확인하고 열려있는 장치들을 문자로 보내 알린다.

# 괜찮은지?
- sendNotificationToContacts,sendSms 대신 send 함수 사용 => phone, recipients 필요 없음
- def scheduleCheck() {
	def response = getWeatherFeature("forecast", zipcode)                                    
	if (isStormy(response)) {                                                                
		def open = sensors.findAll { it?.latestValue("contact") == 'open' }                  
		if (open) {                                                                          
            if (location.contactBookEnabled) {       => send("A storm is a coming and the following things are open:"+ open.join(', ')) 표현,,

                sendNotificationToContacts("A storm is a coming and the following things are open: ${open.join(', ')}", recipients)
            }                                                                                    
            else {
                sendSms(phone, "A storm is a coming and the following things are open: ${open.join(', ')}")
            }
		}
	}
}

# 기능구현 x

def scheduleCheck() {
	def response = getWeatherFeature("forecast", zipcode)                                    <- 이 부분
	if (isStormy(response)) {                                                                <-
		def open = sensors.findAll { it?.latestValue("contact") == 'open' }                  <-
		if (open) {                                                                          <-
            if (location.contactBookEnabled) {
                sendNotificationToContacts("A storm is a coming and the following things are open: ${open.join(', ')}", recipients)
            }                                                                                    
            else {
                sendSms(phone, "A storm is a coming and the following things are open: ${open.join(', ')}")
            }
		}
	}
}


----------------------------------------------------------------------------

private isStormy(json) {
	def STORMY = ['rain', 'snow', 'showers', 'sprinkles', 'precipitation']

	def forecast = json?.forecast?.txt_forecast?.forecastday?.first()
	if (forecast) {
		def text = forecast?.fcttext?.toLowerCase()
		if (text) {
			def result = false
			for (int i = 0; i < STORMY.size() && !result; i++) {
				result = text.contains(STORMY[i])
			}
			return result
		} else {
			return false
		}
	} else {
		log.warn "Did not get a forecast: $json"
		return false
	}
}
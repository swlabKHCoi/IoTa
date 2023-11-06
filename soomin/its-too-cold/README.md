# 기능
- 온도를 모니터링하고 설정값 아래로 떨어지면 문자를 받거나 히터를 켠다.

# 괜찮은지?
- send 함수 속 sendNotificationToContacts, sendSms를 구분 안하고 그냥 send로 통일 -> recipients, phone 필요 x

# 기능 구현 x
	def deltaMinutes = 10 // TODO: Ask for "retry interval" in prefs?
	def timeAgo = new Date(now() - (1000 * 60 * deltaMinutes).toLong())
	def recentEvents = temperatureSensor1.eventsSince(timeAgo)?.findAll { it.name == "temperature" }
	log.trace "Found ${recentEvents?.size() ?: 0} events in the last $deltaMinutes minutes"
	def alreadySentSms = recentEvents.count { it.doubleValue <= tooCold } > 1
    ------------------------------------------------------------------------------------------------------------

	private send(msg) {
    if (location.contactBookEnabled) {
        log.debug("sending notifications to: ${recipients?.size()}")
        sendNotificationToContacts(msg, recipients)
    }
    else {
        if (sendPushMessage != "No") { sendPushMessage가 no인지 구분 안하고 그냥 문자 보냄
            log.debug("sending push message")
            sendPush(msg)
        }

        if (phone1) {
            log.debug("sending text message")
            sendSms(phone1, msg)
        }
    }
	}

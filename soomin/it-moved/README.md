# 기능
- 움직임이 감지되면 텍스트를 보낸다.

# 괜찮은지?
- sendNotificationToContacts, sendSms 구분 안하고 send 함수로 통일 -> recipients 필요 x

# 기능 구현 x
	def deltaSeconds = 5
	def timeAgo = new Date(now() - (1000 * deltaSeconds))
	def recentEvents = accelerationSensor.eventsSince(timeAgo)
	log.trace "Found ${recentEvents?.size() ?: 0} events in the last $deltaSeconds seconds"
	def alreadySentSms = recentEvents.count { it.value && it.value == "active" } > 1

/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Flood Alert
 *
 *  Author: SmartThings
 */
definition(
    name: "Flood Alert!",
    namespace: "smartthings",
    author: "SmartThings",
    description: "Get a push notification or text message when water is detected where it doesn't belong.",
    category: "Safety & Security",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Meta/water_moisture.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Meta/water_moisture@2x.png"
)

preferences {
	// waterSensor not existing으로 처리됨
	section("When there's water detected...") {
		input "alarm", "capability.waterSensor", title: "Where?"
	}
	section("Send a notification to...") {	// 해당 형식 어떻게 Parsing 해야하는지 불분명
		input("recipients", "contact", title: "Recipients", description: "Send notifications to") {
			input "phone", "phone", title: "Phone number?", required: false
		}
	}
}

def installed() {
	subscribe(alarm, "water.wet", waterWetHandler)
}

def updated() {
	unsubscribe()
	subscribe(alarm, "water.wet", waterWetHandler)
}

def waterWetHandler(evt) {
	def deltaSeconds = 60

	// 60초마다 실행하는 것의 문제 (카네기 멜론 논문 참고)
	def timeAgo = new Date(now() - (1000 * deltaSeconds))	 // 1초동안 이벤트 탐지 불가, 결국 해당 시점에 젖어 있는지만 확인
	def recentEvents = alarm.eventsSince(timeAgo)
	log.debug "Found ${recentEvents?.size() ?: 0} events in the last $deltaSeconds seconds" // 60초마다 실행하는 것으로 이해

	def alreadySentSms = recentEvents.count { it.value && it.value == "wet" } > 1

	// alreadySentSms 구현 불가
	if (alreadySentSms) {
		log.debug "SMS already sent within the last $deltaSeconds seconds"
	} else {
		def msg = "${alarm.displayName} is wet!"
		log.debug "$alarm is wet, texting phone number"

		if (location.contactBookEnabled) {
			sendNotificationToContacts(msg, recipients)
		}
		else {
			sendPush(msg)
			if (phone) {
				sendSms(phone, msg)
			}
		}
	}
}

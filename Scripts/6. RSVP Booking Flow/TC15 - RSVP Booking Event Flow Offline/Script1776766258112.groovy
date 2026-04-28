import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Map testData = [
	'url'           : 'https://marq.iscriptsdemo.com/login',
	'email'         : "success.test@yopmail.com",
	'pass'          : "Test@123",
	'prompt'        : "Create a RSVP-Based Booking Test Event",
	'eventName'     : "RSVP-Based Event Test K Online",
	'startMY'       : "June 2026",
	'startDate'     : "3",
	'endMY'         : "June 2026",
	'endDate'       : "3",
	'startTime'     : [hour: '05', min: '30'],
	'endTime'       : [hour: '13', min: '15'],
	'location'      : "Casablanca",
	'platform'      : "YouTube",
	'streamUrl'     : "https://www.youtube.com/watch?v=Ct7He3j8Zlg",
	'session'       : [
		'title': 'RSVP Katalon Test Session',
		'desc' : 'This is a test session for an event created using Katalon',
		'speaker': 'Katalon',
		'link' : 'https://www.youtube.com/watch?v=Ct7He3j8Zlg'
	],
	'eventDesc'     : "RSVP-Based Online Booking Event Testing Using Katalon",
	
	'fbUrl'         : "https://www.facebook.com/SachinTendulkar/",
	'igUrl'         : "https://www.instagram.com/sachintendulkar/?hl=en",
]

WebUI.openBrowser(testData.url)
WebUI.maximizeWindow()

// 1. Login
WebUI.setText(findTestObject('Page_marQ - Event Management/Logout/input_Enter Your Email Address'), testData.email)
WebUI.setText(findTestObject('Page_marQ - Event Management/Logout/input_Enter Your Password'), testData.pass)
WebUI.click(findTestObject('Page_marQ - Event Management/Logout/input_logIn_loginbtn_LnnFD'))

// 2. AI Event Creation Flow
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Create Event'), 30)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Create Event'))
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/textarea_AI_eventPrompt'), testData.prompt)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Generate Setup'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup'), 30)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup_Draft'))

// 3. Event Category selection and Event Basics
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/button_EventCategory_rsvpEvent'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Save draft  Continue'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/input_Event Basics_eventName'), testData.eventName)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Event Basics_startup'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Event Basics_Next'))

// 4. Date and Location
WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventEndDate'))
CustomKeywords.'com.utils.CalendarHelper.selectDate'(testData.startMY, testData.startDate)

WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventStartDate'))
CustomKeywords.'com.utils.CalendarHelper.selectDate'(testData.endMY, testData.endDate)

// Times
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventStartTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : testData.startTime.hour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : testData.startTime.min]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventEndTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : testData.endTime.hour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : testData.endTime.min]))

// Physical Location
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/input_DateAndLocation_physicalVenue'), testData.location)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/input_DateAndLocation_physicalLocation'), testData.location)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Location Configuration/div_eventLocation_selectionAddress'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/button_DateLocation_Next'))

// 5. Media and Branding
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/input_mediaBranding_social-facebook'), testData.fbUrl, FailureHandling.OPTIONAL)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/input_mediaBranding_social-instagram'), testData.igUrl, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/button_mediaBranding_Next'))

// 6. Build your Schedule
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/button_BuildSchedule_addSession'), 10)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/button_BuildSchedule_addSession'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/input__BuildSchedule_location'), testData.location)

// Session Times
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/button_BuildSchedule_startTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : testData.startTime.hour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : testData.startTime.min]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/button_BuildSchedule_endTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : testData.endTime.hour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : testData.endTime.min]))

// Session Details
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/input_BuildSchedule_sessionTitle'), testData.session.title)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/input_BuildSchedule_sessionSpeaker'), testData.session.speaker)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/input_BuildSchedule_streamingLink'), testData.session.link)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/textarea_BuildSchedule_descriptionNotes'), testData.session.desc)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/RSVP Booking Flow/button_BuildSchedule_Next'))

// 7. Terms and Settings
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_policyDetails_AI suggest'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_tandC_AI suggest'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_Next'), 10)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_Next'))

// 8. Terms and Notes
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/button_tandn_Next'))

// 9. Additional Details
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/input_addDet_eventDesc'), testData.eventDesc)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/button_addDet_Next'))

// 10. Publish and Exit
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Preview and Publish/button_Publish'), 20)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Preview and Publish/button_Publish'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Dashboard/events_Logo'), 15)
WebUI.closeBrowser()

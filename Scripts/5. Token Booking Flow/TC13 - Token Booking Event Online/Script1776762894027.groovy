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
	'url'        : 'https://marq.iscriptsdemo.com/login',
	'email'      : "success.test@yopmail.com",
	'pass'       : "Test@123",
	'prompt'     : "Create a Token-Based Booking Test Event",
	'eventName'  : "Token-Based Online Event Test K",
	'tokens'     : '5',
	'minTokens'  : '2',
	'startMY'    : "June 2026",
	'startDay'   : "3",
	'endMY'      : "June 2026",
	'endDay'     : "7",
	'startHr'    : "05",
	'startMin'   : "30",
	'endHr'      : "13",
	'endMin'     : "15",
	'venue'      : 'Casablanca',
	'platform'   : 'YouTube',
	'streamUrl'  : 'https://www.youtube.com/watch?v=Ct7He3j8Zlg',
	'fbUrl'      : "https://www.facebook.com/SachinTendulkar/",
	'igUrl'       : "https://www.instagram.com/sachintendulkar/?hl=en",
	'description': "Token-Based Online Booking Event Testing Using Katalon",
]


WebUI.openBrowser(testData.url)
WebUI.maximizeWindow()

// --- Login Flow ---
WebUI.setText(findTestObject('Page_marQ - Event Management/Logout/input_Enter Your Email Address'), testData.email)
WebUI.setText(findTestObject('Page_marQ - Event Management/Logout/input_Enter Your Password'), testData.pass)
WebUI.click(findTestObject('Page_marQ - Event Management/Logout/input_logIn_loginbtn_LnnFD'))

// --- AI Event Generation ---
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Create Event'), 20)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Create Event'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/textarea_AI_eventPrompt'), testData.prompt)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Generate Setup'))

// Wait for AI to process
WebUI.waitForElementVisible(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup'), 30)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup_Draft'))

// --- Event Setup ---
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Token Booking Flow/button_EventCategory_tokenBasedEvent'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Save draft  Continue'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/input_Event Basics_eventName'), testData.eventName)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Token Booking Flow/input_EventBasics_tokenPurchaseAmount'), testData.tokens)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Token Booking Flow/input_EventBasics_minNumberofTokens'), testData.minTokens)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Event Basics_startup'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Event Basics_Next'))

// --- Date & Location (Using Custom Keyword) ---
WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventEndDate'))
CustomKeywords.'com.utils.CalendarHelper.selectDate'(testData.endMY, testData.endDay)

WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventStartDate'))
CustomKeywords.'com.utils.CalendarHelper.selectDate'(testData.startMY, testData.startDay)

// Times & Location
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventStartTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : testData.startHr]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : testData.startMin]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventEndTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : testData.endHr]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : testData.endMin]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_Online Event'))
WebUI.selectOptionByLabel(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_selectPlatform'), testData.platform, false)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/input_DateAndLocation_streamingUrl'), testData.streamUrl)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/button_DateLocation_Next'))

// --- Media and Branding ---
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/input_mediaBranding_social-facebook'), testData.fbUrl, FailureHandling.OPTIONAL)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/input_mediaBranding_social-instagram'), testData.igUrl, FailureHandling.OPTIONAL)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/button_mediaBranding_Next'))

// --- Vendors ---
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Token Booking Flow/button_Vendor_addVendor'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Token Booking Flow/button_Vendor_vendorSelect'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Token Booking Flow/button_Vendor_addToEvent'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_food_Next'))

// --- Terms and Settings ---
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_policyDetails_AI suggest'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_tandC_AI suggest'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_Next'))

// --- Terms and Notes ---
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/button_tandn_Next'))

// --- Additional Details ---
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/input_addDet_eventDesc'), testData.description)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/button_addDet_Next'))

// --- Publish ---
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Preview and Publish/button_Publish'), 15)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Preview and Publish/button_Publish'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Dashboard/events_Logo'), 15)
WebUI.closeBrowser()
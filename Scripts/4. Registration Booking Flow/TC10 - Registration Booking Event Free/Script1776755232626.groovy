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

String browserUrl = 'https://marq.iscriptsdemo.com/login'

String testEmail = "success.test@yopmail.com"
String testPassword = "Test@123"

String aiPrompt = "Create a Registration-Based Booking Test Event"
String testEventName = "Registration-Based Event Test K"

String eventStartMonthYear = "June 2026"
String eventStartDate = "3"

String eventEndMonthYear = "June 2026"
String eventEndDate = "7"

String eventStartHour = '05'
String eventStartMinute = '30'
String eventEndHour = '13'
String eventEndMinute = '15'

String totalFreeTickets = 50

String regStartDate = "30"
String regStartMonthYear = "May 2026"

String regEndDate = "2"
String regEndMonthYear = "June 2026"

String eventLocation = "Casablanca"

String emailLabel = 'Katalon Email Label'
String emailPlaceholder = 'Katalon Email Placeholder'

String raffleName = "Raffle Katalon"
String rafflePrice = 2
String raffleTotalTickets = 100
String raffleMaxPerUser = 5

String raffleDate = "9"
String raffleMonthYear = "June 2026"
String raffleHour = '05'
String raffleMinute = '30'

String testFacebook = "https://www.facebook.com/SachinTendulkar/"
String testInstagram = "https://www.instagram.com/sachintendulkar/?hl=en"

String foodItemName = "Katalon Food Item"
String foodItemDesc = "Katalon Food Item description"
String foodItemPrice = 5

String cancellationDate = '2'
String cancellationMonthYear = 'June 2026'

String eventDescription = "Registration-Based Booking Event Testing Using Katalon"

WebUI.openBrowser(browserUrl)
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Page_marQ - Event Management/Logout/input_Enter Your Email Address'), testEmail)
WebUI.setText(findTestObject('Page_marQ - Event Management/Logout/input_Enter Your Password'), testPassword)
WebUI.click(findTestObject('Page_marQ - Event Management/Logout/input_logIn_loginbtn_LnnFD'))

WebUI.waitForElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Create Event'), 30, FailureHandling.STOP_ON_FAILURE)

// 1. Click Create Event
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Create Event'))

// 2. Enter AI Prompt and click generate
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/textarea_AI_eventPrompt'), aiPrompt)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Generate Setup'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup'), 10)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/AI Event Flow/button_Continue to Event Setup_Draft'))

// 3. Select Event Category
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/button_EventCategory_registrationEvent'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Save draft  Continue'))

// 4. Event Basics
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/input_Event Basics_eventName'), testEventName)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Event Basics_startup'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Event Category and Basics/button_Event Basics_Next'))

// 5. Date and Location
// end_date
WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventEndDate'))

while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(eventEndMonthYear)) {
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
	WebUI.delay(1)
}


WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : eventEndDate]))

// start_date
WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventStartDate'))

while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(eventStartMonthYear)) {
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
	WebUI.delay(1)
}

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : eventStartDate]))

// Set the Start Time
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventStartTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : eventStartHour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : eventStartMinute]))

// Set the End Time
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/button_DateAndLocation_eventEndTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeHour', [('hourValue') : eventEndHour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/select_DateAndLocation_timeMinute', [('minuteValue') : eventEndMinute]))

// Set Physical Location
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/input_DateAndLocation_physicalVenue'), eventLocation)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Non-Seat Booking Flow/input_DateAndLocation_physicalLocation'), eventLocation)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Location Configuration/div_eventLocation_selectionAddress'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/button_DateLocation_Next'))


// 6. Ticketing
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/button_Free Event'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/input_Total Tickets Available'), totalFreeTickets)

// reg_end_date
WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/input_reg_end_month'))

while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(regEndMonthYear)) {
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
	WebUI.delay(1)
}

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : regEndDate]))

// reg_start_date
WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/input_reg_start_month'))

while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(regStartMonthYear)) {
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
	WebUI.delay(1)
}

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : regStartDate]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/button_Ticketing_Next'))


// 7. Registration Form
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/button_RegistrationForm_shortText'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/button_RegistrationForm_phoneNumber'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/button_RegistrationForm_email'))

// Email field
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/input_RegistrationForm_fieldLabel'), emailLabel)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/input_RegistrationForm_placeholderText'), emailPlaceholder)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/select_RegistrationForm_required'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration-Based Booking Flow/button_RegistrationForm_Next'))

// 8. Raffle Configuration
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/div_Raffle Configuration_toggle'), 30)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/div_Raffle Configuration_toggle'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input__raffleTicketName'), raffleName)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input__pricePerTicket'), rafflePrice)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input__totalTicketsAvailable'), raffleTotalTickets)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input_Maximum Tickets per User_maxTicketsPerUser'), raffleMaxPerUser)

WebUI.enhancedClick(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input_raffle_drawDate'))

while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(raffleMonthYear)) {
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
	WebUI.delay(1)
}

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : raffleDate]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/button_raffle_drawTime'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/raffle_timeHour', [('timeValue') : raffleHour]))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/raffle_timeMinute', [('timeValue') : raffleMinute]))


WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/button_raffleConfig_PrizeDesc_AI Assist'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/button_raffleConfig_RaffleRules_AI suggest'))

WebUI.scrollToElement(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input_raffleConfig_required'), 3)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/input_raffleConfig_required'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Raffle Config/button_raffleConfig_Next'))


// 9. Payment Methods
WebUI.waitForElementClickable(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/button_Cash_PaymentMethods_toggle'), 10)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/button_Cash_PaymentMethods_toggle'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/button_Zelle_PaymentMethods_toggle'))

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/input__zelleEmail'), testEmail)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Ticketing and Pricing/button_paymentMethod_Next'))

// 10. Media and Branding
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/input_mediaBranding_social-facebook'), testFacebook)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/input_mediaBranding_social-instagram'), testInstagram)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Media and Branding/button_mediaBranding_Next'))

// 11. Food and Beverage
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_Add Vendor'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_Add from Existing'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_Stallvendoryopmail.com'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_Add Item'))
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/input_Item name'), foodItemName)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/textarea_itemDescription'), foodItemDesc)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/input_new-item-price'), foodItemPrice)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_Add Item_modal'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_Buy Onsite_FoodAndBeverages_toggle'))
WebUI.delay(5)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Food and Beverage/button_food_Next'))

// 12. Attendee Register
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Attendee Registration/button_Attendee_Next'))

// 13. Terms and Settings
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_policyDetails_AI suggest'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_Cancellation'))
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/input_tands_cancellationDate'))

while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(cancellationMonthYear)) {
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
	WebUI.delay(1)
}

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : cancellationDate]))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_tandC_AI suggest'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Terms and Settings/button_tands_Next'))

// 14. Terms and Notes
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/button_tandn_Next'))

// 15. Additional Details
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/input_addDet_eventDesc'), eventDescription)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/TandN and Add Details/button_addDet_Next'))

// 16. Publish
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Preview and Publish/button_Publish'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Dashboard/events_Logo'), 10)
WebUI.closeBrowser()
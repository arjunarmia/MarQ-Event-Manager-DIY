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

String urlBrowser = "https://marq.iscriptsdemo.com/register"

String timestamp = String.valueOf(System.currentTimeMillis())

String randomUser = "Katalontester" + System.currentTimeMillis()
String testEmail = randomUser + "@mailinator.com"
String testName = "Katalon Test User"
String testNumber = "9" + timestamp.substring(timestamp.length() - 9)
String testPassword = "Test@123"
String businessAddress = "Testour"

WebUI.openBrowser(urlBrowser)
WebUI.maximizeWindow()

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Full Name_name'), testName)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Contact Number_phone-input'), testNumber)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Email Address_email'), testEmail)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Password_password'), testPassword)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Privacy Policy_register_loginbtn__-y0Yl'))


WebUI.executeJavaScript('window.open();', [])
WebUI.switchToWindowIndex(1)

String fullOtp = CustomKeywords.'com.otp.helper.MailinatorReader.getMailinatorOTP'(randomUser)

WebUI.closeWindowIndex(1)
WebUI.switchToWindowIndex(0)

if(fullOtp.length() == 4) {
	char[] digits = fullOtp.toCharArray();
	
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp1'), digits[0].toString())
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp2'), digits[1].toString())
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp3'), digits[2].toString())
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp4'), digits[3].toString())
	
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Resend Code_otpVerify_loginbtn__wOnJC'))
} else {
	KeywordUtil.markFailed("OTP not found or length is incorrect: " + fullOtp)
}

WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Onboarding/input__businessAddress'), businessAddress)
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Onboarding/Address_Testour'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Onboarding/button_Next'))

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Onboarding/button_Complete Setup'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Dashboard/dashboard_Logo'), 30)
WebUI.closeBrowser()

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

String urlBrowser = "https://marq.iscriptsdemo.com/login"

String user = "katalon.passwordtest"
String testEmail = user+"@mailinator.com"
String testNewPassword = "Test@1234"

WebUI.openBrowser(urlBrowser)
WebUI.maximizeWindow()

// 1. Click Forgot Password link
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/a_Forgot Password'))

// 2. Enter email
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/input_email'), testEmail)

// 3. Click Forgot Password button
WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/forgetPassword_button'))

// 4. Switch to Mailinator
WebUI.executeJavaScript('window.open();', [])
WebUI.switchToWindowIndex(1)

String fullOtp = CustomKeywords.'com.otp.helper.MailinatorReader.getMailinatorOTP'(user)

WebUI.closeWindowIndex(1)
WebUI.switchToWindowIndex(0)

if(fullOtp.length() == 4) {
	char[] digits = fullOtp.toCharArray();
	
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp1'), digits[0].toString())
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp2'), digits[1].toString())
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp3'), digits[2].toString())
	WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Registration/input_Verify your email_otp4'), digits[3].toString())
	
	WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/verifyOtp_button'))
} else {
	KeywordUtil.markFailed("OTP not found or length is incorrect: " + fullOtp)
}

// 5. Set New password and click Confirm Password
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/input_password'), testNewPassword)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/input_confirmPassword'), testNewPassword)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Forgot Password/confirmPassword_button'))

// 6. Login again
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Login/input_Enter Your Email Address'), testEmail)
WebUI.setText(findTestObject('Object Repository/Page_marQ - Event Management/Login/input_Enter Your Password'), testNewPassword)

WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Login/input_logIn_loginbtn_LnnFD'))

WebUI.verifyElementPresent(findTestObject('Object Repository/Page_marQ - Event Management/Dashboard/dashboard_Logo'), 30)
WebUI.closeBrowser()
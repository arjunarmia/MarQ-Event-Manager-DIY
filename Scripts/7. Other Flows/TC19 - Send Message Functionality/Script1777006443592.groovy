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

String userMail = 'success.test@yopmail.com'
String userPassword = 'Test@123'

String recipientMail = 'arjun.r@armiasystems.com'
String mailSubject = 'Katalon Testing for MarQ'

String formImagePath = "C:\\Users\\Arjun\\Downloads\\Images\\Test_Vendor_Logo.png"

WebUI.openBrowser('')

WebUI.navigateToUrl(browserUrl)

WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Email Address'), userMail)
WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Password'), userPassword)
WebUI.click(findTestObject('Page_marQ - Event Management/Login/input_logIn_loginbtn_LnnFD'))

WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/button_Events'))

WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/button_Events_Send Message'))

WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/radio_sendMessage_customGroup'))
WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/button_sendMessage_users'))
WebUI.setText(findTestObject('Page_marQ - Event Management/Send Message Functionality/button_sendMessage_search'), recipientMail)
WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/select_sendMessage_firstMail'))

WebUI.setText(findTestObject('Page_marQ - Event Management/Send Message Functionality/input_sendMessage_mailSubject'), mailSubject)
WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/button_sendMessage_AIAssist'))

WebUI.uploadFile(findTestObject('Page_marQ - Event Management/Send Message Functionality/input_sendMessage_fileInput'), formImagePath)
WebUI.delay(3)

WebUI.click(findTestObject('Page_marQ - Event Management/Send Message Functionality/button_sendMessage_Send message'))
WebUI.delay(3)

WebUI.closeBrowser()
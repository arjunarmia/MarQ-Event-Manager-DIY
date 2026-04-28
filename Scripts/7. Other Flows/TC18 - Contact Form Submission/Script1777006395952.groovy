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

String formFirstName = 'Katalon'
String formLastName = 'User'
String formCategory = 'other'
String formDescription = 'Hello, this is a test conducted using Katalon automation software'

String formImagePath = "C:\\Users\\Arjun\\Downloads\\Images\\Test_Vendor_Logo.png"

WebUI.openBrowser('')

WebUI.navigateToUrl(browserUrl)

WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Email Address'), userMail)
WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Password'), userPassword)
WebUI.click(findTestObject('Page_marQ - Event Management/Login/input_logIn_loginbtn_LnnFD'))

WebUI.click(findTestObject('Page_marQ - Event Management/Contact Form/button_Support'))
WebUI.click(findTestObject('Page_marQ - Event Management/Contact Form/button_Contact Support'))

WebUI.setText(findTestObject('Page_marQ - Event Management/Contact Form/input_firstName'), formFirstName)
WebUI.setText(findTestObject('Page_marQ - Event Management/Contact Form/input_lastName'), formLastName)
WebUI.selectOptionByValue(findTestObject('Page_marQ - Event Management/Contact Form/select_Category'), formCategory, false)
WebUI.setText(findTestObject('Page_marQ - Event Management/Contact Form/textarea_formDescription'), formDescription)

WebUI.uploadFile(findTestObject('Page_marQ - Event Management/Contact Form/input_File Attachment'), formImagePath)

WebUI.delay(5)
WebUI.click(findTestObject('Page_marQ - Event Management/Contact Form/button_Submit Support Ticket'))
WebUI.delay(5)

WebUI.closeBrowser()


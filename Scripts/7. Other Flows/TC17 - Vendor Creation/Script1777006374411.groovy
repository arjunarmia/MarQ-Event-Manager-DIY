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

String timestamp = String.valueOf(System.currentTimeMillis())

String browserUrl = 'https://marq.iscriptsdemo.com/login'

String userMail = 'success.test@yopmail.com'
String userPassword = 'Test@123'

String vendorName = 'Katalon Vendor' + System.currentTimeMillis()
String vendorMail = 'katalon.user' + System.currentTimeMillis() + '@yopmail.com'
String vendorNumber = "9" + timestamp.substring(timestamp.length() - 9)
String stallName = 'Katalon Stall' + System.currentTimeMillis()
String vendorImagePath = "C:\\Users\\Arjun\\Downloads\\Images\\Test_Vendor_Logo.png"

WebUI.openBrowser('')

WebUI.navigateToUrl(browserUrl)

WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Email Address'), userMail)

WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Password'), userPassword)

WebUI.click(findTestObject('Page_marQ - Event Management/Login/input_logIn_loginbtn_LnnFD'))

WebUI.click(findTestObject('Page_marQ - Event Management/Vendors/a_Vendors'))

WebUI.click(findTestObject('Page_marQ - Event Management/Vendors/button_Add vendor'))

WebUI.setText(findTestObject('Page_marQ - Event Management/Vendors/input_Enter Vendor Name'), vendorName)

WebUI.setText(findTestObject('Page_marQ - Event Management/Vendors/input_Enter Stall Name'), stallName)

WebUI.setText(findTestObject('Page_marQ - Event Management/Vendors/input_Enter Email Address'), vendorMail)

WebUI.setText(findTestObject('Page_marQ - Event Management/Vendors/input_Enter Contact Number'), vendorNumber)

WebUI.selectOptionByValue(findTestObject('Page_marQ - Event Management/Vendors/select_Vendor Category'), 
    'Entertainment & Activities', false)

//WebUI.click(findTestObject('Page_marQ - Event Management/Vendors/label_Upload Image'))

WebUI.setText(findTestObject('Page_marQ - Event Management/Vendors/input_Vendor Image'), vendorImagePath)
WebUI.uploadFile(findTestObject('Page_marQ - Event Management/Vendors/input_Vendor Image'), vendorImagePath)

WebUI.click(findTestObject('Page_marQ - Event Management/Vendors/button_Create vendor'))

WebUI.verifyElementVisible(findTestObject('Page_marQ - Event Management/Vendors/img_marQ'))

WebUI.closeBrowser()


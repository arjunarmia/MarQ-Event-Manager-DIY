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


String browserUrl = 'https://marq.iscriptsdemo.com/'

String testEmail = 'success.test@yopmail.com'
String testPassword = 'cvW8qx4B2o3F4VwP/kNsqA=='

WebUI.openBrowser('')

WebUI.navigateToUrl(browserUrl)

WebUI.click(findTestObject('Page_marQ - Event Management/Login/button_Continue to event setup'))

WebUI.click(findTestObject('Page_marQ - Event Management/Login/a_Sign In'))

WebUI.setText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Email Address'), testEmail)

WebUI.setEncryptedText(findTestObject('Page_marQ - Event Management/Login/input_Enter Your Password'), testPassword)

WebUI.click(findTestObject('Page_marQ - Event Management/Login/input_logIn_loginbtn_LnnFD'))

WebUI.closeBrowser()


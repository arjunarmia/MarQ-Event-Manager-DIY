package com.otp.helper

import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.util.KeywordUtil

class MailinatorReader {

    @Keyword
    def getMailinatorOTP(String inboxName) {
        WebUI.navigateToUrl("https://www.mailinator.com/v4/public/inboxes.jsp?to=" + inboxName)
        
        // 1. Wait for email and click
        WebUI.waitForElementPresent(findTestObject('Object Repository/Page_Mailinator/first_email_row'), 20)
        WebUI.click(findTestObject('Object Repository/Page_Mailinator/first_email_row'))
        
        // 2. EXTRA SAFETY: Wait for the JavaScript to actually create the iframe
        // We will wait up to 10 seconds for the 'html_msg_body' to exist in the DOM
        for (int i = 0; i < 10; i++) {
            boolean exists = WebUI.executeJavaScript("return document.getElementById('html_msg_body') != null", null)
            if (exists) break
            WebUI.delay(1)
        }

        TestObject iframeObj = findTestObject('Object Repository/Page_Mailinator/iframe_-- HTML EMAIL BODY --')

		WebUI.waitForElementPresent(iframeObj, 15)

		// This 'Force' switch uses the ID directly if the TestObject fails
		try {
    		WebUI.switchToFrame(iframeObj, 10)
		} catch (Exception e) {
    		// If the object fails, we try switching by the ID string directly
    		WebUI.executeJavaScript("const frame = document.getElementById('html_msg_body');", null)
    		WebUI.switchToFrame(iframeObj, 5)
		}

		// 4. Get the text
		String emailText = WebUI.getText(findTestObject('Object Repository/Page_Mailinator/email_body_text'))
        
		// 5. Regex for 4 digits
        def matcher = (emailText =~ /\d{4}/)
        String otp = matcher ? matcher[0] : ""

        WebUI.switchToDefaultContent()
        return otp
    }
}
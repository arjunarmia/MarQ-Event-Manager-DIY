package com.utils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

class CalendarHelper {
    @Keyword
    def selectDate(String targetMonthYear, String targetDay) {
        // Wait for the calendar to be visible before starting the loop
        WebUI.waitForElementVisible(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header'), 10)
        
        // Loop until the month/year matches
        while (!WebUI.getText(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calender_header')).equals(targetMonthYear)) {
            WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/btn_next_month'))
            WebUI.delay(1) // Necessary for the UI animation to complete
        }
        
        // Click the specific day using parameterization
        WebUI.click(findTestObject('Object Repository/Page_marQ - Event Management/Seat Booking Flow/Date and Location/calendar_day', [('day') : targetDay]))
    }
}
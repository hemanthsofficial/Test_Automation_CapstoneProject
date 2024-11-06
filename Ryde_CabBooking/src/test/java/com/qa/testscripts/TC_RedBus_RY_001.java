package com.qa.testscripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_RedBus_RY_001 extends TestBase{
	SoftAssert sAssert = new SoftAssert();
	@Test
	public void main1() throws IOException {
		//check if user landed on redbus page
		Boolean verifyhome = driver.getCurrentUrl().contains("https://www.redbus.in/");
		if(verifyhome) {
			Reporter.log("Landed on Redbus page",true);
			sAssert.assertTrue(verifyhome);
		}
		else {
			captureScreenshot(driver, "main1");
			Reporter.log("Not landed on Redbus page",true);
			sAssert.assertTrue(verifyhome);
		}
		
		//check if user navigated to ryde homepage
		ryde.getpagenav().click();
		Boolean verifypagenav = driver.getCurrentUrl().contains("https://www.redbus.in/ryde/");
		if(verifypagenav) {
			Reporter.log("\nNavigated to ryde homepage",true);
			sAssert.assertTrue(verifypagenav);
		}
		else {
			captureScreenshot(driver, "main1");
			Reporter.log("\nNot navigated to ryde homepage",true);
			sAssert.assertTrue(verifypagenav);
		}		
	}

}
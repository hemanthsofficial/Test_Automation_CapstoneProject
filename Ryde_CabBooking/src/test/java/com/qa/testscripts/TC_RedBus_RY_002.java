package com.qa.testscripts;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RedBus_RY_002 extends TC_RedBus_RY_001 {
	@Test(dependsOnMethods = "main1")
	public void main2() throws InterruptedException, IOException {
		// click on outstation tile
		ryde.getoutstationtile().click();
		Thread.sleep(5000);

		// change focus to frame
		driver.switchTo().frame(ryde.getframenav());

		// check if one-way trip radio button is selected as default
		ryde.getonewaytriprbtn().click();
		boolean verifyoutbtn = ryde.getonewaytriprbtn().isEnabled();
		if (verifyoutbtn) {
			Reporter.log("\nOne-way trip radio button is selected by default", true);
			sAssert.assertTrue(verifyoutbtn);
		} else {
			captureScreenshot(driver, "main2");
			Reporter.log("\nOne-way trip radio button is not selected by default", true);
			sAssert.assertTrue(verifyoutbtn);
		}

	}

}
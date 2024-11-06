package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RedBus_RY_010 extends TC_RedBus_RY_002 {
	@Test(dependsOnMethods = "main2")
	public void main10() throws InterruptedException {
		// check cab booking window is open
		ryde.getcabtype().click();
		Thread.sleep(3000);

		Boolean verifycabwin = ryde.getpickupbox().isDisplayed();
		if (verifycabwin) {
			Reporter.log("\nCab booking window is opened", true);
			sAssert.assertTrue(verifycabwin);
		} else {
			Reporter.log("\nCab booking window is not opened", true);
			sAssert.assertTrue(verifycabwin);
		}

		// Enter date
		ryde.getdandtbox().click();
		Thread.sleep(1000);
		ryde.gethourbox().click();
		// Enter time
		Thread.sleep(1000);
		List<WebElement> select = ryde.gethourinput();
		int len = 0;
		len = select.size();
		if (len != 0) {
			for (int k = 0; k < len; k++) {
				if (select.get(k).getText().equals("08")) {
					select.get(k).click();
					Thread.sleep(3000);
					Reporter.log("\nHour value is selected", true);
					sAssert.assertTrue(true);
					break;
				}
			}
		} else {
			Reporter.log("\nInvalid hour value!", true);
			sAssert.assertTrue(false);
		}
		Thread.sleep(4000);
	}

}
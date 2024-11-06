package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_RedBus_RY_009 extends TC_RedBus_RY_002 {
	@Test(dependsOnMethods = "main2")
	public void main9() throws InterruptedException, IOException {
		// check cab booking window is open
		ryde.getcabtype().click();
		Thread.sleep(3000);

		Boolean verifycabwin = ryde.getpickupbox().isDisplayed();
		if (verifycabwin) {
			Reporter.log("\nCab booking window is opened", true);
			sAssert.assertTrue(verifycabwin);
		} else {
			captureScreenshot(driver, "main9");
			Reporter.log("\nCab booking window is not opened", true);
			sAssert.assertTrue(verifycabwin);
		}

		// Enter date
		ryde.getdandtbox().click();
		Thread.sleep(1000);
		List<WebElement> select1 = ryde.getpresnremdate();
		List<WebElement> select2 = ryde.getpasnfmdate();
		int len1, len2, i, j;
		len1 = select1.size();
		len2 = select2.size();
		WebElement select3 = ryde.getmonth();

		for (int x = 0; x < 8; x++) {
			if (select3.getText().equals("January 2023")) {
				break;
			} else {
				ryde.getrightarrow().click();
				Thread.sleep(1000);
			}
		}

		Thread.sleep(2000);
		if (len1 != 0 && len2 != 0) {
			for (i = 0; i < len2 - 1; i++) {
				for (j = 0; j < len1 - 1; j++) {
					if (select1.get(j).getText().equals("28")) {
						select1.get(j).click();
						Thread.sleep(2000);
						Reporter.log("\nDate is selected", true);
						sAssert.assertTrue(true);
						break;
					}
				}
				if (select2.get(i).getText().equals("28")) {
					Boolean x = select2.get(i).isEnabled();
					if (x) {
						Thread.sleep(2000);
						captureScreenshot(driver, "main9");
						Reporter.log("\nInvalid date!", true);
						sAssert.assertFalse(false);
						break;
					}
				}
			}
		} else {
			captureScreenshot(driver, "main9");
			sAssert.assertTrue(false);
		}

		// Enter time
		List<WebElement> select = ryde.gethourinput();
		int len = 0;
		len = select.size();
		if (len != 0) {
			for (int k = 0; k < len; k++) {
				if (select.get(k).getText().contains("2")) {
					select.get(k).click();
					Thread.sleep(1000);
					Reporter.log("\nHour value is selected", true);
					sAssert.assertTrue(len != 0);
					break;
				}
			}
		} else {
			captureScreenshot(driver, "main9");
			Reporter.log("\nInvalid hour value!", true);
			sAssert.assertTrue(len != 0);
		}
	}

}
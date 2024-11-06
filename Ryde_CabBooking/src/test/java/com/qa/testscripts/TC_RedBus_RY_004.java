package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.utility.ExcelUtility;

public class TC_RedBus_RY_004 extends TC_RedBus_RY_002 {
	@Test(dependsOnMethods = "main2",dataProvider="getData")
	public void main4(String pickup) throws InterruptedException, IOException {
		// check the cab booking window is open
		ryde.getcabtype().click();
		Thread.sleep(3000);

		Boolean verifycabwin = ryde.getpickupbox().isDisplayed();
		if (verifycabwin) {
			Reporter.log("\nCab booking window is opened", true);
			sAssert.assertTrue(verifycabwin);
		} else {
			captureScreenshot(driver, "main4");
			Reporter.log("\nCab booking window is not opened", true);
			sAssert.assertTrue(verifycabwin);
		}

		// Type input data on pickup box
		ryde.getpickupbox().click();
		ryde.getpickupinput().sendKeys(pickup);
		Thread.sleep(3000);

		// Click on the expected result
		List<WebElement> select = ryde.getpickupselect();
		int len = 0;
		len = select.size();
		if (len != 0) {
			for (int i = 0; i < len; i++) {
				if (select.get(i).getText().contains(pickup)) {
					select.get(i).click();
					Thread.sleep(2000);
					Boolean verifychangelocalert = ryde.getchangelocalert().isDisplayed();
					if (verifychangelocalert) {
						Reporter.log("\n'Please enter a nearby landmark' alert is popped", true);
						sAssert.assertTrue(verifychangelocalert);
						break;
					}
					ryde.getproceedbtn().click();
					Reporter.log("\nUser input for pickup location is accepted", true);
					break;
				}
			}
		} else {
			ryde.getproceedbtn().click();
			Thread.sleep(2000);
			if (ryde.getwrong().isDisplayed()) {
				captureScreenshot(driver, "main4");
				Reporter.log("\nInvalid pickup location entered, user input not accepted", true);
				sAssert.assertTrue(len != 0);
			}
		}
	}
	@DataProvider
	public String[][] getData() throws IOException {
		String xFile = "C:\\Users\\HEMANTHS\\OneDrive - Virtusa\\Hemanth S-Selenium\\HemanthS_Batch24_Team8_Redbus\\src\\test\\java\\com\\qa\\testdata\\validation.xlsx";
		String xSheetName = "Sheet2";

		int rowCount = ExcelUtility.getRowCount(xFile, xSheetName);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);
			}
		}
		return data;

	}

}
package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.Redbus_ryde_pages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	WebDriver driver;
	Redbus_ryde_pages ryde;
	FileInputStream fileLoc;
	Properties prop;

	@Parameters({ "Browser", "Url" })

	@BeforeClass
	public void setup(String Browser, String Url) throws IOException {
		if (Browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\\\Users\\\\HEMANTHS\\\\OneDrive - Virtusa\\\\Hemanth S-Selenium\\\\DriverBinaries\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\\\Users\\\\HEMANTHS\\\\OneDrive - Virtusa\\\\Hemanth S-Selenium\\\\DriverBinaries\\\\edgedriver_win32\\\\msedgedriver.exe");
			driver = new EdgeDriver();
		} else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		ryde = new Redbus_ryde_pages(driver);
		driver.manage().window().maximize();
		driver.get(Url);
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tName + ".png");
		FileUtils.copyFile(src, target);
	}
}
package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Redbus_ryde_pages {
	WebDriver driver;

	@FindBy(id = "rYde")
	WebElement pagenav;

	public WebElement getpagenav() {
		return pagenav;
	}

	@FindBy(xpath = "//*[@id=\"reactContentMount\"]/div/div[5]/div/div/div[3]/div[1]/div/div/div[1]")
	WebElement outstationtile;

	public WebElement getoutstationtile() {
		return outstationtile;
	}

	@FindBy(xpath = "//*[@id=\"modal\"]/div[2]/object")
	WebElement framenav;

	public WebElement getframenav() {
		return framenav;
	}

	@FindBy(css = "div:nth-child(2) div.e1_sNvUhT5bx5qPLYquK div.JRstiQLaYjCjhx9msPLT:nth-child(1) div.ZQaRxX7Xrs9EtgkfLDvw > div.ujQNpXeTAt4RRMVVrlO5:nth-child(1)")
	WebElement onewaytriprbtn;

	public WebElement getonewaytriprbtn() {
		return onewaytriprbtn;
	}
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]")
	WebElement cabtype;

	public WebElement getcabtype() {
		return cabtype;
	}

	@FindBy(xpath = "//body/div[@id='OutstationMount']/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/input[1]")
	WebElement pickupbox;

	public WebElement getpickupbox() {
		return pickupbox;
	}

	@FindBy(xpath = "//*[@id=\"OutstationMount\"]/div[2]/div[4]/div[1]/div[1]/div[4]/div[2]/div[1]/div/input")
	WebElement pickupinput;

	public WebElement getpickupinput() {
		return pickupinput;
	}

	@FindAll(@FindBy(xpath = "//*[@id=\"OutstationMount\"]/div[2]/div[4]/div[1]/div[1]/div[4]/div[3]/div/div/div[1]"))
	List<WebElement> pickupselect;

	public List<WebElement> getpickupselect() {
		return pickupselect;
	}

	@FindBy(className = "GcUqQv3IGivQMJNPkUR4")
	WebElement changelocalert;

	public WebElement getchangelocalert() {
		return changelocalert;
	}

	@FindBy(xpath = "//*[@id=\"OutstationMount\"]/div[2]/div[4]/div[1]/div[1]/div[4]/div[2]/div[1]")
	WebElement wrong;

	public WebElement getwrong() {
		return wrong;
	}

	@FindBy(xpath = "//body/div[@id='OutstationMount']/div[2]/div[4]/div[1]/div[1]/div[3]/div[1]/input[1]")
	WebElement destinationbox;

	public WebElement getdestinationbox() {
		return destinationbox;
	}

	@FindBy(xpath = "//*[@id=\"OutstationMount\"]/div[2]/div[4]/div[1]/div[1]/div[4]/div[2]/div[2]/div/input")
	WebElement destinationinput;

	public WebElement getdestinationinput() {
		return destinationinput;
	}

	@FindAll(@FindBy(xpath = "//*[@id=\"OutstationMount\"]/div[2]/div[4]/div[1]/div[1]/div[4]/div[3]/div/div/div[1]"))
	List<WebElement> destinationselect;

	public List<WebElement> getdestinationselect() {
		return destinationselect;
	}

	@FindBy(className = "u_Cx1owFaSkV8ahXESNx")
	WebElement proceedbtn;

	public WebElement getproceedbtn() {
		return proceedbtn;
	}

	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input']")
	WebElement dandtbox;

	public WebElement getdandtbox() {
		return dandtbox;
	}
	
	@FindBy(xpath = "/html/body/div[9]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/button[2]")
	WebElement rightarrow;

	public WebElement getrightarrow() {
		return rightarrow;
	}
	
	@FindBy(xpath = "/html/body/div[9]/div[3]/div/div[1]/div/div[3]/div[1]/div[1]/div")
	WebElement month;

	public WebElement getmonth() {
		return month;
	}

	@FindAll(@FindBy(xpath = "/html/body/div[9]/div[3]/div/div[1]/div/div[3]/div[2]/div/div/div/button[@tabindex='0']/span[1]/p"))
	List<WebElement> presnremdate;

	public List<WebElement> getpresnremdate() {
		return presnremdate;
	}

	@FindAll(@FindBy(xpath = "/html/body/div[9]/div[3]/div/div[1]/div/div[3]/div[2]/div/div/div/button[@tabindex='-1']/span[1]/p"))
	List<WebElement> pasnfmdate;

	public List<WebElement> getpasnfmdate() {
		return pasnfmdate;
	}

	@FindBy(xpath = "/html[1]/body[1]/div[9]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]/h3[1]")
	WebElement hourbox;

	public WebElement gethourbox() {
		return hourbox;
	}
	/*@FindBy(xpath = "/html/body/div[9]/div[3]/div/div[1]/div/div[3]/div/div/span[8]")
	WebElement hourinput;

	public WebElement gethourinput() {
		return hourinput;
	}*/

	@FindAll(@FindBy(xpath = "/html/body/div[9]/div[3]/div/div[1]/div/div[3]/div/div/span"))
	List<WebElement> hourinput;

	public List<WebElement> gethourinput() {
		return hourinput;
	}

	// constructors:
	public Redbus_ryde_pages(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
}
package com.rsystems.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class StoreFilterLayer extends TestInitization {

	WebDriver driver;

	public StoreFilterLayer(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void actionItemValidation() throws InterruptedException {

		driver.switchTo().frame(getCurrentFrameIndex());
		List<WebElement> actionMenuItem = driver.findElements(By.xpath("//div[@id='containerDiv']/div"));
		if (actionMenuItem.size() > 0) {

			reports.log(LogStatus.PASS, "Action item of filter layer is displayed.");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Action item of filter layer is not visible");
		}
	}
}

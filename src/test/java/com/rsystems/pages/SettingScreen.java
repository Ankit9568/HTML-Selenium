package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class SettingScreen extends TestInitization {

	WebDriver driver;

	public SettingScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.SettingScreen.activeOption)
	public WebElement activeOption;

	public void validateSettingOption() throws InterruptedException {

		driver.switchTo().frame(getCurrentFrameIndex());
		reports.log(LogStatus.PASS,"Validation of setting option");
		reports.attachScreenshot(captureCurrentScreenshot());
		if (activeOption.getText()
				.contentEquals(TestInitization.getExcelKeyValue("SettingScreen", "Option1", "Value"))) {
			reports.log(LogStatus.PASS, "Option Found " + activeOption.getText());
		} else {
			FailTestCase(activeOption.getText() + " Option is not Found ");
		}

		sendKeyMultipleTimes("DOWN", 1, 1000);
		if (activeOption.getText()
				.contentEquals(TestInitization.getExcelKeyValue("SettingScreen", "Option2", "Value"))) {
			reports.log(LogStatus.PASS, "Option Found " + activeOption.getText());
		} else {
			FailTestCase(activeOption.getText() + " Option is not Found ");
		}

		sendKeyMultipleTimes("DOWN", 1, 1000);
		if (activeOption.getText()
				.contentEquals(TestInitization.getExcelKeyValue("SettingScreen", "Option3", "Value"))) {
			reports.log(LogStatus.PASS, "Option Found " + activeOption.getText());
		} else {
			FailTestCase(activeOption.getText() + " Option is not Found ");
		}
		sendKeyMultipleTimes("DOWN", 1, 1000);
		if (activeOption.getText()
				.contentEquals(TestInitization.getExcelKeyValue("SettingScreen", "Option4", "Value"))) {
			reports.log(LogStatus.PASS, "Option Found " + activeOption.getText());
		} else {
			FailTestCase(activeOption.getText() + " Option is not Found ");
		}
		sendKeyMultipleTimes("DOWN", 1, 1000);
		if (activeOption.getText()
				.contentEquals(TestInitization.getExcelKeyValue("SettingScreen", "Option5", "Value"))) {
			reports.log(LogStatus.PASS, "Option Found " + activeOption.getText());
		} else {
			FailTestCase(activeOption.getText() + " Option is not Found ");
		}

		reports.log(LogStatus.PASS, "Navigate to Hub page.");
		setApplicationHubPage(2);
	}

}

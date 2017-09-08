package com.rsystems.pages;

import org.openqa.selenium.By;
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

	public void verifyLinesInSettingScreen() throws InterruptedException
	{
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to the Settings Screen");
		TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000, TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
		libraryScreen.verifyTwoLinesInLibraryScreen("Level3");
		reports.log(LogStatus.PASS, "Verify Opacity of Two Lines getting displayed on Settings Screen");
		libraryScreen.verifyOpactiyOfLines();
		reports.log(LogStatus.PASS, "Navigate into Settings Screen");
		verifyMovementsInUpAndDownLine();
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		new SystemInfoScreen(driver).navigateToSytemScreen();
		libraryScreen.verifyTwoLinesInLibraryScreen("Level3");
		reports.log(LogStatus.PASS, "Verify Opacity of Two Lines getting displayed on System Page");
		libraryScreen.verifyOpactiyOfLines();
		reports.log(LogStatus.PASS, "Navigate into Settings Screen");
		verifyMovementsInUpAndDownLine();
	}

	public void verifyMovementsInUpAndDownLine() throws InterruptedException
	{
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		boolean checkMovement = false;
		String initialUpLine = libraryScreen.upCanvasLine.getAttribute("style");
		String initialDownLine = libraryScreen.downCanvasLine.getAttribute("style");
		for (int i = 0; i<= driver.findElements(By.className("cItem")).size()-1;i++)
		{
			sendKeyMultipleTimes("DOWN", 1, 1000);
			if(!(libraryScreen.upCanvasLine.getAttribute("style").equalsIgnoreCase(initialUpLine) && libraryScreen.upCanvasLine.getAttribute("style").equalsIgnoreCase(initialDownLine))){
				checkMovement = true;
				break;
			}

		}
		if(checkMovement)
		{
			FailTestCase("No movement in Line should happen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.PASS, "No movements in line");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}
}

package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class RcArrowKeys extends TestInitization {
	WebDriver driver;

	public RcArrowKeys(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RcArrowKey.heading)
	public WebElement heading;
	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RcArrowKey.type)
	public WebElement type;
	@FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.epgInfo)
	public WebElement epgInfo;
	@FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.background)
	public WebElement background;
	@FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.Id)
	public WebElement Id;
	@FindBy(how = How.ID, using = ObjectRepository.StoreFilterLayer.screenID)
	public WebElement screenID;

	public boolean verifyNavigationToEpgScreen() throws InterruptedException {

		EpgScreen epg = new EpgScreen(driver);

		reports.log(LogStatus.PASS, "Navigation to Epg Screen");
		epg.goToEpgSettingScreen();
		String screenTitle = heading.getText();
		System.out.println("Title is :" + screenTitle);
		String Type = type.getText();
		System.out.println("Type is :" + Type);

		// Navigating to various epg layers
		reports.log(LogStatus.PASS, "Navigation to the Epg type");
		String egyTypeStandard = epgInfo.getText();
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		System.out.println("Epg Type " + egyTypeStandard);

		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String egyTypeSenior = epgInfo.getText();

		System.out.println("Epg Type " + egyTypeSenior);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		String egyTypeStark = epgInfo.getText();
		System.out.println("Epg Type " + egyTypeStark);

		// Forward Navigation in the Epg screen
		reports.log(LogStatus.PASS, "Downward navigation in the Epg screen for 4 times");
		reports.attachScreenshot(captureCurrentScreenshot());
		for (int i = 0; i < 4; i++) {
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		// Backward Navigation in the Epg screen
		reports.log(LogStatus.PASS, "Upward navigation in the Epg screen for 4 times");
		reports.attachScreenshot(captureCurrentScreenshot());
		for (int i = 0; i < 4; i++) {
			TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		}

		String expectedTitle = TestInitization.getExcelKeyValue("EpgScreen", "Heading", "name_nl");
		if (screenTitle.equalsIgnoreCase(expectedTitle)) {
			reports.log(LogStatus.PASS, "HeadingName : " + screenTitle + " and Expected Title : " + expectedTitle
					+ " Test case successfully Passed");
		} else {
			FailTestCase(
					"Actual Title : " + screenTitle + " and Expected Title : " + expectedTitle + " Test case Failed");
		}
		return true;
	}

	public void verifyNavigationToVODScreen() throws InterruptedException {

		VodFeatures vodFeatures = new VodFeatures(driver);

		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS, "Navigate to the VOD Screen");
		
		TestInitization.sendKeySequence("RIGHT,ENTER", 1000, "shop");
		reports.attachScreenshot(captureCurrentScreenshot());

				// Forward Navigation in the VOD screen
		reports.log(LogStatus.PASS, "Press right key");
		
		driver.switchTo().frame(getCurrentFrameIndex());

		for (int iterator = 0; iterator < 2; iterator++) {
			String OldfilmName = vodFeatures.highlightFilm.getText();
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (OldfilmName.contentEquals(vodFeatures.highlightFilm.getText())) {
				FailTestCase("Unable to navigate right");
			}

		}

		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Press LEFT key");
		for (int iterator = 0; iterator < 2; iterator++) {
			String OldfilmName = vodFeatures.highlightFilm.getText();
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			if (OldfilmName.contentEquals(vodFeatures.highlightFilm.getText())) {
				FailTestCase("Unable to navigate left");
			}

		}

	}
}

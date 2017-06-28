package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class DTVChannelScreen extends TestInitization {

	WebDriver driver;

	public DTVChannelScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.chnlNoIn_Infobar)
	public WebElement chnlNoIn_Infobar;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programDurationIn_Infobar)
	public WebElement programDurationIn_Infobar;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programTitle)
	public WebElement programTitle;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.hdIcon)
	public WebElement hdIcon;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.channelLogo)
	public WebElement channelLogo;

	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.pauseAndPlayImg)
	public WebElement pauseAndPlayImg;

	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.backToLive)
	public WebElement backToLive;

	public void chnlChangeAndValidation(Unicode unicode, String expectedUpChannelNumber, String passmsg)
			throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		int expectedUpChannelNumberToInt = Integer.parseInt(expectedUpChannelNumber);

		TestInitization.sendUnicodeMultipleTimes(unicode.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		int acualChannelNumber = Integer.parseInt(dtvChannelScreen.chnlNoIn_Infobar.getText());

		if (acualChannelNumber == expectedUpChannelNumberToInt) {
			reports.log(LogStatus.PASS, passmsg);
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Unable to move screen on desired location ExpectedChannelNo: " + expectedUpChannelNumberToInt
					+ " Actual Channel Number : " + acualChannelNumber);
		}
	}

	public void changeChnlAndInfoBannerValidation(Unicode unicode) throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		
		reports.log(LogStatus.PASS, "Channel Change and validation");
		TestInitization.sendUnicodeMultipleTimes(unicode.toString(), 1, 1000);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		// Validation channel info
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.channelLogo, "Channel logo");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.programTitle, "Program Title");
	}

	public void openLiveTV() throws InterruptedException{
		
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 0);
		// Get the current TV Channel number
		reports.log(LogStatus.PASS, "Navigate Live TV");
		// Open info banner for screenshot
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
	}
	
}

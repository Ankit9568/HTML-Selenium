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
	@FindBy(how = How.XPATH, using = ObjectRepository.HubScreen.headerElement)
	public WebElement headerText;
	@FindBy(how = How.XPATH, using = ObjectRepository.RcArrowKey.firstChannelNumberInEPG)
	public WebElement firstChannelNumberInEPG;
	@FindBy(how = How.CLASS_NAME, using = "dayHeading")
	public WebElement dayHeading;
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


	public void verifyDTVHotKey() throws InterruptedException {
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 2000);
		Thread.sleep(1000);
		new DTVChannelScreen(driver).pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
	}
	public void verifyNumericKeys() throws InterruptedException {
		verifyRCNumericKeyOnEPG();
		verifyRCNumericKeyOnDTV();
		verifyRCNumericKeyOnLibrary();
		verifyRCNumericKeyOnShop();
		
	}

	private void verifyRCNumericKeyOnShop() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to Shop Screen");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 2000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl"))){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Send Numeric Key");
		sendNumaricKeys(5);
		Thread.sleep(2000);
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl"))){
			reports.log(LogStatus.PASS, "Nothing happens. User is on Shop Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Used tuned from Shop Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
	}

	private void verifyRCNumericKeyOnLibrary() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to Library Screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 2000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl"))){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Send Numeric Key");
		sendNumaricKeys(5);
		Thread.sleep(2000);
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl"))){
			reports.log(LogStatus.PASS, "Nothing happens. User is on Library Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Used tuned from Library Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	private void verifyRCNumericKeyOnDTV() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		dtvChannelScreen.tuneToChannel(8);
	}

	private void verifyRCNumericKeyOnEPG() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to EPG Screen");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		sendNumaricKeys(3);
		Thread.sleep(2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(firstChannelNumberInEPG.getAttribute("innerText").trim().equalsIgnoreCase("3")){
			reports.log(LogStatus.PASS, "user moved to channel no "+firstChannelNumberInEPG.getAttribute("innerText").trim());
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("User should be moved to Channel 3");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
	}
	
	public void verifyRCUEPGNavigation() throws InterruptedException {
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Navigate to TV Guide");
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String dateOnEPG = dayHeading.getText();
		reports.log(LogStatus.PASS, "Press Forward Key");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		if(!dayHeading.getText().equalsIgnoreCase(dateOnEPG))
		{
			reports.log(LogStatus.PASS, "User moved horizontally from one day to another");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Press Forward Key - Used not moved horizontally from one day to another");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
		String focusElement = new EpgScreen(driver).focusElemntInEpg.getText();
		reports.log(LogStatus.PASS, "Press Ch- key");
		sendUnicodeMultipleTimes(Unicode.VK_CHANNEL_MINUS.toString(), 1, 1000);
		if(new EpgScreen(driver).focusElemntInEpg.getText().equalsIgnoreCase(focusElement)){
			reports.log(LogStatus.PASS, "Nothing happens. Focus is on current episode");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Press CH- Key : Focus changed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}
	public void verifyRCArrowKeysOnDTV() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		reports.log(LogStatus.PASS, "Press UP Arrow Key");
		sendKeyMultipleTimes("UP", 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Zaplist", "name_nl"))){
			reports.log(LogStatus.PASS, "ZapList getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Zaplist should getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Press DOWN Arrow Key");
		sendKeyMultipleTimes("DOWN", 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Zaplist", "name_nl"))){
			reports.log(LogStatus.PASS, "ZapList getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Zaplist should getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Press RIGHT Arrow Key");
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))){
			reports.log(LogStatus.PASS, "Mini EPG Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Mini EPG Screen  should getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Press LEFT Arrow Key");
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))){
			reports.log(LogStatus.PASS, "Mini EPG Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Mini EPG Screen should getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
	}
}

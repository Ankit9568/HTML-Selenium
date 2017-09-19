package com.rsystems.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	
	@FindBy(how = How.ID, using = ObjectRepository.StoreFilterLayer.screenID)
	public WebElement screenID;
	@FindBy(how = How.XPATH, using = ObjectRepository.HubScreen.headerElement)
	public WebElement headerText;
	@FindBy(how = How.XPATH, using = ObjectRepository.RcArrowKey.firstChannelNumberInEPG)
	public WebElement firstChannelNumberInEPG;
	@FindBy(how = How.CLASS_NAME, using = "dayHeading")
	public WebElement dayHeading;
	
	@FindBy(how = How.ID,using = ObjectRepository.RcArrowKey.notificationMsg)
	public WebElement notificationMsg;
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
	public void verifyBackKey() throws InterruptedException {
		reports.log(LogStatus.PASS, "Go to Hub Screen By pressing Menu Key");
		new Hub(driver).launchAndVerifyMenuScreen();
		reports.log(LogStatus.PASS, "Go to Shop Screen");
		sendKeySequence("DOWN,RIGHT,ENTER", 1000, "shop");
		reports.log(LogStatus.PASS,"Press Back Key");
		sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
		driver.switchTo().defaultContent();
		if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "home", "name_nl"))) {
			driver.switchTo().frame(getCurrentFrameIndex());
			reports.log(LogStatus.PASS, "Hub Screen getting displayed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Hub Screen not displayed");
		}
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString() , 1	, 1000);
		reports.log(LogStatus.PASS, "Go to Hub Screen By pressing Menu Key");
		new Hub(driver).launchAndVerifyMenuScreen();
		reports.log(LogStatus.PASS, "Go to Shop Screen");
		sendKeySequence("DOWN,RIGHT,ENTER", 1000, "shop");
		reports.log(LogStatus.PASS,"Press TV_GUIDE Key");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		reports.log(LogStatus.PASS,"Press Back Key");
		sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
		driver.switchTo().defaultContent();
		if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "home", "name_nl"))) {
			driver.switchTo().frame(getCurrentFrameIndex());
			reports.log(LogStatus.PASS, "Hub Screen getting displayed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Hub Screen not displayed");
		}
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString() , 1	, 1000);
		reports.log(LogStatus.PASS ,"Go to EPG Screen");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		sendNumaricKeys(3);
		Thread.sleep(3000);
		sendKeyMultipleTimes("ENTER", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).programDetailsScreen, "Program Details Screen");
		reports.log(LogStatus.PASS, "Press kijken to watch episode");
		sendKeyMultipleTimes("ENTER", 1, 4000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
		new DTVChannelScreen(driver).pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
		reports.log(LogStatus.PASS,"Press Back Key");
		sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
		driver.switchTo().defaultContent();
		if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "home", "name_nl"))) {
			driver.switchTo().frame(getCurrentFrameIndex());
			reports.log(LogStatus.PASS, "Hub Screen getting displayed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Hub Screen not displayed");
		}
	}
	
	public void verifyRecordButton() throws InterruptedException {
		
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		List<WebElement> we = driver.findElements(By.xpath(ObjectRepository.EpgScreen.actionList));
		boolean found = false;
		for (int i =0 ;i<we.size();i++)
		{
			if(we.get(i).getText().contains("stoppen"))
			{
				sendKeyMultipleTimes("ENTER", 2, 1000);
				new DTVChannelScreen(driver).openLiveTV();
				found = true;
				break;
			}
			else
			{
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
		if(!found)
		{
			sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
			new DTVChannelScreen(driver).openLiveTV();
		}
		reports.log(LogStatus.PASS, "Press Record Button");
		sendUnicodeMultipleTimes(Unicode.VK_ADD_RECORDING.toString(), 1, 2000);
		sendKeyMultipleTimes("ENTER", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).programDetailsScreen, "Program Details Screen");
		
		if(driver.findElement(By.xpath("//div[@class='dtv-info-ratings']/img[@id='recording']")).getAttribute("src").contains("ico_Ongoing_recording.png")){
			reports.log(LogStatus.PASS, "Press Record Button - Recording Started Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Press Record Button - Recording not started");
		}
		reports.log(LogStatus.PASS, "Go to EPG Screen");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		reports.log(LogStatus.PASS, "Press Record Key");
		sendUnicodeMultipleTimes(Unicode.VK_ADD_RECORDING.toString(), 1, 2000);
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "Press Record Key -  Nothing happned. TV Guide");
		
		reports.log(LogStatus.PASS, "Navigate to Library Screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 2000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Press Record Key");
		sendUnicodeMultipleTimes(Unicode.VK_ADD_RECORDING.toString(), 1, 2000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Press Record Key - Nothing happened Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
	}
	
	//Rahul Methods
	public void verifyRCCHPlusChMinusKeysOnDTV() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(1);
		Thread.sleep(3000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String prevchannelNumber = dtvChannelScreen.chnlNoIn_Infobar.getText();
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentChannelNo = dtvChannelScreen.chnlNoIn_Infobar.getText();
		if(!currentChannelNo.equalsIgnoreCase(prevchannelNumber))
		{
			reports.log(LogStatus.PASS, "Press CH+ Key - Channel Zapped to "+ currentChannelNo + " from Channel Number - "+prevchannelNumber);
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else{
			FailTestCase("Press CH+ Key - Not Zapped to next channel");
		}
		reports.log(LogStatus.PASS,"Press CH- Key");
		sendUnicodeMultipleTimes(Unicode.VK_CHANNEL_MINUS.toString(), 1, 2000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String newChannelNo = dtvChannelScreen.chnlNoIn_Infobar.getText();
		if(!currentChannelNo.equalsIgnoreCase(newChannelNo))
		{
			reports.log(LogStatus.PASS, "Press CH- Key - Channel Zapped to "+ newChannelNo + " from Channel Number - "+currentChannelNo);
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else{
			FailTestCase("Press CH+ Key - Not Zapped to next channel");
		}
		verifyCHPluseMinusKeyOnHubScreen();
		reports.log(LogStatus.PASS, "Play TSTV Playback");
		playTSTV();
		reports.log(LogStatus.PASS, "Press CH+ Key while TSTV Playback is playing");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(notificationMsg, "Warning Message");
		handlePopupIfExist();
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		handlePopupIfExist();
		reports.log(LogStatus.PASS, "Navigate to TV Guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		String focusProgram = new EpgScreen(driver).focusElemntInEpg.getText();
		reports.log(LogStatus.PASS, "Press CH+ Key on EPG Screen");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide is still");
		if(new EpgScreen(driver).focusElemntInEpg.getText().equalsIgnoreCase(focusProgram))
		{
			reports.log(LogStatus.PASS, "Nothing happens. Used still on EPG Screen and focus is on current episode");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Used still on EPG Screen but focus changed from current episode");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Play CUTV Playback");
		playCUTVPlayBack();
		reports.log(LogStatus.PASS, "Press CH+ Key while CUTV Playback is playing");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(notificationMsg, "Warning Message");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
	}
	
	private void verifyCHPluseMinusKeyOnHubScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to Hub Screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String prevScreenTitle = headerText.getText();
		if(prevScreenTitle.equalsIgnoreCase("home"))
		{
			reports.log(LogStatus.PASS, "Hub Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Hub Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Press Ch+ Key on Hub Page");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(prevScreenTitle)){
			reports.log(LogStatus.PASS, "Press CH+ Key - Nothing happens. User still on Hub Page");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("User not on Hub Page");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Press Ch- Key on Hub Page");
		sendUnicodeMultipleTimes(Unicode.VK_CHANNEL_MINUS.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(prevScreenTitle)){
			reports.log(LogStatus.PASS, "Press CH- Key - Nothing happens. User still on Hub Page");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("User not on Hub Page");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}
	private void playCUTVPlayBack() throws InterruptedException {
		String cutvChannel =getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		handlePopupIfExist();
		sendNumaricKeys(Integer.parseInt(cutvChannel));
		Thread.sleep(3000);
		handlePopupIfExist();
		dtvChannelScreen.navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 3000);
		reports.log(LogStatus.PASS, "Start CUTV Playback - click on kijken");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 4000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
				sendKeyMultipleTimes("ENTER", 1, 3000);
			}
		} catch (NoSuchElementException ex) {
		}
		Thread.sleep(3000);
		new DTVChannelScreen(driver).pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
	}

	public void playTSTV() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		handlePopupIfExist();
		reports.log(LogStatus.PASS, "Play TSTV");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		Thread.sleep(60000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		Thread.sleep(60000);
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
		Thread.sleep(20000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		new DTVChannelScreen(driver).pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
	}
	
	public void verifyRCUOnDemandKey() throws InterruptedException {
		reports.log(LogStatus.PASS, "Press On Demand Key");
		verifyOnDemandKey();
		reports.log(LogStatus.PASS, "Play TSTV Playback");
		playTSTV();
		reports.log(LogStatus.PASS, "Press On Demand Key while watching TSTV Playback");
		verifyOnDemandKey();
		reports.log(LogStatus.PASS, "Play CUTV Playback");
		playCUTVPlayBack();
		reports.log(LogStatus.PASS, "Press On Demand Key while watching CUTV Playback");
		verifyOnDemandKey();
	}

	private void verifyOnDemandKey() throws InterruptedException
	{
		
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Shop", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop screen should be displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}
	
	public void verifyRCUPVRKey() throws InterruptedException {
		reports.log(LogStatus.PASS, "Press PVR Key from any screen");
		verifyPVRKey();
		reports.log(LogStatus.PASS, "Play TSTV Playback");
		playTSTV();
		reports.log(LogStatus.PASS, "Press PVR Key while watching TSTV Playback");
		verifyPVRKey();
		reports.log(LogStatus.PASS, "Play CUTV Playback");
		playCUTVPlayBack();
		reports.log(LogStatus.PASS, "Press PVR Key while watching CUTV Playback");
		verifyPVRKey();
		
	}
	private void verifyPVRKey() throws InterruptedException{
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		if(headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
		{
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop screen should be displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void verifyRCURadioKey() throws InterruptedException {
		reports.log(LogStatus.PASS, "Press Radio Key from any screen");
		sendUnicodeMultipleTimes(Unicode.VK_RADIO.toString(), 2, 1000);
		verifyRadioKey();
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 2, 2000);
		reports.log(LogStatus.PASS, "Play TSTV Playback");
		playTSTV();
		reports.log(LogStatus.PASS, "Press Radio Key while watching TSTV Playback");
		sendUnicodeMultipleTimes(Unicode.VK_RADIO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(notificationMsg, "Notification popup");
		reports.log(LogStatus.PASS, "Click on Continue");
		sendKeyMultipleTimes("ENTER", 1, 3000);
		verifyRadioKey();
		reports.log(LogStatus.PASS, "Play CUTV Playback");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 2, 2000);
		playCUTVPlayBack();
		reports.log(LogStatus.PASS, "Press Radio Key while watching CUTV Playback");
		sendUnicodeMultipleTimes(Unicode.VK_RADIO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(notificationMsg, "Notification popup");
		reports.log(LogStatus.PASS, "Click on Continue");
		sendKeyMultipleTimes("ENTER", 1, 3000);
		verifyRadioKey();	
	}

	private void verifyRadioKey() throws InterruptedException {
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
		String channelNumber = new DTVChannelScreen(driver).chnlNoIn_Infobar.getText();
		if(channelNumber.equalsIgnoreCase(getExcelKeyValue("DTVChannel", "RadioChannel", "Values")))
		{
			reports.log(LogStatus.PASS, "Navigate to Radio Channel " +channelNumber );
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Not tuned to Radio Channel");
		}
		
	}

}

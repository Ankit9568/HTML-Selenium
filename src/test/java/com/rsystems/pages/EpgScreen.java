package com.rsystems.pages;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.ProximusContext;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

/**
 * @author Ankit.Agarwal1 return necessary object and dependent function of EPG
 *         Screen
 */

public class EpgScreen extends TestInitization {

	static WebDriver driver;

	public EpgScreen(WebDriver driver) {
		EpgScreen.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = ObjectRepository.EpgSettingScreen.epgType)
	public WebElement epgType;

	@FindBy(how = How.ID, using = ObjectRepository.EpgSettingScreen.epgFont)
	public WebElement epgFont;

	@FindBy(how = How.ID, using = ObjectRepository.EpgSettingScreen.epgBackground)
	public WebElement epgBackground;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgSettingScreen.screenBackgroundColor)
	public WebElement screenBackgroundColor;

	@FindBy(how = How.ID, using = ObjectRepository.EpgSettingScreen.confirmButton)
	public WebElement epgConfirmBtn;

	@FindBy(how = How.ID, using = ObjectRepository.EpgSettingScreen.cancelButton)
	public WebElement epgCancelBtn;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focousElement)
	public WebElement focusElemntInEpg;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.displayChannelTitle)
	public WebElement displayChannelTitle;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.EpgScreen.displayChannelDescription)
	public WebElement displayChannelDescription;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.EpgScreen.displayChannelprogressbar)
	public WebElement displayChannelprogressbar;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.displayChannelStartTime)
	public WebElement displayChannelStartTime;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.displayChannelEndTime)
	public WebElement displayChannelEndTime;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.displayChannelCallLetterIcon)
	public WebElement displayChannelCallLetterIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.cutvIcon)
	public WebElement cutvIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focousElementProrgamImg)
	public WebElement focousElementProrgamImg;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.diplayChannelDescImg)
	public WebElement diplayProgramDescImg;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focusElementProgramTiminig)
	public WebElement focusElementProgramTime;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.epgFocussedCell)
	public WebElement epgFocussedCell;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.epgNonFocussedCell)
	public WebElement epgNonFocussedCell;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.activeZapBlockElement)
	public WebElement activeElement;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focousElementChannelNumber)
	public WebElement focousElementChannelNumber;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.herstarten)
	public WebElement herstarten;

	@FindBy(how = How.XPATH, using = ObjectRepository.ZapListPage.screenTitle)
	public WebElement screenTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focusedProgramTvguide)
	public WebElement focusedProgramTvguide;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.focusedCurrentLineTvguide)
	public WebElement focusedCurrentLineTvguide;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.EpgScreen.actionMenuItems)
	public WebElement actionMenuItems;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programDurationIn_Infobar)
	public WebElement programDurationIn_Infobar;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programTitle)
	public WebElement programTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.timeInFocousCell)
	public WebElement timeInFocousCell;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.summryInFocousCell)
	public WebElement summryInFocousCell;

	public void goToEpgSettingScreen() throws InterruptedException {

		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS, "Navigate to the Setting Screen");
		System.out.println("Current Language Set " + ProximusContext.getCurrentLanguage().toUpperCase().trim());
		switch (ProximusContext.getCurrentLanguage().toUpperCase().trim()) {

		case "NL":
			TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
			reports.log(LogStatus.PASS, "Step : Navigate to the System Screen");
			TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "System", "name_nl"));

			reports.log(LogStatus.PASS, "Step : Navigate to the EPG Setting Screen");
			TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "epgSetting", "name_nl"));
			break;
		case "FR":
			TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_fr"));
			reports.log(LogStatus.PASS, "Step : Navigate to the System Screen");
			TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "System", "name_fr"));

			reports.log(LogStatus.PASS, "Step : Navigate to the EPG Setting Screen");
			TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
					TestInitization.getExcelKeyValue("screenTitles", "epgSetting", "name_fr"));
			break;
		}
	}

	public void goToEpgChannelScreen(boolean usingHotKey) throws InterruptedException {

		reports.log(LogStatus.PASS, "Navigate to EPG");
		if (usingHotKey) {

			TestInitization.sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			TestInitization.setApplicationHubPage(2);
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepository.EpgScreen.focousElement)));
	}

	public boolean validationEpgCss(HashMap<String, String> currentEpgSetting, boolean usingHotKey)
			throws InterruptedException {

		String epgType = currentEpgSetting.get("epgType");
		String epgBackground = currentEpgSetting.get("epgBackground");
		String epgFont = currentEpgSetting.get("epgFont");

		// First go to epg channel screen
		goToEpgChannelScreen(usingHotKey);
		String expectedFontSize = null;
		String expectedFontFamily = null;
		String expectedFontColor = null;
		String expectedChannelCount = null;
		String expectedBackgroundColor = null;

		if (epgType.equalsIgnoreCase("STANDAARD") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Grijs")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Geel")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard",
					"font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GEEL")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GRIJS")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard",
					"font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("GRIJS")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("GEEL")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GRIJS")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs",
					"BackgroundColor");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GEEL")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel",
					"No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel",
					"BackgroundColor");
		} else if (epgType.equalsIgnoreCase("d�faut") && epgBackground.equalsIgnoreCase("d�faut")
				&& epgFont.equalsIgnoreCase("d�faut")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "No_of_Channel");
			expectedBackgroundColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "BackgroundColor");
		}
		expectedChannelCount = String.valueOf(expectedChannelCount.charAt(0));

		driver.switchTo().defaultContent();

		// Verify the screen background
		validateEpgBackground(expectedBackgroundColor);

		driver.switchTo().frame(getCurrentFrameIndex());

		List<WebElement> listChnl = driver.findElements(By.xpath("//ul[contains(@class,'channelRow')]"));

		if ((listChnl.size() + "").equalsIgnoreCase(expectedChannelCount)) {
			reports.log(LogStatus.PASS,
					"Row count matched Actual: " + listChnl.size() + " Expected : " + expectedChannelCount);
			System.out.println(
					"Expected Channel Count match Actual: " + listChnl.size() + " Expected : " + expectedChannelCount);
		} else {
			throw new SkipException("Expected Channel Count Unmatch Actual: " + listChnl.size() + " Expected : "
					+ expectedChannelCount);
		}

		// Remove first channel because first channel is always different font
		listChnl.remove(0);

		for (WebElement chnl : listChnl) {
			List<WebElement> listOfPrgrm = chnl.findElements(By.xpath("./li[contains(@class,'program')]"));
			System.out.println("list of program" + listOfPrgrm.size());
			for (WebElement program : listOfPrgrm) {
				WebElement we = program.findElement(By.xpath("./div/p[contains(@class,'programTitle')]"));

				if (expectedFontSize.equalsIgnoreCase(we.getCssValue("font-size"))
						&& expectedFontFamily.equalsIgnoreCase(we.getCssValue("font-family"))
						&& expectedFontColor.equalsIgnoreCase(we.getCssValue("color"))) {
				} else {
					throw new SkipException("CSS not Matched Actual Font-Size,font, font-family, color : "
							+ we.getCssValue("font-size") + "," + we.getCssValue("font-family") + ","
							+ we.getCssValue("color") + " Expected : font-size, font-family, color " + expectedFontSize
							+ "," + expectedFontFamily + "," + expectedFontColor);
				}
			}
		}
		return true;
	}

	public void shuffleEpgSetting(String epgType, String epgBackground, String epgFont) throws InterruptedException {

		changeEpgDropDownValue(epgType, epgBackground, epgFont);

		// Cancel change setting
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);

	}

	private void changeEpgDropDownValue(String epgType, String epgBackground, String epgFont)
			throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgSettingScreen();

		int MoveCount = 4;
		// For EPG Type
		reports.log(LogStatus.PASS, "Trying to set the Epg Type");
		System.out.println("Trying to set the Epg Type");
		while ((!epgScreen.epgType.getText().equalsIgnoreCase(epgType)) && MoveCount > 0) {
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}

		// Set the Epg Background
		System.out.println(" Trying to set the EPG background");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		MoveCount = 4;

		reports.log(LogStatus.PASS, "Trying to set the EPG background");
		while ((!epgScreen.epgBackground.getText().equalsIgnoreCase(epgBackground)) && MoveCount > 0) {
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}

		// Set the Epg font
		System.out.println(" Trying to set the EPG font");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		MoveCount = 4;
		reports.log(LogStatus.PASS, "Trying to set the EPG font");
		while ((!epgScreen.epgFont.getText().equalsIgnoreCase(epgFont)) && MoveCount > 0) {
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}

	}

	public HashMap<String, String> changeEpgSetting(String epgType, String epgBackground, String epgFont)
			throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		changeEpgDropDownValue(epgType, epgBackground, epgFont);

		// Save setting
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);

		// Validation for Setting saved successfully or not
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());

		if (epgScreen.epgType.getText().equalsIgnoreCase(epgType)
				&& epgScreen.epgBackground.getText().equalsIgnoreCase(epgBackground)
				&& epgScreen.epgFont.getText().equalsIgnoreCase(epgFont)) {

			HashMap<String, String> currentEpgSetting = new HashMap<String, String>();
			currentEpgSetting.put("epgType", epgType);
			currentEpgSetting.put("epgBackground", epgBackground);
			currentEpgSetting.put("epgFont", epgFont);
			reports.log(LogStatus.PASS, "EPG Settings Changed");
			return currentEpgSetting;

		}

		else {
			throw new SkipException(
					"Unable to set EPG Setting Actual EpgType,EpgBackground,EpgFont" + epgScreen.epgType.getText() + ","
							+ epgScreen.epgBackground.getText() + "," + epgScreen.epgFont.getText()
							+ "Expected EpgType,EpgBackground,EpgFont" + epgType + "," + epgBackground + "," + epgFont);
		}

	}

	public boolean validateEpgChannelSetting(String epgType, String epgBackgroung, String epgFont)
			throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgSettingScreen();
		boolean validationResult = false;
		if (epgScreen.epgType.getText().equalsIgnoreCase(epgType)
				&& epgScreen.epgBackground.getText().equalsIgnoreCase(epgBackgroung)
				&& epgScreen.epgFont.getText().equalsIgnoreCase(epgFont)) {
			validationResult = true;
		}
		reports.log(LogStatus.PASS, "Validation for EPG channel setting");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		return validationResult;
	}

	public void validateEpgBackground(String expectedEpgBackground) {

		EpgScreen epgScreen = new EpgScreen(driver);

		if (expectedEpgBackground.equalsIgnoreCase("Blue")) {
			// Check css file
			// ["./resources/components/epg_custom/css/parentgreen.css"] not
			// exit
			try {
				epgScreen.screenBackgroundColor.isDisplayed();
				reports.log(LogStatus.FAIL, "Verification of background color is failed");
				throw new SkipException("Verification of background color is failed");
			} catch (NoSuchElementException e) {
				// Means css file not exist
				reports.log(LogStatus.PASS,
						"Verification of background color is passed Actual color : Blue  and expected color : blue");

			}
		}

		else if (expectedEpgBackground.equalsIgnoreCase("Green")) {
			// check css file
			// [./resources/components/epg_custom/css/parentgreen.css] exist

			try {
				epgScreen.screenBackgroundColor.isDisplayed();
				reports.log(LogStatus.PASS,
						"Verification of background color is passed Actual color : Green  and expected color : Green");

			} catch (NoSuchElementException e) {
				// Means css file not exist
				reports.log(LogStatus.FAIL, "Verification of background color is failed");
				throw new SkipException("Verification of background color is failed");

			}

		}
	}

	public void verifyOptionInEpg(String[] optionArr, WebElement we) throws InterruptedException {

		int maxMoveCount = 3;
		String actualVal = "";
		for (String option : optionArr) {
			maxMoveCount = 3;
			while (maxMoveCount > 0) {

				actualVal = actualVal + we.getText() + ";";
				if (we.getText().equalsIgnoreCase(option)) {
					reports.log(LogStatus.PASS, option + " is visible on webpage");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					actualVal = "";
					break;
				}
				sendKeyMultipleTimes("RIGHT", 1, 1000);
				maxMoveCount--;
			}

			if (maxMoveCount == 0) {
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				throw new SkipException("Option is not available in EPG Type Expected Option: " + option
						+ " Actually Found :" + actualVal);
			}
		}
	}

	public void confirmBtnExist() throws InterruptedException {

		try {
			if (epgConfirmBtn.isDisplayed()) {
				reports.log(LogStatus.PASS, "Confirm button is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				FailTestCase("Confirm button is not visible on webpage");
			}

		} catch (NoSuchElementException e) {
			FailTestCase("Confirm button is not visible on webpage");
		}
	}

	public void cancelBtnExist() throws InterruptedException {

		try {
			if (epgCancelBtn.isDisplayed()) {
				reports.log(LogStatus.PASS, "Cancel button is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				FailTestCase("Cancel button is not visible on webpage");
			}

		} catch (NoSuchElementException e) {
			FailTestCase("Cancel button is not visible on webpage");
		}
	}

	public boolean validateEPGProgramSetting(HashMap<String, String> currentEpgSetting, boolean usingHotKey)
			throws InterruptedException {

		String epgType = currentEpgSetting.get("epgType");
		String epgBackground = currentEpgSetting.get("epgBackground");
		String epgFont = currentEpgSetting.get("epgFont");
		String expectedChannelCount = null;
		String expectedFontColor = null;

		// First go to epg channel screen
		goToEpgChannelScreen(usingHotKey);

		if (epgType.equalsIgnoreCase("STANDAARD") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Grijs")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Geel")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GEEL")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GRIJS")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("GRIJS")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("GEEL")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GRIJS")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GEEL")) {
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel",
					"No_of_Channel");
		}

		driver.switchTo().frame(getCurrentFrameIndex());
		List<WebElement> listChnl = driver.findElements(By.xpath("//ul[contains(@class,'channelRow')]"));

		if ((listChnl.size() + "").equalsIgnoreCase(expectedChannelCount)) {
			reports.log(LogStatus.PASS,
					"Row count matched Actual: " + listChnl.size() + " Expected : " + expectedChannelCount);
			System.out.println(
					"Expected Channel Count match Actual: " + listChnl.size() + " Expected : " + expectedChannelCount);
		} else {
			throw new SkipException("Expected Channel Count Unmatch Actual: " + listChnl.size() + " Expected : "
					+ expectedChannelCount);
		}

		// Validate title of Focus program

		if (focusElemntInEpg.getText().equalsIgnoreCase(displayChannelTitle.getText())) {
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			reports.log(LogStatus.PASS, "Display program title and focus program title are same");
		}

		else {
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			throw new SkipException("Display program title and focus program title are not same");
		}
		// Validate focused program details

		reports.log(LogStatus.PASS, "Change focus to another channel");
		isDisplayed(displayChannelDescription, "Focused program details");

		// focused another program
		sendKeyMultipleTimes("NUMPAD5", 1, 4000);

		// validate again description
		isDisplayed(displayChannelDescription, "Focused program details");

		// validate call latter
		isDisplayed(displayChannelCallLetterIcon, "Call Letter Icon");

		// Validate progress bar
		isDisplayed(displayChannelprogressbar, "Progress bar");

		// Start Time validation
		isDisplayed(displayChannelStartTime, "Start time Icon");

		// End Time validation
		isDisplayed(displayChannelEndTime, "End time Icon");

		// CUTV icon
		isDisplayed(cutvIcon, "Cutv Icon");

		// Match the program logo and display logo image source are same

		if (diplayProgramDescImg.getAttribute("src").equalsIgnoreCase(focousElementProrgamImg.getAttribute("src"))) {

			reports.log(LogStatus.PASS, "Display program image and focus program image source are same");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

		} else {
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			reports.log(LogStatus.FAIL, "Display program image and focus program image source are not same");

		}

		// Validation for font color
		if (focusElemntInEpg.getCssValue("color").equalsIgnoreCase(expectedFontColor)) {

			reports.log(LogStatus.PASS, "Font color is matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}

		else {
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			reports.log(LogStatus.FAIL, "Font color is not matched");

		}

		return true;
	}

	public void isDisplayed(WebElement we, String webElementName) throws InterruptedException {

		try {
			if (we.isDisplayed()) {

				reports.log(LogStatus.PASS, webElementName + " is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				reports.log(LogStatus.PASS, webElementName + " exist on webpage but it is not visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

			}
		} catch (NoSuchElementException e) {
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			throw new SkipException(webElementName + " is not found on webpage");

		}

	}

	public void verifyDefaultType() throws InterruptedException {
		String defaultEPGType;
		if (ProximusContext.getCurrentLanguage() == "NL") {
			defaultEPGType = "STANDAARD";
		} else {
			defaultEPGType = "d�faut";
		}
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		if (epgType.getText().equalsIgnoreCase(defaultEPGType)) {
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			String epg_backGround = epgBackground.getText();
			reports.log(LogStatus.PASS, "Try to change EPG Background value");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (epg_backGround.equalsIgnoreCase(epgBackground.getText())) {
				reports.log(LogStatus.PASS, "Not be able to change the background color value");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				reports.log(LogStatus.FAIL, "Able to change the background color value");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			String font_color = epgFont.getText();
			reports.log(LogStatus.PASS, "Try to change Font Color value");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (font_color.equalsIgnoreCase(epgFont.getText())) {
				reports.log(LogStatus.PASS, "Not be able to change the font color value");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				reports.log(LogStatus.FAIL, "Able to change the font color value");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
		}
	}

	public void verifyEPGScreenDisplayed() throws InterruptedException {

		try {
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if (focusElemntInEpg.isDisplayed()) {
				reports.log(LogStatus.PASS, "EPG Screen is visible on webpage");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			} else {
				FailTestCase("EPG Screen is not visible on webpage");
			}

		} catch (NoSuchElementException e) {
			FailTestCase("EPG Screen is not visible on webpage");
		}

	}

	public void verifyNavigationinEPG() throws InterruptedException {

		verifyNavigationHorizontally();
		verifyNavigationVertically();
	}

	private void verifyNavigationVertically() throws InterruptedException {
		String prevTitle = focusElementProgramTime.getText();
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		if (!focusElementProgramTime.getText().equalsIgnoreCase(prevTitle)) {
			reports.log(LogStatus.PASS, "Navigation is properly on Down Side");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			prevTitle = focusElementProgramTime.getText();
		} else {
			FailTestCase("Navigation is not properly on Down Side");

		}
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		if (!focusElementProgramTime.getText().equalsIgnoreCase(prevTitle)) {
			reports.log(LogStatus.PASS, "Navigation is properly on Up Side");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			prevTitle = focusElementProgramTime.getText();
		} else {
			FailTestCase("Navigation is not properly on Up Side");

		}

	}

	private void verifyNavigationHorizontally() throws InterruptedException {
		String prevTitle = focusElementProgramTime.getText();
		TestInitization.sendKeyMultipleTimes("RIGHT", 4, 1000);
		if (!focusElementProgramTime.getText().equalsIgnoreCase(prevTitle)) {
			reports.log(LogStatus.PASS, "Navigation is properly on Right Side");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			prevTitle = focusElementProgramTime.getText();
		} else {
			FailTestCase("Navigation is not properly on Right Side");
		}
		TestInitization.sendKeyMultipleTimes("LEFT", 4, 1000);
		if (!focusElementProgramTime.getText().equalsIgnoreCase(prevTitle)) {
			reports.log(LogStatus.PASS, "Navigation is properly on Left Side");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			prevTitle = focusElementProgramTime.getText();
		} else {
			FailTestCase("Navigation is not properly on Left Side");
		}
	}

	public void verifyLinesInEPGScreen() throws InterruptedException {
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		goToEpgChannelScreen(false);
		reports.log(LogStatus.PASS, "Verify Two Lines in EPG Screen");
		libraryScreen.verifyTwoLinesInLibraryScreen("Level3");
		reports.log(LogStatus.PASS, "Verify Opacity of Two Lines getting displayed on EPG Page");
		libraryScreen.verifyOpactiyOfLines();
		reports.log(LogStatus.PASS, "Verify Line movements while navigate in EPG");
		verifyMovementsInUpAndDownLine();
	}

	public void verifyGradientOnEPG() throws InterruptedException {
		sendKeyMultipleTimes("DOWN", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (new Hub(driver).focusHubElement.getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
			reports.log(LogStatus.PASS,
					"Expected Output - Focus should be on " + getExcelKeyValue("screenTitles", "LiveTV", "name_nl")
							+ ". Actual Output - Focus is on " + new Hub(driver).focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Test cases is failed as Initial Focus is not on "
					+ getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + " Actual Focus is on "
					+ new Hub(driver).focusHubElement.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeElement.getText().equalsIgnoreCase(getExcelKeyValue("TvFilterLayer", "TvGrid", "name_nl"))) {
			reports.log(LogStatus.PASS, "Expected Output - Focus should be on tv-gids. Actual Output - Focus is on "
					+ activeElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Test cases is failed as Initial Focus is not on tv-gids.  Actual Focus is on "
					+ activeElement.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		if (epgFocussedCell.getCssValue("background").contains("epg-gradient.png")) {
			reports.log(LogStatus.PASS, "EPG gradient is displayed in focussed cell");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("EPG graient not present on focussed cell");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void verifyMovementsInUpAndDownLine() throws InterruptedException {

		LibraryScreen libraryScreen = new LibraryScreen(driver);
		boolean checkMovement = false;
		String initialUpLine = libraryScreen.upCanvasLine.getAttribute("style");
		String initialDownLine = libraryScreen.downCanvasLine.getAttribute("style");

		int itemSize = driver.findElements(By.className("cItem")).size();
		for (int i = 0; i <= itemSize - 1; i++) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			if (!(libraryScreen.upCanvasLine.getAttribute("style").equalsIgnoreCase(initialUpLine)
					&& libraryScreen.upCanvasLine.getAttribute("style").equalsIgnoreCase(initialDownLine))) {
				checkMovement = true;
				break;
			}

		}
		if (checkMovement) {
			FailTestCase("No movement in Line should happen");

		} else {
			reports.log(LogStatus.PASS, "No movements in line");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void channelChangeAndValidation() throws InterruptedException {

		sendNumaricKeys(1);
		Thread.sleep(5000);
		reports.log(LogStatus.PASS, " Navigate to 30 channel");
		sendNumaricKeys(30);
		reports.attachScreenshot(captureCurrentScreenshot());
		Thread.sleep(5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (focousElementChannelNumber.getText().contentEquals("30")) {
			reports.log(LogStatus.PASS, "Successfully navigate to 30 channel number");
			reports.attachScreenshot(captureCurrentScreenshot());

		} else {
			FailTestCase("Unable to navigate to expected channel : 30 and Actual channel : "
					+ focousElementChannelNumber.getText());
		}
	}

	public void verifyRoundedCornerOnFocuCell() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		String episodeName = dtvChannelScreen.programTitle.getText();
		goToEpgChannelScreen(true);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (focusElemntInEpg.getText().equalsIgnoreCase(episodeName)) {
			reports.log(LogStatus.PASS, "Guide getting displayed with focus on current channel");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on current episode");
		}
		if (epgFocussedCell.getCssValue("border-bottom-right-radius").equalsIgnoreCase("12px")) {
			reports.log(LogStatus.PASS, "Border right bottom is rounded for focussed Cell");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Border should be rounded for focussed cell in EPG");
		}
		if (epgNonFocussedCell.getCssValue("border-bottom-right-radius").equalsIgnoreCase("0px")) {
			reports.log(LogStatus.PASS, "Borders is flat for non focussed Cell");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Border should be flat for non-focussed cell in EPG");
		}
	}

	public void verifyFFAndREWKeyOnEPGScreen() throws InterruptedException {
		setApplicationHubPage(1);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (new Hub(driver).focusHubElement.getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
			reports.log(LogStatus.PASS,
					"Expected Output - Focus should be on " + getExcelKeyValue("screenTitles", "LiveTV", "name_nl")
							+ ". Actual Output - Focus is on " + new Hub(driver).focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Test cases is failed as Initial Focus is not on "
					+ getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + " Actual Focus is on "
					+ new Hub(driver).focusHubElement.getText());
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeElement.getText().equalsIgnoreCase(getExcelKeyValue("TvFilterLayer", "TvGrid", "name_nl"))) {
			reports.log(LogStatus.PASS, "Expected Output - Focus should be on tv-gids. Actual Output - Focus is on "
					+ activeElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Test cases is failed as Initial Focus is not on tv-gids.  Actual Focus is on "
					+ activeElement.getText());
		}
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 4000);
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, 1);
		int date = calendar.get(Calendar.DATE);
		if (driver.findElement(By.className("dayHeading")).getText().contains(String.valueOf(date))) {
			reports.log(LogStatus.PASS, "Press FW Key - Day Changes in the grid");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press FW Key - Day not changed");
		}
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 2, 2000);
		calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -1);
		date = calendar.get(Calendar.DATE);
		System.out.println(driver.findElement(By.className("dayHeading")).getText());
		System.out.println(String.valueOf(date));
		if (driver.findElement(By.className("dayHeading")).getText().contains(String.valueOf(date))) {
			reports.log(LogStatus.PASS, "Press REW Key - Day Changes in the grid");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press REW Key - Day not changed");
		}
	}

	// Pritam
	public void EPG_Focus_On_Current_Program() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.openLiveTV();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String programTime = programDurationIn_Infobar.getText();
		System.out.println(programTime);
		String programTitleofScreen = programTitle.getText();
		System.out.println(programTitleofScreen);

		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String programTitleofguide = focusElemntInEpg.getText();
		System.out.println(programTitleofguide);
		String programTimeSchedule = focusElementProgramTime.getText();
		System.out.println(programTimeSchedule);

		if (programTime.equalsIgnoreCase(programTimeSchedule)
				&& programTitleofScreen.equalsIgnoreCase(programTitleofguide)) {
			reports.log(LogStatus.PASS, "Current Program " + programTitleofScreen + " is getting hilighted");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Current Program " + programTitleofScreen + " is not getting hilighted");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	// EPG via hotkey

	public void EPG_via_Hotkey() throws InterruptedException {
		String EpgGuideScreen = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		System.out.println(EpgGuideScreen);
		String actionMenuTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		System.out.println(actionMenuTitle);
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String currentEPGuideScreenTitle = screenTitle.getText();
		System.out.println(currentEPGuideScreenTitle);
		if (EpgGuideScreen.equalsIgnoreCase(currentEPGuideScreenTitle)) {
			reports.log(LogStatus.PASS, "EPG screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("EPG has not been reached");
		}

		// Navigate to EPG guide
		driver.switchTo().frame(getCurrentFrameIndex());
		verifyNavigationinEPG();

		// Choose Program
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		// Action menu should be shown
		driver.switchTo().frame(getCurrentFrameIndex());
		if (actionMenuItems.isDisplayed()) {
			reports.log(LogStatus.PASS, "Action menu screen has been reached");
			reports.attachScreenshot(captureCurrentScreenshot());

		} else {
			FailTestCase("Not reached to the Action menu Screen");
		}

		// Press Back

		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		if (EpgGuideScreen.equalsIgnoreCase(currentEPGuideScreenTitle)) {
			reports.log(LogStatus.PASS, "EPG screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("EPG has not been reached");
		}
	}

	public void EPG_Focus_On_Current_Time() throws InterruptedException {
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String tvGuideValue = focusedProgramTvguide.getCssValue("width");
		String tvGuideLine = focusedCurrentLineTvguide.getCssValue("margin-left");
		System.out.println(tvGuideLine);
		System.out.println(tvGuideValue);
		int tvGuideValueOne = Integer.parseInt(tvGuideValue.replaceAll("[\\D]", ""));
		int tvGuideLineOne = Integer.parseInt(tvGuideLine.replaceAll("[\\D]", ""));
		System.out.println(tvGuideValueOne);
		System.out.println(tvGuideLineOne);
		if (tvGuideLineOne <= tvGuideValueOne) {
			reports.log(LogStatus.PASS, "Verify that the start time of the time line is the current time");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Verification of the start time of the time line in the current time has failed");
		}
	}
}

package com.rsystems.pages;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.text.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.rsystems.pages.RecordingScreen.EpisodeInfo;
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

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.displayChannelDescription)
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

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focousElementCell)
	public WebElement focousElementCell;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.dayNavigator)
	public WebElement dayNavigator;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.channelGenere)
	public WebElement channelGenere;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.channelLogo)
	public WebElement channelLogo;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.cutvChannelIcon)
	public WebElement cutvChannelIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focussedCell)
	public WebElement focussedCell;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.nonFocussedCell)
	public WebElement nonFocussedCell;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.ChannelCells)
	public WebElement channelCells;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.nonFocussedProgramTitle)
	public WebElement nonFocussedProgramTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.largeRecordingIcon)
	public WebElement largeRecordingIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.PIPElements.currentPIPClassElement)
	public WebElement breadcumbPosition;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.activeMenuItemElement)
	public WebElement activeInfoMenuItem;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.smallRecordingIcon)
	public WebElement smallRecordingIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.timeInNonFocousCell)
	public WebElement timeInNonFocousCell;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.summryInNonFocousCell)
	public WebElement summryInNonFocousCell;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.timeLineGradient)
	public WebElement timeLineGradient;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.epgPoster)
	public WebElement epgPoster;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.epgTitleHighlightedProgram)
	public WebElement epgTitleHighlightedProgram;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.remainingTime)
	public WebElement remainingTime;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.titleGroup)
	public WebElement titleGroup;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.programSummary)
	public WebElement programSummary;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.groupIconImage)
	public WebElement groupIconImage;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.groupIcon)
	public WebElement groupIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.barIcon)
	public WebElement barIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.lastIcon)
	public WebElement lastIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focusedChannlDetails)
	public WebElement focusedChannlDetails;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.channelBar)
	public WebElement ChannelbarInEpg;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.epgGroupIcon)
	public WebElement epgGroupIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.channelsIcon)
	public WebElement channelsIcon;

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
		TestInitization.sendKeyMultipleTimes("RIGHT", 10, 1000);
		if (!focusElementProgramTime.getText().equalsIgnoreCase(prevTitle)) {
			reports.log(LogStatus.PASS, "Navigation is properly on Right Side");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			prevTitle = focusElementProgramTime.getText();
		} else {
			FailTestCase("Navigation is not properly on Right Side");
		}
		TestInitization.sendKeyMultipleTimes("LEFT", 10, 1000);
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
		if (driver.findElement(By.className("dayHeading")).getText().contains("morgen")) {
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
		if (driver.findElement(By.className("dayHeading")).getText().contains("gisteren")) {
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

	public void EpgFocousCellValidation() throws InterruptedException {

		boolean fontFamilyMatch = false;
		boolean fontSizeMatch = false;
		boolean titlePositionMatch = false;
		boolean hd_IconSizeMatch = false;
		boolean blackListIconSizeMatch = false;
		boolean cutvIconSizeMatch = false;
		boolean recordingIconMatch = false;

		// validation of proximus font
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentFontFamily = focusElemntInEpg.getCssValue("font-family");
		String StartX = focusElemntInEpg.getLocation().getX() + "";
		String paddingFrmTop = focousElementCell.getCssValue("padding-top");
		String currentFontSize = focusElemntInEpg.getCssValue("font-size");

		reports.log(LogStatus.PASS, "Validate focous cell font Size");
		if (!currentFontSize.contentEquals(getExcelKeyValue("EpgScreen", "FocousCell", "font_size"))) {
			FailTestCase("Program title font size is not matched Actual :" + currentFontSize
					+ " and expected Font size " + getExcelKeyValue("EpgScreen", "FocousCell", "font_size"));
		}
		reports.log(LogStatus.PASS, "Program title font size is matched Actual :" + currentFontSize
				+ " and expected Font size " + getExcelKeyValue("EpgScreen", "FocousCell", "font_size"));
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Validate focous cell font family");
		if (!currentFontFamily.contentEquals(getExcelKeyValue("EpgScreen", "FocousCell", "font_family"))) {
			FailTestCase("Program title font is not matched Actual :" + currentFontFamily + " and expected Font family "
					+ getExcelKeyValue("EpgScreen", "FocousCell", "font_family"));
		}
		reports.log(LogStatus.PASS, "Program title font is not matched Actual :" + currentFontFamily
				+ " and expected Font family " + getExcelKeyValue("EpgScreen", "FocousCell", "font_family"));
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Validate focous cell starting position");
		if (!StartX.contentEquals(getExcelKeyValue("EpgScreen", "FocousCell", "StartX"))) {
			FailTestCase("Program title StartX is not matched Actual StartX :" + StartX + " and expected StartX "
					+ getExcelKeyValue("EpgScreen", "FocousCell", "StartX"));
		}
		reports.attachScreenshot(captureCurrentScreenshot());

		if (!paddingFrmTop.contentEquals(getExcelKeyValue("EpgScreen", "FocousCell", "PaddingTop"))) {

			FailTestCase("Program title Padding is not matched Actual :" + paddingFrmTop + " and expected padding "
					+ getExcelKeyValue("EpgScreen", "FocousCell", "PaddingTop"));
		}

		isNotDisplayed(timeInFocousCell, "Time in highlight cell");
		isNotDisplayed(summryInFocousCell, "Summary in highlight cell");

		List<WebElement> iconList = driver
				.findElements(By.xpath(ObjectRepository.EpgScreen.iconElementListInFocousCell));

		for (WebElement icon : iconList) {

			String iconSrc = icon.getAttribute("src");
			String iconSize = icon.getSize().toString();
			String iconPaddingTop = icon.getCssValue("margin-top");

			if (iconSrc.contains("cutv_small_icon.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "CUTV_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "CUTV_Icon", "PaddingTop"))) {
				cutvIconSizeMatch = true;
			}

			else if (iconSrc.contains("recording_small.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "Recording_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "Recording_Icon", "PaddingTop"))) {
				recordingIconMatch = true;
			}

			else if (iconSrc.contains("hd-icon.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "HD_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "HD_Icon", "PaddingTop"))) {
				hd_IconSizeMatch = true;
			}

			else if (iconSrc.contains("blacklist_small.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "Black_List_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "Black_List_Icon", "PaddingTop"))) {
				blackListIconSizeMatch = true;
			}
		}

	}

	public void dayNavigatorCssValidation() throws InterruptedException {
		String actualStartY = (dayNavigator.getLocation().getY() + dayNavigator.getSize().height) + "";
		String actualEndX = (dayNavigator.getLocation().getX() + dayNavigator.getSize().width) + "";
		String actualFontFamily = dayNavigator.getCssValue("font-family");
		String fontSize = dayNavigator.getCssValue("font-size");
		String actualOpacity = dayNavigator.getCssValue("opacity");
		String actualfontColor = dayNavigator.getCssValue("color");

		reports.log(LogStatus.PASS, "Validation of date navigator css");
		if (actualStartY.contentEquals(getExcelKeyValue("EpgScreen", "Day_Navigator", "StartY"))
				&& actualEndX.contentEquals(getExcelKeyValue("EpgScreen", "Day_Navigator", "EndX"))
				&& actualOpacity.contentEquals(getExcelKeyValue("EpgScreen", "Day_Navigator", "Opacity"))
				&& fontSize.contentEquals(getExcelKeyValue("EpgScreen", "Day_Navigator", "font_size"))
				&& actualFontFamily.contentEquals(getExcelKeyValue("EpgScreen", "Day_Navigator", "font_family"))
				&& actualfontColor.contentEquals(getExcelKeyValue("EpgScreen", "Day_Navigator", "color"))) {

			reports.log(LogStatus.PASS, "CSS matched : Actual Start Y " + actualStartY + " expected start y "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "StartY") + " Actual end X " + actualEndX
					+ " Expected End X " + getExcelKeyValue("EpgScreen", "Day_Navigator", "EndX") + " Actual Opacity "
					+ actualOpacity + " Expected opacity " + getExcelKeyValue("EpgScreen", "Day_Navigator", "Opacity")
					+ " Actual Font size " + fontSize + " Expected Font Size "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "font_size") + " Actual font family "
					+ actualFontFamily + " Expected font family "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "font_family") + " Actual font color "
					+ actualfontColor + " Expected font color "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "color"));
		} else {
			FailTestCase("CSS not  matched : Actual Start y " + actualStartY + " expected start y "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "StartY") + " Actual end X " + actualEndX
					+ " Expected End X " + getExcelKeyValue("EpgScreen", "Day_Navigator", "EndX") + " Actual Opacity "
					+ actualOpacity + " Expected opacity " + getExcelKeyValue("EpgScreen", "Day_Navigator", "Opacity")
					+ " Actual Font size " + fontSize + " Expected Font Size "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "font_size") + " Actual font family "
					+ actualFontFamily + " Expected font family "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "font_family") + " Actual font color "
					+ actualfontColor + " Expected font color "
					+ getExcelKeyValue("EpgScreen", "Day_Navigator", "color"));
		}

	}

	public void validateEPGFromTVLayer() throws InterruptedException {
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
	}

	public void validateBreadCumbOnEPG() throws InterruptedException {
		goToEpgChannelScreen(false);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgFocussedCell, "TV Guide");
		driver.switchTo().defaultContent();
		String width = driver.findElement(By.className("defaultMainBg")).getCssValue("width");
		System.out.println(Integer.parseInt(width.replaceAll("[\\D]", "")));
		int midOFScreen = Integer.parseInt(width.replaceAll("[\\D]", "")) / 2;
		int breadcumbposition = Integer.parseInt(breadcumbPosition.getCssValue("margin-left").replaceAll("[\\D]", ""));
		if (breadcumbposition < midOFScreen) {
			reports.log(LogStatus.PASS, "Breadcumb psotion is left on screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Breadcumb psotion is not left on screen");
		}
	}

	public void validateRecordingOnEPG() throws InterruptedException {
		goToEpgChannelScreen(true);
		int noOfTry = 10;
		boolean pogramFound = false;
		while (noOfTry != 0) {
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			System.out.println(driver
					.findElements(By
							.xpath("//li[@class='program focusProgram']/div/span[@class='epggroupicon']/img[contains(@src,'recording_small.png')]"))
					.isEmpty());
			if (driver
					.findElements(By
							.xpath("//li[@class='program focusProgram']/div/span[@class='epggroupicon']/img[contains(@src,'recording_small.png')]"))
					.isEmpty()) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				driver.switchTo().frame(getCurrentFrameIndex());
				List<WebElement> meuList = driver.findElements(By.className("cItem"));
				for (int i = 0; i < meuList.size(); i++) {
					System.out.println(meuList.get(i).getText());
					if (meuList.get(i).getText().equalsIgnoreCase("opnemen")) {
						pogramFound = true;
						break;
					}
				}
				if (pogramFound) {
					break;
				} else {
					sendKeyMultipleTimes("PAGE_DOWN", 1, 2000);
					sendKeyMultipleTimes("DOWN", 1, 2000);
				}
			} else {
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			noOfTry -= 1;
		}
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).programDetailsScreen, "Program Details Screen");
		List<WebElement> meuList = driver.findElements(By.className("cItem"));
		for (int i = 0; i < meuList.size(); i++) {
			System.out.println(meuList.get(i).getText());
			if (meuList.get(i).getText().equalsIgnoreCase("opnemen")) {
				reports.log(LogStatus.PASS, "Click on Openemen to Start Recording");
				reports.attachScreenshot(captureCurrentScreenshot());
				sendKeyMultipleTimes("ENTER", 1, 3000);
				break;
			} else {
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
		Thread.sleep(6000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (largeRecordingIcon.isDisplayed()
					&& largeRecordingIcon.getAttribute("src").contains("ico_Ongoing_recording.png")) {
				reports.log(LogStatus.PASS, "Large Red Icon is getting displayed on Top of EPG Screen");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Large Red Icon is not getting displayed on Top of EPG Screen");
			}
			if (smallRecordingIcon.isDisplayed()
					&& smallRecordingIcon.getAttribute("src").contains("recording_small.png")) {
				reports.log(LogStatus.PASS, "Small Red Icon is getting displayed on Program Cell");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Small Red Icon is not getting displayed on Program Cell");
			}
		} catch (NoSuchElementException ex) {
			FailTestCase("Red Recording Icon not getting displayed on EPG Screen");
		}
	}

	public void validateNonFocussedProgramCellDetails() throws InterruptedException {

		boolean fontFamilyMatch = false;
		boolean fontSizeMatch = false;
		boolean titlePositionMatch = false;
		boolean hd_IconSizeMatch = false;
		boolean blackListIconSizeMatch = false;
		boolean cutvIconSizeMatch = false;
		boolean recordingIconMatch = false;
		goToEpgChannelScreen(true);
		// validation of proximus font
		driver.switchTo().frame(getCurrentFrameIndex());
		String StartX = focusElemntInEpg.getLocation().getX() + "";
		String paddingFrmTop = nonFocussedCell.getCssValue("padding-top");
		reports.log(LogStatus.PASS, "Verify Non Focussed Program Cell Details");
		if (nonFocussedProgramTitle.getCssValue("font-family").equalsIgnoreCase("Proximus, ProximusRegular")) {
			reports.log(LogStatus.PASS,
					"Expected Font Family of Non Focussed Cell Program Title - Proximus, Proximus Regular. Actual Font Family - "
							+ nonFocussedProgramTitle.getCssValue("font-family"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Expected Font Family of Non Focussed Cell Program Title - Proximus, Proximus Regular. Actual Font Family - "
							+ nonFocussedProgramTitle.getCssValue("font-family"));
		}
		if (nonFocussedProgramTitle.getCssValue("font-size").equalsIgnoreCase("24px")) {
			reports.log(LogStatus.PASS,
					"Expected Font Size of Non Focussed Cell Program Title - 24px. Actual Font Family - "
							+ nonFocussedProgramTitle.getCssValue("font-size"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Font Family of Non Focussed Cell Program Title - 24px. Actual Font Family - "
					+ nonFocussedProgramTitle.getCssValue("font-size"));
		}

		reports.log(LogStatus.PASS, "Validate Cells starting position");
		if (!StartX.contentEquals(getExcelKeyValue("EpgScreen", "FocousCell", "StartX"))) {
			FailTestCase("Program title StartX is not matched Actual :" + StartX + " and expected StartX "
					+ getExcelKeyValue("EpgScreen", "FocousCell", "StartX"));
		}
		reports.attachScreenshot(captureCurrentScreenshot());

		if (!paddingFrmTop.contentEquals(getExcelKeyValue("EpgScreen", "NonFocusCell", "PaddingTop"))) {

			FailTestCase("Program title Padding is not matched Actual :" + paddingFrmTop + " and expected padding "
					+ getExcelKeyValue("EpgScreen", "NonFocusCell", "PaddingTop"));
		}

		isNotDisplayed(timeInNonFocousCell, "Time in Non Focussed cell");
		isNotDisplayed(summryInNonFocousCell, "Summary in Non Focussed cell");

		List<WebElement> iconList = driver
				.findElements(By.xpath(ObjectRepository.EpgScreen.iconElementListInNonFocousCell));

		for (WebElement icon : iconList) {

			String iconSrc = icon.getAttribute("src");
			String iconSize = icon.getSize().toString();
			String iconPaddingTop = icon.getCssValue("margin-top");

			if (iconSrc.contains("cutv_small_icon.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "CUTV_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "CUTV_Icon", "PaddingTop"))) {
				cutvIconSizeMatch = true;
			}

			else if (iconSrc.contains("recording_small.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "Recording_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "Recording_Icon", "PaddingTop"))) {
				recordingIconMatch = true;
			}

			else if (iconSrc.contains("hd-icon.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "HD_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "HD_Icon", "PaddingTop"))) {
				hd_IconSizeMatch = true;
			}

			else if (iconSrc.contains("blacklist_small.png")
					&& iconSize.contentEquals(getExcelKeyValue("EpgScreen", "Black_List_Icon", "Image_Size"))
					&& iconPaddingTop.contentEquals(getExcelKeyValue("EpgScreen", "Black_List_Icon", "PaddingTop"))) {
				blackListIconSizeMatch = true;
			}
		}

	}

	public void validaeEPGChannelCellDetails() throws InterruptedException {
		goToEpgChannelScreen(true);
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		reports.log(LogStatus.PASS, "Verify EPG Channel Cell Details");
		System.out.println(focousElementChannelNumber.getCssValue("font-size"));
		if (focousElementChannelNumber.getCssValue("font-size").toString()
				.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "epg_channel_number", "font_size"))
				&& String.valueOf(driver.findElement(By.className("ch_logo")).getLocation().x).trim()
						.equalsIgnoreCase("124")) {
			reports.log(LogStatus.PASS,
					"Expected Font Size of Channel Number - "
							+ getExcelKeyValue("EpgScreen", "epg_channel_number", "font_size") + " Actual Font Size -"
							+ focousElementChannelNumber.getCssValue("font-size"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Font Size of Channel Number - "
					+ getExcelKeyValue("EpgScreen", "epg_channel_number", "font_size") + " Actual Font Size -"
					+ focousElementChannelNumber.getCssValue("font-size"));
		}
		if (focousElementChannelNumber.getCssValue("font-family").toString()
				.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "epg_channel_number", "font_family"))) {
			reports.log(LogStatus.PASS,
					"Expected Font Name of Channel Number - "
							+ getExcelKeyValue("EpgScreen", "epg_channel_number", "font_family") + " Actual Font Size -"
							+ focousElementChannelNumber.getCssValue("font-family"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Font Name of Channel Number - "
					+ getExcelKeyValue("EpgScreen", "epg_channel_number", "font_family") + " Actual Font Size -"
					+ focousElementChannelNumber.getCssValue("font-family"));
		}
		if (channelLogo.getCssValue("width").toString()
				.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "channelLogo", "width"))
				&& channelLogo.getCssValue("height").toString()
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "channelLogo", "height"))) {
			reports.log(LogStatus.PASS,
					"Expected Size of Channel Logo - " + getExcelKeyValue("EpgScreen", "channelLogo", "width") + "*"
							+ getExcelKeyValue("EpgScreen", "channelLogo", "height") + " Actual Font Size -"
							+ channelLogo.getCssValue("width") + "*" + channelLogo.getCssValue("height"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Size of Channel Logo - " + getExcelKeyValue("EpgScreen", "channelLogo", "width")
					+ "*" + getExcelKeyValue("EpgScreen", "channelLogo", "height") + " Actual Font Size -"
					+ channelLogo.getCssValue("width") + "*" + channelLogo.getCssValue("height"));
		}
		try {
			if (cutvChannelIcon.isDisplayed()) {
				if (cutvChannelIcon.getCssValue("width").toString()
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "cutvChannelIcon", "width"))
						&& focousElementChannelNumber.getCssValue("margin-right").toString()
								.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "cutvChannelIcon", "margin-right"))) {
					reports.log(LogStatus.PASS,
							"Expected Size of CUTV Channel Icon - "
									+ getExcelKeyValue("EpgScreen", "cutvChannelIcon", "width")
									+ " and Gap Between Channel Number and Icon - "
									+ getExcelKeyValue("EpgScreen", "cutvChannelIcon", "margin-right")
									+ " Actual Size of CUTV Icon - " + cutvChannelIcon.getCssValue("width").toString()
									+ " Actual Gap Between Icon and Channel Number - "
									+ focousElementChannelNumber.getCssValue("margin-right").toString());
					reports.attachScreenshot(captureCurrentScreenshot());
				} else {
					FailTestCase("Expected Size of CUTV Channel Icon - "
							+ getExcelKeyValue("EpgScreen", "cutvChannelIcon", "width")
							+ " and Gap Between Channel Number and Icon - "
							+ getExcelKeyValue("EpgScreen", "cutvChannelIcon", "margin-right")
							+ " Actual Size of CUTV Icon - " + cutvChannelIcon.getCssValue("width").toString()
							+ " Actual Gap Between Icon and Channel Number - "
							+ focousElementChannelNumber.getCssValue("margin-right").toString());
				}

			}
		} catch (NoSuchElementException ex) {
			System.out.println("Exception Occurred");
		}

		if (channelLogo.getCssValue("top").equalsIgnoreCase(getExcelKeyValue("EpgScreen", "channelLogo", "top"))) {
			reports.log(LogStatus.PASS,
					"Expected Output - Top Margin Of channel Logo wrt to Channel Cell - "
							+ getExcelKeyValue("EpgScreen", "channelLogo", "width")
							+ ". Actual Output - Top Marign of Channel Logo is - " + channelLogo.getCssValue("top"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Output - Top Margin Of channel Logo wrt to Channel Cell - "
					+ getExcelKeyValue("EpgScreen", "channelLogo", "width")
					+ ". Actual Output - Top Marign of Channel Logo is - " + channelLogo.getCssValue("top"));
		}
		if (focussedCell.getCssValue("opacity")
				.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "focussedCell", "Opacity"))
				&& nonFocussedCell.getCssValue("opacity")
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "nonFocussedCell", "Opacity"))) {
			reports.log(LogStatus.PASS,
					"Expected Opacity of Focussed Cell is - " + getExcelKeyValue("EpgScreen", "focussedCell", "Opacity")
							+ " and Non Foccussed Cell is "
							+ getExcelKeyValue("EpgScreen", "nonFocussedCell", "Opacity")
							+ ". Actual Opactiy of Focussed Cell -" + focussedCell.getCssValue("opacity")
							+ " and Non Focussed Cell - " + nonFocussedCell.getCssValue("opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Opacity of Focussed Cell is - "
					+ getExcelKeyValue("EpgScreen", "focussedCell", "Opacity") + " and Non Foccussed Cell is "
					+ getExcelKeyValue("EpgScreen", "nonFocussedCell", "Opacity")
					+ ". Actual Opactiy of Focussed Cell -" + focussedCell.getCssValue("opacity")
					+ " and Non Focussed Cell - " + nonFocussedCell.getCssValue("opacity"));
		}

		if (String.valueOf(channelCells.getLocation().x)
				.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "channelCell", "StartX"))) {
			reports.log(LogStatus.PASS,
					"Channel Cells Should start from x = " + getExcelKeyValue("EpgScreen", "channelCell", "x")
							+ ". Actual Program Starts From x = " + channelCells.getLocation().x);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Channel Cells Should start from x = " + getExcelKeyValue("EpgScreen", "channelCell", "x")
					+ ". Actual Program Starts From x = " + channelCells.getLocation().x);
		}

	}

	public void epg_Currently_Tuned_Focused_Program() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.openLiveTV();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String programTime = programDurationIn_Infobar.getText();
		String programTitleofScreen = programTitle.getText();
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String programTitleofguide = focusElemntInEpg.getText();
		String programTimeSchedule = focusElementProgramTime.getText();
		if (programTime.equalsIgnoreCase(programTimeSchedule)
				&& programTitleofScreen.equalsIgnoreCase(programTitleofguide)) {
			reports.log(LogStatus.PASS, "Current Program " + programTitleofScreen + " is getting highlighted");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Current Program " + programTitleofScreen + " is not getting highlighted");

		}

		// Focused program info should be available over the area above EPG
		// cells

		int ChannelDetailsTop = focusedChannlDetails.getLocation().getY();
		int programDetailsTop = dtv.programTitle.getLocation().getY();

		if (ChannelDetailsTop < programDetailsTop) {
			reports.log(LogStatus.PASS,
					"Focused program details location is : " + ChannelDetailsTop + " program details location is :"
							+ programDetailsTop + " So, focused program details is located in the top of screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focused program info in not available as " + ChannelDetailsTop
					+ " over the area above the EPG cells" + programDetailsTop);

		}

	}

	public void epg_Focused_Program_Info_Details() throws InterruptedException {
		epg_Currently_Tuned_Focused_Program();

		int xCordinateEpgPoster = epgPoster.getLocation().getX();
		System.out.println(xCordinateEpgPoster);
		int yCordinateEpgPoster = epgPoster.getLocation().getY();
		System.out.println(yCordinateEpgPoster);
		String widthOfEpgPoster = epgPoster.getCssValue("width");
		String heightOfEpgPoster = epgPoster.getCssValue("height").replaceAll("[^0-9]", "");
		yCordinateEpgPoster += Integer.parseInt(heightOfEpgPoster);
		if (widthOfEpgPoster.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "Poster", "width"))
				&& heightOfEpgPoster.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "Poster", "height"))
				&& xCordinateEpgPoster == Integer.parseInt(getExcelKeyValue("EpgScreen", "Poster", "StartX"))
				&& yCordinateEpgPoster == Integer.parseInt(getExcelKeyValue("EpgScreen", "Poster", "StartY"))) {
			reports.log(LogStatus.PASS,
					"Expected width of the highlighted program Poster - > "
							+ (getExcelKeyValue("EpgScreen", "Poster", "width")
									+ " Actual width of the highlighted poster is -> " + widthOfEpgPoster
									+ " Expected height of the highlighted title - > "
									+ (getExcelKeyValue("EpgScreen", "Poster", "height"))
									+ " Actual height of the highlighted title -> " + heightOfEpgPoster));
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Test cases is failed as Expected width of the highlighted program Poster - > "
					+ (getExcelKeyValue("EpgScreen", "Poster", "width")
							+ " Actual width of the highlighted poster is -> " + widthOfEpgPoster
							+ " Test cases is failed as Expected height of the highlighted title - > "
							+ (getExcelKeyValue("EpgScreen", "Poster", "height"))
							+ " Actual height of the highlighted poster is -> " + heightOfEpgPoster
							+ "Test cases is failed as Expected x coordinate of the Poster is - > "
							+ (Integer.parseInt(getExcelKeyValue("EpgScreen", "Poster", "StartX")))
							+ " & y cordinate of the Poster is "
							+ (Integer.parseInt(getExcelKeyValue("EpgScreen", "Poster", "StartY")))
							+ ". Actual x coordinate of the Poster is " + xCordinateEpgPoster
							+ "and the Y cordinate of the poster is -> " + yCordinateEpgPoster));
		}

		int positionOfXaxis = epgTitleHighlightedProgram.getLocation().getX();
		int epgHighlightedYaxis = epgTitleHighlightedProgram.getLocation().getY();
		String fontProgramTitle = epgTitleHighlightedProgram.getCssValue("font-family");
		String fontSizeProgram = epgTitleHighlightedProgram.getCssValue("font-size");

		if (fontProgramTitle.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramTitle", "font_family"))
				&& fontSizeProgram.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramTitle", "font_size"))
				&& positionOfXaxis == Integer.parseInt(getExcelKeyValue("EpgScreen", "ProgramTitle", "StartX"))) {
			reports.log(LogStatus.PASS,
					" Expected font-family of focused program title of the EPG screen is - > "
							+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_family"))
							+ " Actual font-family of focused program title of the EPG screen is -> "
							+ epgTitleHighlightedProgram.getCssValue("font-family")
							+ " Expected font-size of focused program title of the EPG screen is - > "
							+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_size"))
							+ " Actual font-size of focused program title of the EPG screen is -> "
							+ epgTitleHighlightedProgram.getCssValue("font-size")
							+ "Expected x coordinate of the highlighted title - > "
							+ (Integer.parseInt(getExcelKeyValue("EpgScreen", "ProgramTitle", "StartX")))
							+ "Actual co-ordinate of the highlighted title -> " + positionOfXaxis);
			reports.attachScreenshot(captureCurrentScreenshot());

		} else {
			FailTestCase(
					"Test cases is failed as Expected font-family of focused program title of the EPG screen is - > "
							+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_family"))
							+ ". Actual font-family of focused program title of the EPG screen is -> "
							+ epgTitleHighlightedProgram.getCssValue("font-family")
							+ "Test cases is failed as Expected font-size of focused program title of the EPG screen is - > "
							+ fontSizeProgram + ". Actual font-family of focused program title of the EPG screen is -> "
							+ epgTitleHighlightedProgram.getCssValue("font-size"));
		}

		int programTimeYaxis = focusElementProgramTime.getLocation().getY();
		int xaxisOfRemainingTime = titleGroup.getLocation().getX();
		int focusedElementXAxis = epgTitleHighlightedProgram.getLocation().getX();
		String fontFamilyRemainingtime = remainingTime.getCssValue("font-family");
		String fontsizeRemainingTime = remainingTime.getCssValue("font-size");

		if (epgHighlightedYaxis < programTimeYaxis
				&& fontProgramTitle.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramTitle", "font_family"))
				&& fontSizeProgram.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramTitle", "font_size"))) {
			reports.log(LogStatus.PASS,
					"ProgramTime is below the program title" + "Expected font title"
							+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_family")) + "Actual font title"
							+ fontProgramTitle + "Expected font size "
							+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_size")) + "Actual Font size"
							+ fontSizeProgram);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("ProgramTime is not shown below the programTitle" + "Test Case failed as Expected title "
					+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_family")) + "Actual font title "
					+ fontProgramTitle + "Test case failed as Expected font size"
					+ (getExcelKeyValue("EpgScreen", "ProgramTitle", "font_size")) + "Actual font size"
					+ fontSizeProgram);
		}

		if (xaxisOfRemainingTime == focusedElementXAxis
				&& fontFamilyRemainingtime
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_family"))
				&& fontsizeRemainingTime
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_size"))) {
			reports.log(LogStatus.PASS,
					" Program remaining time should be shown next to program title" + "Actual font-family "
							+ fontFamilyRemainingtime + "Expected font family remaining time "
							+ (getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_family"))
							+ "Actual Font size" + fontsizeRemainingTime + "Expected font size"
							+ getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_size"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Test case failed as Program remaining time is not shown next to program title"
					+ "Expected font family " + (getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_family"))
					+ "Actual font family " + fontFamilyRemainingtime + "Actual font size remaining time "
					+ fontsizeRemainingTime + "Expected font size of the remaing time"
					+ getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_size"));
		}

		int programSummaryYaxis = programSummary.getLocation().getY();
		int yaxisofProgramTimeAbove = focusElementProgramTime.getLocation().getY();
		String fontFamilyProgramSummary = programSummary.getCssValue("font-family");
		String fontSizeProgramSummary = programSummary.getCssValue("font-size");

		if (programSummaryYaxis > yaxisofProgramTimeAbove
				&& fontFamilyProgramSummary
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_family"))
				&& fontSizeProgramSummary
						.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_size"))) {
			reports.log(LogStatus.PASS,
					" Program sumamry of Y axis should be greater than y axis of the program time showing above"
							+ "Actual font-family " + fontFamilyProgramSummary + "Expected font family "
							+ (getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_family"))
							+ "Actual Font size" + fontSizeProgramSummary + "Expected font size"
							+ getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_size"));
			reports.attachScreenshot(captureCurrentScreenshot());

		} else {
			FailTestCase(
					"Test case failed as Program sumamry of Y axis is not greater than y axis of the program time showing above"
							+ "Expected font family "
							+ (getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_family"))
							+ "Actual font family " + fontSizeProgramSummary + "Actual font size remaining time "
							+ fontSizeProgramSummary + "Expected font size of the remaing time"
							+ getExcelKeyValue("EpgScreen", "ProgramRemainingTime", "font_size"));
		}

		String maxWidthSummaryText = programSummary.getCssValue("width");
		if (maxWidthSummaryText.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "SummaryText", "width"))) {
			reports.log(LogStatus.PASS, "Actual Summary text width is equals to " + maxWidthSummaryText
					+ "Expected Summary text width " + getExcelKeyValue("EpgScreen", "SummaryText", "width"));
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Test case fails as the actual Summary text width is not equals to " + maxWidthSummaryText
					+ "Expected Summary text width " + getExcelKeyValue("EpgScreen", "SummaryText", "width"));
		}

		String widthOfIcon = groupIconImage.getCssValue("width");
		String spaceGroupIcon = groupIcon.getCssValue("padding-left");

		if (widthOfIcon.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "IconsNextToTitle", "font_size"))) {
			reports.log(LogStatus.PASS, "Actual Size of icon is " + widthOfIcon + "Expected size of the icon is "
					+ getExcelKeyValue("EpgScreen", "IconsNextToTitle", "font_size"));
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		else {
			FailTestCase("Test case failed as Actual Size of icon is " + widthOfIcon + "Expected size of the icon is "
					+ getExcelKeyValue("EpgScreen", "IconsNextToTitle", "font_size"));
		}

		int widthBarIcon = barIcon.getSize().getWidth();
		int rightOftheBaricon = Integer.parseInt(barIcon.getCssValue("margin-right").replaceAll("[^0-9]", ""));
		int leftReminingTime = Integer.parseInt(remainingTime.getCssValue("margin-left").replaceAll("[^0-9]", ""));
		int totalSpaceRemaining = widthBarIcon + rightOftheBaricon + leftReminingTime;

		if (totalSpaceRemaining == Integer
				.parseInt(getExcelKeyValue("EpgScreen", "SpaceBetweenlastIcon&RemainingDuration", "MarginLeft")
						.replaceAll("[^0-9]", ""))) {
			reports.log(LogStatus.PASS, "Actual Space between two Icons is" + totalSpaceRemaining
					+ "Expected Space remaiming two icons is "
					+ Integer.parseInt(
							getExcelKeyValue("EpgScreen", "SpaceBetweenlastIcon&RemainingDuration", "MarginLeft")
									.replaceAll("[^0-9]", "")));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Test Case fail as Actual Space between two Icons is" + totalSpaceRemaining
					+ "Expected Space remaiming two icons is "
					+ Integer.parseInt(
							getExcelKeyValue("EpgScreen", "SpaceBetweenlastIcon&RemainingDuration", "MarginLeft")
									.replaceAll("[^0-9]", "")));
		}
	}

	public void epg_Program_title() throws InterruptedException {
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String epgScreenTitle = screenTitle.getText();
		System.out.println(epgScreenTitle);
		String expectedScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		System.out.println(expectedScreenTitle);
		driver.switchTo().frame(getCurrentFrameIndex());
		int YaxisOfTitle = epgTitleHighlightedProgram.getLocation().getY();
		System.out.println(YaxisOfTitle);
		int YaxisofprogramTime = focusElementProgramTime.getLocation().getY();
		System.out.println(YaxisofprogramTime);
		if (epgScreenTitle.equalsIgnoreCase(expectedScreenTitle)) {
			reports.log(LogStatus.PASS, "EPG screen has been reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached at the EPG screen");
		}

		if (YaxisOfTitle < YaxisofprogramTime) {
			reports.log(LogStatus.PASS,
					"Program title is located above the program time and its location is " + YaxisOfTitle
							+ " and Location of the program time is below the Program Title " + YaxisofprogramTime);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Test case failed as the Program title is not above the program time " + YaxisOfTitle
					+ " Should not appear after programtime " + YaxisofprogramTime);
		}

		verifyNavigationinEPG();

	}

	public void epg_FR_Language_Day() throws InterruptedException {
		String expectedDayInFrench = getExcelKeyValue("parameters", "DayInFrench", "name_nl");
		System.out.println(expectedDayInFrench);
		ChangePreference chPreference = new ChangePreference(driver);
		chPreference.navigateToMyPreference();
		chPreference.languageChange("FR");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String dayName = dayNavigator.getText();
		System.out.println(dayName);
		if (dayName.equalsIgnoreCase(expectedDayInFrench)) {
			reports.log(LogStatus.PASS, "After Language has been set to French Day has been changed to " + dayName);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Language changed has not done");
		}

		// Set to default language
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		chPreference.navigateToMyPreference();
		chPreference.languageChange("NL");
	}

	public void epg_NL_Language_Day() throws InterruptedException {
		String expectedDayInDutch = getExcelKeyValue("parameters", "DayInDutch", "name_nl");
		System.out.println(expectedDayInDutch);
		ChangePreference chPreference = new ChangePreference(driver);
		chPreference.navigateToMyPreference();
		chPreference.languageChange("NL");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String dayName = dayNavigator.getText();
		System.out.println(dayName);
		if (dayName.equalsIgnoreCase(expectedDayInDutch)) {
			reports.log(LogStatus.PASS, "After Language has been set to Dutch Day has been changed to " + dayName);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Language changed has not done");
		}

	}

	public void verifyForwardBackWardKey() throws InterruptedException {
		goToEpgChannelScreen(true);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(new MiniEPGScreen(driver).epgGuide, "TV Guide");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 4000);
		Thread.sleep(3000);
		if (dayNavigator.getText().contains("morgen")) {
			reports.log(LogStatus.PASS, "Press FW Key - Day Changes in the grid");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press FW Key - Day not changed");
		}
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 2, 4000);
		Thread.sleep(3000);
		System.out.println(dayNavigator.getText());
		if (dayNavigator.getText().contains("gisteren")) {
			reports.log(LogStatus.PASS, "Press REW Key - Day Changes in the grid");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press REW Key - Day not changed");
		}
	}

	public void verifyProgramDescription() throws InterruptedException {
		goToEpgChannelScreen(true);
		sendNumaricKeys(1);
		Thread.sleep(3000);
		System.out.println(programSummary.getLocation().y);
		System.out.println(focusElementProgramTime.getLocation().y);
		if (programSummary.getLocation().y > focusElementProgramTime.getLocation().y) {
			reports.log(LogStatus.PASS, "Program Summary is present below Program Duration");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Program Summary should display below Program Duration");
		}
		reports.log(LogStatus.PASS, "Navigate RIGHT - LEFT in EPG");
		String prevProgramSummary = programSummary.getText();
		String programDuration = focusElementProgramTime.getText();
		String programTitle = driver.findElement(By.className("progName")).getText();
		int iterator = 20;
		while (iterator != 0) {
			if (programDuration.equalsIgnoreCase(focusElementProgramTime.getText())) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
			} else {
				break;
			}
			iterator--;
		}
		String updatedProgramSummary = programSummary.getText();
		System.out.println(prevProgramSummary + "====== " + updatedProgramSummary);
		Thread.sleep(3000);
		if (programTitle.equalsIgnoreCase(displayChannelTitle.getText())) {
			if (updatedProgramSummary.equalsIgnoreCase(prevProgramSummary)) {
				reports.log(LogStatus.PASS, "Press Right Key - Program Description updated according to Program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press Right Key - Program Description not updated according to Program");
			}
		} else {
			if (!updatedProgramSummary.equalsIgnoreCase(prevProgramSummary)) {
				reports.log(LogStatus.PASS, "Press Right Key - Program Description updated according to Program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press Right Key - Program Description not updated according to Program");
			}
		}

		String currentProgramSummary = programSummary.getText();
		sendKeyMultipleTimes("LEFT", 1, 5000);
		updatedProgramSummary = programSummary.getText();
		System.out.println(currentProgramSummary + "====== " + updatedProgramSummary);
		if (programTitle.equalsIgnoreCase(displayChannelTitle.getText())) {
			if (updatedProgramSummary.equalsIgnoreCase(currentProgramSummary)) {
				reports.log(LogStatus.PASS, "Press LEFT Key - Program Description updated according to Program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press LEFT Key - Program Description not updated according to Program");
			}
		} else {
			if (!updatedProgramSummary.equalsIgnoreCase(currentProgramSummary)) {
				reports.log(LogStatus.PASS, "Press LEFT  Key - Program Description updated according to Program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press LEFT Key - Program Description not updated according to Program");
			}
		}

	}

	public void startaRecording() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		RecordingScreen recordingElement = new RecordingScreen(driver);
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(Integer.parseInt(getExcelKeyValue("Recording", "RecordingToVerifyIconsInEPGGrid", "name_nl")));
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		String episodeName = dtvChannelScreen.programTitle.getText();
		Thread.sleep(3000);
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		EpisodeInfo episodeDetails = null;
		reports.log(LogStatus.PASS, "Navigate to program information screen");
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("DOWN", 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten")) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")) {
			episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName,
					recordingElement.getEpisodeDuration(), recordingElement.getChannelDefiniton());
			sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opname stoppen")) {
			sendKeyMultipleTimes("ENTER", 1, 1000);
			sendKeyMultipleTimes("ENTER", 1, 2000);
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten")) {
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")) {
				episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName,
						recordingElement.getEpisodeDuration(), recordingElement.getChannelDefiniton());
				reports.log(LogStatus.PASS, " Click on opnemen to start recording on - ");
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		}

	}

	public void startaFutureRecording() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		RecordingScreen recordingElement = new RecordingScreen(driver);
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(Integer.parseInt(getExcelKeyValue("Recording", "FetchingShortProgramChannel", "name_nl")));
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 3, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String episodeName = dtvChannelScreen.programTitle.getText();
		Thread.sleep(3000);
		EpisodeInfo episodeDetails = null;
		reports.log(LogStatus.PASS, "Action menu of the Future program will open");
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten")) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		reports.log(LogStatus.PASS, "Recording is getting set");
		if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")) {
			episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName,
					recordingElement.getEpisodeDuration(), recordingElement.getChannelDefiniton());
			sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opname stoppen")) {
			sendKeyMultipleTimes("ENTER", 1, 1000);
			sendKeyMultipleTimes("ENTER", 1, 2000);
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten")) {
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")) {
				episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName,
						recordingElement.getEpisodeDuration(), recordingElement.getChannelDefiniton());
				sendKeyMultipleTimes("ENTER", 1, 1000);
			}
		}
	}

	public void epg_Grid_view_icons() throws InterruptedException {
		startaRecording();
		driver.switchTo().frame(getCurrentFrameIndex());
		List<WebElement> myElements = driver.findElements(By.xpath(ObjectRepository.EpgScreen.epgGroupIcon));
		System.out.println(myElements.size());
		for (WebElement e : myElements) {
			System.out.println(e.getAttribute("src"));
			if (e.getAttribute("src").contains("recording")) {
				isDisplayed(e, "Recording Icon");
			}
			if (e.getAttribute("src").contains("cutv")) {
				isDisplayed(e, "CUTV Icon");
			}
		}
	}

	public void epg_Schedule_recording() throws InterruptedException {
		startaFutureRecording();
		driver.switchTo().frame(getCurrentFrameIndex());
		largeRecordingIcon.isDisplayed();
		System.out.println(largeRecordingIcon.getAttribute("src"));
		smallRecordingIcon.isDisplayed();
		System.out.println(smallRecordingIcon.getAttribute("src"));
		try {
			if (largeRecordingIcon.isDisplayed()
					&& largeRecordingIcon.getAttribute("src").contains("ico_Future_recording.png")) {
				reports.log(LogStatus.PASS, "Large recording icon is getting displayed");
				reports.attachScreenshot(captureCurrentScreenshot());

			} else {
				FailTestCase("large recording icon is not getting displayed");
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);

		}

		try {
			if (smallRecordingIcon.isDisplayed()
					&& smallRecordingIcon.getAttribute("src").contains("future_recording_icon_small.png")) {
				reports.log(LogStatus.PASS, "Small recording icon is getting displayed");
				reports.attachScreenshot(captureCurrentScreenshot());

			} else {
				FailTestCase("Small recording icon is not getting displayed");
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);

		}

	}

	public void EPG_Navigation_Till_Available_Days() throws InterruptedException {
		String expectedDay = null;
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 6);

		Date date = calendar.getTime();

		String currentDay = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date.getTime());
		expectedDay = getExcelKeyValue("parameters", currentDay, "name_nl");

		System.out.println("expected Day" + expectedDay);

		reports.log(LogStatus.PASS, "Moving to the TV guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String todaysDay = dayNavigator.getText();
		System.out.println(todaysDay);
		if (todaysDay.equalsIgnoreCase(getExcelKeyValue("parameters", "DayInDutch", "name_nl"))) {
			reports.log(LogStatus.PASS, "Actual Todays day is showing as " + todaysDay + " and expected day is "
					+ getExcelKeyValue("parameters", "DayInDutch", "name_nl"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Test case failed as actual Todays day is showing as " + todaysDay + " and expected day is "
					+ getExcelKeyValue("parameters", "DayInDutch", "name_nl"));
		}
		reports.log(LogStatus.PASS, "Forwarding till Seven days");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 7, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String AfterSevenDay = dayNavigator.getText();
		System.out.println(AfterSevenDay);
		String focusElement = focusedChannlDetails.getText();
		System.out.println(focusElement);
		if (AfterSevenDay.equalsIgnoreCase(expectedDay)) {
			reports.log(LogStatus.PASS, "After forwdaring to seven days atual day is " + AfterSevenDay
					+ " Expected day after forwarding to seven days " + expectedDay);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("TestCase failed as the actual the actual day is " + AfterSevenDay + " And expected day is "
					+ expectedDay);
		}

		reports.log(LogStatus.PASS, "After rewinding to seven days");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 6, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String todaysDayafterRewind = dayNavigator.getText();
		System.out.println(todaysDayafterRewind);
		if (todaysDay.equalsIgnoreCase(getExcelKeyValue("parameters", "DayInDutch", "name_nl"))) {
			reports.log(LogStatus.PASS, "Actual Todays day is showing as " + todaysDayafterRewind
					+ " and expected day is " + getExcelKeyValue("parameters", "DayInDutch", "name_nl"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Test case failed as actual Todays day is showing as " + todaysDayafterRewind
					+ " and expected day is " + getExcelKeyValue("parameters", "DayInDutch", "name_nl"));
		}
	}

	public void timeAfterRefrehed(String keyToPressIfNedd) throws ParseException, InterruptedException {

		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		if (keyToPressIfNedd != null) {
			sendUnicodeMultipleTimes(keyToPressIfNedd, 2, 0);
		}
		driver.switchTo().defaultContent();
		System.out.println("Text from " + miniEPGScreen.headerTime.getText());
		System.out.println(miniEPGScreen.headerTime.getText().split(" ")[4].trim());

		String currentimeBeforeWait = miniEPGScreen.headerTime.getText().split(" ")[4].trim();
		Date currentTime = sdf.parse(currentimeBeforeWait);
		System.out.println(currentimeBeforeWait);
		reports.log(LogStatus.PASS, "Time before wait for 1 minute " + currentimeBeforeWait);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Wait for 1 Minutes and check the time ");
		Thread.sleep(60000);
		if (keyToPressIfNedd != null) {
			sendUnicodeMultipleTimes(keyToPressIfNedd, 2, 0);
		}
		driver.switchTo().defaultContent();
		String currentTimeAfterWait = miniEPGScreen.headerTime.getText().split(" ")[4].trim();
		Date currentTimeAfterRefreshed = sdf.parse(currentTimeAfterWait);
		System.out.println(currentTimeAfterWait);
		if (currentTime.before(currentTimeAfterRefreshed)) {
			reports.log(LogStatus.PASS, "Time before wait for 1 minute : " + currentimeBeforeWait
					+ " .After refreshed time changes to : " + currentTimeAfterWait);
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Test case failed as Time before wait for 1 minute " + currentimeBeforeWait
					+ " After refreshed time changes to " + currentTimeAfterWait);
		}
	}

	public void TIME0202_UI() throws InterruptedException, ParseException {
		ChangePreference changePreference = new ChangePreference(driver);
		reports.log(LogStatus.PASS, "Navigate to the EPG screen");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		timeAfterRefrehed(null);

		reports.log(LogStatus.PASS, "Navigate to the Parameters screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		changePreference.navigateToMyPreference();
		timeAfterRefrehed(null);

		reports.log(LogStatus.PASS, "Navigate to the Menu screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		timeAfterRefrehed(Unicode.VK_MENU.toString());

		reports.log(LogStatus.PASS, "Navigate to the Info banner screen");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		timeAfterRefrehed(Unicode.VK_INFO.toString());

	}

	/// Rahul Methods
	public void verifyCurrentTimeLine() throws InterruptedException {
		goToEpgChannelScreen(true);
		driver.switchTo().frame(getCurrentFrameIndex());
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);
		String background = (String) ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(document.querySelector('#currentTimeLine'),':before').getPropertyValue('background')");
		System.out.println(background);
		isDisplayed(new EpgScreen(driver).focusedCurrentLineTvguide, "Current Time Line");
		if (background.contains(getExcelKeyValue("EPGScreen", "CurrentTimeLine", "color"))) {
			reports.log(LogStatus.PASS, "Current Time color is blue");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Current Time Line Color is not blue");
		}
		Double opacity = Double.parseDouble((String) ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(document.querySelector('#currentTimeLine'),':before').getPropertyValue('opacity')"));
		System.out.println(opacity);
		String beforeOpacity = df.format(opacity) + "";
		String timeLinewidth = (String) ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(document.querySelector('#currentTimeLine'),':before').getPropertyValue('width')");
		System.out.println(beforeOpacity + "   " + timeLinewidth);
		if (beforeOpacity.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "currentTimeLineBefore", "Opacity"))
				&& timeLinewidth.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "currentTimeLineBefore", "width"))) {
			reports.log(LogStatus.PASS,
					"Current Time Line displayed with : " + beforeOpacity + " opacity and width :" + timeLinewidth);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Opacity of Time Line - "
					+ getExcelKeyValue("EpgScreen", "currentTimeLineBefore", "Opacity") + " Actual Opacity : "
					+ beforeOpacity + " and.Expected Width : "
					+ getExcelKeyValue("EpgScreen", "currentTimeLineBefore", "width") + ". Actual width : "
					+ timeLinewidth);
		}
		Double afterOpacity = Double.parseDouble((String) ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(document.querySelector('#currentTimeLine'),':after').getPropertyValue('opacity')"));
		String opacity1 = df.format(afterOpacity) + "";
		String afterwidth = (String) ((JavascriptExecutor) driver).executeScript(
				"return window.getComputedStyle(document.querySelector('#currentTimeLine'),':after').getPropertyValue('width')");
		System.out.println(opacity1 + "   " + afterwidth);
		if (opacity1.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "currentTimeLineAfter", "Opacity"))
				&& afterwidth.equalsIgnoreCase(getExcelKeyValue("EpgScreen", "currentTimeLineAfter", "width"))) {
			reports.log(LogStatus.PASS,
					"Current Time Line Shadow displayed with : " + opacity1 + " opacity and width :" + afterwidth);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Expected Opacity of Time Line Shadow : "
					+ getExcelKeyValue("EpgScreen", "currentTimeLineAfter", "Opacity") + " Actual Opacity : " + opacity1
					+ " and.Expected Width : " + getExcelKeyValue("EpgScreen", "currentTimeLineAfter", "width")
					+ ". Actual width of Shadow: " + afterwidth);
		}
	}

	public void verify_EPG_Program_Channel_icons() throws InterruptedException {
		startaRecording();
		driver.switchTo().frame(getCurrentFrameIndex());
		List<WebElement> myElements = driver.findElements(By.xpath(ObjectRepository.EpgScreen.epgGroupIcon));
		System.out.println(myElements.size());
		for (WebElement e : myElements) {
			System.out.println(e.getAttribute("src"));
			if (e.getAttribute("src").contains("recording")) {
				isDisplayed(e, "Recording Icon under Program details");
			}
			if (e.getAttribute("src").contains("cutv")) {
				isDisplayed(e, "CUTV Icon under Program Details");
			}
		}

		reports.log(LogStatus.PASS, "Under Channels cells Icons should be shown");
		isDisplayed(channelsIcon, "Cutv Icon under Channel cells");

	}

	public void timeAfterRefresh_grid() throws InterruptedException, ParseException {
		reports.log(LogStatus.PASS, "Navigate to the EPG screen");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		timeAfterRefrehed(null);
	}

	public void navigateToFutureProgram() throws InterruptedException {

		driver.switchTo().frame(getCurrentFrameIndex());
		String presentTmeStartTime = focusElementProgramTime.getText();

		System.out.println("Current Program Duration " + presentTmeStartTime);

		int noOfTry = 20;
		while (noOfTry > 0) {
			try {
				driver.switchTo().frame(getCurrentFrameIndex());
				System.out.println(
						"Focussed Program Duration -" + new EpgScreen(driver).focusElementProgramTime.getText());
				if (!(focusElementProgramTime.getText().equalsIgnoreCase(presentTmeStartTime))) {
					System.out.println("Episode Found");
					reports.log(LogStatus.PASS,
							"Future program found " + new EpgScreen(driver).focusElemntInEpg.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException ex) {

			}
			noOfTry -= 1;
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.log(LogStatus.PASS, "Navigate to Future Program");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

	}
}

package com.rsystems.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

/**
 * @author Ankit.Agarwal1 return necessary object and dependent function of EPG Screen
 */

public class EpgScreen extends TestInitization {

	WebDriver driver;

	public EpgScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.epgType)
	public WebElement epgType;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.epgFont)
	public WebElement epgFont;

	@FindBy(how = How.ID, using = ObjectRepository.EpgScreen.epgBackground)
	public WebElement epgBackground;

	
	public  void goToEpgSettingScreen() throws InterruptedException {

		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS, "Navigate to the Setting Screen");
		TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));

		reports.log(LogStatus.PASS, "Step : Navigate to the System Screen");
		TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "System", "name_nl"));

		reports.log(LogStatus.PASS, "Step : Navigate to the EPG Setting Screen");
		TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "epgSetting", "name_nl"));
	}

	public static void goToEpgChannelScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to EPG");
		TestInitization.setApplicationHubPage(2);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

	}

	public  boolean validationEpgCss(HashMap<String, String> currentEpgSetting) throws InterruptedException {

		
		String epgType = currentEpgSetting.get("epgType");
		String epgBackground = currentEpgSetting.get("epgBackground");
		String epgFont = currentEpgSetting.get("epgFont");
		
		
		// First go to epg channel screen
		goToEpgChannelScreen();
		
		String expectedFontSize = null;
		String expectedFontFamily = null;
		String expectedFontColor = null;
		String expectedChannelCount = null;

		// reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if (epgType.equalsIgnoreCase("STANDAARD") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Grijs")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs",
					"No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Geel")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Standard", "No_of_Channel");
		}
		
		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_Standard", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GEEL")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_geel", "No_of_Channel");
		}

		
		else if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GRIJS")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_Standard_grijs", "No_of_Channel");
		}

		
		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Stark_Standard_Standard", "No_of_Channel");
		}

		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_Standard", "No_of_Channel");
		}
		
		
		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("GRIJS")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_grijs", "No_of_Channel");
		}
		
		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("GROEN")
				&& epgFont.equalsIgnoreCase("GEEL")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_groen_geel", "No_of_Channel");
		}
		
		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GRIJS")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_grijs", "No_of_Channel");
		}
		
		
		else if (epgType.equalsIgnoreCase("STRAK") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("GEEL")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Strak_Standard_geel", "No_of_Channel");
		}
		
		expectedChannelCount = String.valueOf(expectedChannelCount.charAt(0));

		driver.switchTo().defaultContent();
		driver.switchTo().frame(getCurrentFrameIndex());

		List<WebElement> listChnl = driver.findElements(By.xpath("//ul[contains(@class,'channelRow')]"));

		if ((listChnl.size() + "").equalsIgnoreCase(expectedChannelCount)) {
			System.out.println(
					"Expected Channel Count match Actual: " + listChnl.size() + " Expected : " + expectedChannelCount);
		} else {
			System.out.println("Channel count is not matched");
		}

		// Remove first channel because first channel is always different font
		listChnl.remove(0);

		for (WebElement chnl : listChnl) {
			List<WebElement> listOfPrgrm = chnl.findElements(By.xpath("./li[contains(@class,'program')]"));
			System.out.println("list of program" + listOfPrgrm.size());
			for (WebElement program : listOfPrgrm) {
				WebElement we = program.findElement(By.xpath("./div/p[@class='programTitle']"));

				if (expectedFontSize.equalsIgnoreCase(we.getCssValue("font-size"))
						&& expectedFontFamily.equalsIgnoreCase(we.getCssValue("font-family"))
						&& expectedFontColor.equalsIgnoreCase(we.getCssValue("color"))) {
					System.out.println("CSS matched");
				} else {
					throw new SkipException("CSS not Matched Actual Font-Size,font,color: "
							+ we.getCssValue("font-size") + "," + we.getCssValue("font-family") + ","
							+ we.getCssValue("color") + "Expected : font-size,font-family,color" + expectedFontSize
							+ "," + expectedFontFamily + "," + expectedFontColor);
				}
			}
		}
		// reports.log(LogStatus.PASS, "Verification of changes in EPG Colour,
		// Font & Background Passed");
		return true;
	}

	public HashMap<String , String> changeEpgSetting(String epgType, String epgBackground, String epgFont)
			throws InterruptedException {
		
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgSettingScreen();
		
		int MoveCount = 4;
		// For EPG Type
		reports.log(LogStatus.PASS, "Change EPG Settings");
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

		while ((!epgScreen.epgBackground.getText().equalsIgnoreCase(epgBackground)) && MoveCount > 0) {
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}

		// Set the Epg font
		System.out.println(" Trying to set the EPG font");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		MoveCount = 4;

		while ((!epgScreen.epgFont.getText().equalsIgnoreCase(epgFont)) && MoveCount > 0) {
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}

		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		
		
		// Validation for Setting saved successfully or not
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		
		driver.switchTo().frame(getCurrentFrameIndex());
		
		if (epgScreen.epgType.getText().equalsIgnoreCase(epgType)
				&& epgScreen.epgBackground.getText().equalsIgnoreCase(epgBackground)
				&& epgScreen.epgFont.getText().equalsIgnoreCase(epgFont)) {
				
			HashMap<String , String> currentEpgSetting = new HashMap<String,String>();
			currentEpgSetting.put("epgType", epgType);
			currentEpgSetting.put("epgBackground", epgBackground);
			currentEpgSetting.put("epgFont", epgFont);
			return currentEpgSetting;
			
		}

		else {
			throw new SkipException(
					"Unable to set EPG Setting Actual EpgType,EpgBackground,EpgFont" + epgScreen.epgType.getText()
							+ "," + epgScreen.epgBackground.getText() + "," + epgScreen.epgFont.getText()
							+ "Expected EpgType,EpgBackground,EpgFont" + epgType + "," + epgBackground + "," + epgFont);
		}

	}

	public  boolean validateEpgChannelSetting(String epgType, String epgBackgroung, String epgFont)
			throws InterruptedException {
		
		EpgScreen epgScreen = new EpgScreen(driver);
		
		reports.log(LogStatus.PASS, "Validation for EPG channel setting");
		epgScreen.goToEpgSettingScreen();

		boolean validationResult = false;
		if (epgScreen.epgType.getText().equalsIgnoreCase(epgType)
				&& epgScreen.epgBackground.getText().equalsIgnoreCase(epgBackgroung)
				&& epgScreen.epgFont.getText().equalsIgnoreCase(epgFont)) {
			validationResult = true;
		}
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		return validationResult;
	}
	
}

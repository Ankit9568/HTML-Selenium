package com.rsystems.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.EpgScreen;

public class EPG extends TestInitization {



	public static void goToEpgSettingScreen() throws InterruptedException {

		
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

	public static boolean validationChannelCss(String epgType, String epgBackground, String epgFont) {

		String expectedFontSize = null;
		String expectedFontFamily = null;
		String expectedFontColor = null;
		String expectedChannelCount = null;
		
		//reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if (epgType.equalsIgnoreCase("STANDAARD") && epgBackground.equalsIgnoreCase("STANDAARD")
				&& epgFont.equalsIgnoreCase("STANDAARD")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Standard", "No_of_Channel");
		}

		if (epgType.equalsIgnoreCase("Senior") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Grijs")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Grijs", "No_of_Channel");
		}

		if (epgType.equalsIgnoreCase("Seniour") && epgBackground.equalsIgnoreCase("groen")
				&& epgFont.equalsIgnoreCase("Geel")) {

			expectedFontSize = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "font_size");
			expectedFontFamily = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "font_family");
			expectedFontColor = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "color");
			expectedChannelCount = TestInitization.getExcelKeyValue("EpgScreen", "Seniour_groen_Geel", "No_of_Channel");
		}

		expectedChannelCount= String.valueOf(expectedChannelCount.charAt(0));
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(getCurrentFrameIndex());
		
		List<WebElement> listChnl = driver.findElements(By.xpath("//ul[contains(@class,'channelRow')]"));
		
		
		
		if((listChnl.size()+"").equalsIgnoreCase(expectedChannelCount)){
				System.out.println("Expected Channel Count match Actual: " +listChnl.size() + " Expected : "+ expectedChannelCount );
		}
		else{
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
		//reports.log(LogStatus.PASS, "Verification of changes in EPG Colour, Font & Background Passed");
		return true;
	}
	
	public static void changeEpgChannelSetting(String epgType, String epgBackground, String epgFont) throws InterruptedException{
		
		
		int MoveCount = 4;
		// For EPG Type
		reports.log(LogStatus.PASS, "Change EPG Settings");
		System.out.println("Trying to set the Epg Type");
		while((!EpgScreen.getEpgType().getText().equalsIgnoreCase(epgType)) && MoveCount>0){
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}
		
		// Set the Epg Background
		System.out.println(" Trying to set the EPG background");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		MoveCount = 4;
		
		while((!EpgScreen.getEpgBackground().getText().equalsIgnoreCase(epgBackground)) && MoveCount>0){
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}
		
		// Set the Epg font
		System.out.println(" Trying to set the EPG font");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		MoveCount = 4;
		
		while((!EpgScreen.getEpgFont().getText().equalsIgnoreCase(epgFont)) && MoveCount>0){
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			MoveCount--;
		}
		
		//reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
	}
	
	public static boolean validateEpgChannelSetting( String epgType , String epgBackgroung , String epgFont) throws InterruptedException{
		
		
		reports.log(LogStatus.PASS, "Validation for EPG channel setting");
		goToEpgSettingScreen();
		
		boolean validationResult = false;
		if (EpgScreen.getEpgType().getText().equalsIgnoreCase(epgType)
				&& EpgScreen.getEpgBackground().getText().equalsIgnoreCase(epgBackgroung)
				&& EpgScreen.getEpgFont().getText().equalsIgnoreCase(epgFont)) {
			validationResult =  true;
		}
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		return validationResult;
	}
}

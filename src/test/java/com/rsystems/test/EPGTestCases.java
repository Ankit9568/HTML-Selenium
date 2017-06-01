package com.rsystems.test;

import java.util.HashMap;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.EpgScreen;
import com.rsystems.utils.TestInitization;



public class EPGTestCases extends TestInitization {

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STANDAARD"
	 * Epg background = "STANDAARD"
	 * Epg Font = "STANDAARD" 
	 * 
	 */	
	@Test
	public void standardEPG_Validation() throws InterruptedException {
		
		
		
		// check font is standard on EPf Setting Screen
		EpgScreen epgScreen = new EpgScreen(driver);
		
		HashMap<String, String> defaultSetting = new HashMap<String, String>();
		defaultSetting.put("epgType", "STANDAARD");
		defaultSetting.put("epgBackground", "STANDAARD");
		defaultSetting.put("epgFont", "STANDAARD");

		
		if (epgScreen.validationEpgCss(defaultSetting)) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");

		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		
		
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "SENIOR"
	 * Epg background = "GROEN"
	 * Epg Font = "GRIJS" 
	 * 
	 */
	@Test
	public void seniorGreenGrayEPG_Validation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "SENIOR"
	 * Epg background = "GROEN"
	 * Epg Font = "STANDAARD" 
	 * 
	 */

	@Test
	public  void seniorGreenStandardEPG_Validation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "SENIOR"
	 * Epg background = "GROEN"
	 * Epg Font = "GEEL" 
	 * 
	 */
	
	@Test
	public  void seniorGreenYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "SENIOR"
	 * Epg background = "STANDAARD"
	 * Epg Font = "STANDAARD" 
	 * 
	 */
	@Test
	public  void seniorStandardStandardEpgValidation() throws InterruptedException {

		// change EPG Screen to Seniour_groen_Grijs and validation
		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "SENIOR"
	 * Epg background = "STANDAARD"
	 * Epg Font = "GEEL" 
	 * 
	 */

	@Test
	public  void seniorStandardYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "SENIOR"
	 * Epg background = "STANDAARD"
	 * Epg Font = "GRIJS" 
	 * 
	 */
	@Test
	public  void seniorStandardGrayEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STRAK"
	 * Epg background = "STANDAARD"
	 * Epg Font = "STANDAARD" 
	 * 
	 */
	
	@Test
	public  void strakStandardStandardEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STRAK"
	 * Epg background = "GROEN"
	 * Epg Font = "STANDAARD" 
	 * 
	 */
	@Test
	public  void strakGreenStandardEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "GROEN", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STRAK"
	 * Epg background = "GROEN"
	 * Epg Font = "GRIJS" 
	 * 
	 */
	@Test
	public  void strakGreenGrayEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "GROEN", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}
	
	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STRAK"
	 * Epg background = "GROEN"
	 * Epg Font = "GEEL" 
	 * 
	 */
	@Test
	public  void strakGreenYellowEpgValidation() throws InterruptedException {

		
		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "GROEN", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STRAK"
	 * Epg background = "STANDAARD"
	 * Epg Font = "GRIJS" 
	 * 
	 */
	@Test
	public  void strakStandardGrayEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * @throws InterruptedException
	 * Test case validate the CSS When EPF Setting is 
	 * Epg Type = "STRAK"
	 * Epg background = "STANDAARD"
	 * Epg Font = "GEEL" 
	 * 
	 */
	@Test
	public  void strakStandardYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}
}

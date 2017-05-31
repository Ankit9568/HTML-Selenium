package com.rsystems.test;

import java.util.HashMap;

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

		
		if (epgScreen.validationChannelCss(defaultSetting)) {
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
	public void seniorEPG_Validation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("SENIOR", "GROEN", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void seniorGroenStandardEPG_Validation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("SENIOR", "GROEN", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void seniorGroenGeelEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("SENIOR", "GROEN", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("SENIOR", "STANDAARD", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void seniorStandardGeelEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("SENIOR", "STANDAARD", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void seniorStandardGrijsEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("SENIOR", "STANDAARD", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("STRAK", "STANDAARD", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void strakGroenStandardEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("STRAK", "GROEN", "STANDAARD"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void strakGroenGrijsEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("STRAK", "GROEN", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void strakGroenGeelEpgValidation() throws InterruptedException {

		
		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("STRAK", "GROEN", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void strakStandardGrijsEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("STRAK", "STANDAARD", "GRIJS"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
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
	public  void strakStandardGeelEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationChannelCss(epgScreen.changeEpgChannelSetting("STRAK", "STANDAARD", "GEEL"))) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}
}

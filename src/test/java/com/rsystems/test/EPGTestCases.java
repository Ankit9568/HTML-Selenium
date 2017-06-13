package com.rsystems.test;

import java.util.HashMap;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.EpgScreen;
import com.rsystems.utils.TestInitization;

public class EPGTestCases extends TestInitization {

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STANDAARD" Epg background = "STANDAARD" Epg Font =
	 *             "STANDAARD"
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

		if (epgScreen.validationEpgCss(defaultSetting, false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void seniorGreenGrayEPG_Validation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GRIJS"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "STANDAARD"
	 * 
	 */

	@Test
	public void seniorGreenStandardEPG_Validation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "STANDAARD"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "GEEL"
	 * 
	 */

	@Test
	public void seniorGreenYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GEEL"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "STANDAARD" Epg Font = "STANDAARD"
	 * 
	 */
	@Test
	public void seniorStandardStandardEpgValidation() throws InterruptedException {

		// change EPG Screen to Seniour_groen_Grijs and validation
		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "STANDAARD"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "STANDAARD" Epg Font = "GEEL"
	 * 
	 */

	@Test
	public void seniorStandardYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "GEEL"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "STANDAARD" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void seniorStandardGrayEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "GRIJS"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "STANDAARD" Epg Font = "STANDAARD"
	 * 
	 */

	@Test
	public void strakStandardStandardEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "STANDAARD"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "STANDAARD"
	 * 
	 */
	@Test
	public void strakGreenStandardEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "GROEN", "STANDAARD"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void strakGreenGrayEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "GROEN", "GRIJS"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "GEEL"
	 * 
	 */
	@Test
	public void strakGreenYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "GROEN", "GEEL"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "STANDAARD" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void strakStandardGrayEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "GRIJS"), false)) {
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
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "STANDAARD" Epg Font = "GEEL"
	 * 
	 */
	@Test
	public void strakStandardYellowEpgValidation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// change EPG Screen to Seniour_groen_Grijs and validation
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "GEEL"), false)) {
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

	@Test
	public void validateDefaultEpgSetting() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);

		if (epgScreen.validateEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD")) {
			reports.log(LogStatus.PASS, "Verification of default Epg setting successfully passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of default Epg setting successfully passed");
		}

		else {
			reports.log(LogStatus.FAIL, "Verification of default Epg setting failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of default Epg setting successfully passed");
		}

	}

	@Test
	public void tc_epg_001_epg_setting_UI_NL() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgSettingScreen();
		// Validation for epg type
		String optionarrForEpgType[] = { "STANDAARD", "SENIOR", "STRAK" };
		epgScreen.verifyOptionInEpg(optionarrForEpgType, epgScreen.epgType);

		sendKeyMultipleTimes("DOWN", 1, 1000);
		// Validation for background
		String optionarrForbackground[] = { "STANDAARD", "GROEN" };
		epgScreen.verifyOptionInEpg(optionarrForbackground, epgScreen.epgBackground);

		sendKeyMultipleTimes("DOWN", 1, 1000);
		// validation for font color
		String optionarrForFont[] = { "STANDAARD", "GRIJS", "GEEL" };
		epgScreen.verifyOptionInEpg(optionarrForFont, epgScreen.epgFont);

		// Verification for cancle button
		epgScreen.cancleBtnExist();

		// Verification for confirm button
		epgScreen.confirmBtnExist();

	}

	@Test
	public void tc_epg_003_epg_confirmation_setting() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GEEL"), true)) {
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

	@Test
	public void tc_epg_004_epg_cancel_setting() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.shuffleEpgSetting("SENIOR", "GROEN", "GEEL");

		if (!epgScreen.validateEpgChannelSetting("SENIOR", "GROEN", "GEEL")) {
			reports.log(LogStatus.PASS, "Epg setting not saved");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Epg setting not saved");
		} else {
			reports.log(LogStatus.FAIL, "EPG setting saved");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("EPG setting saved");
		}
		// Back EPG setting to Standard
		epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
	}

	/**
	 * TC_ID = epg_006
	 * 
	 * @throws InterruptedException
	 */

	@Test
	public void tc_epg_006_epg_scenior_default() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "STANDAARD"), true)) {
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

	@Test
	public void tc_epg_007_epg_scenior_font_grijs() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "GRIJS"), true)) {
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

	@Test
	public void tc_epg_008_epg_scenior_font_geel() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "STANDAARD", "GEEL"), true)) {
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

	@Test
	public void tc_epg_009_epg_scenior_groen_standard() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "STANDAARD"), true)) {
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

	@Test
	public void tc_epg_010_epg_scenior_groen_grijs() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GRIJS"), true)) {
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

	@Test
	public void tc_epg_011_epg_scenior_groen_geel() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validationEpgCss(epgScreen.changeEpgSetting("SENIOR", "GROEN", "GEEL"), true)) {
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

	@Test
	public void tc_epg_012_epg_strak_default() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validateEPGProgramSetting(epgScreen.changeEpgSetting("STRAK", "GROEN", "STANDAARD"), true)) {
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

	@Test
	public void tc_epg_013_epg_strak_font_grijs() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validateEPGProgramSetting(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "GRIJS"), true)) {
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

	@Test
	public void tc_epg_014_epg_strak_font_geel() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validateEPGProgramSetting(epgScreen.changeEpgSetting("STRAK", "STANDAARD", "GEEL"), true)) {
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

	@Test
	public void tc_epg_015_epg_strak_groen_standard() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validateEPGProgramSetting(epgScreen.changeEpgSetting("STRAK", "GROEN", "STANDAARD"), true)) {
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
	
	@Test
	public void tc_epg_016_epg_strak_groen_grijs() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validateEPGProgramSetting(epgScreen.changeEpgSetting("STRAK", "GROEN", "GRIJS"), true)) {
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


	@Test
	public void tc_epg_017_epg_strak_groen_geel() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		if (epgScreen.validateEPGProgramSetting(epgScreen.changeEpgSetting("STRAK", "GROEN", "GEEL"), true)) {
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

package com.rsystems.test;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.pages.ChangePreference;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.EpgScreen;
import com.rsystems.pages.MiniEPGScreen;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

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
	public void tc_BCEPGHPG05_epg_setting_UI_NL() throws InterruptedException {

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
		epgScreen.cancelBtnExist();

		// Verification for confirm button
		epgScreen.confirmBtnExist();

	}

	@Test
	public void tc_BCEPGHPG02_epg_confirmation_setting() throws InterruptedException {

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
	public void tc_BCEPGHPG01_epg_cancel_setting() throws InterruptedException {

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
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "STANDAARD" Epg Font = "STANDAARD"
	 * 
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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "STANDAARD" Epg Font = "GRIJS"
	 * 
	 */

	@Test
	public void tc_BCEPGHPG010_epg_scenior_font_grijs() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "STANDAARD" Epg Font = "GEEL"
	 * 
	 */

	@Test
	public void tc_BCEPGHPG09_epg_scenior_font_geel() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "STANDAARD"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG013_epg_scenior_groen_standard() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG012_epg_scenior_groen_grijs() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "GEEL"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG011_epg_scenior_groen_geel() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "STANDAARD"
	 * 
	 */
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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "STANDAARD" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG016_epg_strak_font_grijs() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "STANDAARD" Epg Font = "GEEL"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG015_epg_strak_font_geel() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "STANDAARD"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG019_epg_strak_groen_standard() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "GRIJS"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG018_epg_strak_groen_grijs() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "STRAK" Epg background = "GROEN" Epg Font = "GEEL"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG017_epg_strak_groen_geel() throws InterruptedException {

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

	/**
	 * @throws InterruptedException
	 *             Test case validate the CSS When EPF Setting is Epg Type =
	 *             "SENIOR" Epg background = "GROEN" Epg Font = "STANDAARD"
	 * 
	 */
	@Test
	public void tc_BCEPGHPG07_epg_customize_color_patterns() throws InterruptedException {
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

	/**
	 * @throws InterruptedException
	 *             Test case validate the language setting in franch language
	 * 
	 */
	@Test
	public void tc_BCEPGHPG04_epg_setting_UI_FR() throws InterruptedException {

		// Change Language to FR
		ChangePreference pref = new ChangePreference(driver);
		pref.navigateToMyPreference();
		// Change to French
		if (pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_FR", "name_nl"))) {
			reports.log(LogStatus.PASS, "Setting of Language to French has Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("verifyLanguageChangedOrNot OK");

		} else {
			reports.log(LogStatus.FAIL, "Setting of Language to French has Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("verifyLanguageChangedOrNot OK");

		}
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgSettingScreen();
		// Validation for epg type
		String optionarrForEpgType[] = { "d�faut", "sup�rieur", "simplifi�" };
		epgScreen.verifyOptionInEpg(optionarrForEpgType, epgScreen.epgType);

		sendKeyMultipleTimes("DOWN", 1, 1000);
		// Validation for background
		String optionarrForbackground[] = { "d�faut", "vert" };
		epgScreen.verifyOptionInEpg(optionarrForbackground, epgScreen.epgBackground);

		sendKeyMultipleTimes("DOWN", 1, 1000);
		// validation for font color
		String optionarrForFont[] = { "d�faut", "gris", "jaune" };
		epgScreen.verifyOptionInEpg(optionarrForFont, epgScreen.epgFont);

		// Verification for cancel button
		epgScreen.cancelBtnExist();
		// Verification for confirm button
		epgScreen.confirmBtnExist();
		// default LanguageSet
		setApplicationHubPage(1);
		pref.navigateToMyPreference();
		if (pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_NL", "name_nl"))) {
			reports.log(LogStatus.PASS, "Setting of Language to Dutch has Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			reports.log(LogStatus.FAIL, "Setting of Language to Dutch has Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 *             Verify the EPG screen using pressing hot key
	 */
	@Test
	public void tc_BCDTVHP0801_epg_hot_key() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		reports.log(LogStatus.PASS, "Open EPG using hot key");
		epgScreen.goToEpgChannelScreen(true);
		Thread.sleep(5000);
		epgScreen.verifyEPGScreenDisplayed();
		// verify navigation in EPG guide
		epgScreen.verifyNavigationinEPG();

	}

	@Test

	public void tc_BCEPGHPG03_epg_setting_UI_Default_options() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		// Set Type as Standaard
		reports.log(LogStatus.PASS, "Set Default Type as STANDAARD");
		HashMap<String, String> epgSettings = epgScreen.changeEpgSetting("STANDAARD", "STANDAARD", "STANDAARD");
		epgScreen.verifyDefaultType();
		// Navigate to EPG Guide and Verify epg Setting;
		reports.log(LogStatus.PASS, "Navigate to EPG and verify settings");
		if (epgScreen.validationEpgCss(epgSettings, true)) {
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		} else {
			reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Verification of EPG changes OK");
		}
		reports.log(LogStatus.PASS, "Change Language from NL to FR and Verify the Deafult Option Setting in EPG");
		// Change Language to FR
		ChangePreference pref = new ChangePreference(driver);
		setApplicationHubPage(1);
		pref.navigateToMyPreference();
		// Change to French
		if (pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_FR", "name_nl"))) {
			reports.log(LogStatus.PASS, "Setting of Language to French has Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			reports.log(LogStatus.FAIL, "Setting of Language to French has Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		HashMap<String, String> epgSetting = epgScreen.changeEpgSetting("d�faut", "d�faut", "d�faut");
		epgScreen.verifyDefaultType();
		// Navigate to EPG Guide and Verify epg Setting;
		reports.log(LogStatus.PASS, "Navigate to EPG and verify settings");
		try {
			if (epgScreen.validationEpgCss(epgSetting, true)) {
				reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				System.out.println("Verification of EPG changes OK");
			} else {
				reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				System.out.println("Verification of EPG changes OK");
			}
		}
		// Set to Default language - NL
		catch (SkipException e) {
			setApplicationHubPage(1);
			pref.navigateToMyPreference();
			pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_NL", "name_nl"));
			throw e;
		}
		setApplicationHubPage(1);
		pref.navigateToMyPreference();
		pref.changeAndVerifyLanguage(TestInitization.getExcelKeyValue("parameters", "language_NL", "name_nl"));

	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate the EPG_Up_Down_Navigation
	 */
	@Test
	public void tc_EPG_Up_Down_Navigation() throws InterruptedException {
		tc_BCDTVHP0801_epg_hot_key();
	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 *             Test case validate the EPG_Past Program_Options
	 */
	@Test
	public void tc_EPG_Past_Program_Options() throws NumberFormatException, InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		dtvChannelScreen.navigateToPastReplaybleProgramFromTVGuide();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases to validate two lines in EPG Screen
	 */
	@Test
	public void tc_SF008_EPG() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.verifyLinesInEPGScreen();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate gradient in focussed cell of
	 *             EPG Screen
	 */
	@Test
	public void tc_EPG_Gradient_of_Focused_Cell() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.verifyGradientOnEPG();
	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 * 
	 */
	@Test
	public void tc_EPG_Numeric_Navigation() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to Tv guide.");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		epgScreen.channelChangeAndValidation();
	}

	@Test
	public void tc_EPG_Ongoing_Program_Options() throws InterruptedException {

		Boolean pauseBtnFound = false;
		Boolean recordBtnFound = false;

		reports.log(LogStatus.PASS, "Navigate the Live TV");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Select On goining program");
		sendKeySequence("ENTER", 1000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());
		List<WebElement> actionList = driver.findElements(By.xpath(ObjectRepository.EpgScreen.actionList));
		reports.log(LogStatus.PASS, "Validation the action list");
		for (WebElement option : actionList) {
			if (option.getText().contentEquals("pauzeren")) {
				pauseBtnFound = true;
				reports.log(LogStatus.PASS, "Pause button found");
			} else if (option.getText().contentEquals("opnemen")) {
				recordBtnFound = true;
				reports.log(LogStatus.PASS, "Record button found");
			}

			else if (option.getText().contentEquals("serie opnemen")) {
				reports.log(LogStatus.PASS, "Record Series found");
			}

			else if (option.getText().contentEquals("zendercatalogus")) {
				reports.log(LogStatus.PASS, "Channel Catalog found");
			}
		}

		if (!(pauseBtnFound && recordBtnFound)) {
			FailTestCase("Pause or Record button is not found");
		}
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate the focused Cell in EPG Screen
	 *             has Rounded Corners
	 */

	@Test
	public void tc_EPG_Rounded_Corner_on_Focus_Cell() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.verifyRoundedCornerOnFocuCell();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate EPG jump by day using FF and
	 *             REW keys.
	 */
	@Test
	public void tc_EPG_Jump_By_Day_Using_FF_REW_Keys() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.verifyFFAndREWKeyOnEPGScreen();
	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used to focus on the highlighted program
	 */
	@Test
	public void tc_EPG_Focus_On_Current_Program() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.EPG_Focus_On_Current_Program();
	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used to navigate to EPG and verify the EPG
	 *             guide
	 */
	@Test
	public void tc_EPG_via_Hotkey() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.EPG_via_Hotkey();
	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used to when pressing on TV Guide button, the
	 *             start time of the time line is the current time
	 */
	@Test
	public void tc_EPG_Focus_On_Current_Time() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.EPG_Focus_On_Current_Time();
	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate EPG _Focused_Program_Cell_Details
	 */
	@Test
	public void tc_EPG002_EPG_Focused_Program_Cell_Details() throws InterruptedException {

		reports.log(LogStatus.PASS, "Navigate to TV guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 3000);
		reports.attachScreenshot(captureCurrentScreenshot());

		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.EpgFocousCellValidation();

	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate EPG_Day_Navigator_Details
	 */
	@Test
	public void tc_EPG_Day_Navigator_Details() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to TV guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgScreen.dayNavigator, "Day navigator ");

		epgScreen.dayNavigatorCssValidation();
	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate the EPG_Program_description
	 */

	@Test
	public void tc_EPG_Program_description() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to TV guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentPrgDesc = epgScreen.displayChannelDescription.getText();
		reports.log(LogStatus.PASS, "Navigate to another channel");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if (epgScreen.displayChannelDescription.getText().contentEquals(currentPrgDesc)) {
			FailTestCase("Program description is not updated");
		} else {
			reports.log(LogStatus.PASS, "Program description has been updated");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	/**
	 * 
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate the EPG_Mini_EPG
	 */

	@Test
	public void tc_EPG_Mini_EPG() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		EpgScreen epgScreen = new EpgScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Navigate to Mini EPG");
		sendKeySequence("RIGHT", 1000, "televisie");

		reports.log(LogStatus.PASS, "Navigate to tv-gids");
		miniEPGScreen.validateFirstOrRightTile("RIGHT", "tv-gids", 30);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Navigate to EPG");
		sendKeySequence("ENTER", 3000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgScreen.displayChannelDescription, "Current program description ");

	}

	/**
	 * 
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate the EPG_Genre
	 */
	@Test
	public void tc_EPG_Genre() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to TV guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		sendNumaricKeys(Integer.parseInt(getExcelKeyValue("ActivateInfoBanner", "RadioChannel", "name_nl")));
		Thread.sleep(5000);

		String currentPrgDesc = epgScreen.channelGenere.getText();
		reports.log(LogStatus.PASS, "Navigate to another channel");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		if (epgScreen.channelGenere.getText().contentEquals(currentPrgDesc)) {
			FailTestCase("Program genre is not updated");
		} else {
			reports.log(LogStatus.PASS, "Program genre has been updated");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to verify non focused program cell details
	 */
	@Test
	public void tc_EPG003_EPG_Non_Focused_Program_Cell_Details() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.validateNonFocussedProgramCellDetails();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to verify channel list cell details
	 */
	@Test
	public void tc_EPG006_EPG_Channel_List_Cell_Details() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.validaeEPGChannelCellDetails();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to start and verify recording icon on EPG
	 *             Screen
	 */
	@Test
	public void tc_EPG015_EPG_Current_Recording() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.validateRecordingOnEPG();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to verify breadcumb position on EPG Screen
	 */
	@Test
	public void tc_EPG012_EPG_Breadcrumb() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.validateBreadCumbOnEPG();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to open EPG screen from TV Filter Layer
	 */
	@Test
	public void tc_EPG030_EPG_TV_filter_layer() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.validateEPGFromTVLayer();
	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used to when pressing on TV Guide button, the
	 *             start time of the time line is the current time
	 */
	@Test
	public void tc_EPG001_EPG_Currently_Tuned_Focused_Program() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_Currently_Tuned_Focused_Program();
	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used to Check the focused program info
	 *             availablity over the area above EPG cells
	 */
	@Test
	public void tc_EPG004_Focused_Program_Info_Details() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_Focused_Program_Info_Details();
	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used toEPG should display. Program title should
	 *             display above the time duration in Bold letter s Program
	 *             title get change according to the program.
	 */
	@Test

	public void tc_EPG022_EPG_Program_title() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_Program_title();

	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used 1. change STB language to FR . 2. Open EPG
	 *             through RC and Check the language of day.
	 */
	@Test

	public void tc_EPG019_EPG_FR_Language_Day() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_FR_Language_Day();

	}

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 *             Test cases is used 1. change STB language to NL . 2. Open EPG
	 *             through RC and Check the language of day.
	 */
	@Test
	public void tc_EPG020_EPG_NL_Language_Day() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_NL_Language_Day();

	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 */

	@Test
	public void tc_EPG023_EPG_Program_Duration() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);

		reports.log(LogStatus.PASS, "Navigate to Tv guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());

		int startYProgramTitle = epgScreen.displayChannelTitle.getLocation().getY();
		int startTimeDuration = epgScreen.focusElementProgramTime.getLocation().getY();
		int startYProgramDesc = epgScreen.displayChannelDescription.getLocation().getY();
		String startProgramTime = epgScreen.displayChannelStartTime.getText();
		if (startYProgramTitle < startTimeDuration && startTimeDuration < startYProgramDesc) {
			reports.log(LogStatus.PASS, "Program duration is displayed between program title and program description ");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Program duration is not displayed between and program title and program description");
		}
		reports.log(LogStatus.PASS, "Navigation to another program");
		sendKeyMultipleTimes("RIGHT", 10, 1000);
		if (startProgramTime.contentEquals(epgScreen.displayChannelStartTime.getText())) {
			FailTestCase("Program duration is not updated after navigation in EPG");
		} else {
			reports.log(LogStatus.PASS, "Program duration has been updated after navigation in EPG.");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	@Test
	public void tc_EPG_Blacklist_Backprogram_faded() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(1);

		dtvChannelScreen.navigateToPastProgramFromTVGuide(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_1", "Values")));
		double currentHighlightOpacity = Double.parseDouble(epgScreen.focusElemntInEpg.getCssValue("opacity"));
		String currentHighlightOpacityInDecimal = df.format(currentHighlightOpacity) + "";

		if (currentHighlightOpacityInDecimal
				.contentEquals(getExcelKeyValue("EpgScreen", "NonReplayChannelProgramInPast", "Opacity"))) {
			reports.log(LogStatus.PASS,
					"Opacity of program title in past program and non replyable program of CUTV Channel Actual Opacity : "
							+ currentHighlightOpacityInDecimal + "and expected opacity "
							+ getExcelKeyValue("EpgScreen", "NonReplayChannelProgramInPast", "Opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase(
					"Opacity of program title in past program and non replyable program of CUTV Channel are not matched. Actual Opacity : "
							+ currentHighlightOpacityInDecimal + "and expected opacity "
							+ getExcelKeyValue("EpgScreen", "NonReplayChannelProgramInPast", "Opacity"));
		}

		dtvChannelScreen.navigateToPastProgramFromTVGuide(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel", "Values")));
		currentHighlightOpacity = Double.parseDouble(epgScreen.focusElemntInEpg.getCssValue("opacity"));
		currentHighlightOpacityInDecimal = df.format(currentHighlightOpacity) + "";

		if (currentHighlightOpacityInDecimal
				.contentEquals(getExcelKeyValue("EpgScreen", "NonReplayChannelProgramInPast", "Opacity"))) {
			reports.log(LogStatus.PASS,
					"Opacity of program title in past program of non CUTV Channel Actual Opacity : "
							+ currentHighlightOpacityInDecimal + "and expected opacity "
							+ getExcelKeyValue("EpgScreen", "NonReplayChannelProgramInPast", "Opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Opacity in past program in non CUTV Channel are not matched. Actual Opacity : "
					+ currentHighlightOpacityInDecimal + "and expected opacity "
					+ getExcelKeyValue("EpgScreen", "NonReplayChannelProgramInPast", "Opacity"));
		}

	}

	@Test
	public void tc_EPG_Channel_Bar_Navigation() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		reports.log(LogStatus.PASS, "Open EPG");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 3000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String channelBarPostionBeforeNavigation = epgScreen.ChannelbarInEpg.getCssValue("left");

		reports.log(LogStatus.PASS, "Navigate to another program");
		sendKeyMultipleTimes("LEFT", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		String channelBarPostionAfterNavigation = epgScreen.ChannelbarInEpg.getCssValue("left");

		if (channelBarPostionAfterNavigation.contentEquals(channelBarPostionBeforeNavigation)) {
			reports.log(LogStatus.PASS,
					"Channel bar position is same after navigation. channel bar margin-left before navigation : "
							+ channelBarPostionBeforeNavigation + " channel bar margin-left after navigation : "
							+ channelBarPostionAfterNavigation);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Channel bar position is not same after navigation. channel bar margin-left before navigation : "
							+ channelBarPostionBeforeNavigation + " channel bar margin-left after navigation : "
							+ channelBarPostionAfterNavigation);
		}
	}

	/**
	 * @author Rahul.Dhoundiyal Test cases is used to validate Forward and
	 *         Reverse Key
	 */
	@Test
	public void tc_EPG018_EPG_Day_Forward_key_Reverse_key() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.verifyForwardBackWardKey();
	}

	/**
	 * @author Rahul.Dhoundiyal Test cases is used to validate Program
	 *         Description updated or not
	 */
	@Test
	public void tc_EPG024_EPG_Program_description() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.verifyProgramDescription();
	}
	
	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 * Test cases is used 1) Open EPG. 2) Verify the icons in the grid view
	 */
	@Test
	
	public void tc_EPG_Grid_view_icons() throws InterruptedException{
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_Grid_view_icons();
		
	}
	
	
	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 * Test cases is used 1. Select a future program and press OK. 2. Press"Record "
	 */
	@Test
	
	public void tc_EPG016_EPG_Schedule_recording() throws InterruptedException{
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.epg_Schedule_recording();
		
	}
	
	
	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 * Test cases is used Step1-Ensure the EPG will scroll ahead seven days (Or as far ahead as data has been provided) using FFW key.
	 * Step2-Ensure the EPG will scroll back two days (Or as far ahead as data has been provided) using REW key.
	 */
	@Test
	
	public void tc_392_EPG_Navigation_Till_Available_Days() throws InterruptedException{
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.EPG_Navigation_Till_Available_Days();
		
	}
	
	
	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException
	 * Test cases is used Check that time in EPG page, parameter page, info banner, menu page, is correct.
	 * @throws ParseException 
	 */
	@Test
	
	public void tc_356_TIME0202_UI() throws InterruptedException, ParseException{
		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.TIME0202_UI();
		
	}
}

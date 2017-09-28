package com.rsystems.test;

import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.UnAssignStb;
import com.rsystems.utils.TestInitization;

import APIs.STBAPIs;

public class UnAssingedSTBTestCases extends TestInitization {

	/**
	 * 
	 * 
	 * @throws Exception
	 */

	@Test
	public void tc_BCCOMML0210_LANG007_Assignment() throws Exception {

		STBAPIs stbApis = new STBAPIs();

		String stbIP = null;
		stbIP = System.getProperty("STBIP");
		if (stbIP == null || stbIP.contentEquals("")) {
			stbIP = TestInitization.getUpdatedProptiesFile().getProperty("STBIP");
		}

		reports.log(LogStatus.PASS, "Unassigned STB");
		try {
			stbApis.stbUnassign(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "EquipmentId", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "MacAddress", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "SerialNumber", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "SubscriberVersion", stbIP));
		} catch (Exception e) {
			// catch if STB is already Unassign
			if (!e.getMessage().contains("no longer assigned to this subscriber")) {
				throw e;
			}
		}
		reports.attachScreenshot(captureCurrentScreenshot());
		Properties PR = getUpdatedProptiesFile();

		PR.setProperty("RunOnUnassignedSTB", "TRUE");
		PR.put("RunOnUnassignedSTB", "TRUE");
		PR.store(new FileOutputStream(TestInitization.configFilePath), null);

		assignLanguageToStB(TestInitization.getExcelKeyValue("AccountInformation", "Language", stbIP),
				(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", stbIP)),
				(TestInitization.getExcelKeyValue("AccountInformation", "PinCode", stbIP)));
	}

	@Test
	public void STB_Registration_Auto_Config_screen_On_unassigning_STB() throws Exception {
		STBAPIs stbApis = new STBAPIs();
		UnAssignStb unAssignStb = new UnAssignStb(driver);

		String stbIP = null;
		stbIP = System.getProperty("STBIP");
		if (stbIP == null || stbIP.contentEquals("")) {
			stbIP = TestInitization.getUpdatedProptiesFile().getProperty("STBIP");
		}

		reports.log(LogStatus.PASS, "Unassigned STB");
		try {
			stbApis.stbUnassign(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "EquipmentId", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "MacAddress", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "SerialNumber", stbIP),
					TestInitization.getExcelKeyValue("AccountInformation", "SubscriberVersion", stbIP));
		} catch (Exception e) {
			// catch if STB is already Unassign
			if (!e.getMessage().contains("no longer assigned to this subscriber")) {
				throw e;
			}
		}
		reports.attachScreenshot(captureCurrentScreenshot());
		// waiting for 5 second for unassign STB
		Thread.sleep(5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(unAssignStb.languageHeading, "Language heading ");

		Properties PR = getUpdatedProptiesFile();

		PR.setProperty("RunOnUnassignedSTB", "TRUE");
		PR.put("RunOnUnassignedSTB", "TRUE");
		PR.store(new FileOutputStream(TestInitization.configFilePath), null);

		reports.log(LogStatus.PASS, "Trying to Assign STB.");
		assignLanguageToStB(TestInitization.getExcelKeyValue("AccountInformation", "Language", stbIP),
				(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", stbIP)),
				(TestInitization.getExcelKeyValue("AccountInformation", "PinCode", stbIP)));

	}
}

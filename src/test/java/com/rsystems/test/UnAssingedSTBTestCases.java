package com.rsystems.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.UnAssignStb;
import com.rsystems.utils.TestInitization;
import com.sun.jna.platform.win32.WinNT.LOGICAL_PROCESSOR_RELATIONSHIP;

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
		reports.log(LogStatus.PASS, "Unassigned STB");
		try {
			stbApis.stbUnassign(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "EquipmentId", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "MacAddress", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "SerialNumber", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "SubscriberVersion", "Value"));
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

		assignLanguageToStB(TestInitization.getExcelKeyValue("AccountInformation", "Language", "Value"),
				(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value")),
				(TestInitization.getExcelKeyValue("AccountInformation", "PinCode", "Value")));
	}

	@Test
	public void STB_Registration_Auto_Config_screen_On_unassigning_STB() throws Exception {
		STBAPIs stbApis = new STBAPIs();
		UnAssignStb unAssignStb = new UnAssignStb(driver);
		
		reports.log(LogStatus.PASS, "Unassigned STB");
		try {
			stbApis.stbUnassign(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "EquipmentId", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "MacAddress", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "SerialNumber", "Value"),
					TestInitization.getExcelKeyValue("AccountInformation", "SubscriberVersion", "Value"));
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
		assignLanguageToStB(TestInitization.getExcelKeyValue("AccountInformation", "Language", "Value"),
				(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value")),
				(TestInitization.getExcelKeyValue("AccountInformation", "PinCode", "Value")));

	}
}

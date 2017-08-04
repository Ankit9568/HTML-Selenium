package com.rsystems.test;

import java.io.FileOutputStream;
import java.util.Properties;

import org.testng.annotations.Test;

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

		stbApis.stbUnassign(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value"),
				TestInitization.getExcelKeyValue("AccountInformation", "EquipmentId", "Value"),
				TestInitization.getExcelKeyValue("AccountInformation", "MacAddress", "Value"),
				TestInitization.getExcelKeyValue("AccountInformation", "SerialNumber", "Value"),
				TestInitization.getExcelKeyValue("AccountInformation", "SubscriberVersion", "Value"));

		Properties PR = getUpdatedProptiesFile();

		PR.setProperty("RunOnUnassignedSTB", "TRUE");
		PR.put("RunOnUnassignedSTB", "TRUE");
		PR.store(new FileOutputStream(TestInitization.configFilePath), null);

		assignLanguageToStB(TestInitization.getExcelKeyValue("AccountInformation", "Language", "Value"),
				(TestInitization.getExcelKeyValue("AccountInformation", "LineNumber", "Value")),
				(TestInitization.getExcelKeyValue("AccountInformation", "PinCode", "Value")));
	}

}

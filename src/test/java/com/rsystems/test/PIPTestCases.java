package com.rsystems.test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.PIPScreen;
import com.rsystems.utils.TestInitization;
public class PIPTestCases extends TestInitization {

	/**
	 * This test cases is used to verify the pip setting changed to links
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void verifyLinksPipPosition() throws InterruptedException{
		System.out.println(" Validation test case ");
		PIPScreen.changePIPSetting("links");
		if (PIPScreen.verifyPIPSettingChanged()){
			reports.log(LogStatus.PASS, "Verification of changes in PIP Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Verification of changes in PIP Failed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		// Change PIP Setting to default
		PIPScreen.changePIPSetting("standaard");
	}
	/**
	 * This test cases is used to verify the pip setting changed to standard
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void verifyStandardPipPosition() throws InterruptedException{
		System.out.println(" Validation test case ");
		PIPScreen.changePIPSetting("standaard");
		if (PIPScreen.verifyPIPSettingChanged()){
			reports.log(LogStatus.FAIL, "Verification of changes in PIP FAILED");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.PASS, "Verification of changes in PIP Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		// Change PIP Setting to default
		PIPScreen.changePIPSetting("standaard");
	}	
}

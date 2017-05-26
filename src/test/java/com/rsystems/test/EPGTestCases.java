package com.rsystems.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.EPG;
import com.rsystems.utils.TestInitization;

public class EPGTestCases extends TestInitization {

	@Test
	public void standardEPG_Validation() throws InterruptedException {

		System.out.println(" Validation test case ");
		// check font is standard on EPf Setting Screen
		//boolean isEpgSettingCorrect = EPG.validateEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
		
		//if(isEpgSettingCorrect){
			EPG.goToEpgChannelScreen();
			
			if(EPG.validationChannelCss("STANDAARD", "STANDAARD", "STANDAARD"))
			{
			reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

			System.out.println("Verification of EPG changes OK");
			
			}else
			{
				reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

				System.out.println("Verification of EPG changes OK");
			}
			
			
			
			
		//}
		
		//else{
		//	throw new SkipException("EPG Setting is not set successfully");
		//}
	}

	@Test
	public void seniorEPG_Validation() throws InterruptedException {

		// change EPG Screen to Seniour_groen_Grijs and validation
		
		EPG.goToEpgSettingScreen();
		EPG.changeEpgChannelSetting("SENIOR", "GROEN", "GRIJS");
		
		
		//boolean isEpgSettingCorrect = EPG.validateEpgChannelSetting("SENIOR", "GROEN", "GRIJS");
		
		//if(isEpgSettingCorrect){
			EPG.goToEpgChannelScreen();
			
			if(EPG.validationChannelCss("SENIOR", "GROEN", "GRIJS"))
				{
				reports.log(LogStatus.PASS, "Verification of changes in EPG Passed");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

				System.out.println("Verification of EPG changes OK");
				
				}else
				{
					reports.log(LogStatus.FAIL, "Verification of changes in EPG Failed");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

					System.out.println("Verification of EPG changes OK");
				}
		//}
		//else{
		//	throw new SkipException("EPG Setting is not set successfully");
		//}

		// Back EPG setting to Standard
		EPG.goToEpgSettingScreen();
		EPG.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
		
		
	}

}

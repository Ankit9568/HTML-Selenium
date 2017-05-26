package com.rsystems.test;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.rsystems.utils.EPG;
import com.rsystems.utils.TestInitization;

public class TeleviseTestCase extends TestInitization {

	@Test
	public void epg_Nu_ValidationForStandard() throws InterruptedException {

		System.out.println(" Validation test case ");
		// check font is standard on EPf Setting Screen
		boolean isEpgSettingCorrect = EPG.validateEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
		
		if(isEpgSettingCorrect){
			EPG.goToEpgChannelScreen();
			EPG.validationChannelCss("STANDAARD", "STANDAARD", "STANDAARD");
		}
		
		else{
			throw new SkipException("EPG Setting is not set successfully");
		}
	}

	@Test
	public void epg_Nu_ValidationForSenior() throws InterruptedException {

		// change EPG Screen to Seniour_groen_Grijs and validation
		
		EPG.goToEpgSettingScreen();
		EPG.changeEpgChannelSetting("SENIOR", "GROEN", "GRIJS");
		
		
		boolean isEpgSettingCorrect = EPG.validateEpgChannelSetting("SENIOR", "GROEN", "GRIJS");
		
		if(isEpgSettingCorrect){
			EPG.goToEpgChannelScreen();
			EPG.validationChannelCss("SENIOR", "GROEN", "GRIJS");
		}
		else{
			throw new SkipException("EPG Setting is not set successfully");
		}

		// Back EPG setting to Standard
		EPG.goToEpgSettingScreen();
		EPG.changeEpgChannelSetting("STANDAARD", "STANDAARD", "STANDAARD");
		
		
	}

}

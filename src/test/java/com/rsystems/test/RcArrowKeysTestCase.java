package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.EpgScreen;
import com.rsystems.pages.RcArrowKeys;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.utils.TestInitization;

public class RcArrowKeysTestCase extends TestInitization {
	// This test case is verifying the key navigations of Epg,VOD,PVR screen
	@Test
	public void tc_BCREMC0107_verifyNavigationEpgScreen() throws InterruptedException {
		EpgScreen epgScreen = new EpgScreen(driver);
		// navigate the Epg screen
		epgScreen.goToEpgChannelScreen(false);
		epgScreen.verifyNavigationinEPG();

		RcArrowKeys rc = new RcArrowKeys(driver);

		rc.verifyNavigationToVODScreen();
		RecordingScreen record = new RecordingScreen(driver);
		record.verifyNavigationInPlannedRecording();
	}
	
	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 * Test cases is used to validated TV Keyof RCU
	 */
	@Test
	public void tc_RCU_Digital_TV_NTE11() throws InterruptedException
	{
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyDTVHotKey();
	}
	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 * Test cases is used to validate numeric keys on different screens
	 */
	@Test
	public void tc_RCU_Numeric_keys() throws InterruptedException{
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyNumericKeys();
	}
	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 * Test case is used to validate navigation under EPG Screen
	 */
	@Test
	public void tc_RCU_EPG_Navigation() throws InterruptedException{
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCUEPGNavigation();
	}
	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 * Test cases is used to validate Arrows Keys on DTV Full Screen
	 */
	@Test
	public void tc_RCU_Arrow_Keys_on_DTV_fullscreen() throws InterruptedException{
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCArrowKeysOnDTV();
	}
	
}
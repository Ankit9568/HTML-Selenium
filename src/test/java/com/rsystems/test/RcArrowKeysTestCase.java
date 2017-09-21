package com.rsystems.test;

import static org.testng.Assert.expectThrows;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.EpgScreen;
import com.rsystems.pages.HotKeysNavigation;
import com.rsystems.pages.RcArrowKeys;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

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
	 *             Test cases is used to validated TV Keyof RCU
	 */
	@Test
	public void tc_RCU_Digital_TV_NTE11() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyDTVHotKey();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate numeric keys on different
	 *             screens
	 */
	@Test
	public void tc_RCU_Numeric_keys() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyNumericKeys();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test case is used to validate navigation under EPG Screen
	 */
	@Test
	public void tc_RCU_EPG_Navigation() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCUEPGNavigation();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate Arrows Keys on DTV Full Screen
	 */
	@Test
	public void tc_RCU_Arrow_Keys_on_DTV_fullscreen() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCArrowKeysOnDTV();
	}

	/**
	 * @author Rahul.Dhoundiyal Test cases is used to validate Record Button
	 * @throws InterruptedException
	 */
	@Test
	public void tc_RCU_Record_Button() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRecordButton();
	}

	/**
	 * @author Rahul.Dhoundiyal Test cases is used to validate BACK Key
	 */
	@Test
	public void tc_RCU_BackKey() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyBackKey();

	}

	// New Test cases
	/**
	 * @author Rahul.Dhoundiyal Test cases to verify CH+/CH- keys
	 */
	@Test
	public void tc_RCU_CHPlus_CHMiunsKey() throws InterruptedException {

		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCCHPlusChMinusKeysOnDTV();
	}

	/**
	 * @author Rahul.Dhoundiyal Test cases is used to validate OnDemand Key
	 * 
	 */
	@Test
	public void tc_RCU_ON_Demand_NTE1_1() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCUOnDemandKey();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate PVR Key
	 */
	@Test
	public void tc_RCU_PVR_NTE1_1() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCUPVRKey();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate Radio Key
	 */
	@Test
	public void tc_RCU_Radio_Hot_Key_NTE1_1() throws InterruptedException {
		RcArrowKeys rc = new RcArrowKeys(driver);
		rc.verifyRCURadioKey();
	}

	public void tc_RCU_Digital_TV_NTE1_2() throws InterruptedException {

		HotKeysNavigation hotKeysNavigation = new HotKeysNavigation(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		// Step 1
		dtvChannelScreen.openLiveTVAndValidate();
		setApplicationHubPage(1);
		sendKeySequence("RIGHT,ENTER", 1000, "home");
		dtvChannelScreen.openLiveTVAndValidate();
		hotKeysNavigation.navigateToRadioScreen();
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		String channelNumber = dtvChannelScreen.openLiveTVAndValidate();

		// Step 2
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 1000);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		if (channelNumber.contentEquals(dtvChannelScreen.chnlNoIn_Infobar.getText())) {
			reports.log(LogStatus.PASS, "Other TV channel is tuned.");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		dtvChannelScreen.openLiveTVAndValidate();

		// Step3
		reports.log(LogStatus.PASS, "Naviaget to HUB ");
		setApplicationHubPage(1);
		dtvChannelScreen.openLiveTVAndValidate();
		hotKeysNavigation.navigateToRadioScreen();

	}

	@Test
	public void tc_RCU_Digital_TV_NTE1_2_A() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		RcArrowKeys rcArrowKeys = new RcArrowKeys(driver);
		HotKeysNavigation hotKeysNavigation = new HotKeysNavigation(driver);

		// Step 4
		dtvChannelScreen.openLiveTVAndValidate();
		reports.log(LogStatus.PASS, "Naviaget to HUB ");
		setApplicationHubPage(1);
		String lastChannelNumber = dtvChannelScreen.openLiveTVAndValidate();
		hotKeysNavigation.navigateToRadioScreen();

		// step 5
		hotKeysNavigation.navigateToRadioScreen();
		String currentNumber = dtvChannelScreen.openLiveTVAndValidate();
		rcArrowKeys.verifyChannelNumber(currentNumber, lastChannelNumber);

		// Step 6
		rcArrowKeys.validateNotificationMessages(lastChannelNumber, "CUTV");
		rcArrowKeys.validateNotificationMessages(lastChannelNumber, "PVR");
		rcArrowKeys.validateNotificationMessages(lastChannelNumber, "PLTV");

	}

	@Test
	public void tc_RCU_Digital_TV_NTE1_2_B() throws InterruptedException {

		RcArrowKeys rcArrowKeys = new RcArrowKeys(driver);

		// Step 7
		rcArrowKeys.playCUTVPlayBack();
		// Play LIve TV and validate POP UP
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(rcArrowKeys.notificationMsg, " Notification Popup");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 1000);
		isNotDisplayed(rcArrowKeys.notificationMsg, " Notification Popup");
		// For Step 8 Functionality is not yet implemented

	}

	@Test
	public void tc_RCU_Radio_Hot_Key_NTE1_2() throws InterruptedException {

		HotKeysNavigation hotKeysNavigation = new HotKeysNavigation(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		// Step 1
		String tvChannelNumber = dtvChannelScreen.openLiveTVAndValidate();
		setApplicationHubPage(1);
		sendKeySequence("RIGHT,ENTER", 1000, "home");

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_RADIO.toString(), 1, 0);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (tvChannelNumber.contentEquals(dtvChannelScreen.chnlNoIn_Infobar.getText())) {
			reports.log(LogStatus.PASS, "Live TV is tuned Actual Channel Number "
					+ dtvChannelScreen.chnlNoIn_Infobar.getText() + " Expected Channel Number " + tvChannelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Live TV is not tuned Actual Channel Number " + dtvChannelScreen.chnlNoIn_Infobar.getText()
					+ " Expected Channel Number " + tvChannelNumber);
		}
		
		hotKeysNavigation.openRadioButtonAndValidate(2);
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		String channelNumber = hotKeysNavigation.openRadioButtonAndValidate(1) + "";
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		if (channelNumber.contentEquals(dtvChannelScreen.chnlNoIn_Infobar.getText())) {
			reports.log(LogStatus.PASS, "Radio Channel is tuned Actual channel number "
					+ dtvChannelScreen.chnlNoIn_Infobar.getText() + " Expected Channel Number " + channelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Unable to Tuned Radio channel Actual channel number "
					+ dtvChannelScreen.chnlNoIn_Infobar.getText() + " Expected Channel Number " + channelNumber);
		}
		
		
		// Step 2
		
		
		
		
		// Step3
		hotKeysNavigation.openRadioButtonAndValidate();
		setApplicationHubPage(1);
		
		
		dtvChannelScreen.openLiveTVAndValidate();
		hotKeysNavigation.navigateToRadioScreen();

	}
}
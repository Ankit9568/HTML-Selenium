package com.rsystems.test;

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

	@Test
	public void tc_RCU_Digital_TV_NTE1_2() throws InterruptedException {

		HotKeysNavigation hotKeysNavigation = new HotKeysNavigation(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		// Step 1
		dtvChannelScreen.openLiveTVAndValidate();
		setApplicationHubPage(1);
		sendKeySequence("RIGHT,ENTER", 1000, "shop");
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
		rcArrowKeys.validateNotificationMessagesForLiveTV("CUTV", Unicode.VK_TV, "Live TV");
		rcArrowKeys.validateNotificationMessagesForLiveTV("PVR", Unicode.VK_TV, "Live TV");
		rcArrowKeys.validateNotificationMessagesForLiveTV("PLTV", Unicode.VK_TV, "Live TV");
		rcArrowKeys.validateNotificationMessagesForLiveTV("VOD", Unicode.VK_TV, "Live TV");

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
		String tvChannelNumberProgramDuration = dtvChannelScreen.openLiveTVAndValidate();
		setApplicationHubPage(1);
		sendKeySequence("RIGHT,ENTER", 1000, "shop");
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO, tvChannelNumberProgramDuration, "Radio button ");

		int radioChannelNumber = hotKeysNavigation.openRadioButtonAndValidate(2);
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO, radioChannelNumber + "",
				"Radio button ");

		// Step 2
		hotKeysNavigation.openRadioButtonAndValidate(1);
		reports.log(LogStatus.PASS, "Navigate to another Radio channel");
		sendNumaricKeys(Integer.parseInt(getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values")));

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		if (getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values")
				.contentEquals(dtvChannelScreen.chnlNoIn_Infobar.getText())) {
			reports.log(LogStatus.PASS,
					"Other Radio channel is tuned. Actual Channel number " + dtvChannelScreen.chnlNoIn_Infobar.getText()
							+ "Expected Channel number " + getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Other Radio channel is not tuned. Actual Channel number "
					+ dtvChannelScreen.chnlNoIn_Infobar.getText() + "Expected Channel number "
					+ getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values"));
		}

		reports.log(LogStatus.PASS, "Again Radio press nothing should happen");
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO,
				getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values"), "Radio button ");

		// Step3
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO,
				getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values"), "Radio button ");
		
		reports.log(LogStatus.PASS, "Press menu button");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO,
				getExcelKeyValue("DTVChannel", "RadioChannel_1", "Values"), "Radio button ");
		
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_TV,tvChannelNumberProgramDuration ,
				"TV button ");
	}

	@Test
	public void tc_RCU_Radio_Hot_Key_NTE1_2_A() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		HotKeysNavigation hotKeysNavigation = new HotKeysNavigation(driver);
		RcArrowKeys rcArrowKeys = new RcArrowKeys(driver);
		// Step 4
		String currentChannelProgramDuration = dtvChannelScreen.openLiveTVAndValidate();
		reports.log(LogStatus.PASS, "Naviaget to HUB ");
		setApplicationHubPage(1);
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO, currentChannelProgramDuration, "Radio button");
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_TV, currentChannelProgramDuration, "TV button");

		// Step 5
		String getLastTunedRadioChannelProgramDetails = hotKeysNavigation.getLastTunedRadioChannelNum();
		dtvChannelScreen.openLiveTVAndValidate();
		hotKeysNavigation.pressUnicodeAndValidateChannelNumber(Unicode.VK_RADIO, getLastTunedRadioChannelProgramDetails + "",
				"Radio button");

		// Step 6
		rcArrowKeys.validateNotificationMessagesForRadio("CUTV", Unicode.VK_RADIO,
				"Radio button");
		rcArrowKeys.validateNotificationMessagesForRadio("PVR", Unicode.VK_RADIO,
				"Radio button");
		rcArrowKeys.validateNotificationMessagesForRadio( "PLTV", Unicode.VK_RADIO,
				"Radio button");
		rcArrowKeys.validateNotificationMessagesForRadio( "VOD", Unicode.VK_RADIO,
				"Radio button");

	}
}
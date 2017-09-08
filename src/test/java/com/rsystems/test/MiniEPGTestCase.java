package com.rsystems.test;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.EpgScreen;
import com.rsystems.pages.MiniEPGScreen;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class MiniEPGTestCase extends TestInitization {

	MiniEPGScreen miniEPGScreen = null;

	/**
	 * This test cases is used to verify Zap Screen from Live TV. Created By
	 * Rahul Dhoundiyal
	 */
	@Test
	public void tc_Mini_EPG_Full_Scree_TV_ZapBanner() throws InterruptedException {
		miniEPGScreen = new MiniEPGScreen(driver);
		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		dtvChannel.openLiveTV();
		miniEPGScreen.launchAndVerifyMiniEpgScreen();
		reports.log(LogStatus.PASS, "Wait for 10 sec Zap banner should dismissed and navigate to LiveTv");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		try {
			if (miniEPGScreen.headerText.isDisplayed()) {
				FailTestCase("Zap banner not getting dismissed");
			}
		} catch (NoSuchElementException ex) {
			reports.log(LogStatus.PASS, "Zap Banner Getting Dismissed and navigate to live TV");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	/**
	 * This test cases is used to verify mini epg long finished airing episode.
	 * Created By Rahul Dhoundiyal
	 */
	@Test
	public void tc_mini_epg_on_tstv() throws InterruptedException, ParseException {

		EpgScreen epgScreen = new EpgScreen(driver);
		epgScreen.goToEpgChannelScreen(true);
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyMiniEPG_long_finished_airing();
	}

	/**
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 *             test case verify the Mini-EPG Behaviour from Full-screen Live
	 *             TV on CUTV Channel
	 * 
	 */
	@Test
	public void tc_77655Mini_EPGBehaviourFromFull_screenLiveTV_onCUTVChannel()
			throws NumberFormatException, InterruptedException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		MiniEPGScreen miniEpg = new MiniEPGScreen(driver);
		dtvChannel.openLiveTV();
		dtvChannel.tuneToChannel(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		miniEpg.navigateToMiniEpgAndValidationTV_Gids();

	}

	/**
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 *             test case verify Mini-EPG Behaviour from Full-screen Live TV
	 *             on CUTV Channel_A
	 */

	@Test
	public void tc_77655_A_MiniEPGBehaviourFromFullScreenLiveTVOnCUTVChannel()
			throws NumberFormatException, InterruptedException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		MiniEPGScreen miniEpg = new MiniEPGScreen(driver);
		dtvChannel.openLiveTV();
		dtvChannel.tuneToChannel(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		miniEpg.navigateToMiniEpgAndValidationTV_GidsTileCount();

	}

	/**
	 * 
	 * 
	 * @throws NumberFormatException
	 * @throws InterruptedException
	 *             test case verify Mini-EPG Behaviour from Full-screen Live TV
	 *             on CUTV Channel_B
	 */
	@Test
	public void tc_77655_B_MiniEPGBehaviourFrmFullScreenLiveTVOnCUTVChannel()
			throws NumberFormatException, InterruptedException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		MiniEPGScreen miniEpg = new MiniEPGScreen(driver);
		dtvChannel.openLiveTV();
		dtvChannel.tuneToChannel(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		miniEpg.navigateToMiniEPGAndWaitForLiveTV();

	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 *             test case verify Mini-EPG Full-screen live TV with zapbanner
	 */
	@Test
	public void tc_77662_MiniEPG_FullScreenLiveTV_withZapbanner() throws InterruptedException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		dtvChannel.openLiveTV();
		dtvChannel.tuneToChannel(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));

		reports.log(LogStatus.PASS, "Navigate the Zap banner and validation");
		TestInitization.sendKeySequence("UP", 2000, "zaplijst");

		reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
		TestInitization.sendKeySequence("LEFT", 2000, "televisie");

	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 *             Test case verify the Mini-EPG Instant recording on watched
	 *             channel
	 */
	@Test
	public void tc_77678_MiniEPGInstantRecordingOnWatchedChannel() throws InterruptedException, IOException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		MiniEPGScreen miniEpg = new MiniEPGScreen(driver);
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		dtvChannel.openLiveTV();

		dtvChannel.tuneToChannel(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));

		reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
		TestInitization.sendKeySequence("LEFT", 0, "televisie");

		// Forcible move to live TV and move to again Mini EPg screen
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 100);
		driver.switchTo().frame(getCurrentFrameIndex());

		try {
			if (miniEpg.onGoingRecordingIcon.isDisplayed()) {
				
				FailTestCase(
						"Recording icon is already visible on webpage.Try to remove ongoing recording from channel");
			}
		} catch (NoSuchElementException e) {
			reports.log(LogStatus.PASS, "Recoding icon is not found on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		// wait for 5 second to close miniEog automatically
		Thread.sleep(5000);
		recordingScreen.startRecordingFromDTV("SINGLE", 1);

		reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
		TestInitization.sendKeySequence("LEFT", 0, "televisie");

		miniEpg.navigateToMiniEpgAndValidateObject(miniEpg.onGoingRecordingIcon, "On Going recording icon ");

		// wait for 5 second to close miniEog automatically
		Thread.sleep(5000);

		miniEpg.stopLiveTVRecording();

		reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
		TestInitization.sendKeySequence("LEFT", 1000, "televisie");

		driver.switchTo().frame(getCurrentFrameIndex());

		try {
			if (miniEpg.onGoingRecordingIcon.isDisplayed()) {
								
				FailTestCase(
						"Recording icon is already visible on webpage.Try to remove ongoing recording from channel");
			}
		} catch (NoSuchElementException e) {
			reports.log(LogStatus.PASS, "Recoding icon is not found on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 *             Test case verify the Mini-EPG Left-side tv-guide tile
	 */
	@Test
	public void tc_77679_MiniEPG_Left_side_tv_guideTile() throws InterruptedException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
		MiniEPGScreen miniEpgScreen = new MiniEPGScreen(driver);

		dtvChannel.openLiveTV();

		reports.log(LogStatus.PASS, "Navigate the Zap banner and validation");
		TestInitization.sendKeySequence("UP", 2000, "zaplijst");
		

		reports.log(LogStatus.PASS, "Navigate the CUTV disabled channel");
		sendNumaricKeys(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		Thread.sleep(2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
		TestInitization.sendKeySequence("LEFT", 2000, "televisie");
		

		miniEpgScreen.validateFirstOrRightTile("LEFT", "tv-gids", 30);

		miniEpgScreen.validateChannelInfofromMiniEpgTOTvGuide();

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 0);
		// Get the current TV Channel number
		reports.log(LogStatus.PASS, "validate Live TV");
		// Open info banner for screenshot
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(dtvChannel.chnlNoIn_Infobar, "Channel Number ");
		reports.attachScreenshot(captureCurrentScreenshot());

	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 *             Test case verify the Mini-EPG Current program poster tile
	 *             appearance
	 */
	@Test
	public void tc_77657_MiniEPGCurrentProgramPosterTileAppearance() throws InterruptedException, ParseException {
		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyTileAppearance("CURRENT");
	}

	/**
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 *             Test case verify the Mini-EPG Future program poster tile
	 *             appearance
	 */
	@Test
	public void tc_77658_MiniEPGFutureProgramPosterTileAppearance() throws InterruptedException, ParseException {
		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyTileAppearance("FUTURE");
	}

	/**
	 * 
	 * Test Case verify Mini EPG from Zap List on CUTV Enabled Channel
	 * @throws InterruptedException
	 */
	@Test
	public void tc_77664_mini_epg_On_Zaplist_CUTVEnabledChannel() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyMiniEPGOnZapList_CUTVEnabledChannel();
		
	}
	/**
	 * Test Case verify Mini EPG from Zap List on CUTV Disabled Channel
	 * @throws InterruptedException
	 */
	@Test
	public void tc_77665_mini_epg_On_Zaplist_CUTVDisabledChannel() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyMiniEPGOnZapList_CUTVDisabledChannel();
		
	}
	
	
	/**
	 *  Test cases is used to verify past program details screen in Mini EPG
	 * @throws InterruptedException
	 */
	
	@Test
	public void tc_77680_A_Min_EPG_Access_Details_Screen() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.validateMiniEPGAccessToPastProgramDetails();
	}
	/**
	 * Test cases is used to invoke epg guide by navigate to far-east on Mini EPG Screen
	 * @throws InterruptedException
	 */
	@Test
	public void tc_77676_mini_epg_right_side_tv_guide_tile() throws InterruptedException
	{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyMiniEPGTVGuide();
	}
	
	/**
	 * This test cases is used to access future program details screen on Mini EPG
	 * @throws InterruptedException
	 */
	
	@Test
	public void tc_77680_B_Min_EPG_Access_Details_Screen() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.validateMiniEPGAccessToFutureProgramDetails();
	}
	/**
	 * Test cases is used to verify blacklist program info screen on CUTV Channel 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_77680_D_Min_EPG_Access_Details_Screen() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.validateMiniEPGAccessToNonWatchedCUTVBlackListProgramDetails();
	}
	/**
	 * Test cases is used to verify non- blacklist program info screen on CUTV Channel 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_77680_E_Min_EPG_Access_Details_Screen() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.validateMiniEPGAccessToNonWatchedCUTVNonBlackListProgramDetails();
	}
	/**
	 * Test cases is used to verify current program info screen on CUTV Channel 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_77680_C_Min_EPG_Access_Details_Screen() throws InterruptedException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.validateMiniEPGAccessToNonWatchedCUTVCurrentProgramDetails();
	}

	/**
	 * test cases is used to invoke Mini EPG screen by playing CUTV playout program started 32 hrs ago
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	
	@Test
	public void tc_77674_Mini_EPG_On_CUTV_long_finished_airing() throws InterruptedException, ParseException{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyMiniEPGonLongFinishedCUTV();
	}
	/**
	 * Test cases is used to verify details on current tile in Mini EPG Screen
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test
	public void tc_77656_Mini_EPG_Video_tile_appearance() throws InterruptedException, ParseException
	{
		miniEPGScreen = new MiniEPGScreen(driver);	
		miniEPGScreen.verifyTileAppearance("CURRENT");
	}
	
	/**
	 * Test cases is used to verify past tile appearance
	 */
	@Test
	public void tc_77659_Mini_EPG_Past_tile_appearance() throws InterruptedException, ParseException
	{
		miniEPGScreen = new MiniEPGScreen(driver);
		miniEPGScreen.verifyTileAppearance("PAST");
	}

	
    @Test
	public void tc_Mini_EPG_Mini_CUTV_enabled_channel_PartI() throws InterruptedException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPGMiniEPGonzaplistNottunedCUTVenabledchannel();
	 }
		
	
	 @Test
	public void tc_Mini_EPG_Mini_CUTV_enabled_channel_PartII() throws InterruptedException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen. miniEPGMiniEPGonzaplistNottunedCUTVenabledchannel_partII();
	 }
	 
	 @Test
	public void tc_Mini_EPG_Mini_CUTV_enabled_channel_PartIII() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPGMiniEPGonzaplistNottunedCUTVenabledchannel_partIII();
	 }
	 
	 
	 @Test
	 public void tc_77677_A_Mini_EPG_Long_stays_in_Program_Details_screen() throws InterruptedException, ParseException
	 {
		 
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.verifyLongStayInProgramDetailsScreen();
	 }
	 @Test
	 public void tc_77677_B_Mini_EPG_Long_stays_in_Program_Details_screen() throws InterruptedException, ParseException
	 {
		 
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.verifyStayinFutureProgramDetailsScreen();
	 }
	 
	 @Test
	 public void tc_77661_Mini_EPG_Behaviour_Live_TV_On_CUTVDisabledChannel() throws InterruptedException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.verifyMiniEPGBehaviourOnCUTVDisabledChannel();
	 }
	 @Test
	 public void tc_77673_Mini_EPG_Lifespan_scheduled_recording() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.verifyMiniEPGLifeSpanOfScheduledRecording();
	 }
	 @Test
	 public void tc_77663_MiniEPGEvolutionLiveProgramEndsWhileNavigatingMiniEPG()throws InterruptedException, ParseException 
	 {

		 MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.validateMiniEpgprogramAfterProgramEnded();

	 }

	 @Test
	 public void tc_77667_mini_EPGMini_EPGonzaplist_NottunedCUTVdisabled() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPGMiniEPGonzaplistNottunedCUTVdisabledchannel();
	 }

	 
	 @Test
	 public void tc_77667_mini_EPGMini_EPGonzaplist_NottunedCUTV_PartII() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPGMiniEPGonzaplistNottunedCUTVdisabledchannelPartII();
	 }
    
	 
	 @Test
	 public void tc_77669_MiniEPG_finishedairingCUTV() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPGMiniEPGTSTVfinishedAiringCUTVdisabledChannel_PartI();
	 }
	 
	 @Test
	 public void tc_77669_MiniEPG_finishedairingCUTV_PartII() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPGMiniEPGTSTVfinishedAiringCUTVdisabledChannel_PartII();
	 }
	 
	 


	 @Test
	 public void tc_77668_Mini_EPG_TSTV_ongoingAiring_CUTVenabledchannel() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPG_ongoingAiring_CUTVenabledchannel();
	 }

	 
	 
	 @Test
	 public void tc_77668_Mini_EPG_TSTV_ongoingAiring_CUTVenabledchannel_PartII() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPG_ongoingAiring_CUTVenabledchannel_partII();
	 }
	 
	 
	 //Moving back to the current program previous program, restarting the same, return to zaplist , confirmation message should appear in the zaplist
	 
	 @Test
	 public void tc_77671_Mini_EPG_CUTV_ongoingAiring() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.mini_EPG_CUTV_ongoingAiring();
		 
	 }
	 
	 
	 //This test case is checking the successor program title after navigating in the Miniepg screen until the current program ends
	 
	 @Test
	 public void tc_77671_Mini_EPG_CUTV_ongoingAiring_PartII() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.mini_EPG_CUTV_ongoingAiring_PartII();
		 
	 }
	 
	 @Test
	 public void tc_77670_MiniEPG_longfinishedairing_disabledchannel_PartI() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPG_TSTV_longfinishedairing_CUTVdisabledhannel();
		 
	 }
	 
	 @Test
	 public void tc_77670_MiniEPG_longfinishedairing_disabledchannel_PartII() throws InterruptedException, ParseException
	 {
		 miniEPGScreen = new MiniEPGScreen(driver);
		 miniEPGScreen.miniEPG_TSTV_longfinishedairing_CUTVdisabledhannel_PartII();
		 
	 }
}

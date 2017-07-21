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
		 * This test cases is used to verify Zap Screen from Live TV.
		 * Created By Rahul Dhoundiyal
		 */
		@Test
		public void tc_Mini_EPG_Full_Scree_TV_ZapBanner() throws InterruptedException
		{
			miniEPGScreen = new MiniEPGScreen(driver);
			DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
			dtvChannel.openLiveTV();
			miniEPGScreen.launchAndVerifyMiniEpgScreen();
			reports.log(LogStatus.PASS, "Wait for 10 sec Zap banner should dismissed and navigate to LiveTv");
			Thread.sleep(10000);
			driver.switchTo().defaultContent();
			try
			{
				if(miniEPGScreen.headerText.isDisplayed()){
					FailTestCase("Zap banner not getting dismissed");
				}
			}
			catch(NoSuchElementException ex)
			{
				reports.log(LogStatus.PASS, "Zap Banner Getting Dismissed and navigate to live TV");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		}
		
		/**
		 * This test cases is used to verify mini epg long finished airing episode.
		 * Created By Rahul Dhoundiyal
		 */
		@Test
		public void tc_mini_epg_on_tstv() throws InterruptedException, ParseException{
			
			EpgScreen epgScreen = new EpgScreen(driver);
			epgScreen.goToEpgChannelScreen(true);
			miniEPGScreen = new MiniEPGScreen(driver);
			miniEPGScreen.verifyMiniEPG_long_finished_airing();	
		}

		/**
		 * @throws NumberFormatException
		 * @throws InterruptedException
		 * test case verify the Mini-EPG Behaviour from Full-screen Live TV on CUTV Channel
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
		 * test case verify Mini-EPG Behaviour from Full-screen Live TV on CUTV Channel_A
		 */

		@Test
		public void tc_77655_A_Mini_EPGBehaviourFromFull_screenLiveTV_onCUTVChannel()
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
		 * test case verify Mini-EPG Behaviour from Full-screen Live TV on CUTV Channel_B
		 */
		@Test
		public void tc_77655_B_Mini_EPGBehaviourFromFull_screenLiveTV_onCUTVChannel()
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
		 * test case verify Mini-EPG Full-screen live TV with zapbanner
		 */
		@Test
		public void tc_77662_MiniEPG_FullScreenLiveTV_withZapbanner() throws InterruptedException {

			DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
			dtvChannel.openLiveTV();
			dtvChannel.tuneToChannel(
					Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));

			reports.log(LogStatus.PASS, "Navigate the Zap banner and validation");
			TestInitization.sendKeySequence("UP", 2000, "zaplijst");
			reports.attachScreenshot(captureCurrentScreenshot());

			reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
			TestInitization.sendKeySequence("LEFT", 2000, "televisie");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		/**
		 * 
		 * 
		 * @throws InterruptedException
		 * @throws IOException
		 * Test case verify the Mini-EPG Instant recording on watched channel
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
			reports.attachScreenshot(captureCurrentScreenshot());

			// Forcible move to live TV and move to again Mini EPg screen
			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			TestInitization.sendKeySequence("LEFT", 0, "televisie");
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
			reports.attachScreenshot(captureCurrentScreenshot());

			miniEpg.navigateToMiniEpgAndValidateObject(miniEpg.onGoingRecordingIcon, "On Going recording icon ");

			// wait for 5 second to close miniEog automatically
			Thread.sleep(5000);

			miniEpg.stopLiveTVRecording();

			reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
			TestInitization.sendKeySequence("LEFT", 1000, "televisie");
			reports.attachScreenshot(captureCurrentScreenshot());
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
		 * Test case verify the Mini-EPG Left-side tv-guide tile
		 */
		@Test
		public void tc_77679_MiniEPG_Left_side_tv_guideTile() throws InterruptedException {

			DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);
			MiniEPGScreen miniEpgScreen = new MiniEPGScreen(driver);

			dtvChannel.openLiveTV();

			reports.log(LogStatus.PASS, "Navigate the Zap banner and validation");
			TestInitization.sendKeySequence("UP", 2000, "zaplijst");
			reports.attachScreenshot(captureCurrentScreenshot());

			reports.log(LogStatus.PASS, "Navigate the CUTV disabled channel");
			sendNumaricKeys(
					Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
			Thread.sleep(2000);
			reports.attachScreenshot(captureCurrentScreenshot());

			reports.log(LogStatus.PASS, "Navigate the MiniEpg screen and validation");
			TestInitization.sendKeySequence("LEFT", 2000, "televisie");
			reports.attachScreenshot(captureCurrentScreenshot());

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
		 * Test case verify the Mini-EPG Current program poster tile appearance
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
		 * Test case verify the Mini-EPG Future program poster tile appearance
		 */
		@Test
		public void tc_77658_MiniEPGFutureProgramPosterTileAppearance() throws InterruptedException, ParseException {
			MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
			miniEPGScreen.verifyTileAppearance("FUTURE");
		}

		public void tc_77663_MiniEPGEvolutionLiveProgramEndsWhileNavigatingMini_EPG() throws InterruptedException, ParseException{
			
			MiniEPGScreen  miniEPGScreen = new MiniEPGScreen(driver);
			miniEPGScreen.validateMiniEpgprogramAfterProgramEnded();
			
		}
}

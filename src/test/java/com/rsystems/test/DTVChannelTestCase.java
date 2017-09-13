package com.rsystems.test;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.representer.Represent;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository.ZapListPage;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.MiniEPGScreen;
import com.rsystems.pages.Pvr;
import com.rsystems.pages.RentMovie;
import com.rsystems.pages.VodFeatures;
import com.rsystems.pages.ZapList;
import com.rsystems.utils.PackageInformation;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

import APIs.STBAPIs;

public class DTVChannelTestCase extends TestInitization {

	/**
	 * @throws InterruptedException
	 *             Test case validate the info banner in live TV screen
	 */

	@Test
	public void tc_BCDTVDT0105_DTVChannelInfobanner() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.openLiveTV();

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);

		driver.switchTo().frame(getCurrentFrameIndex());

		isDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.programDurationIn_Infobar, "program duration");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.programTitle, "Program title");

		// Now wit for 5 second to hide the info banner
		Thread.sleep(5000);

		isNotDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		isNotDisplayed(dtvChannelScreen.programDurationIn_Infobar, "program duration");
		isNotDisplayed(dtvChannelScreen.programTitle, "Program title");

	}

	/**
	 * @throws InterruptedException
	 *             Test case open the live TV and validate the corresponding
	 *             channel number
	 */

	@Test
	public void tc_BCDTVDT0106_DTV_ChannelZapViaChannelNumberExisting() throws InterruptedException {

		String pressChannelNumber = "5";

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Press a channel number which is available");
		sendKeyMultipleTimes("NUMPAD5", 1, 4000);
		handlePopupIfExist();
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());

		String ActualChannelNo = dtvChannelScreen.chnlNoIn_Infobar.getText();
		if (ActualChannelNo.equalsIgnoreCase(pressChannelNumber)) {
			reports.log(LogStatus.PASS, "Verification of Channel ZapVia Channel Number Existing Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}

		else {
			FailTestCase("Verification of Channel ZapVia Channel Number Existing Failed Actual Channel: "
					+ ActualChannelNo + "and expected : " + pressChannelNumber);
		}
	}

	/**
	 * @throws InterruptedException
	 *             Press a channel number which is not available in list also
	 *             validate the Zap list
	 * 
	 */

	@Test
	public void DTV_ChannelZapViaChannelNumberNotExisting() throws InterruptedException {

		ZapList zapList = new ZapList(driver);
		new DTVChannelScreen(driver).openLiveTV();

		reports.log(LogStatus.PASS, "Press a channel number which is NOT available");
		sendNumaricKeys(321);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());

		Thread.sleep(2000);
		/** Verify the zap list */
		driver.switchTo().frame(getCurrentFrameIndex());
		String actualFocousChannel = zapList.focousChannelNumber.getText();

		if (actualFocousChannel
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "ExpectedFocousChannel", "Values"))) {
			reports.log(LogStatus.PASS, "Page Successfully move to zaplist page");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}

		else {
			FailTestCase("Unable to move zaplist page " + " Expected Focus channel : "
					+ TestInitization.getExcelKeyValue("DTVChannel", "ExpectedFocousChannel", "Values")
					+ "Actual Focus Channel : " + actualFocousChannel);

		}
	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the functionality of CH+/CH- and first and
	 *             last channel
	 */

	@Test
	public void DTV_Channel_Zap_Via_Up_Down() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		int currentChannelNo = Integer.parseInt(dtvChannelScreen.chnlNoIn_Infobar.getText());

		// Channel up and validation
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS, (currentChannelNo + 1) + "",
				"Navigate Screen to next channel");
		// Channel down and validation
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_CHANNEL_MINUS, (currentChannelNo) + "",
				"Navigate Screen to previous channel");

		// Go to first channel
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "FirstChannelNumber", "Values"))));

		Thread.sleep(1000);

		// Check last channel of Live TV
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_CHANNEL_MINUS,
				TestInitization.getExcelKeyValue("DTVChannel", "LastChannelNumber", "Values"),
				"Navigate Screen to last channel");

		// Check the first Channel Number
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS,
				TestInitization.getExcelKeyValue("DTVChannel", "FirstChannelNumber", "Values"),
				"Navigate Screen to First channel");

	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the HD and SD channel
	 */

	@Test
	public void tc_BCDTVDT0110_DTV_HD_SD_Zap() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.openLiveTV();
		// Change channel to HD and validation

		reports.log(LogStatus.PASS, "Navigate to HD channel");
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "HDChannelNumber", "Values"))));
		reports.attachScreenshot(captureCurrentScreenshot());

		// validate live TV has been move to HD channel
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(dtvChannelScreen.hdIcon, "HD Icon");

		reports.log(LogStatus.PASS, "Navigate to SD channel");
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "SDChannelNumber", "Values"))));
		reports.attachScreenshot(captureCurrentScreenshot());

		// validate live TV has been move to HD channel
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		isNotDisplayed(dtvChannelScreen.hdIcon, "HD Icon");

	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the ZAP banner item [Channel Logo ,
	 *             channel number] After changing the channel number using RC
	 */

	@Test
	public void DTVZAP002ZappinginFullscreenDTVShowinfoonzapsettingYES() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.openLiveTV();

		driver.switchTo().frame(getCurrentFrameIndex());
		// channel plus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS);

		// channel Minus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_CHANNEL_MINUS);

		// change channel and check again
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "HDChannelNumber", "Values"))));

		// channel plus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS);

		// channel Minus and validation
		dtvChannelScreen.changeChnlAndInfoBannerValidation(Unicode.VK_CHANNEL_MINUS);

	}

	/**
	 * @throws InterruptedException
	 *             Test case validate the functionality of pause and play from
	 *             RC
	 */

	@Test
	public void pause_LiveTV_play() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(5000);
		dtvChannelScreen.pressPlayButtonAndValidation();

	}

	/**
	 * @throws InterruptedException
	 *             test case validate the functionality of pause and play in
	 *             back to live page
	 */

	@Test
	public void pause_LiveTV_PLTV_BackToLive() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Navigate to DTV Screen");
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Changed channel to 1");
		TestInitization.sendNumaricKeys(1);
		handlePopupIfExist();

		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Navigate to action list");
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		try {

			if (!dtvChannelScreen.backToLive.isDisplayed()) {
				// code when pause functionality is working
			}
		}

		catch (NoSuchElementException e) {

			// Back to live button is not displayed on webpage
			reports.log(LogStatus.PASS, "Click on Pause button");
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 3000);
			reports.attachScreenshot(captureCurrentScreenshot());

			driver.switchTo().frame(getCurrentFrameIndex());
			String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
			String[] currentImgToArr = currentImgSource.split("/");
			String imageName = currentImgToArr[(currentImgToArr.length) - 1];
			if (imageName.equalsIgnoreCase(
					TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
				reports.log(LogStatus.PASS, "Pause Sucessfully");
				reports.attachScreenshot(captureCurrentScreenshot());
			}

			else {
				FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
			}

			reports.log(LogStatus.PASS, "Play and Navigate to action list");
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());

			isDisplayed(dtvChannelScreen.backToLive, "Back to live TV");

		}

	}

	@Test
	public void pause_LiveTV_PLTV_cancelPopupMessage() throws InterruptedException {

		/**
		 * Pop Up functionality not implemented yet so we verify this scenario
		 * through channel number
		 * 
		 */
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Press pause button");
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Waiting for two minute for making buffer");
		// wait for 2 minute for making buffer
		Thread.sleep(120000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Press play button");
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 0);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());

		// channel change
		reports.log(LogStatus.PASS, "Navigate to another channel");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS.toString(), 1, 0);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		if (dtvChannelScreen.chnlNoIn_Infobar.isDisplayed()) {
			FailTestCase("Pop is not showing");
		}

		else {
			reports.log(LogStatus.PASS, "pop up is visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	@Test
	public void Pause_LiveTV_trickplay() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();

		reports.log(LogStatus.PASS, "Tune a channel");
		sendKeyMultipleTimes("NUMPAD2", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		// Wait for 5 minute for buffering the Live program
		Thread.sleep(30000);
		dtvChannelScreen.pressRewindButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();
	}

	@Test
	public void pause_LiveTV_PLTV_ExceedingBuffer() throws InterruptedException, ParseException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		// change to CUTV channel
		dtvChannelScreen.tuneToChannel(
				Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));

		dtvChannelScreen.pressPauseButtonAndValidation();

		Thread.sleep(3660000);

		// validate play video automatically
		String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Play successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Pause button is not highlight on webpage");
		}

	}

	/**
	 * 
	 * First Locked the PLTV package then Execute
	 * 
	 * @throws Exception
	 */

	@Test
	public void tc_Pause_LiveTV_PLTV_package_not_assigned() throws Exception {

		STBAPIs stbApis = new STBAPIs();
		try {

			stbApis.stbPackageUnAssign(new PackageInformation("Pause Live TV"));
			stbApis.stbPackageUnAssign(new PackageInformation("Pause Live TV Free"));

			DTVChannelScreen dtvScreen = new DTVChannelScreen(driver);
			dtvScreen.openLiveTV();

			reports.log(LogStatus.PASS, "Press pause button");
			dtvScreen.errorMsgValidation(Unicode.VK_PAUSE.toString(),
					TestInitization.getExcelKeyValue("ErrorMessages", "PLTV_Lock_Error_Message", "Value"));
			dtvScreen.errorMsgValidation(Unicode.VK_BACKWARD.toString(),
					TestInitization.getExcelKeyValue("ErrorMessages", "PLTV_Lock_Error_Message", "Value"));
		} finally {

			System.out.println("Running finally code");
			stbApis.stbPackageAssign(new PackageInformation("Pause Live TV"));
			stbApis.stbPackageAssign(new PackageInformation("Pause Live TV Free"));

		}
	}

	
	@Test
	public void tc_CUSUB0201_basic() throws Exception {

		// Assign basic subscription of CUTV channel
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		STBAPIs stbApis = new STBAPIs();

		// Assign old package some time old package assign with lock value so we
		// first assign and unassigns package
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));

		stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay"));
		stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay-Plus"));

		reports.log(LogStatus.PASS, "Assign only CUTV Basic package [70:TV-Replay] to Subscriber.");
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
		reports.attachScreenshot(captureCurrentScreenshot());

		dtvChannelScreen.openCutvEnableChannelFromTvGuide();

		try {
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1);
			driver.switchTo().frame(getCurrentFrameIndex());

			if (dtvChannelScreen.chnlNoIn_Infobar.isDisplayed()) {
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		}

		catch (NoSuchElementException e) {
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));
			FailTestCase("Unable to start CUTV channel.Start current program functionality not working");
		}

		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();

		reports.log(LogStatus.PASS, "Press forward button ");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
		try {
			isDisplayed(miniEPGScreen.programDetailsScreen, "Upsell message ");
		} finally {
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));
		}
	}

	@Test
	public void tc_CUSUB0202_premium() throws Exception {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		STBAPIs stbApis = new STBAPIs();
		// Some time package not assign to STB so we first assign package and
		// than unassigns according to the testing condition
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));

		stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay"));
		stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay-Plus"));

		reports.log(LogStatus.PASS,
				"Assign CUTV Basic and premium package [70:TV-Replay and 70:TV-Replay-Plus ]  to Subscriber.");
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
		reports.attachScreenshot(captureCurrentScreenshot());

		dtvChannelScreen.openLiveTV();
		dtvChannelScreen.tuneToChannel(Integer.parseInt(
				TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_2", "Values")));
		String programTitleInEpg = dtvChannelScreen.navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 2, 4000);
		handlePopupIfExist();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1);
		driver.switchTo().frame(getCurrentFrameIndex());
		String titleInInfoBanner = dtvChannelScreen.programTitle.getText();

		if (!programTitleInEpg.equalsIgnoreCase(titleInInfoBanner)) {
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1);
			FailTestCase("Channel Info banner is not updated. Title from EPG : " + programTitleInEpg
					+ " program title in Info banner " + titleInInfoBanner);
		}

		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();
		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();

		reports.log(LogStatus.PASS, "Navigate to action list screen.");
		TestInitization.sendKeySequence("ENTER", 1000, "televisie");

		isDisplayed(dtvChannelScreen.backToLive, "Back to live option");

		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
	}

	




	/**
	 * This test cases is verify back to live option in past program
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_CUBTL0602_back_to_live_other_channel() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.verifyBackToLiveOption();
	}

	/**
	 * This test cases is used to watch start over past program
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_CUSO0504_start_over_watch_past_program() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.verifyStartOverPastProgram();
	}

	/**
	 * This test cases is used to back to live same channel
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_CUBTL0601_back_to_live_same_channel() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.verifyBackToLiveOptionOnSameChannel();
	}

	/**
	 * This test cases is used to verify action item list in past,
	 * future,current program details
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_CUSO0501_start_over_list_actions() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.verifyActionItemList();
	}

	/**
	 * This test cases is used to watch already watched past program
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_CUSO0505_start_over_watch_started_program() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.verifyStartOverWatchStartedProgram();
	}

	/**
	 * @author Pritam.Dutta This test cases is used to Press PAUSE while in
	 *         LiveTV (test it with all possible background load, like: record
	 *         on-going on another channel, load of a broker document, etc&.)
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_Pause_LiveTV_PLTV_pause() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.pause_LiveTV_PLTV_pause();
	}

	/**
	 * @author Pritam.Dutta This test cases is used to Check Timeshifting on hdd
	 *         less STB. Keep STB in timeshift mode for few hours and check how
	 *         it performs.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_HDD_Less_Timeshifting() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.hdd_Less_Timeshifting();
	}



	/**
	 * @author Pritam.Dutta This test cases is used to 'Go to any possible menu
	 *         while Time shifting.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void tc_Pause_LiveTV_PLTV_interworking_with_menu() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.Pause_LiveTV_PLTV_interworking_with_menu();

	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws Exception
	 * 
	 */

	@Test
	public void tc_CUSUB0205_basic_premium_switch() throws Exception {

		tc_CUSUB0201_basic();
		tc_CUSUB0202_premium();
	}

	@Test
	public void tc_CUSUB0203_no_subscription() throws Exception {

		STBAPIs stbApis = new STBAPIs();
		try {

			DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
			MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);
			// Some time package not assign to STB so we first assign package
			// and
			// than unassigns according to the testing condition
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));

			reports.log(LogStatus.PASS, "UnAssign All CUTV package from Subscribe [70:TV-Replay , 70:TV-Replay-Plus]");
			stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay"));
			stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay-Plus"));
			reports.attachScreenshot(captureCurrentScreenshot());

			dtvChannelScreen.openLiveTV();
			dtvChannelScreen.tuneToChannel(
					Integer.parseInt(TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
			dtvChannelScreen.navigateToPastReplaybleProgramFromTVGuide();
			driver.switchTo().frame(getCurrentFrameIndex());
			isDisplayed(miniEPGScreen.programDetailsScreen, "Upsell message ");

			sendKeyMultipleTimes("ENTER", 1, 1000);
			isNotDisplayed(miniEPGScreen.programDetailsScreen, "Upsell message ");

			sendKeyMultipleTimes("ENTER", 1, 1000);
			isDisplayed(miniEPGScreen.programDetailsScreen, "Upsell message ");

			sendKeyMultipleTimes("RIGHT", 1, 1000);
			isNotDisplayed(miniEPGScreen.programDetailsScreen, "Upsell message ");

			sendKeyMultipleTimes("ENTER", 1, 4000);
			driver.switchTo().defaultContent();
			isDisplayed(driver.findElement(By.xpath(ZapListPage.screenTitle)), "televise screen");

			// Test case pending for Unimplemented Functionality
		} finally {
			// Assign package in case of any error
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
			stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));

		}
	}

	@Test
	public void tc_CUUPS0801_upsell_page() throws Exception {

		STBAPIs stbApis = new STBAPIs();

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		MiniEPGScreen miniEPGScreen = new MiniEPGScreen(driver);

		// Some time package not assign to STB so we first assign package and
		// than unassigns according to the testing condition
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay-Plus"));

		stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay"));
		stbApis.stbPackageUnAssign(new PackageInformation("70:TV-Replay-Plus"));

		// Assign basic CUTV package
		reports.log(LogStatus.PASS, "Assign only CUTV basic [70:TV-Replay] CUTV package to subsriber ");
		stbApis.stbPackageAssign(new PackageInformation("70:TV-Replay"));

		dtvChannelScreen.openLiveTV();
		dtvChannelScreen.tuneToChannel(Integer.parseInt(
				TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_2", "Values")));
		dtvChannelScreen.navigateToPastReplaybleProgramFromTVGuide();

		sendKeyMultipleTimes("ENTER", 1, 4000);
		sendKeyMultipleTimes("ENTER", 1, 2000);
		handlePopupIfExist();

		reports.log(LogStatus.PASS, "Press forward button");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(miniEPGScreen.programDetailsScreen, "Upsell message ");

		sendKeyMultipleTimes("ENTER", 1, 4000);
		driver.switchTo().defaultContent();
		isDisplayed(driver.findElement(By.xpath(ZapListPage.screenTitle)), "televise screen");

	}
	
	@Test
	public void TP003_TSTV_Trick_play_menufromFullScreen_TV()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP003_TSTV_Trick_playmenufromFullscreen_TV();
		
	}
	@Test
	public void TP006_DTV_RC_Keys_during_Trickplay()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP006_DTV_RC_Keys_Trickplay();
		
	}
	
	@Test
	public void TP005_DTV_Trick_playmenufromFullScreen_TV()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP005_DTV_Trick_playmenufromFullscreen_TV();
		
	}
	
	@Test
	public void TP004_TSTV_RC_Keys_during_Trickplay()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP004_TSTV_RC_Keys_during_Trickplay();
		
	}
	
	
}

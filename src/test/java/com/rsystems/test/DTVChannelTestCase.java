package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.ZapList;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class DTVChannelTestCase extends TestInitization {

	@Test
	public void tc_BCDTVDT0105_DTVChannelInfobanner() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());

		isDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		isDisplayed(dtvChannelScreen.programDurationIn_Infobar, "program duration");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		isDisplayed(dtvChannelScreen.programTitle, "Program title");

		// Now wit for 5 second to hide the info banner
		Thread.sleep(5000);

		isNotDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		isNotDisplayed(dtvChannelScreen.programDurationIn_Infobar, "program duration");
		isNotDisplayed(dtvChannelScreen.programTitle, "Program title");

	}
	@Test
	public void tc_BCDTVDT0106_DTV_ChannelZapViaChannelNumberExisting() throws InterruptedException {

		String pressChannelNumber = "5";

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("NUMPAD5", 1, 4000);

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
	@Test
	public void DTV_ChannelZapViaChannelNumberNotExisting() throws InterruptedException {

		ZapList zapList = new ZapList(driver);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(321);
		Thread.sleep(2000);
		/** Verify the zap list */
		driver.switchTo().frame(getCurrentFrameIndex());
		String actualFocousChannel = zapList.focousChannelNumber.getText();

		if (actualFocousChannel
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "ExpectedFocousChannel", "Values"))) {
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			reports.log(LogStatus.PASS, "Page Successfully move to zaplist page");
		}

		else {
			FailTestCase("Unable to move zaplist page " + " Expected Focus channel : "
					+ TestInitization.getExcelKeyValue("DTVChannel", "ExpectedFocousChannel", "Values")
					+ "Actual Focus Channel : " + actualFocousChannel);

		}
	}
	@Test
	public void DTV_Channel_Zap_Via_Up_Down() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		// Get the current TV Channel number
		reports.log(LogStatus.PASS, "Navigate Live TV");
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		int currentChannelNo = Integer.parseInt(dtvChannelScreen.chnlNoIn_Infobar.getText());

		// Channel up and validation
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS, (currentChannelNo + 1) + "",
				"Screen has been move to next channel");
		// Channel down and validation
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_CHANNEL_MINUS, (currentChannelNo) + "",
				"Screen has been move to previous channel");

		// Go to first channel
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "FirstChannelNumber", "Values"))));

		Thread.sleep(1000);

		// Check last channel of Live TV
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_CHANNEL_MINUS,
				TestInitization.getExcelKeyValue("DTVChannel", "LastChannelNumber", "Values"),
				"Screen has been move to Last channel");

		// Check the first Channel Number
		dtvChannelScreen.chnlChangeAndValidation(Unicode.VK_PAGE_UP_OR_CHANNEL_PLUS,
				TestInitization.getExcelKeyValue("DTVChannel", "FirstChannelNumber", "Values"),
				"Screen has been move to First channel");

	}
	@Test
	public void tc_BCDTVDT0110_DTV_HD_SD_Zap() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Navigate Live TV");
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		// Change channel to HD and validation

		reports.log(LogStatus.PASS, "Navigate to HD channel");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "HDChannelNumber", "Values"))));

		// validate live TV has been move to HD channel
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(dtvChannelScreen.hdIcon, "HD Icon");

		reports.log(LogStatus.PASS, "Navigate to SD channel");
		reports.attachScreenshot(captureCurrentScreenshot());
		sendNumaricKeys(
				Integer.parseInt((TestInitization.getExcelKeyValue("DTVChannel", "SDChannelNumber", "Values"))));

		// validate live TV has been move to HD channel
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		isNotDisplayed(dtvChannelScreen.hdIcon, "HD Icon");

	}
	@Test
	public void DTVZAP002ZappinginFullscreenDTVShowinfoonzapsettingYES() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Navigate Live TV");
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);

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

	@Test
	public void pause_LiveTV_play() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Navigate Live TV");
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);

		reports.log(LogStatus.PASS, "Press pause button");
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		System.out.println("Image name " + imageName);

		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Play button is now highlight on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage");
		}

		Thread.sleep(5000);

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);

		currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
		currentImgToArr = currentImgSource.split("/");
		imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Pause button is now highlight on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Pause button is not highlight on webpage");
		}

	}
	@Test
	public void pause_LiveTV_PLTV_BackToLive() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Navigate to DTV Screen");
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Changed channel to 1");
		TestInitization.sendNumaricKeys(1);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Navigate to action list");
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		try {

			if (!dtvChannelScreen.backToLive.isDisplayed()) {
				// code when pause functionality is working
			}
		}

		catch (Exception e) {

			// Back to live button is not displayed on webpage
			reports.log(LogStatus.PASS, "Click on Pause button");
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
			isDisplayed(dtvChannelScreen.pauseAndPlayImg, "Play button");
		}

	}
}

package com.rsystems.pages;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class MiniEPGScreen extends TestInitization {

	WebDriver driver;

	public MiniEPGScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.HubScreen.headerElement)
	public WebElement headerText;

	@FindBy(how = How.ID, using = ObjectRepository.MiniEPGScreen.headerTimeElement)
	public WebElement headerTime;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.currentEpisodeElement)
	public WebElement currentEpisode;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.activeZapBlockElement)
	public WebElement activeZapBlock;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.highligheVideotitle)
	public WebElement highligheVideotitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.videoPlayer)
	public WebElement videoPlayer;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.highlightVideoLeftTitle)
	public WebElement highlightVideoLeftTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.highlightVideoRightTitle)
	public WebElement highlightVideoRightTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.activeTileProgramTime)
	public WebElement activeTileProgramTime;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.activeTileHeading)
	public WebElement activeTileHeading;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.onGoingRecordingIcon)
	public WebElement onGoingRecordingIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.currentChannelNumber)
	public WebElement currentChannelNumber;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.cuTVIcon)
	public WebElement cutvIcon;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.miniEPGCurrentChannelName)
	public WebElement miniEPGChannelName;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.miniEPGCurrentEpisodeDuration)
	public WebElement miniEPGEpisodeDuration;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.epgGuideElement)
	public WebElement epgGuide;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.miniEPGChannelNumber)
	public WebElement miniEPGChannelNumber;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.videoPlayer)
	public WebElement miniEPGVideoPlayer;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.progressBar)
	public WebElement miniEPGProgressBar;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.cutvIconZapScreen)
	public WebElement cutvIconZapScreen;

	@FindBy(how = How.CLASS_NAME, using = "dayHeading")
	public WebElement dayHeading;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.recordingIconMiniEpg)
	public WebElement recordingIconMiniEpg;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)
	public WebElement cutvIconMiniEPG;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.hdratingIcon)
	public WebElement hdratingIconMiniEpg;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.textWithDurationInEPG)
	public WebElement textWithDurationInEPG;

	public void launchDTV(boolean hotKey) throws InterruptedException {
		if (hotKey) {
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		} else {
			TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		}
		Thread.sleep(1000);
		reports.log(LogStatus.PASS, "Tuned to LiveTv");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	}

	public void launchAndVerifyMiniEpgScreen() throws InterruptedException {
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		reports.log(LogStatus.PASS, "Zapping screen getting displayed");
		driver.switchTo().defaultContent();
		System.out.println(headerText.getText());
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Initial Focus should be on In Progress Program");
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "InProgress", "name_nl"))) {
			reports.log(LogStatus.PASS, "In Progress program is active");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("In Progress program is not active");
		}
		reports.log(LogStatus.PASS, "Previous Program tile should be on Left Side");
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl"))) {
			reports.log(LogStatus.PASS, "Previous program is on Left Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Previous program tile is not on left side");
		}
		reports.log(LogStatus.PASS, "Future Program tiles should be on Right Side");
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Future", "name_nl"))) {
			reports.log(LogStatus.PASS, "Future program is on Right Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Future program tile is not on right side");
		}
	}

	public void verifyMiniEPG_long_finished_airing() throws ParseException, InterruptedException {
		long minBufferTime = 0;
		int first8Channel = 8;
		HashMap<Integer, Long> channelTiming = new HashMap<Integer, Long>();
		EpgScreen epgScreen = new EpgScreen(driver);
		ArrayList<String> episodeName = new ArrayList<String>();
		ArrayList<String> episodeTiming = new ArrayList<String>();
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		for (int i = 1; i <= first8Channel; i++) {
			driver.switchTo().frame(getCurrentFrameIndex());
			Date episodeTime = sdf.parse(epgScreen.focusElementProgramTime.getText().split(" ")[2].trim());
			System.out.println(epgScreen.focusElementProgramTime.getText().split(" ")[2].trim());
			episodeName.add(epgScreen.focusElemntInEpg.getText());
			episodeTiming.add(epgScreen.focusElementProgramTime.getText().trim());
			System.out.println(epgScreen.focusElemntInEpg.getText());
			driver.switchTo().defaultContent();
			Date currentTime = sdf.parse(headerTime.getText().split(" ")[4].trim());
			System.out.println(headerTime.getText().split(" ")[4].trim());
			long diff = episodeTime.getTime() - currentTime.getTime();
			long diffSec = diff / 1000;
			minBufferTime = diffSec / 60;
			if (minBufferTime > 3 && minBufferTime < 55) {
				channelTiming.put(i, minBufferTime);
			}
			sendKeyMultipleTimes("DOWN", 1, 2000);
		}
		System.out.println(channelTiming);
		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : channelTiming.keySet()) {
			Long value = channelTiming.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}
		if (channelKeyWithMinBuffer != 0) {
			System.out.println(channelKeyWithMinBuffer);
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			Thread.sleep(1000);
			sendNumaricKeys(channelKeyWithMinBuffer);
			reports.log(LogStatus.PASS, "Navigate to Channel with minium buffer time left -" + channelKeyWithMinBuffer);
			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
			Thread.sleep(1000);
			reports.log(LogStatus.PASS,
					"Click on Pause button to start buffering on" + episodeName.get(channelKeyWithMinBuffer - 1));
			sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
			driver.switchTo().frame(getCurrentFrameIndex());
			String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
			String[] currentImgToArr = currentImgSource.split("/");
			String imageName = currentImgToArr[(currentImgToArr.length) - 1];
			if (imageName.equalsIgnoreCase(
					TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
				reports.log(LogStatus.PASS, "Play button is now highlight on webpage");
				reports.attachScreenshot(captureCurrentScreenshot());
			}

			else {
				FailTestCase("Play button is not highlight on webpage. Might be Video is not playing in this channel");
			}
			Thread.sleep(60000);
			reports.log(LogStatus.PASS,
					"Click on Play button to start video on " + episodeName.get(channelKeyWithMinBuffer - 1));
			sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
			long waitTime = (channelTiming.get(channelKeyWithMinBuffer) * 60000) - 180000 - 10000;
			System.out.println(waitTime);
			reports.log(LogStatus.PASS, "Wait to complete the epsiode");
			Thread.sleep(waitTime);
			reports.log(LogStatus.PASS, "Shift Time backwards for some time");
			sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
			Thread.sleep(120000);
			reports.log(LogStatus.PASS, "Click on Play button to start video again");
			sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
			reports.attachScreenshot(captureCurrentScreenshot());
			reports.log(LogStatus.PASS, "Launch Mini EPG");
			sendKeyMultipleTimes("RIGHT", 1, 500);
			reports.attachScreenshot(captureCurrentScreenshot());
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(currentEpisode.findElement(By.tagName("h2")).getText());
			if (currentEpisode.findElement(By.tagName("h2")).getText()
					.equalsIgnoreCase(episodeName.get(channelKeyWithMinBuffer - 1))
					&& currentEpisode.findElement(By.cssSelector(".media-content p")).getText()
							.equalsIgnoreCase(episodeTiming.get(channelKeyWithMinBuffer - 1))) {
				reports.log(LogStatus.PASS, "Expected Episode -" + episodeName.get(channelKeyWithMinBuffer - 1)
						+ " Actual Episode :-" + currentEpisode.findElement(By.tagName("h2")).getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Test Cases is failed Expected Episode -" + episodeName.get(channelKeyWithMinBuffer - 1)
						+ " Actual Episode :-" + currentEpisode.findElement(By.tagName("h2")).getText()
						+ " And Expected Episode Time Duration : " + episodeTiming.get(channelKeyWithMinBuffer - 1)
						+ "Actual Episode Time Duration is "
						+ currentEpisode.findElement(By.cssSelector(".media-content p")).getText());
			}
		} else {
			reports.log(LogStatus.PASS, "Buffer Time is greater than 1 hr for first 8 channel");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	// My function
	public void navigateToMiniEpgAndValidationTV_Gids() throws InterruptedException {

		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");

		navigateToMiniEpgAndValidateObject(highligheVideotitle, "Active tile title ");
		navigateToMiniEpgAndValidateObject(videoPlayer, "Active tile video player ");
		navigateToMiniEpgAndValidateObject(highlightVideoLeftTitle, "Left tile title ");
		navigateToMiniEpgAndValidateObject(highlightVideoRightTitle, "Right tile title ");

		reports.log(LogStatus.PASS, "Validate Left-far Tile is tv-gids");
		validateFirstOrRightTile("LEFT", "tv-gids", 30);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Validate Right-far Tile is tv-gids");
		validateFirstOrRightTile("RIGHT", "tv-gids", 50);
		reports.attachScreenshot(captureCurrentScreenshot());

	}

	public void navigateToMiniEpgAndValidationTV_GidsTileCount() throws InterruptedException {

		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");

		// Store the left tile time
		TestInitization.sendKeySequence("LEFT", 1000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());
		String previousToLiveTileTime = activeTileProgramTime.getText();

		TestInitization.sendKeySequence("RIGHT", 0, "televisie");

		driver.switchTo().frame(getCurrentFrameIndex());

		reports.log(LogStatus.PASS, "Navigate the left tile");
		String currentTimeTileTime = activeTileProgramTime.getText();
		TestInitization.sendKeySequence("LEFT", 1000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());

		if (currentTimeTileTime.contentEquals(activeTileProgramTime.getText())) {
			FailTestCase("previous to Live tile currently not in focous");
		}

		int maxLeftCount = Integer
				.parseInt(TestInitization.getExcelKeyValue("MiniEPGScreen", "LeftProgramCountTillTvGuide", "name_nl"));
		reports.log(LogStatus.PASS, "Validate tv-guide in left " + maxLeftCount);

		maxLeftCount = maxLeftCount + 1;
		int count = 0;
		while (maxLeftCount > 0) {

			if (activeTileHeading.getText().contentEquals("tv-gids")) {
				reports.log(LogStatus.PASS, "TV guide found on after press " + count + " LEFT key");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			maxLeftCount--;
			count++;
		}

		if (!(maxLeftCount == 1)) {
			FailTestCase("tv-gids is not found in after press "
					+ TestInitization.getExcelKeyValue("MiniEPGScreen", "LeftProgramCountTillTvGuide", "name_nl")
					+ " left");
		}

		maxLeftCount = Integer
				.parseInt(TestInitization.getExcelKeyValue("MiniEPGScreen", "LeftProgramCountTillTvGuide", "name_nl"));
		reports.log(LogStatus.PASS, "Navigate to previous to Live tile");
		TestInitization.sendKeyMultipleTimes("RIGHT", maxLeftCount, 1000);
		assertEquals(activeTileProgramTime.getText(), previousToLiveTileTime);
		reports.attachScreenshot(captureCurrentScreenshot());

		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");

		driver.switchTo().frame(getCurrentFrameIndex());
		reports.log(LogStatus.PASS, "Navigate the next to live program");
		currentTimeTileTime = activeTileProgramTime.getText();
		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());

		// Forcibly move to live screen and again move next to Live TV
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 2, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());

		if (currentTimeTileTime.contentEquals(activeTileProgramTime.getText())) {
			FailTestCase("Next to Live tile currently not in focous");
		}

		int maxRightCount = Integer
				.parseInt(TestInitization.getExcelKeyValue("MiniEPGScreen", "RightProgramCountTillTvGuide", "name_nl"));
		count = 0;
		maxRightCount = maxRightCount + 1;
		while (maxRightCount > 0) {

			if (activeTileHeading.getText().contentEquals("tv-gids")) {
				reports.log(LogStatus.PASS, "TV guide found on after press " + count + " RIGHT key");
				break;
			}
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			count++;
			maxRightCount--;
		}

		if (!(maxRightCount == 1)) {
			FailTestCase("tv-gids is not found in after press "
					+ TestInitization.getExcelKeyValue("MiniEPGScreen", "RightProgramCountTillTvGuide", "name_nl")
					+ " right");
		}

		reports.log(LogStatus.PASS, "TV-gids tile active now");
		reports.attachScreenshot(captureCurrentScreenshot());

	}

	public void navigateToMiniEPGAndWaitForLiveTV() throws InterruptedException {

		DTVChannelScreen dtvChannel = new DTVChannelScreen(driver);

		Thread.sleep(10000);

		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);

		isDisplayed(dtvChannel.chnlNoIn_Infobar, "Channel number ");
	}

	public void navigateToMiniEpgAndValidateObject(WebElement we, String objectName) throws InterruptedException {

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(we, objectName);

	}

	public void validateFirstOrRightTile(String keyToPress, String tilenameToValidate, int maxKeyPressCount)
			throws InterruptedException {

		navigateToMiniEpgAndValidateObject(activeTileHeading, "Active tile title ");
		int count = 0;
		while (maxKeyPressCount > 0) {

			if (activeTileHeading.getText().contentEquals(tilenameToValidate)) {
				reports.log(LogStatus.PASS, tilenameToValidate + " found after press " + count + keyToPress + "Key");
				return;
			}
			TestInitization.sendKeyMultipleTimes(keyToPress, 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			maxKeyPressCount--;
			count++;
		}

		FailTestCase("Far-" + keyToPress + " tile " + tilenameToValidate + "is not found");
	}

	public void stopLiveTVRecording() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		TestInitization.sendKeySequence("ENTER", 1000, "televisie");

		reports.log(LogStatus.PASS, "Click on stop record");
		TestInitization.sendKeySequence("DOWN,DOWN,ENTER", 1000, "televisie");

		reports.log(LogStatus.PASS, "Validation of stop recording screen");
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgScreen.displayChannelDescription, "Display channel description");

		TestInitization.sendKeySequence("ENTER", 1000, "televisie");
		reports.log(LogStatus.PASS, "Validation of stop recording has been successfully");

		dtvChannelScreen.openLiveTV();
		// press right to open mini Epg
		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());

		try {
			if (onGoingRecordingIcon.isDisplayed()) {
				FailTestCase(
						"Recording icon is already visible on webpage.Try to remove ongoing recording from channel");
			}
		} catch (NoSuchElementException e) {
			reports.log(LogStatus.PASS, "Recoding icon is not found on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		// back to live screen
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);

	}

	public void validateChannelInfofromMiniEpgTOTvGuide() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		// capture time of next channel
		TestInitization.sendKeySequence("RIGHT", 2000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());
		String programtime = activeTileProgramTime.getText();

		reports.log(LogStatus.PASS, "Open Tv guide and validation focous program");
		TestInitization.sendKeySequence("LEFT,ENTER", 2000, "televisie");

		driver.switchTo().frame(getCurrentFrameIndex());

		if (epgScreen.focusElementProgramTime.getText().contentEquals(programtime)) {
			reports.log(LogStatus.PASS, "Mini epg program time " + programtime
					+ " match with Epg screen focous program time " + epgScreen.focusElementProgramTime.getText());
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		else {

			FailTestCase("Capture time from Mini EPG is :" + programtime + "tv Guide focous program time is : "
					+ epgScreen.focusElementProgramTime.getText());
		}
	}

	public void verifyTileAppearance(String tileType) throws InterruptedException, ParseException {
		boolean checkRecordingIcon = false;
		boolean checkCUTVIcon = false;
		boolean checkHDIcon = false;
		String episodeName = null;
		HashMap<Integer, String> channelName = null;
		switch (tileType.toUpperCase()) {
		case "FUTURE":

			// Validate the current program end time match with future program
			// tile time

			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			String currentprogramEndTime = activeTileProgramTime.getText().split(">")[1];

			reports.log(LogStatus.PASS,
					"Navigate to future program and validate the current program End time match with future program strat time");
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			if (currentprogramEndTime.trim().contentEquals(activeTileProgramTime.getText().split(">")[0].trim())) {
				reports.log(LogStatus.PASS, "Current program end time match with future program start time");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Current program end time does not match with future program start time");
			}

			channelName = getFirstFutureOrPastEpisodeMiniEPG("FUTURE");
			System.out.println(channelName.toString());
			episodeName = getEpisodeDetailsFromEPG("FUTURE", channelName);

			System.out.print(episodeName);
			new DTVChannelScreen(driver).openLiveTV();
			for (Integer channelNumber : channelName.keySet()) {
				sendNumaricKeys(channelNumber);
			}
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (driver.findElement(By.className("programRecording")).getAttribute("style").contains("block")) {
				checkRecordingIcon = true;
			}
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
				checkCUTVIcon = true;
			}
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (driver.findElement(By.className("programHD")).getAttribute("style").contains("block")) {
				checkHDIcon = true;
			}
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			driver.switchTo().defaultContent();
			if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
				reports.log(LogStatus.PASS, "Press LEFT Key - Mini EPG Screen getting displayed");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press LEFT Key - Mini EPG Screen not getting displayed");
			}
			if (!headerText.getText().equalsIgnoreCase("televisie")) {
				sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			navigateToFutureOrPastTile("FUTURE", channelName);
			isDisplayed(activeTileHeading, "Episode Name on Future Tile");
			navigateToFutureOrPastTile("FUTURE", channelName);
			isDisplayed(miniEPGEpisodeDuration, "Duration on Future Tile ");
			navigateToFutureOrPastTile("FUTURE", channelName);
			isDisplayed(miniEPGChannelNumber, "Channel Number on Future Tile ");
			if (checkCUTVIcon) {
				navigateToFutureOrPastTile("FUTURE", channelName);
				isDisplayed(cutvIconMiniEPG, "CUTV Icon on Future Tile ");
			}
			if (checkHDIcon) {
				navigateToFutureOrPastTile("FUTURE", channelName);
				isDisplayed(hdratingIconMiniEpg, "HD Icon on Future Tile");
			}
			navigateToFutureOrPastTile("FUTURE", channelName);
			try {
				if (textWithDurationInEPG.getText()
						.equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Tomorrow", "name_nl"))) {
					reports.log(LogStatus.PASS, getExcelKeyValue("MiniEPGScreen", "Tomorrow", "name_nl")
							+ " getting displayed with duration");
					reports.attachScreenshot(captureCurrentScreenshot());
				}
			} catch (NoSuchElementException ex) {
				FailTestCase(getExcelKeyValue("MiniEPGScreen", "Tomorrow", "name_nl")
						+ " should be displayed with Duration");
			}
			break;
		case "CURRENT":

			String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
			new DTVChannelScreen(driver).openLiveTV();
			sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (driver.findElement(By.className("programRecording")).getAttribute("style").contains("block")) {
				checkRecordingIcon = true;
			}
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
				checkCUTVIcon = true;
			}
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			// System.out.println(driver.findElement(By.className("programHD")).getAttribute("style"));
			if (driver.findElement(By.className("programHD")).getAttribute("style").contains("block")) {
				checkHDIcon = true;
			}
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			episodeName = driver.findElement(By.className("programTitle")).getText();
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			driver.switchTo().defaultContent();
			if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
				reports.log(LogStatus.PASS, "Press LEFT Key - Mini EPG Screen getting displayed");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press LEFT Key - Mini EPG Screen not getting displayed");
			}
			if (!headerText.getText().equalsIgnoreCase("televisie")) {
				sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			verifyTilAppearancee(episodeName, checkRecordingIcon, checkCUTVIcon, checkHDIcon);
			break;
		default:
			break;
		}
	}

	private void navigateToFutureOrPastTile(String pastOrfuture, HashMap<Integer, String> channelName)
			throws InterruptedException {
		String keyEnter = null;
		if (pastOrfuture.equalsIgnoreCase("PAST")) {
			keyEnter = "LEFT";
		} else {
			keyEnter = "RIGHT";
		}
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		int channelNumber = 0;
		for (Integer key : channelName.keySet()) {
			channelNumber = key;
		}
		String duration = channelName.get(channelNumber);
		while (true) {
			sendKeyMultipleTimes(keyEnter, 1, 1000);
			System.out.println(miniEPGEpisodeDuration.getAttribute("innerText"));
			System.out.println(duration);
			if (miniEPGEpisodeDuration.getAttribute("innerText").equalsIgnoreCase(duration)) {
				break;
			}
		}

	}

	public void verifyTilAppearancee(String episodeName, boolean checkRecordingIcon, boolean checkCUTVIcon,
			boolean checkHDIcon) throws InterruptedException {
		if (episodeName != null) {
			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 2000);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeTileHeading.getText().equalsIgnoreCase(episodeName)) {
				reports.log(LogStatus.PASS, "Episode Name matched. Expected Episode Name - " + episodeName
						+ " Actual Episode Name - " + activeTileHeading.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Episode Name not matched. Expected Episode Name - " + episodeName
						+ " Actual Episode Name - " + activeTileHeading.getText());
			}
		}
		navigateToMiniEpgAndValidateObject(activeTileHeading, "Episode Name");
		navigateToMiniEpgAndValidateObject(miniEPGEpisodeDuration, "Duration");
		navigateToMiniEpgAndValidateObject(miniEPGChannelNumber, "Channel Number");
		navigateToMiniEpgAndValidateObject(miniEPGVideoPlayer, "Video Player");
		navigateToMiniEpgAndValidateObject(miniEPGProgressBar, "Progress Bar");
		if (checkRecordingIcon) {
			navigateToMiniEpgAndValidateObject(recordingIconMiniEpg, "Recording Icon");
		}
		if (checkCUTVIcon) {
			navigateToMiniEpgAndValidateObject(cutvIconMiniEPG, "CUTV Icon");
		}
		if (checkHDIcon) {
			navigateToMiniEpgAndValidateObject(hdratingIconMiniEpg, "HD Icon");
		}

	}

	private String getEpisodeDetailsFromEPG(String pastOrFuture, HashMap<Integer, String> channelName)
			throws InterruptedException {

		String keyEnter = null;
		String episodeName = null;
		EpgScreen epgScreen = new EpgScreen(driver);
		if (pastOrFuture.equalsIgnoreCase("PAST")) {
			keyEnter = "LEFT";
		} else {
			keyEnter = "RIGHT";
		}
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		int channelNumber = 0;
		for (Integer key : channelName.keySet()) {
			channelNumber = key;
			sendNumaricKeys(channelNumber);
		}
		Thread.sleep(1000);
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		while (true) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (epgScreen.focusElementProgramTime.getText().equalsIgnoreCase(channelName.get(channelNumber))) {
				episodeName = epgScreen.focusElemntInEpg.getText();
				break;
			} else {
				sendKeyMultipleTimes(keyEnter, 1, 1000);
			}
		}
		return episodeName;

	}

	private HashMap<Integer, String> getFirstFutureOrPastEpisodeMiniEPG(String futureOrPast)
			throws InterruptedException, ParseException {
		String keyEnter = null;
		String duration = null;
		if (futureOrPast.equalsIgnoreCase("PAST")) {
			keyEnter = "LEFT";
		} else {
			keyEnter = "RIGHT";
		}
		boolean channelFound = false;
		HashMap<Integer, String> channel = new HashMap<Integer, String>();
		int noOfPrograms = 10;
		for (int i = 1; i <= noOfPrograms; i++) {
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			sendNumaricKeys(i);
			Thread.sleep(1000);
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			driver.switchTo().defaultContent();
			if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
				reports.log(LogStatus.PASS, "Press RIGHT Key - Mini EPG Screen getting displayed");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press RIGHT Key - Mini EPG Screen not getting displayed");
			}
			driver.switchTo().frame(getCurrentFrameIndex());
			String prevTime = null;
			while (true) {

				prevTime = miniEPGEpisodeDuration.getText().split(" ")[0].split(":")[0].trim();

				sendKeyMultipleTimes(keyEnter, 1, 1200);
				if (miniEPGChannelName.getAttribute("innerText").equalsIgnoreCase("tv-gids")) {
					System.out.println("Tv gids found channel is not contain next day program");
					break;
				}
				duration = miniEPGEpisodeDuration.getText();

				System.out.println("Mini Epg Duration " + duration);
				if (Integer.parseInt(prevTime) >= 22) {

					int currentTime1 = Integer.parseInt(duration.split(" ")[0].split(":")[0].trim());
					int prevTileTime = Integer.parseInt(prevTime);
					System.out.println(currentTime1);
					System.out.println(prevTileTime);
					System.out.println((currentTime1 != prevTileTime));
					if ((currentTime1 != 23) && currentTime1 >= 0 && (currentTime1 != prevTileTime)) {
						channel.put(i, duration);
						reports.log(LogStatus.PASS, "Channel number found with next day episode on Mini EPG");
						reports.attachScreenshot(captureCurrentScreenshot());
						channelFound = true;
						break;
					}
				}
			}
			if (channelFound) {
				break;
			}

		}
		return channel;
	}

}
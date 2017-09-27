package com.rsystems.pages;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.lastTileInMiniEPG)
	public WebElement lastTileInMiniEPG;
	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.onGoingRecordingIcon)
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

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.programDetailsScreen)
	public WebElement programDetailsScreen;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.recordingIconOnInfo)
	public WebElement recordingIconOnInfo;

	@FindAll({ @FindBy(className = ObjectRepository.MiniEPGScreen.actionItemList) })
	public List<WebElement> actionItemList;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.activeTileHeading)
	public WebElement programTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.centerTitle)
	public WebElement centerTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.nextProgramTitle)
	public WebElement nextProgramTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.previousProgramTitle)
	public WebElement previousProgramTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.futureRecordingIcon)
	public WebElement futureRecordingIcon;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.activeMenuItemElement)
	public WebElement activeInfoMenuItem;

	@FindBy(how = How.ID, using = ObjectRepository.RcArrowKey.notificationMsg)
	public WebElement notificationMsg;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.logo)
	public WebElement logo;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.programTiming)
	public WebElement programTiming;

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
		String current = getExcelKeyValue("MiniEPGScreen", "InProgress", "name_nl");
		String previous = getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl");
		String future = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		reports.log(LogStatus.PASS, "Zapping screen getting displayed");
		driver.switchTo().defaultContent();
		System.out.println(headerText.getText());
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Initial Focus should be on In Progress Program");
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(current)) {
			reports.log(LogStatus.PASS, "In Progress program is active");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("In Progress program is not active");
		}
		reports.log(LogStatus.PASS, "Previous Program tile should be on Left Side");
		sendKeyMultipleTimes("LEFT", 3, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(previous)) {
			reports.log(LogStatus.PASS, "Previous program is on Left Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Previous program tile is not on left side");
		}
		reports.log(LogStatus.PASS, "Future Program tiles should be on Right Side");
		sendKeyMultipleTimes("RIGHT", 4, 500);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(future)) {
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
			Thread.sleep(3000);
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
			System.out.println(currentEpisode.findElement(By.className("title-animate")).getText());
			if (currentEpisode.findElement(By.className("title-animate")).getText()
					.equalsIgnoreCase(episodeName.get(channelKeyWithMinBuffer - 1))
					&& currentEpisode.findElement(By.cssSelector(".media-content p")).getText()
							.equalsIgnoreCase(episodeTiming.get(channelKeyWithMinBuffer - 1))) {
				reports.log(LogStatus.PASS, "Expected Episode -" + episodeName.get(channelKeyWithMinBuffer - 1)
						+ " Actual Episode :-" + currentEpisode.findElement(By.className("title-animate")).getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Test Cases is failed Expected Episode -" + episodeName.get(channelKeyWithMinBuffer - 1)
						+ " Actual Episode :-" + currentEpisode.findElement(By.className("title-animate")).getText()
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

		reports.log(LogStatus.PASS, "Navigate to Mini EPG");
		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");

		navigateToMiniEpgAndValidateObject(highligheVideotitle, "Active tile title ");
		navigateToMiniEpgAndValidateObject(videoPlayer, "Active tile video player ");
		reports.log(LogStatus.PASS, "Validate Left tile position");
		navigateToMiniEpgAndValidateObject(highlightVideoLeftTitle, "Left tile title ");
		reports.log(LogStatus.PASS, "Validate right tile position");
		navigateToMiniEpgAndValidateObject(highlightVideoRightTitle, "Right tile title ");

		reports.log(LogStatus.PASS, "Validate Left-far Tile is tv-gids");
		validateFirstOrRightTile("LEFT", "tv-gids", 30);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Validate Right-far Tile is tv-gids");
		validateFirstOrRightTile("RIGHT", "tv-gids", 50);
		reports.attachScreenshot(captureCurrentScreenshot());

	}

	public void navigateToMiniEpgAndValidationTV_GidsTileCount() throws InterruptedException {

		reports.log(LogStatus.PASS, "Navigate to Mini Epg Screen");
		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");

		// Store the left tile time
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String previousToLiveTileTime = activeTileProgramTime.getText();

		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);

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

			try {
				if (activeTileHeading.getText().contentEquals("tv-gids")) {
					reports.log(LogStatus.PASS, "TV guide found on after press " + count + " LEFT key");
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException e) {

				if (lastTileInMiniEPG.getText().contentEquals("tv-gids")) {
					reports.log(LogStatus.PASS, "TV guide found on after press " + count + " LEFT key");
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}

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

		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		reports.log(LogStatus.PASS, "Navigate the next to live program");
		currentTimeTileTime = activeTileProgramTime.getText();
		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());

		// Forcibly move to live screen and again move next to Live TV
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 100);
		driver.switchTo().frame(getCurrentFrameIndex());

		if (currentTimeTileTime.contentEquals(activeTileProgramTime.getText())) {
			FailTestCase("Next to Live tile currently not in focous expected next to liveTile Time : "
					+ currentTimeTileTime + " expected next to live time : " + activeTileProgramTime.getText());
		}

		int maxRightCount = Integer
				.parseInt(TestInitization.getExcelKeyValue("MiniEPGScreen", "RightProgramCountTillTvGuide", "name_nl"));
		count = 0;
		maxRightCount = maxRightCount + 1;
		while (maxRightCount > 0) {

			try {
				if (activeTileHeading.getText().contentEquals("tv-gids")) {
					reports.log(LogStatus.PASS, "TV guide found on after press " + count + " RIGHT key");

					break;
				}
			} catch (NoSuchElementException e) {

				if (lastTileInMiniEPG.getText().contentEquals("tv-gids")) {
					reports.log(LogStatus.PASS, "TV guide found on after press " + count + " RIGHT key");
					break;
				}
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
			try {
				if (activeTileHeading.getText().contentEquals(tilenameToValidate)) {
					reports.log(LogStatus.PASS,
							tilenameToValidate + " found after press " + count + " " + keyToPress + " Key");
					return;
				}
			} catch (NoSuchElementException ex) {
				if (lastTileInMiniEPG.getText().contentEquals(tilenameToValidate)) {
					reports.log(LogStatus.PASS,
							tilenameToValidate + " found after press " + count + " " + keyToPress + " Key");
					return;
				}
			}
			TestInitization.sendKeyMultipleTimes(keyToPress, 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			maxKeyPressCount--;
		}
		FailTestCase("Far-" + keyToPress + " tile " + tilenameToValidate + " is not found");
	}

	public void stopLiveTVRecording() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Press Enter on live Tile");
		TestInitization.sendKeySequence("ENTER", 1000, "televisie");

		reports.log(LogStatus.PASS, "Click on stop record");
		TestInitization.sendKeySequence("DOWN,ENTER", 1000, "televisie");

		reports.log(LogStatus.PASS, "Validation of stop recording screen");
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgScreen.displayChannelDescription, "Display channel description");

		TestInitization.sendKeySequence("ENTER", 1000, "televisie");
		reports.log(LogStatus.PASS, "Validation of stop recording has been successfully");

		dtvChannelScreen.openLiveTV();
		// press right to open mini Epg
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 100);
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

			FailTestCase("Capture time from Mini EPG is : " + programtime + " tv Guide focous program time is : "
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
				Thread.sleep(3000);
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
			Thread.sleep(2000);
			handlePopupIfExist();
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
			handlePopupIfExist();
			driver.switchTo().defaultContent();
			if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
				reports.log(LogStatus.PASS, "Press RIGHT Key - Mini EPG Screen getting displayed");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press RIGHT Key - Mini EPG Screen not getting displayed");
			}
			if (!headerText.getText().equalsIgnoreCase("televisie")) {
				sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			verifyTilAppearancee(episodeName, checkRecordingIcon, checkCUTVIcon, checkHDIcon);
			break;
		case "PAST":
			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			String currentprogramStartTime = activeTileProgramTime.getText().split(">")[0];

			reports.log(LogStatus.PASS,
					"Navigate to Past program and validate the current program Start time match with Past program end time");
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			if (currentprogramStartTime.trim().contentEquals(activeTileProgramTime.getText().split(">")[1].trim())) {
				reports.log(LogStatus.PASS, "Current program start time match with past program end time");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Current program start time does not match with past program end time");
			}
			channelName = getFirstFutureOrPastEpisodeMiniEPG("PAST");
			System.out.println(channelName.toString());
			episodeName = getEpisodeDetailsFromEPG("PAST", channelName);

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
			navigateToFutureOrPastTile("PAST", channelName);
			isDisplayed(activeTileHeading, "Episode Name on Future Tile");
			navigateToFutureOrPastTile("PAST", channelName);
			isDisplayed(miniEPGEpisodeDuration, "Duration on Future Tile ");
			navigateToFutureOrPastTile("PAST", channelName);
			isDisplayed(miniEPGChannelNumber, "Channel Number on Future Tile ");
			if (checkCUTVIcon) {
				navigateToFutureOrPastTile("PAST", channelName);
				isDisplayed(cutvIconMiniEPG, "CUTV Icon on Future Tile ");
			}
			if (checkHDIcon) {
				navigateToFutureOrPastTile("PAST", channelName);
				isDisplayed(hdratingIconMiniEpg, "HD Icon on Future Tile");
			}
			navigateToFutureOrPastTile("PAST", channelName);
			try {
				driver.switchTo().frame(getCurrentFrameIndex());
				String timeinHr = miniEPGEpisodeDuration.getText().split(" ")[0].split(":")[0];
				if (Integer.parseInt(timeinHr.trim()) <= 23 && Integer.parseInt(timeinHr.trim()) >= 22) {
					if (textWithDurationInEPG.getText()
							.equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Yesterday", "name_nl"))) {
						reports.log(LogStatus.PASS, getExcelKeyValue("MiniEPGScreen", "Yesterday", "name_nl")
								+ " getting displayed with duration");
						reports.attachScreenshot(captureCurrentScreenshot());
					}
				}
			} catch (NoSuchElementException ex) {
				FailTestCase(getExcelKeyValue("MiniEPGScreen", "Yesterday", "name_nl")
						+ " should be displayed with Duration");
			}
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
		int noOfTry = 25;
		while (noOfTry != 0) {
			sendKeyMultipleTimes(keyEnter, 1, 1000);
			System.out.println(miniEPGEpisodeDuration.getAttribute("innerText"));
			System.out.println(duration);
			if (miniEPGEpisodeDuration.getAttribute("innerText").equalsIgnoreCase(duration)) {
				break;
			}
			noOfTry -= 1;
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
		int noOfTry = 25;
		while (noOfTry != 0) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (epgScreen.focusElementProgramTime.getText().equalsIgnoreCase(channelName.get(channelNumber))) {
				episodeName = epgScreen.focusElemntInEpg.getText();
				break;
			} else {
				sendKeyMultipleTimes(keyEnter, 1, 1000);
			}
			noOfTry -= 1;
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
			reports.log(LogStatus.PASS, "Find next day episode in channel number :" + i);
			sendNumaricKeys(i);
			Thread.sleep(1000);
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (cutvIcon.getAttribute("src").contains("cutv-icon.png") || futureOrPast.equalsIgnoreCase("FUTURE")) {
				sendKeySequence("RIGHT", 1000, getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
				driver.switchTo().frame(getCurrentFrameIndex());
				String prevTime = null;
				int noOfTry = 25;
				while (noOfTry != 0) {

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
							reports.log(LogStatus.PASS, "Next day episode found in channel number " + i);
							reports.attachScreenshot(captureCurrentScreenshot());
							channelFound = true;
							break;
						}
					}
					noOfTry -= 1;
				}
			} else {
				sendKeySequence("RIGHT", 1000, getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
				driver.switchTo().frame(getCurrentFrameIndex());
				sendKeyMultipleTimes(keyEnter, 1, 1000);
				duration = miniEPGEpisodeDuration.getText();
				channel.put(i, duration);
				channelFound = true;
				break;
			}
			if (channelFound) {
				break;
			}
		}
		return channel;
	}

	public void validateMiniEpgprogramAfterProgramEnded() throws InterruptedException, ParseException {

		HashMap<Integer, Long> cutvChanel = null;
		launchDTV(true);
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		cutvChanel = getCUTVChannelMinRemainingTime();
		System.out.println(cutvChanel.toString());
		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		reports.log(LogStatus.PASS, "Pressing RIGHT key will reach to the MiniEPG Screen");
		sendKeySequence("RIGHT", 1000, screenTitle);
		reports.attachScreenshot(captureCurrentScreenshot());

		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String timingOftheNextProgram = activeTileProgramTime.getText();
		System.out.println("Program Time :" + timingOftheNextProgram);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		String executedProgramTime = activeTileProgramTime.getText();
		String executedProgramTitleName = programTitle.getText();

		reports.log(LogStatus.PASS, "Tune to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Pressing Right key will navigate to EPG screen");
		sendKeyMultipleTimes("RIGHT", 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		System.out.println(headerTime.getText().split(" ")[4].trim());
		String nextProgramTime = timingOftheNextProgram.split(">")[0].trim();
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		Date nextEpisodeTime = sdf.parse(nextProgramTime);
		reports.log(LogStatus.PASS, "Moving LEFT & RIGHT in the EPG screen untill the program ends");
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(nextProgramTime)) {
			sendKeyMultipleTimes("LEFT", 1, 500);
			sendKeyMultipleTimes("RIGHT", 1, 500);
			Date currentTime = sdf.parse(headerTime.getText().split(" ")[4].trim());
			if (currentTime.after(nextEpisodeTime)) {
				break;
			}
		}
		reports.attachScreenshot(captureCurrentScreenshot());

		// Navigate to previous tile
		sendKeyMultipleTimes("LEFT", 1, 500);

		driver.switchTo().frame(getCurrentFrameIndex());
		String executedProgramTitleNameAfterExecution = programTitle.getText();
		String executedProgramTimeNameAfterExecution = activeTileProgramTime.getText();

		reports.log(LogStatus.PASS, "Verify whether the future program is getting updated or not");
		if (executedProgramTime.equalsIgnoreCase(executedProgramTimeNameAfterExecution)
				&& executedProgramTitleName.equalsIgnoreCase(executedProgramTimeNameAfterExecution)) {

			reports.log(LogStatus.PASS,
					"Expected previous title of the program " + executedProgramTitleName
							+ "Actual previous title of the program" + executedProgramTitleNameAfterExecution
							+ "Expected previous time of the program " + executedProgramTime
							+ "Actual previous time of the program" + executedProgramTimeNameAfterExecution + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("previous Program is not getting updated");
		}

	}

	public void miniEPGMiniEPGonzaplistNottunedCUTVenabledchannel_partIII()
			throws InterruptedException, ParseException {
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		HashMap<Integer, Long> cutvChanel = null;
		launchDTV(true);
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		cutvChanel = getCUTVChannelMinRemainingTime();

		System.out.println(cutvChanel.toString());
		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		reports.log(LogStatus.PASS, "Pressing RIGHT key will reach to the MiniEPG Screen");
		sendKeySequence("RIGHT", 1000, screenTitle);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Pressing RIGHT key to get the Next Program Details");
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		reports.attachScreenshot(captureCurrentScreenshot());

		String nextProgramTitleoftheScreen = programTitle.getText();
		System.out.println("Next Program Title:: " + nextProgramTitleoftheScreen);
		String timingOftheNextProgram = activeTileProgramTime.getText();
		System.out.println("Program Time :" + timingOftheNextProgram);

		reports.log(LogStatus.PASS, "Tune to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Pressing Right key will navigate to EPG screen");
		sendKeyMultipleTimes("RIGHT", 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		System.out.println(headerTime.getText().split(" ")[4].trim());
		System.out.println(timingOftheNextProgram.split(">")[0].trim());
		String nextProgramTime = timingOftheNextProgram.split(">")[0].trim();
		reports.log(LogStatus.PASS, "Moving LEFT & RIGHT in the EPG screen untill the program ends");
		Date nextEpisodeTime = sdf.parse(nextProgramTime);
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(nextProgramTime)) {
			sendKeyMultipleTimes("LEFT", 1, 500);
			sendKeyMultipleTimes("RIGHT", 1, 500);
			Date currentTime = sdf.parse(headerTime.getText().split(" ")[4].trim());
			if (currentTime.after(nextEpisodeTime)) {
				break;
			}
		}

		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String nextTitleOfTheProgram = programTitle.getText();
		System.out.println("nextTitleOfTheProgram ::" + nextTitleOfTheProgram);
		String timingasPerNextProgram = activeTileProgramTime.getText();
		System.out.println("Program Time :" + timingasPerNextProgram);

		reports.log(LogStatus.PASS, "Verify whether the future program is getting updated or not");
		if (nextTitleOfTheProgram.equalsIgnoreCase(nextProgramTitleoftheScreen)
				&& timingasPerNextProgram.equalsIgnoreCase(timingOftheNextProgram)) {
			reports.log(LogStatus.PASS, "Expected next title of the program:::" + nextProgramTitleoftheScreen
					+ "Current title of the program::::" + nextTitleOfTheProgram + "Timing as per next program ::::"
					+ timingasPerNextProgram + "Timing as on the Next program is ::::" + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(" Expected next title of the program::::" + nextProgramTitleoftheScreen
					+ "Current title of the program::::" + nextTitleOfTheProgram + "Timing as per next program ::::"
					+ timingasPerNextProgram + "Timing as on the Next program is ::::" + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	private HashMap<Integer, Long> getCUTVChannelMinRemainingTime() throws ParseException, InterruptedException {
		long minBufferTime = 0;
		ArrayList<Integer> cutvList = new ArrayList<Integer>();
		cutvList.add(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_1", "Values")));
		cutvList.add(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_2", "Values")));
		cutvList.add(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_3", "Values")));
		cutvList.add(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_4", "Values")));
		cutvList.add(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_5", "Values")));
		cutvList.add(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_6", "Values")));
		HashMap<Integer, Long> channelTiming = new HashMap<Integer, Long>();
		EpgScreen epgScreen = new EpgScreen(driver);
		ArrayList<String> episodeName = new ArrayList<String>();
		ArrayList<String> episodeTiming = new ArrayList<String>();
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		for (Integer channel : cutvList) {
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);

			sendNumaricKeys(channel);

			Thread.sleep(2000);
			handlePopupIfExist();

			sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);

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
			if (minBufferTime > 2 && minBufferTime < 30) {
				channelTiming.put(channel, minBufferTime);
			}
		}
		return channelTiming;
	}

	public void verifyMiniEPGOnZapList_CUTVEnabledChannel() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		String miniEPGExpectedscreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String miniEPGNowTitle = getExcelKeyValue("MiniEPGScreen", "InProgress", "name_nl");
		String miniEPGPastTitle = getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl");
		String miniEPGFutureTitle = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(5000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
			reports.log(LogStatus.PASS, "Tune To CUTV Channel " + cutvChannelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not Tuned to CUTV Channel Or CUTV Icon not getting displayed on Info Bar");
		}
		sendKeyMultipleTimes("UP", 1, 0);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(headerText));
		if (headerText.getText().equalsIgnoreCase(getExcelKeyValue("screenTitles", "ZapList", "name_nl"))) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (currentChannelNumber.getText().equalsIgnoreCase(cutvChannelNumber)) {
				reports.log(LogStatus.PASS,
						"Press UP Key - ZapList Screen getting displayed and Focus is on Current Live TV. Expected Channel -"
								+ cutvChannelNumber + "Actual Channel - " + currentChannelNumber.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase(
						"Press UP Key - ZapList Screen getting displayed But Focus is not on Current Live TV. Expected Channel -"
								+ cutvChannelNumber + "Actual Channel - " + currentChannelNumber.getText());
			}

		} else {
			FailTestCase("Press UP Key - ZapList Screen not getting displayed");
		}
		sendKeyMultipleTimes("UP", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (currentChannelNumber.getText().equalsIgnoreCase(cutvChannelNumber)) {
			FailTestCase("Press UP Key - Focus is on Current Live TV " + currentChannelNumber.getText()
					+ " Expected Focus should not on Channel Number -" + cutvChannelNumber);
		} else {
			reports.log(LogStatus.PASS,
					"Press UP Key - Focus is not on Current Live TV. Expected Output - Focus should not on Channel Number - "
							+ cutvChannelNumber + "  Actual Output - Focus is on Channel - "
							+ currentChannelNumber.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("DOWN", 2, 500);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (currentChannelNumber.getText().equalsIgnoreCase(cutvChannelNumber)) {
			FailTestCase("Press DOWN Keys - Focus is on Current Live TV " + currentChannelNumber.getText()
					+ "Expected Focus should not on Channel Number -" + cutvChannelNumber);
		} else {
			reports.log(LogStatus.PASS,
					"Press DOWN Keys - Focus is not on Current Live TV. Expected Output - Focus should not on Channel Number - "
							+ cutvChannelNumber + "  Actual Output - Focus is on Channel - "
							+ currentChannelNumber.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("UP", 1, 800);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (currentChannelNumber.getText().equalsIgnoreCase(cutvChannelNumber)) {
			reports.log(LogStatus.PASS, "Focus is on Current Live TV. Expected Channel -" + cutvChannelNumber
					+ "Actual Channel - " + currentChannelNumber.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Current Live TV. Expected Channel -" + cutvChannelNumber + "Actual Channel - "
					+ currentChannelNumber.getText());
		}
		sendKeyMultipleTimes("RIGHT", 1, 0);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(headerText));
		if (headerText.getText().equalsIgnoreCase(miniEPGExpectedscreenTitle)) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeZapBlock.getText().equalsIgnoreCase(miniEPGNowTitle)) {
				reports.log(LogStatus.PASS,
						"Press RIGHT Key - Mini EPG Screen getting displayed and Focus on Current program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press RIGHT Key - Mini EPG Screen getting displayed But Focus is not on Current program");
			}
		} else {
			FailTestCase("Press RIGHT Key - Mini EPG Screen not getting displayed");
		}
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGPastTitle)) {
			reports.log(LogStatus.PASS, "Press LEFT Key - Previous program is on Left Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press LEFT Key - Previous program tile is not on left side");
		}
		sendKeyMultipleTimes("RIGHT", 2, 500);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGFutureTitle)) {
			reports.log(LogStatus.PASS, "Press RIGHT Keys - Future program is on Right Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Future program tile is not on right side");
		}
		// verifyMiniEPGScreen();
		reports.log(LogStatus.PASS, "Wait for 10 sec Mini EPG Screen should dismissed and navigate to LiveTv");
		Thread.sleep(10000);
		driver.switchTo().defaultContent();
		try {
			if (headerText.isDisplayed()) {
				FailTestCase("Zap banner not getting dismissed");
			} else {
				{
					reports.log(LogStatus.PASS, "Mini EPG Screen Getting Dismissed and navigate to live TV");
					reports.attachScreenshot(captureCurrentScreenshot());
				}
			}
		} catch (NoSuchElementException ex) {
			reports.log(LogStatus.PASS, "Mini EPG Screen Getting Dismissed and navigate to live TV");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void verifyMiniEPGOnZapList_CUTVDisabledChannel() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVDisabledChannel", "Values");
		String zapListExpectedTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGExpectedTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String miniEPGNowTitle = getExcelKeyValue("MiniEPGScreen", "InProgress", "name_nl");
		String miniEPGPastTitle = getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl");
		String miniEPGFutureTitle = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(5000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
			FailTestCase("Not Tuned to CUTV Disabled Channel");
		} else {
			reports.log(LogStatus.PASS, "Tune To CUTV Disabled Channel " + cutvChannelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		Thread.sleep(2000);
		sendKeyMultipleTimes("DOWN", 1, 0);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(headerText));
		if (headerText.getText().equalsIgnoreCase(zapListExpectedTitle)) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (currentChannelNumber.getText().equalsIgnoreCase(cutvChannelNumber)) {
				reports.log(LogStatus.PASS,
						"Press UP Key - ZapList Screen getting displayed and Focus is on Current Live TV. Expected Channel -"
								+ cutvChannelNumber + "Actual Channel - " + currentChannelNumber.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase(
						"Press UP Key - ZapList Screen getting displayed But Focus is not on Current Live TV. Expected Channel -"
								+ cutvChannelNumber + "Actual Channel - " + currentChannelNumber.getText());
			}
		} else {
			FailTestCase("Press DOWN Key - ZapList Screen not getting displayed");
		}
		sendKeyMultipleTimes("LEFT", 1, 0);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(headerText));
		if (headerText.getText().equalsIgnoreCase(miniEPGExpectedTitle)) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeZapBlock.getText().equalsIgnoreCase(miniEPGNowTitle)) {
				reports.log(LogStatus.PASS,
						"Press LEFT Key - Mini EPG Screen getting displayed and Focus on Current program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press LEFT Key - Mini EPG Screen getting displayed But Focus is not on Current program");
			}
			reports.log(LogStatus.PASS, "Press LEFT Key - Mini EPG Screen getting displayed");
		} else {
			FailTestCase("Press LEFT Key - Mini EPG Screen not getting displayed");
		}
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGPastTitle)) {
			reports.log(LogStatus.PASS, "Press LEFT Key - Previous program is on Left Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press LEFT Key - Previous program tile is not on left side");
		}
		sendKeyMultipleTimes("RIGHT", 2, 500);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGFutureTitle)) {
			reports.log(LogStatus.PASS, "Press RIGHT Keys - Future program is on Right Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Future program tile is not on right side");
		}
		sendKeyMultipleTimes("LEFT", 1, 500);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGNowTitle)) {
			reports.log(LogStatus.PASS, "Focus is on Live Tile");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Live Tile");
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().defaultContent();
		try {
			if (activeZapBlock.isDisplayed()) {
				FailTestCase("Mini EPG not getting dismissed");
			} else {
				reports.log(LogStatus.PASS, "Press OK key - Mini EPG Screen getting Dismissed and navigate to live TV");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		} catch (NoSuchElementException ex) {
			reports.log(LogStatus.PASS, "Press OK key - Mini EPG Screen getting Dismissed and navigate to live TV");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void validateMiniEPGAccessToPastProgramDetails() throws InterruptedException {
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(1);
		Thread.sleep(2000);
		sendKeyMultipleTimes("UP", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl"))) {
			reports.log(LogStatus.PASS, "Focus is on Past Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Past Program");
		}
		driver.switchTo().frame(getCurrentFrameIndex());
		String pastTitle = miniEPGChannelName.getAttribute("innerText");
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (programDetailsScreen.getAttribute("innerText").equalsIgnoreCase(pastTitle)
				|| programDetailsScreen.isDisplayed()) {
			reports.log(LogStatus.PASS, "Program Details of Past Episode getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Program Details of Past Episode not getting displayed");
		}
		String[] expectedActionList = { "zendercatalogus" };
		driver.switchTo().frame(getCurrentFrameIndex());
		for (int i = 0; i < actionItemList.size(); i++) {
			if (actionItemList.get(i).getText().equalsIgnoreCase(expectedActionList[i])) {
				reports.log(LogStatus.PASS, "Action list getting displayed " + actionItemList.get(i).getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);

		}
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl"))) {
			reports.log(LogStatus.PASS, "Focus is on Past Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Past Program");
		}
	}

	public void validateMiniEPGAccessToFutureProgramDetails() throws InterruptedException {
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(1);
		Thread.sleep(2000);
		sendKeyMultipleTimes("UP", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(getExcelKeyValue("MiniEPGScreen", "Future", "name_nl"))) {
			reports.log(LogStatus.PASS, "Future program is on Right Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Future program tile is not on right side");
		}
		driver.switchTo().frame(getCurrentFrameIndex());
		String futureTitle = miniEPGChannelName.getAttribute("innerText");
		sendKeyMultipleTimes("ENTER", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (programDetailsScreen.getAttribute("innerText").equalsIgnoreCase(futureTitle)
				|| programDetailsScreen.isDisplayed()) {
			reports.log(LogStatus.PASS, "Program Details of Future Episode getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Program Details of Future Episode not getting displayed");
		}
		String[] expectedActionList = { "opnemen", "serie opnemen", "herinnering", "zendercatalogus" };
		driver.switchTo().frame(getCurrentFrameIndex());
		for (int i = 0; i < actionItemList.size(); i++) {
			if (actionItemList.get(i).getText().equalsIgnoreCase(expectedActionList[i])) {
				reports.log(LogStatus.PASS, "Action list getting displayed " + actionItemList.get(i).getText());
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);

		}
		sendKeySequence("PAGE_DOWN", 800, miniEPGScreenTitle);
		driver.switchTo().frame(getCurrentFrameIndex());
		System.out.println(miniEPGChannelName.getAttribute("innerText"));
		if (miniEPGChannelName.getAttribute("innerText").equalsIgnoreCase(futureTitle)) {
			reports.log(LogStatus.PASS, "Focus is on Last Future Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Last Future Program");
		}
		sendKeySequence("PAGE_DOWN", 800, zapListScreenTitle);
	}

	public void validateScreenTitles(String expectedTitle) throws InterruptedException {
		driver.switchTo().defaultContent();
		if (headerText.getText().equalsIgnoreCase(expectedTitle)) {
			reports.log(LogStatus.PASS, expectedTitle + " Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(expectedTitle + " Screen not getting displayed");
		}
	}

	public void verifyMiniEPGTVGuide() throws InterruptedException {
		String minEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String prevTileTitle = null;
		String prevTileEpisodeDuration = null;
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(5000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
			reports.log(LogStatus.PASS, "Tune To CUTV Enabled Channel");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not Tuned to CUTV Channel Or CUTV Icon not getting displayed on Info Bar");
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(minEPGScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to far-east tv guide");
		int noOfTry = 30;
		boolean found = false;
		while (noOfTry != 0) {
			try {
				driver.switchTo().frame(getCurrentFrameIndex());
				if (miniEPGChannelName.getText().equalsIgnoreCase("tv-gids")) {
					reports.log(LogStatus.PASS, "Focus is on " + miniEPGChannelName.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					found = true;
					break;
				} else {
					prevTileEpisodeDuration = miniEPGEpisodeDuration.getText();
					prevTileTitle = miniEPGChannelName.getText();
					sendKeyMultipleTimes("RIGHT", 1, 1000);
				}

			} catch (NoSuchElementException ex) {
				if (lastTileInMiniEPG.getText().equalsIgnoreCase("tv-gids")) {
					reports.log(LogStatus.PASS, "Focus is on " + lastTileInMiniEPG.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					found = true;
					break;
				}
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("TV-Gids not found at far east side");

		}
		sendKeyMultipleTimes("ENTER", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");

		if (new EpgScreen(driver).focusElemntInEpg.getText().equalsIgnoreCase(prevTileTitle)
				&& new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(prevTileEpisodeDuration)) {
			reports.log(LogStatus.PASS, "Focus should on Program - " + prevTileEpisodeDuration + " Actual focus is on "
					+ new EpgScreen(driver).focusElementProgramTime.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus should on Program - " + prevTileEpisodeDuration + " Actual focus is on "
					+ new EpgScreen(driver).focusElementProgramTime.getText());
		}

		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
	}

	public void validateMiniEPGAccessToNonWatchedCUTVBlackListProgramDetails() throws InterruptedException {
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String presentTitle = null;
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(1);
		Thread.sleep(3000);
		sendKeyMultipleTimes("UP", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
		int noOfTry = 30;
		boolean found = false;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				found = true;
				break;
			}
			noOfTry -= 1;
		}

		if (!found) {
			FailTestCase("No CUTV Enabled Channel Found");

		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to BlackListed Past Program");
		noOfTry = 30;
		found = false;

		while (noOfTry != 0) {
			sendKeyMultipleTimes("LEFT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)).size() == 0
					|| driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)).get(0)
							.getAttribute("src").contains("blacklist-icon.png")) {
				reports.log(LogStatus.PASS, "Past BlackList Program Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				presentTitle = miniEPGChannelName.getAttribute("innerText");
				sendKeyMultipleTimes("ENTER", 1, 2000);
				found = true;
				break;
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("No black list program found");

		}
		Thread.sleep(2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (programDetailsScreen.getText().equalsIgnoreCase(presentTitle) || programDetailsScreen.isDisplayed()) {
			reports.log(LogStatus.PASS, "Program Details of BlackList Episode getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Program Details of Black List Episode not getting displayed");
		}

		driver.switchTo().frame(getCurrentFrameIndex());
		for (int i = 0; i < actionItemList.size(); i++) {
			System.out.println(actionItemList.get(i).getText());
			if (actionItemList.get(i).getText().equalsIgnoreCase("kijken")) {
				FailTestCase("Watch option should not be displayed for BlackListed Programs");
			} else {
				reports.log(LogStatus.PASS, "Action Item Present - " + actionItemList.get(i).getText());
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
	}

	public void validateMiniEPGAccessToNonWatchedCUTVNonBlackListProgramDetails() throws InterruptedException {
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String cuTVChannel = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String presentTitle = null;
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys((Integer.parseInt(cuTVChannel) - 2));
		Thread.sleep(3000);
		handlePopupIfExist();
		sendKeyMultipleTimes("UP", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
		int noOfTry = 30;
		boolean found = false;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				found = true;
				break;
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("No CUTV Enabled Channel Found");

		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to Non BlackListed Past Program");
		noOfTry = 30;
		found = false;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("LEFT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)).size() > 0
					&& driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconMiniEpg)).get(0)
							.getAttribute("src").contains("cutv-icon.png")) {
				reports.log(LogStatus.PASS, "Past Replayable Program Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				presentTitle = miniEPGChannelName.getAttribute("innerText");
				sendKeyMultipleTimes("ENTER", 1, 1000);
				found = true;
				break;
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("No Replaybaled Past Program found");

		}
		driver.switchTo().frame(getCurrentFrameIndex());
		if (programDetailsScreen.getText().equalsIgnoreCase(presentTitle) || programDetailsScreen.isDisplayed()) {
			reports.log(LogStatus.PASS, "Program Details of Non - BlackList Episode getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Program Details of non Black List Episode not getting displayed");
		}

		driver.switchTo().frame(getCurrentFrameIndex());
		List<String> actionListText = new ArrayList<String>();
		for (int i = 0; i < actionItemList.size(); i++) {
			actionListText.add(actionItemList.get(i).getText());
		}
		if (actionListText.contains("kijken")) {
			reports.log(LogStatus.PASS, "Watch Option getting dsiplayed for Non black Listed Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Watch Option should be dsiplayed for Non black Listed Program");
		}
		for (int i = 0; i < actionItemList.size(); i++) {
			reports.log(LogStatus.PASS, "Action Item Present - " + actionItemList.get(i).getText());
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		for (int i = 0; i < actionItemList.size() - 1; i++) {
			sendKeyMultipleTimes("UP", 1, 1000);
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (miniEPGChannelName.isDisplayed()) {
				FailTestCase("Mini EPG not getting dismissed");
			} else {
				reports.log(LogStatus.PASS, "Mini EPG got dismissed");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		} catch (NoSuchElementException ex) {
			reports.log(LogStatus.PASS, "Mini EPG got dismissed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		Thread.sleep(2000);
		handlePopupIfExist();
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		System.out.println(imageName);
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Full Screen Video is playing successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
	}

	public void validateMiniEPGAccessToNonWatchedCUTVCurrentProgramDetails() throws InterruptedException {
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String cuTVChannel = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys((Integer.parseInt(cuTVChannel) - 2));
		Thread.sleep(2000);
		handlePopupIfExist();
		sendKeyMultipleTimes("UP", 1, 1000);
		handlePopupIfExist();
		validateScreenTitles(zapListScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
		int noOfTry = 30;
		boolean found = false;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				found = true;
				break;
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("No CUTV Enabled Channel FOund");

		}
		sendKeyMultipleTimes("RIGHT", 1, 1500);
		validateScreenTitles(miniEPGScreenTitle);
		driver.switchTo().frame(getCurrentFrameIndex());
		miniEPGChannelName.getAttribute("innerText");
		sendKeyMultipleTimes("ENTER", 1, 1000);
		Thread.sleep(1000);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = dtvChannelScreen.pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		System.out.println(imageName);
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Full Screen Video is playing successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);

	}

	public void verifyMiniEPGonLongFinishedCUTV() throws ParseException, InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		String miniEPGExpectedscreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(3000);
		handlePopupIfExist();
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 3000);
		int noOfTry = 30;
		while (noOfTry > 0) {
			try {
				String focustText = new EpgScreen(driver).focusElemntInEpg.getText();
				String title = driver.findElement(By.xpath("//*[@id='title']")).getText();
				if (new DTVChannelScreen(driver).focusElementcutvIcon.getAttribute("src").contains("cutv-icon.png")
						&& focustText.equalsIgnoreCase(title)) {
					System.out.println("Episode Found");
					reports.log(LogStatus.PASS, "Past Replayble program found Started long back"
							+ new EpgScreen(driver).focusElemntInEpg.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException ex) {

			}
			noOfTry -= 1;
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			reports.log(LogStatus.PASS, "Navigate to Replayble Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		wait.until(ExpectedConditions.visibilityOf(programDetailsScreen));
		isDisplayed(programDetailsScreen, "Program Details Screen");
		Thread.sleep(3000);
		List<WebElement> menuList = driver.findElements(By.xpath(ObjectRepository.EpgScreen.actionList));
		System.out.println(menuList.size());
		for (int i = 0; i < menuList.size(); i++) {
			if (menuList.get(i).getText().equalsIgnoreCase("kijken")) {
				sendKeyMultipleTimes("ENTER", 1, 3000);
				break;
			} else {
				sendKeyMultipleTimes("DOWN", 1, 2000);
			}
		}

		Thread.sleep(5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
				sendKeyMultipleTimes("ENTER", 1, 3000);
			}
		} catch (NoSuchElementException ex) {
		}
		Thread.sleep(2000);
		new DTVChannelScreen(driver).pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 3000);
		Thread.sleep(3000);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.visibilityOf(headerText));
		if (headerText.getText().equalsIgnoreCase(miniEPGExpectedscreenTitle)) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeZapBlock.getText().equalsIgnoreCase("bezig")) {
				reports.log(LogStatus.PASS, "Press LEFT Key - Mini EPG Screen getting displayed and Current focus on "
						+ activeZapBlock.getText() + " tile");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Press LEFT Key - Mini EPG Screen getting displayed and Current focus on "
						+ activeZapBlock.getText() + " tile. Focus should be on bezig");
			}

		} else {
			FailTestCase("Press LEFT Key - Mini EPG Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Validate Left-far Tile is tv-gids");
		validateFirstOrRightTile("LEFT", "tv-gids", 15);
		reports.attachScreenshot(captureCurrentScreenshot());
		noOfTry = 30;
		boolean found = false;
		while (noOfTry != 1) {
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeZapBlock.getAttribute("innerText").equalsIgnoreCase("bezig")) {
				reports.log(LogStatus.PASS, "Navigated to Active Episode Tile");
				reports.attachScreenshot(captureCurrentScreenshot());
				found = true;
				break;
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("Not navigated to Active Episode Tile");

		}
		reports.log(LogStatus.PASS, "Validate Right-far Tile is tv-gids");
		validateFirstOrRightTile("RIGHT", "tv-gids", 25);
		reports.attachScreenshot(captureCurrentScreenshot());
		noOfTry = 30;
		found = false;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("LEFT", 1, 1000);
			if (activeZapBlock.getText().equalsIgnoreCase("bezig")) {
				reports.log(LogStatus.PASS, "Navigated to Active Episode Tile");
				reports.attachScreenshot(captureCurrentScreenshot());
				found = true;
				break;
			}
			noOfTry = 1;
		}
		if (!found) {
			FailTestCase("Not navigated to Active Episode Tile");

		}
		sendKeyMultipleTimes("ENTER", 1, 3000);
		new DTVChannelScreen(driver).pressPauseButtonAndValidation();
	}

	public void verifyTitleOfMiniEPGScreen() throws InterruptedException {
		reports.log(LogStatus.PASS, "Checking the Center Title of the screen");
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String centerTitleofTheScreen = centerTitle.getText();
		System.out.println("centerTitleofTheScreen" + centerTitleofTheScreen);
		if (centerTitleofTheScreen
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("screenTitles", "CenterTitle", "name_nl"))) {
			reports.log(LogStatus.PASS, "Center title is matched with the actual title of the screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Center title is not matched with the actual title of the screen");
		}

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 500);
		handlePopupIfExist();
		sendKeyMultipleTimes("LEFT", 1, 1000);
		reports.log(LogStatus.PASS, "Checking the Previous Program Title of the screen");
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 500);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String previousProgramTitleoftheScreen = previousProgramTitle.getText();
		System.out.println("previousProgramTitleoftheScreen " + previousProgramTitleoftheScreen);
		if (previousProgramTitleoftheScreen
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("screenTitles", "PreviousScreenTitle", "name_nl"))) {
			reports.log(LogStatus.PASS, "Previous Screen title is matched with the actual title of the screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Previous Screen title is not matched with the actual title of the screen");
		}

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 500);
		handlePopupIfExist();
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		reports.log(LogStatus.PASS, "Checking the Next Program Title of the screen");
		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 500);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String nextProgramTitleoftheScreen = nextProgramTitle.getText();
		System.out.println("nextProgramTitleoftheScreen " + nextProgramTitleoftheScreen);
		if (nextProgramTitleoftheScreen
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("screenTitles", "NextScreenTitle", "name_nl"))) {
			reports.log(LogStatus.PASS, "Next Screen title is matched with the actual title of the screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Next Screen title is not matched with the actual title of the screen");
		}

	}

	public void miniEPGMiniEPGonzaplistNottunedCUTVenabledchannel() throws NumberFormatException, InterruptedException {
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(1);
		Thread.sleep(2000);
		handlePopupIfExist();
		String cutvChannel = TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.tuneToChannel(Integer.parseInt(cutvChannel));
		int noOfTry = 20;
		boolean found = false;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("UP", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				found = true;
				break;
			}
			noOfTry -= 1;
		}
		if (!found) {
			FailTestCase("No CUTV Enabled Channel Found");

		}
		reports.log(LogStatus.PASS, "Pressing on RIGHT key will reach to the MiniEPG screen");
		sendKeyMultipleTimes("RIGHT", 1, 500);
		reports.attachScreenshot(captureCurrentScreenshot());

		verifyTitleOfMiniEPGScreen();

	}

	public void miniEPGMiniEPGonzaplistNottunedCUTVenabledchannel_partII() throws InterruptedException {

		launchDTV(true);
		String zapTitle = TestInitization.getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String cutvChannel = TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.tuneToChannel(Integer.parseInt(cutvChannel));

		sendKeySequence("UP", 1000, zapTitle);
		navigateToMiniEpgAndValidationTV_Gids();

		setApplicationHubPage(2);
		launchDTV(true);

		dtvChannelScreen.tuneToChannel(Integer.parseInt(cutvChannel));

		sendKeySequence("UP", 1000, zapTitle);

		sendKeyMultipleTimes("RIGHT", 1, 1000);

		verifyTitleOfMiniEPGScreen();

		launchDTV(true);
		reports.log(LogStatus.PASS, "Navigate to Mini EPG screen");
		sendKeySequence("RIGHT", 1, getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));

		Thread.sleep(10000);

		reports.log(LogStatus.PASS, "After 10 seconds it should close and returns to Full screen live TV");
		reports.attachScreenshot(captureCurrentScreenshot());
		DTVChannelScreen dtvchannel = new DTVChannelScreen(driver);
		reports.log(LogStatus.PASS, "Verifying Play button in Live TV");
		dtvchannel.pressPauseButtonAndValidation();

	}

	public void verifyLongStayInProgramDetailsScreen() throws ParseException, InterruptedException {
		String miniEPGExpectedscreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String future = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		String current = getExcelKeyValue("MiniEPGScreen", "InProgress", "name_nl");
		String channelWithLeastDuration = getExcelKeyValue("DTVChannel", "ChannelWithLeastDurationEpisode", "Values");
		long minBufferTime = 0;
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		HashMap<Integer, Long> channelTiming = findProgramWithMinRemainingTime(2, 30);
		if (channelTiming.isEmpty()) {
			DateFormat sdf = new SimpleDateFormat("hh:mm");
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
			handlePopupIfExist();
			Thread.sleep(2000);
			sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			Date episodeTime = sdf.parse(new EpgScreen(driver).focusElementProgramTime.getText().split(" ")[2].trim());
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			Date currentTime = sdf.parse(headerTime.getText().split(" ")[4].trim());
			System.out.println(headerTime.getText().split(" ")[4].trim());
			long diff = episodeTime.getTime() - currentTime.getTime();
			long diffSec = diff / 1000;
			minBufferTime = diffSec / 60;
			channelTiming.put(Integer.parseInt(channelWithLeastDuration), minBufferTime);
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
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(channelKeyWithMinBuffer);
		Thread.sleep(3000);
		reports.log(LogStatus.PASS, "Navigate to Mini EPG Screen");
		sendKeySequence("RIGHT", 800, miniEPGExpectedscreenTitle);
		// sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 500);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(future)) {
			reports.log(LogStatus.PASS, "Press Right Key - Focus is on next Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Fcous should be on " + future);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		String episodeDuration = miniEPGEpisodeDuration.getText();
		String episodeName = miniEPGChannelName.getText();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		reports.log(LogStatus.PASS, "Wait in this screen till current program ends");
		Thread.sleep(channelTiming.get(channelKeyWithMinBuffer) * 60000);
		sendKeySequence("PAGE_DOWN", 800, miniEPGExpectedscreenTitle);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(current)
				&& miniEPGEpisodeDuration.getText().equalsIgnoreCase(episodeDuration)) {
			reports.log(LogStatus.PASS,
					"Press Back Key - Mini EPG Screen getting displayed and Focus is on channel which is live"
							+ episodeName);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Press Back Key - Mini EPG Screen should getting displayed and Focus is not on channel which is live");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		Thread.sleep(1000);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		System.out.println(imageName);
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Full Screen Video is playing successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
	}

	public HashMap<Integer, Long> findProgramWithMinRemainingTime(int minTime, int maxTime)
			throws ParseException, InterruptedException {
		long minBufferTime = 0;
		int noOfChannel = 20;
		HashMap<Integer, Long> channelTiming = new HashMap<Integer, Long>();
		EpgScreen epgScreen = new EpgScreen(driver);
		ArrayList<String> episodeName = new ArrayList<String>();
		ArrayList<String> episodeTiming = new ArrayList<String>();
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		for (int i = 1; i <= noOfChannel; i++) {
			sendNumaricKeys(i);
			Thread.sleep(2000);
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
			if (minBufferTime > minTime && minBufferTime < maxTime) {
				channelTiming.put(i, minBufferTime);
			}
		}
		return channelTiming;
	}

	public void verifyStayinFutureProgramDetailsScreen() throws InterruptedException {
		String miniEPGExpectedscreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String future = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(2);
		Thread.sleep(5000);
		// sendKeySequence("RIGHT", 1, miniEPGExpectedscreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(future)) {
			reports.log(LogStatus.PASS, "Press Right Key - Focus is on next Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus should be on " + future);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		reports.log(LogStatus.PASS, "Wait in this screen for atleaset 15 min");
		Thread.sleep(16 * 60000);
		reports.log(LogStatus.PASS, "Press Back key - Mini EPG Screen should displayed");
		sendKeySequence("PAGE_DOWN", 800, miniEPGExpectedscreenTitle);
	}

	public void verifyMiniEPGBehaviourOnCUTVDisabledChannel() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVDisabledChannel", "Values");
		String miniEPGExpectedTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String miniEPGNowTitle = getExcelKeyValue("MiniEPGScreen", "InProgress", "name_nl");
		String miniEPGPastTitle = getExcelKeyValue("MiniEPGScreen", "Previous", "name_nl");
		String miniEPGFutureTitle = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		boolean foundLiveTile = false;
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(3000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
			FailTestCase("Not Tuned to CUTV Disabled Channel");
		} else {
			reports.log(LogStatus.PASS, "Tune To CUTV Disabled Channel " + cutvChannelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		Thread.sleep(2000);
		reports.log(LogStatus.PASS, "Navigate to Mini EPG");
		TestInitization.sendKeySequence("RIGHT", 1000, miniEPGExpectedTitle);

		navigateToMiniEpgAndValidateObject(highligheVideotitle, "Active tile title ");
		navigateToMiniEpgAndValidateObject(videoPlayer, "Active tile video player ");
		reports.log(LogStatus.PASS, "Validate Left tile position");
		navigateToMiniEpgAndValidateObject(highlightVideoLeftTitle, "Left tile title ");
		reports.log(LogStatus.PASS, "Validate right tile position");
		navigateToMiniEpgAndValidateObject(highlightVideoRightTitle, "Right tile title ");

		sendKeyMultipleTimes("LEFT", 2, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String episodeDuration = miniEPGEpisodeDuration.getText();
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGPastTitle)) {
			reports.log(LogStatus.PASS, "Press Left Key - Past Program Tile getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press Left Key - Past program tile should be displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (miniEPGEpisodeDuration.getText().equalsIgnoreCase(episodeDuration)) {
			reports.log(LogStatus.PASS, "Press Left Key Again - Nothing happenss.Focus is on last focus tile");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press Left Key - Focus should be on last focus tile");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGNowTitle)) {
			reports.log(LogStatus.PASS, "Press RIGHT KEY - Current Program Tile getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press RIGHT KEY - Current Program Tile should displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGFutureTitle)) {
			reports.log(LogStatus.PASS, "Press RIGHT KEY - FUTURE Program Tile getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Press RIGHT KEY - FUTURE Program Tile should displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Validate Right-far Tile is tv-gids");
		validateFirstOrRightTile("RIGHT", "tv-gids", 25);
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Press Left Key One By One until Live Tile getting displayed");
		driver.switchTo().frame(getCurrentFrameIndex());
		int noOfTry = 30;
		while (noOfTry != 0) {
			sendKeyMultipleTimes("LEFT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeZapBlock.getText().equalsIgnoreCase(miniEPGNowTitle)) {
				foundLiveTile = true;
				break;
			}
			noOfTry -= 1;
		}
		if (foundLiveTile) {
			reports.log(LogStatus.PASS, "Live Tile getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(":Live Tile not getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("LEFT", 1, 1000);
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGPastTitle)) {
			reports.log(LogStatus.PASS, "Prevoius Tile getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Previous Tile not getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		Thread.sleep(1000);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		System.out.println(imageName);
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Press BACK Key - Full Screen Video is playing successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");
		}
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
	}

	public void verifyMiniEPGLifeSpanOfScheduledRecording() throws InterruptedException, ParseException {
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		String miniEPGFutureTitle = getExcelKeyValue("MiniEPGScreen", "Future", "name_nl");
		String channelWithLeastDuration = getExcelKeyValue("DTVChannel", "ChannelWithLeastDurationEpisode", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
		handlePopupIfExist();
		Thread.sleep(2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (notificationMsg.isDisplayed()) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
				Thread.sleep(2000);
			}
		} catch (NoSuchElementException e) {
		}
		Thread.sleep(2000);
		reports.log(LogStatus.PASS, "Open Zap Screen");
		sendKeySequence("UP", 1000, zapListScreenTitle);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.log(LogStatus.PASS, "Navigate to Not-tuned channel");
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Open Mini EPG Screen");
		sendKeySequence("RIGHT", 800, miniEPGScreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(miniEPGFutureTitle)) {
			reports.log(LogStatus.PASS, "Focus is on Future Tile");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Future Tile");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		String episodeDuration = miniEPGEpisodeDuration.getText().trim().split(" ")[0];
		DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm");
		LocalTime lt = LocalTime.parse(episodeDuration);
		String date1 = df.format(lt.plusMinutes(-5));
		String date2 = df.format(lt.plusMinutes(4));
		System.out.println(date2);
		System.out.println(date1);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Future Program Details Screen");
		reports.log(LogStatus.PASS, "Schedule Recording on Future Episode");
		if (activeInfoMenuItem.getText().equalsIgnoreCase("opname stoppen")) {
			sendKeyMultipleTimes("ENTER", 1, 2000);
			sendKeyMultipleTimes("ENTER", 1, 2000);
			sendKeyMultipleTimes("ENTER", 1, 2000);
			Thread.sleep(3000);
		} else {
			sendKeyMultipleTimes("ENTER", 1, 1000);
			Thread.sleep(3000);
		}
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(futureRecordingIcon, "Future Recording Icon");
		sendKeyMultipleTimes("PAGE_DOWN", 2, 1000);
		reports.log(LogStatus.PASS, "Navigate to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
		handlePopupIfExist();
		Thread.sleep(2000);
		reports.log(LogStatus.PASS, "Open Zap Screen");
		sendKeySequence("UP", 800, zapListScreenTitle);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.log(LogStatus.PASS, "Navigate to Not-tuned channel");
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Open Mini EPG Screen");
		sendKeySequence("RIGHT", 800, miniEPGScreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(futureRecordingIcon, "Future Recording Icon on Future");
		reports.log(LogStatus.PASS, "Navigate to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
		handlePopupIfExist();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		System.out.println(headerTime.getText().split(" ")[4].trim());
		reports.log(LogStatus.PASS, "Wait till pre-recording timespan");
		Date nextEpisodeTime = sdf.parse(date1);
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(date1)
				&& sdf.parse(headerTime.getText().split(" ")[4].trim()).before(nextEpisodeTime)) {
			System.out.println(headerTime.getText());
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		}
		reports.log(LogStatus.PASS, "Open Zap Screen");
		sendKeySequence("UP", 800, zapListScreenTitle);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		reports.log(LogStatus.PASS, "Navigate to Not-tuned channel");
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Open Mini EPG Screen");
		sendKeySequence("RIGHT", 800, miniEPGScreenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(onGoingRecordingIcon, "On Going Recording Icon on Future Tile Pre recording timespan");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		System.out.println(headerTime.getText().split(" ")[4].trim());
		reports.log(LogStatus.PASS, "Wait till start of program");
		nextEpisodeTime = sdf.parse(episodeDuration);
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(episodeDuration)
				&& sdf.parse(headerTime.getText().split(" ")[4].trim()).before(nextEpisodeTime)) {
			System.out.println(headerTime.getText());
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		}
		sendKeySequence("UP", 800, zapListScreenTitle);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeySequence("RIGHT", 800, miniEPGScreenTitle);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(onGoingRecordingIcon, "On Going Recording Icon on Present Tile");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(Integer.parseInt(channelWithLeastDuration));
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		System.out.println(headerTime.getText().split(" ")[4].trim());
		reports.log(LogStatus.PASS, "Wait till  post-recording timespan");
		nextEpisodeTime = sdf.parse(date2);
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(date2)
				&& sdf.parse(headerTime.getText().split(" ")[4].trim()).before(nextEpisodeTime)) {
			System.out.println(headerTime.getText());
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		}
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeySequence("UP", 800, zapListScreenTitle);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeySequence("RIGHT", 800, miniEPGScreenTitle);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(onGoingRecordingIcon, "On Going Recording Icon on Past Tile Post recording timespan");
	}

	public void miniEPGMiniEPGonzaplistNottunedCUTVdisabledchannel() throws InterruptedException {
		// Pressing Up arrow will open Zaplist and verifying the focused tuned
		// channel

		launchDTV(true);
		String zapTitle = TestInitization.getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		String cutvChannel = TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		String miniEPGTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.tuneToChannel(Integer.parseInt(cutvChannel));
		reports.log(LogStatus.PASS, "Pressing up arrow to invoke the zaplist");
		sendKeySequence("UP", 1000, zapTitle);
		launchDTV(true);
		dtvChannelScreen.tuneToChannel(Integer.parseInt(cutvChannel));
		// Pressing down arrow to navigate to CUTV disabled channel
		reports.log(LogStatus.PASS, "Pressing Down arrow to navigate to CUTV disabled channel");
		int maxTry = 20;
		while (maxTry > 0) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() == 0) {
				reports.log(LogStatus.PASS, "CUTV Disabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
			maxTry -= 1;
		}
		reports.log(LogStatus.PASS, "Navigate to Mini EPG screen");
		sendKeySequence("LEFT", 1, miniEPGTitle);
		// Verifying the Titles of the miniEPG screen
		verifyTitleOfMiniEPGScreen();
	}

	public void miniEPGMiniEPGonzaplistNottunedCUTVdisabledchannelPartII() throws InterruptedException {

		// Navigate to Zaplist screen
		String zapTitle = TestInitization.getExcelKeyValue("screenTitles", "ZapList", "name_nl");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);

		handlePopupIfExist();

		reports.log(LogStatus.PASS, "Navigate to Zaplist screen");
		sendKeyMultipleTimes("UP", 1, 1000);
		handlePopupIfExist();

		driver.switchTo().defaultContent();
		String screenTitleZaplist = new EpgScreen(driver).screenTitle.getText();
		if (zapTitle.equalsIgnoreCase(screenTitleZaplist)) {
			reports.log(LogStatus.PASS, "MiniEPG screen has been reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the desired screen");
		}

		// Navigate to miniEpg screen
		reports.log(LogStatus.PASS, "Navigate to MiniEpg screen");
		sendKeySequence("LEFT", 1, getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
		// Pressing back button will return to Zaplist and verifying the same

		reports.log(LogStatus.PASS, "Pressing Back button will navigate to Zaplist screen");
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		ZapList zar = new ZapList(driver);
		driver.switchTo().defaultContent();
		String screenTitileofThePage = zar.screenTitle.getText();
		System.out.println(screenTitileofThePage);
		if (zapTitle.equalsIgnoreCase(screenTitileofThePage)) {
			reports.log(LogStatus.PASS, "Reached to the zaplist page");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not navigate to zaplist");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS, "Pressing Back button from Zaplist screen will navigate to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 500);
		DTVChannelScreen dtvchannel = new DTVChannelScreen(driver);
		dtvchannel.pressPauseButtonAndValidation();
	}

	public void miniEPGMiniEPGTSTVfinishedAiringCUTVdisabledChannel_PartI()
			throws InterruptedException, ParseException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		HashMap<Integer, Long> cutvChanel = getCUTVDisabledChannelMinRemainingTime();
		System.out.println(cutvChanel.toString());
		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		// Pause TV for
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		dtvChannelScreen.pressPlayButtonAndValidation();
		Thread.sleep(6000);

		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(cutvChanel.get(channelKeyWithMinBuffer) * 6000);
		dtvChannelScreen.pressRewindButtonAndValidation();

		Thread.sleep(1800);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		// verifying the TV grid title from extreme left & extreme right

		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);

		sendKeyMultipleTimes("RIGHT", 1, 1000);
		verifyTitleOfMiniEPGScreen();
	}

	public void miniEPGMiniEPGTSTVfinishedAiringCUTVdisabledChannel_PartII()
			throws InterruptedException, ParseException {
		navigateLeftRightToVerifyFutureProgrammeCUTVdisabled();
	}

	public void navigateLeftRightToVerifyFutureProgrammeCUTVEnabled() throws InterruptedException, ParseException {
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		HashMap<Integer, Long> cutvChanel = null;
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		cutvChanel = getCUTVChannelMinRemainingTime();

		System.out.println(cutvChanel.toString());
		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		reports.log(LogStatus.PASS, "Pressing RIGHT key will reach to the MiniEPG Screen");
		sendKeySequence("RIGHT", 500, screenTitle);
		sendKeyMultipleTimes("RIGHT", 1, 800);
		driver.switchTo().frame(getCurrentFrameIndex());
		String nextProgramTitleoftheScreen = programTitle.getText();
		String timingOftheNextProgram = activeTileProgramTime.getText();
		reports.log(LogStatus.PASS, "Pressing RIGHT key to get the Next Program Details");
		reports.attachScreenshot(captureCurrentScreenshot());
		System.out.println("Next Program Title:: " + nextProgramTitleoftheScreen);
		System.out.println("Program Time :" + timingOftheNextProgram);
		reports.log(LogStatus.PASS, "Tune to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Pressing Right key will navigate to EPG screen");
		sendKeyMultipleTimes("RIGHT", 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		System.out.println(headerTime.getText().split(" ")[4].trim());
		String nextProgramTime = timingOftheNextProgram.split(">")[0].trim();

		Date nextEpisodeTime = sdf.parse(nextProgramTime);
		reports.log(LogStatus.PASS, "Moving LEFT & RIGHT in the EPG screen untill the program ends");
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(nextProgramTime)) {
			sendKeyMultipleTimes("LEFT", 1, 500);
			sendKeyMultipleTimes("RIGHT", 1, 500);
			Date currentTime = sdf.parse(headerTime.getText().split(" ")[4].trim());
			if (currentTime.after(nextEpisodeTime)) {
				break;
			}

		}

		driver.switchTo().frame(getCurrentFrameIndex());
		String nextTitleOfTheProgram = programTitle.getText();
		System.out.println("nextTitleOfTheProgram ::" + nextTitleOfTheProgram);
		String timingasPerNextProgram = activeTileProgramTime.getText();
		System.out.println("Program Time :" + timingasPerNextProgram);

		reports.log(LogStatus.PASS, "Verify whether the future program is getting updated or not");
		if (nextTitleOfTheProgram.equalsIgnoreCase(nextProgramTitleoftheScreen)
				&& timingasPerNextProgram.equalsIgnoreCase(timingOftheNextProgram)) {
			reports.log(LogStatus.PASS, "Expected next title of the program:::" + nextProgramTitleoftheScreen
					+ "Current title of the program::::" + nextTitleOfTheProgram + "Timing as per next program ::::"
					+ timingasPerNextProgram + "Timing as on the Next program is ::::" + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(" Expected next title of the program::::" + nextProgramTitleoftheScreen
					+ "Current title of the program::::" + nextTitleOfTheProgram + "Timing as per next program ::::"
					+ timingasPerNextProgram + "Timing as on the Next program is ::::" + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	// Left & Ri
	// Left & Right navigation for CUTVdisabled
	public void navigateLeftRightToVerifyFutureProgrammeCUTVdisabled() throws InterruptedException, ParseException {
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		HashMap<Integer, Long> cutvChanel = null;
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		cutvChanel = getCUTVDisabledChannelMinRemainingTime();

		System.out.println(cutvChanel.toString());
		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();
		handlePopupIfExist();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		reports.log(LogStatus.PASS, "Pressing RIGHT key will reach to the MiniEPG Screen");
		sendKeySequence("RIGHT", 1000, screenTitle);

		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());

		String nextProgramTitleoftheScreen = programTitle.getText();
		System.out.println("Next Program Title:: " + nextProgramTitleoftheScreen);
		String timingOftheNextProgram = activeTileProgramTime.getText();
		System.out.println("Program Time :" + timingOftheNextProgram);

		reports.log(LogStatus.PASS, "Pressing RIGHT key to get the Next Program Details");
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Tune to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);

		reports.log(LogStatus.PASS, "Pressing Right key will navigate to EPG screen");
		sendKeyMultipleTimes("RIGHT", 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		System.out.println(headerTime.getText().split(" ")[4].trim());

		String nextProgramTime = timingOftheNextProgram.split(">")[0].trim();
		System.out.println(nextProgramTime);

		Date nextEpisodeTime = sdf.parse(nextProgramTime);

		reports.log(LogStatus.PASS, "Moving LEFT & RIGHT in the EPG screen untill the program ends");
		while (!headerTime.getText().split(" ")[4].trim().equalsIgnoreCase(nextProgramTime)) {
			sendKeyMultipleTimes("LEFT", 1, 500);
			sendKeyMultipleTimes("RIGHT", 1, 500);
			Date currentTime = sdf.parse(headerTime.getText().split(" ")[4].trim());
			if (currentTime.after(nextEpisodeTime)) {
				break;
			}

		}
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String nextTitleOfTheProgram = programTitle.getText();
		System.out.println("nextTitleOfTheProgram ::" + nextTitleOfTheProgram);
		String timingasPerNextProgram = activeTileProgramTime.getText();
		System.out.println("Program Time :" + timingasPerNextProgram);

		reports.log(LogStatus.PASS, "Verify whether the future program is getting updated or not");
		if (nextTitleOfTheProgram.equalsIgnoreCase(nextProgramTitleoftheScreen)
				&& timingasPerNextProgram.equalsIgnoreCase(timingOftheNextProgram)) {
			reports.log(LogStatus.PASS, "Expected next title of the program:::" + nextProgramTitleoftheScreen
					+ "Current title of the program::::" + nextTitleOfTheProgram + "Timing as per next program ::::"
					+ timingasPerNextProgram + "Timing as on the Next program is ::::" + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(" Expected next title of the program::::" + nextProgramTitleoftheScreen
					+ "Current title of the program::::" + nextTitleOfTheProgram + "Timing as per next program ::::"
					+ timingasPerNextProgram + "Timing as on the Next program is ::::" + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	private HashMap<Integer, Long> getCUTVDisabledChannelMinRemainingTime()
			throws ParseException, InterruptedException {
		long minBufferTime = 0;
		ArrayList<Integer> cutvList = new ArrayList<Integer>();
		cutvList.add(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel_1", "Values")));
		cutvList.add(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel_2", "Values")));
		cutvList.add(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel_3", "Values")));
		cutvList.add(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel_4", "Values")));
		cutvList.add(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel_5", "Values")));
		cutvList.add(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVDisabledChannel_6", "Values")));
		HashMap<Integer, Long> channelTiming = new HashMap<Integer, Long>();
		EpgScreen epgScreen = new EpgScreen(driver);
		ArrayList<String> episodeName = new ArrayList<String>();
		ArrayList<String> episodeTiming = new ArrayList<String>();
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		for (Integer channel : cutvList) {
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			sendNumaricKeys(channel);
			Thread.sleep(2000);
			handlePopupIfExist();
			sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
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
			if (minBufferTime > 2 && minBufferTime < 30) {
				channelTiming.put(channel, minBufferTime);
			}
		}
		return channelTiming;
	}

	public void miniEPG_ongoingAiring_CUTVenabledchannel() throws InterruptedException, ParseException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		reports.log(LogStatus.PASS, "Navigate DTV to find CUTV enabled channel");

		HashMap<Integer, Long> cutvChanel = getCUTVChannelMinRemainingTime();

		System.out.println(cutvChanel.toString());

		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		// Pause TV for
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(6000);

		dtvChannelScreen.pressPlayButtonAndValidation();
		Thread.sleep(cutvChanel.get(channelKeyWithMinBuffer) * 6000);

		dtvChannelScreen.pressRewindButtonAndValidation();
		Thread.sleep(1800);

		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);

		sendKeyMultipleTimes("UP", 1, 2000);

		driver.switchTo().frame(getCurrentFrameIndex());

		isDisplayed(notificationMsg, "Notificaton Message");

		// cancel the program continuation
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);

		// Return to Live TV
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(2000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);

		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);

		// Right click will navigate to miniepg screen
		sendKeySequence("RIGHT", 1000, screenTitle);

		// verifying the TV grid title from extreme left & extreme right
		navigateToMiniEpgAndValidationTV_Gids();

		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);

	}

	public void miniEPG_ongoingAiring_CUTVenabledchannel_partII() throws InterruptedException, ParseException {
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		sendNumaricKeys(
				Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannelToPassForRecording_2", "Values")));
		Thread.sleep(3000);
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Moving to MiniEPG screen");
		sendKeySequence("RIGHT", 1, screenTitle);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(logo, "Previous Program logo");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programTitle, "Previous program title");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programTiming, "Previous program timing");

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(logo, "Current Program logo");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programTitle, "Current program title");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programTiming, "Current program timing");

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(logo, "Future Program logo");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programTitle, "Future program title");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programTiming, "Future program timing");

		// Navigating to MiniEPG untill the program ends
		navigateLeftRightToVerifyFutureProgrammeCUTVEnabled();

		// Auto close miniEPG
		Thread.sleep(1000);
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.pressPauseButtonAndValidation();
	}

	public void mini_EPG_CUTV_ongoingAiring() throws InterruptedException, ParseException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		launchDTV(true);

		HashMap<Integer, Long> cutvChanel = getCUTVChannelMinRemainingTime();

		System.out.println(cutvChanel.toString());

		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);

		// Pause TV for
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(6000);

		dtvChannelScreen.pressPlayButtonAndValidation();
		Thread.sleep(cutvChanel.get(channelKeyWithMinBuffer) * 6000);

		dtvChannelScreen.pressRewindButtonAndValidation();
		Thread.sleep(1800);

		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);

		sendKeyMultipleTimes("UP", 1, 2000);

		driver.switchTo().frame(getCurrentFrameIndex());

		isDisplayed(notificationMsg, "Zapping will interrupt TSTV warning message");

		// cancel the program continuation
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);

		// Return to Live TV
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(2000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);

		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);

		// Right click will navigate to miniepg screen
		sendKeySequence("RIGHT", 1000, screenTitle);

		// verifying the TV grid title from extreme left & extreme right
		navigateToMiniEpgAndValidationTV_Gids();

	}

	public void mini_EPG_CUTV_ongoingAiring_PartII() throws InterruptedException, ParseException {

		// Navigating to MiniEPG untill the program ends
		navigateLeftRightToVerifyFutureProgrammeCUTVEnabled();

		// Waiting for 10 seconds
		reports.log(LogStatus.PASS, "Moving to Live TV");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Moving to MiniEPG Screen");
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		Thread.sleep(10000);
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		reports.log(LogStatus.PASS, "To validate whether reached to MiniEPG screen or not");
		dtv.pressPauseButtonAndValidation();
	}

	public void miniEPG_TSTV_longfinishedairing_CUTVdisabledhannel() throws InterruptedException, ParseException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String screenTitle = TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
		HashMap<Integer, Long> cutvChanel = getCUTVDisabledChannelMinRemainingTime();

		System.out.println(cutvChanel.toString());

		long minValue = Integer.MAX_VALUE;
		int channelKeyWithMinBuffer = 0;
		for (Integer key : cutvChanel.keySet()) {
			Long value = cutvChanel.get(key);
			if (value < minValue) {
				minValue = value;
				channelKeyWithMinBuffer = key;
			}
		}

		// Opening Live TV
		dtvChannelScreen.openLiveTV();

		handlePopupIfExist();
		// Tuning to Channel
		dtvChannelScreen.tuneToChannel(channelKeyWithMinBuffer);
		handlePopupIfExist();
		// Pause TV for
		dtvChannelScreen.pressPauseButtonAndValidation();
		Thread.sleep(6000);

		dtvChannelScreen.pressPlayButtonAndValidation();
		Thread.sleep(cutvChanel.get(channelKeyWithMinBuffer) * 6000);

		dtvChannelScreen.pressRewindButtonAndValidation();
		Thread.sleep(1800);

		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		handlePopupIfExist();

		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);

		// Right click will navigate to miniepg screen
		sendKeySequence("RIGHT", 1000, screenTitle);

		// verifying the TV grid title from extreme left & extreme right
		verifyTitleOfMiniEPGScreen();
	}

	public void miniEPG_TSTV_longfinishedairing_CUTVdisabledhannel_PartII()
			throws InterruptedException, ParseException {
		navigateLeftRightToVerifyFutureProgrammeCUTVdisabled();

	}

}
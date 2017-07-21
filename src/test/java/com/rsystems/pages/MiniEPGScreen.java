package com.rsystems.pages;

import static org.testng.Assert.assertEquals;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.programTitle)
	public WebElement programTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.centerTitle)
	public WebElement centerTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.nextProgramTitle)
	public WebElement nextProgramTitle;

	@FindBy(how = How.XPATH, using = ObjectRepository.MiniEPGScreen.previousProgramTitle)
	public WebElement previousProgramTitle;

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
		sendKeyMultipleTimes("LEFT", 2, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (activeZapBlock.getText().equalsIgnoreCase(previous)) {
			reports.log(LogStatus.PASS, "Previous program is on Left Side");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Previous program tile is not on left side");
		}
		reports.log(LogStatus.PASS, "Future Program tiles should be on Right Side");
		sendKeyMultipleTimes("RIGHT", 3, 500);
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

		TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		reports.log(LogStatus.PASS, "Navigate the next to live program");
		currentTimeTileTime = activeTileProgramTime.getText();
		TestInitization.sendKeySequence("RIGHT", 1000, "televisie");
		driver.switchTo().frame(getCurrentFrameIndex());

		// Forcibly move to live screen and again move next to Live TV
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		TestInitization.sendKeyMultipleTimes("RIGHT", 2, 100);
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
				reports.log(LogStatus.PASS,
						tilenameToValidate + " found after press " + count + " " + keyToPress + " Key");
				return;
			}
			TestInitization.sendKeyMultipleTimes(keyToPress, 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			maxKeyPressCount--;
			count++;
		}

		FailTestCase("Far-" + keyToPress + " tile " + tilenameToValidate + " is not found");
	}

	public void stopLiveTVRecording() throws InterruptedException {

		EpgScreen epgScreen = new EpgScreen(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Press Enter on live Tile");
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
			reports.log(LogStatus.PASS, "Find next day episode in channel number :" + i);
			sendNumaricKeys(i);
			Thread.sleep(1000);
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (cutvIcon.getAttribute("src").contains("cutv-icon.png") || futureOrPast.equalsIgnoreCase("FUTURE")) {
				sendKeySequence("RIGHT", 1000, getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
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
							reports.log(LogStatus.PASS, "Next day episode found in channel number " + i);
							reports.attachScreenshot(captureCurrentScreenshot());
							channelFound = true;
							break;
						}
					}
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
		System.out.println(timingOftheNextProgram.split(">")[1].trim());

		reports.log(LogStatus.PASS, "Moving LEFT & RIGHT in the EPG screen untill the program ends");
		while (!headerTime.getText().split(" ")[4].trim()
				.equalsIgnoreCase(timingOftheNextProgram.split(">")[1].trim())) {
			sendKeyMultipleTimes("LEFT", 1, 500);
			sendKeyMultipleTimes("RIGHT", 1, 500);
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
		System.out.println(timingOftheNextProgram.split(">")[1].trim());

		reports.log(LogStatus.PASS, "Moving LEFT & RIGHT in the EPG screen untill the program ends");
		while (!headerTime.getText().split(" ")[4].trim()
				.equalsIgnoreCase(timingOftheNextProgram.split(">")[1].trim())) {
			sendKeyMultipleTimes("LEFT", 1, 500);
			sendKeyMultipleTimes("RIGHT", 1, 500);
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
			reports.log(LogStatus.PASS,
					"Expected next title of the program " + nextProgramTitleoftheScreen + "Current title of the program"
							+ nextTitleOfTheProgram + "Timing as per next program" + timingasPerNextProgram
							+ "Timing as on the Next program is " + timingOftheNextProgram + "");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Future Program is not getting updated");
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
			reports.log(LogStatus.PASS, "Tune in to LIVE Tv");
			sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());

			sendNumaricKeys(channel);
			Thread.sleep(2000);

			reports.log(LogStatus.PASS, "Moving to TV Guide Screen to pick the shortest program playing");
			sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());

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
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
			reports.log(LogStatus.PASS, "Tune To CUTV Channel " + cutvChannelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not Tuned to CUTV Channel");
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
		sendKeyMultipleTimes("ENTER", 1, 2000);
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
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		driver.switchTo().frame(getCurrentFrameIndex());
		System.out.println(miniEPGChannelName.getAttribute("innerText"));
		if (miniEPGChannelName.getAttribute("innerText").equalsIgnoreCase(futureTitle)) {
			reports.log(LogStatus.PASS, "Focus is on Last Future Program");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus is not on Last Future Program");
		}
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
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
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.className("programCUTV")).getAttribute("src").contains("cutv-icon.png")) {
			reports.log(LogStatus.PASS, "Tune To CUTV Enabled Channel");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not Tuned to CUTV Channel");
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(minEPGScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to far-east tv guide");

		while (true) {
			driver.switchTo().frame(getCurrentFrameIndex());
			if (miniEPGChannelName.getText().equalsIgnoreCase("tv-gids")) {
				reports.log(LogStatus.PASS, "Focus is on " + miniEPGChannelName.getText());
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			} else {
				prevTileEpisodeDuration = miniEPGEpisodeDuration.getText();
				prevTileTitle = miniEPGChannelName.getText();
				sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
		}
		sendKeyMultipleTimes("ENTER", 1, 2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");

		if (new EpgScreen(driver).focusElemntInEpg.getText().equalsIgnoreCase(prevTileTitle)
				&& new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(prevTileEpisodeDuration)) {
			reports.log(LogStatus.PASS, "Focus should on Latest Program Shouwn on Mini EPG- " + prevTileTitle
					+ " Actual focus is on " + new EpgScreen(driver).focusElemntInEpg.getText());
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Focus should on Latest Program Shouwn on Mini EPG- " + prevTileTitle + " Actual focus is on "
					+ new EpgScreen(driver).focusElemntInEpg.getText());
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
		sendKeyMultipleTimes("UP", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
		while (true) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to BlackListed Past Program");
		while (true) {
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
				break;
			}
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
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		String presentTitle = null;
		dtvChannelScreen.openLiveTV();
		sendNumaricKeys(1);
		sendKeyMultipleTimes("UP", 1, 1000);
		validateScreenTitles(zapListScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
		while (true) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
		}
		sendKeyMultipleTimes("RIGHT", 1, 1000);
		validateScreenTitles(miniEPGScreenTitle);
		reports.log(LogStatus.PASS, "Navigate to Non BlackListed Past Program");
		while (true) {
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
				break;
			}
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

	public void validateMiniEPGAccessToNonWatchedCUTVCurrentProgramDetails() throws InterruptedException {
		String zapListScreenTitle = getExcelKeyValue("screenTitles", "ZapList", "name_nl");
        String miniEPGScreenTitle = getExcelKeyValue("screenTitles", "LiveTV", "name_nl");
        
        DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
        dtvChannelScreen.openLiveTV();
        sendNumaricKeys(1);
        Thread.sleep(2000);
        sendKeyMultipleTimes("UP", 1, 1000);
        validateScreenTitles(zapListScreenTitle);
        reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
        while(true)
        {
              sendKeyMultipleTimes("DOWN", 1, 1000);
              driver.switchTo().frame(getCurrentFrameIndex());
              System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
              if(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size()>0)
              {
                    reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
                    reports.attachScreenshot(captureCurrentScreenshot());
                    break;
              }
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
		Thread.sleep(1000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (cutvIcon.getAttribute("src").contains("cutv-icon.png")) {
			reports.log(LogStatus.PASS, "Tuned To CUTV Channel " + cutvChannelNumber);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not Tuned to CUTV Channel");
		}
		Thread.sleep(2000);
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (epgGuide.isDisplayed()) {
				reports.log(LogStatus.PASS, "TV Guide Displayed");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Tv Guide not displayed");
			}
		} catch (NoSuchElementException ex) {
			FailTestCase("TV Guide not displayed");
		}
		driver.switchTo().defaultContent();
		DateFormat sdf = new SimpleDateFormat("hh:mm");
		System.out.println(Calendar.DATE);
		Calendar c = Calendar.getInstance();
		c.add(Calendar.HOUR, -32);
		System.out.println("Before 32 hr: " + c.getTime());
		String day = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
		System.out.println(c.get(Calendar.DAY_OF_MONTH));
		Date date1 = sdf.parse(c.getTime().toString().split(" ")[3]);
		System.out.println(sdf.parse(c.getTime().toString().split(" ")[3]));
		while (true) {
			driver.switchTo().frame(getCurrentFrameIndex());
			sendKeyMultipleTimes("LEFT", 1, 1000);
			if (dayHeading.getText().contains(day)) {
				Date date2 = sdf.parse(new EpgScreen(driver).focusElementProgramTime.getText().split(">")[0].trim());
				System.out.println(date2.before(date1));
				if (date2.before(date1)) {
					System.out.println("Found");
					reports.log(LogStatus.PASS, "CUTV Program started 32 hrs ago found");
					reports.attachScreenshot(captureCurrentScreenshot());

					sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS, "Start playing CUTV playout of program started 32 hrs ago");
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			}
		}
		sendKeyMultipleTimes("ENTER", 1, 3000);
		Thread.sleep(2000);
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
		while (true) {
			sendKeyMultipleTimes("RIGHT", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			if (activeZapBlock.getAttribute("innerText").equalsIgnoreCase("bezig")) {
				reports.log(LogStatus.PASS, "Navigated to Active Episode Tile");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
		}
		reports.log(LogStatus.PASS, "Validate Right-far Tile is tv-gids");
		validateFirstOrRightTile("RIGHT", "tv-gids", 25);
		reports.attachScreenshot(captureCurrentScreenshot());
		while (true) {
			sendKeyMultipleTimes("LEFT", 1, 1000);
			if (activeZapBlock.getText().equalsIgnoreCase("bezig")) {
				reports.log(LogStatus.PASS, "Navigated to Active Episode Tile");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Full Screen Vidoe is playing");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not navigated to Full Scren Video");
		}
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
		launchDTV(true);

		String cutvChannel = TestInitization.getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.tuneToChannel(Integer.parseInt(cutvChannel));
		while (true) {
			sendKeyMultipleTimes("UP", 1, 1000);
			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println(driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size());
			if (driver.findElements(By.xpath(ObjectRepository.MiniEPGScreen.cutvIconOnZapTile)).size() > 0) {
				reports.log(LogStatus.PASS, "CUTV Enabled Channel Found");
				reports.attachScreenshot(captureCurrentScreenshot());
				break;
			}
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

		// Auto Close miniEPG & Zaplist after 10 seconds

		launchDTV(true);
		reports.log(LogStatus.PASS, "Navigate to Mini EPG screen");
		sendKeySequence("RIGHT", 1, getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
		ZapList zar = new ZapList(driver);
		String screenTitileofThePage = zar.screenTitle.getText();
		Thread.sleep(10000);
		reports.log(LogStatus.PASS, "After 10 seconds it should close and returns to Zaplist screen");

		driver.switchTo().defaultContent();

		if (TestInitization.getExcelKeyValue("screenTitles", "ZapList", "name_nl")
				.equalsIgnoreCase(screenTitileofThePage)) {
			reports.log(LogStatus.PASS, "Reached to the zaplist page");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not navigate to zaplist");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		Thread.sleep(10000);
		reports.log(LogStatus.PASS, "After 10 seconds it should close and returns to Full screen live TV");
		reports.attachScreenshot(captureCurrentScreenshot());
		DTVChannelScreen dtvchannel = new DTVChannelScreen(driver);
		reports.log(LogStatus.PASS, "Verifying Play button in Live TV");
		dtvchannel.pressPauseButtonAndValidation();

	}
}
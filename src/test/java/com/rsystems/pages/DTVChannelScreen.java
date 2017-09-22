package com.rsystems.pages;

import java.util.ArrayList;
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
import com.rsystems.pages.RecordingScreen.EpisodeInfo;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class DTVChannelScreen extends TestInitization {

	EpisodeInfo episodeDetails = null;
	WebDriver driver;

	public DTVChannelScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.chnlNoIn_Infobar)
	public WebElement chnlNoIn_Infobar;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programDurationIn_Infobar)
	public WebElement programDurationIn_Infobar;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.programTitle)
	public WebElement programTitle;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.hdIcon)
	public WebElement hdIcon;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.channelLogo)
	public WebElement channelLogo;

	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.pauseAndPlayImg)
	public WebElement pauseAndPlayImg;

	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.backToLive)
	public WebElement backToLive;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.rewindBtn)
	public WebElement rewindBtn;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.DtvChannel.errorMsg)
	public WebElement errorMsg;

	@FindBy(how = How.XPATH, using = ObjectRepository.EpgScreen.focusElementCUTVIcon)
	public WebElement focusElementcutvIcon;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.epgGuideElement)
	public WebElement epgGuide;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.infoBanner)
	public WebElement infoBanner;

	@FindAll({ @FindBy(className = ObjectRepository.MiniEPGScreen.actionItemList) })
	public List<WebElement> actionItemList;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.MiniEPGScreen.programDetailsScreen)
	public WebElement programDetailsScreen;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.stopBtn)
	public WebElement stopBtn;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.enablePausePlayButton)
	public WebElement enablePausePlayButton;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.activeMenuItemElement)
	public WebElement activeInfoMenuItem;

	public void chnlChangeAndValidation(Unicode unicode, String expectedUpChannelNumber, String passmsg)
			throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		int expectedUpChannelNumberToInt = Integer.parseInt(expectedUpChannelNumber);

		TestInitization.sendUnicodeMultipleTimes(unicode.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		int acualChannelNumber = Integer.parseInt(dtvChannelScreen.chnlNoIn_Infobar.getText());

		if (acualChannelNumber == expectedUpChannelNumberToInt) {
			reports.log(LogStatus.PASS, passmsg);
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Unable to move screen on desired location ExpectedChannelNo: " + expectedUpChannelNumberToInt
					+ " Actual Channel Number : " + acualChannelNumber);
		}
	}

	public void changeChnlAndInfoBannerValidation(Unicode unicode) throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		reports.log(LogStatus.PASS, "Channel Change and validation");
		TestInitization.sendUnicodeMultipleTimes(unicode.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());

		// Validation channel info
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.channelLogo, "Channel logo");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		isDisplayed(dtvChannelScreen.programTitle, "Program Title");
	}

	public String openLiveTVAndValidate() throws InterruptedException {

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 0);
		// Get the current TV Channel number
		reports.log(LogStatus.PASS, "Navigate Live TV");
		
		sendNumaricKeys(1);
		Thread.sleep(5000);
		// Open info banner for screenshot
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(chnlNoIn_Infobar, "Channel Number");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		return chnlNoIn_Infobar.getText();
	}
	public void openLiveTV() throws InterruptedException {

		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 0);
		// Get the current TV Channel number
		reports.log(LogStatus.PASS, "Navigate Live TV");
		// Open info banner for screenshot
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
	}

	public void errorMsgValidation(String keyForError, String msg) throws InterruptedException {

		DTVChannelScreen dtvScreen = new DTVChannelScreen(driver);

		sendUnicodeMultipleTimes(keyForError, 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(keyForError, 1, 1000);

		if (dtvScreen.errorMsg.getText().contentEquals(msg)) {

			reports.log(LogStatus.PASS, msg + " visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase(msg + " is not visible on webpage");
		}
	}

	public void navigateToFilmScreenAndRentMovie(String parentCategory, String movieName) throws InterruptedException {

		reports.log(LogStatus.PASS, "Navigate to HUb page");
		setApplicationHubPage(2);
		int maxRetryCount = 20;
		RentMovie rentMovie = new RentMovie(driver);

		reports.log(LogStatus.PASS, "Navigate the filterlayer screen");
		sendKeySequence("RIGHT,ENTER,ENTER", 1000, "shop");
		reports.attachScreenshot(captureCurrentScreenshot());

		/** Loop for enter in parent category */

		reports.log(LogStatus.PASS, "Select " + parentCategory + " category");
		driver.switchTo().frame(getCurrentFrameIndex());

		while (maxRetryCount > 0) {

			// Some time blank tile is highlight so we wrap this code in try
			// catch
			try {

				if (rentMovie.highlighedMovieCategory.getText().contentEquals(parentCategory.trim())) {

					break;
				}
			} catch (NoSuchElementException e) {
			}

			maxRetryCount = maxRetryCount - 1;
			sendKeyMultipleTimes("RIGHT", 1, 1000);

		}

		if (maxRetryCount == 0) {
			FailTestCase("Unable to find category for rent movie");
		}

		/** Loop for find and rent movie */
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Select " + movieName);
		driver.switchTo().frame(getCurrentFrameIndex());
		maxRetryCount = 20;
		while (maxRetryCount > 0) {

			// Some time blank tile is highlight so we wrap this code in try
			// catch
			try {
				if (rentMovie.currentSelectedMovieName.getText().contentEquals(movieName.trim())) {
					break;
				}
			} catch (NoSuchElementException e) {
			}

			maxRetryCount = maxRetryCount - 1;
			sendKeyMultipleTimes("RIGHT", 1, 1000);

		}
		if (maxRetryCount == 0) {
			FailTestCase("Unable to find movie for rent movie");
		}

		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 4000);

	}

	public void pressPauseButtonAndValidation() throws InterruptedException {

		reports.log(LogStatus.PASS, "Press pause button");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		String currentClassName = enablePausePlayButton.getAttribute("class");
		System.out.println("class name " + currentClassName);
		System.out.println(imageName);
		if (imageName.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))
				&& currentClassName.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "Pause Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage.Might be video is not playing on STB");

		}
	}

	public void pressPlayButtonAndValidation() throws InterruptedException {

		reports.log(LogStatus.PASS, "Press play button");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		String currentImgSource = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		String currentClassName = enablePausePlayButton.getAttribute("class");
		System.out.println("class name " + currentClassName);
		if (imageName.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))
				&& currentClassName.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "play Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Pause button is not highlight on webpage");

		}

	}

	public void pressRewindButtonAndValidation() throws InterruptedException {

		reports.log(LogStatus.PASS, "Press rewind button");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 4000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassName);
		if (currentClassName.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "Live TV is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind Live TV");
		}
	}

	public void tuneToChannel(int channelNumber) throws InterruptedException {

		sendNumaricKeys(channelNumber);
		Thread.sleep(2000);
		handlePopupIfExist();
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		if (new DTVChannelScreen(driver).chnlNoIn_Infobar.getText().equalsIgnoreCase(String.valueOf(channelNumber))) {
			reports.log(LogStatus.PASS, "Tuned to Channel " + channelNumber);
			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not Tuned to Channel " + channelNumber);
		}
	}

	public void pressForwardButtonAndValidation() throws InterruptedException {

		Pvr pvr = new Pvr(driver);
		reports.log(LogStatus.PASS, "Press forward button");
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 4000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = pvr.forward.getAttribute("class");
		System.out.println("class name " + currentClassName);
		if (currentClassName.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "Live TV is forwarded");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to forward");
		}
	}

	public EpisodeInfo startRecording(int channelNumber) throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		RecordingScreen recordingElement = new RecordingScreen(driver);
		sendNumaricKeys(channelNumber);
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		String episodeName = dtvChannelScreen.programTitle.getText();
		Thread.sleep(3000);
		EpisodeInfo episodeDetails = null;
		reports.log(LogStatus.PASS, "Navigate to program information screen");
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("DOWN", 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten")) {
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")) {
			episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName,
					recordingElement.getEpisodeDuration(), recordingElement.getChannelDefiniton());
			reports.log(LogStatus.PASS, " Click on opnemen to start recording on - ");
			sendKeyMultipleTimes("ENTER", 1, 1000);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opname stoppen")) {
			sendKeyMultipleTimes("ENTER", 1, 1000);
			sendKeyMultipleTimes("ENTER", 1, 2000);
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten")) {
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")) {
				episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName,
						recordingElement.getEpisodeDuration(), recordingElement.getChannelDefiniton());
				reports.log(LogStatus.PASS, " Click on opnemen to start recording on - ");
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		}
		return episodeDetails;

	}

	public void openCutvEnableChannelFromTvGuide() throws InterruptedException {

		reports.log(LogStatus.PASS, "Open TV Guide.");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Navigae to CUTV Enabled channel action list from tv guide");
		sendNumaricKeys(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		Thread.sleep(5000);
		reports.attachScreenshot(captureCurrentScreenshot());
		reports.log(LogStatus.PASS, "Navigate to action list.");
		sendKeySequence("ENTER", 5000, "televisie");

		reports.log(LogStatus.PASS, "Navigate to watch movie");
		driver.switchTo().frame(getCurrentFrameIndex());
		// isDisplayed(new EpgScreen(driver).herstarten, "Restart button ");
		// sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 4000);

	}

	public String navigateToPastProgramFromTVGuide(int channelNumber) throws InterruptedException {

		openLiveTV();
		tuneToChannel(channelNumber);
		reports.log(LogStatus.PASS, "Open TV Guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 2000);

		// Wait for successfully navigate to given channel
		Thread.sleep(5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		reports.log(LogStatus.PASS, "Navigate to Past Program");
		EpgScreen epgScreen = new EpgScreen(driver);
		String presentTmeStartTime = epgScreen.focusElementProgramTime.getText();
		sendKeyMultipleTimes("LEFT", 2, 1000);
		System.out.println("Current Program Duration " + presentTmeStartTime);
		int noOfTry = 20;
		while (noOfTry > 0) {

			driver.switchTo().frame(getCurrentFrameIndex());
			System.out.println("Focussed Program Duration -" + new EpgScreen(driver).focusElementProgramTime.getText());

			if (!(new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(presentTmeStartTime))) {

				try {
					if (focusElementcutvIcon.getAttribute("src").contains("cutv-icon.png")) {
						sendKeyMultipleTimes("LEFT", 1, 1000);
						reports.log(LogStatus.PASS, "Navigate to Past Program");
						reports.attachScreenshot(captureCurrentScreenshot());
					}
				} catch (NoSuchElementException e) {
					System.out.println("Episode Found");
					reports.log(LogStatus.PASS,
							"Past program found " + new EpgScreen(driver).focusElemntInEpg.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					break;

				}
			} else {
				sendKeyMultipleTimes("LEFT", 1, 1000);
				reports.log(LogStatus.PASS, "Navigate to Past Program");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			noOfTry -= 1;
		}

		return epgScreen.focusElemntInEpg.getText();

	}

	public String tuneToCUTVAndPastReplaybleProgramFromTVGuide() throws InterruptedException {

		reports.log(LogStatus.PASS, "Open TV Guide");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 3000);
		
		sendNumaricKeys(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		Thread.sleep(5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		
		reports.log(LogStatus.PASS, "Navigate to Past Program");
		EpgScreen epgScreen = new EpgScreen(driver);
		
		
		String presentTmeStartTime = epgScreen.focusElementProgramTime.getText();
		System.out.println("Current Program Duration " + presentTmeStartTime);
		int noOfTry = 20;
		while (noOfTry > 0) {
			try {
				driver.switchTo().frame(getCurrentFrameIndex());
				System.out.println(
						"Focussed Program Duration -" + new EpgScreen(driver).focusElementProgramTime.getText());
				System.out.println(focusElementcutvIcon.getAttribute("src"));
				String focustText = new EpgScreen(driver).focusElemntInEpg.getText();
				String title = driver.findElement(By.xpath("//*[@id='title']")).getText();
				if (!(new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(presentTmeStartTime))
						&& focusElementcutvIcon.getAttribute("src").contains("cutv-icon.png")
						&& focustText.equalsIgnoreCase(title)) {
					System.out.println("Episode Found");
					reports.log(LogStatus.PASS,
							"Past Replayble program found " + new EpgScreen(driver).focusElemntInEpg.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException ex) {

			}
			noOfTry -= 1;
			sendKeyMultipleTimes("LEFT", 1, 1000);
			reports.log(LogStatus.PASS, "Navigate to Past Program");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		return epgScreen.focusElemntInEpg.getText();
	}

	public String navigateToPastReplaybleProgramFromTVGuide() throws InterruptedException {

		reports.log(LogStatus.PASS, "Open TV Guide");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 3000);
		handlePopupIfExist();
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		
		reports.log(LogStatus.PASS, "Navigate to Past Program");
		EpgScreen epgScreen = new EpgScreen(driver);
		
		
		String presentTmeStartTime = epgScreen.focusElementProgramTime.getText();
		System.out.println("Current Program Duration " + presentTmeStartTime);
		int noOfTry = 20;
		while (noOfTry > 0) {
			try {
				driver.switchTo().frame(getCurrentFrameIndex());
				System.out.println(
						"Focussed Program Duration -" + new EpgScreen(driver).focusElementProgramTime.getText());
				System.out.println(focusElementcutvIcon.getAttribute("src"));
				String focustText = new EpgScreen(driver).focusElemntInEpg.getText();
				String title = driver.findElement(By.xpath("//*[@id='title']")).getText();
				if (!(new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(presentTmeStartTime))
						&& focusElementcutvIcon.getAttribute("src").contains("cutv-icon.png")
						&& focustText.equalsIgnoreCase(title)) {
					System.out.println("Episode Found");
					reports.log(LogStatus.PASS,
							"Past Replayble program found " + new EpgScreen(driver).focusElemntInEpg.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException ex) {

			}
			noOfTry -= 1;
			sendKeyMultipleTimes("LEFT", 1, 1000);
			reports.log(LogStatus.PASS, "Navigate to Past Program");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		return epgScreen.focusElemntInEpg.getText();
	}

	public void validateMovieExistInGrp(String foundMovieName) throws InterruptedException {
		VodFeatures vodFeatures = new VodFeatures(driver);

		driver.switchTo().frame(getCurrentFrameIndex());

		int maxcount = 20;
		while (maxcount > 0) {
			if (vodFeatures.topMovieHeading.getText().trim().equalsIgnoreCase(foundMovieName.trim())
					|| vodFeatures.topMovieHeading.getAttribute("innerText").trim()
							.equalsIgnoreCase(foundMovieName.trim())) {
				reports.log(LogStatus.PASS, "VOD " + foundMovieName + " found ");
				reports.attachScreenshot(captureCurrentScreenshot());
				return;

			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
			maxcount--;
		}

		maxcount = 20;
		while (maxcount > 0) {
			if (vodFeatures.topMovieHeading.getText().trim().equalsIgnoreCase(foundMovieName.trim())
					|| vodFeatures.topMovieHeading.getAttribute("innerText").trim()
							.equalsIgnoreCase(foundMovieName.trim())) {
				reports.log(LogStatus.PASS, "VOD " + foundMovieName + " found ");
				reports.attachScreenshot(captureCurrentScreenshot());
				return;

			}
			sendKeyMultipleTimes("UP", 1, 1000);
			maxcount--;
		}

		FailTestCase("Movie not found in group Expected Movie name : " + foundMovieName + " Actual movie name : "
				+ vodFeatures.vodHeading.getText());
	}

	public void validateMovieNotExistInGrp(String foundMovieName) throws InterruptedException {
		VodFeatures vodFeatures = new VodFeatures(driver);
		driver.switchTo().frame(getCurrentFrameIndex());

		int maxcount = 20;
		while (maxcount > 0) {
			if (vodFeatures.topMovieHeading.getText().trim().equalsIgnoreCase(foundMovieName.trim())) {
				FailTestCase("Movie found in group " + foundMovieName);
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
			maxcount--;
		}

		maxcount = 20;
		while (maxcount > 0) {
			if (vodFeatures.topMovieHeading.getText().trim().equalsIgnoreCase(foundMovieName.trim())) {
				FailTestCase("Movie found in group " + foundMovieName);
			}
			sendKeyMultipleTimes("UP", 1, 1000);
			maxcount--;
		}
		reports.log(LogStatus.PASS, "Movie " + foundMovieName + "is not found in grp ");
		reports.attachScreenshot(captureCurrentScreenshot());
	}

	public void changeSortingOptionAndValidation(String sortingOption, String FirstMovieName)
			throws InterruptedException {

		boolean sortingOptionFound = false;
		VodFeatures vodFeatures = new VodFeatures(driver);
		sendKeyMultipleTimes("LEFT", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		int maxcount = 20;
		while (maxcount > 0) {
			if (vodFeatures.activeSortOption.getText().equalsIgnoreCase(sortingOption)) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS, "Sorting option " + sortingOption + " has been selected");
				reports.attachScreenshot(captureCurrentScreenshot());
				sortingOptionFound = true;
				break;

			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
			maxcount--;
		}

		maxcount = 20;
		while (maxcount > 0 && !sortingOptionFound) {

			if (vodFeatures.activeSortOption.getText().equalsIgnoreCase(sortingOption)) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS, "Sorting option " + sortingOption + " has been selected");
				reports.attachScreenshot(captureCurrentScreenshot());
				sortingOptionFound = true;
				break;

			}
			sendKeyMultipleTimes("UP", 1, 1000);
			maxcount--;
		}

		if (!sortingOptionFound) {
			FailTestCase(sortingOption + " option is not availiable in sorting pannel");
		}
		RentMovie rentMovie = new RentMovie(driver);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (rentMovie.currentSelectedMovieName.getText().equalsIgnoreCase(FirstMovieName)) {
			reports.log(LogStatus.PASS, "Movie list has been updated. First movie is " + FirstMovieName);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Movie list is not updated Acutal First Movie Name : "
					+ rentMovie.currentSelectedMovieName.getText() + " expected First Movie Name : " + FirstMovieName);
		}

	}

	public String getMovieNameForSpecificCategory(String sortingOption) throws InterruptedException {
		boolean sortingOptionFound = false;
		VodFeatures vodFeatures = new VodFeatures(driver);
		sendKeyMultipleTimes("LEFT", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		int maxcount = 20;
		while (maxcount > 0) {
			if (vodFeatures.activeSortOption.getText().equalsIgnoreCase(sortingOption)) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS, "Sorting option " + sortingOption + " has been selected");
				reports.attachScreenshot(captureCurrentScreenshot());
				sortingOptionFound = true;
				break;

			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
			maxcount--;
		}

		maxcount = 20;
		while (maxcount > 0 && !sortingOptionFound) {

			if (vodFeatures.activeSortOption.getText().equalsIgnoreCase(sortingOption)) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS, "Sorting option " + sortingOption + " has been selected");
				reports.attachScreenshot(captureCurrentScreenshot());
				sortingOptionFound = true;
				break;

			}
			sendKeyMultipleTimes("UP", 1, 1000);
			maxcount--;
		}

		if (!sortingOptionFound) {
			FailTestCase(sortingOption + " option is not availiable in sorting pannel");
		}
		RentMovie rentMovie = new RentMovie(driver);
		driver.switchTo().frame(getCurrentFrameIndex());
		return rentMovie.currentSelectedMovieName.getText();

	}

	public void navigateToFilmScreenVerifyPoster(String postername) throws InterruptedException {

		int maxRetryCount = 40;

		VodFeatures vodFeatures = new VodFeatures(driver);

		reports.log(LogStatus.PASS, "Navigate to the filterlayer screen");
		sendKeySequence("RIGHT,ENTER,ENTER", 1000, "shop");
		reports.attachScreenshot(captureCurrentScreenshot());

		/** Loop for enter in parent category */

		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String posterDetailsNL = vodFeatures.filmsCategoryPoster.getAttribute("src");
		System.out.println(posterDetailsNL);
		while (maxRetryCount > 0) {

			// Some time blank tile is highlight so we wrap this code in try
			// catch
			driver.switchTo().frame(getCurrentFrameIndex());

			try {
				System.out.println(vodFeatures.filmsCategoryPoster.getAttribute("src"));
				System.out.println(postername.trim());
				if (vodFeatures.filmsCategoryPoster.getAttribute("src").trim().contains(postername.trim())) {
					reports.log(LogStatus.PASS, "Poster has been verified");
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException e) {
				FailTestCase("Poster has not been verified");
			}

			maxRetryCount = maxRetryCount - 1;
			sendKeyMultipleTimes("RIGHT", 1, 500);
			Thread.sleep(2000);

		}

		if (maxRetryCount == 0) {
			FailTestCase("Unable to find the poster");
		}
	}

	public void navigateToFilmScreenVerifyDefaultPoster(String parentCategory) throws InterruptedException {

		int maxRetryCount = 20;
		RentMovie rentMovie = new RentMovie(driver);

		reports.log(LogStatus.PASS, "Navigate the filterlayer screen");
		sendKeySequence("RIGHT,ENTER,ENTER", 1000, "shop");
		reports.attachScreenshot(captureCurrentScreenshot());

		/** Loop for enter in parent category */

		reports.log(LogStatus.PASS, "Select " + parentCategory + " category");
		while (maxRetryCount > 0) {

			// Some time blank tile is highlight so we wrap this code in try
			// catch
			driver.switchTo().frame(getCurrentFrameIndex());

			try {
				System.out.println(rentMovie.highlighedMovieCategory.getText());
				System.out.println(parentCategory.trim());
				if (rentMovie.highlighedMovieCategory.getText().equalsIgnoreCase(parentCategory.trim())) {

					break;
				}
			} catch (NoSuchElementException e) {
			}

			maxRetryCount = maxRetryCount - 1;
			sendKeyMultipleTimes("RIGHT", 1, 1000);

		}
	}

	public void pressStopButtonAndValidation() throws InterruptedException {

		reports.log(LogStatus.PASS, "Press Stop button");
		sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 4000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = stopBtn.getAttribute("class");

		System.out.println("class name " + currentClassName);
		if (currentClassName.contentEquals("enable")) {
			reports.log(LogStatus.PASS, "Live TV is Stopped");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to stop Live TV");
		}
	}

	public void pause_LiveTV_PLTV_pause() throws InterruptedException {
		// Recording on Channel
		openLiveTV();
		episodeDetails = startRecording(
				Integer.parseInt(TestInitization.getExcelKeyValue("Recording", "RecordingChannelNumber", "name_nl")));
		recordingOnLiveTv(episodeDetails);

		// After recording Pause Live TV
		openLiveTV();
		reports.log(LogStatus.PASS, "Tuned to another channel to check the Pause Functionality");
		tuneToChannel(3);
		pressPauseButtonAndValidation();

	}

	public void recordingOnLiveTv(EpisodeInfo episodeDetails) throws InterruptedException {
		RecordingScreen record = new RecordingScreen(driver);
		String recordingType = "SINGLE";

		reports.log(LogStatus.PASS, "Navigate to Library Screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 2000);
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim());
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim()
				.equalsIgnoreCase("mijn bibliotheek")) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.id("titleHeading")).getText().equalsIgnoreCase("opnames")) {
			reports.log(LogStatus.PASS, "Recording List getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Recording List not getting displayed");
		}

		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		int recordingSize = Integer.parseInt(record.totalRecordingID.getText());
		for (int i = 0; i < recordingSize; i++) {

			if ((record.focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase(recordingType))) {
				if (record.focusRecordingElement
						.findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording))
						.getText().equalsIgnoreCase(episodeDetails.channelNo)
						&& record.focusRecordingElement
								.findElement(By
										.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording))
								.getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
						&& record.focusRecordingElement
								.findElements(By.cssSelector(".videoQuality .ongoing_recording img")).get(0)
								.getAttribute("src").contains("ico_Ongoing_recording.png")) {
					break;
				} else {
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
				}
			} else {
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
	}

	// Pritam, Check Timeshifting on hdd less STB, Keep STB in timeshift mode
	// for few hours and check how it performs.

	public void hdd_Less_Timeshifting() throws InterruptedException {
		openLiveTV();

		pressPauseButtonAndValidation();
		Thread.sleep(3660000);
		driver.switchTo().frame(getCurrentFrameIndex());
		// validate play video automatically
		String currentImgSource = pauseAndPlayImg.getAttribute("src");
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

		pressRewindButtonAndValidation();
		pressForwardButtonAndValidation();
	}

	/*** Updated Functions ****/
	public void verifyBackToLiveOption() throws InterruptedException {
		String cutvDisabledNumber = getExcelKeyValue("DTVChannel", "CUTVDisabledChannel", "Values");
		String cutvEnabledNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvDisabledNumber));
		Thread.sleep(2000);
		reports.log(LogStatus.PASS, "Navigate to TV Guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		// isDisplayed(epgGuide, "TV Guide");
		sendNumaricKeys(Integer.parseInt(cutvEnabledNumber));
		Thread.sleep(6000);
		reports.log(LogStatus.PASS, "Navigate to CUTV Enabled Channel");
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		EpgScreen epgScreen = new EpgScreen(driver);
		String presentTmeStartTime = epgScreen.focusElementProgramTime.getText();
		System.out.println("Current Program Duration " + presentTmeStartTime);
		int noOfTry = 30;
		while (noOfTry > 0) {
			try {
				driver.switchTo().frame(getCurrentFrameIndex());
				System.out.println(
						"Focussed Program Duration -" + new EpgScreen(driver).focusElementProgramTime.getText());
				System.out.println(focusElementcutvIcon.getAttribute("src"));
				String focustText = new EpgScreen(driver).focusElemntInEpg.getText();
				String title = driver.findElement(By.xpath("//*[@id='title']")).getText();
				if (!(new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(presentTmeStartTime))
						&& focusElementcutvIcon.getAttribute("src").contains("cutv-icon.png")
						&& focustText.equalsIgnoreCase(title)) {
					System.out.println("Episode Found");
					reports.log(LogStatus.PASS,
							"Past Replayble program found " + new EpgScreen(driver).focusElemntInEpg.getText());
					reports.attachScreenshot(captureCurrentScreenshot());
					break;
				}
			} catch (NoSuchElementException ex) {

			}
			noOfTry -= 1;
			sendKeyMultipleTimes("LEFT", 1, 1000);
			reports.log(LogStatus.PASS, "Navigate to Past Program");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		sendKeyMultipleTimes("ENTER", 1, 3000);

		sendKeyMultipleTimes("ENTER", 1, 3000);

		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
				sendKeyMultipleTimes("ENTER", 1, 3000);
			}
		} catch (NoSuchElementException ex) {
		}
		Thread.sleep(2000);
		pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 6000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		wait.until(ExpectedConditions.visibilityOf(programDetailsScreen));
		isDisplayed(programDetailsScreen, "Program Details Screen");
		List<String> menuItemList = new ArrayList<String>();
		for (WebElement we : actionItemList) {
			menuItemList.add(we.getText());
		}
		if (menuItemList.contains("terug naar Live")) {
			reports.log(LogStatus.PASS, "Back To Live Option getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Back to Live Option should be getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void verifyStartOverPastProgram() throws NumberFormatException, InterruptedException {
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(3000);
		handlePopupIfExist();
		navigateToPastReplaybleProgramFromTVGuide();
		String episodeName = new EpgScreen(driver).focusElemntInEpg.getText();
		String episodeDuration = new EpgScreen(driver).focusElementProgramTime.getText();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		reports.log(LogStatus.PASS, "Start Watching Program");
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
				sendKeyMultipleTimes("ENTER", 1, 3000);
			}
		} catch (NoSuchElementException ex) {
		}
		driver.switchTo().frame(getCurrentFrameIndex());
		Thread.sleep(4000);
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Play button is now highlight on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage. Might be Video is not playing in this channel");
		}
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 7000);
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String infoEpisodeDuration = programDurationIn_Infobar.getText();
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 0);
		driver.switchTo().frame(getCurrentFrameIndex());
		String infoProgramTitle = programTitle.getText();
		if (episodeName.equalsIgnoreCase(infoProgramTitle) && infoEpisodeDuration.equalsIgnoreCase(episodeDuration)) {
			reports.log(LogStatus.PASS,
					"Past Program Start playing successfully Expected Episode Name  - " + episodeName
							+ " And Episode Duraion - " + episodeDuration + " Actual Episode Name  - "
							+ infoProgramTitle + " And Episode Duraion - " + infoEpisodeDuration);
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Past Program Start not playing successfully Expected Episode Name  - " + episodeName
					+ " And Episode Duraion - " + episodeDuration + " Actual Episode Name  - " + infoProgramTitle
					+ " And Episode Duraion - " + infoEpisodeDuration);
			sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 0);
			reports.attachScreenshot(captureCurrentScreenshot());
		}
	}

	public void verifyBackToLiveOptionOnSameChannel() throws NumberFormatException, InterruptedException {
		boolean backToLiveFound = false;
		String cutvEnabledNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvEnabledNumber));
		Thread.sleep(3000);
		reports.log(LogStatus.PASS, "Go to TV - Guide");
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		handlePopupIfExist();
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		String liveEpisodeName = new EpgScreen(driver).focusElemntInEpg.getText();
		String liveEpisodeDuration = new EpgScreen(driver).focusElementProgramTime.getText();
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		reports.log(LogStatus.PASS, "Start Watching Video");
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
				sendKeyMultipleTimes("ENTER", 1, 3000);
			}
		} catch (NoSuchElementException ex) {
		}
		pressPauseButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 7000);
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		wait.until(ExpectedConditions.visibilityOf(programDetailsScreen));
		isDisplayed(programDetailsScreen, "Program Details Screen");
		reports.log(LogStatus.PASS, "Click on Back To Live Option");
		List<WebElement> actionItemList = driver.findElements(By.xpath(ObjectRepository.EpgScreen.actionList));
		for (int i = 0; i < actionItemList.size(); i++) {
			if (activeInfoMenuItem.getText().equalsIgnoreCase("terug naar Live")) {
				backToLiveFound = true;
				break;
			} else {
				sendKeyMultipleTimes("DOWN", 1, 2000);
			}
		}
		if (backToLiveFound) {
			reports.log(LogStatus.PASS, "Back To Live Option Found");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Back To Live Option is not present");
		}
	}

	public void verifyActionItemList() throws NumberFormatException, InterruptedException {
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(3000);
		reports.log(LogStatus.PASS,
				"Verify Past Program Action List. Expected Output - kijken should be present in action item list");
		navigateToPastReplaybleProgramFromTVGuide();
		String episodeDuration = new EpgScreen(driver).focusElementProgramTime.getText();
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (actionMenuList().contains("kijken")) {
			reports.log(LogStatus.PASS, "Watch option getting displayed for past program");
			reports.attachScreenshot(captureCurrentScreenshot());
			System.out.println("Program Started");
			sendKeyMultipleTimes("ENTER", 1, 5000);
			driver.switchTo().frame(getCurrentFrameIndex());
			try {
				if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
					sendKeyMultipleTimes("RIGHT", 1, 3000);
					sendKeyMultipleTimes("ENTER", 1, 3000);
				}
			} catch (NoSuchElementException ex) {
			}

		} else {
			FailTestCase("Watch Option should be displayed as part of action Item List");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		navigateToAlreadyStartedPastProgram(Integer.parseInt(cutvChannelNumber), episodeDuration);
		sendKeyMultipleTimes("ENTER", 1, 4000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		sendKeyMultipleTimes("ENTER", 1, 4000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
			reports.log(LogStatus.PASS, "Resume option getting displayed for past program");
			reports.attachScreenshot(captureCurrentScreenshot());
			sendKeyMultipleTimes("ENTER", 1, 5000);
		} else {
			FailTestCase("Resume option should be displayed as part of action Item List");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		reports.log(LogStatus.PASS,
				"Verify Action Items of Current Episode: Expected - herstarten should be displayed");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 3000);
		handlePopupIfExist();
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		if (actionMenuList().contains("herstarten")) {
			reports.log(LogStatus.PASS, "Restart option getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Restart option should be displayed in current program action list");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
		reports.log(LogStatus.PASS,
				"Verify Action Item List for Future Episode. Expected Output - Neither Watch nor Restart option getting displayed");
		sendKeyMultipleTimes("RIGHT", 3, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Future Program Details Screeen");
		if (!(actionMenuList().contains("kijken") || actionMenuList().contains("herstarten"))) {
			reports.log(LogStatus.PASS, "Neither Restart nor Watch option getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Restart or watch option should not be displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);

	}

	private List<String> actionMenuList() {
		List<String> actionMenuList = new ArrayList<String>();
		for (WebElement we : actionItemList) {
			actionMenuList.add(we.getText());
		}
		return actionMenuList;
	}

	public void navigateToAlreadyStartedPastProgram(int channelNumber, String episodeDuration)
			throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate to TV Guide");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 3000);
		handlePopupIfExist();
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.TV_GUIDE.toString(), 1, 1000);
		handlePopupIfExist();
		sendNumaricKeys(channelNumber);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgGuide, "TV Guide");
		int noOfTry = 20;
		while (noOfTry > 0) {
			driver.switchTo().frame(getCurrentFrameIndex());
			String focustText = new EpgScreen(driver).focusElemntInEpg.getText();
			String title = driver.findElement(By.xpath("//*[@id='title']")).getText();
			if (new EpgScreen(driver).focusElementProgramTime.getText().equalsIgnoreCase(episodeDuration)
					&& focustText.equalsIgnoreCase(title)) {
				Thread.sleep(2000);
				System.out.println(new EpgScreen(driver).focusElementProgramTime.getText() + "found");
				reports.log(LogStatus.PASS, "Already Started Watch Program Found - " + title
						+ "Expected Episode Duration -" + episodeDuration);
				reports.attachScreenshot(captureCurrentScreenshot());
				break;

			}
			noOfTry -= 1;
			sendKeyMultipleTimes("LEFT", 1, 3000);
		}
	}

	public void verifyStartOverWatchStartedProgram() throws NumberFormatException, InterruptedException {
		String cutvChannelNumber = getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values");
		openLiveTV();
		sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
		Thread.sleep(4000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (new MiniEPGScreen(driver).notificationMsg.isDisplayed()) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				sendNumaricKeys(Integer.parseInt(cutvChannelNumber));
				Thread.sleep(3000);
			}
		} catch (NoSuchElementException e) {
		}
		navigateToPastReplaybleProgramFromTVGuide();
		String episodeDuration = new EpgScreen(driver).focusElementProgramTime.getText();
		sendKeyMultipleTimes("ENTER", 1, 5000);
		sendKeyMultipleTimes("ENTER", 1, 5000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				sendKeyMultipleTimes("RIGHT", 1, 3000);
				sendKeyMultipleTimes("ENTER", 1, 3000);
			}
		} catch (NoSuchElementException ex) {
		}
		navigateToAlreadyStartedPastProgram(Integer.parseInt(cutvChannelNumber), episodeDuration);
		driver.switchTo().frame(getCurrentFrameIndex());
		String episodeName = new EpgScreen(driver).focusElemntInEpg.getText();
		System.out.println(episodeName);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(programDetailsScreen, "Program Details Screen");
		Thread.sleep(3000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (!driver.findElement(By.id("negative")).getText().contains("verder kijken")) {
				FailTestCase("Resume option should be dispalyed for already watched past program");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				sendKeyMultipleTimes("ENTER", 1, 3000);
				Thread.sleep(3000);
				pressPauseButtonAndValidation();
				sendKeyMultipleTimes("ENTER", 1, 3000);
				sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 3000);
				sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 3, 0);
				driver.switchTo().frame(getCurrentFrameIndex());
				String infoProgramTitle = programDurationIn_Infobar.getText();
				sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 3, 0);
				driver.switchTo().frame(getCurrentFrameIndex());
				String episode = programTitle.getText();
				System.out.println(episodeName + " " + episode + "  " + infoProgramTitle + " " + episodeDuration);
				if (episodeName.equalsIgnoreCase(episode) && infoProgramTitle.equalsIgnoreCase(episodeDuration)) {
					reports.log(LogStatus.PASS, "Past Program Start playing successfully");
					reports.attachScreenshot(captureCurrentScreenshot());
				} else {
					FailTestCase("Past Program not playing successfully");
					reports.attachScreenshot(captureCurrentScreenshot());
				}
			}
		} catch (NoSuchElementException ex) {
		}
	}

	public void Pause_LiveTV_PLTV_interworking_with_menu() throws InterruptedException {
		EpgScreen epg = new EpgScreen(driver);
		ZapList zap = new ZapList(driver);
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Tuning to any channel number");
		tuneToChannel(3);
		pressPauseButtonAndValidation();
		Thread.sleep(120000);
		reports.log(LogStatus.PASS, "Moving to the EPG screen");
		sendUnicodeMultipleTimes(Unicode.VK_TVGUIDE.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epg.displayChannelDescription, "Epg screen Text");
		reports.log(LogStatus.PASS, "Moving to the Hub screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		isDisplayed(zap.screenTitle, "Home title in the menu");
		reports.log(LogStatus.PASS, "Tuning to the same channel number to verify the buffer");
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		sendNumaricKeys(3);
		Thread.sleep(3000);
		driver.switchTo().frame(getCurrentFrameIndex());
		System.out.println(new MiniEPGScreen(driver).notificationMsg.isDisplayed());
		try {
			if (new MiniEPGScreen(driver).notificationMsg.isDisplayed()) {
				reports.log(LogStatus.PASS, "Live TV buffer has been interrupted");
				reports.attachScreenshot(captureCurrentScreenshot());

			} else {
				FailTestCase("No buffer has been created");
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		}
	}

	public void TP001_CUTV_Trick_play_menu_from_Full_screenTV() throws InterruptedException {
		Pvr pvr = new Pvr(driver);
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, "Programme is getting played");
		clickToContinue();
		reports.attachScreenshot(captureCurrentScreenshot());
		handlePopupIfExist();
		pressForwardButtonAndValidation();
		pressRewindButtonAndValidation();
		pressPauseButtonAndValidation();
		pressPlayButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Live TV forwarded thorugh Trick Play Bar Icon");
		sendKeyMultipleTimes("RIGHT", 2, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = pvr.forward.getAttribute("class");
		System.out.println("class name " + currentClassName);
		if (currentClassName.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "Running streaming is forwarded");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to forward the running streaming");
		}

		reports.log(LogStatus.PASS, "Live TV is played thorugh Trick Play Bar Icon");
		sendKeyMultipleTimes("LEFT", 2, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		String currentImgSource = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];
		String currentClassNameForPlay = enablePausePlayButton.getAttribute("class");
		System.out.println("class name " + currentClassNameForPlay);
		if (imageName.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))
				&& currentClassNameForPlay.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "play Successfully");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Pause button is not highlight on webpage");

		}

		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		reports.log(LogStatus.PASS, "Live TV is rewind thorugh Trick Play Bar Icon");
		sendKeyMultipleTimes("LEFT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassNameRewind = rewindBtn.getAttribute("class");
		System.out.println("class name " + currentClassNameRewind);
		if (currentClassNameRewind.contentEquals("enable active")) {
			reports.log(LogStatus.PASS, "Running streaming is rewind");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {

			FailTestCase("Unable to rewind the running streaming");
		}

	}

	public void clickToContinue() throws InterruptedException {
		driver.switchTo().frame(getCurrentFrameIndex());
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@id='containerDiv']"))));
		sendKeyMultipleTimes("ENTER", 1, 2000);
	}

	public void TP002_CUTV_RC_Keys_during_Trickplay() throws InterruptedException {
		ActivateInfobanner activateInfobanner = new ActivateInfobanner(driver);
		EpgScreen epgScreen = new EpgScreen(driver);
		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Menu key though RC ");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "home", "name_nl"))) {
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Menu Screen not getting displayed");
		}

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressRewindButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Ondemand Hot key though RC");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.xpath(ObjectRepository.StoreFilterLayer.shopScreen)).getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "OnDemandMenu", "name_nl"))) {

			reports.log(LogStatus.PASS, "Ondemand Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("On demand Screen not getting displayed");
		}

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing PVR key through RC");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl"))) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		driver.switchTo().frame(getCurrentFrameIndex());
		String presentTmeStartTime = epgScreen.focusElementProgramTime.getText();
		System.out.println(presentTmeStartTime);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressRewindButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Back key through RC");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 2, 1000);
		String currentProgramTime = activateInfobanner.duration.getText();
		System.out.println(currentProgramTime);
		if (presentTmeStartTime.equalsIgnoreCase(currentProgramTime)) {
			reports.log(LogStatus.PASS, "CUTV is not interrupted and Playing the same programme");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Current programme in CUTV has been interrupted");
		}

		pressPauseButtonAndValidation();

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Back key through RC");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		if (presentTmeStartTime.equalsIgnoreCase(currentProgramTime)) {
			reports.log(LogStatus.PASS, "CUTV is not interrupted and Playing the same programme");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Current programme in CUTV has been interrupted");
		}
		pressPauseButtonAndValidation();

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing PVR key through RC");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl"))) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}

		sendUnicodeMultipleTimes(Unicode.VK_TV.toString(), 1, 1000);
		tuneToChannel(Integer.parseInt(getExcelKeyValue("DTVChannel", "CUTVEnabledChannel", "Values")));
		navigateToPastReplaybleProgramFromTVGuide();
		sendKeyMultipleTimes("ENTER", 1, 1000);
		clickToContinue();
		handlePopupIfExist();
		pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Ondemand Hot key though RC");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		if (driver.findElement(By.xpath(ObjectRepository.StoreFilterLayer.shopScreen)).getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "OnDemandMenu", "name_nl"))) {

			reports.log(LogStatus.PASS, "Ondemand Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("On demand Screen not getting displayed");
		}

	}
}

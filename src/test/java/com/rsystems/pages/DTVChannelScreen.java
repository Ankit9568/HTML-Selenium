package com.rsystems.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.pages.RecordingScreen.EpisodeInfo;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class DTVChannelScreen extends TestInitization {

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

			reports.log(LogStatus.FAIL, msg + " is not visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());

		}
	}

	public void navigateToFilmScreenAndRentMovie(String parentCategory, String movieName) throws InterruptedException {

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
		sendKeyMultipleTimes("ENTER", 1, 1000);

	}

	public void pressPauseButtonAndValidation() throws InterruptedException {

		reports.log(LogStatus.PASS, "Press pause button");
		TestInitization.sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 2000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String currentImgSource = pauseAndPlayImg.getAttribute("src");
		String[] currentImgToArr = currentImgSource.split("/");
		String imageName = currentImgToArr[(currentImgToArr.length) - 1];

		System.out.println(imageName);
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
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
		if (imageName
				.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PauseButtonImageName", "Values"))) {
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
	 public void pressForwardButtonAndValidation() throws InterruptedException{
			
		    Pvr pvr = new Pvr(driver);
			reports.log(LogStatus.PASS, "Press forward button");
			sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 4000);
			reports.attachScreenshot(captureCurrentScreenshot());

			
			driver.switchTo().frame(getCurrentFrameIndex());
			String currentClassName = pvr.forward.getAttribute("class");
			System.out.println("class name " + currentClassName);
			if (currentClassName.contentEquals("enable active")) 
			{
				reports.log(LogStatus.PASS, "Live TV is forwarded");
				reports.attachScreenshot(captureCurrentScreenshot());
			} 
			else {

				FailTestCase("Unable to forward Live TV");
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
			if(recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
			{
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")){
				episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName, recordingElement.getEpisodeDuration(),recordingElement.getChannelDefiniton());
				reports.log(LogStatus.PASS, " Click on opnemen to start recording on - ");
				sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.attachScreenshot(captureCurrentScreenshot());
			}
			else if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opname stoppen")){
				sendKeyMultipleTimes("ENTER", 1, 1000);
				sendKeyMultipleTimes("ENTER", 1, 2000);
				sendKeyMultipleTimes("DOWN", 1, 1000);
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				if(recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("herstarten"))
				{
					sendKeyMultipleTimes("DOWN", 1, 1000);
				}
				if (recordingElement.activeInfoMenuItem.getText().equalsIgnoreCase("opnemen")){
					episodeDetails = recordingElement.new EpisodeInfo(recordingElement.getChannelNo(), episodeName, recordingElement.getEpisodeDuration(),recordingElement.getChannelDefiniton());
					reports.log(LogStatus.PASS, " Click on opnemen to start recording on - ");
					sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.attachScreenshot(captureCurrentScreenshot());
				}
			}
			return episodeDetails;

		}

}

package com.rsystems.pages;

import org.openqa.selenium.By;
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

public class Pvr extends TestInitization {
	WebDriver driver;
	EpisodeInfo episodeDetails = null;

	public Pvr(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.pauseAndPlayImg)
	public WebElement pauseAndPlayImg;

	@FindBy(how = How.ID, using = ObjectRepository.DtvChannel.forward)
	public WebElement forward;

	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.playerBar)
	public WebElement playerBar;

	@FindBy(how = How.XPATH, using = ObjectRepository.ZapListPage.screenTitle)
	public WebElement screenTitle;

	public void navigateToThePVRPlayback(EpisodeInfo episodeDetails) throws InterruptedException {


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

              if ((record.focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
              {
                    if (record.focusRecordingElement.findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
                && record.focusRecordingElement.findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName))
                    {
                          break;
                    } 
                    else 
                    {
                          TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
                    }
                } 
              else 
              {
                    TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
              }
        }
        sendKeyMultipleTimes("ENTER", 1, 1000);
        sendKeyMultipleTimes("ENTER", 1, 1000);
        sendKeyMultipleTimes("ENTER", 1, 1000);

        reports.log(LogStatus.PASS, "PVR Playback video is playing");
        Thread.sleep(3000);
        sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 3000);
        reports.attachScreenshot(captureCurrentScreenshot());
        driver.switchTo().frame(getCurrentFrameIndex());
        String currentImgSource = new DTVChannelScreen(driver).pauseAndPlayImg.getAttribute("src");
        String[] currentImgToArr = currentImgSource.split("/");
        String imageName = currentImgToArr[(currentImgToArr.length) - 1];
        if (imageName
                    .equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
              reports.log(LogStatus.PASS, "Playback Video is playing.Play button is now highlight on webpage");
              reports.attachScreenshot(captureCurrentScreenshot());
        }

        else {
              FailTestCase("Play button is not highlight on webpage. Might be Video is not playing in this channel");
        }

	}

	public void PvrPlayBackMenu() throws InterruptedException {

        DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
        dtvChannelScreen.openLiveTV();
        handlePopupIfExist();
        episodeDetails = new DTVChannelScreen(driver).startRecording(Integer.parseInt(TestInitization.getExcelKeyValue("Recording", "RecordingChannelNumber", "name_nl")));

        navigateToThePVRPlayback(episodeDetails);
        handlePopupIfExist();

        dtvChannelScreen.pressForwardButtonAndValidation();

        dtvChannelScreen.pressRewindButtonAndValidation();

        dtvChannelScreen.pressForwardButtonAndValidation();

        dtvChannelScreen.pressPlayButtonAndValidation();

        dtvChannelScreen.pressPauseButtonAndValidation();

        reports.log(LogStatus.PASS, "Stop the Video Playback");
        sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
        reports.attachScreenshot(captureCurrentScreenshot());
        driver.switchTo().defaultContent();
        String libraryScreenTitle=screenTitle.getText();
        if(libraryScreenTitle.equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl")))
        {
              reports.log(LogStatus.PASS, "Successfully reached to the library screen");
              reports.attachScreenshot(captureCurrentScreenshot());
              
        }
        else
        {
              FailTestCase("Libary screen has not been reached");
        }
        

	}

	public void PvrRcTrickPlay() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		handlePopupIfExist();
		reports.log(LogStatus.PASS, "Start Recording to verify PVR Playback");
		EpisodeInfo episodeDetails = new DTVChannelScreen(driver).startRecording(
				Integer.parseInt(TestInitization.getExcelKeyValue("Recording", "RecordingChannelNumber", "name_nl")));
		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();

		reports.log(LogStatus.PASS, "Returning to the Main Menu");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")) {
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}

		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressRewindButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the Ondemand Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")) {
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Shop Screen not getting displayed");
		}

		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the PVR hot key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();

		System.out.println(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText());
		System.out.println(getExcelKeyValue("screenTitles", "Library", "name_nl"));
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl"))) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);

		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();

		dtvChannelScreen.pressRewindButtonAndValidation();

		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressPauseButtonAndValidation();

		dtvChannelScreen.pressForwardButtonAndValidation();

		dtvChannelScreen.pressRewindButtonAndValidation();

		dtvChannelScreen.pressPauseButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the PVR button");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText()
				.equalsIgnoreCase("mijn bibliotheek")) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

		TestInitization.setApplicationHubPage(2);

		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressPauseButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the Ondemand hot key button");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")) {
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Shop Screen not getting displayed");
		}

		navigateToThePVRPlayback(episodeDetails);
		handlePopupIfExist();
		dtvChannelScreen.pressPauseButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the Menu button");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().defaultContent();

		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")) {
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}

	public void VODplayback() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		handlePopupIfExist();
		
		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		setApplicationHubPage(2);

	}

	public void VodRCKeysTrickplay() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		handlePopupIfExist();
		
		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Press on the Menu key");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")) {
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();

		reports.log(LogStatus.PASS, "Press on Demand Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")) {
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();

		reports.log(LogStatus.PASS, "Press on PVR Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText()
				.equalsIgnoreCase("mijn bibliotheek")) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 3000);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();
		dtvChannelScreen.pressPauseButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing the PVR key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText()
				.equalsIgnoreCase("mijn bibliotheek")) {
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		handlePopupIfExist();
		dtvChannelScreen.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing the on demand hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")) {
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		sendKeyMultipleTimes("ENTER", 1, 3000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		handlePopupIfExist();
		dtvChannelScreen.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Press Menu key hot key");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if (driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")) {
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}

	public void TP003_TSTV_Trick_playmenufromFullscreen_TV() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		dtv.openLiveTV();
		handlePopupIfExist();
		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 1000);
		Thread.sleep(10000);
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 3000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
		dtv.pressRewindButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 2000);
		dtv.pressForwardButtonAndValidation();
		dtv.pressPauseButtonAndValidation();
		dtv.pressPlayButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_ADD_RECORDING.toString(), 1, 1000);
		try {
			if (playerBar.isDisplayed()) {
				reports.log(LogStatus.PASS, "Recording button is highlighted");
			}

			else {
				reports.log(LogStatus.PASS, "Nothing should happen in case of Recording Button");
				reports.attachScreenshot(captureCurrentScreenshot());

			}
		} catch (NoSuchElementException e) {
			reports.log(LogStatus.PASS, "Nothing should happen in case of Recording Button");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.pressStopButtonAndValidation();

	}

	public void TP006_DTV_RC_Keys_Trickplay() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		String expectedScreenTitleMenu = getExcelKeyValue("screenTitles", "home", "name_nl");
		System.out.println(expectedScreenTitleMenu);
		String expectedScreenTitleOndemandScreen = getExcelKeyValue("screenTitles", "Shop", "name_nl");
		System.out.println(expectedScreenTitleOndemandScreen);
		String expectedScreenTitlePVRScreen = getExcelKeyValue("screenTitles", "Library", "name_nl");
		System.out.println(expectedScreenTitlePVRScreen);

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressRewindButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Menu Screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 500);
		driver.switchTo().defaultContent();
		String menuTitle = screenTitle.getText();
		System.out.println(menuTitle);
		if (expectedScreenTitleMenu.equalsIgnoreCase(menuTitle)) {
			reports.log(LogStatus.PASS, "Menu Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Menu Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Ondemand Screen");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String onDemandScreenTitle = screenTitle.getText();
		System.out.println(onDemandScreenTitle);
		if (expectedScreenTitleOndemandScreen.equalsIgnoreCase(onDemandScreenTitle)) {
			reports.log(LogStatus.PASS, "Ondemand Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Ondemand Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressRewindButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the PVR screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String PVRScreenTitle = screenTitle.getText();
		System.out.println(PVRScreenTitle);
		if (expectedScreenTitlePVRScreen.equalsIgnoreCase(PVRScreenTitle)) {
			reports.log(LogStatus.PASS, "PVR Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the PVR Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Back Key");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		dtv.openLiveTV();
		handlePopupIfExist();
		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Back Key");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the PVR screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String PVRScreenTitleTwo = screenTitle.getText();
		if (expectedScreenTitlePVRScreen.equalsIgnoreCase(PVRScreenTitleTwo)) {
			reports.log(LogStatus.PASS, "PVR Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the PVR Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Ondemand screen");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		String onDemandScreenTitleTwo = screenTitle.getText();
		if (expectedScreenTitleOndemandScreen.equalsIgnoreCase(onDemandScreenTitleTwo)) {
			reports.log(LogStatus.PASS, "Ondemand Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Ondemand Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Menu screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String menuTitleTwo = screenTitle.getText();
		if (expectedScreenTitleMenu.equalsIgnoreCase(menuTitleTwo)) {
			reports.log(LogStatus.PASS, "Menu Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Menu Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

	public void TP005_DTV_Trick_playmenufromFullscreen_TV() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		Pvr pvr = new Pvr(driver);
		dtv.openLiveTV();
		sendNumaricKeys(16);
		// Forwarding video should not happen anything
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 4000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String currentClassName = pvr.forward.getAttribute("class");
		System.out.println("class name " + currentClassName);
		try {
			if (currentClassName.contentEquals("enable active")) {
				FailTestCase("Forward button is highlighted");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				reports.log(LogStatus.PASS, "Forward button is not highlighted");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		} catch (NoSuchElementException e) {
			reports.log(LogStatus.PASS, "Forward button is not highlighted");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		Thread.sleep(8000);
		
		
		// rewind & validate
		dtv.pressRewindButtonAndValidation();

		// pause & validate
		dtv.pressPauseButtonAndValidation();

		// play & validate
		dtv.pressPlayButtonAndValidation();

		// stop & validate
		dtv.pressStopButtonAndValidation();
	}

	public void TP004_TSTV_RC_Keys_during_Trickplay() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		String expectedScreenTitleMenu = getExcelKeyValue("screenTitles", "home", "name_nl");
		String expectedScreenTitleOndemandScreen = getExcelKeyValue("screenTitles", "Shop", "name_nl");
		String expectedScreenTitlePVRScreen = getExcelKeyValue("screenTitles", "Library", "name_nl");
		dtv.openLiveTV();

		// If notification message appears
		handlePopupIfExist();

		dtv.pressRewindButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Menu Screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String menuTitle = screenTitle.getText();
		if (expectedScreenTitleMenu.equalsIgnoreCase(menuTitle)) {
			reports.log(LogStatus.PASS, "Menu Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Menu Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();
		handlePopupIfExist();

		dtv.pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Ondemand screen");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		String onDemandScreenTitleTwo = screenTitle.getText();
		if (expectedScreenTitleOndemandScreen.equalsIgnoreCase(onDemandScreenTitleTwo)) {
			reports.log(LogStatus.PASS, "Ondemand Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Ondemand Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();

		handlePopupIfExist();

		sendUnicodeMultipleTimes(Unicode.VK_PAUSE.toString(), 1, 5000);
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);

		dtv.pressRewindButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the PVR screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String PVRScreenTitleTwo = screenTitle.getText();
		if (expectedScreenTitlePVRScreen.equalsIgnoreCase(PVRScreenTitleTwo)) {
			reports.log(LogStatus.PASS, "PVR Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the PVR Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();

		handlePopupIfExist();

		dtv.pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Back Key");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
		dtv.pressPlayButtonAndValidation();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing Back Key");
		sendUnicodeMultipleTimes(Unicode.VK_BACKWARD.toString(), 1, 1000);
		dtv.pressPlayButtonAndValidation();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the PVR screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String PVRScreenTitleThree = screenTitle.getText();
		if (expectedScreenTitlePVRScreen.equalsIgnoreCase(PVRScreenTitleThree)) {
			reports.log(LogStatus.PASS, "PVR Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the PVR Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();

		handlePopupIfExist();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Ondemand screen");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		String onDemandScreenTitleThree = screenTitle.getText();
		if (expectedScreenTitleOndemandScreen.equalsIgnoreCase(onDemandScreenTitleThree)) {
			reports.log(LogStatus.PASS, "Ondemand Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Ondemand Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		dtv.openLiveTV();

		handlePopupIfExist();

		dtv.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Moving to the Menu Screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		driver.switchTo().defaultContent();
		String menuTitleTwo = screenTitle.getText();
		if (expectedScreenTitleMenu.equalsIgnoreCase(menuTitleTwo)) {
			reports.log(LogStatus.PASS, "Menu Screen is reached");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Not reached to the Menu Screen");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

	}

}

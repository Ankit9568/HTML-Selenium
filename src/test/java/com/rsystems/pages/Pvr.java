package com.rsystems.pages;

import org.openqa.selenium.By;
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

public class Pvr extends TestInitization
{
	WebDriver driver;
	EpisodeInfo episodeDetails = null;
	public Pvr(WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.XPATH, using = ObjectRepository.DtvChannel.pauseAndPlayImg)
	public WebElement pauseAndPlayImg;
	
	@FindBy(how = How.ID,using = ObjectRepository.DtvChannel.forward)
	public WebElement forward;
	
	
	public void navigateToThePVRPlayback(EpisodeInfo episodeDetails) throws InterruptedException
	{
		
		// Start a recording
		

		RecordingScreen record = new RecordingScreen(driver);
		String recordingType = "SINGLE";
		
		
		reports.log(LogStatus.PASS, "Navigate to Library Screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 2000);
		driver.switchTo().defaultContent();
		System.out.println(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim().equalsIgnoreCase("mijn bibliotheek"))
		{
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		sendKeyMultipleTimes("ENTER", 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		if(driver.findElement(By.id("titleHeading")).getText().equalsIgnoreCase("opnames"))
		{
			reports.log(LogStatus.PASS, "Recording List getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Recording List not getting displayed");
		}
		
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		int recordingSize = Integer.parseInt(record.totalRecordingID.getText());
		for(int i = 0 ; i< recordingSize;i++)
		{
			
			if((record.focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (record.focusRecordingElement.findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				record.focusRecordingElement.findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				record.focusRecordingElement.findElements(By.cssSelector(".videoQuality .ongoing_recording img")).get(0).getAttribute("src").contains("ico_Ongoing_recording.png")
						)
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
		if (imageName.equalsIgnoreCase(TestInitization.getExcelKeyValue("DTVChannel", "PlayButtonImageName", "Values"))) {
			reports.log(LogStatus.PASS, "Playback Video is playing.Play button is now highlight on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		else {
			FailTestCase("Play button is not highlight on webpage. Might be Video is not playing in this channel");
		}
		
		
	}

	public void PvrPlayBackMenu() throws InterruptedException
	{

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		episodeDetails = new DTVChannelScreen(driver).startRecording(Integer.parseInt(TestInitization.getExcelKeyValue("Recording","RecordingChannelNumber", "name_nl")));
		
		navigateToThePVRPlayback(episodeDetails);

		dtvChannelScreen.pressForwardButtonAndValidation();
		
		
		dtvChannelScreen.pressRewindButtonAndValidation();
	
		dtvChannelScreen.pressForwardButtonAndValidation();
		
		dtvChannelScreen.pressPlayButtonAndValidation();
		
        dtvChannelScreen.pressPauseButtonAndValidation();

		
		reports.log(LogStatus.PASS, "Stop the Video Playback");
		sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		EpgScreen epgScreen = new EpgScreen(driver);
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(epgScreen.displayChannelDescription, "Channel Description");
	}	

	public void PvrRcTrickPlay() throws InterruptedException
	{
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		dtvChannelScreen.openLiveTV();
		reports.log(LogStatus.PASS, "Start Recording to verify PVR Playback");
		EpisodeInfo episodeDetails = new DTVChannelScreen(driver).startRecording(Integer.parseInt(TestInitization.getExcelKeyValue("Recording","RecordingChannelNumber", "name_nl")));
		navigateToThePVRPlayback(episodeDetails);
		
		dtvChannelScreen.pressForwardButtonAndValidation();

		reports.log(LogStatus.PASS, "Returning to the Main Menu");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		
		navigateToThePVRPlayback(episodeDetails);
		
		dtvChannelScreen.pressRewindButtonAndValidation();
		
		reports.log(LogStatus.PASS, "Pressing on the Ondemand Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
	
		navigateToThePVRPlayback(episodeDetails);
		
		dtvChannelScreen.pressForwardButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the PVR hot key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		
		System.out.println(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText());
		System.out.println(getExcelKeyValue("screenTitles", "Library", "name_nl"));
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().trim().equalsIgnoreCase(getExcelKeyValue("screenTitles", "Library", "name_nl"))){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		
		navigateToThePVRPlayback(episodeDetails);
	
		dtvChannelScreen.pressForwardButtonAndValidation();


		dtvChannelScreen.pressRewindButtonAndValidation();
		
		navigateToThePVRPlayback(episodeDetails);
		
		dtvChannelScreen.pressPauseButtonAndValidation();

		
		 dtvChannelScreen.pressForwardButtonAndValidation();
		
		dtvChannelScreen.pressRewindButtonAndValidation();
		

        dtvChannelScreen.pressPauseButtonAndValidation(); 
		
		reports.log(LogStatus.PASS, "Pressing on the PVR button");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		
		
		TestInitization.setApplicationHubPage(2);
		
		navigateToThePVRPlayback(episodeDetails);
		
		dtvChannelScreen.pressPauseButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the Ondemand hot key button");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1,1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
	
		navigateToThePVRPlayback(episodeDetails);
		
		dtvChannelScreen.pressPauseButtonAndValidation();

		reports.log(LogStatus.PASS, "Pressing on the Menu button");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(),1,1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		
		driver.switchTo().defaultContent();
		
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}

	public void VODplayback() throws InterruptedException
	{
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		
		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();
		
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		setApplicationHubPage(2);

		
	}

	public void VodRCKeysTrickplay() throws InterruptedException
	{
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		
		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressForwardButtonAndValidation();
		reports.log(LogStatus.PASS, "Press on the Menu key");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1,0);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		
		
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		
		
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 3000);
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		
		
		dtvChannelScreen.pressForwardButtonAndValidation();
		
		reports.log(LogStatus.PASS, "Press on Demand Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 3000);
		sendKeyMultipleTimes("ENTER", 1	, 3000);
		
		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();
		
		reports.log(LogStatus.PASS, "Press on PVR Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 3000);
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		

		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressPauseButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();
		dtvChannelScreen.pressPauseButtonAndValidation();
	
		reports.log(LogStatus.PASS, "Pressing the PVR key");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("mijn bibliotheek")){
			reports.log(LogStatus.PASS, "Library Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 3000);
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		
		dtvChannelScreen.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Pressing the on demand hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("shop")){
			reports.log(LogStatus.PASS, "Shop Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Shop Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");
		TestInitization.setApplicationHubPage(2);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		
		sendKeyMultipleTimes("ENTER", 1	, 3000);
		sendKeyMultipleTimes("ENTER", 1	, 1000);
		dtvChannelScreen.pressPauseButtonAndValidation();
		reports.log(LogStatus.PASS, "Press Menu key hot key");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(),1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());	
		driver.switchTo().defaultContent();
		if(driver.findElement(By.xpath(ObjectRepository.ZapListPage.screenTitle)).getText().equalsIgnoreCase("home")){
			reports.log(LogStatus.PASS, "Menu Screen getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		else
		{
			FailTestCase("Library Screen not getting displayed");
		}
		reports.log(LogStatus.PASS, "Returning to the Hub Menu");

	}
 
}

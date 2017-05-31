package com.rsystems.pages;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class RecordingScreen extends TestInitization{

	/**
	 * This function is used to get Episode Name.
	 * Created By Rahul Dhoundiyal
	 */
	public static String getInfoEpisodeName()
	{
		return driver.findElement(By.xpath(ObjectRepository.RecordingElements.InfoEpisodeNameXPath)).getText();
	}
	/**
	 * This function is used to get Channel Number.
	 * Created By Rahul Dhoundiyal
	 */
	public static String getChannelNo()
	{
		return driver.findElement(By.className(ObjectRepository.RecordingElements.ChannelNoClassName)).getText();
	}
	/**
	 * This function is used to get Channel Info Image.
	 * Created By Rahul Dhoundiyal
	 */
	public static String getChannelInfoImage()
	{
		String[] channelInfoImageUrl = driver.findElement(By.xpath(ObjectRepository.RecordingElements.ChannelInfoImageXPath)).getAttribute("src").split("/"); 
		return channelInfoImageUrl[channelInfoImageUrl.length-1];
	}
	/**
	 * This function is used to get Episode Duration.
	 * Created By Rahul DHoundiyal
	 */
	public static String getEpisodeDuration()
	{
		return driver.findElement(By.xpath(ObjectRepository.RecordingElements.EpisodeDurationXPath)).getText();
	}
	/**
	 * This function is used to get Channel Definition.
	 * Created By Rahul Dhoundiyal
	 */
	public static String getChannelDefiniton()
	{ 
		String channelDefString = null;
		try
		{
			WebElement definitionElement = driver.findElement(By.xpath(ObjectRepository.RecordingElements.ProgramDefinitionXPath));
			channelDefString = definitionElement.getAttribute("src");
		}
		catch(NoSuchElementException ne)
		{
			channelDefString = null;
		}
		return channelDefString;
	}
	/**
	 * This class is used to set the details of program
	 * @author Rahul.Dhoundiyal
	 *
	 */
	public static class EpsiodeInfo {
		public String channelNo;
		public String programName;
		public String programInfoImage;
		public String programDuration;
		public String programDefiniton;
		public EpsiodeInfo(String channelNo, String programName, String programInfoImage, String programDuration,String programDefiniton) {
			this.channelNo = channelNo;
			this.programName = programName;
			this.programInfoImage = programInfoImage;
			this.programDuration = programDuration;
			this.programDefiniton = programDefiniton;
		}
	}
	/**
	 * This function is used to navigate to Planning Menu Under Library Screen
	 * Created By Rahul Dhoundiyal
	 */
	public static void moveToPlanning() throws InterruptedException
	{	driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		TestInitization.setApplicationHubPage(2);
		//Move to My Library
		TestInitization.sendKeySequence("DOWN,LEFT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));
		//Move to Planning
		TestInitization.sendKeySequence("DOWN,DOWN,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));
	}
	/**
	 * This function is used to start recording on future channel.It will return the episode details like channel number,program name,Info Image,Channel Definition
	 * Created By Rahul Dhoundiyal
	 */
	public static EpsiodeInfo startRecordingForFutureChannel(String recordingType) throws InterruptedException{
		//Move to Future Epsiode
		TestInitization.sendKeySequence("UP,ENTER,RIGHT,RIGHT,RIGHT", 1000,TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
		//Enter to open Episode Info
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		EpsiodeInfo programDetails = new EpsiodeInfo(RecordingScreen.getChannelNo(), RecordingScreen.getInfoEpisodeName(), RecordingScreen.getChannelInfoImage(), RecordingScreen.getEpisodeDuration(),RecordingScreen.getChannelDefiniton());
		if(recordingType == "SINGLE"){
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 5000);
		}
		else
		{
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 5000);
			TestInitization.sendKeyMultipleTimes("ENTER", 1, 5000);
		}
		return programDetails;
	}

	/**
	 * This function is used to delete recording from scheduled recorded list under planning option of Library
	 * Created By Rahul Dhoundiyal
	 */
	public static void deleteSchduledRecording(EpsiodeInfo episodeDetails,String recordingType) throws InterruptedException{
		moveToPlanning();
		//Recording.moveToSingleAsset(recordedAssetName);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ChannelLogoInPlannedRecording)).getCssValue("background").contains(episodeDetails.programInfoImage)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
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
		//Enter to Info Page
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		//Click on Delete
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.INFO,"Expected - Should be in Info box to delete "+episodeDetails.programName + " Actual - Delete option should be displayed to delete "+episodeDetails.programName);
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
	}
	/**
	 * This function is used to verify the recording is scheduled properly or not.
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	public static boolean verifyRecordingIsScheduledOrNot(EpsiodeInfo episodeDetails,String recordingType) throws InterruptedException {
		boolean verifyRecording = false;
		//Move to planning
		moveToPlanning();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (! (episodeDetails.programDefiniton == null) && recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDefinitionInPlannedRecording)).getAttribute("src").equalsIgnoreCase(episodeDetails.programDefiniton)){
					verifyRecording = true;
				}
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ChannelLogoInPlannedRecording)).getCssValue("background").contains(episodeDetails.programInfoImage)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					verifyRecording = true;
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
		return verifyRecording;
	}

	/**
	 * This function is used to verify the recording is deleted properly or not.
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	public static boolean verifyRecordingisDeletedOrNot(EpsiodeInfo episodeDetails, String recordingType) throws InterruptedException {
		boolean verifyRecording = true;
		//Move to planning
		moveToPlanning();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ChannelLogoInPlannedRecording)).getCssValue("background").contains(episodeDetails.programInfoImage)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					verifyRecording = false;
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
		return verifyRecording;
	}
}

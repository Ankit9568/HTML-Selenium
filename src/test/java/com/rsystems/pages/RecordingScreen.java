package com.rsystems.pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class RecordingScreen extends TestInitization{
	
	WebDriver driver;
	public RecordingScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.InfoEpisodeNameXPath)
	public WebElement getInfoEpisodeName;
	
	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.RecordingElements.ChannelNoClassName)
	public WebElement getChannelNo;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.RecordingElements.ChannelInfoImageXPath)
	public WebElement getChannelInfoImage;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.RecordingElements.EpisodeDurationXPath)
	public WebElement getEpisodeDuration;
	
	
	@FindBy(how = How.XPATH, using = ObjectRepository.RecordingElements.ProgramDefinitionXPath)
	public WebElement getChannelDefiniton;
	
	@FindBy(how = How.ID,using = ObjectRepository.RecordingElements.totalRecordingsID)
	public WebElement totalRecordingID;
	
	@FindBy(how = How.XPATH,using = ObjectRepository.RecordingElements.focusRecordingElementXPath)
	public WebElement focusRecordingElement;

	@FindBy(how = How.ID,using = ObjectRepository.RecordingElements.currentRecordingCountID)
	public WebElement currentRecordingCountID;
	
	/**
	 * This function is used to get Episode Name.
	 * Created By Rahul Dhoundiyal
	 */
	public String getInfoEpisodeName()
	{
		return getInfoEpisodeName.getText();
	}
	/**
	 * This function is used to get Channel Number.
	 * Created By Rahul Dhoundiyal
	 */
	public String getChannelNo()
	{
		return getChannelNo.getText();
	}
	/**
	 * This function is used to get Channel Info Image.
	 * Created By Rahul Dhoundiyal
	 */
	public String getChannelInfoImage()
	{
		String[] channelInfoImageUrl = getChannelInfoImage.getAttribute("src").split("/"); 
		return channelInfoImageUrl[channelInfoImageUrl.length-1];
	}
	/**
	 * This function is used to get Episode Duration.
	 * Created By Rahul DHoundiyal
	 */
	public String getEpisodeDuration()
	{
		return getEpisodeDuration.getText();
	}
	/**
	 * This function is used to get Channel Definition.
	 * Created By Rahul Dhoundiyal
	 */
	public String getChannelDefiniton()
	{ 
		String channelDefString = null;
		try
		{
			channelDefString = getChannelDefiniton.getAttribute("src");
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
	public class EpsiodeInfo {
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
	public void moveToPlanning() throws InterruptedException
	{	driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		TestInitization.setApplicationHubPage(2);
		//Move to My Library
		reports.log(LogStatus.PASS, " Navigate to mijn bibliotheek Screen ");
		TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
		reports.log(LogStatus.PASS, " mijn bibliotheek Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Move to Planning
		reports.log(LogStatus.PASS, " Navigate to mijn planning Screen ");
		TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
		TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
		TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
		reports.log(LogStatus.PASS, " mijn planning Screen getting displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	}
	/**
	 * This function is used to start recording on future channel.It will return the episode details like channel number,program name,Info Image,Channel Definition
	 * Created By Rahul Dhoundiyal
	 */
	public List<EpsiodeInfo> startRecordingForFutureChannel(String recordingType,int numberOfRecording) throws InterruptedException{
		boolean stopRecording = false;
		int noOfRecordedChannel = 0;
		List<EpsiodeInfo> programDetails = new ArrayList<EpsiodeInfo>();
		//Move to Future Epsiode
		TestInitization.setApplicationHubPage(1);
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, " DTV Channel Screen getting Displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.sendKeySequence("RIGHT",1000,TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
		reports.log(LogStatus.PASS, " Mini EPG Screen Displayed ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		while(!stopRecording){
			if (numberOfRecording != noOfRecordedChannel)
			{
					TestInitization.sendKeySequence("RIGHT", 1000,TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
					reports.log(LogStatus.PASS, " Navigate to Future Episode Screen ");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					if(recordingType.equalsIgnoreCase("SINGLE")){
						//Enter to open Episode Info
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 2000);
						reports.log(LogStatus.PASS, " Episode Info Screen getting displayed ");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						if (driver.findElement(By.xpath(ObjectRepository.RecordingElements.StartRecordingXPath)).getText().equalsIgnoreCase("opnemen")){
							programDetails.add(new EpsiodeInfo(getChannelNo(), getInfoEpisodeName(), getChannelInfoImage(), getEpisodeDuration(),getChannelDefiniton()));
							reports.log(LogStatus.PASS, " Click on opnemen to start recording on - "+getInfoEpisodeName());
							TestInitization.sendKeyMultipleTimes("ENTER", 1, 10000);
							reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
							noOfRecordedChannel += 1;
						}
						else 
						{	reports.log(LogStatus.PASS, " Already recording is scheduled on  " + getInfoEpisodeName() + " epsiode. Unable to record this episode");
							reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
							TestInitization.sendKeyMultipleTimes("PAGE_DOWN", 1, 5000);
							reports.log(LogStatus.PASS," Going back and Navigate to another Channel");
							reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						}
					}
					else
					{
						TestInitization.sendKeyMultipleTimes("DOWN", 1, 5000);
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 5000);
					}
			}
			else
			{
				stopRecording = true;
				break;
			}
		}
		return programDetails;
	}

	/**
	 * This function is used to delete recording from scheduled recorded list under planning option of Library
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteSchduledRecording(EpsiodeInfo episodeDetails,String recordingType) throws InterruptedException{
		moveToPlanning();
		//Recording.moveToSingleAsset(recordedAssetName);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		reports.log(LogStatus.PASS, " Navigate to "+ episodeDetails.programName +" recording ");
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				(recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ChannelLogoInPlannedRecording)).getCssValue("background").contains(episodeDetails.
						programInfoImage) || !(episodeDetails.programInfoImage.contains(".jpg")))&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
					reports.log(LogStatus.PASS, "Episode - "+ episodeDetails.programName + " found ");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					break;
				}
				else
				{	
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
				}
			}
			else
			{
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}
			
		}
		//Enter to Info Page
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		//Click on Delete
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS,"Expected Output - " +episodeDetails.programName +" Info Screen should be displayed with Delete Option " + " Actual Output - " +episodeDetails.programName+" Info Screen getting displayed with Delete Option ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, episodeDetails.programName + " Recording Deleted Successfully");
	}
	/**
	 * This function is used to verify the recording is scheduled properly or not.
	 * Created By Rahul Dhoundiyal
	 * 
	 */
	public boolean verifyRecordingIsScheduledOrNot(EpsiodeInfo episodeDetails,String recordingType) throws InterruptedException {
		boolean verifyRecording = false;
		//Move to planning
		moveToPlanning();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<WebElement> recordingContentElementList;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		reports.log(LogStatus.PASS, " Navigate to Scheduled Recording(geplande opnames) ");
		for(int i=0;i<recordingContentElementList.size();i++)
		{
			if((recordingContentElementList.get(i).getAttribute("assetvolume").equalsIgnoreCase(recordingType)))
			{
				if (! (episodeDetails.programDefiniton == null) && recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDefinitionInPlannedRecording)).getAttribute("src").equalsIgnoreCase(episodeDetails.programDefiniton)){
					verifyRecording = true;
				}
				if (recordingContentElementList.get(i).findElement(By.className(ObjectRepository.RecordingElements.ChannelNoInPlannedRecording)).getText().equalsIgnoreCase(episodeDetails.channelNo)
				&&
				(recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ChannelLogoInPlannedRecording)).getCssValue("background").contains(episodeDetails.
						programInfoImage) || !(episodeDetails.programInfoImage.contains(".jpg")))
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
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
	public boolean verifyRecordingisDeletedOrNot(EpsiodeInfo episodeDetails, String recordingType) throws InterruptedException {
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
				(recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ChannelLogoInPlannedRecording)).getCssValue("background").contains(episodeDetails.
						programInfoImage) || !(episodeDetails.programInfoImage.contains(".jpg")))&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramNameInPlannedRecording)).getAttribute("innerText").equalsIgnoreCase(episodeDetails.programName)
				&&
				recordingContentElementList.get(i).findElement(By.cssSelector(ObjectRepository.RecordingElements.ProgramDurationInPlannedRecording)).getText().split("-")[1].trim().equalsIgnoreCase(episodeDetails.programDuration))
				{
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
	
	/**
	 * This function is used to verify navigation under recordings under planned recording
	 * @return
	 * Created By Rahul Dhoundiyal
	 */
	public boolean verifyNavigationInRecording() throws InterruptedException {
		//Move to Planning under Library Section
		moveToPlanning();
		boolean verifyDownwardNavigation = false;
		boolean verifyUpwardNavigation = false;
		String countNumber = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		
		String totalRecordings = totalRecordingID.getText();
		/*If there is no recording scheduled the first start multiple recording then test this scenario*/
		if (Integer.parseInt(totalRecordings) == 0)
		{
			startRecordingForFutureChannel("SINGLE", 5);
			verifyNavigationInRecording();
		}
		/*Navigate down till last element of schdeule recording*/ 
		reports.log(LogStatus.INFO, " Navigate down till the last element of schdeuled recordings ");
		for(int i=0;i<Integer.parseInt(totalRecordings);i++){
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		reports.log(LogStatus.PASS," Verify Focus is on last element and will not go down anymore ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		countNumber = currentRecordingCountID.getText();
		//Send Down Key to verify list is end and Down Key is not working
		reports.log(LogStatus.INFO," Send DOWN Key to verify if focus is removed from last element or not ");
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		//Verify the count number should not change
		Assert.assertEquals(countNumber, currentRecordingCountID.getText());
		reports.log(LogStatus.PASS,"Focus is on last element will not go down anymore");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if(countNumber.equalsIgnoreCase(currentRecordingCountID.getText()))
		{
			verifyDownwardNavigation = true;
		}
		//Going Upward
		/*Navigate down till last element of schdeule recording*/ 
		reports.log(LogStatus.INFO, " Navigate up till the top element of schdeuled recordings ");
		for(int i=0;i<Integer.parseInt(totalRecordings);i++){
			TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		}
		reports.log(LogStatus.PASS," Verify Focus is on top element and will not go up anymore ");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		countNumber = currentRecordingCountID.getText();
		//Send Down Key to verify list is end and Down Key is not working
		reports.log(LogStatus.INFO," Send UP Key to verify if focus is removed from top element or not ");
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		//Verify the count number should not change
		Assert.assertEquals(countNumber, currentRecordingCountID.getText());
		reports.log(LogStatus.PASS,"Focus is on top element will not go up anymore");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		if(countNumber.equalsIgnoreCase(currentRecordingCountID.getText()))
		{
			verifyUpwardNavigation = true;
		}
		return (verifyDownwardNavigation && verifyUpwardNavigation);		
	}
	/**
	 * This function is used to delete all Single Recordings from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteSingleRecordings() throws InterruptedException {
		moveToPlanning();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		Integer totalRecordings = Integer.parseInt(totalRecordingID.getText());
		for(int i=0;i<totalRecordings;i++)
		{
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if(focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SINGLE")){
				//Enter to Info Page
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				//Click on Delete
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS,"Recording Deleted Successfully");
			}
			else{
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			}		
		}	
	}
	/**
	 * This function is used to delete all Series Recordings from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteSeriesRecordins() throws InterruptedException {
		moveToPlanning();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		Integer totalRecordings = Integer.parseInt(totalRecordingID.getText());
		for(int i=0;i<totalRecordings;i++)
		{
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			if(focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SERIES")){
				TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
				reports.log(LogStatus.PASS,"Expected - Info box containing Series Recordings");
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				List<WebElement> recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
				for(int j=0;j<recordingContentElementList.size();j++)
				{
					//Enter to Info Page
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					//Click on Delete
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Recording Deleted Successfully");
				}
			}
		}
	}
	/**
	 * This function is used to delete all Recordings from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public void deleteAllRecordings() throws InterruptedException{
		moveToPlanning();
		List<WebElement> recordingContentElementList = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		Integer totalRecordings = 0;
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		/*If there is no recordings under Scheduled Recording then first start recording for multiple episode and try again to deleteAll*/
		if (recordingContentElementList.size() == 0)
		{
			reports.log(LogStatus.PASS, "No Recordings present to delete");
			startRecordingForFutureChannel("SINGLE", 3);
			deleteAllRecordings();
		}
		else
		{
			totalRecordings = Integer.parseInt(totalRecordingID.getText());
			for(int i=0;i<totalRecordings;i++)
			{
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				if(focusRecordingElement.getAttribute("assetvolume").equalsIgnoreCase("SINGLE"))
				{
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					//Click on Delete
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					reports.log(LogStatus.PASS,"Recording Deleted Successfully");;
				}
				else{
					TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
					driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
					recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
					int noOfSeries = recordingContentElementList.size();
					for(int j=0;j<noOfSeries;j++)
					{
						reports.log(LogStatus.PASS,"Expected - Info box containing Series Recordings");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						//Enter to Info Page
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						//Click on Delete
						driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS,"Expected - Should be in Info box to delete");
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
						reports.log(LogStatus.PASS,"Recording Deleted Successfully");
					}
				}
				
			}
		}
	}
	/**
	 * This function is used to verify all recordings getting deleted from Planned recordings
	 * Created By Rahul Dhoundiyal
	 */
	public boolean verifyAllRecordingsgDeleted() throws InterruptedException {
		moveToPlanning();
		List<WebElement> recordingContentElementList = null;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		recordingContentElementList = driver.findElements(By.cssSelector(ObjectRepository.RecordingElements.RecordingListCSSSelector));
		String totalRecordings = totalRecordingID.getText();
		if((recordingContentElementList.size() == 0) && (Integer.parseInt(totalRecordings) == 0))
		{
			Assert.assertEquals(Integer.parseInt(totalRecordings), 0);
			Assert.assertEquals(recordingContentElementList.size(), 0);
			return true;
		}
		else
		{
			return false;
		}
	}
}
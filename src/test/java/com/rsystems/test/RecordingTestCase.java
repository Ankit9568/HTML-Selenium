package com.rsystems.test;
import java.util.List;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.pages.RecordingScreen.EpsiodeInfo;
import com.rsystems.utils.TestInitization;
public class RecordingTestCase extends TestInitization {

	List<EpsiodeInfo> episodeDetails = null;
	/**
	 *  This test cases is used to schedule recording and verifying recording is started successfully or not
	 *  Created By Rahul Dhoundiyal
	 */
	@Test(priority = 1)
	public void verifyStartSingleRecording() throws InterruptedException{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		episodeDetails = recordingScreen.startRecordingForFutureChannel("SINGLE",1);
		boolean verifyRecording = recordingScreen.verifyRecordingIsScheduledOrNot(episodeDetails.get(0),"SINGLE");
		if (verifyRecording)
		{	
			reports.log(LogStatus.PASS, "Expected Output - Recording should be scheduled for " +episodeDetails.get(0).programName+ " Actual - Recoring getting scheduled for " + episodeDetails.get(0).programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Output - Recording should be scheduled for " +episodeDetails.get(0).programName+ " Actual - Recoring not getting scheduled for " + episodeDetails.get(0).programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		
	}
	/**
	 *  This test cases is used to delete recording and verifying recording is deleted or not
	 *  Created By Rahul Dhoundiyal
	 */
	@Test(priority = 2)
	public void verifySingleAssetIsDeleted() throws InterruptedException
	{	
		//Delete recording
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		recordingScreen.deleteSchduledRecording(episodeDetails.get(0),"SINGLE");
		boolean verifyRecordingDeleted = recordingScreen.verifyRecordingisDeletedOrNot(episodeDetails.get(0),"SINGLE");
		if (verifyRecordingDeleted){
			reports.log(LogStatus.PASS, "Expected Output - Scheduled Recording should be deleted for " + episodeDetails.get(0).programName + " Actual Output - Scheduled Recording getting deleted for " + episodeDetails.get(0).programName + " successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());	
		}
		else
		{
			reports.log(LogStatus.FAIL, "Expected Output - Scheduled Recording should be deleted for " + episodeDetails.get(0).programName + " Actual Output - Scheduled Recording not getting deleted for " + episodeDetails.get(0).programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
	/**
	 * This test case is used to set multiple single recordings
	 * Created By Rahul Dhoundiyal
	 */	
	@Test(priority = 3)
	public void verifyMultipleSingleRecordings() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		reports.log(LogStatus.INFO,"Start Recording for 5 future episodes");
		List<EpsiodeInfo> listOfAddedRecordings = recordingScreen.startRecordingForFutureChannel("SINGLE",5);
		for (EpsiodeInfo epsiodeInfo : listOfAddedRecordings) {
			boolean verifyMultipleSingleRecordings = recordingScreen.verifyRecordingIsScheduledOrNot(epsiodeInfo,"SINGLE");		
			if (verifyMultipleSingleRecordings)
			{
				reports.log(LogStatus.PASS, "Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recoring getting scheduled for " + epsiodeInfo.programName);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else
			{
				reports.log(LogStatus.FAIL, "Expected Output - Recording should be scheduled for " +epsiodeInfo.programName+ " Actual - Recoring not getting scheduled for " + epsiodeInfo.programName);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
		}
		
	}
	/**
	 * This test case is used to navigate under planned recordings
	 * Created By Rahul Dhoundiyal
	 */	
	@Test(priority = 4)
	public void navigateUnderPlannedRecordings() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		boolean verifyNavigation = recordingScreen.verifyNavigationInRecording();
		if(verifyNavigation){
			reports.log(LogStatus.PASS, " Naivgation is properly for scheduled recordings ");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL," Navigation is not properly for scheduled recordings ");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
	/**
	 * This test cases is used to delete and verify all recordings from scheduled recordings
	 * Created By Rahul Dhoundiyal
	 */
	@Test(priority = 5)
	public void deleteAllRecordings() throws InterruptedException
	{
		RecordingScreen recordingScreen = new RecordingScreen(driver);
		System.out.println("Start Deleting All Scheduled Recordings");
		recordingScreen.deleteAllRecordings();
		boolean verifyDeleteAllRecordings = recordingScreen.verifyAllRecordingsgDeleted();
		if (verifyDeleteAllRecordings)
		{
			reports.log(LogStatus.PASS,"All recordings got deleted successfully");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			reports.log(LogStatus.FAIL,"All recording not got deleted");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
}
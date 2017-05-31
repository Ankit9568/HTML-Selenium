package com.rsystems.test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.RecordingScreen;
import com.rsystems.pages.RecordingScreen.EpsiodeInfo;
import com.rsystems.utils.TestInitization;

import junit.framework.Assert;
public class RecordingTestCase extends TestInitization {

	EpsiodeInfo episodeDetails = null;
	/**
	 *  This test cases is used to schedule recording and verifying recording is started successfully or not
	 *  Created By Rahul Dhoundiyal
	 */
	@Test(priority = 1)
	public void verifyStartSingleRecording() throws InterruptedException{
		episodeDetails = RecordingScreen.startRecordingForFutureChannel("SINGLE");
		boolean verifyRecoriding = RecordingScreen.verifyRecordingIsScheduledOrNot(episodeDetails,"SINGLE");
		if (verifyRecoriding)
		{	
			Assert.assertEquals(true, verifyRecoriding);
			reports.log(LogStatus.PASS, "Recording is started :: Expected - Recording should scheduled on Asset" +episodeDetails.programName + " Actual - Recoring scheduled on " + episodeDetails.programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
		else
		{
			Assert.assertEquals(false, verifyRecoriding);
			reports.log(LogStatus.FAIL, "Recording is started :: Expected - Recording should scheduled on Asset" +episodeDetails.programName + " Actual - Recoring scheduled on " + episodeDetails.programName);
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
		RecordingScreen.deleteSchduledRecording(episodeDetails,"SINGLE");
		boolean verifyRecordingDeleted = RecordingScreen.verifyRecordingisDeletedOrNot(episodeDetails,"SINGLE");
		if (verifyRecordingDeleted){
			Assert.assertEquals(true, verifyRecordingDeleted);
			reports.log(LogStatus.PASS, "Recording should be deleted deleted :: Expected - Recording should deleted on Asset" +episodeDetails.programName + " Actual - Recoring deleted for " + episodeDetails.programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());	
		}
		else
		{
			Assert.assertEquals(false, verifyRecordingDeleted);
			reports.log(LogStatus.FAIL, "Recording should be deleted :: Expected - Recording should deleted on Asset" +episodeDetails.programName + " Actual - Recoring not deleted for " + episodeDetails.programName);
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		}
	}
}
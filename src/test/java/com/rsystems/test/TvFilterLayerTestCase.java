package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.LibraryScreen;
import com.rsystems.pages.TvFilterLayer;
import com.rsystems.utils.TestInitization;

public class TvFilterLayerTestCase extends TestInitization
{
	
	/*
	 * This test case is checking the TV Filter Layer Screen 
	 */
	
	
	
	@Test
	public void verifyTvFilterLayerScreen() throws InterruptedException
	{
		TvFilterLayer tv= new TvFilterLayer(driver);
		if(tv.tvFilterLayerVerify())
		{
			reports.log(LogStatus.PASS, "Content in the TV filter layer screens has been matched");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			System.out.println("Content has been matched");
		}
		else
		{
			FailTestCase("Content in the TV filter layer screens has not been matched");
		}
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 * Test cases is used to verify two lines in TV Filter Layer screen
	 */
	@Test
	public void tc_SF003_TV() throws InterruptedException{
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		reports.log(LogStatus.PASS, "Press OK Button");
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.log(LogStatus.PASS, "Verify Two Lines getting displayed on TV Filter Page");
		libraryScreen.verifyTwoLinesInLibraryScreen("Level2");
		libraryScreen.verifyOpactiyOfLines();
	}
}

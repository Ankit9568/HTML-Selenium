package com.rsystems.test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.VodFeatures;
import com.rsystems.utils.TestInitization;

public class VodFeaturesTestCase extends TestInitization
{

	@Test
	 public void tc_BCVODVD0118_naviagteToVODTrailer() throws InterruptedException
	 {
		 VodFeatures vod = new VodFeatures(driver);
		 if(vod.naviagteToVideoOndemandScreen())
		 {
			 reports.log(LogStatus.PASS, "Navigation to VOD trailer test case passed");
			 System.out.println("Navigation to VOD trailer is OK");
			 
		 }
		 else
		 {
			 FailTestCase("Navigation to VOD trailer and program running is Failed");
		 }
	 }
	 
	 @Test
	 public void tc_BCVODVD0101_navigateToOndemandScreenHotKey() throws InterruptedException
	 {

			VodFeatures vod = new VodFeatures(driver);
		    if(vod.navigateToVideoOnDemandScreenHotkey())
		    {
		    	reports.log(LogStatus.PASS, "Navigation to VOD test case on demand Screen via hot key is passed");
				System.out.println("Navigation to VOD on demand screen is OK");
		    }
		    else
		    {
		    	FailTestCase("Navigation to VOD on demand screen is Failed");
		    }
		 
	 }
	
	 
}

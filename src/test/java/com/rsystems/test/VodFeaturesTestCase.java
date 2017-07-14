package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.VodFeatures;
import com.rsystems.utils.TestInitization;

public class VodFeaturesTestCase extends TestInitization
{
	@Test
	 public void tc_BCVODVD0118_naviagteToVODTrailer() throws InterruptedException
	 {
		 VodFeatures vod = new VodFeatures(driver);
		 vod.naviagteToVideoOndemandScreen();
	 }
	 
	@Test
	 public void tc_BCVODVD0101_navigateToOndemandScreenHotKey() throws InterruptedException
	 {

		 VodFeatures vod = new VodFeatures(driver);
		 vod.navigateToVideoOnDemandScreenHotkey();
		 
	 }
	
	@Test
	public void tc_BCVODBG0312_VOD_Rent() throws InterruptedException
	{
		VodFeatures vod = new VodFeatures(driver);
		vod.vodOnRent(TestInitization.getExcelKeyValue("RentMovie", "POD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "PinNumber"));
	}
	
	@Test
	public void tc_BCVODVD0131_VOD_Rent_Zero_Euro() throws InterruptedException
	{
		VodFeatures vod = new VodFeatures(driver);
		vod.validateFreeMovieInformation();
	}
	
	@Test
	public void tc_BCVODVD0114_VOD_Current_Rentals() throws InterruptedException
	{
		VodFeatures vod = new VodFeatures(driver);
		vod.rentalVodDeatils();
	}
	 
}

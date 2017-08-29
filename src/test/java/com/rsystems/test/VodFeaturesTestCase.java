package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.VodFeatures;
import com.rsystems.utils.TestInitization;

public class VodFeaturesTestCase extends TestInitization {
	@Test
	public void tc_BCVODVD0118_naviagteToVODTrailer() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.naviagteToVideoOndemandScreen();
	}

	@Test
	public void tc_BCVODVD0101_navigateToOndemandScreenHotKey() throws InterruptedException {

		VodFeatures vod = new VodFeatures(driver);
		vod.navigateToVideoOnDemandScreenHotkey();

	}

	@Test
	public void tc_BCVODBG0312_VOD_Rent() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.vodOnRent(TestInitization.getExcelKeyValue("RentMovie", "POD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "PinNumber"));
	}

	@Test
	public void tc_BCVODVD0131_VOD_Rent_Zero_Euro() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.validateFreeMovieInformation();
	}

	@Test
	public void tc_BCVODVD0114_VOD_Current_Rentals() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.rentalVodDeatils();
	}

	// Verifying the Poster is getting changed when a new VOD is added to the
	// category
	@Test
	public void tc_StoreEvolutionDefaultPosterLeafCategory() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.storeEvolutionDefaultPosterOfLeafCategory();
	}

	// Verifying the poster is getting changed when a new poster is added for NL
	// and FR
	@Test
	public void tc_StoreEvolutionPosterleafCategory() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.storeEvolutionPosterLeafCategory();
	}

	// Verifying whether a default poster is getting changed when there is no
	// picture under category and VOD
	@Test
	public void tc_storeEvolutionDefaultposternonleafCategory() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.storeEvolutionDefaultposternonleafCategory();
	}

	// Checking for the non-leaf category where there is a different poster for
	// NL & FR
	@Test
	public void tc_StoreEvolutionPosternonleafCategory() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.storeEvolutionPosternonleafCategory();
	}

	// VOD trickplay
	@Test
	public void tc_TP009_VOD_Trick_play_menu_from_VOD_playback() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.TP009_VOD_Trick_play_menufrom_VODplayback();
	}

	/**
	 * @author Rahul.Dhoundiyal
	 * @throws InterruptedException
	 *             Test cases is used to validate two lines under Shop Screen
	 */
	@Test
	public void tc_SF005_Store() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.verifyLinesInStore();
	}

}

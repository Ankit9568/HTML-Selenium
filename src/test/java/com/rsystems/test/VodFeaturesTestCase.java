package com.rsystems.test;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.Pvr;
import com.rsystems.pages.RentMovie;
import com.rsystems.pages.VodFeatures;
import com.rsystems.utils.PackageInformation;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

import APIs.STBAPIs;

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

	@Test
	public void TP009_VOD_TrickplaymenufromVODplayback() throws InterruptedException {
		Pvr p = new Pvr(driver);
		p.VODplayback();

	}

	@Test
	public void TP010_VODRCKeysduringTrickplay() throws InterruptedException {
		Pvr p = new Pvr(driver);
		p.VodRCKeysTrickplay();

	}

	@Test
	public void tc_BCVODVD0130_VOD_FOD() throws InterruptedException {

		DTVChannelScreen dtvScreen = new DTVChannelScreen(driver);
		RentMovie rentMovie = new RentMovie(driver);
		dtvScreen.navigateToFilmScreenAndRentMovie(TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			reports.log(LogStatus.FAIL, rentMovie.rentOption.getText() + "is visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());
		} catch (NoSuchElementException e) {

			reports.log(LogStatus.PASS, " Rent Option is not visible on webpage");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		sendKeyMultipleTimes("ENTER", 1, 1000);
		handlePopupIfExist();
		dtvScreen.pressPauseButtonAndValidation();
		// navigate to menu page
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 2000);
	}

	@Test
	public void tc_Single_Asset_Variant_Group_Purchase() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		VodFeatures vodFeatures = new VodFeatures(driver);
		// Navigate the group item of VODs
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "GroupName"));

		// check and VOD in a single group
		sendKeyMultipleTimes("ENTER", 1, 1000);

		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD2", "MovieName"));
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD3", "MovieName"));
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD4", "MovieName"));

		vodFeatures.RentGrpMovie(TestInitization.getExcelKeyValue("RentMovie", "POD2", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "PinNumber"));

		vodFeatures.validateMovieRentedAndPlay(TestInitization.getExcelKeyValue("RentMovie", "POD2", "MovieName"));
		// Navigate to move Category
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "GroupName"));
		sendKeyMultipleTimes("ENTER", 1, 1000);

		vodFeatures.RentGrpMovie(TestInitization.getExcelKeyValue("RentMovie", "POD3", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "PinNumber"));
		vodFeatures.validateMovieRentedAndPlay(TestInitization.getExcelKeyValue("RentMovie", "POD3", "MovieName"));

		// highlight the VOD3
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD4", "MovieName"));
		sendKeyMultipleTimes("ENTER", 1, 1000);

		// validate the PIN container is displayed
		isDisplayed(vodFeatures.pinContainer, "Pin Container");
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 1000);
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD2", "MovieName"));
		sendKeyMultipleTimes("ENTER", 1, 1000);
		handlePopupIfExist();
		dtvChannelScreen.pressForwardButtonAndValidation();

	}

	@Test
	public void tc_Single_Asset_Variant_Group_Package_Lock_Unlock() throws Exception {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		STBAPIs stbApis = new STBAPIs();

		// Navigate the group item of VODs
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "GroupName"));

		// check and VOD in a single group
		sendKeyMultipleTimes("ENTER", 1, 1000);

		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD2", "MovieName"));
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD3", "MovieName"));
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD4", "MovieName"));

		stbApis.stbPackageUnAssign(new PackageInformation("Spiderman2"));

		// waiting for 20 second for updation package
		Thread.sleep(15000);
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 2, 1000);

		// check and VOD in a single group
		sendKeyMultipleTimes("ENTER", 2, 1000);
		dtvChannelScreen.validateMovieNotExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD4", "MovieName"));

		stbApis.stbPackageAssign(new PackageInformation("Spiderman2"));
		// waiting for 20 second for updation package
		Thread.sleep(15000);
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 2, 1000);
		// check and VOD in a single group
		sendKeyMultipleTimes("ENTER", 2, 1000);

		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD2", "MovieName"));
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD3", "MovieName"));
		dtvChannelScreen.validateMovieExistInGrp(TestInitization.getExcelKeyValue("RentMovie", "POD4", "MovieName"));

	}

	@Test
	public void tc_StoreEvolution_ChangeSortingOfCategory() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		VodFeatures vodFeatures = new VodFeatures(driver);

		// Navigate the group item of VODs
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD2", "GroupName"));

		// back to parent category
		sendUnicodeMultipleTimes(Unicode.VK_PAGE_DOWN_OR_BACK.toString(), 1, 1000);

		if (vodFeatures.leftPannel.getAttribute("class").equalsIgnoreCase("cStoreLeftSection")) {
			reports.log(LogStatus.PASS, "Sorting criteria found in left side on page");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Sorting criteria does not found in left side on page");
		}
		String popularMovieName = dtvChannelScreen.getMovieNameForSpecificCategory(
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption3", "SortingOptionName"));

		dtvChannelScreen.changeSortingOptionAndValidation(
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption1", "SortingOptionName"),
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption1", "First Movie Order"));
		dtvChannelScreen.changeSortingOptionAndValidation(
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption2", "SortingOptionName"),
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption2", "First Movie Order"));

		dtvChannelScreen.changeSortingOptionAndValidation(
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption3", "SortingOptionName"),
				popularMovieName);

		dtvChannelScreen.changeSortingOptionAndValidation(
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption4", "SortingOptionName"),
				TestInitization.getExcelKeyValue("MovieScreen", "SortingOption4", "First Movie Order"));

	}

	@Test
	public void tc_Single_Asset_Variant_Non_Grouped_Purchase() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		VodFeatures vodFeatures = new VodFeatures(driver);
		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "POD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"));

		vodFeatures.RentGrpMovie(TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "PinNumber"));

		vodFeatures.validateMovieRentedAndPlay(TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"));

	}
	

	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException Test cases is used to '1.Go to shop
        2.Select a program from the available category
        3.Select 'Rent' from the Action Menu
        4. Enter incorrect PIN
	 */
	@Test
	public void tc_VOD_Rent_Enter_Invalid_PIN() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.VOD_Rent_Enter_Invalid_PIN(TestInitization.getExcelKeyValue("RentMovie", "POD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD", "WrongPinNumber"));
	}
	
	
	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException Test cases 'Watch a VOD and try to record it.
	 */
	@Test
	public void tc_VOD_Record() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.VOD_Record();
	}
	
	
	/**
	 * @author Pritam.Dutta
	 * @throws InterruptedException Test cases 1.Go to shop 2.Select a rented asset from the available category 3.Select 'Watch' option from the Action Menu 4.Select one among the options
	 */
	@Test
	public void tc_VOD_Renting_within_the_Rental_Time() throws InterruptedException {
		VodFeatures vod = new VodFeatures(driver);
		vod.VOD_Renting_within_the_Rental_Time();
	}
	
}

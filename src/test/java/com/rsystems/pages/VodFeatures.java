package com.rsystems.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class VodFeatures extends TestInitization {

	WebDriver driver;

	public VodFeatures(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.StoreFilterLayer.shopScreen)
	public WebElement shopScreen;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.Vod.vodHeading)
	public WebElement vodHeading;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.itemPrice)
	public WebElement itemPrice;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.Vod.rowId)
	public WebElement rowId;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.menuText)
	public WebElement menuText;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.actie)
	public WebElement actie;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.mubiPass)
	public WebElement mubiPass;

	@FindBy(how = How.CLASS_NAME, using = ObjectRepository.Vod.rows)
	public WebElement rows;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.pinContainer)
	public WebElement pinContainer;

	@FindBy(how = How.ID, using = ObjectRepository.Vod.count)
	public WebElement count;

	@FindBy(how = How.ID, using = ObjectRepository.Vod.container)
	public WebElement container;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.dateTime)
	public WebElement dateTime;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.duration)
	public WebElement duration;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.movieName)
	public WebElement movieName;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.totalItems)
	public WebElement totalItems;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.lookOption)
	public WebElement lookOption;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.highlightFilm)
	public WebElement highlightFilm;

	@FindBy(how = How.XPATH, using = ObjectRepository.ZapListPage.screenTitle)
	public WebElement shopHeader;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.leftPannelPosition)
	public WebElement leftPannel;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.activeSortOption)
	public WebElement activeSortOption;

	@FindBy(how = How.ID, using = ObjectRepository.Vod.topMovieHeading)
	public WebElement topMovieHeading;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.filmsCategoryPoster)
	public WebElement filmsCategoryPoster;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.leafPoster)
	public WebElement leafPoster;

	@FindBy(how = How.XPATH, using = ObjectRepository.StoreFilterLayer.dramaScreen)
	public WebElement dramaScreen;

	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.continueWatchVideo)
	public WebElement continueWatchVideo;
	
	@FindBy(how = How.XPATH, using = ObjectRepository.Vod.wrongPinEnterMessage)
	public WebElement wrongPinEnterMessage;
	
	@FindBy(how = How.ID, using = ObjectRepository.FilmsScreen.currentSelectedMovieName)
	public WebElement currentSelectedMovieName;
	
	public void naviagteToVideoOndemandScreen() throws InterruptedException {
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		reports.log(LogStatus.PASS, "Trailer is started");
		sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		reports.log(LogStatus.PASS, "Press stop button from RC");
		sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());
		String headingVODHeadingDetails = vodHeading.getText();
		System.out.println("Vod heading :: " + headingVODHeadingDetails);
		String expectedheadingVODHeadingDetails = getExcelKeyValue("RentMovie", "FOD", "MovieName");
		System.out.println("Expected heading :: " + expectedheadingVODHeadingDetails);

		if (headingVODHeadingDetails.equalsIgnoreCase(expectedheadingVODHeadingDetails)) {
			reports.log(LogStatus.PASS,
					"Actual VOD heading details is : " + headingVODHeadingDetails
							+ " and Expected VOD heading details is: " + expectedheadingVODHeadingDetails
							+ " Test case successfully Passed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Actual VOD heading details is : " + headingVODHeadingDetails
					+ " and Expected VOD heading details is : " + expectedheadingVODHeadingDetails
					+ " Test case Failed");
		}
	}

	public void navigateToVideoOnDemandScreenHotkey() throws InterruptedException {

		reports.log(LogStatus.PASS, "Navigate to the On demand Screen by Hot key");
		sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1, 0);
		reports.attachScreenshot(captureCurrentScreenshot());
		String actualTitleShop = null;
		String expectedTitleShop = getExcelKeyValue("screenTitles", "OnDemandMenu", "name_nl");
		driver.switchTo().frame(getCurrentFrameIndex());
		actualTitleShop = shopScreen.getText();
		System.out.println("actualTitleShop ############## " + actualTitleShop);
		System.out.println("Expected Title ######" + expectedTitleShop);

		if (actualTitleShop.equalsIgnoreCase(expectedTitleShop)) {
			reports.log(LogStatus.PASS,
					"Actual Title of the On Demand Screen is : " + actualTitleShop
							+ " and Expected Title of the On Demand Screen is: " + expectedTitleShop
							+ " Test case successfully Passed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Actual Title of the On Demand Screen is: " + actualTitleShop
					+ " and Expected Title of the On Demand Screen is : " + expectedTitleShop + " Test case Failed");
		}

	}

	public void vodOnRent(String parentCategry, String movieName, String pinNumber) throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(parentCategry, movieName);

		reports.log(LogStatus.PASS, "Navigate to PIN Screen");

		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(pinContainer, "Pin Container");
		reports.log(LogStatus.PASS, "Enter pin number");
		sendNumaricKeys(Integer.parseInt(pinNumber));
		reports.attachScreenshot(captureCurrentScreenshot());
		Thread.sleep(5000);
		
		driver.switchTo().frame(getCurrentFrameIndex());
		wait.until(ExpectedConditions.visibilityOf(continueWatchVideo));
		reports.log(LogStatus.PASS, "Press Enter to continue watch video");
		reports.attachScreenshot(captureCurrentScreenshot());
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 3000);
		
		
		dtvChannelScreen.pressForwardButtonAndValidation();
		sendUnicodeMultipleTimes(Unicode.VK_PLAY.toString(), 1, 1000);
		dtvChannelScreen.pressRewindButtonAndValidation();

		reports.log(LogStatus.PASS, "Moving back to the Menu screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

	}

	public void RentGrpMovie(String movieName, String pinNumber) throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		// highlight rented Movie
		dtvChannelScreen.validateMovieExistInGrp(movieName);

		reports.log(LogStatus.PASS, "Navigate to PIN Screen");

		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		
		
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(pinContainer, "Pin Container");
		reports.attachScreenshot(captureCurrentScreenshot());
		
		sendNumaricKeys(Integer.parseInt(pinNumber));
		// for auto switch to next page
		Thread.sleep(5000);
		reports.log(LogStatus.PASS, "Navigate to Movie");
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		dtvChannelScreen.pressForwardButtonAndValidation();
		dtvChannelScreen.pressRewindButtonAndValidation();
		dtvChannelScreen.pressPlayButtonAndValidation();

		reports.log(LogStatus.PASS, "Navigate back to the Menu screen");
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());
	}

	public void validateFreeMovieInformation() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		String priceOfItem = itemPrice.getText();
		System.out.println("Price of Items :" + priceOfItem);

		isDisplayed(lookOption, "Look Option");

		if (priceOfItem.contentEquals(TestInitization.getExcelKeyValue("RentMovie", "FOD", "Rate")))

		{
			reports.log(LogStatus.PASS, "price is " + TestInitization.getExcelKeyValue("RentMovie", "FOD", "Rate"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Free movie should not contain Huren");
		}
	}

	public void rentalVodDeatils() throws InterruptedException {

		vodOnRent(TestInitization.getExcelKeyValue("RentMovie", "POD1", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "POD1", "MovieName"),
				TestInitization.getExcelKeyValue("RentMovie", "POD1", "PinNumber"));

		String movieTitle = TestInitization.getExcelKeyValue("RentMovie", "POD1", "MovieName");

		setApplicationHubPage(2);

		reports.log(LogStatus.PASS, "Navigate to the VOD rental Folder");
		sendKeySequence("LEFT,ENTER", 1000, "mijn bibliotheek");
		sendKeyMultipleTimes("LEFT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());

		List<WebElement> listOfMovie = driver
				.findElements(By.xpath("//div[contains(@id,'item_')]/div[@class='poster-info']/h2"));
		for (WebElement movie : listOfMovie) {

			if (movie.getText().contentEquals(movieTitle)) {

				reports.log(LogStatus.PASS, "Movie succsesfully rented");
				reports.attachScreenshot(captureCurrentScreenshot());

				return;
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		FailTestCase("Movie not rented");
	}

	public void validateMovieRentedAndPlay(String movieTitle) throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to the VOD rental Folder");
		setApplicationHubPage(2);

		sendKeySequence("LEFT,ENTER", 1000, "mijn bibliotheek");
		sendKeyMultipleTimes("LEFT", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		reports.attachScreenshot(captureCurrentScreenshot());

		driver.switchTo().frame(getCurrentFrameIndex());

		List<WebElement> listOfMovie = driver
				.findElements(By.xpath("//div[contains(@id,'item_')]/div[@class='poster-info']/h2"));

		for (WebElement movie : listOfMovie) {

			if (movie.getText().contentEquals(movieTitle)) {

				reports.log(LogStatus.PASS, "Movie succsesfully rented");
				reports.attachScreenshot(captureCurrentScreenshot());
				sendKeyMultipleTimes("ENTER", 1, 1000);

				reports.log(LogStatus.PASS, "Click on Watch Option");
				sendKeyMultipleTimes("ENTER", 1, 5000);
				handlePopupIfExist();
				reports.attachScreenshot(captureCurrentScreenshot());

				reports.log(LogStatus.PASS, "Validating movie is open or not.");
				sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
				driver.switchTo().frame(getCurrentFrameIndex());
				//isDisplayed(dtvChannelScreen.infoBanner, "Info banner ");

				sendKeyMultipleTimes("ENTER", 1, 6000);
				Thread.sleep(4000);
				new DTVChannelScreen(driver).pressPauseButtonAndValidation();
				reports.log(LogStatus.PASS, "Movie " + movieTitle + " found in Renterd Folder and play sucessfully");
				reports.attachScreenshot(captureCurrentScreenshot());


				return;
			}
			sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		FailTestCase("Movie not rented");
	}

	public void storeEvolutionDefaultPosterOfLeafCategory() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		ChangePreference change = new ChangePreference(driver);

		// Changing language to Dutch
		change.navigateToMyPreference();
		change.languageChange("NL");

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		dtv.navigateToFilmScreenVerifyDefaultPoster(getExcelKeyValue("Films", "Poster_Navigation_NL", "name_nl"));
		driver.switchTo().frame(getCurrentFrameIndex());

		if (filmsCategoryPoster.getAttribute("src")
				.equalsIgnoreCase(getExcelKeyValue("Films", "RecentPoster_NL", "name_nl"))) {
			reports.log(LogStatus.PASS, "Recent poster has been updated");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Recent poster has not been updated");
		}

		// Moving to the Menu Screen

		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		// Changing language to French
		change.navigateToMyPreference();
		change.languageChange("FR");

		dtv.navigateToFilmScreenVerifyDefaultPoster(getExcelKeyValue("Films", "Poster_Navigation_FR", "name_nl"));

		if (filmsCategoryPoster.getAttribute("src").trim()
				.contains(getExcelKeyValue("Films", "DeafultPoster_FR", "name_nl"))) {
			reports.log(LogStatus.PASS, "Default poster has been matched");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Default poster is not getting matched");
		}

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);
		// Changing language to Dutch
		change.navigateToMyPreference();
		change.languageChange("NL");

	}

	// Poster changed for for Both NL & FL and verified
	public void storeEvolutionPosterLeafCategory() throws InterruptedException {

		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		ChangePreference change = new ChangePreference(driver);

		// Changing language to Dutch
		change.navigateToMyPreference();
		change.languageChange("NL");

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		dtv.navigateToFilmScreenVerifyPoster(getExcelKeyValue("Films", "Navigate_NL_Leaf", "name_nl"));

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		change.navigateToMyPreference();
		change.languageChange("FR");

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		dtv.navigateToFilmScreenVerifyPoster(getExcelKeyValue("Films", "Navigate_FR_Leaf", "name_nl"));

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		change.navigateToMyPreference();
		change.languageChange("NL");

	}

	// If there is no poster set for any Language Default poster should get
	// updated
	public void storeEvolutionDefaultposternonleafCategory() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		ChangePreference change = new ChangePreference(driver);

		// Setting language to NL
		change.navigateToMyPreference();
		change.languageChange("NL");

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		dtv.navigateToFilmScreenVerifyDefaultPoster(getExcelKeyValue("Films", "Navigate_NL_NonLeaf", "name_nl"));

		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		System.out.println(filmsCategoryPoster.getAttribute("src").trim());
		System.out.println(getExcelKeyValue("Films", "DeafultPoster_NL", "name_nl"));
		if (filmsCategoryPoster.getAttribute("src").trim()
				.contains(getExcelKeyValue("Films", "DeafultPoster_NL", "name_nl"))) {
			reports.log(LogStatus.PASS, "Default poster has been matched");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Default poster is not get matched");
			reports.attachScreenshot(captureCurrentScreenshot());
		}

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		change.navigateToMyPreference();
		change.languageChange("FR");

		if (filmsCategoryPoster.getAttribute("src").trim()
				.contains(getExcelKeyValue("Films", "DeafultPoster_FR", "name_nl"))) {
			reports.log(LogStatus.PASS, "Default poster has been matched");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Default poster is not get matched");
		}

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		// Setting to Default language
		change.navigateToMyPreference();
		change.languageChange("NL");
	}

	// Changed both the poster for NL and FL
	public void storeEvolutionPosternonleafCategory() throws InterruptedException {
		DTVChannelScreen dtv = new DTVChannelScreen(driver);
		ChangePreference change = new ChangePreference(driver);

		// Setting to Default language
		change.navigateToMyPreference();
		change.languageChange("NL");

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		System.out.println(getExcelKeyValue("Films", "Navigate_New_Poster_NL", "name_nl"));
		dtv.navigateToFilmScreenVerifyPoster(getExcelKeyValue("Films", "Navigate_New_Poster_NL", "name_nl"));

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		change.navigateToMyPreference();
		change.languageChange("FR");

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		dtv.navigateToFilmScreenVerifyPoster(getExcelKeyValue("Films", "Navigate_New_Poster_FR", "name_nl"));

		// Moving to the Menu Screen
		sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
		sendKeyMultipleTimes("DOWN", 1, 1000);

		// Setting Default language to NL
		change.navigateToMyPreference();
		change.languageChange("NL");
	}
	
	public void TP009_VOD_Trick_play_menufrom_VODplayback() throws InterruptedException
	{
        DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
        dtvChannelScreen.navigateToFilmScreenAndRentMovie(
        TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
      TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
        sendKeyMultipleTimes("ENTER", 2, 1000);
        dtvChannelScreen.pressForwardButtonAndValidation();
        dtvChannelScreen.pressRewindButtonAndValidation();
        dtvChannelScreen.pressPauseButtonAndValidation();
        dtvChannelScreen.pressPlayButtonAndValidation();
        sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 1000);
        reports.log(LogStatus.PASS, "Should be on the Movie list screen");
        driver.switchTo().frame(getCurrentFrameIndex());
        isDisplayed(currentSelectedMovieName, "Currently played film");
        sendKeyMultipleTimes("ENTER", 1, 1000);
        driver.switchTo().frame(getCurrentFrameIndex());
        isDisplayed(lookOption, "kijken");
        reports.log(LogStatus.PASS, "Continue to watch video");
        sendKeyMultipleTimes("ENTER", 1, 1000);
        reports.attachScreenshot(captureCurrentScreenshot());
        handlePopupIfExist();
        dtvChannelScreen.pressPauseButtonAndValidation();



	}
	
	public void verifyLinesInStore() throws InterruptedException {

		LibraryScreen libraryScreen = new LibraryScreen(driver);
		reports.log(LogStatus.PASS, "Navigate the Store Filter screen");
		sendKeySequence("RIGHT,ENTER,ENTER", 1000, "shop");
		reports.log(LogStatus.PASS, "Verify Two Lines getting displayed on Store Filter Screen");
		libraryScreen.verifyTwoLinesInLibraryScreen("Level2");
		reports.log(LogStatus.PASS, "Verify Opacity of Two Lines getting displayed on Store Filter Screen");
		libraryScreen.verifyOpactiyOfLines();
	}
	
	public void VOD_Rent_Enter_Invalid_PIN(String parentCategry, String movieName, String WrongPinNumber) throws InterruptedException
	{
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(parentCategry, movieName);

		reports.log(LogStatus.PASS, "Navigate to PIN Screen");

		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);

		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(pinContainer, "Pin Container");
		reports.log(LogStatus.PASS, "Enter Wrong number");
		sendNumaricKeys(Integer.parseInt(WrongPinNumber));
		reports.attachScreenshot(captureCurrentScreenshot());
		Thread.sleep(2000);
		driver.switchTo().frame(getCurrentFrameIndex());
		String wrongPinMessage=wrongPinEnterMessage.getText();
		System.out.println(wrongPinMessage);
		if(wrongPinMessage.equalsIgnoreCase(getExcelKeyValue("ErrorMessages","WrongErrorMessage","Value")))
		{
			Thread.sleep(2000);
			reports.log(LogStatus.PASS, "Wrong pin enter message is getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
		else
		{
			FailTestCase("Wrong pin enter message is not getting displayed");
		}
	}
	
	public void VOD_Record() throws InterruptedException
	{
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		Pvr pvr = new Pvr(driver);

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

		reports.log(LogStatus.PASS, "Start VOD");
		driver.switchTo().frame(getCurrentFrameIndex());
		if(lookOption.isDisplayed())
		{
		sendKeyMultipleTimes("ENTER", 1, 1000);
		handlePopupIfExist();
		}
		else
		{
			driver.switchTo().frame(getCurrentFrameIndex());
			wait.until(ExpectedConditions.visibilityOf(lookOption));
			
		}
		reports.attachScreenshot(captureCurrentScreenshot());
		driver.switchTo().frame(getCurrentFrameIndex());
		try {
			if (pvr.playerBar.isDisplayed()) 
			{
				FailTestCase("Recording button is getting displayed");
			}

			else 
			{
				reports.log(LogStatus.PASS, "Nothing should happen in case of Recording Button");
				reports.attachScreenshot(captureCurrentScreenshot());
			}
		} catch (NoSuchElementException e) {
			reports.log(LogStatus.PASS, "Nothing should happen in case of Recording Button");
			reports.attachScreenshot(captureCurrentScreenshot());
		}
		
	}
	public void VOD_Renting_within_the_Rental_Time() throws InterruptedException
    {
          DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
          Pvr pvr = new Pvr(driver);

          dtvChannelScreen.navigateToFilmScreenAndRentMovie(
                      TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
                      TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));

          reports.log(LogStatus.PASS, "Start VOD");
          driver.switchTo().frame(getCurrentFrameIndex());
          wait.until(ExpectedConditions.visibilityOf(lookOption));
          sendKeyMultipleTimes("ENTER", 1, 1000);
          try
          {
                driver.switchTo().frame(getCurrentFrameIndex());
                if(new MiniEPGScreen(driver).notificationMsg.isDisplayed())
                {
                      reports.log(LogStatus.PASS, "Notification message is getting displayed.Restart the video");
                      reports.attachScreenshot(captureCurrentScreenshot());
                      sendKeyMultipleTimes("RIGHT", 1, 3000);
                      sendKeyMultipleTimes("ENTER", 1, 3000);
              }
          }
          catch(NoSuchElementException e)
          {
                System.out.println("NO notification");
          }     
          new DTVChannelScreen(driver).pressPauseButtonAndValidation();
          
    }
}

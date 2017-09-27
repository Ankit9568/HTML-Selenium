package com.rsystems.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.pages.DTVChannelScreen;
import com.rsystems.pages.Hub;
import com.rsystems.pages.LibraryScreen;
import com.rsystems.pages.StoreFilterLayer;
import com.rsystems.pages.TvFilterLayer;
import com.rsystems.pages.VodFeatures;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class HubTestCases extends TestInitization {

	Hub hubScreen = null;

	/**
	 * This test case is used to verify Menu Screen is launching or not using
	 * hot key Created by Rahul Dhoundiyal Reviewed Reviewed 2 Reviewed Finally
	 */
	@Test
	public void tc_Hub_Menu_Button() throws InterruptedException {
		hubScreen = new Hub(driver);
		hubScreen.launchAndVerifyMenuScreen();
	}

	/**
	 * This test case is used to verify Navigation in text line in Hub Screen
	 * Created by Rahul Dhoundiyal Reviewed by Nitin
	 */
	@Test
	public void tc_HUB_Navigation_Text_Line() throws InterruptedException {
		hubScreen = new Hub(driver);
		if (hubScreen.focusHubElement.getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
			reports.log(LogStatus.PASS,
					"Expected Output - Focus should be on " + getExcelKeyValue("screenTitles", "LiveTV", "name_nl")
							+ ". Actual Output - Focus is on " + hubScreen.focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Test cases is failed as Initial Focus is not on "
					+ getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + " Actual Focus is on "
					+ hubScreen.focusHubElement.getText());
		}
		hubScreen.verifyHubTextLineNavigation();
	}

	/**
	 * This test case is used to verify Navigation in Asset line in Hub Screen
	 * Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_hub_navigation_asset_line() throws InterruptedException {
		hubScreen = new Hub(driver);
		sendKeyMultipleTimes("UP", 1, 1000);
		if (hubScreen.focusHubElement.getText()
				.equalsIgnoreCase(getExcelKeyValue("screenTitles", "LiveTV", "name_nl"))) {
			reports.log(LogStatus.PASS,
					"Expected Output - Focus should be on " + getExcelKeyValue("screenTitles", "LiveTV", "name_nl")
							+ ". Actual Output - Focus is on " + hubScreen.focusHubElement.getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		} else {
			FailTestCase("Test cases is failed as Initial Focus is not on "
					+ getExcelKeyValue("screenTitles", "LiveTV", "name_nl") + " Actual Focus is on "
					+ hubScreen.focusHubElement.getText());
		}
		hubScreen.verifyHubAssetLineNavigation();
	}

	/**
	 * This test case is used to verify existence and opacity of two lines in
	 * Hub Screen Created by Rahul Dhoundiyal
	 */
	@Test
	public void tc_sf001_hub() throws InterruptedException {
		hubScreen = new Hub(driver);
		setApplicationHubPage(1);
		hubScreen.verifyLinesinHub();
		hubScreen.verifyOpactiyOfLines();
	}

	/**
	 * This test case is used to verify asset line in Hub Screen Created by
	 * Rahul Dhoundiyal
	 */
	@Test
	public void tc_hub_asset_line_in_hub() throws InterruptedException {
		hubScreen = new Hub(driver);
		sendKeyMultipleTimes("UP", 1, 1000);
		hubScreen.verifyAssetLine();
	}

	/**
	 * This test cases is used to check hub menu getting displayed when no
	 * package is assigned Created by Rahul Dhoundiyal
	 * 
	 */
	@Test
	public void tc_Hub_menu_button_no_package() throws InterruptedException {
		hubScreen = new Hub(driver);
		reports.log(LogStatus.PASS, "Test When No Package Is assigned");
		hubScreen.launchAndVerifyMenuScreen();
	}

	/**
	 * 
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 *             Test case validate the Hub_Up-Down navigation in HUB
	 */

	@Test
	public void tc_Hub_Up_Down_navigation_in_HUB() throws InterruptedException {

		Hub hub = new Hub(driver);
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		hub.verifyFocousLineMoveUp();
		TestInitization.sendKeyMultipleTimes("UP", 1, 1000);
		hub.verifyFocousLineMoveUp();
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		hub.verifyFocousLineMoveDown();
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		hub.verifyFocousLineMoveDown();
	}

	/**
	 * This test cases is used to Go to HUB and check the no. of entries in text
	 * line Created by Pritam Dutta
	 * 
	 * @throws InterruptedException
	 * 
	 */
	@Test
	public void tc_hub_Text_line() throws InterruptedException {

		Hub hub = new Hub(driver);
		hub.hub_Text_line();

	}

	/**
	 * @author Ankit.Agarwal1
	 * @throws InterruptedException
	 */
	@Test
	public void tc_Hub_Selecting_elements_in_asset_line() throws InterruptedException {

		Hub hub = new Hub(driver);
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		StoreFilterLayer storeFilterLayer = new StoreFilterLayer(driver);
		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		reports.log(LogStatus.PASS, "Navigate to library screen");
		sendKeySequence("LEFT,UP,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));
		libraryScreen.libraryElementActionListDisplayed();
		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		hub.verifyFocousElementText(TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to shop screen");
		sendKeySequence("DOWN,RIGHT,RIGHT,UP,ENTER", 1000,
				TestInitization.getExcelKeyValue("screenTitles", "Shop", "name_nl"));
		storeFilterLayer.actionItemValidation();

		// Search button functionality not implemented
		/*
		 * reports.log(LogStatus.PASS, "Navigate to hub screen");
		 * sendKeySequence("PAGE_DOWN", 1000,
		 * TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		 * hub.verifyFocousElementText(TestInitization.getExcelKeyValue(
		 * "screenTitles", "Shop", "name_nl"));
		 * 
		 * reports.log(LogStatus.PASS, "Navigate to search screen");
		 * sendKeySequence("DOWN,RIGHT,UP,ENTER", 1000,
		 * TestInitization.getExcelKeyValue("screenTitles", "Search",
		 * "name_nl"));
		 */

		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		hub.verifyFocousElementText(TestInitization.getExcelKeyValue("screenTitles", "Shop", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to search screen");
		sendKeySequence("DOWN,RIGHT,RIGHT,UP,ENTER", 1000,
				TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to television screen");
		sendKeyMultipleTimes("DOWN", 1, 1000);
		sendKeyMultipleTimes("LEFT", 3, 1000);
		sendKeyMultipleTimes("UP", 1, 1000);
		sendKeyMultipleTimes("ENTER", 1, 1000);
		
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		driver.switchTo().frame(getCurrentFrameIndex());
		sendUnicodeMultipleTimes(Unicode.VK_INFO.toString(), 1, 1000);
		isDisplayed(dtvChannelScreen.chnlNoIn_Infobar, "Channel Number in info banner ");
		
		
		
		
		
	}

	@Test
	public void tc_Hub_Selecting_elements_in_text_line() throws InterruptedException {

		TvFilterLayer tvFilterLayer = new TvFilterLayer(driver);
		Hub hub = new Hub(driver);
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		VodFeatures vodFeatures = new VodFeatures(driver);

		reports.log(LogStatus.PASS, "Navigate to television screen");
		sendKeySequence("ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(tvFilterLayer.now, "Nu tile ");
		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		hub.verifyFocousElementText(TestInitization.getExcelKeyValue("screenTitles", "LiveTV", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to library screen");
		sendKeySequence("LEFT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(libraryScreen.libraryElementRowContainer, "Library Element row container ");
		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		hub.verifyFocousElementText(TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to shop screen");
		sendKeySequence("RIGHT,RIGHT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Shop", "name_nl"));
		driver.switchTo().frame(getCurrentFrameIndex());
		isDisplayed(vodFeatures.shopScreen, "highlight tile title");
		
		// Search button functionality not implemented
		/*reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		hub.verifyFocousElementText(TestInitization.getExcelKeyValue("screenTitles", "Shop", "name_nl"));

		reports.log(LogStatus.PASS, "Navigate to search screen");
		sendKeySequence("RIGHT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Search", "name_nl"));*/
	
		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		hub.verifyFocousElementText(TestInitization.getExcelKeyValue("screenTitles", "Shop", "name_nl"));
		reports.log(LogStatus.PASS, "Navigate to Setting screen");
		sendKeySequence("RIGHT,RIGHT,ENTER", 1000, TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));
		
		reports.log(LogStatus.PASS, "Navigate to hub screen");
		sendKeySequence("PAGE_DOWN", 1000, TestInitization.getExcelKeyValue("screenTitles", "home", "name_nl"));
		
	}

	public void tc_Hub_No_stack_animation_for_Asset_line() throws InterruptedException {

		// pending test case
		sendKeyMultipleTimes("DOWN", 1, 1000);

		List<WebElement> assetLineItems = driver.findElements(By.xpath(ObjectRepository.HubScreen.assetLineList));

		for (WebElement assetLineItem : assetLineItems) {

			// int startX = assetLineItem.getLocation().x;
			int startX = assetLineItem.findElement(By.xpath("./ul/li[1]")).getLocation().getX();
			System.out.println("Staart x " + startX + "start Y " + assetLineItem.getLocation().y + "Width"
					+ assetLineItem.getSize().getWidth());
			int endX = startX + assetLineItem.getSize().getWidth();

			System.out.println(assetLineItem.getText() + " StartX  " + startX + " End X" + endX);

		}

	}

	@Test
	public void tc_SF022_ACTION_MENU() throws InterruptedException {

		DTVChannelScreen dtvChannelScreen = new DTVChannelScreen(driver);
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		dtvChannelScreen.openLiveTV();

		sendKeyMultipleTimes("ENTER", 1, 2000);
		libraryScreen.verifyTwoLinesInWithoutOpacityValidation("Level3");

		reports.log(LogStatus.PASS, "Navigate to Recording screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 4000);
		sendKeySequence("ENTER", 1000, "mijn bibliotheek");
		libraryScreen.verifyTwoLinesInWithoutOpacityValidation("Level3");

		dtvChannelScreen.navigateToFilmScreenAndRentMovie(
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "Category"),
				TestInitization.getExcelKeyValue("RentMovie", "FOD", "MovieName"));
		libraryScreen.verifyTwoLinesInWithoutOpacityValidation("Level3");

		reports.log(LogStatus.PASS, "Navigate to Recording screen");
		sendUnicodeMultipleTimes(Unicode.VK_PVR.toString(), 1, 4000);
		sendKeySequence("LEFT,ENTER", 1000, "mijn bibliotheek");
		libraryScreen.verifyTwoLinesInWithoutOpacityValidation("Level3");

	}

}

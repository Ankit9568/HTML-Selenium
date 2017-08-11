package com.rsystems.test;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.pages.LibraryScreen;
import com.rsystems.utils.TestInitization;
public class LibraryTestCase extends TestInitization {


	/**
	 * This Test case verify the line movement while navigating through the Library Screen
	 * 
	 * 
	 */
	@Test
	public void verifyLibraryMenuItemsText() throws InterruptedException
	{
		LibraryScreen libraryScreen = new LibraryScreen(driver);
		libraryScreen.moveToLibrary();
		reports.log(LogStatus.PASS, "Verify Two Lines getting displayed on Hub Page");
		libraryScreen.verifyTwoLinesInLibraryScreen("Level2");
		libraryScreen.verifyLineMovementInLibraryScreen();
		libraryScreen.verifyLinesInLibrarySubMenuScreen("Level3");
		libraryScreen.verifyNavigationinLibrarySubMenu();
		
	}
}
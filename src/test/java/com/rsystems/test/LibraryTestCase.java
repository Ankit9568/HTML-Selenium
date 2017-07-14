package com.rsystems.test;
import org.testng.annotations.Test;

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
		libraryScreen.verifyTwoLinesInLibraryScreen("Level2");
		libraryScreen.verifyLineMovementInLibraryScreen();
		libraryScreen.verifyLinesInLibrarySubMenuScreen("Level3");
		libraryScreen.verifyNavigationinLibrarySubMenu();
		
	}
}
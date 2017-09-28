package com.rsystems.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

import junit.framework.Assert;

public class LibraryScreen extends TestInitization {

	/**
	 * This function is used to get all the Library Menu Items List Created By
	 * Rahul Dhoundiyal
	 */
	WebDriver driver;

	public LibraryScreen(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = ObjectRepository.LibraryElements.libraryCanvas)
	public WebElement libraryCanvas;

	@FindBy(how = How.ID, using = ObjectRepository.HubScreen.upCanvasLineElement)
	public WebElement upCanvasLine;

	@FindBy(how = How.ID, using = ObjectRepository.HubScreen.downCanvasLineElement)
	public WebElement downCanvasLine;

	@FindBy(how = How.ID, using = ObjectRepository.LibraryElements.libraryElementRowContainer)
	public WebElement libraryElementRowContainer;

	public List<WebElement> libraryMenuItems() {
		return driver.findElements(By.xpath(ObjectRepository.LibraryElements.libraryMenuItemsXPath));
	}

	/**
	 * This function is used to get all the Library Sub Menu Items List for a
	 * particular Menu Created By Rahul Dhoundiyal
	 */
	public List<WebElement> libraryMenuSubItems(int i) {
		return driver.findElements(By.cssSelector("#focus_row_" + i + " li[id^='item']"));
	}

	/**
	 * This function is used to move to Library Section Created By Rahul
	 * Dhoundiyal
	 */
	public void moveToLibrary() throws InterruptedException {
		reports.log(LogStatus.PASS, "Navigate the Library Screen");
		TestInitization.sendKeySequence("DOWN,LEFT,ENTER", 1000,
				TestInitization.getExcelKeyValue("screenTitles", "Library", "name_nl"));
	}

	/**
	 * This function is used to get the text for all menu items Created By Rahul
	 * Dhoundiyal
	 */
	public List<String> getLibraryMenuItemsText() throws InterruptedException {

		moveToLibrary();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> libraryMenuItemList = new ArrayList<String>();
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			libraryMenuItemList.add(libraryMenuItems().get(i).getText());
		}
		return libraryMenuItemList;
	}

	/**
	 * This function is used to get the font-size for all menu items Created By
	 * Rahul Dhoundiyal
	 */
	public List<String> getLibraryMenuItemFontSize() throws InterruptedException {
		moveToLibrary();
		System.out.println("Inside getLibraryMenuItemFontSize method");
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> libraryMenuItemFontList = new ArrayList<String>();
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			libraryMenuItemFontList.add(libraryMenuItems().get(i).getCssValue("font-size"));
		}
		return libraryMenuItemFontList;
	}

	/**
	 * This function is used to verify the expected text or font-size of menu
	 * items with actual text or font-size Created By Rahul Dhoundiyal
	 */
	public boolean VerifyMenuItemsTextOrFonts(List<String> actualList, String keyName) throws InterruptedException {
		boolean validateTextOrFont = false;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> expectedList = new ArrayList<String>();
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			expectedList.add(TestInitization.getExcelKeyValue("library", libraryMenuItems().get(i).getText(), keyName));
		}
		for (int i = 0; i < expectedList.size(); i++) {
			Assert.assertEquals(expectedList.get(i), actualList.get(i));
			reports.log(LogStatus.PASS,
					"Expected List" + expectedList.get(i) + "Actual List :" + libraryMenuItems().get(i).getText());
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			if (expectedList.get(i).equalsIgnoreCase(actualList.get(i))) {
				validateTextOrFont = true;
				TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
			} else {
				validateTextOrFont = false;
			}
		}
		return validateTextOrFont;
	}

	/**
	 * This function is used to get the text for all sub menu items Created By
	 * Rahul Dhoundiyal
	 */
	public List<String> getLibrarySubMenuListText() throws InterruptedException {
		moveToLibrary();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> subMenuList = new ArrayList<String>();
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			for (int j = 0; j < libraryMenuSubItems(i).size(); j++) {
				subMenuList.add(libraryMenuSubItems(i).get(j).getAttribute("innerText"));
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		return subMenuList;
	}

	/**
	 * This function is used to get the font-size for all sub menu items Created
	 * By Rahul Dhoundiyal
	 */
	public List<String> getLibrarySubMenuFontSize() throws InterruptedException {
		moveToLibrary();
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> listOfSubMenuFontList = new ArrayList<String>();
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
			for (int j = 0; j < libraryMenuSubItems(i).size(); j++) {
				listOfSubMenuFontList.add(libraryMenuSubItems(i).get(j).getCssValue("font-size"));
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
			}
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		}
		return listOfSubMenuFontList;
	}

	/**
	 * This function is used to verify the expected text or font-size of sub
	 * menu items with actual text or font-size Created By Rahul Dhoundiyal
	 */
	public boolean verifyLibrarySubMenuTextOrFonts(List<String> actualList, String keyName)
			throws InterruptedException {
		// Switch to Active Frame
		boolean validateTextOrFont = false;
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		List<String> expectedList = new ArrayList<String>();
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			for (int j = 0; j < libraryMenuSubItems(i).size(); j++) {
				if (i == 1) {
					System.out.println(TestInitization.getExcelKeyValue("library", "Apps", keyName));
					expectedList.add(TestInitization.getExcelKeyValue("library", "Apps", keyName));
				} else {
					expectedList.add(TestInitization.getExcelKeyValue("library",
							libraryMenuSubItems(i).get(j).getAttribute("innerText"), keyName));
				}
			}
		}

		for (int i = 0; i < expectedList.size(); i++) {
			Assert.assertEquals(expectedList.get(i), actualList.get(i));
			if (expectedList.get(i).equalsIgnoreCase(actualList.get(i))) {
				reports.log(LogStatus.PASS, "Expected" + keyName + "- " + expectedList.get(i) + " Actual" + keyName
						+ "-" + actualList.get(i));
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				validateTextOrFont = true;
			}
		}
		return validateTextOrFont;

	}

	public String fetchTwoLinesLevel() {
		String level = null;
		driver.switchTo().defaultContent();
		System.out.println(upCanvasLine.getAttribute("style"));
		System.out.println(downCanvasLine.getAttribute("style"));
		if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -60px, 0px)")
				&& downCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, 70px, 0px)")) {
			level = "Level2";
		} else if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -70px, 0px)")
				&& downCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, 70px, 0px)")) {
			level = "Level1";
		} else if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -130px, 0px)")
				&& downCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, 305px, 0px)")) {
			level = "Level3";
		}

		return level;
	}

	public void verifyTwoLinesInWithoutOpacityValidation(String lineLevel) throws InterruptedException {
		driver.switchTo().defaultContent();
		if (upCanvasLine.isDisplayed()) {
			reports.log(LogStatus.PASS,
					"Expected Output -: Up Line should Displyaed. Actual Output :- Up Line getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Test cases is failed as Expected Output -: Up Line should Displyaed. Actual Output :- Up Line getting displayed");
		}
		if (downCanvasLine.isDisplayed()) {
			reports.log(LogStatus.PASS,
					"Expected Output -: Down Line should Displyaed. Actual Output :- Down Line getting displayed");
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Test cases is failed as Expected Output -: Down Line should Displyaed. Actual Output :- Down Line not getting displayed");
		}
		if (fetchTwoLinesLevel().equalsIgnoreCase(lineLevel)) {
			reports.log(LogStatus.PASS, "Two Lines are displayted at " + lineLevel);
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase("Two Lines are not displayed at " + lineLevel);
		}

	}

	public void verifyTwoLinesInLibraryScreen(String lineLevel) throws InterruptedException {
	
		verifyTwoLinesInWithoutOpacityValidation(lineLevel);
		verifyOpactiyOfLines();
	}

	public void verifyOpactiyOfLines() throws InterruptedException {
		reports.log(LogStatus.PASS, "Verify Opacity of Two Lines getting displayed on Hub Page");
		driver.switchTo().defaultContent();
		if (upCanvasLine.getCssValue("opacity").equals("0.8")) {
			reports.log(LogStatus.PASS, "Expected Opacity of Up Line - > 0.8 or 80%. Actual Opacity of Up Line is -> "
					+ upCanvasLine.getCssValue("opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Test cases is failed as Expected Opacity of Up Line - > 0.8 or 80%. Actual Opacity of Up Line is -> "
							+ upCanvasLine.getCssValue("opacity"));
		}
		if (downCanvasLine.getCssValue("opacity").equals("0.8")) {
			reports.log(LogStatus.PASS,
					"Expected Opacity of Down Line - > 0.8 or 80%. Actual Opacity of Down Line is -> "
							+ downCanvasLine.getCssValue("opacity"));
			reports.attachScreenshot(captureCurrentScreenshot());
		} else {
			FailTestCase(
					"Test cases is failed as Expected Opacity of Down Line - > 0.8 or 80%. Actual Opacity of Down Line is -> "
							+ downCanvasLine.getCssValue("opacity"));
		}
	}

	public void verifyLineMovementInLibraryScreen() throws InterruptedException {
		verifyLineMoveMentLeftRight();
		verifyLineMovementUpDown();
	}

	private void verifyLineMoveMentLeftRight() throws InterruptedException {
		TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		int menuSize = libraryMenuItems().size();
		for (int i = 0; i < menuSize; i++) {

			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			int listsize = libraryMenuSubItems(i).size();
			for (int j = 0; j < listsize - 1; j++) {
				TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
				driver.switchTo().defaultContent();
				if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -60px, 0px)")
						&& downCanvasLine.getAttribute("style").split(";")[1].trim()
								.contains("translate3d(0px, 70px, 0px)")) {
					reports.log(LogStatus.PASS, "Press RIGHT Key - No Movement in Line");
					reports.attachScreenshot(captureCurrentScreenshot());
				} else {
					FailTestCase("Movement Occur in Lines");
				}
			}
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			for (int j = 0; j < listsize - 1; j++) {
				TestInitization.sendKeyMultipleTimes("LEFT", 1, 1000);
				driver.switchTo().defaultContent();
				if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -60px, 0px)")
						&& downCanvasLine.getAttribute("style").split(";")[1].trim()
								.contains("translate3d(0px, 70px, 0px)")) {
					reports.log(LogStatus.PASS, "Press LEFT Key - No Movement in Line");
					reports.attachScreenshot(captureCurrentScreenshot());
				} else {
					FailTestCase("Movement Occur in Lines");
				}
			}
			TestInitization.sendKeyMultipleTimes("DOWN", 1, 2000);
		}
		TestInitization.sendKeyMultipleTimes("UP", menuSize, 500);
	}

	private void verifyLineMovementUpDown() throws InterruptedException {
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		for (int i = 0; i < libraryMenuItems().size() - 1; i++) {
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			sendKeyMultipleTimes("DOWN", 1, 1000);
			driver.switchTo().defaultContent();
			if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -60px, 0px)")
					&& downCanvasLine.getAttribute("style").split(";")[1].trim()
							.contains("translate3d(0px, 70px, 0px)")) {
				reports.log(LogStatus.PASS, "Press DOWN Key - No Movement in Line while going downward");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Movement Occur in Lines");
			}
		}
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		for (int i = 0; i < libraryMenuItems().size() - 1; i++) {
			sendKeyMultipleTimes("UP", 1, 1000);
			driver.switchTo().defaultContent();
			if (upCanvasLine.getAttribute("style").split(";")[1].trim().contains("translate3d(0px, -60px, 0px)")
					&& downCanvasLine.getAttribute("style").split(";")[1].trim()
							.contains("translate3d(0px, 70px, 0px)")) {
				reports.log(LogStatus.PASS, "Press UP Key - No Movement in Line while going Upward");
				reports.attachScreenshot(captureCurrentScreenshot());
			} else {
				FailTestCase("Movement Occur in Lines");
			}
		}
	}

	public void verifyLinesInLibrarySubMenuScreen(String lineLevel) throws InterruptedException {
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			if (!libraryMenuItems().get(i).getText().equalsIgnoreCase("mijn apps")) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				reports.log(LogStatus.PASS, "Lines at " + libraryMenuItems().get(i).getText());
				verifyTwoLinesInLibraryScreen(lineLevel);
				verifyOpactiyOfLines();
				sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
	}

	public void verifyNavigationinLibrarySubMenu() throws InterruptedException {
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		for (int i = 0; i < libraryMenuItems().size(); i++) {
			if (!libraryMenuItems().get(i).getText().equalsIgnoreCase("mijn apps")) {
				sendKeyMultipleTimes("ENTER", 1, 1000);
				driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
				for (int j = 0; j < 5; j++) {
					sendKeyMultipleTimes("DOWN", 1, 1000);
					driver.switchTo().defaultContent();
					if (upCanvasLine.getAttribute("style").split(";")[1].trim()
							.contains("translate3d(0px, -120px, 0px)")
							&& downCanvasLine.getAttribute("style").split(";")[1].trim()
									.contains("translate3d(0px, 288px, 0px)")) {
						reports.log(LogStatus.PASS, "Press DOWN Key - No Movements in Line");
						reports.attachScreenshot(captureCurrentScreenshot());
					} else {
						FailTestCase("Press DOWN Key - Movement in two Lines");
					}
				}
				for (int j = 0; j < 5; j++) {
					sendKeyMultipleTimes("UP", 1, 1000);
					driver.switchTo().defaultContent();
					if (upCanvasLine.getAttribute("style").split(";")[1].trim()
							.contains("translate3d(0px, -120px, 0px)")
							&& downCanvasLine.getAttribute("style").split(";")[1].trim()
									.contains("translate3d(0px, 288px, 0px)")) {
						reports.log(LogStatus.PASS, "Press UP Key - No Movements in Line");
						reports.attachScreenshot(captureCurrentScreenshot());
					} else {
						FailTestCase("Press UP Key - Movement in two Lines");
					}
				}
			} else {
				sendKeyMultipleTimes("PAGE_DOWN", 1, 1000);
				sendKeyMultipleTimes("DOWN", 1, 1000);
			}
		}
	}

	public void libraryElementActionListDisplayed() throws InterruptedException {

		driver.switchTo().frame(getCurrentFrameIndex());

		List<WebElement> actionList = driver.findElements(By.xpath("//div[@id='sContainerDiv']/div"));
		if (actionList.size() > 0) {
			reports.log(LogStatus.PASS, "Action menu of library screen is visible");
			reports.attachScreenshot(captureCurrentScreenshot());

		}

		else {
			FailTestCase("Action menu of library screen is not visible");
		}
	}
}
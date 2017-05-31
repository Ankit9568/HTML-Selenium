package com.rsystems.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class PIPScreen extends TestInitization {

	/**
	 * This function is used to get cuurent PIP setting element on Setting Screen
	 * Created By Rahul Dhoundiyal
	 */
	public static WebElement getPIPPosition(){	
		return driver.findElement(By.id(ObjectRepository.PIPElements.pipPositonIDElement));
	}
	/**
	 * This function is used to get PIP position element on Screen
	 * Created By Rahul Dhoundiyal
	 */
	public static WebElement getPIPPostionOnScreen()
	{
		WebElement currentElement;
		try {
			currentElement = driver.findElement(By.className(ObjectRepository.PIPElements.currentPIPClassElement));
		}
		catch(org.openqa.selenium.NoSuchElementException ex)
		{
			currentElement = null;
		}
		return currentElement;
	}
	
	/**
	 *  This function is used to navigate to PIP Section under Setting Screen
	 *  Created By Rahul Dhoundiyal
	 */
	public static void goToPIPSettingScreen() throws InterruptedException {
		TestInitization.setApplicationHubPage(2);
		reports.log(LogStatus.PASS, "Navigate to the Setting Screen");
		TestInitization.sendKeysSequenceUpdated("RIGHT,RIGHT,RIGHT,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "Setting", "name_nl"));

		reports.log(LogStatus.PASS, "Step : Navigate to the System Screen");
		TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "System", "name_nl"));

		reports.log(LogStatus.PASS, "Step : Navigate to the PIP Setting Screen");
		TestInitization.sendKeysSequenceUpdated("DOWN,DOWN,DOWN,DOWN,ENTER", 2000,
				TestInitization.getExcelKeyValue("screenTitles", "pipSetting", "name_nl"));
	}

	/**
	 *  This function is used to change the PIP Settings
	 *  Created By Rahul Dhoundiyal
	 */
	public static void changePIPSetting(String pipPosition) throws InterruptedException{
		goToPIPSettingScreen();
		if (!PIPScreen.getPIPPosition().getText().equals(pipPosition))
		{
			TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
		}
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
	}
	/**
	 *  This function is used to verify the PIP Settings set successfully or not
	 *  Created By Rahul Dhoundiyal
	 */
	public static boolean verifyPIPSettingChanged() throws InterruptedException
	{
		boolean validateLinksPIP = false;
		if (PIPScreen.getPIPPostionOnScreen()!=null   && PIPScreen.getPIPPostionOnScreen().isDisplayed() == true){
				validateLinksPIP = true;
		}

		return validateLinksPIP;
	}
}

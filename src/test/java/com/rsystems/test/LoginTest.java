package com.rsystems.test;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class LoginTest extends TestInitization{
	
	
	@Test
	public void hubTextLineNavigation()
	{
		log.info("Logger Info:: Inside Test hubTextLineNavigation() method");
		System.out.println("Hello hubTextLineNavigation");
		//reports.startTest("Starting the test: hubTextLineNavigation()");
		reports.log(LogStatus.INFO, "Step 1: Start with the focus on HUB Text Line");
		
		reports.log(LogStatus.INFO, "Step 2: Navigate to the left most item");
		
		reports.log(LogStatus.INFO, "Step 3: Navigate to the right most item");
		
		reports.log(LogStatus.PASS, "hubTextLineNavigation() Test cases successfully PASSED");
		//reports.endTest();
	}
	
	
	@Test
	public void hubNavigation()
	{
		log.info("Logger Info:: Inside Test hubNavigation() method");
		System.out.println("Hello hubTextLineNavigation");
		//reports.startTest("Starting the test: hubTextLineNavigation()");
		reports.log(LogStatus.INFO, "Step 1: Start with the focus on HUB Text Line");
		
		reports.log(LogStatus.INFO, "Step 2: Navigate to the left most item");
		
		reports.log(LogStatus.INFO, "Step 3: Navigate to the right most item");
		
		reports.log(LogStatus.PASS, "hubTextLineNavigation() Test cases successfully PASSED");
		//reports.endTest();
	}

	@Test
	public void hubShowcaseLineNavigation() throws InterruptedException
	{
		log.info("Logger Info:: Inside Test hubShowcaseLineNavigation() method");
		System.out.println("Hello hubShowcaseLineNavigation");
		//reports.startTest("Starting the test: hubShowcaseLineNavigation()");
		//Thread.sleep(1000);
		driver.switchTo().frame("ScreenHolder1");
		Thread.sleep(1000);
		
		reports.log(LogStatus.INFO, "Step 1: Start with the focus on HUB DTV Showcase Item Focused");
		System.out.println("Default Unfocused elements location on HUB text line is:");
		System.out.println("Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		/*System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_0']']")).getCssValue("color"));
	*/
		
		
		System.out.println("Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_1']")).getLocation().getY());
		/*System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_1']']")).getCssValue("color"));
	*/
		
		
		
		
		System.out.println("Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_2']")).getLocation().getY());
		/*System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_2']']")).getCssValue("color"));
	*/
		
		
		
		System.out.println("Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_3']")).getLocation().getY());
		/*System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_3']']")).getCssValue("color"));
	*/
			
		
		
		System.out.println("Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_4']")).getLocation().getY());
		/*System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_4']']")).getCssValue("color"));
	
		*/
		
		
		
			
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		
		
		
		Actions action = new Actions(driver);
		//Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		//System.out.println("Television Item FOCUSSSSEDDDDDDDDDDD : " + driver.findElement(By.cssSelector(".cMenuItem.cTelevision.cActiveMenuItem_Bold.cActiveMenuItem")).getLocation().getX());
		
		

		
		reports.log(LogStatus.INFO, "Step 2: Focus moved down on TV text line");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		
		
		System.out.println("HUB TV Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("color"));
		
		if(driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("color").equalsIgnoreCase("rgba(255, 255, 255, 1)"))
		{
			System.out.println("Fonts Matchedddddddddddddddddddd");
		}
		else
			System.out.println("FONTS not matached..............");
		
		
		if(driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-family").equalsIgnoreCase("Proximus, ProximusRegular"))
		{
			System.out.println("Fonts Family Matchedddddddddddddddddddd");
		}
		else
			System.out.println("FONTS Family not matached..............");
		
		
		action.sendKeys(Keys.LEFT).perform();
		Thread.sleep(1000);
		reports.log(LogStatus.INFO, "Step 3: Focus moved left on the Library item in text line");
		System.out.println("HUB Library Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_0']")).getCssValue("color"));
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Thread.sleep(2000);
		

		action.sendKeys(Keys.RIGHT).perform();
		Thread.sleep(1000);
		reports.log(LogStatus.INFO, "Step 4: Navigate to the HUB DTV Textline item");
		System.out.println("HUB TV Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_1']")).getCssValue("color"));
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Thread.sleep(2000);
		
	
		action.sendKeys(Keys.RIGHT).perform();
		Thread.sleep(1000);
		reports.log(LogStatus.INFO, "Step 5: Navigate to the HUB Store Text item");
		System.out.println("HUB Store Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_2']")).getCssValue("color"));
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Thread.sleep(2000);
		
		
		action.sendKeys(Keys.RIGHT).perform();
		Thread.sleep(1000);
		reports.log(LogStatus.INFO, "Step 6: Navigate to the HUB Search Text item");
		System.out.println("HUB Search Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("color"));
		System.out.println("Its Background is ::::::: BACKGROUNDDDDDDDDD " + driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("background"));
		
		if(driver.findElement(By.xpath("//li[@id='menuItem_3']")).getCssValue("background").contains("search_active_bold1.png"))
		{
			System.out.println("IMAGE IS OKKKKKKKKKKKKKKKKKK");
			
		}
		else
			System.out.println("IMAGE IS NOT OKKKKKKKKKKKKKKKKKK");
		
		
		
		
		
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Thread.sleep(2000);
		
		action.sendKeys(Keys.RIGHT).perform();
		Thread.sleep(1000);
		reports.log(LogStatus.INFO, "Step 7: Navigate to the HUB Settings Text item");
		System.out.println("HUB Settings Its Location is ::::::: X: " + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getLocation().getX() + "------ Y:  " +driver.findElement(By.xpath("//li[@id='menuItem_0']")).getLocation().getY());
		System.out.println("Its FONTs size is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getCssValue("font-size"));
		System.out.println("Its FONTs Family is :::::::" + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getCssValue("font-family"));
		System.out.println("Its FONTs Color is ::::::: RGB " + driver.findElement(By.xpath("//li[@id='menuItem_4']")).getCssValue("color"));
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		//Thread.sleep(2000);
		
		
		action.sendKeys(Keys.RIGHT).perform();	
		Thread.sleep(1000);			
		reports.log(LogStatus.FAIL, "hubShowcaseLineNavigation() Test cases FAILD");
		reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
		Thread.sleep(2000);
		//reports.endTest();
	}

}

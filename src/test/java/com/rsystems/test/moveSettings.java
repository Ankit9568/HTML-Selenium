package com.rsystems.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class moveSettings extends TestInitization{
	
	
	@Test
	public void hubSettingNavigation() throws InterruptedException
	{
		System.out.println("Hello hubSettingNavigation");
		System.out.println("HUB window handle is:  " + driver.getWindowHandle());
		
		int framesizes = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Frames are::::  " + framesizes);
		
		Thread.sleep(1000);
		driver.switchTo().frame("ScreenHolder1");
		Thread.sleep(1000);
		System.out.println("Switch to Frame : ScreenHolder1");
		System.out.println("Now HUB window handle is:  " + driver.getWindowHandle());
		Actions action = new Actions(driver);
		//Thread.sleep(2000);
		action.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		//System.out.println("Television Item FOCUSSSSEDDDDDDDDDDD : " + driver.findElement(By.cssSelector(".cMenuItem.cTelevision.cActiveMenuItem_Bold.cActiveMenuItem")).getLocation().getX());
		
		

		
		reports.log(LogStatus.INFO, "Step 2: Focus moved down on TV text line");
		
		action.sendKeys(Keys.RIGHT).perform();
		System.out.println("Move to Store Item");
		Thread.sleep(1000);
		
		action.sendKeys(Keys.RIGHT).perform();
		System.out.println("Move to Search Item");
		Thread.sleep(1000);
		
		action.sendKeys(Keys.RIGHT).perform();
		System.out.println("Move to Settings Item");
		Thread.sleep(1000);
		
		action.sendKeys(Keys.ENTER).perform();
		System.out.println("Move to Settings Menu");
		Thread.sleep(2000);
		
		driver.switchTo().defaultContent();
		System.out.println("Setting's window handle is:  " + driver.getWindowHandle());
	
		
		framesizes = driver.findElements(By.xpath("//iframe[contains(@id,'ScreenHolder')]")).size();
		System.out.println("Total Frames are::::  " + framesizes);
		
		WebElement frame1=driver.findElement(By.xpath("//iframe[contains(@id,'ScreenHolder')]"));
		driver.switchTo().frame(frame1);
		Thread.sleep(1000);
		
		
		System.out.println("Move to System Item");
		action.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.DOWN).perform();
		Thread.sleep(1000);
		
		action.sendKeys(Keys.ENTER).perform();
		Thread.sleep(1000);
		
		driver.switchTo().defaultContent();
		System.out.println("Systems's window handle is:  " + driver.getWindowHandle());
		framesizes = driver.findElements(By.xpath("//iframe[contains(@id,'ScreenHolder')]")).size();
		int frameindex=framesizes-1;
		System.out.println("Total Frames are::::  " + framesizes);
		frame1=driver.findElement(By.xpath("//iframe[contains(@id,'ScreenHolder')]"));
		driver.switchTo().frame(frameindex);
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@id='settingHeading']")).getText());
		
		
		
			}


}

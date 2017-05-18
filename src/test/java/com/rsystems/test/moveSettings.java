package com.rsystems.test;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.utils.TestInitization;

public class moveSettings extends TestInitization{
	
	
	@Test
	public void hubSettingNavigation() throws InterruptedException
	{
		System.out.println("Hello hubSettingNavigation");
			
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
		
		
		reports.log(LogStatus.INFO, "Step 2: Focus moved down on TV text line");
		
		TestInitization.sendKeyMultipleTimes("RIGHT", 3, 1000);
		
		System.out.println("Move to Settings Menu");
		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
			
		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		
		System.out.println("Move to System Item");
		TestInitization.sendKeyMultipleTimes("DOWN", 3, 1000);

		TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);

		driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
		System.out.println(driver.findElement(By.xpath("//div[@id='settingHeading']")).getText());
		
		
		
			}


}

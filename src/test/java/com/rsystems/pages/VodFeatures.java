package com.rsystems.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;
import com.rsystems.utils.Unicode;

public class VodFeatures extends TestInitization
{
	 
		WebDriver driver;
	    public VodFeatures(WebDriver driver) 
	    {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(how = How.XPATH, using = ObjectRepository.StoreFilterLayer.shopScreen)
		public WebElement shopScreen;
	    
	    @FindBy(how = How.CLASS_NAME, using = ObjectRepository.Vod.vodHeading)
		public WebElement vodHeading;
	    
	    
	    
	    public boolean naviagteToVideoOndemandScreen() throws InterruptedException
	    {
	    	reports.log(LogStatus.PASS, "Navigate to the Shop Screen");
	    	TestInitization.sendKeyMultipleTimes("DOWN", 1, 1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("RIGHT", 1, 1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	      	reports.log(LogStatus.PASS, "Navigate to the Films Screen");
	    	TestInitization.sendKeyMultipleTimes("ENTER", 1, 1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	reports.log(LogStatus.PASS, "Navigate to the Video Screen");
	    	TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("LEFT",1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	    	reports.log(LogStatus.PASS, "Trailer is getting started");
	    	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	
	    	reports.log(LogStatus.PASS, "Press stop button from RC");
	    	TestInitization.sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(),1,1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    	
	    	driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
	    	String headingVODHeadingDetails = vodHeading.getText();
	    	System.out.println("Vod heading :: "+headingVODHeadingDetails);
	    	String expectedheadingVODHeadingDetails = TestInitization.getExcelKeyValue("Films", "VodHeading", "name_nl");
	    	System.out.println("Expected heading :: "+expectedheadingVODHeadingDetails);
	    	
			if (headingVODHeadingDetails.equalsIgnoreCase(expectedheadingVODHeadingDetails)) 
			{
			reports.log(LogStatus.PASS, "Actual VOD heading details is : "+ headingVODHeadingDetails + " and Expected VOD heading details is: " + expectedheadingVODHeadingDetails +" Test case successfully Passed");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			}
			else 
			{
			FailTestCase("Actual VOD heading details is : "+ headingVODHeadingDetails + " and Expected VOD heading details is : " + expectedheadingVODHeadingDetails +" Test case Failed");
			}
	    	return true;
	    }
	    
	    public boolean navigateToVideoOnDemandScreenHotkey() throws InterruptedException
	    {

			reports.log(LogStatus.PASS, "Navigate to the On demand Screen by Hot key");
			TestInitization.sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1,0);
			reports.attachScreenshot(captureCurrentScreenshot());
			String actualTitleShop=null;
			String expectedTitleShop = TestInitization.getExcelKeyValue("screenTitles", "OnDemandMenu", "name_nl");
			driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
			actualTitleShop=shopScreen.getText();
			System.out.println("actualTitleShop ############## "+actualTitleShop);
			System.out.println("Expected Title ######" + expectedTitleShop);
			
			if (actualTitleShop.equalsIgnoreCase(expectedTitleShop)) 
			{
			reports.log(LogStatus.PASS, "Actual Title of the On Demand Screen is : "+ actualTitleShop + " and Expected Title of the On Demand Screen is: " + expectedTitleShop +" Test case successfully Passed");
			}
			else 
			{
			reports.log(LogStatus.FAIL, "Actual Title of the On Demand Screen is: "+ actualTitleShop + " and Expected Title of the On Demand Screen is : " + expectedTitleShop +" Test case Failed");
			}
			
			return true;
	    	
	    }
	    
	    
	    
	    
	    
}

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
	    
	    @FindBy(how = How.XPATH, using = ObjectRepository.Vod.valueContains)
	 	 public WebElement valueContains;
	    
	    public void navigateToShopScreen() throws InterruptedException
	    {
	    	reports.log(LogStatus.PASS, "Navigate to the Shop Screen");
	    	sendKeyMultipleTimes("DOWN", 1, 1000);
	    	sendKeyMultipleTimes("RIGHT", 1, 1000);
	    	sendKeyMultipleTimes("ENTER", 1, 1000);
	    	reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
	    }
	    
	    public boolean naviagteToVideoOndemandScreen() throws InterruptedException
	    {
	    	navigateToShopScreen();	
	      	reports.log(LogStatus.PASS, "Navigate to the Films Screen");
	    	sendKeyMultipleTimes("ENTER", 1, 1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	reports.log(LogStatus.PASS, "Navigate to the Video Screen");
	    	sendKeyMultipleTimes("LEFT",1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	sendKeyMultipleTimes("LEFT",1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	sendKeyMultipleTimes("LEFT",1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	sendKeyMultipleTimes("ENTER",1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	sendKeyMultipleTimes("RIGHT",1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	sendKeyMultipleTimes("ENTER",1,1000);
	    	reports.log(LogStatus.PASS, "Trailer is getting started");
	    	sendKeyMultipleTimes("ENTER",1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	reports.log(LogStatus.PASS, "Press stop button from RC");
	    	sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(),1,1000);
	    	reports.attachScreenshot(captureCurrentScreenshot());
	    	
	    	driver.switchTo().frame(getCurrentFrameIndex());
	    	String headingVODHeadingDetails = vodHeading.getText();
	    	System.out.println("Vod heading :: "+headingVODHeadingDetails);
	    	String expectedheadingVODHeadingDetails = getExcelKeyValue("Films", "VodHeading", "name_nl");
	    	System.out.println("Expected heading :: "+expectedheadingVODHeadingDetails);
	    	
			if (headingVODHeadingDetails.equalsIgnoreCase(expectedheadingVODHeadingDetails)) 
			{
			reports.log(LogStatus.PASS, "Actual VOD heading details is : "+ headingVODHeadingDetails + " and Expected VOD heading details is: " + expectedheadingVODHeadingDetails +" Test case successfully Passed");
			reports.attachScreenshot(captureCurrentScreenshot());
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
			sendUnicodeMultipleTimes(Unicode.VK_ONDEMAND.toString(), 1,0);
			reports.attachScreenshot(captureCurrentScreenshot());
			String actualTitleShop=null;
			String expectedTitleShop = getExcelKeyValue("screenTitles", "OnDemandMenu", "name_nl");
			driver.switchTo().frame(getCurrentFrameIndex());
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
	    
	    
	    
public void vodOnRent() throws InterruptedException
{
	reports.log(LogStatus.PASS, "Navigate to the Shop Screen");
	TestInitization.sendKeyMultipleTimes("RIGHT",1,1000);
	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Navigate to the Films Screen");
	TestInitization.sendKeyMultipleTimes("ENTER",1,2000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Navigate to the Film Details Screen");
	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS,"Navigate to the Genre Category");
	TestInitization.sendKeyMultipleTimes("ENTER", 1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Navigate to the Drama Category");
	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Navigate to the Play VOD Screen");
	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Playing the Video");
	TestInitization.sendKeyMultipleTimes("DOWN",1,1000);
	TestInitization.sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	sendKeyMultipleTimes("ENTER", 1, 1000);
	
	reports.log(LogStatus.PASS, "Forwarding the Video Playback");
	sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Stopping the video playback will return to the list screen");
	sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(),1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Moving back to the Menu screen");
	sendUnicodeMultipleTimes(Unicode.VK_MENU.toString(), 1, 1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
}

public void unrentMovie() throws InterruptedException
{
	reports.log(LogStatus.PASS, "Navigate to the Shop Screen");
	sendKeyMultipleTimes("RIGHT",1,1000);
	sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	
	reports.log(LogStatus.PASS, "Navigate to the Films Screen");
    sendKeyMultipleTimes("ENTER",1,1000);
    reports.attachScreenshot(captureCurrentScreenshot());
    
    reports.log(LogStatus.PASS, "Playing the movie");
    sendKeyMultipleTimes("LEFT",1,1000);
    sendKeyMultipleTimes("LEFT",1,1000);
    sendKeyMultipleTimes("LEFT",1,1000);
    sendKeyMultipleTimes("ENTER",1,1000);
    sendKeyMultipleTimes("RIGHT",1,1000);
    sendKeyMultipleTimes("ENTER",1,1000);
    reports.attachScreenshot(captureCurrentScreenshot());
    
    driver.switchTo().frame(TestInitization.getCurrentFrameIndex());
    String priceOfItem=itemPrice.getText();
    System.out.println("Price of Items :"+priceOfItem);
    String string = priceOfItem;
	String[] parts = string.split("/");
	System.out.println(parts[0]);
    
    
    String pinValue=valueContains.getText().trim();
    System.out.println("Value Contains :"+pinValue);
    
    String ExpectedValuePin = TestInitization.getExcelKeyValue("Films", "Pinvalue", "name_nl").trim();
    System.out.println("::::::::"+ExpectedValuePin);
    
    if(parts[0].equals("€0,00")&&pinValue.equalsIgnoreCase(ExpectedValuePin))
    {
    reports.log(LogStatus.PASS, "Playing the Video");
    sendKeyMultipleTimes("DOWN",1,1000);
   	sendKeyMultipleTimes("ENTER",1,1000);
   	reports.attachScreenshot(captureCurrentScreenshot());
    }
    else
    {
     FailTestCase("Free movie should not contain Huren");
    }
 
    reports.log(LogStatus.PASS, "Forward the Video");
    sendUnicodeMultipleTimes(Unicode.VK_FORWARD.toString(), 1,0);
    reports.attachScreenshot(captureCurrentScreenshot());
    
    reports.log(LogStatus.PASS, "Stopping the video will return to the list");
    sendUnicodeMultipleTimes(Unicode.VK_STOP_RECORDING.toString(), 1, 0);
    reports.attachScreenshot(captureCurrentScreenshot());
     
}

public void rentalVodDeatils() throws InterruptedException
{
	reports.log(LogStatus.PASS, "Navigate to the VOD rental Folder");
	sendKeyMultipleTimes("LEFT",1,1000);
	sendKeyMultipleTimes("ENTER",1,1000);
	sendKeyMultipleTimes("LEFT",1,1000);
	sendKeyMultipleTimes("ENTER",1,1000);
	reports.attachScreenshot(captureCurrentScreenshot());
	 
	driver.switchTo().frame(getCurrentFrameIndex());
	String movieNames=movieName.getText();
	System.out.println("Movie Name: "+movieNames);
	String dateTimeVod=dateTime.getText();
	System.out.println("Date & time "+dateTimeVod);
	String durationVod=duration.getText();
	System.out.println("Duration of VOD "+durationVod);
	String itemsTotal=totalItems.getText();
	System.out.println("Items Total "+itemsTotal);
	for(int i=0; i<Integer.parseInt(itemsTotal);i++)
	{
	  sendKeyMultipleTimes("DOWN", 1, 1000);
	}

	for(int i=0; i<Integer.parseInt(itemsTotal);i++)
	{
	 sendKeyMultipleTimes("UP", 1, 1000);
	}

}

}

	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    	
	    
	    	
	    	
	   

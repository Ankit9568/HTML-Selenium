package com.rsystems.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.rsystems.config.ObjectRepository;


public class TestInitization {

	public static WebDriver driver;
	public static Logger log;
	public static final ExtentReports reports = ExtentReports.get(TestInitization.class);
	public static Calendar cald;
	public static String captureFilePath;
	public static String currentMethodName;
	public static Xls_Reader excel = new Xls_Reader(ObjectRepository.excelFilePath);
	public static WebDriverWait wait = null;
	
	
	@BeforeSuite
	public void Setup() throws InterruptedException, IOException
	{
		
		String extentReportPath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\rsystems\\testreport\\report.html";
		reports.init(extentReportPath, true);
		reports.config().reportHeadline("HTML Client Automation Testing");
		reports.config().reportTitle("Regression Test Execution");
		reports.config().useExtentFooter(false);
		
		
		log = Logger.getLogger("nitinLogger");
		log.info("Logger Info:: Inside Setup Method");
		
		
		
		FileInputStream FI = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\rsystems\\config\\config.properties");
		Properties PR = new Properties();
		PR.load(FI);
		System.setProperty("webdriver.chrome.driver",PR.getProperty("CHROME_DRIVER_PATH"));		
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to(PR.getProperty("URL"));
		System.out.println("Waiting for the page to load");
		wait = new WebDriverWait(driver, 30L);

		
		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
			System.out.println("Proximus Logo Loaded");
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder1"));
			System.out.println("Frame loaded");
			
			Thread.sleep(2000);
			
			if(driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText().equalsIgnoreCase(getExcelKeyValue("hub", "TV", "name_nl")))
			{
				System.out.println("HUB TV text returned is :: " + driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText());
				System.out.println("HUB is loaded with TV showcase focused");
				
			}
			else{
				
				System.out.println("HUB TV text returned is :: " + driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText());
				System.out.println("This is not equal to Televisie ");
				
			}
				
		}
		catch(Throwable t)
		{
			System.out.println("HUB is not loaded with TV showcase focused " + t );
		}
		
		log.info("Logger Info:: Going out of Setup Method");
	}
	
	@BeforeMethod
	public void beforeMethodCalled(Method method)
	{
		reports.startTest("Starting the Test: + " +  method.getName());
		log.info("Testcase name is :::::: " + method.getName());
		System.out.println("Testcase name is :::::: " + method.getName());
		currentMethodName=method.getName();
				
		

	}
	
	@AfterMethod()
	public void afterMethodCalled()
	{
		reports.endTest();
		
	}
	
	@AfterSuite
	public void suiteEndReached() 
	{
		
		log.info("Logger Info:: Inside suiteEndReached Method");
		driver.quit();
							
	}
	

	public static String captureCurrentScreenshot()
	{
		
		cald = Calendar.getInstance();
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		//System.out.println("Current unformatted time is ::::::::::::::: " + cald.getTime());
		//System.out.println("Current formatted time is ::::::::::::::: " + formatter.format(cald.getTime()).toString());
		String captureFileName = currentMethodName+formatter.format(cald.getTime()).toString()+".jpg";
		
		captureFilePath = System.getProperty("user.dir")+"\\src\\test\\java\\com\\rsystems\\testreport\\screenshots\\"+captureFileName;
		
		
		//System.out.println("Image to be captured as :: " + captureFilePath); 
		//log.info("Image to be captured as :: " + captureFilePath);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile, new File(captureFilePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Exception while taking screenshot");
			log.info("Exception while taking screenshot");
					
			e.printStackTrace();
		}
		
		
		return captureFilePath;
			
	}
	
	
	
	public static String getExcelKeyValue(String sheetname, String objectname, String keyname)
	{
		
		System.out.println("Inside getExcelKeyValue Function");
		
		String sheetName = sheetname;
		String objectName = objectname;
		String keyName = keyname;
		String errorMessage = "Something wrong with your Key-Value Pair";
		
		int rows = excel.getRowCount(sheetName);
		
		for(int rowNum=2; rowNum<=rows; rowNum++)
		{
			
			if(excel.getCellData(sheetName, "objectID", rowNum).equalsIgnoreCase(objectName))
			{
		
				System.out.println("Going out of getExcelKeyValue Function with valid value");
				return excel.getCellData(sheetName, keyName, rowNum);
				
				
				
			}
					
			
			
		}
		
		System.out.println("NOT VALIDDDDDDDDDDDDD");
		System.out.println("Going out of getExcelKeyValue Function without any valid value");
		return errorMessage;
		
	}
	

	
	public static boolean loadHubFocusedDTVTextLine()
	{
		System.out.println("Inside method ::::::::::::::::::::::::::::::::::::::::: loadHubFocusedDTVShowcase");
		driver.navigate().refresh();
		

		try{
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@src='resources/components/animation/images/logo.png']")));
			System.out.println("Proximus Logo Loaded");
			
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("ScreenHolder1"));
			System.out.println("Frame loaded");
			
			Thread.sleep(2000);
			
			if(driver.findElement(By.xpath(ObjectRepository.HubTVItem)).getText().equalsIgnoreCase(getExcelKeyValue("hub", "TV", "name_nl")))
			{
				
				sendKeyMultipleTimes("DOWN", 1, 1000);
				return true;
			}
				
				
		}
		catch(Throwable t)
		{
			
			System.out.println("Element not found:: " + t );
			return false;
			
			
		}
		return false;
		
					
	}
	
	public static int getCurrentFrameIndex()
	{
		int lastFrameIndex;
		driver.switchTo().defaultContent();
		lastFrameIndex = driver.findElements(By.xpath("//iframe[contains(@id,'ScreenHolder')]")).size()-1;
		System.out.println("Last opened frame index is returned as :: " + lastFrameIndex); 
		log.info("Last opened frame index is returned as :: " + lastFrameIndex);		
		
		return lastFrameIndex;
			
	}
	
	public static void sendKeyMultipleTimes(String keyname, int numberoftimes, long delaybetweemKeys) throws InterruptedException
	{
	
		System.out.println("Sending : " + keyname + " numberoftimes : " + numberoftimes + "  with delay in each key as : " + delaybetweemKeys);

		Actions action = new Actions(driver);
		
		
		for(int noOfTimes=0; noOfTimes<numberoftimes;  noOfTimes++)
		{
			action.sendKeys(Keys.valueOf(keyname)).perform();
			Thread.sleep(delaybetweemKeys);
			
			
		}
		
			
	}
	
	
	
	
}

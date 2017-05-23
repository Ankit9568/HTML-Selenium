package com.rsystems.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.rsystems.config.ObjectRepository;
import com.rsystems.utils.TestInitization;

public class Hub extends TestInitization {
	
	WebDriver driver;
	
	public Hub(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubTVItem)
	public WebElement hubTelevisionTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubLibraryItem)
	public WebElement hubLibraryTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubStoreItem)
	public WebElement hubStoreTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubSearchItem)
	public WebElement hubSearchTextLine;
	
	@FindBy(how=How.XPATH,using=ObjectRepository.HubSettingsItem)
	public WebElement hubSettingsTextLine;
		
	public List<WebElement> hubMenuItems()
	{
		/*
		 * This function will check the different elements present on the screen including their translation, font-size, position etc.
		 * Created by Nitin Kaushik
		 */
		log.info("Inside hubMenuItems method ::: It will return the list of elements containing Menu Items");
		System.out.println("Inside hubMenuItems method");
		return driver.findElements(By.xpath("//li[contains(@id,'menuItem')]"));
		
		
	}
	
	
	
	
	/*public String hubCurrentFocusedMenuItem()
	{
		
		String currentFocusedMenuItem = TestInitization.returnElementTextOrImageAtGivenLocation(element, TestInitization.getExcelKeyValue("hub", "HubMenu", "hubFocusedX"), TestInitization.getExcelKeyValue("hub", "HubMenu", "hubFocusedY"));
		
		//String currentFocusedMenuItem = TestInitization.returnElementTextOrImageAtGivenLocation(hubLibraryTextLine, coordX, coordY);
		
		
		if(currentFocusedMenuItem.contains("search_active_bold.png"))
		{
			System.out.println("hubCurrentFocusedMenuItem :: search_active_bold.png");
			return "search_active_bold.png";
		}
			
		else if(currentFocusedMenuItem.contains("setting_active_bold.png"))
		{
			System.out.println("hubCurrentFocusedMenuItem :: setting_active_bold.png");
			return "setting_active_bold.png";
		}
			
		else 		
		{
			System.out.println("hubCurrentFocusedMenuItem :: " + currentFocusedMenuItem);
			return currentFocusedMenuItem;
		}
			
		
	}*/
	
	public String returnElementTextOrImageAtGivenLocation(WebElement element, String elementExcelX, String elementExcelY)
	{
		int x = (int) Float.parseFloat(elementExcelX);
		int y = (int) Float.parseFloat(elementExcelY);
		
		System.out.println("Element returned from excel are x & y :: " + x + " ::::: " + y);		
		System.out.println("Element passed in the function is :::::::::::  " + element);
		
		System.out.println("Element returned x & y :: " + element.getLocation().getX() + " ::::: " + element.getLocation().getY());		
		
		if(element.getLocation().getX()==x && element.getLocation().getY()==y)
		{
			System.out.println("Elemnt's X and Y cordinates are correctly matched");
			log.info("Elemnt's X and Y cordinates are correctly matched");
			
			if(element.getText()!=null)
			{
				System.out.println("Elemnt's Text returned from X and Y cordinates : " + element.getText());
				log.info("Elemnt's Text returned from X and Y cordinates : " + element.getText());
				return element.getText();
				
			}
			else if(element.getCssValue("background-image")!=null)
			{
				System.out.println("Elemnt's Image returned from X and Y cordinates : " + element.getCssValue("background-image"));
				log.info("Elemnt's Image returned from X and Y cordinates : " + element.getCssValue("background-image"));
				return element.getCssValue("background-image");
					
			}
			else
			{
				System.out.println("Neither image nor text found at Elemnt's X and Y cordinates");
				log.info("Neither image nor text found at Elemnt's X and Y cordinates");
				return "Neither text nor image found at the given location";
			}
			
		}
		else
			return "Element not found at the given cordinates";
		
		
	}
	
	
	
	
}

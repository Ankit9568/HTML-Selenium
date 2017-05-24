package com.rsystems.pages;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.LogStatus;
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
	
	
	/*
	 * This function will return the list of translation of Hub Menu Items
	 * Created by Nitin Kaushik
	 */
	
	public List<String> getHubMenuItemsText()
	{
		
		log.info("Inside hubMenuItemsTranslation method ::: This function will return the list of Hub Menu Items Text");
		System.out.println("Inside hubMenuItemsTranslation method ::: This function will return the list of Hub Menu Items Text");
		
		List<String> hubMenuItemList = new ArrayList<String>();
		
		
		for(int i=0; i<driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).size() ;i++)
		{
			
			
			if(i<3)
			{
				hubMenuItemList.add(driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).get(i).getText());
				System.out.println("Adding value in the array list at position + " + i + " " + driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).get(i).getText());	
				
				
			}
			else
			{
				String imageURL = driver.findElements(By.xpath("//li[contains(@id,'menuItem')]")).get(i).getCssValue("background-image");
				hubMenuItemList.add(imageURL.split("/")[imageURL.split("/").length-1].replace("\")", ""));
				System.out.println("Adding value in the array list at position + " + i + " " + imageURL.split("/")[imageURL.split("/").length-1].replace("\")", ""));
			}
			
			
			
		}
		
		
		
		
		return hubMenuItemList;
		
		
	}
	
	
	public List<String> getHubMenuItemsFonts()
	{
		
		log.info("Inside getHubMenuItemsFonts method ::: This function will return the list of Hub Menu Items Fonts");
		System.out.println("Inside getHubMenuItemsFonts method ::: This function will return the list of Hub Menu Items Fonts");
		

		List<String> hubMenuItemFonts = new ArrayList<String>();
		
		
		hubMenuItemFonts.add(hubLibraryTextLine.getAttribute("font-size"));
		hubMenuItemFonts.add(hubTelevisionTextLine.getAttribute("font-size"));
		hubMenuItemFonts.add(hubStoreTextLine.getAttribute("font-size"));
		hubMenuItemFonts.add(hubSearchTextLine.getAttribute("width"));
		hubMenuItemFonts.add(hubSettingsTextLine.getAttribute("width"));

		return hubMenuItemFonts;
		
		
	}
	
	
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

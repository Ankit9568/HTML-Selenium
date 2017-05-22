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
		log.info("Inside hubMenuItemsTranslationCheck method ::: It will return the list of elements containing Menu Items");
		System.out.println("Inside hubMenuItemsTranslationCheck method");
		return driver.findElements(By.xpath("//li[contains(@id,'menuItem')]"));
		
		
	}
	
	
	
	
	public void hubTextlineNavigation()
	{
		
		
		
		
		
		
	}
	

	
	public void hubShowcaselineNavigation()
	{
					
		
	}
	
}

package com.rsystems.test;
import java.util.List;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import com.rsystems.config.ObjectRepository;
import com.rsystems.pages.Hub;
import com.rsystems.utils.TestInitization;

public class HubTestCases extends TestInitization{

	Hub hubScreen = null;
	
	
	@Test
	public void testHubMenuTitles()
	{
		hubScreen = new Hub(driver);
		
		int MenuItemsMismatched = 0;
		
		reports.log(LogStatus.INFO, "Load the Hub with DTV text line focused.");
		TestInitization.loadHubFocusedDTVTextLine();
		
		List<WebElement> hubMenuItems = hubScreen.hubMenuItems();
		

		for(int i=0; i<hubMenuItems.size(); i++)
		{
			try{
				
				
		
				if(i<3)
				{
					
					Assert.assertEquals(ObjectRepository.HubMenuItemsNL[i], hubMenuItems.get(i).getText());
					System.out.println("Menu Item is OK :: " + hubMenuItems.get(i).getText());
					reports.log(LogStatus.INFO, "Translation of Menu Item is OK :: " + hubMenuItems.get(i).getText());
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					
				}
				else
				{
					Assert.assertTrue(hubMenuItems.get(i).getCssValue("background-image").contains(ObjectRepository.HubMenuItemsNL[i]));
					System.out.println("Menu Item is OK :: " + ObjectRepository.HubMenuItemsNL[i]);
					reports.log(LogStatus.INFO, "Icon Image of Menu Item is OK :: " + ObjectRepository.HubMenuItemsNL[i]);
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				}
			
			}
			catch(Throwable t)
			{
				MenuItemsMismatched++;
				System.out.println("Menu Item is Not OK :: " + ObjectRepository.HubMenuItemsNL[i]);
				reports.log(LogStatus.INFO, "Menu Item is Not OK :: " + ObjectRepository.HubMenuItemsNL[i]);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				
				
			}
			
			
			
		}
		
		if(MenuItemsMismatched==0)
		{
			reports.log(LogStatus.PASS,"All Menu Items are correctly displayed in HUB");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			
		}
		else
		{
			reports.log(LogStatus.FAIL, MenuItemsMismatched + "  Menu Items are not correctly displayed in HUB");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				
		}
		
		
		
		
	}
	
	

	@Test
	public void testHubMenuFontsNonFocused()
	{
		hubScreen = new Hub(driver);
		
		int MenuItemsFontMismatched = 0;
		
		reports.log(LogStatus.INFO, "Load the Hub with DTV text line focused.");
		TestInitization.loadHubFocusedDTVTextLine();
		
		reports.log(LogStatus.INFO, "Load the Hub with DTV Showcase line focused.");
		
		
		
		List<WebElement> hubMenuItems = hubScreen.hubMenuItems();
		

		for(int i=0; i<hubMenuItems.size(); i++)
		{
			try{
				
				
		
				if(i<3)
				{
					
					Assert.assertEquals(ObjectRepository.HubMenuItemsNL[i], hubMenuItems.get(i).getText());
					System.out.println("Menu Item is OK :: " + hubMenuItems.get(i).getText());
					reports.log(LogStatus.INFO, "Translation of Menu Item is OK :: " + hubMenuItems.get(i).getText());
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
					
				}
				else
				{
					Assert.assertTrue(hubMenuItems.get(i).getCssValue("background-image").contains(ObjectRepository.HubMenuItemsNL[i]));
					System.out.println("Menu Item is OK :: " + ObjectRepository.HubMenuItemsNL[i]);
					reports.log(LogStatus.INFO, "Icon Image of Menu Item is OK :: " + ObjectRepository.HubMenuItemsNL[i]);
					reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				}
			
			}
			catch(Throwable t)
			{
				MenuItemsFontMismatched++;
				System.out.println("Menu Item is Not OK :: " + ObjectRepository.HubMenuItemsNL[i]);
				reports.log(LogStatus.INFO, "Menu Item is Not OK :: " + ObjectRepository.HubMenuItemsNL[i]);
				reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				
				
			}
			
			
			
		}
		
		if(MenuItemsMismatched==0)
		{
			reports.log(LogStatus.PASS,"All Menu Items are correctly displayed in HUB");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			
		}
		else
		{
			reports.log(LogStatus.FAIL, MenuItemsMismatched + "  Menu Items are not correctly displayed in HUB");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				
		}
		
		
		
		
	}

	
	

}

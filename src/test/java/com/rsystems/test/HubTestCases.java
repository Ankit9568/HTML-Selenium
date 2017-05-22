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
		
		reports.log(LogStatus.INFO, "Load the Hub with focus on DTV showcase.");
		TestInitization.loadHubFocusedDTVShowcase();
		
		List<WebElement> hubMenuItems = hubScreen.hubMenuItems();
		

			
				for(int i=0; i<hubMenuItems.size(); i++)
				{
					try
					{
						
					
					switch(i)
					{
					case 0 : 
						System.out.println("Fonts size is " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("font-size"));
						log.info("Fonts size is " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("font-size"));
						Assert.assertEquals(TestInitization.getExcelKeyValue("hub", "Library", "font-size"), hubMenuItems.get(i).getCssValue("font-size"));
						reports.log(LogStatus.INFO, "Font for Menu Item is OK :: " + hubMenuItems.get(i).getText() + ":::Expected Font:: " +  TestInitization.getExcelKeyValue("hub", "Library", "font-size") + "::::Action Font::::"+hubMenuItems.get(i).getCssValue("font-size"));
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						break;
					
					case 1: 
						Assert.assertEquals(TestInitization.getExcelKeyValue("hub", "TV", "font-size"), hubMenuItems.get(i).getCssValue("font-size"));
						System.out.println("Fonts size is " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("font-size"));
						reports.log(LogStatus.INFO, "Font for Menu Item is OK :: " + hubMenuItems.get(i).getText() + ":::Expected Font:: " +  TestInitization.getExcelKeyValue("hub", "TV", "font-size") + "::::Action Font::::"+hubMenuItems.get(i).getCssValue("font-size"));
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						break;
					
					case 2: 
						Assert.assertEquals(TestInitization.getExcelKeyValue("hub", "Store", "font-size"), hubMenuItems.get(i).getCssValue("font-size"));
						System.out.println("Fonts size is " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("font-size"));
						reports.log(LogStatus.INFO, "Font for Menu Item is OK :: " + hubMenuItems.get(i).getText() + ":::Expected Font:: " +  TestInitization.getExcelKeyValue("hub", "Store", "font-size") + "::::Action Font::::"+hubMenuItems.get(i).getCssValue("font-size"));
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						break;
						
					case 3: 
						Assert.assertEquals(TestInitization.getExcelKeyValue("hub", "Search", "width"), hubMenuItems.get(i).getCssValue("width"));
						Assert.assertEquals(TestInitization.getExcelKeyValue("hub", "Search", "height"), hubMenuItems.get(i).getCssValue("height"));
						System.out.println("Fonts size is " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("width") + hubMenuItems.get(i).getCssValue("height"));
						reports.log(LogStatus.INFO, "Height & Width of Search Icon is OK :: " + hubMenuItems.get(i).getText() + ":::Expected Width & Height:: " +  TestInitization.getExcelKeyValue("hub", "Search", "width") +" , "  +TestInitization.getExcelKeyValue("hub", "Search", "height") + "::::Action Width & Height::::"+hubMenuItems.get(i).getCssValue("width") +" , " + hubMenuItems.get(i).getCssValue("height"));
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						break;
					
					case 4: 
						Assert.assertEquals(TestInitization.getExcelKeyValue("hub", "Settings", "width"), hubMenuItems.get(i).getCssValue("width"));
						System.out.println("Fonts size is " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("width"));
						reports.log(LogStatus.INFO, "Height & Width of Settings Icon is OK :: " + hubMenuItems.get(i).getText() + ":::Expected Width & Height:: " +  TestInitization.getExcelKeyValue("hub", "Settings", "width") +" , "  +TestInitization.getExcelKeyValue("hub", "Settings", "height") + "::::Action Width & Height::::"+hubMenuItems.get(i).getCssValue("width") +" , " + hubMenuItems.get(i).getCssValue("height"));
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						break;
					
					
					}
					
					}
					catch(Throwable t)
					{
						
						MenuItemsFontMismatched++;
						System.out.println("Menu Item font is Not OK :: " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("font-size") + hubMenuItems.get(i).getCssValue("width"));
						reports.log(LogStatus.INFO, "Menu Item font is Not OK :: " + hubMenuItems.get(i).getText()+ hubMenuItems.get(i).getCssValue("font-size") + hubMenuItems.get(i).getCssValue("width"));
						reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
						
						
					}
			
			
				}
		
	
		if(MenuItemsFontMismatched==0)
		{
			reports.log(LogStatus.PASS,"All Menu Items are displayed in correct font size");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
			
		}
		else
		{
			reports.log(LogStatus.FAIL, MenuItemsFontMismatched + "  Menu Items are not correctly displayed in correct font");
			reports.attachScreenshot(TestInitization.captureCurrentScreenshot());
				
		}
		
		
		
		
	}

	
	

}

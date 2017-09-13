package com.rsystems.test;

import org.testng.annotations.Test;

import com.rsystems.pages.Pvr;
import com.rsystems.utils.TestInitization;

public class PvrTestCase extends TestInitization
{
	@Test
	public void TP007_PVRTrickplaymenufromPVR() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.PvrPlayBackMenu();
		
	}
	
    @Test      
	public void TP008_PVRRCKeysduringTrickplay() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.PvrRcTrickPlay();
		
	}
	
	
	
	
	



	
	
	
	
	
	
	
}

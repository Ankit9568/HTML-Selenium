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
	
	@Test
	public void TP009_VOD_TrickplaymenufromVODplayback() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.VODplayback();
		
	}
	
	@Test
	public void TP010_VODRCKeysduringTrickplay() throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.VodRCKeysTrickplay();
		
	}
	
}

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
	
	@Test
	public void TP003_TSTV_Trick_play_menufromFullScreen_TV()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP003_TSTV_Trick_playmenufromFullscreen_TV();
		
	}
	


	@Test
	public void TP006_DTV_RC_Keys_during_Trickplay()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP006_DTV_RC_Keys_Trickplay();
		
	}
	
	
	@Test
	public void TP005_DTV_Trick_playmenufromFullScreen_TV()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP005_DTV_Trick_playmenufromFullscreen_TV();
		
	}
	
	@Test
	public void TP004_TSTV_RC_Keys_during_Trickplay()throws InterruptedException
	{
		Pvr p = new Pvr(driver);
		p.TP004_TSTV_RC_Keys_during_Trickplay();
		
	}
	
	
	
	
	
}

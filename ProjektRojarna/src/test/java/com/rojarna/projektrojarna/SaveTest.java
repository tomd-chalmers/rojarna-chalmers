/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rojarna.projektrojarna;

import junit.framework.TestCase;

/**
 *
 * @author Tom
 */
public class SaveTest extends TestCase {
    
    public SaveTest(String testName) {
        super(testName);
    }

    public void testSaveCampaign() {
        Save.saveCampaign(2,200);
        Save.saveCampaign(1,100);
        Save.saveCampaign(3,300);
        assertTrue(Save.getSavedCampaignLevel()==3 && Save.getSavedCampaignTime()==300);
    }

    public void testGetSavedCampaignLevel() {
        //tested in testSaveCampaign()
    }

    public void testGetSavedCampaignTime() {
        //tested in testSaveCampaign()
    }

    public void testSaveClassic() {
        Save.clearClassic();
        assertTrue(Save.getHighscore().isEmpty());
        Save.saveClassic(1);
        Save.saveClassic(2);
        assertTrue(Save.getHighscore().get(0)==1);
    }

    public void testGetHighscore() {
        //tested in testSaveClassic
    }

    public void testClearClassic() {
        Save.saveClassic(2);
        Save.clearClassic();
        assertTrue(Save.getHighscore().isEmpty());
    }

    public void testClearCampaign() {
        Save.saveCampaign(17, 123);
        Save.clearCampaign();
        assertTrue(Save.getSavedCampaignTime()==0 && Save.getSavedCampaignLevel()==0);
    }
}

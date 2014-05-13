package com.rojarna.projektrojarna;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * OBS! koden är lite stökig ska fixa de senare här är metoderna.
 * 
 * för classic:
 * void saveClassic(int score) - skapar (om det inte redan finns) och lägger till ett score.
 * List<Integer> getHighescore() - returnerar en lista med bästa score på förstaplats.
 * void clearClassic() - clearar allt score. (tar bort filen).
 * 
 * för campaign:
 * void saveCampaign(int level, int time) -  sparar leveln och tiden(i sekunder)
 * int getSavedCampaignLevel() - returner level
 * int getSavedCampaignTime() - returner tid
 * void clearCampaign() - clearar sparade filen. (tar bort filen).
 * @author tomd
 *
 */
public class Save {
	private final static String pathClassic = "save/classicSave.sav";
	private final static File fileClassic = new File(pathClassic);
	
	private final static String pathCampaign = "save/CampaignSave.sav";
	private final static File fileCampaign = new File(pathCampaign);
	
	public static void saveCampaign(int level, int time){
		checkAndCreateCampaign();
		try
		{
			FileWriter fw = new FileWriter(pathCampaign,true);
			fw.write(level+"\n"+time);
			fw.close();
		}
		catch(IOException e)
		{
			System.err.println("IOException: " + e.getMessage());
		}
	}
	
	public static int getSavedCampaignLevel(){
		int level=0;
		if(!fileCampaign.exists()){
			return level;
		}
		else{
			List<String> lines = new ArrayList<String>();
			List<Integer> intList=new ArrayList<Integer>();
			 try {
		            lines = Files.readAllLines(Paths.get(pathCampaign),Charset.defaultCharset());
		            for (String line : lines) {
		                intList.add(Integer.parseInt(line));
		            }
			 }
			 catch (IOException e) {
		            System.err.println("IOException: " + e.getMessage());
		        }
			 return intList.get(0);// first value is the level.
		}
	}
	public static int getSavedCampaignTime(){
		int time=0;
		if(!fileCampaign.exists()){
			return time;
		}
		else{
			List<String> lines = new ArrayList<String>();
			List<Integer> intList=new ArrayList<Integer>();
			 try {
		            lines = Files.readAllLines(Paths.get(pathCampaign),Charset.defaultCharset());
		            for (String line : lines) {
		                intList.add(Integer.parseInt(line));
		            }
			 }
			 catch (IOException e) {
		            System.err.println("IOException: " + e.getMessage());
		        }
			 return intList.get(1);// first value is the level.
		}
	}
	
	// saveclassic
	public static void saveClassic(int score){
		checkAndCreateClassic();
		try
		{
		    FileWriter fw = new FileWriter(pathClassic,true); 
		    fw.write(score+"\n");
		    fw.close();
		}
		catch(IOException e)
		{
		    System.err.println("IOException: " + e.getMessage());
		}
	}
	
	public static List<Integer> getHighscore(){ // return a list with highscore highest first.
		checkAndCreateClassic();
		List<String> lines = new ArrayList<String>();
		List<Integer> intList=new ArrayList<Integer>();
		 try {
	            lines = Files.readAllLines(Paths.get(pathClassic),Charset.defaultCharset());
	            for (String line : lines) {
	                intList.add(Integer.parseInt(line));
	            }
	            Collections.sort(intList);
	            Collections.reverse(intList);
	        } 
		 catch (IOException e) {
	            System.err.println("IOException: " + e.getMessage());
	        }
		 System.out.println(intList); // for test only
		return intList;    
	}
	
	private static void checkAndCreateClassic(){
		if(!fileClassic.exists()){
			fileClassic.getParentFile().mkdir();
			try {
				fileClassic.createNewFile();
			} catch (IOException e) {
				System.err.println("IOException: " + e.getMessage());
			}
		}
	}// end off checkAndCreate
	
	private static void checkAndCreateCampaign(){
		if(!fileCampaign.exists()){
			fileCampaign.getParentFile().mkdir();
			try{
				fileCampaign.createNewFile();
			} catch (IOException e){
				System.err.println("IOException: " + e.getMessage());
			}
		}else{
			if(fileCampaign.delete()){//succsesfullydeleted.
			}else{
				System.out.println("ERROR: could not delete the save!");
			}
		}
	}
	
	public static void clearClassic(){
            try{
                if(fileClassic.exists()){
                    fileClassic.delete();
		}
            }
          catch(Exception e){
              e.printStackTrace();
            }
	}
	public static void clearCampaign(){
            try{
                if(fileCampaign.exists()){
                    fileCampaign.delete();
		}
            }
          catch(Exception e){
              e.printStackTrace();
            }
	}
}

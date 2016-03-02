package fr.univavignon.courbes.stats;

import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StockageStats {
	
	public static void writeStats(String player, String stat, long howMuch)
	{
		int whichLine = -1;
		if(stat == "ELO") whichLine = 0;
		if(stat == "playedGames") whichLine = 2;
		if(stat == "wonGames") whichLine = 3;
		if(stat == "playedRounds") whichLine = 4;
		if(stat == "wonRounds") whichLine = 5;
		if(stat == "pointsTotal") whichLine = 6;
		//if(whichLine == -1) exit;
		
		try {
			File fichier = new File(player);
			
			FileWriter fw = new FileWriter (player);
			BufferedWriter bw = new BufferedWriter (fw);
			PrintWriter saveFile = new PrintWriter (bw);
			
			InputStream ips = new FileInputStream(player); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			if (! fichier.exists())
			{
				saveFile.println("0");
				saveFile.println(player);
				saveFile.println("0");
				saveFile.println("0");
				saveFile.println("0");
				saveFile.println("0");
				saveFile.println("0");
			}
			
			while(whichLine > 0)
			{
				br.readLine();
				whichLine --;
			}
			
			String readed = br.readLine();
			br.close();
			long swappedStat = Long.parseLong(readed);
			swappedStat = swappedStat+howMuch;
			
			saveFile.println(swappedStat);
			saveFile.close();
			}
		
		catch (Exception e) {System.out.println(e.toString());}	
	}

}

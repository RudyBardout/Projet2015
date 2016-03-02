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
	
	public static void writeStats(String player, String stat, int howMuch)
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
			File fichier = new File(player+".txt");
			
			if (!fichier.exists())
			{
				FileWriter fw = new FileWriter (player+".txt");
				BufferedWriter bw = new BufferedWriter (fw);
				
				bw.write("0\n");
				bw.write(player);
				bw.write("\n");
				bw.write("0\n");
				bw.write("0\n");
				bw.write("0\n");
				bw.write("0\n");
				bw.write("0\n");
				bw.flush();
				bw.close();
				
				System.out.println("fichier créé");
			} 
			
			FileWriter fw = new FileWriter (player+".txt");
			BufferedWriter bw = new BufferedWriter (fw);
			
			InputStream ips = new FileInputStream(player+".txt"); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);
			
			String ligne;
			int numLigne = 0;
			int howLigne = 8;
			
			int[] var = new int[howLigne];
			
			while ((ligne = br.readLine()) != null)
			{
			numLigne++;
			System.out.println(ligne);
			//chaine += ligne + "\n";
			int ind = ligne.indexOf(" ");
			var[numLigne -1] = Integer.parseInt(ligne.substring(0, ind));
			} 
			
			var[whichLine] = var[whichLine] + howMuch;
			
			bw.write(var[0]);
			bw.write("\n");
			bw.write(var[1]);
			bw.write("\n");
			bw.write(var[2]);
			bw.write("\n");
			bw.write(var[3]);
			bw.write("\n");
			bw.write(var[4]);
			bw.write("\n");
			bw.write(var[5]);
			bw.write("\n");
			bw.write(var[6]);
			bw.write("\n");
			bw.write(var[7]);
			bw.flush();
			bw.close();
			
			}
		
		catch (Exception e) {System.out.println(e.toString());}
	
	}
} 

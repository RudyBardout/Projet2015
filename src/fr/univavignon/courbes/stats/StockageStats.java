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
	static int ELO = 0;
	static String player = "Default";
	static int playedGames = 0;
	static int wonGames = 0;
	static int playedRounds = 0;
	static int wonRounds = 0;
	static int pointsTotal = 0;
	
	public StockageStats(String p, String stat, int howMuch){
		player = p;
		getFile(player);

		/*if(stat == "ELO") {
			//var[whichLine] = var[whichLine] + howMuch;
		}*/
		/*if(stat == "player") {
			//var[whichLine] = var[whichLine] + howMuch;
		}*/
		if(stat == "playedGames") {
			playedGames += howMuch;
			//var[whichLine] = var[whichLine] + howMuch;
		}
		if(stat == "wonGames") {
			wonGames += howMuch;
			//var[whichLine] = var[whichLine] + howMuch;
		}
		if(stat == "playedRounds") {
			playedRounds += howMuch;
			//var[whichLine] = var[whichLine] + howMuch;
		}
		if(stat == "wonRounds") {
			wonRounds += howMuch;
			//var[whichLine] = var[whichLine] + howMuch;
		}
		if(stat == "pointsTotal") {
			pointsTotal += howMuch;
			//var[whichLine] = var[whichLine] + howMuch;
		}
	}
	
	public static void writeStats(String player, String stat, int howMuch)
	{
		StockageStats statsProfile = new StockageStats(player,stat,howMuch);
		/*File fichier = new File(player+".txt");
		if (!fichier.exists()) {
			createFile(player);
		}*/
		
		try {
			
			FileWriter fw = new FileWriter(player+".txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			/*InputStream ips = new FileInputStream(player+".txt"); 
			InputStreamReader ipsr = new InputStreamReader(ips);
			BufferedReader br = new BufferedReader(ipsr);*/
			
			//int howLigne = 8;
			//int[] var = new int[howLigne];
			
			//int whichLine = -1;
			String NewWriting,NewWriting2,NewWriting3,NewWriting4,NewWriting5,NewWriting6;
			
			NewWriting = Integer.toString(statsProfile.ELO);
			bw.write(NewWriting);
			bw.write("\n");
			
			bw.write(statsProfile.player);
			bw.write("\n");
			
			NewWriting2 = Integer.toString(statsProfile.playedGames);
			bw.write(NewWriting2);
			bw.write("\n");
			
			NewWriting3 = Integer.toString(statsProfile.wonGames);
			bw.write(NewWriting3);
			bw.write("\n");
			
			NewWriting4 = Integer.toString(statsProfile.playedRounds);
			bw.write(NewWriting4);
			bw.write("\n");
			
			NewWriting5 = Integer.toString(statsProfile.wonRounds);
			bw.write(NewWriting5);
			bw.write("\n");
			
			NewWriting6 = Integer.toString(statsProfile.pointsTotal);
			bw.write(NewWriting6);
			bw.write("\n");
			
			/*if(stat == "ELO") {
				whichLine = 0;
				//var[whichLine] = var[whichLine] + howMuch;
			}
			if(stat == "player") {
				whichLine = 1;
				//var[whichLine] = var[whichLine] + howMuch;
			}
			if(stat == "playedGames") {
				whichLine = 2;
				//var[whichLine] = var[whichLine] + howMuch;
			}
			if(stat == "wonGames") {
				whichLine = 3;
				//var[whichLine] = var[whichLine] + howMuch;
			}
			if(stat == "playedRounds") {
				whichLine = 4;
				//var[whichLine] = var[whichLine] + howMuch;
			}
			if(stat == "wonRounds") {
				whichLine = 5;
				//var[whichLine] = var[whichLine] + howMuch;
			}
			if(stat == "pointsTotal") {
				whichLine = 6;
				//var[whichLine] = var[whichLine] + howMuch;
			}*/
			//if(whichLine == -1) exit;
			//var[whichLine] = var[whichLine] + howMuch;
			
			/*String NewWriting = Integer.toString(var[whichLine]);
			bw.write("Elo\n");
			bw.write(player);
			bw.write("\n");
			
			/*for(int i = 2; i < howLigne; i++)
			{
				NewWriting = Integer.toString(var[i]);
				bw.write(NewWriting);
				bw.write("\n");
			}*/
			/*int i = 0;
			String NewWriting = Integer.toString(var[whichLine]);	// pb ici
			while (i < whichLine) {
				i++;
				bw.write(NewWriting);
				//br.readLine();
			}

			bw.write(NewWriting);
			bw.write("\n");*/
			//bw.write(var[whichLine]);
			
			
			
			
			//String ligne;
			//int numLigne = 0;
			
			
			//ligne = br.readLine();
			/*while (br.readLine() != null) {
				if (br.readLine() == stat) {
					var[whichLine] = var[whichLine] + howMuch;
				}
				numLigne++;
			}*/
			/*ligne = br.readLine();
			while ((ligne = br.readLine()) != null)
			//while (ligne != null)
			{
			numLigne++;
			System.out.println(ligne);
			//chaine += ligne + "\n";
			int ind = ligne.indexOf(" ");
			var[numLigne -1] = Integer.parseInt(ligne.substring(0, ind));
			//ligne = br.readLine();
			} */
			
			//var[whichLine] = var[whichLine] + howMuch;
			
			/*String NewWriting = Integer.toString(var[whichLine]);
			bw.write(NewWriting);
			bw.write("\n");
			
			bw.write(player);
			bw.write("\n");
			
			for(int i = 2; i < howLigne; i++)
			{
				NewWriting = Integer.toString(var[i]);
				bw.write(NewWriting);
				bw.write("\n");
			}*/
			
			
			bw.flush();
			bw.close();
			//br.close();
			
		}
		
		catch (Exception e) {System.out.println(e.toString());}
	
	}
	
	public static void createFile(String player) {
		try {
			FileWriter fw = new FileWriter (player+".txt",true);
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
		catch (Exception e) {System.out.println(e.toString());}
	}
	
	public static void getFile(String player) {
	//String chaine = null;
	// lecture du fichier texte
		try {
				InputStream ips = new FileInputStream(player+".txt");
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
				String ligne;
				int numLigne = 0;
				int nombreDeLignes = 7; // par exemple
				int[] var = new int[nombreDeLignes];
				
				while ((ligne = br.readLine()) != null) {
					numLigne++;
					System.out.println(ligne);
					//chaine += ligne + "\n";
					//int ind = ligne.indexOf(" ");
					System.out.println("test avant");
					//var[numLigne -1] = Integer.parseInt(ligne.substring(0));
					var[numLigne - 1] = Integer.parseInt(ligne.substring(0));
					System.out.println("test après");
				}

				StockageStats.ELO = var[0];
				StockageStats.player = player;
				StockageStats.playedGames = var[2];
				StockageStats.wonGames = var[3];
				StockageStats.playedRounds = var[4];
				StockageStats.wonRounds = var[5];
				StockageStats.pointsTotal = var[6];
			
				/*for (int i = 0; i < var.length; i++) {
					System.out.println("var[" + i + "] = " + var[i]);
				}*/
			
				br.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		} 
	}
} 

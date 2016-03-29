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

/** 
 * 
 * Classe permettant la gestion des statistiques dans des fichiers textes.
 * 
 * @author Laurent Harkiolakis
 * @author Félix Boucher
 *
 */
public class StockageStats {
	static int ELO = 0;
	static String player = "Default";
	static int playedGames = 0;
	static int wonGames = 0;
	static int playedRounds = 0;
	static int wonRounds = 0;
	static int pointsTotal = 0;
	
	/**
	 * Constructeur à 3 arguments de la classe.
	 * 
	 * @param p Nom du Joueur.
	 * @param stat Nom de la stat à incrémenter.
	 * @param howMuch Nombre qu'on incrémente.
	 * 
	 * @author Laurent Harkiolakis
	 * @author Felix Boucher
	 * 
	 */
	public StockageStats(String p, String stat, int howMuch){
		player = p;
		getFile(player);
		if(stat == "playedGames")	playedGames += howMuch;
		if(stat == "wonGames")	wonGames += howMuch;
		if(stat == "playedRounds")	playedRounds += howMuch;
		if(stat == "wonRounds")	wonRounds += howMuch;
		if(stat == "pointsTotal")	pointsTotal += howMuch;
	}
	
	/**
	 * Méthode pour gérer l'écriture dans un fichier.
	 * 
	 * @param player Nom du Joueur.
	 * @param stat Nom de la stat à incrémenter.
	 * @param howMuch Nombre qu'on incrémente.
	 * 
	 * @author Laurent Harkiolakis
	 * @author Félix Boucher
	 * 
	 */
	public static void writeStats(String player, String stat, int howMuch) {
		StockageStats statsProfile = new StockageStats(player,stat,howMuch);
		
		try {
			
			FileWriter fw = new FileWriter(player+".txt");
			BufferedWriter bw = new BufferedWriter(fw);
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
			
			bw.flush();
			bw.close();
			
		}
		
		catch (Exception e) {System.out.println(e.toString());}
	
	}
	
	/**
	 * Méthode permettant de conserver un fichier texte d'une partie à une autre.
	 * 
	 * @param player Nom du joueur.
	 * 
	 * @author Laurent Harkiolakis
	 */
	public static void getFile(String player) {
		try {
				InputStream ips = new FileInputStream(player+".txt");
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
				String ligne;
				int nombreDeLignes = 7;
				int[] var = new int[nombreDeLignes];
				
				int i = 0;
				ligne = br.readLine();
				ligne = br.readLine();
				i=2;
				
				while ((ligne = br.readLine()) != null) {
					var[i] = Integer.parseInt(ligne.substring(0));
					i++;
				}

				StockageStats.ELO = var[0];
				StockageStats.player = player;
				StockageStats.playedGames = var[2];
				StockageStats.wonGames = var[3];
				StockageStats.playedRounds = var[4];
				StockageStats.wonRounds = var[5];
				StockageStats.pointsTotal = var[6];
			
				br.close();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		} 
	}
} 

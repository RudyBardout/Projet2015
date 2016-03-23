package fr.univavignon.courbes.inter.stats;

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

import fr.univavignon.courbes.stats.StockageStats;

public class AffichageStats {
	static boolean clockwork = true;
	static String name_J1;
	static String name_J2;
	static int[][] matriceStats = new int[7][2];

public AffichageStats(){
	
		String target = "Kvothe";
		
		readFile(target);

		System.out.println(name_J1);
		System.out.println(matriceStats[0][0]);
		System.out.println(matriceStats[2][0]);
		System.out.println(matriceStats[3][0]);
		System.out.println(matriceStats[4][0]);
		System.out.println(matriceStats[5][0]);
		System.out.println(matriceStats[6][0]);
		
		System.out.println(name_J2);
		System.out.println(matriceStats[0][1]);
		System.out.println(matriceStats[2][1]);
		System.out.println(matriceStats[3][1]);
		System.out.println(matriceStats[4][1]);
		System.out.println(matriceStats[5][1]);
		System.out.println(matriceStats[6][1]);
	}

public static void readFile(String player) {
	// lecture du fichier texte
		try {
				InputStream ips = new FileInputStream(player+".txt");
				InputStreamReader ipsr = new InputStreamReader(ips);
				BufferedReader br = new BufferedReader(ipsr);
				String ligne;
				int numLigne = 0;
					
					if (clockwork == true)
					{
						while ((ligne = br.readLine()) != null) {
							numLigne++;
							if (numLigne == 1) name_J1 = ligne.substring(0);
							else matriceStats[numLigne - 1][0] = Integer.parseInt(ligne.substring(0));
						}
						clockwork = false;
					}
					
					else if (clockwork == false)
					{
						while ((ligne = br.readLine()) != null) {
							numLigne++;
							if (numLigne == 1) name_J2 = ligne.substring(0);
							else matriceStats[numLigne - 1][1] = Integer.parseInt(ligne.substring(0));
						}
						clockwork = true;
					}

				br.close();
		}
		
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}
}
package fr.univavignon.courbes.network.central;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HttpsURLConnection;
import javax.swing.JOptionPane;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;



public class ConnexionWithPhp {
	private final String USER_AGENT = "Mozilla/5.0";
	
	
	//verification existence profile dans bdd
	public String verification( String userName,  String password){
		
		String result ="";
		try {
			result = this.sendGet("verefication", "verification",  "verification", "verification",   userName,   password).toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;			
	}
	
//On choisit l'action a executer, puis on ajouter l'username et le mot de passe pour interroger la BDD
	public void doAction(String action, String eloRank,String email,String country, String username, String password)
	{	switch(action){
			case "login" :
			this.se_connecter( eloRank,  email, country,   username,   password);
			break;
			case "singup" :
			this.cree_compte( eloRank,  email, country,   username,   password);
			break;
			case "remove" :
			this.supprimer_compte( eloRank,  email, country,   username,   password);
			break;
			
		}
		
	}




private void supprimer_compte(String eloRank, String email, String country, String username, String password) {
	String result ="";
	try {
		result = this.sendGet("remove", eloRank,  email,  country,   username,   password).toString();
	} catch (NumberFormatException e) {
		e.printStackTrace();
	} catch (Exception e) {
		e.printStackTrace();
	}
	supprimer_compte_result(result);
	
		
	}




	private void supprimer_compte_result(String result) {
		if (result.equals("1")) 
			System.out.println("Compte suprrime Avec succÃ©s"); 
		else 
			System.out.println("Erreur durant la suppression du compte"); 		
		
}




	//Cette fonction sert Ã  crer un compte
	private void cree_compte(String celoRank,String cemail,String ccountry, String cusername, String cpassword)
	{
		String result ="";
		try {
			result = this.sendGet("singup", celoRank,  cemail, ccountry,   cusername,   cpassword).toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		creee_compte_result(result);		
	}




//durant la creation cette fonction traite les rÃ©sultats de la fonction de creation du compte
	private void creee_compte_result(String result) {
		if (result.equals("1")) 
			System.out.println("Compte cree Avec succÃ©s"); 
		else 
			System.out.println("Erreur durant la creation du compte"); 		
	}




//CF. connecte un utilisateur 
	private  void se_connecter(String seloRank,String semail,String scountry, String susername, String spassword)
	{
		String result ="";
		try {
			result = this.sendGet("login", seloRank,  semail,  scountry,   susername,   spassword).toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		se_connecter_result(result);
		
	} 
	//les resultats de la connexion
	private  void se_connecter_result (String result) 
	{ if (result.equals("1")) 
	System.out.println("Vous etes connecter Avec succÃ©s"); 
	else 
		System.out.println("Erreur durant la connexion"); 
} 


//Envoie des infos avec get
private String sendGet(String action, String eloRank, String email, String country,String   username, String  password) throws Exception {
	String url = "";
	switch(action){
	case "login" :
		url+="https://pedago02a.univ-avignon.fr/~uapv1600538/projet2015/connexion.php?action="+action+"&username="+username+"&password="+password;
		break;
	case "verefication" :
		url+="https://pedago02a.univ-avignon.fr/~uapv1600538/projet2015/connexion.php?action="+action+"&username="+username+"&password="+password;
		break;
		case "singup" :
		url+="https://pedago02a.univ-avignon.fr/~uapv1600538/projet2015/connexion.php?country="+country+"&eloRank="+eloRank+"&email="+email+"&action="+action+"&username="+username+"&password="+password;
		break;	
		case "getProfiles" :
		url+="https://pedago02a.univ-avignon.fr/~uapv1600538/projet2015/connexion.php?country="+country+"&eloRank="+eloRank+"&email="+email+"&action="+action+"&username="+username+"&password="+password;
		break;	
		case "remove" :
		url+="https://pedago02a.univ-avignon.fr/~uapv1600538/projet2015/connexion.php?country="+country+"&eloRank="+eloRank+"&email="+email+"&action="+action+"&username="+username+"&password="+password;
		break;	
	}
	System.out.println(url);
	URL obj = new URL(url);
	HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	con.setRequestMethod("GET");
	con.setRequestProperty("User-Agent", USER_AGENT);
	int responseCode = con.getResponseCode();
	System.out.println("\nSending 'GET' request to URL : " + url);
	System.out.println("Response Code : " + responseCode);

	BufferedReader in = new BufferedReader(
		new InputStreamReader(con.getInputStream()));
	String inputLine;
	StringBuffer response = new StringBuffer();

	while ((inputLine = in.readLine()) != null) {
		response.append(inputLine);
	}
	in.close();

//print result
	System.out.println(response.toString());
	return response.toString();
}

public void mise_ajour_des_profiles() {
	final String PROFILE_FILE = "res/profiles/profiles.txt";
	

	//mise a jour du fichier de profiles 
			try {
				PrintWriter fichier = new PrintWriter(new FileWriter(PROFILE_FILE ), false);
				String result = this.sendGet("getProfiles", "getProfiles",  "getProfiles", "getProfiles",   "getProfiles",   "getProfiles").toString();
				
				int i = 0;
				Pattern p = Pattern.compile("\n");
				Matcher m = p.matcher( result.replace('|', '\n') );
				while (m.find()) {
				    i++;
				}
				if(i<=0){
					throw new Exception();
				}
				
				fichier.print(result.replace('|', '\n'));
				fichier.close();
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null,"Erreur pendent la mise a jours  des profiles, erreur N�:"+Thread.currentThread().getStackTrace()[2].getLineNumber(), "Error",
	                         JOptionPane.ERROR_MESSAGE);
				}	
}

}
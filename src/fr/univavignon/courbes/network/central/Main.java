package fr.univavignon.courbes.network.central;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		ConnexionWithPhp MyHttpConnexion = new ConnexionWithPhp();
		Scanner scanner = new Scanner(System.in);
		String username ="";
		String password="";
		String country="0";
		String eloRank="0";
		String email="0";
		String action="";
		int actionId=1;

		


		System.out.println("LOGIN : 1  --- SINGUP : 2");
		
        if(scanner.nextInt()==1){
        	action="login";


        username=scanner.nextLine();
        if(username.isEmpty()){
        	System.out.println("Entrer Username : ");
            username=scanner.nextLine();
        	System.out.println("Bonjour, merci d'entrer un password : ");
        	password=scanner.nextLine();
        }


        }else{
            username=scanner.nextLine();
            for(int i=1;i<=6;i++){
            	switch(i){
            	case 1 : System.out.println("Entrer Username : ");
                username=scanner.nextLine();
            		break;

            	case 2 : System.out.println("Bonjour, merci d'entrer un password : ");
            	password=scanner.nextLine();
            		break;

            	case 3 : System.out.println("Bonjour, merci d'entrer  country: ");
            	country=scanner.nextLine();
            		break;

            	case 4 : System.out.println("Bonjour, merci d'entrer eloRank : ");
            	eloRank=scanner.nextLine();
            		break;

            	case 5 : System.out.println("Bonjour, merci d'entrer email : ");
            	email=scanner.nextLine();
            		break;
    		    	
            	}
            }
        	action="singup";

        }

        
     
		

		MyHttpConnexion.doAction(action, eloRank, email, country, username, password);

	}

	
	
}

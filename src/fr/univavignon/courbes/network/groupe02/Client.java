package fr.univavignon.courbes.network.groupe02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.List;
import java.util.Map;


import fr.univavignon.courbes.common.Board;
import fr.univavignon.courbes.common.Direction;
import fr.univavignon.courbes.common.Profile;
import fr.univavignon.courbes.network.ClientCommunication;
/**
 * 
 * 
 * @author Marie et Mary    
 * 
 * On fait la classe Client
 *
 */
public class Client implements ClientCommunication
{

	protected Socket socketClient = null;
	protected int port = 2345;
	
	@Override
	public String getIp() 
	{
		InetAddress ipServer;
		String ip="";
		
		try
		{
			ipServer = InetAddress.getLocalHost();
			ip = ipServer.getHostAddress();
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		return ip;
	}

	@Override
	public void setIp(String ip) 
	{
	
	}

	@Override
	public int getPort() 
	{
		return port; //juste pour l'interface utilisateur, pour qu'ils puisssent afficher le port.
	}

	@Override
	public void setPort(int port) 
	{

	}

	@Override
	public void launchClient() 
	{
		String ip = getIp();
	     try 
	     {
	         socketClient = new Socket(getIp(), port);
	         BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
	         PrintStream out = new PrintStream(socketClient.getOutputStream());
	     } 
	     catch (UnknownHostException e) 
	     {
	         e.printStackTrace();
	     } 
	     catch (IOException e) 
	     {
	         e.printStackTrace();
	     }
		
		
	}

	@Override
	public void closeClient() 
	{
			if(socketClient != null)
			{
				try
				{
					socketClient.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
					socketClient = null;
				}
			}
	}

	@Override
	public List<Profile> retrieveProfiles() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer retrievePointThreshold() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Board retrieveBoard() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendCommands(Map<Integer, Direction> commands) 
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public String retrieveText() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendText(String message) 
	{
		// TODO Auto-generated method stub
		
	}
	
}
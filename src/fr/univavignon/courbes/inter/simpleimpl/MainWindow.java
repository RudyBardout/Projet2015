package fr.univavignon.courbes.inter.simpleimpl;
import fr.univavignon.courbes.sounds.*;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import fr.univavignon.courbes.common.Player;
import fr.univavignon.courbes.common.Round;
import fr.univavignon.courbes.inter.ErrorHandler;
import fr.univavignon.courbes.inter.simpleimpl.local.LocalGamePlayerSelectionPanel;
import fr.univavignon.courbes.inter.simpleimpl.local.LocalGameRoundPanel;
import fr.univavignon.courbes.inter.simpleimpl.profiles.ProfileListPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.client.ClientGamePlayerSelectionPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.client.ClientGameRoundPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.client.ClientGameServerConnectionPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.client.ClientGameWaitPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.server.ServerGameLocalPlayerSelectionPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.server.ServerGamePortSelectionPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.server.ServerGameRemotePlayerSelectionPanel;
import fr.univavignon.courbes.inter.simpleimpl.remote.server.ServerGameRoundPanel;
import fr.univavignon.courbes.network.ClientCommunication;
import fr.univavignon.courbes.network.ServerCommunication;

/**
 * Menu principal du jeu.
 * 
 * @author	L3 Info UAPV 2015-16
 */
public class MainWindow extends JFrame implements ErrorHandler, WindowListener
{	/** Numéro de série de la classe */
	private static final long serialVersionUID = 1L;
	/** Nom du jeu */
	private static final String GAME_NAME = "Courbes";
	/** Version du jeu */
	private static final String GAME_VERSION = "1";
	private static Sound a = new Sound();


	/**
	 * Crée le menu principal et tous ses composants graphiques.
	 */
	public MainWindow()
	{	super();

		initWindow();

	}
	
	/** Panel correspondant au menu principal */
	private MainMenuPanel mainMenuPanel;
	/** Panel actuellement affiché */
	private JPanel currentPanel;
	/** Manche en cours de jeu */
	public Round currentRound;
	/** Moteur réseau actuellement utilisé par le serveur */
	public ServerCommunication serverCom;
	/** Moteur réseau actuellement utilisé par le client */
	public ClientCommunication clientCom;
	/** Joueur sélectionné côté client pour participer à une partie réseau */
	public Player clientPlayer;
	
	/**
	 * Initialise la fenêtre.
	 */
	private void initWindow()
			
	{	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	//a.menu();
	
	
		updateTitle();
		try
		{	String iconPath = "res/images/icon.png";
			File iconFile = new File(iconPath);
			Image img = ImageIO.read(iconFile);
			setIconImage(img);
		}
		catch(IOException e)
		{	e.printStackTrace();
		}
		
		int windowHeight = SettingsManager.getWindowHeight();
		int windowWidth = SettingsManager.getWindowWidth();
		Dimension dim = new Dimension(windowWidth,windowHeight);
		setPreferredSize(dim);
		setMinimumSize(dim);
		setMaximumSize(dim);
		setResizable(false);
		
		mainMenuPanel = new MainMenuPanel(this);
		currentPanel = mainMenuPanel;
		getContentPane().add(currentPanel);
		
		pack();
		setLocationRelativeTo(null);
		addWindowListener(this);
		setVisible(true);

	}
	
	/**
	 * Checks if saving is required,
	 * then close the window.
	 */
	public void closeWindow()
	{	// on tue éventuellement le processus en cours de jeu
		if(currentPanel instanceof LocalGameRoundPanel)
		{	LocalGameRoundPanel lgrp = (LocalGameRoundPanel)currentPanel;
			lgrp.stop();
		}
		
		// on ferme la fenêtre
		dispose();
		System.exit(0);
	}

	/**
	 * Type énuméré utilisé pour basculer d'un panel à un autre.
	 * 
	 * @author	L3 Info UAPV 2015-16
	 */
	public enum PanelName
	{	/** Menu principal */
		MAIN_MENU,
		
		/** Sélection des joueurs pour une partie locale */
		LOCAL_GAME_PLAYER_SELECTION,
		/** Aire de jeu d'une partie locale */
		LOCAL_GAME_PLAY,
		
		/** Sélection du port TCP utilisé pour les connexions aux clients */
		SERVER_GAME_PORT_SELECTION,
		/** Sélection des joueurs locaux au serveur pour une partie réseau */
		SERVER_GAME_LOCAL_PLAYER_SELECTION,
		/** Sélection des joueurs distants pour une partie réseau */
		SERVER_GAME_REMOTE_PLAYER_SELECTION,
		/** Aire de jeu d'une partie réseau côté serveur */
		SERVER_GAME_PLAY,
		
		/** Configuration des informations de connexion pour une partie client */
		CLIENT_GAME_CONNECTION,
		/** Sélection du joueur local géré par ce client */
		CLIENT_GAME_PLAYER_SELECTION,
		/** Attente du début de partie */
		CLIENT_GAME_WAIT,
		/** Aire de jeu d'une partie réseau côté client */
		CLIENT_GAME_PLAY,
		
		/** Liste des profils */
		PROFILE_LIST,
		/** Affichage des statistiques */
		STATISTICS;
	}
	
	/**
	 * Change le panel actuellement affiché dans cette fenêtre.
	 * 
	 * @param panelName
	 * 		Nom du panel à afficher dans cette fenêtre.
	 */
	public void displayPanel(PanelName panelName)
	{	
a.menu();
		getContentPane().remove(currentPanel);
		switch(panelName)
		{	case MAIN_MENU:
				currentPanel = mainMenuPanel;
				break;
			case LOCAL_GAME_PLAYER_SELECTION:
				currentPanel = new LocalGamePlayerSelectionPanel(this);
				break;
			case LOCAL_GAME_PLAY:
				currentPanel = new LocalGameRoundPanel(this);
				break;
			case SERVER_GAME_PORT_SELECTION:
				currentPanel = new ServerGamePortSelectionPanel(this);
				break;
			case SERVER_GAME_LOCAL_PLAYER_SELECTION:
				currentPanel = new ServerGameLocalPlayerSelectionPanel(this);
				break;
			case SERVER_GAME_REMOTE_PLAYER_SELECTION:
				currentPanel = new ServerGameRemotePlayerSelectionPanel(this);
				break;
			case SERVER_GAME_PLAY:
				currentPanel = new ServerGameRoundPanel(this);
				break;
			case CLIENT_GAME_CONNECTION:
				currentPanel = new ClientGameServerConnectionPanel(this);
				break;
			case CLIENT_GAME_PLAYER_SELECTION:
				currentPanel = new ClientGamePlayerSelectionPanel(this);
				break;
			case CLIENT_GAME_WAIT:
				currentPanel = new ClientGameWaitPanel(this);
				break;
			case CLIENT_GAME_PLAY:
				currentPanel = new ClientGameRoundPanel(this);
				break;
			case PROFILE_LIST:
				currentPanel = new ProfileListPanel(this);
				break;
			case STATISTICS:
				System.out.println("Option pas encore implémentée...");
				// TODO à compléter
				// currentPanel = new XxxxxxPanel(this);
				break;
		}
		a.end();
		updateTitle();
		getContentPane().add(currentPanel);
		validate();
		repaint();	
		

	}
	
	/**
	 * Met à jour le titre de la fenêtre.
	 */
	public void updateTitle()
	{	String title = GAME_NAME + " v" + GAME_VERSION;
		if(serverCom!=null)
		{	String ipStr = serverCom.getIp();
			title = title + " - " + ipStr;
		}
		setTitle(title);
		//action a = new Sound();
		//((Sound) a).end();
	}
	
	@Override
	public void displayError(final String errorMessage)
	{	final MainWindow window = this;
		SwingUtilities.invokeLater(new Runnable()
		{	@Override
			public void run()
			{	JOptionPane.showMessageDialog(window, errorMessage, "Erreur", JOptionPane.WARNING_MESSAGE);
				System.out.println("ERROR: "+errorMessage);
			}
		});
	}
	
	@Override
	public void windowOpened(WindowEvent e)
	{	// pas utilisé
	}
	
	@Override
	public void windowClosing(WindowEvent e)
	{	closeWindow();
	}
	
	@Override
	public void windowClosed(WindowEvent e)
	{	// pas utilisé
	}

	@Override
	public void windowIconified(WindowEvent e)
	{	// pas utilisé
	}
	
	@Override
	public void windowDeiconified(WindowEvent e)
	{	// pas utilisé
	}
	
	@Override
	public void windowActivated(WindowEvent e)
	{	// pas utilisé
	}
	
	@Override
	public void windowDeactivated(WindowEvent e)
	{	// pas utilisé
	}
}

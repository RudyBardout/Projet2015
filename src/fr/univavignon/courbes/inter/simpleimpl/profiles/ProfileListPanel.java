package fr.univavignon.courbes.inter.simpleimpl.profiles;

/*
 * Courbes
 * Copyright 2015-16 L3 Info UAPV 2015-16
 * 
 * This file is part of Courbes.
 * 
 * Courbes is free software: you can redistribute it and/or modify it under the terms 
 * of the GNU General Public License as published by the Free Software Foundation, 
 * either version 2 of the License, or (at your option) any later version.
 * 
 * Courbes is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; 
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR 
 * PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Courbes. If not, see <http://www.gnu.org/licenses/>.
 */

import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import fr.univavignon.courbes.common.Profile;
import fr.univavignon.courbes.inter.simpleimpl.MainWindow;
import fr.univavignon.courbes.inter.simpleimpl.MainWindow.PanelName;
import fr.univavignon.courbes.inter.simpleimpl.SettingsManager;
import fr.univavignon.courbes.network.central.ConnexionWithPhp;

/**
 * Panel destinÃ© Ã  afficher la liste des profils existants.
 * 
 * @author	L3 Info UAPV 2015-16
 */
public class ProfileListPanel extends JPanel implements ActionListener, FocusListener
{	/** NumÃ©ro de sÃ©rie de la classe */
	private static final long serialVersionUID = 1L;
	/** Nom par dÃ©faut pour le champ texte */
	private static final String DEFAULT_NAME = "Nom";
	/** Pays par dÃ©faut pour le champ texte */
	private static final String DEFAULT_COUNTRY = "Pays";
	/** password par dÃ©faut pour le champ texte */
	private static final String DEFAULT_PASSWORD = "password";
	/**
	 * CrÃ©e un nouveau panel destinÃ© Ã  afficher la liste des profils.
	 * 
	 * @param mainWindow
	 * 		FenÃªtre principale contenant ce panel.
	 */
	public ProfileListPanel(MainWindow mainWindow)
	{	super();
		this.mainWindow = mainWindow;
		
		init();
	}

	/** FenÃªtre contenant ce panel */
	private MainWindow mainWindow;
	/** Table affichÃ©e par ce panel */
	private JTable playerTable;
	/** Scrollpane contenu dans ce panel pour afficher la table */
	private JScrollPane scrollPane; 
	/** Champ texte contenant le nom d'un nouveau profil */
	private JTextField nameField;
	/** Champ texte contenant le pays d'un nouveau profil */
	private JTextField countryField;
	/** Bouton pour revenir au menu principal */
	private JButton backButton;
	/** Bouton pour ajouter le nouveau profil */
	private JButton addButton;
	/** Bouton pour supprimer le profil sÃ©lectionnÃ© */
	private JButton removeButton;
	/** Champ texte contenant le mot de passe d'un nouveau profil */
	private JPasswordField passwordField;
	/** champ de validation de mot de passe **/
	 final JFrame parent = new JFrame();
	/* La connexion avec PHP */
	 private ConnexionWithPhp MyHttpConnexion = new ConnexionWithPhp();

	
	/**
	 * MÃ©thode principale d'initialisation du panel.
	 */
	private void init()
	{	BoxLayout layout = new BoxLayout(this, BoxLayout.PAGE_AXIS);
		setLayout(layout);
	
		initTablePanel();
		
		add(Box.createVerticalGlue());
		
		initTextFields();
		initButtonsPanel();
	}
	
	/**
	 * Initialisation de la table affichÃ©e par ce panel.
	 */
	private void initTablePanel()
	{	playerTable = new JTable();
		playerTable.setAutoCreateRowSorter(true);
		
		playerTable.setModel(new ProfileTableModel());
		
		scrollPane = new JScrollPane
		(	playerTable,
			JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
			JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED
		);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
		scrollPane.setAlignmentX(Component.CENTER_ALIGNMENT);
		Dimension frameDim = mainWindow.getPreferredSize();
		int boardHeight = SettingsManager.getBoardHeight();
		Dimension dim = new Dimension(frameDim.width,(int)(boardHeight*0.8));
		add(scrollPane);
	}

	/**
	 * Initialisation des champs texte contenus dans ce panel.
	 */
	private void initTextFields()
<<<<<<< HEAD
	{		
		
		MyHttpConnexion.mise_ajour_des_profiles();
		
			
		
		JLabel newPlayerLabel = new JLabel("Nouveau profil");
=======
	{	JLabel newPlayerLabel = new JLabel("Nouveau profil");
		newPlayerLabel.setHorizontalAlignment(SwingConstants.CENTER);
>>>>>>> branch 'master' of git@github.com:CeriAvignon/Projet2015.git
		add(newPlayerLabel);
		

		
		
		Dimension frameDim = mainWindow.getPreferredSize();
		Dimension dim = new Dimension(frameDim.width,30);
		
		nameField = new JTextField(DEFAULT_NAME);
		nameField.addFocusListener(this);
		nameField.setPreferredSize(dim);
		nameField.setMaximumSize(dim);
		nameField.setMinimumSize(dim);
		add(nameField);

		passwordField = new JPasswordField(DEFAULT_PASSWORD);
		passwordField.addFocusListener(this);
		passwordField.setPreferredSize(dim);
		passwordField.setMaximumSize(dim);
		passwordField.setMinimumSize(dim);
		add(passwordField);

		countryField = new JTextField(DEFAULT_COUNTRY);
		countryField.addFocusListener(this);
		
		
		countryField.setPreferredSize(dim);
		countryField.setMaximumSize(dim);
		countryField.setMinimumSize(dim);
		add(countryField);
	}
	
	/**
	 * Initialisation des boutons contenus dans ce panel.
	 */
	private void initButtonsPanel()
	{	JPanel panel = new JPanel();
		BoxLayout layout = new BoxLayout(panel, BoxLayout.LINE_AXIS);
		panel.setLayout(layout);
		
		backButton = new JButton("Retour");
		backButton.addActionListener(this);
		panel.add(backButton);
		
		panel.add(Box.createHorizontalGlue());
		
		removeButton = new JButton("Supprimer");
		removeButton.addActionListener(this);
		panel.add(removeButton);
		
		panel.add(Box.createHorizontalGlue());
		
		addButton = new JButton("Ajouter");
		addButton.addActionListener(this);
		panel.add(addButton);
		
		add(panel);
	}
	
	/**
	 * Validation de l'ajout d'un nouveau profil.
	 */
	private void addPlayer()
	{	String userName = nameField.getText();
		String country = countryField.getText();
		String password = String.valueOf(passwordField.getPassword());


		// on vÃ©rifie que les champs ont Ã©tÃ© remplis, et que le nom n'est pas dÃ©jÃ  pris
		if(!userName.isEmpty() && !country.isEmpty() && !ProfileManager.containsUserName(userName))
		{
			try{
			// on crÃ©e le profil
			Profile profile = new Profile();
			profile.userName = userName;
			profile.country = country;
			profile.email = "test@gmail.com";
			profile.password=password;
			
			profile.eloRank = ProfileManager.getProfiles().size()+1;
			String action="singup";

			
			// on le rajoute Ã  la liste
			ProfileManager.addProfile(profile);
			
			// on le rajoute dans la table
			ProfileTableModel model = (ProfileTableModel) playerTable.getModel();
			model.addProfile(profile);
			
			//on le ajouter à la base de donnes
			MyHttpConnexion.doAction(action, String.valueOf(profile.eloRank), profile.email, profile.country, profile.userName, password);	

			
			// on rÃ©initialise les champs texte
			nameField.setText(DEFAULT_NAME);
			countryField.setText(DEFAULT_COUNTRY);
			
			//Affichage de PopUp
			 JOptionPane.showMessageDialog(null,"Compte cree avec Succes !", "Succes", JOptionPane.INFORMATION_MESSAGE);
			}catch (Exception e){
				 JOptionPane.showMessageDialog(null,"Impossible de crer le compte, erreur N�:"+Thread.currentThread().getStackTrace()[2].getLineNumber(), "Error",
                         JOptionPane.ERROR_MESSAGE);
			}
			}
			
			
			
			}
	
	

	/**
	 * Suppression d'un profil existant.
	 */
	private void removePlayer()
	{	int selected = playerTable.getSelectedRow();
	

    String input = (String) JOptionPane.showInputDialog(
        new JFrame(),
        "Merci d'entrer le mot de passe du compte choisi",
        "Verification", JOptionPane.INFORMATION_MESSAGE,
        new ImageIcon("java2sLogo.GIF"), null, "password");
    System.out.println("User's input: " + input);
    	
    	// on rÃ©cupÃ¨re le profil
			List<Profile> profiles = new ArrayList<Profile>(ProfileManager.getProfiles());
			Profile profile = profiles.get(selected);
			


			if(MyHttpConnexion.verification(profile.userName,input).equals("1")){
				try{
				// on supprime le profil de la liste
				ProfileManager.removeProfile(profile);
				
				// on le supprime de la table
				ProfileTableModel model = (ProfileTableModel) playerTable.getModel();
				model.removeProfile(selected);
				
				//On le supprime de la base de donnes
				String action="remove";
				MyHttpConnexion.doAction(action,"willberemoved","willberemoved", "willberemoved", profile.userName, profile.password);	
				//Affichage de PopUp
				 JOptionPane.showMessageDialog(null,"Compte supprim� avec Succes !", "Succes", JOptionPane.INFORMATION_MESSAGE);
				}catch (Exception e){
					 JOptionPane.showMessageDialog(null,"Impossible de supprimer le compte, erreur N�:"+Thread.currentThread().getStackTrace()[2].getLineNumber(), "Error",
	                         JOptionPane.ERROR_MESSAGE);
				}

		}else{
			JOptionPane.showMessageDialog(null,"Impossible de supprimer le compte : Password erron�", "Error",
                    JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
	
	
	@Override
	public void focusGained(FocusEvent e)
	{	if(e.getSource()==nameField)
		{	nameField.setText("");
		}
		else if(e.getSource()==countryField)
		{	countryField.setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent e)
	{	// pas utilisÃ©
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{	if(e.getSource()==backButton)
			mainWindow.displayPanel(PanelName.MAIN_MENU);
		else if(e.getSource()==addButton){
			addPlayer();
			MyHttpConnexion.mise_ajour_des_profiles();
		}
		else if(e.getSource()==removeButton){
			removePlayer();
			MyHttpConnexion.mise_ajour_des_profiles();
		}
	}
}

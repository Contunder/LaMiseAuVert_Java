package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Crypt;
import Controller.DBConnect;
import DAO.PensionDAO;
import DAO.ProprietaireDAO;
import DAO.UtilisateurDAO;
import Modele.Proprietaire;
import Modele.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class AddCompte extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldNom;
	private JTextField fieldPrenom;
	private JTextField fieldAdresse;
	private JTextField fieldTel;
	private JTextField fieldEmail;
	private JPasswordField fieldPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCompte frame = new AddCompte(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddCompte(Utilisateur utilisateur) {
		
		String url= DBConnect.getUrl();
		String dbName = DBConnect.getDbName();
		String userName = DBConnect.getUserName();
		String password = DBConnect.getPassword();
		
		PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
		ProprietaireDAO proprietaireDAO = new ProprietaireDAO(url, dbName, userName, password);
		UtilisateurDAO utilisateurDAO = new UtilisateurDAO(url, dbName, userName, password);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(177, 6, 112, 16);
		contentPane.add(labelName);
		
		JLabel labelCreateCompte = new JLabel("Cree un Compte");
		labelCreateCompte.setBounds(177, 34, 112, 16);
		contentPane.add(labelCreateCompte);
		
		JLabel labelNom = new JLabel("Nom :");
		labelNom.setBounds(20, 65, 61, 16);
		contentPane.add(labelNom);
		
		JLabel labelPrenom = new JLabel("Prenom :");
		labelPrenom.setBounds(20, 93, 61, 16);
		contentPane.add(labelPrenom);
		
		JLabel labelType = new JLabel("Type de Compte :");
		labelType.setBounds(20, 121, 110, 16);
		contentPane.add(labelType);
		
		JLabel labelAdresse = new JLabel("Adresse :");
		labelAdresse.setBounds(20, 149, 61, 16);
		contentPane.add(labelAdresse);
		
		JLabel labelTel = new JLabel("Telephone :");
		labelTel.setBounds(20, 177, 73, 16);
		contentPane.add(labelTel);
		
		JLabel labelEmail = new JLabel("Email :");
		labelEmail.setBounds(20, 205, 61, 16);
		contentPane.add(labelEmail);
		
		JLabel labelPass = new JLabel("Mot de Passe :");
		labelPass.setBounds(20, 233, 96, 16);
		contentPane.add(labelPass);
		
		fieldNom = new JTextField();
		fieldNom.setBounds(177, 60, 200, 26);
		contentPane.add(fieldNom);
		fieldNom.setColumns(10);
		
		fieldPrenom = new JTextField();
		fieldPrenom.setBounds(177, 88, 200, 26);
		contentPane.add(fieldPrenom);
		fieldPrenom.setColumns(10);
		
		JComboBox<String> typeCompte;
		if (utilisateur.getRole().equals("ADMIN")) {
			List<String> pensionVille = pensionDAO.getAllPension();
			typeCompte = new JComboBox<String>(pensionVille.toArray(new String[0]));
			typeCompte.addItem("ADMIN");
			typeCompte.addItem("USER");
			typeCompte.setBounds(177, 117, 200, 27);
			contentPane.add(typeCompte);
		} else {
			String userRole = utilisateur.getRole().toString();
			typeCompte = new JComboBox<String>();
			typeCompte.addItem(userRole);
			typeCompte.addItem("USER");
			typeCompte.setBounds(177, 117, 200, 27);
			contentPane.add(typeCompte);
		}
		
		fieldAdresse = new JTextField();
		fieldAdresse.setBounds(177, 144, 200, 26);
		contentPane.add(fieldAdresse);
		fieldAdresse.setColumns(10);
		
		fieldTel = new JTextField();
		fieldTel.setBounds(177, 172, 200, 26);
		contentPane.add(fieldTel);
		fieldTel.setColumns(10);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(177, 200, 200, 26);
		contentPane.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		fieldPass = new JPasswordField();
		fieldPass.setBounds(177, 228, 200, 26);
		contentPane.add(fieldPass);
		
		JButton btnCreate = new JButton("Cree un Compte");
		btnCreate.setBounds(279, 266, 145, 29);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String Nom = fieldNom.getText();
				String Prenom = fieldPrenom.getText();
				String Role = typeCompte.getSelectedItem().toString();
				String Adresse = fieldAdresse.getText();
				String Telephone = fieldTel.getText();
				String Email = fieldEmail.getText();
				char[] passChar = fieldPass.getPassword();
				String Pass = new String(passChar);
				String hashed_password = Crypt.encryptThisString(Pass);
				Proprietaire proprietaire = proprietaireDAO.getProprietaireByEmail(Email);
				if (proprietaire.getNom() == null) {
					proprietaireDAO.newProprietaire(Nom, Prenom, Adresse, Telephone, Email);
					proprietaire = proprietaireDAO.getProprietaireByEmail(Email);
					utilisateurDAO.newUtilisateur(proprietaire.getId(), hashed_password, Role);
					labelCreateCompte.setText("Utilisateur Cree");
				} else {
					labelCreateCompte.setText("Le mail existe déjà");
				}
			}
			
		});
		
		JButton btnAnnul = new JButton("Annuler");
		btnAnnul.setBounds(150, 266, 117, 29);
		contentPane.add(btnAnnul);
		btnAnnul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
			
		});
	}
}

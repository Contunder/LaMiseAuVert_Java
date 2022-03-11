package View;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Crypt;
import DAO.ProprietaireDAO;
import DAO.UtilisateurDAO;

import Modele.Proprietaire;
import Modele.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Connect extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldEmail;
	private JPasswordField passwordField;
	private static Connect frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Connect();
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
	public Connect() {
		
		String url="jdbc:mysql://127.0.0.1/";
		String dbName = "lamiseauvert";
		String userName = "Valentin";
		String password = "kilabilon";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(174, 6, 112, 16);
		contentPane.add(labelName);
		
		JLabel labelEmail = new JLabel("Adresse Email :");
		labelEmail.setBounds(28, 56, 101, 16);
		contentPane.add(labelEmail);
		
		JLabel labelPass = new JLabel("Mot de Passe :");
		labelPass.setBounds(28, 84, 101, 16);
		contentPane.add(labelPass);
		
		fieldEmail = new JTextField();
		fieldEmail.setBounds(141, 51, 274, 26);
		contentPane.add(fieldEmail);
		fieldEmail.setColumns(10);
		
		JLabel labelError = new JLabel("Erreur");
		labelError.setForeground(Color.RED);
		labelError.setBounds(141, 34, 274, 16);
		labelError.setVisible(false);
		contentPane.add(labelError);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 79, 274, 26);
		contentPane.add(passwordField);
		
		JButton btnConnect = new JButton("Se Connecter");
		btnConnect.setBounds(298, 125, 117, 29);
		contentPane.add(btnConnect);
		btnConnect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				char[] passChar = passwordField.getPassword();
				String pass = new String(passChar);
				String email = fieldEmail.getText();
				ProprietaireDAO proprietaireDAO = new ProprietaireDAO(url, dbName, userName, password);
				Proprietaire proprietaire = proprietaireDAO.getProprietaireByEmail(email);
				if(proprietaire.getEmail() != null) {
					String hashed_password = Crypt.encryptThisString(pass);
					UtilisateurDAO utilisateurDAO = new UtilisateurDAO(url, dbName, userName, password);
					Utilisateur utilisateur = utilisateurDAO.getUtilisateurByPassword(hashed_password);
					if(utilisateur.getPassword() != null) {
						frame.setVisible(false);
						Pension Pension = new Pension(utilisateur, proprietaire);
						Pension.setVisible(true);
					} else {
						labelError.setText("Erreur : Email ou Mot de Passe invalide !");
						labelError.setVisible(true);
					}
				} else {
					labelError.setText("Erreur : Email ou Mot de Passe invalide !");
					labelError.setVisible(true);
				}
				
			}
		});
		
	}
}

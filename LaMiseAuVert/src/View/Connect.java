package View;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.net.URL;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Crypt;
import Controller.DBConnect;
import DAO.ProprietaireDAO;
import DAO.UtilisateurDAO;

import Modele.Proprietaire;
import Modele.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect frame = new Connect();
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
		
		String url= DBConnect.getUrl();
		String dbName = DBConnect.getDbName();
		String userName = DBConnect.getUserName();
		String password = DBConnect.getPassword();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 214);
		setVisible(true);
		setTitle("La Mise Au Vert - Connexion");
		URL iconURL = getClass().getResource("/images/icon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		
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
		fieldEmail.setText("valentin.denavaut@hotmail.fr");
		
		JLabel labelError = new JLabel("Erreur");
		labelError.setForeground(Color.RED);
		labelError.setBounds(28, 33, 387, 16);
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
					Utilisateur utilisateur = utilisateurDAO.getUtilisateurByPassword(hashed_password, proprietaire.getId());
					String verifUtilAdmin =  new String("ADMIN");
					String verifUtilUser = new String("USER");
					if(utilisateur.getPassword() != null) {
						String Role = new String(utilisateur.getRole());
						if (Role.equals(verifUtilAdmin)){
							setVisible(false);
							Admin Admin = new Admin(utilisateur, proprietaire);
							Admin.setVisible(true);
						}else if (Role.equals(verifUtilUser)) {
							labelError.setText("Erreur : Vous ne pouvez pas vous connecter avec ce compte !");
							labelError.setVisible(true);
						}else {
							setVisible(false);
							Pension Pension = new Pension(utilisateur, proprietaire);
							Pension.setVisible(true);
						}
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

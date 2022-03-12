package View;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DBConnect;
import DAO.PensionDAO;
import DAO.PrixDAO;
import Modele.Proprietaire;
import Modele.Utilisateur;

import javax.swing.JLabel;
import javax.swing.JButton;

public class Pension extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Connect connectFrame = null;
	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pension frame = new Pension(null, null);
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
	public Pension(Utilisateur utilisateur, Proprietaire proprietaire) {
		
		String url= DBConnect.getUrl();
		String dbName = DBConnect.getDbName();
		String userName = DBConnect.getUserName();
		String password = DBConnect.getPassword();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(170, 6, 112, 16);
		contentPane.add(labelName);
		
		JButton btnEditPen = new JButton("Modifier ma Pension");
		btnEditPen.setBounds(39, 63, 156, 29);
		contentPane.add(btnEditPen);
		btnEditPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
				Modele.Pension pension = pensionDAO.getPensionByVille(utilisateur.getRole());
				EditPension EditPension = new EditPension(pension);
				EditPension.setVisible(true);
			}
			
		});
		
		JButton btnEditPrix = new JButton("Modifier mes Prix");
		btnEditPrix.setBounds(243, 63, 156, 29);
		contentPane.add(btnEditPrix);
		btnEditPrix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrixDAO prixDAO = new PrixDAO(url, dbName, userName, password);
				PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
				
				Modele.Pension pension = pensionDAO.getPensionByVille(utilisateur.getRole());
				Modele.Prix prixHotel = prixDAO.getPrixByVilleAndLibelle(utilisateur.getRole(), "Hotel Canin");
				Modele.Prix prixCamping = prixDAO.getPrixByVilleAndLibelle(utilisateur.getRole(), "Camping Canin");
				Modele.Prix prixPension = prixDAO.getPrixByVilleAndLibelle(utilisateur.getRole(), "Pension Feline");
				EditPrix EditPrix = new EditPrix(prixHotel, prixCamping, prixPension, pension);
				EditPrix.setVisible(true);
			}
			
		});
		
		JLabel labelPen = new JLabel("Connecter avec " + utilisateur.getRole());
		labelPen.setBounds(39, 35, 179, 16);
		contentPane.add(labelPen);
		
		JButton btnCreeCompte = new JButton("Cree un Compte");
		btnCreeCompte.setBounds(39, 104, 156, 29);
		contentPane.add(btnCreeCompte);
		btnCreeCompte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCompte AddCompte = new AddCompte();
				AddCompte.setVisible(true);
			}
			
		});
		
		JButton btnClient = new JButton("Infos Client");
		btnClient.setBounds(242, 104, 157, 29);
		contentPane.add(btnClient);
		btnClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client Client = new Client();
				Client.setVisible(true);
			}
			
		});
		
		JButton btnDeco = new JButton("Deconnection");
		btnDeco.setBounds(282, 206, 117, 29);
		contentPane.add(btnDeco);
		btnDeco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
			
		});
	}

}

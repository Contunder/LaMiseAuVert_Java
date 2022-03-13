package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DBConnect;
import DAO.PensionDAO;
import DAO.PrixDAO;
import Modele.Proprietaire;
import Modele.Utilisateur;
import javax.swing.JSpinner;
import javax.swing.JComboBox;

public class Admin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel labelSelectPension;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin(null, null);
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
	public Admin(Utilisateur utilisateur, Proprietaire proprietaire) {
		
		String url= DBConnect.getUrl();
		String dbName = DBConnect.getDbName();
		String userName = DBConnect.getUserName();
		String password = DBConnect.getPassword();
		
		PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		labelSelectPension = new JPanel();
		labelSelectPension.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(labelSelectPension);
		labelSelectPension.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(170, 6, 112, 16);
		labelSelectPension.add(labelName);
		
		JLabel labelPen = new JLabel("Connecter avec " + utilisateur.getRole());
		labelPen.setBounds(39, 35, 179, 16);
		labelSelectPension.add(labelPen);
		
		JLabel lblNewLabel = new JLabel("Pension de :");
		lblNewLabel.setBounds(39, 67, 85, 16);
		labelSelectPension.add(lblNewLabel);
		
		List<String> pensionVille = pensionDAO.getAllPension();
		JComboBox<String> selectPension = new JComboBox<String>(pensionVille.toArray(new String[0]));
		selectPension.setBounds(136, 63, 146, 27);
		labelSelectPension.add(selectPension);
		
		JButton btnEditPen = new JButton("Modifier ma Pension");
		btnEditPen.setBounds(39, 102, 156, 29);
		labelSelectPension.add(btnEditPen);
		btnEditPen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
				Modele.Pension pension = pensionDAO.getPensionByVille(selectPension.getSelectedItem().toString());
				EditPension EditPension = new EditPension(pension);
				EditPension.setVisible(true);
			}
			
		});
		
		JButton btnEditPrix = new JButton("Modifier mes Prix");
		btnEditPrix.setBounds(243, 102, 156, 29);
		labelSelectPension.add(btnEditPrix);
		btnEditPrix.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrixDAO prixDAO = new PrixDAO(url, dbName, userName, password);
				PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
				
				Modele.Pension pension = pensionDAO.getPensionByVille(selectPension.getSelectedItem().toString());
				Modele.Prix prixHotel = prixDAO.getPrixByVilleAndLibelle(selectPension.getSelectedItem().toString(), "Hotel Canin");
				Modele.Prix prixCamping = prixDAO.getPrixByVilleAndLibelle(selectPension.getSelectedItem().toString(), "Camping Canin");
				Modele.Prix prixPension = prixDAO.getPrixByVilleAndLibelle(selectPension.getSelectedItem().toString(), "Pension Feline");
				EditPrix EditPrix = new EditPrix(prixHotel, prixCamping, prixPension, pension);
				EditPrix.setVisible(true);
			}
			
		});
		
		JButton btnCreatePension = new JButton("Cree une Pension");
		btnCreatePension.setBounds(39, 143, 156, 29);
		labelSelectPension.add(btnCreatePension);
		
		JButton btnCreatePrix = new JButton("Cree un Prix");
		btnCreatePrix.setBounds(243, 143, 156, 29);
		labelSelectPension.add(btnCreatePrix);
		
		JButton btnCreeCompte = new JButton("Cree un Compte");
		btnCreeCompte.setBounds(39, 184, 156, 29);
		labelSelectPension.add(btnCreeCompte);
		btnCreeCompte.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddCompte AddCompte = new AddCompte(utilisateur);
				AddCompte.setVisible(true);
			}
			
		});
		
		JButton btnClient = new JButton("Infos Client");
		btnClient.setBounds(242, 184, 157, 29);
		labelSelectPension.add(btnClient);
		btnClient.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Client Client = new Client();
				Client.setVisible(true);
			}
			
		});
		
		JButton btnDeco = new JButton("Deconnection");
		btnDeco.setBounds(282, 225, 117, 29);
		labelSelectPension.add(btnDeco);
		btnDeco.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
			
		});
	}
}

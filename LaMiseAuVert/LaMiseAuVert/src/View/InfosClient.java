package View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import Controller.DBConnect;
import DAO.ProprietaireDAO;
import Modele.Proprietaire;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class InfosClient extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldSClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InfosClient frame = new InfosClient();
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
	public InfosClient() {
		
		String url= DBConnect.getUrl();
		String dbName = DBConnect.getDbName();
		String userName = DBConnect.getUserName();
		String password = DBConnect.getPassword();
		
		ProprietaireDAO proprietaireDAO = new ProprietaireDAO(url, dbName, userName, password);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setVisible(true);
		setTitle("La Mise Au Vert - Rechercher un Client");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(170, 6, 112, 16);
		contentPane.add(labelName);
		
		JLabel labelClient = new JLabel("Rechercher un Client : (Nom ou Prenom)");
		labelClient.setBounds(10, 33, 272, 14);
		contentPane.add(labelClient);
		
		fieldSClient = new JTextField();
		fieldSClient.setBounds(10, 58, 272, 20);
		contentPane.add(fieldSClient);
		fieldSClient.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane (textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 89, 383, 127);
		contentPane.add(scrollPane);
		
		JButton btnSearch = new JButton("Rechercher");
		btnSearch.setBounds(292, 57, 101, 23);
		contentPane.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String search = fieldSClient.getText();
				List<Proprietaire> client = proprietaireDAO.getSearch(search);
				for (int i = 0; i < client.size(); i++) {
					String Nom = client.get(i).getNom();
					String Prenom = client.get(i).getPrenom();
					String Adresse = client.get(i).getAdresse();
					String Telephone = client.get(i).getTelephone();
					String Animal = client.get(i).getNomAnimal();
					String Espece = client.get(i).getLibelle();
					
					textArea.setText( textArea.getText() + Nom + "   " + Prenom + "\n" + Adresse + "\n" + Telephone 
							+ "\n" + Animal + "   " + Espece + "\n \n");
				}
			}
			
		});
		
		JButton btnAnnul = new JButton("Annuler");
		btnAnnul.setBounds(304, 227, 89, 23);
		contentPane.add(btnAnnul);
		btnAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
		
	}
}

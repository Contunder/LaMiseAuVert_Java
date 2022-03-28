package View;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.DBConnect;
import DAO.PensionDAO;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class EditPension extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fieldAdresse;
	private JTextField fieldResponsable;
	private JTextField fieldTel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPension frame = new EditPension(null);
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
	public EditPension(Modele.Pension pension) {
		
		String url= DBConnect.getUrl();
		String dbName = DBConnect.getDbName();
		String userName = DBConnect.getUserName();
		String password = DBConnect.getPassword();
		
		PensionDAO pensionDAO = new PensionDAO(url, dbName, userName, password);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 320);
		setVisible(true);
		setTitle("La Mise Au Vert - Modifier une Pension");
		java.net.URL iconURL = getClass().getResource("/images/icon.png");
		ImageIcon icon = new ImageIcon(iconURL);
		setIconImage(icon.getImage());
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(170, 6, 112, 16);
		contentPane.add(labelName);
		
		JLabel labelPen = new JLabel("Pension de " + pension.getVille());
		labelPen.setBounds(146, 34, 179, 16);
		contentPane.add(labelPen);
		
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setBounds(21, 63, 89, 16);
		contentPane.add(labelDescription);
		
		JLabel labelAdresse = new JLabel("Adresse :");
		labelAdresse.setBounds(21, 125, 89, 16);
		contentPane.add(labelAdresse);
		
		JLabel labelResponsable = new JLabel("Responsable :");
		labelResponsable.setBounds(21, 153, 89, 16);
		contentPane.add(labelResponsable);
		
		JLabel labelTel = new JLabel("Telephone :");
		labelTel.setBounds(21, 181, 89, 16);
		contentPane.add(labelTel);
		
		JLabel labelImage = new JLabel("Image :");
		labelImage.setBounds(21, 209, 89, 16);
		contentPane.add(labelImage);
		
		JTextArea textDescription = new JTextArea();
		textDescription.setText(pension.getDescription());
		textDescription.setBounds(122, 63, 298, 44);
		contentPane.add(textDescription);
		
		fieldAdresse = new JTextField();
		fieldAdresse.setText(pension.getAdresse());
		fieldAdresse.setBounds(122, 120, 298, 26);
		contentPane.add(fieldAdresse);
		fieldAdresse.setColumns(10);
		
		fieldResponsable = new JTextField();
		fieldResponsable.setText(pension.getResponsable());
		fieldResponsable.setBounds(122, 150, 298, 21);
		contentPane.add(fieldResponsable);
		fieldResponsable.setColumns(10);
		
		fieldTel = new JTextField();
		fieldTel.setText(pension.getTelephone());
		fieldTel.setBounds(122, 176, 298, 26);
		contentPane.add(fieldTel);
		fieldTel.setColumns(10);
		
		JButton btnFile = new JButton("Choisir une Image");
		btnFile.setBounds(122, 204, 160, 29);
		contentPane.add(btnFile);
		btnFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
			
		});
		
		JButton btnEdit = new JButton("Modifier");
		btnEdit.setBounds(327, 237, 117, 29);
		contentPane.add(btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String paramDescription = textDescription.getText();
				String paramAdresse = fieldAdresse.getText();
				String paramResponsable = fieldResponsable.getText();
				String paramTelephone = fieldTel.getText();
				String paramVille = pension.getVille();
				
				String retour = pensionDAO.editPensionByVille(paramDescription, paramAdresse, paramResponsable, paramTelephone, paramVille);
				labelPen.setText(retour);
			}
			
		});
		
		JButton btnAnnul = new JButton("Annuler");
		btnAnnul.setBounds(208, 237, 117, 29);
		contentPane.add(btnAnnul);
		btnAnnul.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
	}
}

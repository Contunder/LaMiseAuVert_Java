package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Helper extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Helper frame = new Helper();
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
	public Helper() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 535, 285);
		setVisible(true);
		setTitle("La Mise Au Vert - Aide");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHelp = new JLabel("Aide :");
		labelHelp.setFont(new Font("Tahoma", Font.BOLD, 13));
		labelHelp.setBounds(10, 11, 46, 14);
		contentPane.add(labelHelp);
		
		JLabel labelEditPension = new JLabel("Modifier une pension :");
		labelEditPension.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelEditPension.setBounds(10, 36, 128, 14);
		contentPane.add(labelEditPension);
		
		
		JLabel labelEditPrix = new JLabel("Modifier un prix :");
		labelEditPrix.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelEditPrix.setBounds(10, 74, 102, 14);
		contentPane.add(labelEditPrix);
		
		JLabel labelCreePension = new JLabel("Cree une Pension :");
		labelCreePension.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCreePension.setBounds(10, 99, 128, 14);
		contentPane.add(labelCreePension);
		
		JLabel labelCreePrix = new JLabel("Cree un Prix :");
		labelCreePrix.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCreePrix.setBounds(10, 124, 90, 14);
		contentPane.add(labelCreePrix);
		
		JLabel labelCreeCompte = new JLabel("Cree un Compte :");
		labelCreeCompte.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelCreeCompte.setBounds(10, 149, 102, 14);
		contentPane.add(labelCreeCompte);
		
		JLabel labelInfoClient = new JLabel("Info Client :");
		labelInfoClient.setFont(new Font("Tahoma", Font.BOLD, 11));
		labelInfoClient.setBounds(10, 174, 77, 14);
		contentPane.add(labelInfoClient);
		
		JLabel labelHelpEditPension = new JLabel("Tout les champs doivent être remplie sauf l'image");
		labelHelpEditPension.setVerticalAlignment(SwingConstants.TOP);
		labelHelpEditPension.setBounds(148, 36, 361, 14);
		contentPane.add(labelHelpEditPension);
		
		JLabel labelHelpEditPension2 = new JLabel("si vous ne souhaitez pas la changer.");
		labelHelpEditPension2.setVerticalAlignment(SwingConstants.TOP);
		labelHelpEditPension2.setBounds(148, 49, 361, 14);
		contentPane.add(labelHelpEditPension2);
		
		JLabel labelHelpEditPrix = new JLabel("Tout les champs doivent être remplie.");
		labelHelpEditPrix.setBounds(148, 74, 361, 14);
		contentPane.add(labelHelpEditPrix);
		
		JLabel labelHelpCreePension = new JLabel("Tout les champs doivent être remplie sauf l'image");
		labelHelpCreePension.setBounds(148, 99, 361, 14);
		contentPane.add(labelHelpCreePension);
		
		JLabel labelHelpCreePrix = new JLabel("Vous devez d'abord cree une pension puis la selectionner");
		labelHelpCreePrix.setBounds(148, 124, 361, 14);
		contentPane.add(labelHelpCreePrix);
		
		JLabel labelHelpCreeCompte = new JLabel("Vous pouver modifier les roles (USER pour un client)");
		labelHelpCreeCompte.setBounds(148, 149, 361, 14);
		contentPane.add(labelHelpCreeCompte);
		
		JLabel labelHelpInfoClient = new JLabel("Vous pouvez chercher un client avec son nom");
		labelHelpInfoClient.setBounds(148, 174, 361, 14);
		contentPane.add(labelHelpInfoClient);
		
		JLabel labelHelpInfoClient2 = new JLabel("ou son prenom");
		labelHelpInfoClient2.setBounds(148, 186, 361, 14);
		contentPane.add(labelHelpInfoClient2);
		
		JButton btnClose = new JButton("Fermer");
		btnClose.setBounds(392, 211, 89, 23);
		contentPane.add(btnClose);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
			
		});
	}

}

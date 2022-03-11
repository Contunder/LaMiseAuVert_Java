import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;

public class Connect extends JFrame {

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
		
		JButton btnNewButton = new JButton("Se Connecter");
		btnNewButton.setBounds(298, 125, 117, 29);
		contentPane.add(btnNewButton);
		
		JLabel labelError = new JLabel("Erreur");
		labelError.setForeground(Color.RED);
		labelError.setBounds(26, 34, 389, 16);
		contentPane.add(labelError);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(141, 79, 274, 26);
		contentPane.add(passwordField);
	}
}

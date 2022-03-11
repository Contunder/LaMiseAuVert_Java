import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Pension extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pension frame = new Pension();
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
	public Pension() {
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
		
		JButton btnEditPrix = new JButton("Modifier mes Prix");
		btnEditPrix.setBounds(243, 63, 156, 29);
		contentPane.add(btnEditPrix);
		
		JLabel labelPen = new JLabel("Pension de ");
		labelPen.setBounds(140, 35, 179, 16);
		contentPane.add(labelPen);
		
		JButton btnCreeCompte = new JButton("Crée un Compte");
		btnCreeCompte.setBounds(39, 104, 156, 29);
		contentPane.add(btnCreeCompte);
		
		JButton btnClient = new JButton("Infos Client");
		btnClient.setBounds(242, 104, 157, 29);
		contentPane.add(btnClient);
		
		JButton btnDeco = new JButton("Deconnection");
		btnDeco.setBounds(282, 206, 117, 29);
		contentPane.add(btnDeco);
	}

}

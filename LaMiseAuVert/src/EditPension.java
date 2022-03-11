import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditPension extends JFrame {

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
					EditPension frame = new EditPension();
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
	public EditPension() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelName = new JLabel("La Mise Au Vert");
		labelName.setBounds(170, 6, 112, 16);
		contentPane.add(labelName);
		
		JLabel labelPen = new JLabel("Pension de ");
		labelPen.setBounds(146, 34, 179, 16);
		contentPane.add(labelPen);
		
		JLabel labelDescription = new JLabel("Description :");
		labelDescription.setBounds(21, 63, 89, 16);
		contentPane.add(labelDescription);
		
		JLabel labelAdresse = new JLabel("Adresse :");
		labelAdresse.setBounds(21, 125, 89, 16);
		contentPane.add(labelAdresse);
		
		JLabel labelResponsable = new JLabel("Résponsable :");
		labelResponsable.setBounds(21, 153, 89, 16);
		contentPane.add(labelResponsable);
		
		JLabel labelTel = new JLabel("Télèphone :");
		labelTel.setBounds(21, 181, 89, 16);
		contentPane.add(labelTel);
		
		JLabel labelImage = new JLabel("Image :");
		labelImage.setBounds(21, 209, 89, 16);
		contentPane.add(labelImage);
		
		JTextArea textDescription = new JTextArea();
		textDescription.setBounds(122, 63, 298, 44);
		contentPane.add(textDescription);
		
		fieldAdresse = new JTextField();
		fieldAdresse.setBounds(122, 120, 298, 26);
		contentPane.add(fieldAdresse);
		fieldAdresse.setColumns(10);
		
		fieldResponsable = new JTextField();
		fieldResponsable.setBounds(122, 150, 298, 21);
		contentPane.add(fieldResponsable);
		fieldResponsable.setColumns(10);
		
		fieldTel = new JTextField();
		fieldTel.setBounds(122, 176, 298, 26);
		contentPane.add(fieldTel);
		fieldTel.setColumns(10);
	}
}

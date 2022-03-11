import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EditPrix extends JFrame {

	private JPanel contentPane;
	private JTextField fieldCCanin;
	private JTextField fieldPFeline;
	private JTextField fieldHCanin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditPrix frame = new EditPrix();
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
	public EditPrix() {
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
		labelPen.setBounds(144, 34, 179, 16);
		contentPane.add(labelPen);
		
		JLabel labelPFeline = new JLabel("Prix Pension Féline :");
		labelPFeline.setBounds(32, 73, 132, 16);
		contentPane.add(labelPFeline);
		
		JLabel labelCCanin = new JLabel("Prix Camping Canin :");
		labelCCanin.setBounds(32, 101, 132, 16);
		contentPane.add(labelCCanin);
		
		JLabel labelHCanin = new JLabel("Prix Hotel Canin :");
		labelHCanin.setBounds(32, 129, 132, 16);
		contentPane.add(labelHCanin);
		
		fieldPFeline = new JTextField();
		fieldPFeline.setBounds(272, 68, 132, 26);
		contentPane.add(fieldPFeline);
		fieldPFeline.setColumns(10);
		
		fieldCCanin = new JTextField();
		fieldCCanin.setBounds(272, 96, 132, 26);
		contentPane.add(fieldCCanin);
		fieldCCanin.setColumns(10);
		
		fieldHCanin = new JTextField();
		fieldHCanin.setBounds(272, 124, 132, 26);
		contentPane.add(fieldHCanin);
		fieldHCanin.setColumns(10);
		
		JButton btnEdit = new JButton("Modifier les Prix");
		btnEdit.setBounds(296, 181, 132, 29);
		contentPane.add(btnEdit);
		
		JButton btnAnnule = new JButton("Annuler");
		btnAnnule.setBounds(170, 181, 117, 29);
		contentPane.add(btnAnnule);
	}

}

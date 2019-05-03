import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeHomepage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeHomepage frame = new EmployeeHomepage();
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
	public EmployeeHomepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee HomePage");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel.setBounds(129, 25, 192, 33);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("View Customer Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CustomerViewDetails table=new CustomerViewDetails();
				table.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton.setBounds(90, 90, 250, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Search Customer Details");
		btnNewButton_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				SearchCustomerDetails search=new SearchCustomerDetails();
				search.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(90, 155, 250, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Update Customer Details");
		btnNewButton_2.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateCustomerDetails update=new UpdateCustomerDetails();
				update.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(90, 220, 250, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Delete Customer Details");
		btnNewButton_3.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DeleteCustomerDetails delete=new DeleteCustomerDetails();
				delete.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(90, 285, 250, 35);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Home");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage home=new HomePage();
				home.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_4.setBounds(54, 360, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton(" Back");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Emplogin login=new Emplogin();
				login.setVisible(true);
			}
		});
		btnNewButton_5.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnNewButton_5.setBounds(284, 360, 89, 23);
		contentPane.add(btnNewButton_5);

		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\VisualCodeWorkSpace\\photos in html\\beachback.jpg"));
		lblNewLabel_1.setBounds(0, 11, 1350, 729);
		contentPane.add(lblNewLabel_1);
	}
}

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class SearchEmployeeDetails extends JFrame 
{
	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					SearchEmployeeDetails frame = new SearchEmployeeDetails();
					frame.setVisible(true);
				} 
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SearchEmployeeDetails() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCustomerDetails = new JLabel("EMPLOYEE DETAILS");
		lblCustomerDetails.setForeground(Color.GRAY);
		lblCustomerDetails.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		lblCustomerDetails.setBounds(130, 20, 199, 28);
		contentPane.add(lblCustomerDetails);
		
		JLabel lblCustomerId = new JLabel("Employee ID");
		lblCustomerId.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblCustomerId.setBounds(73, 91, 104, 25);
		contentPane.add(lblCustomerId);
		
		textField = new JTextField();
		textField.setBounds(210, 94, 150, 25);
		contentPane.add(textField);
		textField.setColumns(10);
	
		JLabel lblCustomerName = new JLabel("Employee Name");
		lblCustomerName.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblCustomerName.setBounds(73, 140, 104, 25);
		contentPane.add(lblCustomerName);
		
		textField_1 = new JTextField();
		textField_1.setBounds(210, 143, 150, 25);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblAddress.setBounds(73, 198, 104, 25);
		contentPane.add(lblAddress);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(210, 194, 150, 60);
		contentPane.add(textArea);
		
		JLabel lblPhoneNo = new JLabel("Phone no");
		lblPhoneNo.setFont(new Font("SansSerif", Font.PLAIN, 13));
		lblPhoneNo.setBounds(73, 287, 104, 25);
		contentPane.add(lblPhoneNo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(210, 290, 150, 25);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String id=textField.getText();
					
					String str1="select * from addemployee where employee_id='"+id+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(str1);
					rs.next();
					
					String en=rs.getString(2);
					String ea=rs.getString(3);
					String ep=rs.getString(4);
					
					textField_1.setText(en);
					textArea.setText(ea);
					textField_2.setText(ep);
					
					JOptionPane.showMessageDialog(btnSearch, "Search Completed..");			
					
				}
				catch(Exception t)
				{
					System.out.println(t);
				}
			}
		});
		btnSearch.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnSearch.setBounds(172, 343, 100, 26);
		contentPane.add(btnSearch);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				textField.setText("");
				textField_1.setText("");
				textArea.setText("");
				textField_2.setText("");
			}
		});
		btnReset.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnReset.setBounds(172, 387, 100, 25);
		contentPane.add(btnReset);
		
		JButton btnHome = new JButton("Back");
		btnHome.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnHome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				AdminHomePage home=new AdminHomePage();
				home.setVisible(true);
			}
		});
		btnHome.setBounds(42, 387, 100, 25);
		contentPane.add(btnHome);
		
		JButton btnHome_1 = new JButton("Home");
		btnHome_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				HomePage home=new HomePage();
				home.setVisible(true);
			}
		});
		btnHome_1.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnHome_1.setBounds(295, 387, 100, 25);
		contentPane.add(btnHome_1);

		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\VisualCodeWorkSpace\\photos in html\\beachback.jpg"));
		lblNewLabel_1.setBounds(0, 11, 1350, 729);
		contentPane.add(lblNewLabel_1);
	}

}

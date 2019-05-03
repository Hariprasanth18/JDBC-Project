import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class EmployeeViewDetails extends JFrame
{
	private JPanel contentPane;
	private JTextField textField;
	JPanel panel=new JPanel();
	JTable table=new JTable();

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
					EmployeeViewDetails frame = new EmployeeViewDetails();
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
	public EmployeeViewDetails()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnViewdata = new JButton("ViewData");
		btnViewdata.setFont(new Font("SansSerif", Font.PLAIN, 13));
		btnViewdata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
			    String id=textField.getText();		
				String str="select * from addemployee where employee_id='"+id+"'";
				Class.forName("org.h2.Driver");
				Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
				Statement stm=conn.createStatement();
				ResultSet rs=stm.executeQuery(str);
				table.setModel(DbUtils.resultSetToTableModel(rs));
				}
				catch(Exception y)
				{
					
				}
				
			}
		});
		btnViewdata.setBounds(136, 55, 90, 25);
		contentPane.add(btnViewdata);
		//Important code for view tables
				JPanel panel = new JPanel();
				panel.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel.setBounds(26, 98, 398, 332);
				contentPane.add(panel);
				panel.setLayout(null);
				
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(10, 11, 381, 310);
				panel.add(scrollPane);
				
				table = new JTable();
				scrollPane.setViewportView(table);
				
				textField = new JTextField();
				textField.setBounds(26, 55, 100, 25);
				contentPane.add(textField);
				textField.setColumns(10);
				
				JButton btnViewall = new JButton("ViewAll");
				btnViewall.setFont(new Font("SansSerif", Font.PLAIN, 13));
				btnViewall.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						try
						{
					    String id=textField.getText();		
						String str="select * from addemployee";
						
						Class.forName("org.h2.Driver");
						Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
						Statement stm=conn.createStatement();
						
						ResultSet rs=stm.executeQuery(str);
						table.setModel(DbUtils.resultSetToTableModel(rs));
						}
						catch(Exception y)
						{
							System.out.println(y);
						}
					}
				});
				btnViewall.setBounds(246, 55, 90, 25);
				contentPane.add(btnViewall);
				
				JLabel lblEmployeeDetailsTable = new JLabel("EMPLOYEE DETAILS TABLE");
				lblEmployeeDetailsTable.setForeground(Color.GRAY);
				lblEmployeeDetailsTable.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
				lblEmployeeDetailsTable.setBounds(111, 11, 248, 30);
				contentPane.add(lblEmployeeDetailsTable);
				
				JButton btnReset = new JButton("Reset");
				btnReset.setFont(new Font("SansSerif", Font.PLAIN, 13));
				btnReset.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						textField.setText("");
					}
				});
				btnReset.setBounds(359, 40, 70, 20);
				contentPane.add(btnReset);
				
				JButton btnBack = new JButton("Back");
				btnBack.setFont(new Font("SansSerif", Font.PLAIN, 13));
				btnBack.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						AdminHomePage home=new AdminHomePage();
						home.setVisible(true);
					}
				});
				btnBack.setBounds(359, 70, 70, 20);
				contentPane.add(btnBack);
				
				
				
				JLabel lblNewLabel_1 = new JLabel("New label");
				lblNewLabel_1.setIcon(new ImageIcon("D:\\VisualCodeWorkSpace\\photos in html\\beachback.jpg"));
				lblNewLabel_1.setBounds(0, 11, 1350, 729);
				contentPane.add(lblNewLabel_1);
				
				
	}
}

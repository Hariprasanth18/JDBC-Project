import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddProductEx extends JFrame
{
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

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
					AddProductEx frame = new AddProductEx();
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
	public AddProductEx()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAddproduct = new JLabel("ADDPRODUCT");
		lblAddproduct.setBounds(178, 11, 97, 14);
		contentPane.add(lblAddproduct);
		
		JLabel Pid = new JLabel("Name");
		Pid.setBounds(42, 99, 53, 14);
		contentPane.add(Pid);
		
		textField = new JTextField();
		textField.setBounds(155, 96, 120, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblPprice = new JLabel("Price");
		lblPprice.setBounds(42, 135, 46, 14);
		contentPane.add(lblPprice);
		
		textField_1 = new JTextField();
		textField_1.setBounds(155, 132, 120, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPquantity = new JLabel("Quantity");
		lblPquantity.setBounds(42, 169, 63, 14);
		contentPane.add(lblPquantity);
		
		textField_2 = new JTextField();
		textField_2.setBounds(155, 166, 120, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnAddproduct = new JButton("ADDPRODUCT");
		btnAddproduct.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{	
					String ID=textField_3.getText();
					String name=textField.getText();
					String price=textField_1.getText();
					String quantity=textField_2.getText();
					
					String str="insert into AddproductEx values('"+ID+"','"+name+"','"+price+"','"+quantity+"')";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(str);
					
					JOptionPane.showMessageDialog(btnAddproduct, "Inserted..");
					
				}
				catch(Exception r)
				{
				System.out.println(r);	
				}
			}
		});
		btnAddproduct.setBounds(81, 227, 120, 23);
		contentPane.add(btnAddproduct);
		
		JButton btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}
		});
		btnReset.setBounds(324, 227, 89, 23);
		contentPane.add(btnReset);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(42, 57, 46, 14);
		contentPane.add(lblId);
		
		textField_3 = new JTextField();
		textField_3.setBounds(155, 54, 120, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnSubmit = new JButton("UPDATE");
		btnSubmit.addActionListener(new ActionListener()
		{
			private Component btnUpdate;

			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String ID=textField_3.getText();
					String pn=textField.getText();
					
					String str="update AddproductEx set name='"+pn+"' where ID='"+ID+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(str);
					
					JOptionPane.showMessageDialog(btnUpdate,"Updated..");
					
					
				}
				catch(Exception t)
				{
					System.out.println(t);
				}
			}
		});
		btnSubmit.setBounds(324, 109, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnView = new JButton("VIEW");
		btnView.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					String ID=textField_3.getText();
					
					String str1="select * from AddproductEx where ID='"+ID+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					ResultSet rs=stm.executeQuery(str1);
					rs.next();
					String pn=rs.getString(2);
					String pp=rs.getString(3);
					String pq=rs.getString(4);
					
					textField.setText(pn);
					textField_1.setText(pp);
					textField_2.setText(pq);
					
					JOptionPane.showMessageDialog(btnView, "Searching...");			
					
				}
				catch(Exception t)
				{
					System.out.println(t);
				}
			}
		});
		btnView.setBounds(324, 53, 89, 23);
		contentPane.add(btnView);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					String ID=textField_3.getText();

					String str4="delete from Addproductex where ID='"+ID+"'";
					
					Class.forName("org.h2.Driver");
					Connection conn=DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
					Statement stm=conn.createStatement();
					stm.executeUpdate(str4);
					
					JOptionPane.showMessageDialog(btnDelete,"Deleted..");
				}
				catch (Exception d)
				{
					System.out.println(d);
				}
			}
		});
		btnDelete.setBounds(324, 165, 89, 23);
		contentPane.add(btnDelete);
	}
}
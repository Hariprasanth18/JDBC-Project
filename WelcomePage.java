import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class WelcomePage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomePage frame = new WelcomePage();
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
	public WelcomePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Popeye's Beach Resort");
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 42));
		lblNewLabel.setBounds(436, 185, 543, 42);
		contentPane.add(lblNewLabel);
		
		JButton btnClickToContinue = new JButton("Welcome.");
		btnClickToContinue.setForeground(Color.BLACK);
		btnClickToContinue.setBackground(Color.LIGHT_GRAY);
		btnClickToContinue.setFont(new Font("Segoe Script", Font.BOLD | Font.ITALIC, 31));
		btnClickToContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					HomePage home=new HomePage();
					home.setVisible(true);
			}
		});
		btnClickToContinue.setBounds(583, 573, 214, 28);
		contentPane.add(btnClickToContinue);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\VisualCodeWorkSpace\\photos in html\\beachbackground.jpg"));
		lblNewLabel_1.setBounds(0, 0, 1350, 729);
		contentPane.add(lblNewLabel_1);
	}
}

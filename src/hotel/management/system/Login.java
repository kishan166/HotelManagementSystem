package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
	
	JLabel l1,l2;
	JTextField t1,t2;
	JButton b1,b2;
	
	Login(){
		
		this.setTitle("Login");
		
		l1=new JLabel("Username");
		l1.setBounds(40,20,100,30);
		add(l1);
		
		l2=new JLabel("Password");
		l2.setBounds(40,60,100,30);
		add(l2);
		
		t1 = new JTextField();
		t1.setBounds(150, 20, 150, 30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(150, 60, 150, 30);
		add(t2);
		
		b1 = new JButton("Login");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(40,150,120,30);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setForeground(Color.WHITE);
		b2.setBackground(Color.BLACK);
		b2.addActionListener(this);
		b2.setBounds(200,150,120,30);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.png"));
		Image i2=i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);    //change image size
		ImageIcon i3 = new ImageIcon(i2);    //change image to image icon
		JLabel l3 = new JLabel(i3);         //JLabel can only take imageicon
		l3.setBounds(350,10,200,200);
		add(l3);
		
		getContentPane().setBackground(Color.WHITE);		   //change bg color to while
		
		setLayout(null);
		setBounds(700,400,600,280);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Login();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			try {
				
			
				String username = t1.getText();
				String password = t2.getText();
				
				conn c = new conn();
				
				String str = "Select * from login where username = '"+username+"' and password = '"+password+"'";
				ResultSet rs = c.s.executeQuery(str);
				if (rs.next()) {
					new Dashboard().setVisible(true);
					this.setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "invalid username and password");
					this.setVisible(false);
				}
			}catch (SQLException e1) {
				e1.printStackTrace();
			}}
			else if (e.getSource() == b2) {
			System.exit(0);
		}
		
	}

}

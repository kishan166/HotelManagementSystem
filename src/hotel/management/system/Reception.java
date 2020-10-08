package hotel.management.system;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import com.sun.prism.Image;

public class Reception extends JFrame implements ActionListener {

	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	
	public Reception() {
		
		this.setTitle("Reception");
		
		b1 = new JButton("New Customer Form");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(40,50,200,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Rooms");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(40,90,200,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Department");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(40,130,200,30);
		b3.addActionListener(this);
		add(b3);
		
		b4 = new JButton("All Employee Info");
		b4.setBackground(Color.BLACK);
		b4.setForeground(Color.WHITE);
		b4.setBounds(40,170,200,30);
		b4.addActionListener(this);
		add(b4);
		
		b5 = new JButton("Customer Info");
		b5.setBackground(Color.BLACK);
		b5.setForeground(Color.WHITE);
		b5.setBounds(40,210,200,30);
		b5.addActionListener(this);
		add(b5);
		
		b6 = new JButton("Manager Info");
		b6.setBackground(Color.BLACK);
		b6.setForeground(Color.WHITE);
		b6.setBounds(40,250,200,30);
		b6.addActionListener(this);
		add(b6);
		
		b7 = new JButton("Check Out");
		b7.setBackground(Color.BLACK);
		b7.setForeground(Color.WHITE);
		b7.setBounds(40,290,200,30);
		b7.addActionListener(this);
		add(b7);
		
		b8 = new JButton("Update Check Status");
		b8.setBackground(Color.BLACK);
		b8.setForeground(Color.WHITE);
		b8.setBounds(40,330,200,30);
		b8.addActionListener(this);
		add(b8);
		
		b9 = new JButton("Update Room Status");
		b9.setBackground(Color.BLACK);
		b9.setForeground(Color.WHITE);
		b9.setBounds(40,370,200,30);
		b9.addActionListener(this);
		add(b9);
		
		b10 = new JButton("Pickup Service");
		b10.setBackground(Color.BLACK);
		b10.setForeground(Color.WHITE);
		b10.setBounds(40,410,200,30);
		b10.addActionListener(this);
		add(b10);
		
		b11 = new JButton("Search Room");
		b11.setBackground(Color.BLACK);
		b11.setForeground(Color.WHITE);
		b11.setBounds(40,450,200,30);
		b11.addActionListener(this);
		add(b11);
		
		b12 = new JButton("Logout");
		b12.setBackground(Color.BLACK);
		b12.setForeground(Color.WHITE);
		b12.setBounds(40,490,200,30);
		b12.addActionListener(this);
		add(b12);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fourth1.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 450, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(260,60,500,450);
		add(l1);
			
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(570,230,800,600);
		setLayout(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Reception().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			new AddCustomer().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b2) {
			new Rooms().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b3) {
			new Department().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b4) {
			new EmployeeInfo().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b5) {
			new CustomerInfo().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b6) {
			new ManagerInfo().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b7) {
			new CheckOut().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b8) {
			new UpdateCheck().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b9) {
			new UpdateRoom().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b10) {
			new Pickup().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b11) {
			new SearchRoom().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource() == b12) {
			setVisible(false);
		}
		
		
	}

}

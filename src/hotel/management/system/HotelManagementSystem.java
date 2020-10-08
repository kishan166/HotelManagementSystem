package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HotelManagementSystem extends JFrame implements ActionListener{
	
	public HotelManagementSystem() {
		
		this.setTitle("HOTEL MANAGEMENT SYSTEM");
		
		setBounds(300,200,1366,565);
		
		ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
		JLabel l1 = new JLabel(il);
		
		l1.setBounds(0,0,1366,565);
		add(l1);
		JLabel l2= new JLabel("Hotel Management System");
		l2.setBounds(100, 400, 1000, 100);   //(x,y,width,height)
		l2.setForeground(Color.ORANGE);
		l2.setFont(new Font("serif",Font.PLAIN,70));
		l1.add(l2);
		
		setLayout(null);
		setVisible(true);
		
		JButton b1 = new JButton("Next");  //set button
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(1160, 460, 150, 30);
		b1.addActionListener(this);
		l1.add(b1);
		
		while(true) {                       //flashing banner using threads
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}catch (Exception e) {
				
			}
			l2.setVisible(true);
			try{
				Thread.sleep(500);
			}catch (Exception e) {
				
			}
		}
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		new Login().setVisible(true);
		this.setVisible(false);
	}
	public static void main(String[] args) {
		new HotelManagementSystem();

	}

}

package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddRooms extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	
	public AddRooms() {
		
		this.setTitle("Add Rooms");
		
		l1 = new JLabel("ADD ROOMS");
		l1.setForeground(Color.BLUE);
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setBounds(150,30,200,40);
		add(l1);
		
		l2 = new JLabel("Room Number");
		l2.setFont(new Font("tahoma",Font.PLAIN,17));
		l2.setBounds(60,100,120,30);
		add(l2);
		t1 = new JTextField();
		t1.setBounds(200,100,160,30);
		add(t1);
		
		l3 = new JLabel("Avaibility");
		l3.setFont(new Font("tahoma",Font.PLAIN,17));
		l3.setBounds(60,150,120,30);
		add(l3);
		String avaibility[] = {"available","occupied"};
		c1 = new JComboBox(avaibility);
		c1.setBackground(Color.white);
		c1.setBounds(200,150,160,30);
		add(c1);
		
		l4 = new JLabel("Checked Status");
		l4.setFont(new Font("tahoma",Font.PLAIN,17));
		l4.setBounds(60,200,120,30);
		add(l4);
		String checkstat[] = {"cleaned","dirty"};
		c2 = new JComboBox(checkstat);
		c2.setBackground(Color.white);
		c2.setBounds(200,200,160,30);
		add(c2);
		
		l5 = new JLabel("Price");
		l5.setFont(new Font("tahoma",Font.PLAIN,17));
		l5.setBounds(60,250,120,30);
		add(l5);
		t2 = new JTextField();
		t2.setBounds(200,250,160,30);
		add(t2);
		
		l6 = new JLabel("Bed Type");
		l6.setFont(new Font("tahoma",Font.PLAIN,17));
		l6.setBounds(60,300,120,30);
		add(l6);
		String bedtype[] = {"single bed","double bed"};
		c3 = new JComboBox(bedtype);
		c3.setBackground(Color.white);
		c3.setBounds(200,300,160,30);
		add(c3);
		
		b1 = new JButton("Add room");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(85,350,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(225,350,120,30);
		add(b2);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/twelve.jpg"));
		Image i2 = i1.getImage().getScaledInstance(480, 230, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(380,100,480,230);
		add(l1);
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,900,450);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AddRooms().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			String roomno = t1.getText();
			String availabe = (String) c1.getSelectedItem();
			String status = (String) c2.getSelectedItem();
			String price = t2.getText();
			String type = (String) c3.getSelectedItem();
			
			conn c = new conn();
			try {
				
				String str="Insert into room values('"+roomno+"','"+availabe+"','"+status+"','"+price+"','"+type+"')";
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "NEW ROOM ADDED");
				this.setVisible(true);
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
		else if(e.getSource() == b2) {
			
			setVisible(false);
		}
		
	}

}

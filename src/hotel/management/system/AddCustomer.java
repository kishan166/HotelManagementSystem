package hotel.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddCustomer extends JFrame implements ActionListener {

	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JButton b1,b2;
	JComboBox c1;
	Choice c2;
	
	public AddCustomer() {

		this.setTitle("Add Employee");
		
		JLabel l1 = new JLabel("New Customer Form");
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		l1.setBounds(60,30,350,40);
		add(l1);
		
		JLabel id = new JLabel("ID");                               //ID
		id.setFont(new Font("Tahoma",Font.PLAIN,17));
		id.setBounds(60,80,120,30);
		add(id);
		String str[]= {"Passport","Driving-license","id"};
		c1 = new JComboBox(str);
		c1.setBackground(Color.WHITE);
		c1.setBounds(280, 80, 160, 30);
		add(c1);
		
		JLabel number = new JLabel("NUMBER");                         //number
		number.setFont(new Font("Tahoma",Font.PLAIN,17));
		number.setBounds(60,130,120,30);
		add(number);		
		t1 = new JTextField();
		t1.setBounds(280,130,160,30);
		add(t1);
		
		JLabel name = new JLabel("NAME");                             //name
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,180,120,30);
		add(name);
		t2 = new JTextField();
		t2.setBounds(280,180,160,30);
		add(t2);
		
		
		JLabel gender = new JLabel("GENDER");                        //gender
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		gender.setBounds(60,230,120,30);
		add(gender);		
		r1 = new JRadioButton("Male");
		r1.setBounds(280,230,70,30);
		r1.setBackground(Color.WHITE);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(380, 230, 70, 30);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		
		 
		JLabel country = new JLabel("COUNTRY");                         //country
		country.setFont(new Font("Tahoma",Font.PLAIN,17));
		country.setBounds(60,280,120,30);
		add(country);		
		t3 = new JTextField();
		t3.setBounds(280,280,160,30);
		add(t3);
		 
		JLabel allroomno = new JLabel("ALOCATED ROOM NUMBER");                          //allocated room number
		allroomno.setFont(new Font("Tahoma",Font.PLAIN,17));
		allroomno.setBounds(60,330,220,30);
		add(allroomno);	
		c2 = new Choice();
		try {
			
			conn c = new conn();
			String	sql = "Select * from room";
			ResultSet rs = c.s.executeQuery(sql);
			while (rs.next()) {
				String allo = rs.getString("available");
				if (allo.equals("available")) {
					c2.add(rs.getString("room_number"));
				} else {
					continue;
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		c2.setBounds(280,330,160,30);
		add(c2);
		
		
		JLabel checkin = new JLabel("CHECKED IN");                          //checked in
		checkin.setFont(new Font("Tahoma",Font.PLAIN,17));
		checkin.setBounds(60,380,120,30);
		add(checkin);		
		t4 = new JTextField();
		t4.setBounds(280,380,160,30);
		add(t4);
		
		 
		JLabel email = new JLabel("DEPOSIT");                          //deposit
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		email.setBounds(60,430,120,30);
		add(email);		
		t5 = new JTextField();
		t5.setBounds(280,430,160,30);
		add(t5);
		
		b1=new JButton("Save");
		b1.setBounds(105, 480, 120, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(245,480,120,30);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/fifth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l11 = new JLabel(i3);
		l11.setBounds(460, 80, 400, 400);
		add(l11);
		
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,900,600);
		setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		new AddCustomer().setVisible(true);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == b1) {
			
			String id = (String) c1.getSelectedItem();
			String number = t1.getText();	
			String name = t2.getText();	
			String gender = null;
				if(r1.isSelected()) {
					gender = "male";
				}
				else if(r2.isSelected()){
					gender = "female";
				}
			String country = t3.getText();	
			String allroomno = c2.getSelectedItem();
			String checkin = t4.getText();	
			String deposit = t5.getText();	
;
			conn c = new conn();
			String sql="insert into customer values('"+id+"','"+number+"','"+name+"','"+gender+"','"+country+"','"+allroomno+"','"+checkin+"','"+deposit+"')";
			String sql2 = "update room set available = 'occupied' where room_number ='"+allroomno+"'";
			try {
				c.s.executeUpdate(sql);
				c.s.executeUpdate(sql2);
				JOptionPane.showMessageDialog(null, "NEW CUSTOMER ADDED");
				this.setVisible(true);
			} catch (Exception e2) {
				System.out.println(e);
			}
		}
		else if(e.getSource() == b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}

}

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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class AddDriver extends JFrame implements ActionListener {
	
	JLabel l1,l2,l3,l4,l5,l6,l7,l8;
	JTextField t1,t2,t3,t4,t5;
	JRadioButton r1,r2;
	JComboBox c1;
	JButton b1,b2;
	
	public AddDriver() {
		
		this.setTitle("Add Driver");
		
		l1 = new JLabel("ADD DRIVER");
		l1.setBounds(150,30,200,40);
		l1.setFont(new Font("Tahoma",Font.PLAIN,30));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		l2 = new JLabel("Name");                             //name
		l2.setBounds(60,100,120,30);
		l2.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l2);
		t1 = new JTextField();
		t1.setBounds(200,100,160,30);
		add(t1);
		
		l3 = new JLabel("Age");                               //age
		l3.setBounds(60,150,120,30);
		l3.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l3);
		t2 = new JTextField();
		t2.setBounds(200,150,160,30);
		add(t2);
		
		l4 = new JLabel("Gender");                           //gender
		l4.setBounds(60,200,120,30);
		l4.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l4);
		r1 = new JRadioButton("Male");
		r1.setBounds(200,200,70,30);
		r1.setBackground(Color.WHITE);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(300, 200, 70, 30);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		l5 = new JLabel("Car Company");                        //car company
		l5.setBounds(60,250,120,30);
		l5.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l5);
		t3 = new JTextField();
		t3.setBounds(200,250,160,30);
		add(t3);
		
		l6 = new JLabel("Car Model");                           //car model
		l6.setBounds(60,300,120,30);
		l6.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l6);
		t4 = new JTextField();
		t4.setBounds(200,300,160,30);
		add(t4);
		
		l7 = new JLabel("Available");                           //available
		l7.setBounds(60,350,120,30);
		l7.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l7);
		String a[]= {"Available","Not Available"};
		c1 = new JComboBox(a);
		c1.setBackground(Color.WHITE);
		c1.setBounds(200,350,160,30);
		add(c1);
		
		l8 = new JLabel("Location");                             //location
		l8.setBounds(60,400,120,30);
		l8.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(l8);
		t5 = new JTextField();
		t5.setBounds(200,400,160,30);
		add(t5);
		
		b1 = new JButton("Add Driver");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(85,450,120,30);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(225,450,120,30);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
		Image i2 = i1.getImage().getScaledInstance(480, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel il = new JLabel(i3);
		il.setBounds(380,110,480,300);
		add(il);		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(520,230,900,550);
		setLayout(null);
		setVisible(true);
		
	}
	public static void main(String[] args) {
		
		new AddDriver().setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			
			String name = t1.getText();
			String age = t2.getText();
			String gender = null;
			if(r1.isSelected()) {
				gender = "male";
			}
			else if(r2.isSelected()){
				gender = "female";
			}
			String carcomp = t3.getText();
			String carbrand = t4.getText();
			String available = (String) c1.getSelectedItem();
			String location = t5.getText();
			
			conn c = new conn();
			try {
				String sql = "Insert into driver values('"+name+"','"+age+"','"+gender+"','"+carcomp+"','"+carbrand+"','"+available+"','"+location+"')";
				c.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "NEW DRIVER ADDED");
				this.setVisible(false);
				
			} catch (Exception e2) {
				System.out.println(e);
			}
			
		}
		else if(e.getSource() == b2) {
			setVisible(false);
		}
		
	}

}

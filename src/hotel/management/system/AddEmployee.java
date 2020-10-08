package hotel.management.system;

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

public class AddEmployee extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	JButton b1,b2;
	JComboBox c1;
	public AddEmployee() {
		
		this.setTitle("Add Employee");
		
		JLabel name = new JLabel("NAME");                             //name
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,30,120,30);
		add(name);
		t1 = new JTextField();
		t1.setBounds(200,30,160,30);
		add(t1);
		
		JLabel age = new JLabel("AGE");                              //age
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		age.setBounds(60,80,120,30);
		add(age);		
		t2 = new JTextField();
		t2.setBounds(200,80,160,30);
		add(t2);
		
		JLabel gender = new JLabel("GENDER");                        //gender
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		gender.setBounds(60,130,120,30);
		add(gender);		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,130,70,30);
		r1.setBackground(Color.WHITE);
		add(r1);
		r2 = new JRadioButton("Female");
		r2.setBounds(300, 130, 70, 30);
		r2.setBackground(Color.WHITE);
		add(r2);
		
		
		JLabel job = new JLabel("JOB");                               //job
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		job.setBounds(60,180,120,30);
		add(job);
		String str[]= {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitresses","Manager","Accountant"};
		c1 = new JComboBox(str);
		c1.setBackground(Color.WHITE);
		c1.setBounds(200, 180, 160, 30);
		add(c1);
		
		 
		JLabel salary = new JLabel("SALARY");                         //salary
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		salary.setBounds(60,230,120,30);
		add(salary);		
		t3 = new JTextField();
		t3.setBounds(200,230,160,30);
		add(t3);
		 
		JLabel phone = new JLabel("PHONE");                          //phone
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		phone.setBounds(60,280,120,30);
		add(phone);		
		t4 = new JTextField();
		t4.setBounds(200,280,160,30);
		add(t4);
		
		JLabel id = new JLabel("ID");                          //aadhar
		id.setFont(new Font("Tahoma",Font.PLAIN,17));
		id.setBounds(60,330,120,30);
		add(id);		
		t5 = new JTextField();
		t5.setBounds(200,330,160,30);
		add(t5);
		 
		JLabel email = new JLabel("E-MAIL");                          //email
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		email.setBounds(60,380,120,30);
		add(email);		
		t6 = new JTextField();
		t6.setBounds(200,380,160,30);
		add(t6);
		
		b1=new JButton("Save");
		b1.setBounds(85, 430, 120, 30);
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(225,430,120,30);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
		Image i2 = i1.getImage().getScaledInstance(550, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(350, 150, 550, 300);
		add(l1);
		
		JLabel l2 = new JLabel("Add Employee Details");
		l2.setFont(new Font("Tahoma",Font.PLAIN,45));
		l2.setForeground(Color.BLUE);
		l2.setBounds(400,70,450,60);
		add(l2);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(520,230,900,550);
		setVisible(true);
	}
	public static void main(String[]args) {
		new AddEmployee().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1) {
			
			String name = t1.getText();	
			String age = t2.getText();	
			String salary = t3.getText();	
			String phone = t4.getText();	
			String id = t5.getText();	
			String email = t6.getText();
			
			String gender = null;
			if(r1.isSelected()) {
				gender = "male";
			}
			else if(r2.isSelected()){
				gender = "female";
			}
			
			String job = (String) c1.getSelectedItem();
			
			conn c = new conn();
			String sql="Insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+id+"','"+email+"')";
			try {
				c.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "NEW EMPLOYEE ADDED");
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

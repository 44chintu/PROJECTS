package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BalanceEnquiry extends JFrame implements ActionListener{
	String pinNumber;
	JButton back;
	JLabel text;
	BalanceEnquiry(String pinNumber){
		this.pinNumber = pinNumber;
		
		setLayout(null);
		ImageIcon i1= new ImageIcon(getClass().getResource("./atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		text = new JLabel("Balance : ");
		text.setFont(new Font("Raleway",Font.BOLD,20));
		text.setForeground(Color.WHITE);
		text.setBounds(240,350,500,35);
		image.add(text);
		
		back = new JButton("Back");
		back.setBounds(385,520,120,30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance=0;
		try {
			ResultSet rs = c.stm.executeQuery("select * from bank where pinNumber = '"+pinNumber+"'");
			while(rs.next()) {
				if(rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				}else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		JLabel result = new JLabel(""+balance);
		result.setForeground(Color.white);
		result.setBounds(420,350,120,30);
		image.add(result);
		
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(false);
		setResizable(false);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource() == back) {
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}
	}
	public static void main(String args[]) {
		new BalanceEnquiry("");
	}
}

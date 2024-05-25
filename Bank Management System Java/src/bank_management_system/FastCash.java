package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;



public class FastCash extends JFrame implements ActionListener{
	
	JButton deposit,withdrawal1,miniStatement,fastCash,pinChange,balanceEnquiry,exit;
	String pinNumber;
	FastCash(String pinNumber){
		this.pinNumber = pinNumber;
		ImageIcon i1 = new ImageIcon(getClass().getResource("./atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Select Withdrawl Amount ");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Rs 100");
		deposit.setBounds(155,390,120,28);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawal1 = new JButton("Rs 500");
		withdrawal1.setBounds(155,425,120,28);
		withdrawal1.addActionListener(this);
		image.add(withdrawal1);
		
		fastCash = new JButton("Rs 1000");
		fastCash.setBounds(155,460,120,28);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		miniStatement = new JButton("Rs 2000");
		miniStatement.setBounds(385,390,120,28);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("Rs 5000");
		pinChange.setBounds(385,425,120,28);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balanceEnquiry = new JButton("Rs 10000");
		balanceEnquiry.setBounds(385,460,120,28);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Back");
		exit.setBounds(280,485,100,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==exit) {
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}
		else {
			String amount = ((JButton)ae.getSource()).getText().substring(3); 
			Conn c = new Conn();
			try {
				ResultSet rs = c.stm.executeQuery("select * from bank where PinNumber = '"+pinNumber+"'");
				int balance=0;
				while(rs.next()) {
					if(rs.getString("Type").equals("Deposit")) {
						balance += Integer.parseInt(rs.getString("amount"));
					}else {
						balance -= Integer.parseInt(rs.getString("amount"));
					}
				}
				if(balance< Integer.parseInt(amount)) {
					JOptionPane.showMessageDialog(null,"Insufficent Balance");
					return;
				}
				
				Date date = new Date();
				String query = "insert into bank values('"+pinNumber+"','"+date+"','Withdrawl', '"+amount+"')";
				c.stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Rs"+amount+"Debited Succesfully");
				
				setVisible(false);
				new Transaction(pinNumber).setVisible(true);
			} catch(Exception e) {
				System.out.println(e);
			}
		} 
		
		
	}
	public static void main(String args[]) {
		new FastCash("");
	}
}

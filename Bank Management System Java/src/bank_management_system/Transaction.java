package bank_management_system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Transaction extends JFrame implements ActionListener{
	
	JButton deposit,withdrawal,miniStatement,fastCash,pinChange,balanceEnquiry,exit;
	String pinNumber;
	Transaction(String pinNumber){
		this.pinNumber = pinNumber;
		ImageIcon i1 = new ImageIcon(getClass().getResource("./atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Please Select Your Transaction");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(155,390,120,28);
		deposit.addActionListener(this);
		image.add(deposit);
		
		withdrawal = new JButton("withdraw");
		withdrawal.setBounds(155,425,120,28);
		withdrawal.addActionListener(this);
		image.add(withdrawal);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(155,460,120,28);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(385,390,120,28);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("Pin Change");
		pinChange.setBounds(385,425,120,28);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balanceEnquiry = new JButton("Balance Enquiry");
		balanceEnquiry.setBounds(385,460,120,28);
		balanceEnquiry.addActionListener(this);
		image.add(balanceEnquiry);
		
		exit = new JButton("Exit");
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
			new Login();
			setVisible(false);
		}
		else if(ae.getSource() == deposit) {
			setVisible(false);
			new Deposit(pinNumber).setVisible(true);	
		}
		else if(ae.getSource() == withdrawal) {
			setVisible(false);
			new Withdraw(pinNumber).setVisible(true);	
		}
		else if(ae.getSource() == fastCash) {
			setVisible(false);
			new FastCash(pinNumber).setVisible(true);
		}
		else if(ae.getSource() == pinChange) {
			setVisible(false);
			new PinChange(pinNumber).setVisible(true);
		}
		else if(ae.getSource() == balanceEnquiry) {
			setVisible(false);
			new BalanceEnquiry(pinNumber).setVisible(true);
		}
		else if(ae.getSource() == miniStatement) {
			new MiniStatement(pinNumber).setVisible(true);
		}
	}
	public static void main(String args[]) {
		new Transaction("");
	}
}

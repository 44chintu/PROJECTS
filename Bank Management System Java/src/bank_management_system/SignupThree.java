package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

  public class SignupThree extends JFrame implements ActionListener{
	  
	  
	  JRadioButton r1,r2,r3,r4;
	  JCheckBox c1,c2,c3,c4,c5,c6,c7;
	  JButton submit,cancel;
	  String formno;
  
     SignupThree(String formno){
    	 this.formno = formno;
    	 setLayout(null);
    	 
    	 JLabel l1 = new JLabel("Page 3 : Account Details");
    	 l1.setFont(new Font("Raleway",Font.BOLD,22));
    	 l1.setBounds(200,40,400,40);
    	 add(l1);
    	 
    	 JLabel type = new JLabel("Account type");
    	 type.setFont(new Font("Raleway",Font.BOLD,22));
    	 type.setBounds(100,140,200,30);
    	 add(type);
    	 
    	 r1= new JRadioButton("saving account");
    	 r1.setFont(new Font("Raleway",Font.BOLD,16));
    	 r1.setBackground(Color.WHITE);
    	 r1.setBounds(100,180,250,20);
    	 add(r1);
    	 
    	 r2= new JRadioButton("Fixed Deposit account");
    	 r2.setFont(new Font("Raleway",Font.BOLD,16));
    	 r2.setBackground(Color.WHITE);
    	 r2.setBounds(350,180,150,20);
    	 add(r2);
    	 
    	 r3= new JRadioButton("Current account");
    	 r3.setFont(new Font("Raleway",Font.BOLD,16));
    	 r3.setBackground(Color.WHITE);
    	 r3.setBounds(100,220,250,20);
    	 add(r3);
    	 
    	 r4= new JRadioButton("Recuring DEposit account");
    	 r4.setFont(new Font("Raleway",Font.BOLD,16));
    	 r4.setBackground(Color.WHITE);
    	 r4.setBounds(350,220,150,20);
    	 add(r4);
    	 
    	 ButtonGroup groupaccount= new ButtonGroup();
    	 groupaccount.add(r1);
    	 groupaccount.add(r2);
    	 groupaccount.add(r3);
    	 groupaccount.add(r4);
    	 
    	 JLabel card = new JLabel("Card Number");
    	 card.setFont(new Font("Raleway",Font.BOLD,22));
    	 card.setBounds(100,300,200,30);
    	 add(card);
    	 
    	 JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
    	 number.setFont(new Font("Raleway",Font.BOLD,22));
    	 number.setBounds(330,300,300,30);
    	 add(number);
    	 
    	 JLabel carddetail = new JLabel("YOUR 16 DIGIT CARD NUMBER ");
    	 carddetail.setFont(new Font("Raleway",Font.BOLD,12));
    	 carddetail.setBounds(100,330,300,20);
    	 add(carddetail);
    	 
    	 JLabel pin = new JLabel("PIN");
    	 pin.setFont(new Font("Raleway",Font.BOLD,22));
    	 pin.setBounds(100,370,200,30);
    	 add(pin);
    	 
    	 JLabel pinnumber = new JLabel("XXXX");
    	 pinnumber.setFont(new Font("Raleway",Font.BOLD,22));
    	 pinnumber.setBounds(330,370,300,30);
    	 add(pinnumber);
    	 
    	 JLabel pinddetail = new JLabel("YOUR 4 DIGIT PIN NUMBER ");
    	 pinddetail.setFont(new Font("Raleway",Font.BOLD,12));
    	 pinddetail.setBounds(100,400,300,20);
    	 add(pinddetail);
    	 
    	 JLabel services = new JLabel("SERVICES REQUIRED ");
    	 services.setFont(new Font("Raleway",Font.BOLD,22));
    	 services.setBounds(100,450,400,30);
    	 add(services);
    	 
    	 c1= new JCheckBox("ATM CARD");
    	 c1.setBackground(Color.white);
    	 c1.setBounds(100,500,200,30);
    	 c1.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c1);
    	 
    	 c2= new JCheckBox("INTERNET BANKING");
    	 c2.setBackground(Color.white);
    	 c2.setBounds(350,500,200,30);
    	 c2.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c2);
    	 
    	 c3= new JCheckBox("MOBILE BANKING");
    	 c3.setBackground(Color.white);
    	 c3.setBounds(100,550,200,30);
    	 c3.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c3);
    	 
    	 c4= new JCheckBox("EMAIL  && SMS ALERTS");
    	 c4.setBackground(Color.white);
    	 c4.setBounds(350,500,200,30);
    	 c4.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c4);
    	 
    	 
    	 c5= new JCheckBox("CHECK BOOK");
    	 c5.setBackground(Color.white);
    	 c5.setBounds(100,600,200,30);
    	 c5.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c5);
    	 
    	 c6= new JCheckBox("E-STATEMENT");
    	 c6.setBackground(Color.white);
    	 c6.setBounds(350,600,200,30);
    	 c6.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c6);
    	 
    	 c7= new JCheckBox("I Here By Declare That Above Details are Correct to the best my knowledge");
    	 c7.setBackground(Color.white);
    	 c7.setBounds(100,680,600,30);
    	 c7.setFont(new Font("Raleway",Font.BOLD,16));
    	 add(c7);
    	 
    	 submit = new JButton("Submit");
    	 submit.setBackground(Color.black);
    	 submit.setForeground(Color.white);
    	 submit.setFont(new Font("Raleway",Font.BOLD,14));
    	 submit.setBounds(250,720,100,30);
    	 submit.addActionListener(this);
    	 add(submit);
    	 
    	 cancel = new JButton("Cancel");
    	 cancel.setBackground(Color.black);
    	 cancel.setForeground(Color.white);
    	 cancel.setFont(new Font("Raleway",Font.BOLD,14));
    	 cancel.setBounds(420,720,100,30);
    	 cancel.addActionListener(this);
    	 add(cancel);
    	 
    	 
    	 getContentPane().setBackground(Color.WHITE);
    	 
    	 setSize(850,820);
    	 setLocation(350,0);
    	 setResizable(false);
    	 setVisible(true);
     }

         public void actionPerformed(ActionEvent ae) {
        	 
        	 if(ae.getSource()  == submit) {
        		String accountType = null;
        		
        		if(r1.isSelected()) {
        			accountType = "Saving Account";
        		}
        		else if(r2.isSelected()) {
        			accountType = "Fixed Deposit Account";
        		}
        		else if(r3.isSelected()){
        			accountType = "Current Account";
        		}
        		else if(r4.isSelected()) {
        			accountType ="Recurring Deposit Account";
        		}
        		
        		Random random = new Random();
        		String cardnumber = "" + Math.abs((random.nextLong() % 90000000L)+ 5040936000000000L);
        		String pinnumber = "" + Math.abs((random.nextLong() % 9000L)+ 100L);
        		String facility = "" ;
        		String accepted = "";
        		if(c1.isSelected()) {
        			facility = facility + "ATM CARD";
        		}
        		else if(c2.isSelected()) {
        			facility = facility + "Internet Banking";
        		}
        		else if(c3.isSelected()) {
        			facility = facility + "Mobile Banking";
        		}
        		else if(c4.isSelected()) {
        			facility = facility + "Email & SMS Alerts";
        		}
        		else if(c5.isSelected()) {
        			facility = facility + "Cheque Book";
        		}
        		else if(c6.isSelected()) {
        			facility = facility + "E-Statement";
        		}
        		else if(c7.isSelected()) {
        			accepted = accepted + "Yes";
        		}
        		
        		try {
        			if(accountType.equals("")) {
        				JOptionPane.showMessageDialog(null, "Account Type is Required");
        			}
        			else if(facility.equals("")) {
        				JOptionPane.showMessageDialog(null, "Service Type is Required");
        			}
        			
        			else {
        				Conn c = new Conn();
        				String query1 = "insert into signupThree values('"+formno+"', '"+accountType+"', '"+cardnumber+"', '"+pinnumber+"', '"+facility+"')";
        				String query2 = "insert into login values('"+formno+"','"+cardnumber+"', '"+pinnumber+"')";
        				
        				c.stm.executeUpdate(query1);
        				c.stm.executeUpdate(query2);
        				
        				JOptionPane.showMessageDialog(null, "Card Number: "+cardnumber+"\n"+"Pin: "+pinnumber);
        				JOptionPane.showMessageDialog(null, "Please Make Your First Deposit");
        				setVisible(false);
        				new Deposit(pinnumber).setVisible(true);
        			}
        		}
        		catch(Exception e) {
        			System.out.println(e);
        		}
        		
        	 }else if(ae.getSource() == cancel) {
        		 setVisible(false);
        		 new Login().setVisible(true);
        	 }
         }
         public static void main(String[] args) {
        	 new SignupThree("");
         }
		
}

package bank_management_system;

import java.awt.Image;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.*;
import java.awt.*;
public class Login extends JFrame implements ActionListener{

       JButton login,signup,clear;
       JTextField cardTextField;
       JPasswordField pinTextField;
       static int i=1;

    Login(){
        setTitle("Automated Teller Machine");
        setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);

        JLabel pin = new JLabel("PIN :");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(200,220,250,30);
        add(pin);

        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);

        login =new JButton("SIGN IN");
        login.setBounds(430,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear =new JButton("CLEAR");
        clear.setBounds(300,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        signup =new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);


        getContentPane().setBackground(Color.white);

        setSize(800,480);
        setResizable(false);
        setVisible(true);
        setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){ 
    	
        if(ae.getSource()== clear)
        {            
        	cardTextField.setText("");
            pinTextField.setText("");
        } 
        
        
        else if(ae.getSource()==login){
            Conn cn = new Conn();
            String cardNumber = cardTextField.getText();
            String pinNumber = pinTextField.getText();
            String query = "select * from login where CardNumber = '"+cardNumber+"' and PinNumber = '"+pinNumber+"'";
            
            try {
            	ResultSet rs = cn.stm.executeQuery(query);
            	if(rs.next()) {
            		setVisible(false);
            		new Transaction(pinNumber).setVisible(true);
            	}
            	else {
            		i++;
            		JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Try Again..");
            		if(i==5) {
            			JOptionPane.showMessageDialog(null, "Close The Application..");
            			setVisible(false);
            		}
            		else if(i>3) {
            			setVisible(false);
            			new waitPage().frame.setVisible(true);
            		}
            	}
            }
            catch(Exception e) {
            	System.out.println(e);
            }
            }
        
        else if(ae.getSource()==signup){
        	setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
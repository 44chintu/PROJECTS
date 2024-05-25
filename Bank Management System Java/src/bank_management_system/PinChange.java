package bank_management_system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PinChange extends JFrame implements ActionListener{
	
	JButton change,back;
	JPasswordField pin,repin;
	String pinNumber;
	PinChange(String pinNumber){
		this.pinNumber = pinNumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(getClass().getResource("./atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Change Your Pin");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System",Font.BOLD,16));
		text.setBounds(250,280,500,35);
		image.add(text);
		
		JLabel pinText = new JLabel("New Pin");
		pinText.setForeground(Color.WHITE);
		pinText.setFont(new Font("System",Font.BOLD,16));
		pinText.setBounds(165,320,180,25);
		image.add(pinText);
		
		pin = new JPasswordField();
		pin.setFont(new Font("Raleway",Font.BOLD,25));
		pin.setBounds(330,320,180,25);
		image.add(pin);
		
		JLabel reEnterPin = new JLabel("Re-Enter New Pin");
		reEnterPin.setForeground(Color.WHITE);
		reEnterPin.setFont(new Font("System",Font.BOLD,16));
		reEnterPin.setBounds(165,360,180,25);
		image.add(reEnterPin);
		
		repin = new JPasswordField();
		repin.setFont(new Font("Raleway",Font.BOLD,25));
		repin.setBounds(330,360,180,25);
		image.add(repin);
		
		change = new JButton("CHANGE");
		change.setBounds(355,485,150,30);
		change.addActionListener(this);
		image.add(change);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setResizable(false);
		setVisible(true);
		
	}

	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == change) {
			try {
				String npin = pin.getText();
				String rpin = repin.getText();
				
				if(!(npin.equals(rpin))){
					JOptionPane.showMessageDialog(null, "Entered PIN does not match");
					return;
				}
				if(npin.equals("") || rpin.equals("")) {
					JOptionPane.showMessageDialog(null, "Please Enter New Pin and Re-Enter New Pin");
					return;
				}
				if(npin.equals(rpin)) {
					try {
						Conn c = new Conn();
						String query1 = "update bank set PinNumber = '"+rpin+"' where PinNumber = '"+pinNumber+"'";
						String query2 = "update login set PinNumber = '"+rpin+"' where PinNUmber = '"+pinNumber+"'";
						String query3 = "update signupThree set PinNumber = '"+rpin+"' where PinNUmber = '"+pinNumber+"'";
						
						c.stm.executeUpdate(query1);
						c.stm.executeUpdate(query2);
						c.stm.executeUpdate(query3);
						
						JOptionPane.showMessageDialog(null, "Pin Changed Successfully");
						
						setVisible(false);
						new Transaction(pinNumber).setVisible(true);
						
					}
					catch(Exception e) {
						System.out.println(e);
					}
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource() == back){
			setVisible(false);
			new Transaction(pinNumber).setVisible(true);
		}
	}

	public static void main(String args[]) {
		new PinChange("");
		
	}
}



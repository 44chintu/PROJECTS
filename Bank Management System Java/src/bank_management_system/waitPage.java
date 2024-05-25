package bank_management_system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class waitPage extends Thread{
	JFrame frame = new JFrame();
	waitPage(){
		
		frame.setTitle("Automated Teller Machine");
        frame.setLayout(null);
        ImageIcon i1 = new ImageIcon(getClass().getResource("logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(20,10,100,100);
        frame.add(label);

        JLabel text = new JLabel("Invalid Credentials.. Please wait");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(120,40,800,40);
        frame.add(text);
        
        JLabel time = new JLabel("");
        time.setFont(new Font("Osward",Font.BOLD,38));
        time.setBounds(160,180,800,60);
        frame.add(time);
        
        frame.getContentPane().setBackground(Color.white);

        frame.setSize(800,480);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocation(350, 200);
        
        new Thread(() -> {
            for (int i = 29; i >= 0; i--) {
                try {
                    Thread.sleep(1000);
                    time.setText("Wait for "+i+"Sec to try again");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            frame.setVisible(false);
            new Login();
        }).start();
    }
	public static void main(String args[]) {
		new waitPage();
		
	}
}

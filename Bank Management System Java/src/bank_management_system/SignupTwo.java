package bank_management_system;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupTwo extends JFrame implements ActionListener{

		long random;
		JTextField pan,aadhaarTextField;
		JButton next;
		JRadioButton scyes,scno,eayes,eano;
		JDateChooser dateChooser;
		JLabel religion,catagory;
		JComboBox religioncb,catagorycb,incomecb,education,occupationcb;
		String formno;
	    SignupTwo(String formno){
	    	this.formno = formno;
	        setLayout(null);

	        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE2");

	        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
	        additionalDetails.setFont(new Font("Raleway",Font.BOLD,22));
	        additionalDetails.setBounds(290,80,400,30);
	        add(additionalDetails);

	        religion = new JLabel("Religion :" );
	        religion.setFont(new Font("Raleway",Font.BOLD,20));
	        religion.setBounds(100,140,100,30);
	        add(religion);
	        
	        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
	        religioncb = new JComboBox(valReligion);
	        religioncb.setBounds(300,140,400,30);
	        religioncb.setBackground(Color.WHITE);
	        add(religioncb);
            
	        catagory= new JLabel(" Catagory" );
	        catagory.setFont(new Font("Raleway",Font.BOLD,20));
	        catagory.setBounds(100,190,200,30);
	        add(catagory);

	        String valcategory[]= {"General","OBC","SC","ST","Other"};
	        catagorycb = new JComboBox(valcategory);
	        catagorycb.setBounds(300,190,400,30);
	        catagorycb.setBackground(Color.WHITE);
	        add(catagorycb);

	        JLabel income = new JLabel("Income:" );
	        income.setFont(new Font("Raleway",Font.BOLD,20));
	        income.setBounds(100,240,200,30);
	        add(income);
	        
	        String incomecategory[]= {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
	        incomecb = new JComboBox(incomecategory);
	        incomecb.setBounds(300,240,400,30);
	        incomecb.setBackground(Color.WHITE);
	        add(incomecb);

	         
	        JLabel educational = new JLabel("Educational :" );
	        educational.setFont(new Font("Raleway",Font.BOLD,20));
	        educational.setBounds(100,290,200,30);
	        add(educational);
	        
	        
	        JLabel qualification = new JLabel("Qualification :" );
	        qualification.setFont(new Font("Raleway",Font.BOLD,20));
	        qualification.setBounds(100,315,200,30);
	        add(qualification);
	        
	        String educationValues[]= {"Non Graduate","Graduate","Post Graduation","Doctrate","Other"};
	        education = new JComboBox(educationValues);
	        education.setBounds(300,315,400,30);
	        education.setBackground(Color.WHITE);
	        add(education);

	        

	        JLabel occupation= new JLabel("Occupation:" );
	        occupation.setFont(new Font("Raleway",Font.BOLD,20));
	        occupation.setBounds(100,390,200,30);
	        add(occupation);
	        
	        String occupationValues[]= {"Salaried","Self Employee","Bussinessman","Student","Other"};
	        occupationcb = new JComboBox(occupationValues);
	        occupationcb.setBounds(300,390,400,30);
	        occupationcb.setBackground(Color.WHITE);
	        add(occupationcb);
	        

	        JLabel panl= new JLabel("Pan:" );
	        panl.setFont(new Font("Raleway",Font.BOLD,20));
	        panl.setBounds(100,440,200,30);
	        add(panl);

	        pan = new JTextField();
	        pan.setFont(new Font("Raleway",Font.BOLD,14));
	        pan.setBounds(300,440,400,30);
	        add(pan);
	        
	         JLabel aadhaar= new JLabel("Aadhaar Number:" );
	         aadhaar.setFont(new Font("Raleway",Font.BOLD,20));
	         aadhaar.setBounds(100,490,200,30);
	         add(aadhaar);

	        aadhaarTextField = new JTextField();
	        aadhaarTextField.setFont(new Font("Raleway",Font.BOLD,14));
	        aadhaarTextField.setBounds(300,490,400,30);
	        add(aadhaarTextField);

	        JLabel seniorCitizen= new JLabel("Senior Citizen:" );
	        seniorCitizen.setFont(new Font("Raleway",Font.BOLD,20));
	        seniorCitizen.setBounds(100,540,200,30);
	        add(seniorCitizen);
	        
	        scyes = new JRadioButton("YES");
	        scyes.setBounds(300,540,100,30);
	        scyes.setBackground(Color.WHITE);
	        add(scyes);
	        
	        scno = new JRadioButton("NO");
	        scno.setBounds(450,540,100,30);
	        scno.setBackground(Color.WHITE);
	        add(scno);
	        
	        ButtonGroup scgroup = new ButtonGroup();
	        scgroup.add(scyes);
	        scgroup.add(scno);

	        JLabel existingAccount= new JLabel("Existing Accoount:" );
	        existingAccount.setFont(new Font("Raleway",Font.BOLD,20));
	        existingAccount.setBounds(100,590,200,30);
	        add(existingAccount);
	        
	        eayes = new JRadioButton("YES");
	        eayes.setBounds(300,590,100,30);
	        eayes.setBackground(Color.WHITE);
	        add(eayes);
	        
	        eano = new JRadioButton("NO");
	        eano.setBounds(450,590,100,30);
	        eano.setBackground(Color.WHITE);
	        add(eano);
	        
	        ButtonGroup eagroup = new ButtonGroup();
	        eagroup.add(eayes);
	        eagroup.add(eano);

	        next = new JButton("NEXT");
	        next.setBackground(Color.BLACK);
	        next.setForeground(Color.WHITE);
	        next.setFont(new Font("Raleway",Font.BOLD,14));
	        next.setBounds(620,660,80,30);
	        next.addActionListener(this);
	        add(next);
	        

	        getContentPane().setBackground(Color.WHITE);
	        setSize(850,800);
	        setLocation(350,10);
	        setResizable(false);
	        setVisible(true);
	    }
	    
	    public void actionPerformed(ActionEvent ae) {
	    	
	    	String formn = "" + random;
	    	String sreligion = (String)religioncb.getSelectedItem();
	    	String sincome = (String)incomecb.getSelectedItem();
	    	String scatagory = (String)catagorycb.getSelectedItem();
	    	String seducation = (String)education.getSelectedItem();
	    	String soccupation = (String)occupationcb.getSelectedItem();
	    	
	    	String seniorCitizen = null;
	    	if(scyes.isSelected()) {
	    		seniorCitizen = "Yes";
	    	}
	    	else if(scno.isSelected()) {
	    		seniorCitizen = "No";
	    	}
	    	
	    	String existingAccount = null;
	    	if(eayes.isSelected()) {
	    		existingAccount = "Yes";
	    	}
	    	else if(eano.isSelected()) {
	    		existingAccount = "No";
	    	}
	    	
	    	String span = pan.getText();
	    	String saadhaar = aadhaarTextField.getText();
	    	
	    	try {
	    			Conn c = new Conn();
	    			String query = "insert into signupTwo values('"+formno+"','"+sreligion+"', '"+scatagory+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+span+"', '"+saadhaar+"', '"+seniorCitizen+"', '"+existingAccount+"')";
	    			c.stm.executeUpdate(query);
	    			
	    			setVisible(false);
	    			new SignupThree(formno).setVisible(true);
	   
	    	}
	    	catch(Exception e){
	    		System.out.println(e);
	    	}	
	    }
	    
	    public static void main(String[] args) {
	        new SignupTwo("formno");
	    }
	}


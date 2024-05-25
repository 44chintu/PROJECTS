import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class student_grade_calculator extends JFrame implements ActionListener{
	JTextField name,mark1_text,mark2_text,mark3_text,total_text;
    JButton submit;
    
	student_grade_calculator(){
    	getContentPane().setBackground(Color.white);
    	setLayout(null);
    	JLabel headerLabel=new JLabel("Student Grade Calculation");
    	headerLabel.setBounds(100,20,400,50);
    	headerLabel.setFont(new Font("Raleway",Font.BOLD,30));
    	add(headerLabel);

    	JLabel student_name=new JLabel("Student Name");
    	student_name.setBounds(50,100,150,30);
    	student_name.setFont(new Font("Raleway",Font.BOLD,20));
    	add(student_name);

    	name=new JTextField();
    	name.setBounds(220,100,300,30);
    	name.setFont(new Font("Raleway",Font.BOLD,17));
    	add(name);

    	JLabel mark1=new JLabel("Maths");
    	mark1.setBounds(50,148,150,30);
    	mark1.setFont(new Font("Raleway",Font.BOLD,20));
    	add(mark1);

    	mark1_text=new JTextField();
    	mark1_text.setBounds(220,150,300,30);
    	mark1_text.setFont(new Font("Raleway",Font.BOLD,17));
    	add(mark1_text);

    	JLabel mark2=new JLabel("Science");
    	mark2.setBounds(50,200,150,30);
    	mark2.setFont(new Font("Raleway",Font.BOLD,20));
    	add(mark2);
    	
    	mark2_text=new JTextField();
    	mark2_text.setBounds(220,200,300,30);
    	mark2_text.setFont(new Font("Raleway",Font.BOLD,17));
    	add(mark2_text);
    	
    	JLabel mark3=new JLabel("English");
    	mark3.setBounds(50,250,150,30);
    	mark3.setFont(new Font("Raleway",Font.BOLD,20));
    	add(mark3);
    	
    	mark3_text=new JTextField();
    	mark3_text.setBounds(220,250,300,30);
    	mark3_text.setFont(new Font("Raleway",Font.BOLD,17));
    	add(mark3_text);
    	
    	submit = new JButton("Submit");
    	submit.setBounds(320,300,90,35);
    	submit.setFont(new Font("Raleway",Font.BOLD,15));
    	submit.addActionListener(this);
    	add(submit);
    	
    	JLabel total = new JLabel("Total Marks");
    	total.setBounds(50,380,150,30);
    	total.setFont(new Font("Raleway",Font.BOLD,20));
    	add(total);
    	
    	total_text=new JTextField();
    	total_text.setBounds(220,380,300,30);
    	total_text.setFont(new Font("Raleway",Font.BOLD,17));
    	add(total_text);
    	
    	setSize(600,500);
    	setVisible(true);
    	setLocation(400,120);
        setResizable(false);
    }
	
	
	public static void main(String[] args) {
		new student_grade_calculator();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==submit) {
			String studentName = name.getText();
			int m1 = Integer.parseInt(mark1_text.getText());
			int m2 = Integer.parseInt(mark2_text.getText());
			int m3 = Integer.parseInt(mark3_text.getText());
			
			total_text.setText(""+(m1+m2+m3));
		}
	}

}

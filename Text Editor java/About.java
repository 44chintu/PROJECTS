import javax.swing.*;
public class About extends JFrame{
    About(){
        setBounds(100,100,500,400);
        setTitle("About Notepad Application");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        ImageIcon image = new ImageIcon(ClassLoader.getSystemResource("notepadicon.png"));
        JLabel iconLabel = new JLabel(image);
        iconLabel.setBounds(100,50, 80, 80);

        JLabel text = new JLabel("THIS IS MY NOTEPAD APPLICATION PROJECT");
        text.setBounds(100,50,400,300);
        add(text);
        add(iconLabel);
    }
    public static void main(String args[]){
        new About().setVisible(true);
    }
}

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class NotepadApp extends JFrame implements ActionListener{

    JTextArea textArea = new JTextArea();


    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("edit");
    JMenu help = new JMenu("help");

    JMenuItem newFile = new JMenuItem("New File");
    JMenuItem openFile = new JMenuItem("Open File");
    JMenuItem saveFile = new JMenuItem("Save File");
    JMenuItem print = new JMenuItem("Print");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy  = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectAll = new JMenuItem("Select All");

    JMenuItem about = new JMenuItem("About");

    NotepadApp(){
        setTitle("NotePad Application");
        setBounds(100,100,800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("notepadicon.png"));
        // setIconImage(icon.getImage());

        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(print);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);

        help.add(about);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));

        add(scrollPane);

        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        print.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);
        about.addActionListener(this);

        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,KeyEvent.CTRL_DOWN_MASK));
        print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,KeyEvent.CTRL_DOWN_MASK));
        selectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,KeyEvent.CTRL_DOWN_MASK));
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equalsIgnoreCase("New File")){
            textArea.setText(null);
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Open File")){

            JFileChooser openJFileChooser = new JFileChooser();

            int action = openJFileChooser.showOpenDialog(null);

            if(action!=JFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                try{
                    BufferedReader reader = new BufferedReader(new FileReader(openJFileChooser.getSelectedFile()));
                    textArea.read(reader,null);
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }

        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Save File")){
            
            JFileChooser saveJFileChooser = new JFileChooser();

            int action = saveJFileChooser.showSaveDialog(null);
            if(action!=saveJFileChooser.APPROVE_OPTION){
                return;
            }
            else{
                String filename = saveJFileChooser.getSelectedFile().getAbsolutePath().toString();
                if(!(filename.contains(".txt"))){
                    filename += ".txt";
                }
                try{
                    BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
                    textArea.write(writer);
                }
                catch(IOException ioe){
                    ioe.printStackTrace();
                }
            }
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Print")){

            try{
                textArea.print();
            }
            catch(PrinterException pe){
                Logger.getLogger(NotepadApp.class.getName()).log(Level.SEVERE,null,pe);
            }

        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Exit")){
            System.exit(0);
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Cut")){
            textArea.cut();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Copy")){
            textArea.copy();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("Paste")){
            textArea.paste();
        }
       
        else if(e.getActionCommand().equalsIgnoreCase("Select All")){
            textArea.selectAll();
        }
        
        else if(e.getActionCommand().equalsIgnoreCase("About")){
            new About().setVisible(true);
        }
    }

    public static void main(String args[]) throws Exception {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        new NotepadApp().setVisible(true);
    }
}
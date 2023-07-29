import javax.sql.rowset.spi.TransactionalWriter;
import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;
import javax.swing.text.PlainDocument;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.*;
import java.util.*;

public class GAME extends JFrame implements ActionListener{

    JFrame mainFrame = new JFrame();
    Random random = new Random();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    TextField textField = new TextField();
    JLabel title = new JLabel("TIC TAC TOE");
    JButton[] buttons = new JButton[9];
    boolean player1_turn = random.nextBoolean();
    boolean win = false;

    GAME(){

        mainFrame.setTitle("TicTacToe");
        mainFrame.setSize(700, 700);
        mainFrame.setLocation(200,80);
        mainFrame.getContentPane().setBackground((new Color(50,50,50)));
        mainFrame.setLayout(new BorderLayout());
        title_panel.setBackground(new Color(102,204,153));
        title_panel.setLayout(new BorderLayout()); 
        title_panel.setPreferredSize(new Dimension(700, 100));
        title.setForeground((new Color(225,31,31)));
        title.setFont(new Font("Sans_Serif",Font.BOLD,50));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title_panel.add(title,BorderLayout.CENTER);
        mainFrame.add(title_panel,BorderLayout.NORTH);
        mainFrame.setVisible(true);
        button_panel.setLayout(new GridLayout(3,3));
        mainFrame.add(button_panel);

        for(int i=0;i<9;i++){
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        firstTurn();
    }

    public static void main(String[] args) {

        new GAME();
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i] && buttons[i].getText()==""){
                if(player1_turn){
                    buttons[i].setForeground(new Color(255,0,0));
                    buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
                    buttons[i].setText("X");
                    check();
                    if(win==false){
                        title.setText("O Turn"); 
                        player1_turn = false;
                    }
                    
                }
                else{
                    buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
                    buttons[i].setForeground(new Color(0,255,0));
                    buttons[i].setText("O");
                    check();
                    if(win==false){
                        title.setText("X Turn"); 
                        player1_turn = true;
                    }
                }
            }
        }
    }

    public void firstTurn(){ 
        try{
            Thread.sleep(2000);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(player1_turn){
            player1_turn = true;
            title.setText("X Turn");
            check();
        }
        else{
            player1_turn = false;
            title.setText("O Turn");
            check();
        }
    }
    public void check(){
        //X Wins
        if(
            (buttons[0].getText()=="X") &&
            (buttons[1].getText()=="X") &&
            (buttons[2].getText()=="X")){
                xWins(0,1,2);
            }
        if(
            (buttons[3].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[5].getText()=="X")){
                xWins(3,4,5);
            }
        if(
            (buttons[6].getText()=="X") &&
            (buttons[7].getText()=="X") &&
            (buttons[8].getText()=="X")){
                xWins(6,7,8);
            }
        if(
            (buttons[0].getText()=="X") &&
            (buttons[3].getText()=="X") &&
            (buttons[6].getText()=="X")){
                xWins(0,3,6);
            }
        if(
            (buttons[1].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[7].getText()=="X")){
                xWins(1,4,7);
            }
        if(
            (buttons[2].getText()=="X") &&
            (buttons[5].getText()=="X") &&
            (buttons[8].getText()=="X")){
                xWins(2,5,8);
            }
        if(
            (buttons[0].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[8].getText()=="X")){
                xWins(0,4,8);
            }
        if(
            (buttons[2].getText()=="X") &&
            (buttons[4].getText()=="X") &&
            (buttons[6].getText()=="X")){
                xWins(2,4,6);
            }
        //Owin

        if(
            (buttons[0].getText()=="O") &&
            (buttons[1].getText()=="O") &&
            (buttons[2].getText()=="O")){
                oWins(0,1,2);
            }
        if(
            (buttons[3].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[5].getText()=="O")){
                oWins(3,4,5);
            }
        if(
            (buttons[6].getText()=="O") &&
            (buttons[7].getText()=="O") &&
            (buttons[8].getText()=="O")){
                oWins(6,7,8);
            }
        if(
            (buttons[0].getText()=="O") &&
            (buttons[3].getText()=="O") &&
            (buttons[6].getText()=="O")){
                oWins(0,3,6);
            }
        if(
            (buttons[1].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[7].getText()=="O")){
                oWins(1,4,7);
            }
        if(
            (buttons[2].getText()=="O") &&
            (buttons[5].getText()=="O") &&
            (buttons[8].getText()=="O")){
                oWins(2,5,8);
            }
        if(
            (buttons[0].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[8].getText()=="O")){
                oWins(0,4,8);
            }
        if(
            (buttons[2].getText()=="O") &&
            (buttons[4].getText()=="O") &&
            (buttons[6].getText()=="O")){
                oWins(2,4,6);
            }  
    }

    public void xWins(int a, int b, int c){
        win = true;
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        title.setText("X Wins");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }
    public void oWins(int a, int b, int c){
        win = true;
        buttons[a].setBackground(Color.green);
        buttons[b].setBackground(Color.green);
        buttons[c].setBackground(Color.green);
        title.setText("O Wins");
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
    }

    // public void draw(){
    //     for(int i=0;i<9;i++){
    //         if(buttons[i].getText()!= "" && draw == false){
    //             title.setText("Game Draw");
    //             draw = true;
    //         }
    //     }
    //     if(draw == true){
    //         for(int i=0;i<9;i++){
    //             buttons[i].setEnabled(false);
    //         }
    //     }
    // }




}
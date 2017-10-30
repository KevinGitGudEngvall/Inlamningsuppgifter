
package inlämningsuppgift3;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUIspel extends JFrame implements ActionListener{
    
    JPanel spelpan = new JPanel();
    
    JButton[][] bArray = new JButton[4][4];
   
    int rad;
    int kolumn;
    int n = 1;
    
    public GUIspel(){
        
        add(spelpan);
        spelpan.setLayout(new GridLayout(4, 4));
        
        for(int i = 0; i < bArray.length; i++ ){
            for(int j = 0; j < bArray[i].length; j++){
                bArray[i][j] = new JButton();
                bArray[i][j].setText(n + "");
                spelpan.add(bArray[i][j]);
                bArray[i][j].addActionListener(this);
                n++;
            }
        }
        
        bArray[3][3].setBackground(Color.black);
        
        
        
        setLocation(600, 300);
        setSize(600, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
        
    }
    
    public void blanda(){
        
        String rand[] = new String[16];
        int i, j, n = 0;
        for(i = 0; i < 16; i++){
            int num = (int)(Math.random()*15+1);
            rand[i] = String.valueOf(num);
        }
        for(i = 0; i < 16; i++){
             for(j = 0; j < i; j++){
                if( rand[i].equals(rand[j])){
                    int num = (int)(Math.random()*16+1);
                    rand[i] = String.valueOf(num);
                    j=-1;
                }
            }
        }
        for(i = 0; i < 16; i++ ){
           
            if(rand[i].equals("16")){
                rand[i] = rand[15];
            }
        } 
        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++){
                bArray[i][j].setText(rand[n]);
                n++;
            }
        }
        
        bArray[3][3].setText("");
        
    }
    
    
    public void vann(){
    int i, j;
    int n = 1;
    int m = 2;
    String check = "1";
    boolean bröt = true;
        for(i = 0; i < 4; i++){
            for(j = 0; j < 4; j++){
                if( check.equals(bArray[i][j].getText())){
                    n++;
                    check = n + "";
                    if(check.equals("16")){
                        check = "";
                    }
                }     
                if(n == m){
                    m++;
                }     
            }
        }
        if( m == 18){
             JOptionPane.showMessageDialog(null, "Du Vann!");
             System.exit(0);
        }
             
    }
    
    public void flyttaknapp(int r, int k){
        if(!bArray[r][k].getText().equals("") ){
            if( r-1 >= 0 ){
                if(bArray[r-1][k].getText().equals("") ){
                    JButton temp = new JButton();
                    String s = bArray[r-1][k].getText();
                    temp.setName(s);
                    bArray[r-1][k].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(Color.black);
                    bArray[r-1][k].setBackground(null);
                }
            }    
            if( r+1 < 4){
                if(bArray[r+1][k].getText().equals("")){
                    JButton temp = new JButton();
                    String s = bArray[r+1][k].getText();
                    temp.setName(s);
                    bArray[r+1][k].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(Color.black);
                    bArray[r+1][k].setBackground(null);
                }
            }
            if( k-1 >= 0){
                if(bArray[r][k-1].getText().equals("") ){
                    JButton temp = new JButton();
                    String s = bArray[r][k-1].getText();
                    temp.setName(s);
                    bArray[r][k-1].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(Color.black);
                    bArray[r][k-1].setBackground(null);
                }
            }
            if( k+1 < 4){
                if(bArray[r][k+1].getText().equals("") ){
                    JButton temp = new JButton();
                    String s = bArray[r][k+1].getText();
                    temp.setName(s);
                    bArray[r][k+1].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(Color.black);
                    bArray[r][k+1].setBackground(null);
                }
            }
            
        }
        vann();
    }
    
    
    
    public void actionPerformed(ActionEvent e){
        
        
        JButton vald = (JButton) e.getSource();
        for(int r = 0; r < bArray.length; r++){
            for(int k = 0; k < bArray[r].length; k++){
                if(bArray[r][k] == vald){
                     rad = r;
                     kolumn = k;
                } 
            }
        }
        
        flyttaknapp(rad, kolumn);
        
        revalidate();
        repaint();
        
    }
    
}

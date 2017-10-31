
package inlämningsuppgift3;

import java.awt.BorderLayout;
import static java.awt.BorderLayout.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class GUIspel extends JFrame implements ActionListener{
    
    JPanel allpan = new JPanel();
    JPanel spelpan = new JPanel();
    JPanel blandpan = new JPanel();
    
    JButton[][] bArray = new JButton[4][4];
    JButton blandknapp = new JButton("Blanda");
   
    int rad;
    int kolumn;
    int r = 3;
    int k = 3;
    int n = 1;
    
    public GUIspel(){
        
        add(allpan);
        allpan.setLayout(new BorderLayout());
        allpan.add(spelpan, CENTER);
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
        bArray[3][3].setText("");
        
        allpan.add(blandpan, SOUTH);
        blandpan.add(blandknapp);
        blandknapp.addActionListener(this);
        
        setLocation(700, 100);
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        
        
        
        
    }
    
    public void blanda(){
        
        
        for(int i = 0; i < 1000; i++){
            int num = (int)(Math.random()*4+1);
            if(num == 1){
                if(r-1 >= 0){
                    JButton temp = new JButton();
                    String s = bArray[r-1][k].getText();
                    temp.setName(s);
                    bArray[r-1][k].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(null);
                    bArray[r-1][k].setBackground(Color.black);
                    r -= 1;
                }        
            }
            if(num == 2){
                if(r+1 < 4){
                    JButton temp = new JButton();
                    String s = bArray[r+1][k].getText();
                    temp.setName(s);
                    bArray[r+1][k].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(null);
                    bArray[r+1][k].setBackground(Color.black);
                    r += 1;
                }        
            }
            if(num == 3){
                if(k-1 >= 0){
                    JButton temp = new JButton();
                    String s = bArray[r][k-1].getText();
                    temp.setName(s);
                    bArray[r][k-1].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(null);
                    bArray[r][k-1].setBackground(Color.black);
                    k -= 1;
                }        
            }
            if(num == 4){
                if(k+1 < 4){
                    JButton temp = new JButton();
                    String s = bArray[r][k+1].getText();
                    temp.setName(s);
                    bArray[r][k+1].setText(bArray[r][k].getText());
                    bArray[r][k].setText(temp.getName());
                    bArray[r][k].setBackground(null);
                    bArray[r][k+1].setBackground(Color.black);
                    k += 1;
                }        
            }
        }
     
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
            for(int v = 0; v < 4; v++){ 
                for(int w = 0; w < 4; w++){
                    bArray[v][w].setBackground(Color.yellow);
                    bArray[3][3].setBackground(Color.black);
                }
            }
            JOptionPane.showMessageDialog(null, "Du Vann!");
            System.exit(0);
        }
             
    }
    
    public void flyttaknapp(int ra, int ko){
        if(!bArray[ra][ko].getText().equals("") ){
            if( ra-1 >= 0 ){
                if(bArray[ra-1][ko].getText().equals("") ){
                    JButton temp = new JButton();
                    String s = bArray[ra-1][ko].getText();
                    temp.setName(s);
                    bArray[ra-1][ko].setText(bArray[ra][ko].getText());
                    bArray[ra][ko].setText(temp.getName());
                    bArray[ra][ko].setBackground(Color.black);
                    bArray[ra-1][ko].setBackground(null);
                    r += 1;
                }
            }    
            if( ra+1 < 4){
                if(bArray[ra+1][ko].getText().equals("")){
                    JButton temp = new JButton();
                    String s = bArray[ra+1][ko].getText();
                    temp.setName(s);
                    bArray[ra+1][ko].setText(bArray[ra][ko].getText());
                    bArray[ra][ko].setText(temp.getName());
                    bArray[ra][ko].setBackground(Color.black);
                    bArray[ra+1][ko].setBackground(null);
                    r -= 1;
                }
            }
            if( ko-1 >= 0){
                if(bArray[ra][ko-1].getText().equals("") ){
                    JButton temp = new JButton();
                    String s = bArray[ra][ko-1].getText();
                    temp.setName(s);
                    bArray[ra][ko-1].setText(bArray[ra][ko].getText());
                    bArray[ra][ko].setText(temp.getName());
                    bArray[ra][ko].setBackground(Color.black);
                    bArray[ra][ko-1].setBackground(null);
                    k += 1;
                }
            }
            if( ko+1 < 4){
                if(bArray[ra][ko+1].getText().equals("") ){
                    JButton temp = new JButton();
                    String s = bArray[ra][ko+1].getText();
                    temp.setName(s);
                    bArray[ra][ko+1].setText(bArray[ra][ko].getText());
                    bArray[ra][ko].setText(temp.getName());
                    bArray[ra][ko].setBackground(Color.black);
                    bArray[ra][ko+1].setBackground(null);
                    k -= 1;
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
        
        if(e.getSource() == blandknapp){
            blanda();
        }
        
        flyttaknapp(rad, kolumn);
        
        revalidate();
        repaint();
        
    }
    
}

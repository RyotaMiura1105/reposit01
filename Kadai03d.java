//22D81011040E Miura Ryota 三浦僚太　2024年4月26日

import java.awt.*;
import javax.swing.*;

public class Kadai03d extends JFrame{
    private MyPanel sp;

    public static void main(String[] args){
        Kadai03d sm = new Kadai03d();
    }

    public Kadai03d(){
        super("Kadai03d");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        sp = new MyPanel();
        add(sp,BorderLayout.CENTER);
        setVisible(true);
    }
    public class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int x, y_sin, y_cos;
            double RD;
            int x_base = 100, y_base = 100, size = 80;
            for(int k = 0; k < 360; k++){
                RD = k* Math.PI/180;
                x = x_base+k;
                y_sin = y_base-(int)(Math.sin(RD)*size);
                y_cos = y_base-(int)(Math.cos(RD)*size);
                if(k % 6 == 0 && k % 5 == 0){
                   g.fillOval(y_sin-5, y_cos-5, 10, 10); 
                }else if(k % 6 == 0 && k % 5 != 0){
                   g.fillOval(y_sin-2, y_cos-2, 4, 4); 
                }
                
            }
        }
    }
}
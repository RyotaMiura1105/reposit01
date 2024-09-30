//22D81011040E Miura Ryota 三浦僚太　2024年4月26日

import java.awt.*;
import javax.swing.*;

public class Kadai03c extends JFrame{
    private MyPanel sp;

    public static void main(String[] args){
        Kadai03c sm = new Kadai03c();
    }

    public Kadai03c(){
        super("Kadai03c");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000,500);
        sp = new MyPanel();
        add(sp,BorderLayout.CENTER);
        setVisible(true);
    }
    public class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int y_sin_sq, x;
            int N = 50;
            double RD;
            int x_base = 0, size = 100;
            for(int k = 0; k < 720; k++){
                y_sin_sq = 0;
                RD = k* Math.PI/180;
                x = x_base+k;
                for(int h = 1; h <= N; h++){
                    y_sin_sq += (int)(-1/(2*h-1))*(Math.sin((2*h-1)*RD)*size);
                }
                g.drawLine(x, 200+y_sin_sq, x, 200+y_sin_sq);
            }
        }
    }
}
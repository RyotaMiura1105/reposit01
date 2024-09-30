//22D81011040E Miura Ryota 三浦僚太　2024年4月26日

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Kadai03e extends JFrame{
    private MyPanel sp;

    public static void main(String[] args){
        Kadai03e sm = new Kadai03e();
    }

    public Kadai03e(){
        super("Kadai03e");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);
        sp = new MyPanel();
        add(sp,BorderLayout.CENTER);
        setVisible(true);
    }
    public class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int x, y_sin, y_cos, y_cos_m, y_sin_m, y_cos_h, y_sin_h;
            double RD;
            int x_base = 100, y_base = 100, size = 80;
            for(int k = 0; k < 360; k++){
                RD = k* Math.PI/180;
                x = x_base+k;
                y_sin = y_base-(int)(Math.sin(RD)*size);
                y_cos = y_base-(int)(Math.cos(RD)*size);
                g.fillOval(x_base-5, y_base-5, 10, 10);
                if(k % 6 == 0 && k % 5 == 0){
                   g.fillOval(y_sin-5, y_cos-5, 10, 10); 
                }else if(k % 6 == 0 && k % 5 != 0){
                   g.fillOval(y_sin-2, y_cos-2, 4, 4); 
                }
            }
            double RD_mi, RD_ho;
            Calendar cl = Calendar.getInstance();
            RD_mi = (((-cl.get(Calendar.MINUTE)*6))) * Math.PI/180;
            RD_ho= (((-cl.get(Calendar.HOUR)*30-cl.get(Calendar.MINUTE)*0.5))) * Math.PI/180;
            y_sin_m = y_base-(int)(Math.sin(RD_mi)*(size-10));
            y_cos_m = y_base-(int)(Math.cos(RD_mi)*(size-10));
            y_sin_h = y_base-(int)(Math.sin(RD_ho)*(size-30));
            y_cos_h = y_base-(int)(Math.cos(RD_ho)*(size-30));
            g.drawLine(x_base, y_base, y_sin_m, y_cos_m);
            g.drawLine(x_base, y_base, y_sin_h, y_cos_h);
        }
    }
}
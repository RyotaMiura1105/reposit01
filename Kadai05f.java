//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Kadai05f extends JFrame{
    private MyPanel sp;

    public static void main(String[] args){
        Kadai05f sm = new Kadai05f();
    }

    public Kadai05f(){
        super("Kadai05f");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(650,300);
        sp = new MyPanel();
        add(sp,BorderLayout.CENTER);
        setVisible(true);
    }
    public class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            MyClock[] mc = new MyClock[3];
            mc[0] = new MyClock(100,100,80,"Asia/Tokyo");
            mc[1] = new MyClock(300,100,80,"Europe/London");
            mc[2] = new MyClock(500,100,80,"America/Chicago");

            for(MyClock a : mc){
                a.draw(g);
                a.print(g);
            }
        }
    }
}
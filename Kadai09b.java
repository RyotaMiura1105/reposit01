//22D81011040E Miura Ryota 三浦僚太　2024年6月19日

import java.awt.*;
import javax.swing.*;

public class Kadai09b extends JFrame {
    private MyPanel sp;

    public static void main(String[] args) {
        Kadai09b sm = new Kadai09b();
    }

    public Kadai09b() {
        super("Kadai09b");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600,450); 
        sp = new MyPanel(); 
        add(sp, BorderLayout.CENTER);
        setVisible(true);
    }

    public class MyPanel extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            MySuper[] ms = new MySuper[6];
            ms[0] = new MyClock2(100,100,80,"Asia/Tokyo");
            ms[1] = new MyClock2(300,100,80,"Europe/London");
            ms[2] = new MyClock2(500,100,80,"America/Chicago");
            ms[3] = new MyPolygon2(100,300,80,10);
            ms[4] = new MyPolygon2(300,300,80,15);
            ms[5] = new MyPolygon2(500,300,80,20);
            for(MySuper a : ms){
                a.draw(g);
            }
        }
    }
}


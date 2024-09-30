//22D81011040E Miura Ryota 三浦僚太　2024年7月5日

import javax.swing.*;
import java.awt.*;

public class Kadai12a{
    int x=70, y=70;
    public static void main(String[] args){
        Kadai12a gui = new Kadai12a();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300,300);
        frame.setVisible(true);

        for(int i=0;i<130;i++){
            x++;
            y++;
            drawPanel.repaint();
            try{
                Thread.sleep(50);
            }catch(Exception e){}
        }
    }

    class MyDrawPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.blue);
            g.fillOval(x,y,40,40);
        }
    }
}
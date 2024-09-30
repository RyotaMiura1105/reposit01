//22D81011040E Miura Ryota 三浦僚太　2024年7月12日

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kadai13c{
    public static void main(String[] args){
        Kadai13c gui = new Kadai13c();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setSize(356,400);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements ActionListener{
        String fn[] = {"img1.JPG","img2.JPG","img3.JPG","img4.JPG"};
        int k=0, n=fn.length;
        ImageIcon[] imgs;
        Timer time;

        public MyDrawPanel(){
            imgs = new ImageIcon[fn.length];
            for(int i=0;i<fn.length;i++){
                imgs[i] = new ImageIcon(fn[i]);
            }
            time = new Timer(1000,this);
            time.start();
        }

       
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            int i;
            for(i=0;i<n;i++) if(fn[i] == cmd) break;
            k = (k+1)%n;
            System.out.println("k="+k);
            repaint();
        } 
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(imgs[k].getImage(),40,90,this);
        }

    }
}

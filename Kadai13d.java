//22D81011040E Miura Ryota 三浦僚太　2024年7月12日

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Kadai13d{
    public static void main(String[] args){
        Kadai13d gui = new Kadai13d();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel,BorderLayout.CENTER);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements MouseMotionListener,MouseListener{
        int x=10,y=10;;
        Image img;
        
        public MyDrawPanel(){
            addMouseMotionListener(this);
            addMouseListener(this);
            img = new ImageIcon("img1.JPG").getImage();
        }
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.drawImage(img, x, y, 50, 50, this);
        }
        public void mousePressed(MouseEvent e){
            x = e.getX();
            y = e.getY();
            repaint();
        }
        public void mouseDragged(MouseEvent e){
            x = e.getX();
            y = e.getY();
            repaint();
        }
        public void mouseMoved(MouseEvent e){}
        public void mouseExited(MouseEvent e){}
        public void mouseEntered(MouseEvent e){}
        public void mouseReleased(MouseEvent e){}
        public void mouseClicked(MouseEvent e){}
    }
}

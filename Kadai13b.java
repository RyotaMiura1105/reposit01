//22D81011040E Miura Ryota 三浦僚太　2024年7月12日

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

class BlueCircle{
    int w,h;
    int x,y,vx,vy,r;
    public BlueCircle(int w,int h){
        this.w = w; this.h = h;
        x = urand(300)+w/4; y = urand(200)+h/4;
        vx = 5; vy = 3; r = 30;
    }
    public BlueCircle(int w,int h, int r){
        this.w = w; this.h = h; this.r =r;
        x = urand(300)+w/4; y = urand(200)+h/4;
        vx = 5; vy = 3; 
    }
    public void update(){
        x = x+vx; y=y+vy;
        if(x-r < 50){x = x-vx; vx = -vx;};
        if(x+r >= w-50){x = x-vx; vx = -vx;};
        if(y-r < 50){y = y-vy; vy = -vy;};
        if(y+r >= h-50){y = y-vy; vy = -vy;};
    }
    int urand(int m){
        return (int)(Math.random()*m);
    }
    void disp(Graphics g){
        g.setColor(Color.blue);
        g.drawOval(x-r, y-r, 2*r, 2*r);
    }
}

public class Kadai13b{
    JButton button1,button2;
    public static void main(String[] args){
        Kadai13b gui = new Kadai13b();
        gui.go();
    }

    public void go(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1 = new JButton("Add a Ball");
        button2 = new JButton("Add a Small Ball");
        MyDrawPanel drawPanel = new MyDrawPanel();
        button1.addActionListener(drawPanel);
        button2.addActionListener(drawPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, button1);
        frame.getContentPane().add(BorderLayout.NORTH, button2);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.setSize(600,500);
        frame.setVisible(true);
    }

    class MyDrawPanel extends JPanel implements ActionListener{
        ArrayList<BlueCircle> al;
        javax.swing.Timer time;

        public MyDrawPanel(){
            al = new ArrayList<BlueCircle>();
            time = new javax.swing.Timer(20,this);
            time.start();
        }

        public void actionPerformed(ActionEvent e){
            if(e.getSource() == button1){
                BlueCircle c = new BlueCircle(getWidth(),getHeight());
                al.add(c);
            }else if(e.getSource() == button2){
                BlueCircle c = new BlueCircle(getWidth(),getHeight(),15);
                al.add(c);
            }else{
                repaint();
            }
        }

        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.white);
            g.fillRect(0,0,getWidth(),getHeight());
            g.setColor(Color.blue);
            g.drawRect(50,50,getWidth()-100,getHeight()-100);

            Iterator<BlueCircle> it = al.iterator();
            while(it.hasNext()){
                BlueCircle c = it.next();
                c.update();
                c.disp(g);
            }
        }
    }
}
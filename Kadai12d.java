//22D81011040E Miura Ryota 三浦僚太　2024年7月5日

import javax.swing.*;
import java.awt.*;

public class Kadai12d{
	int x=70,y=70;
	int vx=1,vy=1;
	int r=20;
	public static void main(String[] args){
		Kadai12d gui = new Kadai12d();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		drawPanel.setBackground(Color.WHITE);
		frame.getContentPane().add(drawPanel);
		frame.setSize(500,400);
		frame.setVisible(true);
		
		while(true){
			x+=vx;
			y+=vy;
			
			if(x-r<=50 || x+r>=drawPanel.getWidth()-50){
				vx=-vx;
			}
			if(y-r<=50 || y+r>=drawPanel.getHeight()-50){
				vy=-vy;
			}
			
			drawPanel.repaint();
			try{
				Thread.sleep(10);
			}catch(Exception e){}
		}
	}
	
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawRect(50,50,this.getWidth()-100,this.getHeight()-100);
			g.setColor(Color.blue);
			g.fillOval(x-r,y-r,2*r,2*r);
		}
	}
}

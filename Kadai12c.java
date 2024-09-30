//22D81011040E Miura Ryota 三浦僚太　2024年7月5日

import javax.swing.*;
import java.awt.*;

public class Kadai12c{
	int x=1,y=1;
	public static void main(String[] args){
		Kadai12c gui = new Kadai12c();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawP drawP = new MyDrawP();
		
		frame.getContentPane().add(drawP);
		frame.setSize(500,270);
		frame.setVisible(true);
		
		for(int i=0;i<124;i++){
			x++;
			y++;
			drawP.repaint();
			try{
				Thread.sleep(50);
			}catch(Exception e){}
		}
	}
	
	class MyDrawP extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.blue);
			g.fillRect(x,y,500-x*2,250-y*2);
		}
	}
}

//22D81011040E Miura Ryota 三浦僚太　2024年7月5日

import javax.swing.*;
import java.awt.*;

public class Kadai12b{
	int i;
	public static void main(String[] args){
		Kadai12b gui = new Kadai12b();
		gui.go();
	}
	
	public void go(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDrawPanel drawPanel = new MyDrawPanel();
		
		frame.getContentPane().add(drawPanel);
		frame.setSize(300,300);
		frame.setVisible(true);
		
		for(i=5;i<51;i++){
			drawPanel.repaint();
			try{
				Thread.sleep(100);
			}catch(Exception e){}
		}
	for(i=50;i>=5;i--){
		drawPanel.repaint();
		try{
				Thread.sleep(100);
			}catch(Exception e){}
	}
	}
	class MyDrawPanel extends JPanel{
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			(new MyPolygon(120,120,100,i)).draw(g);
		}
	}
}

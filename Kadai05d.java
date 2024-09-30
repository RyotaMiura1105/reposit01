//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

import java.awt.*;
import javax.swing.*;
import java.util.Scanner;

public class Kadai05d extends JFrame{
    private MyPanel sp;
    static int m;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("サイズを入力");
        m = sc.nextInt();
        Kadai05d sm = new Kadai05d();
    }
    public Kadai05d(){
        super("Kadai05d");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800,800);
        sp = new MyPanel();
        add(sp, BorderLayout.CENTER);
        setVisible(true);
    }
    public class MyPanel extends JPanel{
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            int[][] a = new int[m][m];
            for(int n = 0; n < m; n++){
                for(int k = 0; k < m; k++){
                    if(k == 0){
                        a[n][k] = 1;
                    }else if(n == 0){
                        a[n][k] = 0;
                    }else{
                        a[n][k] = ((a[n-1][k-1] + a[n-1][k]) % 2);
                    }
                }
            }
            for(int n = 0; n < m; n++){
                for(int k = 0; k < m; k++){
                    g.drawRect(k*5,n*5,5,5);
                    if(a[n][k] == 1){
                        g.fillRect(k*5,n*5,5,5);
                    }
                }
            }
        }
    }
}
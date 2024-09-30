//22D81011040E Miura Ryota 三浦僚太　2024年5月31日

import java.awt.*;
import javax.swing.*;
import java.util.*;
public class MyPolygon{
    int cx;
    int cy;
    int radious;
    int n;

    public MyPolygon(int cx, int cy, int radious, int n){
        this.cx = cx;
        this.cy = cy;
        this.radious = radious;
        this.n = n;
    }

    public void draw(Graphics g){
        int x,t,tmp_i_sin,tmp_i_cos,tmp_j_sin,tmp_j_cos;
        double RD;
        int size = 50;
        double[] plot = new double[n];
        t = 0;
        for(int k = 0; k < 360; k++){
            RD = k* Math.PI/180;
            x = cx+k;
            if(k % (360/n) == 0){
                plot[t] = RD;
                t++;
            }
        }    
        for(int i = 0; i < n - 1; i++){
            tmp_i_sin = cx+(int)(Math.sin(plot[i])*size);
            tmp_i_cos = cy+(int)(Math.sin(plot[i])*size);
            for(int j = 1; j < n; j++){
                tmp_j_sin = cx+(int)(Math.sin(plot[j])*size);
                tmp_j_cos = cy+(int)(Math.sin(plot[j])*size);
                g.drawLine(tmp_i_sin,tmp_i_cos,tmp_j_sin,tmp_j_cos);
            }
        }
    }
}
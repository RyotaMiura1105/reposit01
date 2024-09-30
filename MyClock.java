//22D81011040E Miura Ryota 三浦僚太　2024年5月17日

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class MyClock{
    private int cx;
    private int cy;
    private int radious;
    private String country;

    public MyClock(int cx, int cy, int radious, String country){
        this.cx = cx;
        this.cy = cy;
        this.radious = radious;
        this.country = country;
    }

    public void print(Graphics g){
        g.drawString(country, cx-25, cy+radious+30);
    }

    public void draw(Graphics g){
        int x, y_sin, y_cos,y_cos_m, y_sin_m, y_cos_h, y_sin_h;
        double RD;
        int size = 80;
        for(int k = 0; k < 360; k++){
            RD = k* Math.PI/180;
            x = cx+k;
            y_sin = cy-(int)(Math.sin(RD)*size);
            y_cos = cy-(int)(Math.cos(RD)*size);
            g.fillOval(cx-5, cy-5, 10, 10); 
            if(k % 6 == 0 && k % 5 == 0){
               g.fillOval(cx+y_sin-105, y_cos-5, 10, 10); 
            }else if(k % 6 == 0 && k % 5 != 0){
               g.fillOval(cx+y_sin-102, y_cos-2, 4, 4); 
            }
        }    
        
        Calendar cl = Calendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone(country);
        cl.setTimeZone(tz);

        double RD_mi, RD_ho;
        RD_mi = (((-cl.get(Calendar.MINUTE)*6))) * Math.PI/180;
        RD_ho= (((-cl.get(Calendar.HOUR)*30-cl.get(Calendar.MINUTE)*0.5))) * Math.PI/180;
        y_sin_m = cy-(int)(Math.sin(RD_mi)*(size-10));
        y_cos_m = cy-(int)(Math.cos(RD_mi)*(size-10));
        y_sin_h = cy-(int)(Math.sin(RD_ho)*(size-30));
        y_cos_h = cy-(int)(Math.cos(RD_ho)*(size-30));
        g.drawLine(cx, cy, cx+y_sin_m-100, y_cos_m);
        g.drawLine(cx, cy, cx+y_sin_h-100, y_cos_h);
    }
}
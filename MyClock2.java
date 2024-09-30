//22D81011040E Miura Ryota 三浦僚太　2024年6月19日

import java.awt.*;
import java.util.Calendar;
import java.util.TimeZone;

public class MyClock2 extends MySuper implements Printable {
    private String country;

    public MyClock2(int cx, int cy, int radius, String country) {
        super(cx,cy,radius);
        this.country = country;
    }

    public void print(Graphics g) {
        g.drawString(country,cx-50,cy+120);
    }

    @Override
    public void draw(Graphics g) {
        Calendar cl = Calendar.getInstance();
        TimeZone tz = TimeZone.getTimeZone(country);
        cl.setTimeZone(tz);
        
        int x, y;
        for (int i=0;i<60;i++) {
            x=cx + (int)(radius*Math.cos(i*Math.PI/30));
            y=cy + (int)(radius*Math.sin(i*Math.PI/30));
            if (i%5==0){
                g.fillOval(x-5,y-5,10,10);
            }else{
                g.fillOval(x-2, y-2,4,4);
        	}
        }
        	g.fillOval(cx-5,cy-5,10,10);
        	double M_RD=2*Math.PI*cl.get(Calendar.MINUTE)/60;
        	double H_RD=2*Math.PI*cl.get(Calendar.HOUR)/12+M_RD/12;
        	g.drawLine(cx,cy,cx+(int)(69*Math.sin(M_RD)),cy-(int)(69*Math.cos(M_RD)));
        	g.drawLine(cx,cy,cx+(int)(45*Math.sin(H_RD)),cy-(int)(45*Math.cos(H_RD)));
    }
}


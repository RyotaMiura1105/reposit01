//22D81011040E Miura Ryota 三浦僚太　2024年6月19日

import java.awt.*;

public class MyPolygon2 extends MySuper {
    private int n;

    public MyPolygon2(int cx, int cy, int radius, int n) {
        super(cx, cy, radius);
        this.n = n;
    }

    public void draw(Graphics g) {
        int startX, startY, endX, endY;
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                startX = cx + (int)(radius * Math.cos(2 * Math.PI * i / n));
                startY = cy + (int)(radius * Math.sin(2 * Math.PI * i / n));
                endX   = cx + (int)(radius * Math.cos(2 * Math.PI * j / n));
                endY   = cy + (int)(radius * Math.sin(2 * Math.PI * j / n));
                g.drawLine(startX, startY, endX, endY);
            }
        }
    }
}


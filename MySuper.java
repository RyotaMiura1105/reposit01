//22D8103001C Kazumi Kase 加瀬風海 2024/06/19

import java.awt.Graphics;

public abstract class MySuper {
    public int cx;
    public int cy;
    public int radius;

    public MySuper(int cx, int cy, int radius) {
        this.cx = cx;
        this.cy = cy;
        this.radius = radius;
    }

    public abstract void draw(Graphics g);
}


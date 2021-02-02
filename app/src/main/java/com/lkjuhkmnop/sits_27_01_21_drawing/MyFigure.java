package com.lkjuhkmnop.sits_27_01_21_drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class MyFigure {
//    Figure's "center"
    private float fx, fy;
//    Main big circle
    private Circle cb;
//    Two small circles - right and left
//    right
    private Circle cr;
    //    left
    private Circle cl;
//    Figure's parts
    private Figure[] parts;

    //    paint
    private Paint paint = new Paint();

    public MyFigure(float x, float y) {
        this.fx = x;
        this.fy = y;
        cb = new Circle(x, y, 65);
        cr = new Circle((float) (cb.fx + (Math.sqrt(2) * cb.r / 2)), (float) (cb.fy - (Math.sqrt(2) * cb.r / 2)), cb.r / 2);
        cl = new Circle((float) (cb.fx - (Math.sqrt(2) * cb.r / 2)), (float) (cb.fy - (Math.sqrt(2) * cb.r / 2)), cb.r / 2);
        parts = new Figure[]{cb, cr, cl};
        paint.setColor(Color.MAGENTA);
        paint.setStyle(Paint.Style.FILL);
    }

    public void drawFigure(Canvas canvas) {
        for (Figure fig: parts) {
            fig.draw(canvas, paint);
        }
    }

    public boolean isFigureUnderXY(float tx, float ty) {
        if (cb.isUnderXY(tx, ty) || cr.isUnderXY(tx, ty) || cl.isUnderXY(tx, ty)) {
            return true;
        }
        return false;
    }

    public void moveToXY(float tx, float ty) {
        float vx = tx - this.fx;
        float vy = ty - this.fy;
        for (Figure fig: parts) {
            fig.moveVector(vx, vy);
        }
        this.fx = tx;
        this.fy = ty;
    }
}

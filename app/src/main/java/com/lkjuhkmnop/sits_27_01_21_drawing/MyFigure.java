package com.lkjuhkmnop.sits_27_01_21_drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class MyFigure {

    private float x = 100, y = 100, r = 60;
    private Paint p = new Paint();

    public MyFigure(float x, float y) {
        this.x = x;
        this.y = y;
        p.setColor(Color.MAGENTA);
        p.setStyle(Paint.Style.FILL);
    }

    public void setPos(float x, float y) {
        this.x = x;
        this.y = y;
    }

    protected void draw(Canvas canvas) {
        canvas.drawCircle(x, y, r, p);
        canvas.drawCircle(x+(2*r/3), y, r, p);
        canvas.drawCircle(x-(2*r/3), y, r, p);
        canvas.drawCircle(x, y+(2*r/3), r, p);
        canvas.drawCircle(x, y-(2*r/3), r, p);
    }
}

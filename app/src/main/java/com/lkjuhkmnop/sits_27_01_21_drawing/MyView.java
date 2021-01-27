package com.lkjuhkmnop.sits_27_01_21_drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MyView extends View {
    private List<MyFigure> figures = new ArrayList<MyFigure>();

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void createFig(float x, float y) {
        figures.set(figures.size(), new MyFigure(x, y));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (MyFigure fig: figures) {
            fig.draw(canvas);
        }
        invalidate();
    }

    public void moveFigures(float x, float y) {
    }
}

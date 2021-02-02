package com.lkjuhkmnop.sits_27_01_21_drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyView extends View {
    private ArrayList<MyFigure> figures = new ArrayList<MyFigure>();
    private MyFigure selectedFigure = null;

    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public void createFig(float x, float y) {
        figures.add(new MyFigure(x, y));
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (MyFigure fig: figures) {
            fig.drawFigure(canvas);
        }
        this.invalidate();
    }

    public MyFigure getFigureUnderXY(float tx, float ty) {
        for (MyFigure fig: figures) {
            if (fig.isFigureUnderXY(tx, ty)) {
                return fig;
            }
        }
        return null;
    }

    public void setSelectedFigure(MyFigure fig) {
        this.selectedFigure = fig;
    }

    public boolean haveSelectedFigure() {
        if (this.selectedFigure != null) {
            return true;
        }
        return false;
    }

    public void moveSelectedFigureToXY(float tx, float ty) {
        this.selectedFigure.moveToXY(tx, ty);
        this.selectedFigure = null;
    }
}

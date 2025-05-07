package com.example.mygrafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class Parabola extends View {
    private String a1;
    private String b1;
    private String c1;

    public Parabola(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Paint paint = new Paint();


        //параметры
        float x1 = -5;
        float x2 = 5;
        float step = 0.001f;
        float a = Float.parseFloat(this.getA1());
        float b = Float.parseFloat(this.getB1());
        float c = Float.parseFloat(this.getC1());

        //считаем масштаб
        float masX = (width/2-20)/Float.max(Math.abs(x1), Math.abs(x2));
        float masY = 0;
        for(float x = x1; x <= x2; x+= step) {
            float y = a*(x+b)*(x+b)+c;
            if(Math.abs(y) > masY) masY = Math.abs(y);
        }
        masY = (height/2-20)/masY;
        float mas = Float.min(masX, masY);

        //строим сетку
        paint.setStrokeWidth(3);
        paint.setColor(Color.GRAY);
        for(int x = 0; x < width/2; x+= mas) {
            canvas.drawLine(x + width/2, 0, x+width/2, height, paint);
        }
        for(int x = 0; x > -width/2; x -= mas) {
            canvas.drawLine(x+width/2, 0, x+width/2, height, paint);
        }
        for(int y = 0; y < height/2; y += mas) {
            canvas.drawLine(0, height/2-y, width, height/2-y, paint);
        }
        for(int y = 0; y > -height/2; y -= mas) {
            canvas.drawLine(0, height/2-y, width, height/2-y, paint);
        }

        //строим оси
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, height/2, width, height/2, paint);

        //строим график
        paint.setStrokeWidth(7);
        paint.setColor(Color.RED);
        for (float x = x1; x <= x2; x+= step) {
            float y = a*(x+b)*(x+b)+c;
            canvas.drawPoint(x*mas+width/2, height/2-y*mas, paint);
        }
    }

    public String getA1() {
        return a1;
    }
    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getB1() {
        return b1;
    }
    public void setB1(String b1) {
        this.b1 = b1;
    }

    public String getC1() {
        return c1;
    }
    public void setC1(String c1) {
        this.c1 = c1;
    }
}
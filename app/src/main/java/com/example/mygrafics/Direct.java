package com.example.mygrafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import androidx.annotation.NonNull;

public class Direct extends View {
    public Direct(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Paint paint = new Paint();
        //параметры
        float t1 = 0;
        float t2 = (float) (8*Math.PI);
        float step = 0.001f;

        //считаем масштаб
        float masX = 0;
        float masY = 0;
        for (float t = t1; t <= t2; t+=step) {
            float x = f(t).x;
            float y = f(t).y;
            if(Math.abs(x)>masX) masX = Math.abs(x);
            if(Math.abs(y)>masY) masY = Math.abs(y);
        }
        masX = (width/2-20)/masX;
        masY = (height/2-20)/masY;
        float mas = Float.min(masX, masY);

        paint.setStrokeWidth(2);
        paint.setColor(Color.GRAY);
        for (int x = 0; x < width/2; x+=mas) {
            canvas.drawLine(x+width/2, 0, x+width/2, height, paint);
        }
        for (int x = 0; x > -width/2; x-=mas) {
            canvas.drawLine(x+width/2, 0, x+width/2, height, paint);
        }
        for (int y = 0; y < height/2; y+=mas) {
            canvas.drawLine(0, height/2-y, width, height/2-y, paint);
        }
        for (int y = 0; y > -height/2; y-=mas) {
            canvas.drawLine(0, height/2-y, width, height/2-y, paint);
        }

        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, height/2, width, height/2, paint);

        paint.setStrokeWidth(7);
        paint.setColor(Color.BLUE);
        for (float t = t1; t <= t2; t+=step) {
            float x = f(t).x;
            float y = f(t).y;
            canvas.drawPoint(x*mas+width/2, height/2-y*mas, paint);
        }
    }

    Vector f(float t){
        double r = 2*t;
        Vector v = new Vector();
        v.x = (float) (r*Math.cos(t));
        v.y = (float) (r*Math.sin(t));
        return v;
    }
    class Vector {
        float x, y;
    }
}

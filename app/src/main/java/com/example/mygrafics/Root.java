package com.example.mygrafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

public class Root extends View {
    private String a2;
    private String b2;
    private String c2;

    public Root(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        drawFunction(canvas, getA2(), getB2(), getC2());
    }

    public static void drawFunction(@NonNull Canvas canvas, String a2, String b2, String c2) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Paint paint = new Paint();

        // параметры
        float x1 = Float.parseFloat(b2);
        float x2 = 5;
        float step = 5 / (width / 2 - 20);
        float a = Float.parseFloat(a2);
        float b = Float.parseFloat(b2);
        float c = Float.parseFloat(c2);

        // масштаб
        float masX = (width / 2 - 20) / Float.max(Math.abs(x1), Math.abs(x2));
        float masY = 0;
        for (float x = x1; x <= x2; x += step) {
            float y = a*(float) (Math.sqrt(x+b))+c;
            if (Math.abs(y) > masY) masY = Math.abs(y);
        }
        masY = (height / 2 - 20) / masY;
        float mas = Float.min(masX, masY);

        // строим сетку
        paint.setStrokeWidth(3);
        paint.setColor(Color.GRAY);
        for (int x = 0; x < width / 2; x += mas) {
            canvas.drawLine(x + width / 2, 0, x + width / 2, height, paint);
        }
        for (int x = 0; x > -width / 2; x -= mas) {
            canvas.drawLine(x + width / 2, 0, x + width / 2, height, paint);
        }
        for (int y = 0; y < height / 2; y += mas) {
            canvas.drawLine(0, height / 2 - y, width, height / 2 - y, paint);
        }
        for (int y = 0; y > -height / 2; y -= mas) {
            canvas.drawLine(0, height / 2 - y, width, height / 2 - y, paint);
        }

        // строим оси
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawLine(width / 2, 0, width / 2, height, paint);
        canvas.drawLine(0, height / 2, width, height / 2, paint);

        // строим график
        paint.setStrokeWidth(7);
        paint.setColor(Color.GREEN);
        float prevX = x1;
        float prevY = a*(float) (Math.sqrt(x1+b))+c;
        for (float x = x1 + step; x <= x2; x += step) {
            float y = a*(float) (Math.sqrt(x+b))+c;
            canvas.drawLine(
                    prevX * mas + width / 2,
                    height / 2 - prevY * mas,
                    x * mas + width / 2,
                    height / 2 - y * mas,
                    paint
            );
            prevX = x;
            prevY = y;
        }
    }

    public String getA2() {
        return a2;
    }
    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getB2() {
        return b2;
    }
    public void setB2(String b2) {
        this.b2 = b2;
    }

    public String getC2() {
        return c2;
    }
    public void setC2(String c2) {
        this.c2 = c2;
    }
}

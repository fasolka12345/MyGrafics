package com.example.mygrafics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

public class Direct extends View {
    private String k;
    private String b;

    public Direct(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        drawFunction(canvas, getK(), getB());
    }

    public static void drawFunction(@NonNull Canvas canvas, String k, String b) {
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Paint paint = new Paint();

        // Параметры диапазона
        float x1 = -5;
        float x2 = 5;
        float step = 5 / (width / 2 - 20);
        float koef = Float.parseFloat(k);
        float koefb = Float.parseFloat(b);

        // Вычисление масштаба
        float masX = (width / 2 - 20) / Float.max(Math.abs(x1), Math.abs(x2));
        float masY = 0;
        for (float x = x1; x <= x2; x += step) {
            float y = x * koef + koefb;
            if (Math.abs(y) > masY) masY = Math.abs(y);
        }
        masY = (height / 2 - 20) / masY;
        float mas = Float.min(masX, masY);

        // Построение сетки
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

        // Оси координат
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawLine(width / 2, 0, width / 2, height, paint);
        canvas.drawLine(0, height / 2, width, height / 2, paint);

        // Построение графика функциями (отрезками)
        paint.setStrokeWidth(7);
        paint.setColor(Color.BLUE);
        float prevX = x1;
        float prevY = x1 * koef + koefb;
        for (float x = x1 + step; x <= x2; x += step) {
            float y = x * koef + koefb;
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

    public String getK() {
        return k;
    }

    public void setK(String k) {
        this.k = k;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}

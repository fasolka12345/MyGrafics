package com.example.mygrafics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DirectYourself extends View {
    private Bitmap bitmap;
    private Canvas canvas;
    private Path path;
    private Paint drawPaint;
    private String k;
    private String b;

    public DirectYourself(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupDrawing();
    }

    private void setupDrawing() {
        path = new Path();   // Путь для рисования линий
        drawPaint = new Paint();
        drawPaint.setAntiAlias(true);      // Включаем сглаживание
        drawPaint.setDither(true);         // Включаем эффект дитеринга
        drawPaint.setColor(Color.BLUE);      // Цвет кисти красный
        drawPaint.setStyle(Paint.Style.STROKE); // Режим рисования — линия
        drawPaint.setStrokeJoin(Paint.Join.ROUND); // Тип соединения отрезков
        drawPaint.setStrokeCap(Paint.Cap.ROUND);  // Форма концов линии
        drawPaint.setStrokeWidth(8);       // Толщина линии
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888); // Создаем битмап нужного размера
        canvas = new Canvas(bitmap);                             // Канава для рисования
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Paint paint = new Paint();


        //параметры
        float x1 = -5;
        float x2 = 5;
        float step = 0.00001f;
        float koef = Float.parseFloat(this.getK());
        float koefb = Float.parseFloat(this.getB());

        //считаем масштаб
        float masX = (width/2-20)/Float.max(Math.abs(x1), Math.abs(x2));
        float masY = 0;
        for(float x = x1; x <= x2; x+= step) {
            float y = x*koef + koefb;
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
        canvas.drawLine(0, height/2, width, height/2, paint);    // Рисуем фон
        canvas.drawPath(path, drawPaint);                            // Отображаем нарисованные пути
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();                                 // Получаем координату Х
        float touchY = event.getY();                                 // Получаем координату Y

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);                         // Начало движения
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);                         // Продолжение линии
                break;
            default:
                return false;
        }

        invalidate();                                                // Обновляем изображение
        return true;
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
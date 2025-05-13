package com.example.mygrafics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RootYourself extends View {
    private Bitmap bitmap;
    private Canvas canvas;
    private static Path path = new Path();
    private Paint drawPaint;
    private String a2;
    private String b2;
    private String c2;

    private static boolean showFunction = false;

    public RootYourself(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setupDrawing();
    }

    private void setupDrawing() {
        drawPaint = new Paint();
        drawPaint.setAntiAlias(true);
        drawPaint.setDither(true);
        drawPaint.setColor(Color.MAGENTA);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
        drawPaint.setStrokeWidth(8);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = canvas.getWidth();
        float height = canvas.getHeight();
        Paint paint = new Paint();


        //параметры
        float x1 = Float.parseFloat(b2);
        float x2 = 5;
        float step = 5 / (width / 2 - 20);
        float a = Float.parseFloat(this.getA2());
        float b = Float.parseFloat(this.getB2());
        float c = Float.parseFloat(this.getC2());

        //считаем масштаб
        float masX = (width/2-20)/Float.max(Math.abs(x2), Math.abs(x2));
        float masY = 0;
        for(float x = x1; x <= x2; x+= step) {
            float y = a*(float) (Math.sqrt(x+b))+c;
            if(Math.abs(y) > masY) masY = Math.abs(y);
        }
        masY = (height/2-20)/masY;
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


        //строим оси
        paint.setStrokeWidth(5);
        paint.setColor(Color.BLACK);
        canvas.drawLine(width/2, 0, width/2, height, paint);
        canvas.drawLine(0, height/2, width, height/2, paint);

        canvas.drawPath(path, drawPaint);

        if (showFunction) {
            Root.drawFunction(canvas, a2, b2, c2);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float touchX = event.getX();
        float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            default:
                return false;
        }

        invalidate();
        return true;
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
    public void showFunction() {
        showFunction = true;
    }

    public Path getPath() {
        return path;
    }
}
package com.example.stepappv4.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CaloryIntake extends View {
    private Paint circlePaint;
    private Paint textPaint;
    private String labelText = "吃吃吃";

    public CaloryIntake(Context context) {
        super(context);
        init(null, 0);
    }

    public CaloryIntake(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CaloryIntake(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // 初始化画笔
        circlePaint = new Paint();
        circlePaint.setColor(Color.parseColor("#EADDFF")); // 设置圆的颜色
        circlePaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(Color.WHITE); // 设置文本的颜色
        textPaint.setTextSize(50); // 设置文本的大小
        textPaint.setAntiAlias(true);
        textPaint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 绘制圆
        float radius = Math.min(getWidth(), getHeight()) / 2;
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, circlePaint);

        // 绘制文本
        canvas.drawText(labelText, getWidth() / 2, (getHeight() / 2) - ((textPaint.descent() + textPaint.ascent()) / 2), textPaint);
    }

    public void setLabelText(String text) {
        labelText = text;
        invalidate();
        requestLayout();
    }
}

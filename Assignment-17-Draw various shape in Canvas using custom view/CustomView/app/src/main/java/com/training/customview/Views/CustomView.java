package com.training.customview.Views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class CustomView extends View {
    private static final int SQUARE_SIZE=100;
    private Rect rect1;
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    float cx,cy;
    float radius=100f;
    Path path1;
    public float x1,y1,x2,y2;
    public float width=100;
    public float hw;
    public float x=130;
    public float y=80+SQUARE_SIZE+80;


    public CustomView(Context context) {
        super(context);
        init(null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomView(Context context, @Nullable  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomView(Context context, @Nullable  AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
    private void init(AttributeSet set){
        rect1=new Rect();
        paint1=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint2=new Paint(Paint.ANTI_ALIAS_FLAG);
        paint3=new Paint(Paint.ANTI_ALIAS_FLAG);
        path1=new Path();
        paint1.setColor(Color.GREEN);
        paint2.setColor(Color.CYAN);
        paint3.setColor(Color.BLACK);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
         rect1.left=80;
        rect1.top=80;
        rect1.right=80+SQUARE_SIZE;
        rect1.bottom=80+SQUARE_SIZE;
        canvas.drawRect(rect1, paint1);
       //circle
        cx=rect1.right+50+radius;
        cy=rect1.top+SQUARE_SIZE/2;
        canvas.drawCircle(cx,cy,radius,paint2);
        // line
       x1=cx+radius+50;
        y1=cy;
        x2=x1+100;
       y2=cy;
        canvas.drawLine(x1,y1,x2,y2,paint3);
        //triangle
        hw=width/2;
        Path linePath=new Path();
        linePath.moveTo(x,y-hw);
        linePath.lineTo(x-hw,y+hw);
        linePath.lineTo(x+hw,y+hw);
        linePath.lineTo(x,y-hw);
        linePath.close();
        canvas.drawPath(linePath,paint1);

    }
    public void swapColor(){
        paint1.setColor(paint1.getColor()==Color.GREEN?Color.RED:Color.GREEN);
        postInvalidate();
    }

}

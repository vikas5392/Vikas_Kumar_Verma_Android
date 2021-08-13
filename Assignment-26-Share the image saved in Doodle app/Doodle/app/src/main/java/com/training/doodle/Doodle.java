package com.training.doodle;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class Doodle extends View {

    Bitmap m_bitmap;
    Canvas m_canvas;
    Paint m_paint;
    ViewGroup.LayoutParams m_params;
    Path m_path;
    Paint mBitmapPaint;

    public Doodle(Context context,AttributeSet attrs) {
        super(context,attrs);
        init(null);
        m_paint.setAntiAlias(true);
        m_paint.setColor(Color.CYAN);
        m_paint.setStyle(Paint.Style.STROKE);
        m_paint.setStrokeJoin(Paint.Join.ROUND);
        m_paint.setStrokeWidth(8f);
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    }

    public Doodle(Context context) {
        super(context);
      init(null);
    }

    private void init(AttributeSet set){
        m_paint=new Paint();
        m_path=new Path();
        m_params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        m_bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        m_canvas = new Canvas(m_bitmap);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float pointX=event.getX();
        float pointY=event.getY();
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:m_path.moveTo(pointX,pointY);
            return true;
            case MotionEvent.ACTION_MOVE:m_path.lineTo(pointX,pointY);
            break;
            default:
                return false;
        }
        postInvalidate();
        return false;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap( m_bitmap, 0, 0, mBitmapPaint);
        canvas.drawPath( m_path,  m_paint);
    }
    public Bitmap loadBitmapFromView(View v) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        v.measure(View.MeasureSpec.makeMeasureSpec(dm.widthPixels,
                View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(dm.heightPixels,
                        View.MeasureSpec.EXACTLY));
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        Bitmap returnedBitmap =
                Bitmap.createBitmap(v.getMeasuredWidth(),
                        v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(returnedBitmap);
        v.draw(c);

        return returnedBitmap;
    }

}


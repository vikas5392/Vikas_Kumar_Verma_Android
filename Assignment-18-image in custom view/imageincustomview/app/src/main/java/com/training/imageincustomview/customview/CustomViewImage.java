package com.training.imageincustomview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.training.imageincustomview.R;

import java.io.ByteArrayInputStream;

public class CustomViewImage extends View {
    private Bitmap imageBitMap;
    Rect srcRect, dstRect;
    int bitmapWidth;
    int bitmapHeight;

    public CustomViewImage(Context context) {
        super(context);
        init(null);
    }

    public CustomViewImage(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public CustomViewImage(Context context, @Nullable  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomViewImage(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }
public void init(AttributeSet set){

    imageBitMap=BitmapFactory.decodeResource(getResources(), R.drawable.image);
}
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        bitmapWidth = imageBitMap.getWidth();
        bitmapHeight = imageBitMap.getHeight();

        srcRect = new Rect(0, 0, bitmapWidth, bitmapHeight);//size of bitmap

        dstRect = new Rect(0,0,getWidth(),getHeight());//size of the custom view

        canvas.drawBitmap(imageBitMap, srcRect, dstRect, null);//scale bitmap from src to dst
    }
}

package com.training.imageincustomview.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import com.training.imageincustomview.R;
public class CustomViewImage extends View {
    private Bitmap imageBitMap;
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
canvas.drawBitmap(imageBitMap,20,20,null);
    }
}

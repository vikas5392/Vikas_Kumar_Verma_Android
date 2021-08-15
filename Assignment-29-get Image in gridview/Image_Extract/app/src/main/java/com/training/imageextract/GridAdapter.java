package com.training.imageextract;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
    ArrayList<Uri> imageUriList;
    Context context;

    public GridAdapter(ArrayList<Uri> imageUriList, Context context) {
        this.imageUriList = imageUriList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageUriList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageUriList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View singleFrameView= inflater.inflate(R.layout.single_frame,parent,false);
       ImageView image=singleFrameView.findViewById(R.id.imageView);
       image.setImageURI(imageUriList.get(position));
       return singleFrameView;

    }
}

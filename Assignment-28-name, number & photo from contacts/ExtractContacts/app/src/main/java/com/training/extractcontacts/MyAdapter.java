package com.training.extractcontacts;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    ArrayList<DataModel> list;

    public MyAdapter(ArrayList<DataModel> list) {
        this.list = list;
    }

    public class Holder extends RecyclerView.ViewHolder{
        TextView nameTextView,numberTextView;
        ImageView imageV;
        public Holder(@NonNull  View itemView) {
            super(itemView);
            nameTextView=itemView.findViewById(R.id.nameTextView);
            numberTextView=itemView.findViewById(R.id.numberTextView);
            imageV=itemView.findViewById(R.id.imageView);

        }
    }

    @NonNull

    @Override
    public Holder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
       View  Rowview=inflater.inflate(R.layout.single_row,parent,false);

        return new Holder(Rowview);
    }

    @Override
    public void onBindViewHolder(@NonNull  Holder holder, int position) {
        holder.numberTextView.setText(list.get(position).getNumber());
        holder.nameTextView.setText(list.get(position).getName());
        holder.imageV.setImageURI(list.get(position).getImageUri());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

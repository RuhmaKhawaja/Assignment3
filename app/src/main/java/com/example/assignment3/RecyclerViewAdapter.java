package com.example.assignment3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.security.AccessControlContext;
import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>
{

    //Context mContext;
    private ArrayList<Contact> mData;

    public RecyclerViewAdapter(ArrayList<Contact> Data)
    {
        this.mData = Data;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v;
        v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        MyViewHolder vHolder=new MyViewHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        String n= mData.get(position).getName();
        int im=mData.get(position).getImg();
        holder.setData(n,im);
        // holder.Cname.setText(mData.get(position).getName());
        // holder.image.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount()
    {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView Cname;
        private ImageView image;


        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            Cname=(TextView)itemView.findViewById(R.id.contact);
            image=(ImageView)itemView.findViewById(R.id.img_contact);
        }

        public void setData(String cn, int im)
        {
            Cname.setText(cn);
            image.setImageResource(im);
        }
    }
}

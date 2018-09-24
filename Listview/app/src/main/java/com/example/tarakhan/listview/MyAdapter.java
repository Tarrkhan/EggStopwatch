package com.example.tarakhan.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by tArAkHaN on 13-04-2018.
 */

public class MyAdapter extends BaseAdapter {
    Context context;
    ArrayList<Modal> modalArrayList;
    LayoutInflater inflater;

    public MyAdapter(Context context, ArrayList<Modal> modalArrayList) {
        this.context = context;
        this.modalArrayList = modalArrayList;
    }

    @Override
    public int getCount() {
        return modalArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return modalArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.item,viewGroup,false);
        TextView txtname = (TextView)view.findViewById(R.id.txtname);
        TextView txtdetail = (TextView)view.findViewById(R.id.txtdetail);
        ImageView imageView = (ImageView)view.findViewById(R.id.img);

        Modal modal = modalArrayList.get(i);
        txtname.setText(modal.getName());
        txtdetail.setText(modal.getDetails());
        imageView.setImageResource(modal.getImage());
        return view;
    }
}

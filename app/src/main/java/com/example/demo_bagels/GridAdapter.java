package com.example.demo_bagels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class GridAdapter extends BaseAdapter {

    private int icons[];

    private String bagels[];

    private Context context;

    private LayoutInflater inflater;



    public GridAdapter(Context context, int icons[], String bagels[]){

        this.context = context;
        this.icons = icons;
        this.bagels = bagels;


    }

    @Override
    public int getCount() {
        return bagels.length;
    }

    @Override
    public Object getItem(int position) {
        return bagels[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View gridView = convertView;

        if (convertView == null) {

            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.custom_layout, null);

        }

        ImageView icon = (ImageView) gridView.findViewById(R.id.icons);
        ToggleButton toggle = (ToggleButton) gridView.findViewById(R.id.toggle);
        TextView bagel = (TextView) gridView.findViewById(R.id.bagels);


        icon.setImageResource(icons[position]);
        bagel.setText(bagels[position]);



        return gridView;
    }



}

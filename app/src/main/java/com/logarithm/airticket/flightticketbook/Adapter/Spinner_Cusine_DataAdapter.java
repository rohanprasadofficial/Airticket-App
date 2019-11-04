package com.logarithm.airticket.flightticketbook.Adapter;

/**
 * Created by Wolf Soft on 2/1/2017.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.R;

import java.util.ArrayList;



public class Spinner_Cusine_DataAdapter  extends BaseAdapter {

private Context context;
private ArrayList<ItemData_Cusine> listPojo;

public Spinner_Cusine_DataAdapter(Context context, ArrayList<ItemData_Cusine> listPojo) {
        super();
        this.context = context;
        this.listPojo = listPojo;

        }

@Override
public int getCount() {
        // TODO Auto-generated method stub
        return listPojo.size();
        }

@Override
public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listPojo.get(position);
        }

@Override
public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        MyViewHolder holder = null;

        if (convertView == null) {

        LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        convertView = inflater.inflate(
        R.layout.spinner_list_cusine, null);

        holder = new MyViewHolder();
        holder.textView = (TextView) convertView.findViewById(R.id.data);
        holder.imageView =  (ImageView) convertView.findViewById(R.id.image);

        convertView.setTag(holder);

        } else {

        holder = (MyViewHolder) convertView.getTag();
        }

        ItemData_Cusine rowItem = (ItemData_Cusine) getItem(position);
        holder.textView.setText(rowItem.getText());
        holder.imageView.setImageResource(rowItem.getImage());


        return convertView;
        }

class MyViewHolder {


    private ImageView imageView;
    private TextView textView;



}


}


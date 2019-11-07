package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.Message;

import java.util.List;


public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.MyViewHolder> {

    List<Message> tripList;
    AlertDialog alertDialog = null;
    Context context;
    public FlightAdapter(Context context, List<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.Message> tripList) {
        this.context = context;
        this.tripList = tripList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
          // set the data in items
        holder.name.setText(tripList.get(position).getName());
        holder.flightid.setText(tripList.get(position).getFlightID());
        holder.flightnumber.setText(tripList.get(position).getFlightNumber());
        // implement setOnClickListener event on item view.
    }

    @Override
    public int getItemCount() {
        return tripList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name,flightnumber,flightid;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.name);
            flightnumber = (TextView) itemView.findViewById(R.id.flightnumber);
            flightid = (TextView) itemView.findViewById(R.id.flightID);

        }
    }
}
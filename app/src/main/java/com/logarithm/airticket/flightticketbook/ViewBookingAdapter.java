package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.Message;
import java.util.List;


public class ViewBookingAdapter extends RecyclerView.Adapter<ViewBookingAdapter.MyViewHolder> {

    List<Message> tripList;
    AlertDialog alertDialog = null;
    Context context;
    public ViewBookingAdapter(Context context, List<com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.Message> tripList) {
        this.context = context;
        this.tripList = tripList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.bookinglayout, parent, false);
// set the view's size, margins, paddings and layout parameters
        MyViewHolder vh = new MyViewHolder(v); // pass the view to View Holder
        return vh;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
          // set the data in items
        try {
            Message flight = tripList.get(position);
              holder.from.setText(flight.getFrom());
            holder.to.setText(flight.getTo());
            holder.date.setText(flight.getDepartDate());
            holder.time.setText(flight.getSourceTime());
            holder.travelType.setText(flight.getTravelType());
            holder.passengername.setText(flight.getPassengerName());
            holder.FlightNumber.setText(flight.getFlightNumber());
            holder.FlicketName.setText(flight.getFlicketName());
            holder.flightId.setText(flight.getFlightId());
            holder.bookingDate.setText(flight.getDate());
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
        // implement setOnClickListener event on item view.
    }
    @Override
    public int getItemCount() {
        return tripList.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView from,to,date,time,travelType,passengername,FlightNumber,FlicketName,flightId,bookingDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            try {
                // get the reference of item view's
               from = itemView.findViewById(R.id.from);
                to = itemView.findViewById(R.id.to);
                date = itemView.findViewById(R.id.date);
                time = itemView.findViewById(R.id.time);
                travelType = itemView.findViewById(R.id.travelType);
                passengername = itemView.findViewById(R.id.passengername);
                FlightNumber = itemView.findViewById(R.id.FlightNumber);
                FlicketName = itemView.findViewById(R.id.FlicketName);
                flightId = itemView.findViewById(R.id.flightId);
                bookingDate = itemView.findViewById(R.id.bookingDate);
            }catch (Exception e)
            {
                e.printStackTrace();
            }

        }

    }
}
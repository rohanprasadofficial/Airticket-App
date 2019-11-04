package com.logarithm.airticket.flightticketbook.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.ModelClass.Flight;
import com.logarithm.airticket.flightticketbook.R;

import java.util.List;

/**
 * Created by KURPC on 03-02-2018.
 */

public class FlightAdapter extends RecyclerView.Adapter<FlightAdapter.FlightViewHolder> {

    private LinearLayout lia;


    private Context mCtx;
    private List<Flight>productList;

    @Override
    public FlightViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.activity_flight_list,null);
        return new FlightViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FlightViewHolder holder, int position) {

        Flight flight =productList.get(position);

        holder.txtFlightName.setText(String.valueOf(flight.getTxtFlightName()));
        holder.txtCountry.setText(String.valueOf(flight.getTxtCountry()));
        holder.txtStationArrived.setText(String.valueOf(flight.getTxtStationArrived()));
        holder.txtCountryDestination.setText(String.valueOf(flight.getTxtCountryDestination()));
        holder.txtStationDestination.setText(String.valueOf(flight.getTxtStationDestination()));
        holder.btnBuy.setText(String.valueOf(flight.getBtnBuy()));
        holder.imgPlane.setImageDrawable(mCtx.getResources().getDrawable(flight.getImgPlane()));


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class FlightViewHolder extends RecyclerView.ViewHolder{

        ImageView imgPlane;
        TextView txtFlightName,txtCountry,txtStationArrived,txtCountryDestination,txtStationDestination,btnBuy;

        public FlightViewHolder(View itemView) {
            super(itemView);


            txtFlightName = itemView.findViewById(R.id.txtFlightName);
            txtCountry = itemView.findViewById(R.id.txtCountry);
            txtStationArrived = itemView.findViewById(R.id.txtStationArrived);
            txtCountryDestination = itemView.findViewById(R.id.txtCountryDestination);
            txtFlightName = itemView.findViewById(R.id.txtFlightName);
            txtStationDestination = itemView.findViewById(R.id.txtStationDestination);
            btnBuy = itemView.findViewById(R.id.btnBuy);
            imgPlane = itemView.findViewById(R.id.imgPlane);

        }
    }
}

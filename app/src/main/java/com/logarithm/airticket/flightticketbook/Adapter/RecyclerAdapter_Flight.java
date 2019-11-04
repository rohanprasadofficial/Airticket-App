package com.logarithm.airticket.flightticketbook.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.ModelClass.Flight;
import com.logarithm.airticket.flightticketbook.R;
import com.logarithm.airticket.flightticketbook.RestAPI.ConfirmTicketActivity;

import java.util.List;

/**
 * Created by KURPC on 05-02-2018.
 */

public class RecyclerAdapter_Flight extends RecyclerView.Adapter<RecyclerAdapter_Flight.MyViewHolder> {


    private TextView txt;

    boolean showingFirst = true;

    private List<Flight> moviesList;
    Context mContext;

    ImageView NormalImageView;
    Bitmap ImageBit;
    float ImageRadius = 40.0f;




    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView imgPlane;
        TextView txtFlightName,txtCountry,txtStationArrived,txtCountryDestination,txtStationDestination,btnBuy;
        LinearLayout linear;


        public MyViewHolder(View view) {
            super(view);


            linear = itemView.findViewById(R.id.linear);
            txtFlightName = itemView.findViewById(R.id.txtFlightName);
            txtCountry = itemView.findViewById(R.id.txtCountry);
            txtStationArrived = itemView.findViewById(R.id.txtStationArrived);
            txtCountryDestination = itemView.findViewById(R.id.txtCountryDestination);
            txtStationDestination = itemView.findViewById(R.id.txtStationDestination);
            btnBuy = itemView.findViewById(R.id.btnBuy);
            imgPlane = itemView.findViewById(R.id.imgPlane);


        }

    }



    public RecyclerAdapter_Flight(Context mContext, List<Flight> moviesList) {
        this.moviesList = moviesList;
        this.mContext = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_flight_list, parent, false);

        return new MyViewHolder(itemView);

    }




    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position)
    {

        Flight movie = moviesList.get(position);
        holder.txtFlightName.setText(movie.getTxtFlightName());
        holder.txtCountry.setText(movie.getTxtCountry());
        holder.txtStationArrived.setText(movie.getTxtStationArrived());
        holder.txtCountryDestination.setText(movie.getTxtCountryDestination());
        holder.txtStationDestination.setText(movie.getTxtStationDestination());
        holder.btnBuy.setText(movie.getBtnBuy());
        holder.imgPlane.setImageResource(movie.getImgPlane());
        holder.btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, ConfirmTicketActivity.class);
                mContext.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }






}



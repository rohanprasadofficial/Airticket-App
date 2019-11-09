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

import com.logarithm.airticket.flightticketbook.ConfirmTicketActivity;
import com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.Message;
import com.logarithm.airticket.flightticketbook.ModelClass.Flight;
import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;
import com.logarithm.airticket.flightticketbook.R;

import java.util.List;

/**
 * Created by KURPC on 05-02-2018.
 */

public class RecyclerAdapter_Flight extends RecyclerView.Adapter<RecyclerAdapter_Flight.MyViewHolder> {


    private TextView txt;

    boolean showingFirst = true;


    private List<RecyclerMessage> moviesList;
    Context mContext;

    ImageView NormalImageView;
    Bitmap ImageBit;
    float ImageRadius = 40.0f;




    public class MyViewHolder extends RecyclerView.ViewHolder {


        ImageView imgPlane;
        TextView txtFlightName,txtCountry,txtStationArrived,txtCountryDestination,txtStationDestination,btnBuy;
        LinearLayout linear;
        TextView txtTimeArrived,txtTimeDestination,txtDateArrived,txtDateDestination;

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
            txtTimeArrived =itemView.findViewById(R.id.txtTimeArrived);
            txtTimeDestination =itemView.findViewById(R.id.txtTimeDestination);
            txtDateArrived =itemView.findViewById(R.id.txtDateArrived);
            txtDateDestination =itemView.findViewById(R.id.txtDateDestination);

        }

    }



    public RecyclerAdapter_Flight(Context mContext, List<RecyclerMessage> moviesList) {
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

        RecyclerMessage movie = moviesList.get(position);
        holder.txtFlightName.setText(movie.getName());
        holder.txtCountry.setText(movie.getSource());
        holder.txtStationArrived.setText(movie.getDestination());
        holder.txtCountryDestination.setText(movie.getDestination());
        holder.txtStationDestination.setText(movie.getDestination());
        holder.btnBuy.setText("Book this Trip");
        holder.imgPlane.setImageResource(R.drawable.ic_blackplane);
        holder.txtDateArrived.setText(movie.getSourceDate());
        holder.txtDateDestination.setText(movie.getDestDate());
        holder.txtTimeArrived.setText(movie.getSourceTime());
        holder.txtTimeDestination.setText(movie.getDestTime());


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



package com.logarithm.airticket.flightticketbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.Adapter.RecyclerAdapter_Flight;
import com.logarithm.airticket.flightticketbook.ModelClass.Flight;

import java.util.ArrayList;

public class FlightListActivity extends AppCompatActivity {

    private TextView txt;

//    RecyclerView recyclerView;
//    FlightAdapter adapter;
//
//    List<Flight>productlist;

    private String txtFlightName  []= {"AIRFRANCE ","Emirates","AIRFRANCE"};
    private String txtCountry []={"Paris","Paris","AIRFRANCE"};
    private String txtStationArrived []={"New York","New York","AIRFRANCE"};
    private int imgPlane []={R.drawable.ic_blackplane,R.drawable.ic_blackplane,R.drawable.ic_blackplane};
    private String txtCountryDestination []={"CDG","CDG","CDG"};
    private String txtStationDestination []={"JFK","JFK","JFK"};
    private String btnBuy []={"Buy","Buy","Buy"};


    private ArrayList<Flight> flights;

    private RecyclerView recyclerView;
    private RecyclerAdapter_Flight mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flight_list_view);



        flights = new ArrayList<>();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerview);


        for (int i = 0; i < txtFlightName.length; i++) {
            Flight beanClassForRecyclerView_contacts = new Flight(txtFlightName[i],txtCountry[i],txtStationArrived[i],imgPlane[i],
                    txtCountryDestination[i],txtStationDestination[i],btnBuy[i]);
            flights.add(beanClassForRecyclerView_contacts);
        }




        mAdapter = new RecyclerAdapter_Flight(FlightListActivity.this,flights);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(FlightListActivity.this);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(mAdapter);



    }
}

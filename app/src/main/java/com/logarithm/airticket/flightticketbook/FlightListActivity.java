package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.Adapter.RecyclerAdapter_Flight;
import com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.Message;
import com.logarithm.airticket.flightticketbook.ModelClass.Flight;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.logarithm.airticket.flightticketbook.LoginAdmin.TOKEN_ID_ADMIN;

public class FlightListActivity extends AppCompatActivity {

    private TextView txt;

//    RecyclerView recyclerView;
//    FlightAdapter adapter;
//    List<Flight>productlist;



    public String Source,Destination;
    public AlertDialog alertDialog = null;
    List<Message> tripList;


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
        Source=getIntent().getStringExtra("FROM");
        Destination=getIntent().getStringExtra("TO");

        try {
            // call the constructor of CustomAdapter to send the reference and data to Adapter
            alertDialog = new SpotsDialog.Builder().setContext(FlightListActivity.this).setTheme(R.style.Custom).build();
            alertDialog.setMessage("Getting flights info..");
            alertDialog.show();
            final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
            Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight> call2 = apiService.getAllflights(TOKEN_ID_ADMIN);
            call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight>() {
                @Override

                public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight> response) {
                    try {
                        alertDialog.dismiss();
                        Log.i("JSON", response.body().getSuccess().toString());
                        if (response.body().getSuccess()) {
                            alertDialog.dismiss();
                            tripList = response.body().getMessage();
                            if (tripList.size() == 0) {
                                Toast.makeText(FlightListActivity.this, "No Flights Available !", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(FlightListActivity.this, tripList.get(0).getName(), Toast.LENGTH_SHORT).show();
                            }


                        } else {
                            Log.i("TEST", response.body().getMessage().toString());
                        }
                    } catch (Exception e) {
                        alertDialog.dismiss();
                        Toast.makeText(FlightListActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight> call, Throwable t) {
                    alertDialog.dismiss();
                    Toast.makeText(FlightListActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });


        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


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

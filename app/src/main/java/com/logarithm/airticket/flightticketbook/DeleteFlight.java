package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.Message;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;
import com.logarithm.airticket.flightticketbook.utils.MyRecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.logarithm.airticket.flightticketbook.LoginAdmin.TOKEN_ID_ADMIN;


public class DeleteFlight extends AppCompatActivity {

    public AlertDialog alertDialog = null;
    RecyclerView recyclerView;
    List<Message> tripList;
    //    static View.OnClickListener myOnClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_flight);
        // get the reference of RecyclerView
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        // set a LinearLayoutManager with default vertical orientaion
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerVie

        recyclerView.addOnItemTouchListener(
                new MyRecyclerItemClickListener(getApplicationContext(), new MyRecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, final int position) {

                        Toast.makeText(DeleteFlight.this, tripList.get(position).getName(), Toast.LENGTH_SHORT).show();
                        Log.i("Ds",tripList.get(position).getName());

                        try {
                            alertDialog = new SpotsDialog.Builder().setContext(DeleteFlight.this).setTheme(R.style.Custom).build();
                            alertDialog.setMessage("Deleting Flight.. ");
                            alertDialog.show();

                            final APIInterface apiService = APIClient.getClient().create(APIInterface.class);

                            com.logarithm.airticket.flightticketbook.ParametersClass.DeleteFlight deleteFlight = new com.logarithm.airticket.flightticketbook.ParametersClass.DeleteFlight(tripList.get(position).getName(), tripList.get(position).getFlightNumber(), tripList.get(position).getFlightID());

                            Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call2 = apiService.deleteFlight(TOKEN_ID_ADMIN, deleteFlight);
                            call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.Response>() {
                                @Override
                                public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.Response> response) {
                                    try {
                                        alertDialog.dismiss();
                                        if (response.body().getSuccess()) {
                                            Toast.makeText(DeleteFlight.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                            finish();
                                        } else {
                                            Toast.makeText(DeleteFlight.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                        }

                                    } catch (Exception e) {
                                        alertDialog.dismiss();
                                        Toast.makeText(DeleteFlight.this, "Something Went Wrong-1 ", Toast.LENGTH_SHORT).show();
                                        e.printStackTrace();

                                    }
                                }

                                @Override
                                public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Throwable t) {
                                    alertDialog.dismiss();
                                    t.printStackTrace();
                                    Toast.makeText(DeleteFlight.this, "Something Went Wrong -2", Toast.LENGTH_SHORT).show();
                                }


                            });


                        }catch (Exception e)

                        {
                            e.printStackTrace();
                        }

                    }
                })
        );



        // call the constructor of CustomAdapter to send the reference and data to Adapter
        alertDialog = new SpotsDialog.Builder().setContext(DeleteFlight.this).setTheme(R.style.Custom).build();
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
                        if(tripList.size()==0)
                        {
                            Toast.makeText(DeleteFlight.this, "No Flights Available !", Toast.LENGTH_SHORT).show();
                        }
                        FlightAdapter customAdapter = new FlightAdapter(DeleteFlight.this, response.body().getMessage());
                        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


                    } else {
                        Log.i("TEST", response.body().getMessage().toString());
                    }
                } catch (Exception e) {
                    alertDialog.dismiss();
                    Toast.makeText(DeleteFlight.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();

                }
            }

            @Override
            public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteFlight.DeleteFlight> call, Throwable t) {
                alertDialog.dismiss();
                Toast.makeText(DeleteFlight.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
            }
        });


    }
}

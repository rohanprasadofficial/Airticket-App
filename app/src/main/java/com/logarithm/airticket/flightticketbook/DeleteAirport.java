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


public class DeleteAirport extends AppCompatActivity {

    public AlertDialog alertDialog = null;
    RecyclerView recyclerView;
    List<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.Message> tripList2;
    //    static View.OnClickListener myOnClickListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_airport);
        try {
            // get the reference of RecyclerView
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            // set a LinearLayoutManager with default vertical orientaion
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerVie

            recyclerView.addOnItemTouchListener(
                    new MyRecyclerItemClickListener(getApplicationContext(), new MyRecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, final int position) {

                            Toast.makeText(DeleteAirport.this, tripList2.get(position).getName(), Toast.LENGTH_SHORT).show();
                            Log.i("Ds", tripList2.get(position).getName());

                            try {
                                alertDialog = new SpotsDialog.Builder().setContext(DeleteAirport.this).setTheme(R.style.Custom).build();
                                alertDialog.setMessage("Deleting Airport.. ");
                                alertDialog.show();

                                final APIInterface apiService = APIClient.getClient().create(APIInterface.class);

                                com.logarithm.airticket.flightticketbook.ParametersClass.DeleteAirport deleteAirport = new com.logarithm.airticket.flightticketbook.ParametersClass.DeleteAirport(tripList2.get(position).getName());

                                Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call2 = apiService.deleteAirport(TOKEN_ID_ADMIN, deleteAirport);
                                call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.Response>() {
                                    @Override
                                    public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.Response> response) {
                                        try {
                                            alertDialog.dismiss();
                                            if (response.body().getSuccess()) {
                                                Toast.makeText(DeleteAirport.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                finish();
                                            } else {
                                                Toast.makeText(DeleteAirport.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                            }

                                        } catch (Exception e) {
                                            alertDialog.dismiss();
                                            Toast.makeText(DeleteAirport.this, "Something Went Wrong-1 ", Toast.LENGTH_SHORT).show();
                                            e.printStackTrace();

                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Throwable t) {
                                        alertDialog.dismiss();
                                        t.printStackTrace();
                                        Toast.makeText(DeleteAirport.this, "Something Went Wrong -2", Toast.LENGTH_SHORT).show();
                                    }


                                });


                            } catch (Exception e) {
                                e.printStackTrace();
                            }

                        }
                    })
            );

            // call the constructor of CustomAdapter to send the reference and data to Adapter
            alertDialog = new SpotsDialog.Builder().setContext(DeleteAirport.this).setTheme(R.style.Custom).build();
            alertDialog.setMessage("Getting Airports info..");
            alertDialog.show();
            final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
            Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> call2 = apiService.getAllAirports(TOKEN_ID_ADMIN);
            call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport>() {
                @Override

                public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> response) {
                    try {
                        alertDialog.dismiss();
                        Log.i("JSON", response.body().getSuccess().toString());
                        if (response.body().getSuccess()) {
                            alertDialog.dismiss();
                            tripList2 = response.body().getMessage();
                            if (tripList2.size() == 0) {
                                Toast.makeText(DeleteAirport.this, "No Flights Available !", Toast.LENGTH_SHORT).show();
                            }
                            AirportAdapter customAdapter = new AirportAdapter(DeleteAirport.this, response.body().getMessage());
                            recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


                        } else {
                            Log.i("TEST", response.body().getMessage().toString());
                        }
                    } catch (Exception e) {
                        alertDialog.dismiss();
                        Toast.makeText(DeleteAirport.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> call, Throwable t) {
                    alertDialog.dismiss();
                    Toast.makeText(DeleteAirport.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }

    }
}

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
        recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerView

//
//        recyclerView.addOnItemTouchListener(
//                new MyRecyclerItemClickListener(getApplicationContext(), new MyRecyclerItemClickListener.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(View view, final int position) {
//
//                        alertDialog = new SpotsDialog.Builder().setContext(Trips.this).setTheme(R.style.Custom).build();
//                        alertDialog.setMessage("Verifying passport.. ");
//                        alertDialog.show();
//
//                        final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
//                        InitiatorAppData initiatorAppData=new InitiatorAppData(tripList.get(position).getTripId());
//                        List<Trigger> trigger=new ArrayList<>();
//                        trigger.add(new Trigger("planATrip",initiatorAppData,"airportSecurity"));
//                        PassportPermission passportPermission=new PassportPermission(SCANNED_TEXT,trigger);
//                        Call<Permission> call2 = apiService.verifyPassport(passportPermission,"Bearer "+ MainActivity.TOKEN_ID);
//                        call2.enqueue(new Callback<Permission>() {
//                            @Override
//                            public void onResponse(Call<Permission> call, Response<Permission> response) {
//                                try {
//                                    alertDialog.dismiss();
//                                    Log.i("JSON", response.body().getSuccess().toString());
//                                    if (response.body().getSuccess()) {
//                                        Toast.makeText(Trips.this, "Passport verified successfully!", Toast.LENGTH_SHORT).show();
//                                        finish();
//                                    } else {
//                                        Toast.makeText(Trips.this, response.body().getError(), Toast.LENGTH_SHORT).show();
//                                    }
//
//                                } catch (Exception e) {
//                                    alertDialog.dismiss();
//                                    Toast.makeText(Trips.this, "Something Went Wrong-1 ", Toast.LENGTH_SHORT).show();
//                                    e.printStackTrace();
//
//                                }
//                            }
//
//                            @Override
//                            public void onFailure(Call<Permission> call, Throwable t) {
//                                alertDialog.dismiss();
//                                t.printStackTrace();
//                                Toast.makeText(Trips.this, "Something Went Wrong -2", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//
//                    }
//                })
//        );

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
                    Log.i("JSON", response.body().getStatus().toString());
                    if (response.body().getStatus()) {
                        alertDialog.dismiss();
                        tripList = response.body().getMessage();
                        if(tripList.size()==0)
                        {
                            Toast.makeText(DeleteFlight.this, "No Flights Available !", Toast.LENGTH_SHORT).show();
                        }
                        FlightAdapter customAdapter = new FlightAdapter(DeleteFlight.this, response.body().getMessage());
                        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


                    } else {
                        Log.i("TEST", response.body().getStatus().toString());
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

package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.Message;
import com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.ViewBooking;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;

import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.logarithm.airticket.flightticketbook.Login.TOKEN_ID;


public class Bookings extends AppCompatActivity {

    public AlertDialog alertDialog = null;
    RecyclerView recyclerView;
    List<Message> tripList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        // get the reference of RecyclerView

        try {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            // set a LinearLayoutManager with default vertical orientaion
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerVie

            // call the constructor of CustomAdapter to send the reference and data to Adapter
            alertDialog = new SpotsDialog.Builder().setContext(Bookings.this).setTheme(R.style.Custom).build();
            alertDialog.setMessage("Getting flights info..");
            alertDialog.show();
            final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
            Call<ViewBooking> call2 = apiService.viewBookings(TOKEN_ID);
            call2.enqueue(new Callback<ViewBooking>() {
                @Override

                public void onResponse(Call<ViewBooking> call, Response<ViewBooking> response) {
                    try {
                        alertDialog.dismiss();
                        if (response.body().getSuccess()) {
                            alertDialog.dismiss();
                            tripList = response.body().getMessage();
                            if (tripList.size() == 0) {
                                Toast.makeText(Bookings.this, "No bookings Available !", Toast.LENGTH_SHORT).show();
                            }
                            ViewBookingAdapter customAdapter = new ViewBookingAdapter(Bookings.this, response.body().getMessage());
                            recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


                        } else {
                            Log.i("TEST", response.body().getMessage().toString());
                        }
                    } catch (Exception e) {
                        alertDialog.dismiss();
                        Toast.makeText(Bookings.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<ViewBooking> call, Throwable t) {
                    alertDialog.dismiss();
                    Toast.makeText(Bookings.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

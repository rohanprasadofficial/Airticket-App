package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.Message;
import com.logarithm.airticket.flightticketbook.ModelClass.ViewBooking.ViewBooking;
import com.logarithm.airticket.flightticketbook.ParametersClass.DeleteBooking;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;
import com.logarithm.airticket.flightticketbook.utils.MyRecyclerItemClickListener;

import java.util.List;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.logarithm.airticket.flightticketbook.LoginAdmin.TOKEN_ID_ADMIN;


public class ViewAllBookingAdmin extends AppCompatActivity {


    public AlertDialog alertDialog = null;
    RecyclerView recyclerView;
    List<Message> tripList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_all_booking_admin);
        // get the reference of RecyclerView
        try {
            recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
            // set a LinearLayoutManager with default vertical orientaion
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(linearLayoutManager); // set LayoutManager to RecyclerVie
            recyclerView.addOnItemTouchListener(
                    new MyRecyclerItemClickListener(getApplicationContext(), new MyRecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, final int position) {

                            try {
                                alertDialog = new SpotsDialog.Builder().setContext(ViewAllBookingAdmin.this).setTheme(R.style.Custom).build();
                                alertDialog.setMessage("Deleting Booking.. ");
                                alertDialog.show();
                                final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
                                DeleteBooking deleteBooking=new DeleteBooking(tripList.get(position).getId());
                                Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call2 = apiService.deleteBooking(TOKEN_ID_ADMIN, deleteBooking);
                                call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.Response>() {
                                    @Override
                                    public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.Response> response) {
                                        try {
                                            alertDialog.dismiss();
                                            if (response.body().getSuccess()) {
                                                Toast.makeText(ViewAllBookingAdmin.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                                finish();
                                            } else {
                                                Toast.makeText(ViewAllBookingAdmin.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                            }

                                        } catch (Exception e) {
                                            alertDialog.dismiss();
                                            Toast.makeText(ViewAllBookingAdmin.this, "Something Went Wrong-1 ", Toast.LENGTH_SHORT).show();
                                            e.printStackTrace();

                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Throwable t) {
                                        alertDialog.dismiss();
                                        t.printStackTrace();
                                        Toast.makeText(ViewAllBookingAdmin.this, "Something Went Wrong -2", Toast.LENGTH_SHORT).show();
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
            alertDialog = new SpotsDialog.Builder().setContext(ViewAllBookingAdmin.this).setTheme(R.style.Custom).build();
            alertDialog.setMessage("Getting flights info..");
            alertDialog.show();
            final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
            Call<ViewBooking> call2 = apiService.viewAllBookings(TOKEN_ID_ADMIN);
            call2.enqueue(new Callback<ViewBooking>() {
                @Override

                public void onResponse(Call<ViewBooking> call, Response<ViewBooking> response) {
                    try {
                        alertDialog.dismiss();
                        if (response.body().getSuccess()) {
                            alertDialog.dismiss();
                            tripList = response.body().getMessage();
                            if (tripList.size() == 0) {
                                Toast.makeText(ViewAllBookingAdmin.this, "No bookings Available !", Toast.LENGTH_SHORT).show();
                            }
                            ViewBookingAdapter customAdapter = new ViewBookingAdapter(ViewAllBookingAdmin.this, response.body().getMessage());
                            recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView


                        } else {
                            Log.i("TEST", response.body().getMessage().toString());
                        }
                    } catch (Exception e) {
                        alertDialog.dismiss();
                        Toast.makeText(ViewAllBookingAdmin.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<ViewBooking> call, Throwable t) {
                    alertDialog.dismiss();
                    Toast.makeText(ViewAllBookingAdmin.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });

        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}

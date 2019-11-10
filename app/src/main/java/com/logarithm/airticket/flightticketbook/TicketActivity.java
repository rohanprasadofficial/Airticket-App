package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;
import com.logarithm.airticket.flightticketbook.ModelClass.Response;
import com.logarithm.airticket.flightticketbook.ParametersClass.BookTicket;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;

import static com.logarithm.airticket.flightticketbook.Login.EMAIL;
import static com.logarithm.airticket.flightticketbook.Login.TOKEN_ID;
import static com.logarithm.airticket.flightticketbook.LoginAdmin.TOKEN_ID_ADMIN;
import static com.logarithm.airticket.flightticketbook.MainActivity.CLASS;
import static com.logarithm.airticket.flightticketbook.PassengerDetail.NAME;
import static com.logarithm.airticket.flightticketbook.PassengerDetail.PRICE;

public class TicketActivity extends AppCompatActivity {

    private Button btn;
    TextView txtFlightName,txtCountry,txtStationArrived,txtTimeArrived,txtDateArrived,passengerType;
    TextView txtCountryDestination,txtStationDestination,txtTimeDestination,txtDateDestination,passengerName,price;
    RecyclerMessage flight;
    AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        try {
            flight = (RecyclerMessage) getIntent().getSerializableExtra("Flight");
            txtFlightName = findViewById(R.id.txtFlightName);
            txtFlightName.setText(flight.getName());
            txtCountry = findViewById(R.id.txtCountry);
            txtCountry.setText(flight.getSource());
            txtStationArrived = findViewById(R.id.txtStationArrived);
            txtStationArrived.setText(flight.getSource());
            txtTimeArrived = findViewById(R.id.txtTimeArrived);
            txtTimeArrived.setText(flight.getSourceTime());
            txtDateArrived = findViewById(R.id.txtDateArrived);
            txtDateArrived.setText(flight.getSourceDate());
            passengerType = findViewById(R.id.passengerType);
            passengerType.setText(CLASS);

            txtCountryDestination = findViewById(R.id.txtCountryDestination);
            txtCountryDestination.setText(flight.getDestination());


            txtStationDestination = findViewById(R.id.txtStationDestination);

            txtStationDestination.setText(flight.getDestination());


            txtTimeDestination = findViewById(R.id.txtTimeDestination);
            txtTimeDestination.setText(flight.getDestTime());
            txtDateDestination = findViewById(R.id.txtDateDestination);
            txtDateDestination.setText(flight.getDestDate());

            passengerName = findViewById(R.id.passengerName);
            passengerName.setText(NAME);
            price = findViewById(R.id.price);
            price.setText(PRICE);


            btn = (Button) findViewById(R.id.btnBook);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    alertDialog = new SpotsDialog.Builder().setContext(TicketActivity.this).setTheme(R.style.Custom).build();
                    alertDialog.setMessage("Booking Flight... ");
                    alertDialog.show();

                    BookTicket bookTicket=new BookTicket(flight.getSource(),flight.getDestination(),flight.getSourceDate(),flight.getDestDate(),flight.getSourceTime(),flight.getDestTime(),CLASS,EMAIL,NAME,flight.getFlightID(),flight.getFlightNumber(),flight.getName());

                    final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
                        Call<com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.BookTicket> call2 = apiService.bookTicket(TOKEN_ID,bookTicket);
                        call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.BookTicket>() {
                            @Override
                            public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.BookTicket> call, retrofit2.Response<com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.BookTicket> response) {
                                try {
                                    alertDialog.dismiss();
                                    if (response.body().getStatus()) {
                                        //  TOKEN_ID=response.body().getToken();
                                        Toast.makeText(TicketActivity.this, "Booking Successfull !", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(TicketActivity.this, ConfirmTicketActivity.class);
                                        intent.putExtra("Flight",response.body().getPayload());
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(TicketActivity.this,"Booking Error", Toast.LENGTH_SHORT).show();
                                    }
                                    //   alertDialog.dismiss();

                                } catch (Exception e) {
                                    Toast.makeText(TicketActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
//                            alertDialog.dismiss();

                                }
                            }

                            @Override
                            public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.BookTicket> call, Throwable t) {
                                Toast.makeText(TicketActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                alertDialog.dismiss();

                            }
                        });
                    }

            });
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
package com.logarithm.airticket.flightticketbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;

import static com.logarithm.airticket.flightticketbook.MainActivity.CLASS;
import static com.logarithm.airticket.flightticketbook.PassengerDetail.NAME;
import static com.logarithm.airticket.flightticketbook.PassengerDetail.PRICE;

public class TicketActivity extends AppCompatActivity {

    private Button btn;
    TextView txtFlightName,txtCountry,txtStationArrived,txtTimeArrived,txtDateArrived,passengerType;
    TextView txtCountryDestination,txtStationDestination,txtTimeDestination,txtDateDestination,passengerName,price;
    RecyclerMessage flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        flight=(RecyclerMessage)getIntent().getSerializableExtra("Flight");
        txtFlightName=findViewById(R.id.txtFlightName);
        txtFlightName.setText(flight.getName());
        txtCountry=findViewById(R.id.txtCountry);
        txtCountry.setText(flight.getSource());
        txtStationArrived=findViewById(R.id.txtStationArrived);
        txtStationArrived.setText(flight.getSource());
        txtTimeArrived=findViewById(R.id.txtTimeArrived);
        txtTimeArrived.setText(flight.getSourceTime());
        txtDateArrived=findViewById(R.id.txtDateArrived);
        txtDateArrived.setText(flight.getSourceDate());
        passengerType=findViewById(R.id.passengerType);
        passengerType.setText(CLASS);

        txtCountryDestination=findViewById(R.id.txtCountryDestination);
        txtCountryDestination.setText(flight.getDestination());


        txtStationDestination=findViewById(R.id.txtStationDestination);

        txtStationDestination.setText(flight.getDestination());


        txtTimeDestination=findViewById(R.id.txtTimeDestination);
        txtTimeDestination.setText(flight.getDestTime());
        txtDateDestination=findViewById(R.id.txtDateDestination);
        txtDateDestination.setText(flight.getDestDate());

        passengerName=findViewById(R.id.passengerName);
        passengerName.setText(NAME);
        price=findViewById(R.id.price);
        price.setText(PRICE);

























        btn =(Button) findViewById(R.id.btnBook);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TicketActivity.this, FlightListActivity.class);
                startActivity(intent);
            }
        });
    }
}
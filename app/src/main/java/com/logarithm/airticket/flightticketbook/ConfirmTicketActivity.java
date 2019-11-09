package com.logarithm.airticket.flightticketbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ModelClass.BookTicket.Payload;
import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;
import com.logarithm.airticket.flightticketbook.R;

import static com.logarithm.airticket.flightticketbook.MainActivity.CLASS;
import static com.logarithm.airticket.flightticketbook.PassengerDetail.NAME;
import static com.logarithm.airticket.flightticketbook.PassengerDetail.PRICE;

public class ConfirmTicketActivity extends AppCompatActivity {


    Payload Flight;
    TextView name ,txtCountry,txtStationArrived,txtTimeArrived,txtDateArrived,passengerType;
    TextView txtCountryDestination,txtStationDestination,txtTimeDestination,txtDateDestination,passengerName,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_ticket);


        try {
            Flight = (Payload) getIntent().getSerializableExtra("Flight");

            name = findViewById(R.id.name);
            name.setText(Flight.getFlicketName());
            txtCountry = findViewById(R.id.txtCountry);
            txtCountry.setText(Flight.getFrom());
            txtStationArrived=findViewById(R.id.txtStationArrived);
            txtStationArrived.setText(Flight.getFrom());
            txtTimeArrived = findViewById(R.id.txtTimeArrived);
            txtTimeArrived.setText(Flight.getSourceTime());
            txtDateArrived = findViewById(R.id.date);
            txtDateArrived.setText(Flight.getDepartDate());
            passengerType = findViewById(R.id.passengerType);
            txtCountryDestination = findViewById(R.id.txtCountryDestination);
            txtCountryDestination.setText(Flight.getTo());
            txtStationDestination=findViewById(R.id.txtStationDestination);
            txtStationDestination.setText(Flight.getTo());
            passengerName = findViewById(R.id.passengerName);
            passengerName.setText(NAME);
//            Toast.makeText(this, Flight.getFlicketName(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, Flight.getId(), Toast.LENGTH_SHORT).show();
//            Toast.makeText(this, Flight.getFlicketName(), Toast.LENGTH_SHORT).show();

        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();

        }
    }

}

package com.logarithm.airticket.flightticketbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;
import com.logarithm.airticket.flightticketbook.R;

public class ConfirmTicketActivity extends AppCompatActivity {


    RecyclerMessage Flight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_ticket);

        

        Flight =(RecyclerMessage)getIntent().getSerializableExtra("Flight");


        Toast.makeText(this, Flight.getId(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, Flight.getName(), Toast.LENGTH_SHORT).show();


    }

}

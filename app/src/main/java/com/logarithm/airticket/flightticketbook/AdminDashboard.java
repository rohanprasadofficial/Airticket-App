package com.logarithm.airticket.flightticketbook;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.logarithm.airticket.flightticketbook.R;

public class AdminDashboard extends AppCompatActivity {



    Button addFlight,deleteFlight,addAirport,deleteAirport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);



        addAirport=findViewById(R.id.btn_addairport);
        deleteAirport=findViewById(R.id.btn_deleteairport);
        deleteFlight=findViewById(R.id.btn_deleteflight);
        addFlight=findViewById(R.id.btn_addflight);

        addFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddFlight.class));
            }
        });


        addAirport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddAirport.class));
            }
        });


        deleteFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DeleteFlight.class));
            }
        });
        deleteAirport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),DeleteAirport.class));


            }
        });







    }
}

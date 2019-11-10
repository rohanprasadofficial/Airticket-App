package com.logarithm.airticket.flightticketbook;


import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.logarithm.airticket.flightticketbook.R;

public class AdminDashboard extends AppCompatActivity {


    SharedPreferences pref;
    SharedPreferences.Editor editor ;


    Button addFlight,deleteFlight,addAirport,deleteAirport;
    LinearLayout logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        logout=findViewById(R.id.logout);


        pref = getApplicationContext().getSharedPreferences("cred", 0); // 0 - for private mode
        editor = pref.edit();

        addAirport=findViewById(R.id.btn_addairport);
        deleteAirport=findViewById(R.id.btn_deleteairport);
        deleteFlight=findViewById(R.id.btn_deleteflight);
        addFlight=findViewById(R.id.btn_addflight);


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.remove("TOKEN_ID_ADMIN");
                editor.commit();
                startActivity(new Intent(getApplicationContext(),RoleChoose.class));
                finish();

            }
        });


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

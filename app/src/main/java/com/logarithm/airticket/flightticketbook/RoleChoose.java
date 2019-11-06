package com.logarithm.airticket.flightticketbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RoleChoose extends AppCompatActivity {

    Button admin,user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role_choose);

        admin=findViewById(R.id.btn_admin);
        user=findViewById(R.id.btn_user);

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),LoginAdmin.class));
            }
        });

        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
    }
}

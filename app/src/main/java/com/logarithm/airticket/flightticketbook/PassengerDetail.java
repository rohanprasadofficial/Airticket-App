package com.logarithm.airticket.flightticketbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.logarithm.airticket.flightticketbook.ModelClass.Flight;
import com.logarithm.airticket.flightticketbook.ModelClass.RecyclerMessage;

import static com.logarithm.airticket.flightticketbook.Login.EMAIL;
import static com.logarithm.airticket.flightticketbook.MainActivity.CLASS;
import static com.logarithm.airticket.flightticketbook.MainActivity.DATE;

public class PassengerDetail extends AppCompatActivity {

    TextView name,email,Tclass,date,price;
    RecyclerMessage flight;
    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_detail);

        name=findViewById(R.id.edt_name);
        email=findViewById(R.id.edt_email);
        Tclass=findViewById(R.id.edt_Class);
        date=findViewById(R.id.edt_date);
        price=findViewById(R.id.edt_price);
        book=findViewById(R.id.btn_book);
        flight= (RecyclerMessage)getIntent().getSerializableExtra("Flight");


        email.setText(EMAIL);
        Tclass.setText(CLASS);
        date.setText(DATE);
        if(CLASS.equals("First Class"))
        price.setText(flight.getFclassPrice());
        if(CLASS.equals("Business Class"))
            price.setText(flight.getBclassPrice());
        if(CLASS.equals("Premium Economy"))
            price.setText(flight.getPclassPrice());
        if(CLASS.equals("Economy Class"))
            price.setText(flight.getEclassPrice());

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),TicketActivity.class));
            }
        });



    }
}

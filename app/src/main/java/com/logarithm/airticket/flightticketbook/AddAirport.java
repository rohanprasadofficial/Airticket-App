package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ParametersClass.Credentials;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.logarithm.airticket.flightticketbook.LoginAdmin.TOKEN_ID_ADMIN;

public class AddAirport extends AppCompatActivity {


    TextView name;
    Button addAirport;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_airport);


        name=findViewById(R.id.edt_name);

        addAirport=findViewById(R.id.btn_add);


        addAirport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new SpotsDialog.Builder().setContext(AddAirport.this).setTheme(R.style.Custom).build();
                alertDialog.setMessage("Adding Flight... ");
                alertDialog.show();
                if (name.getText().length() > 0  )  {
                    final APIInterface apiService = APIClient.getClient().create(APIInterface.class);

                    com.logarithm.airticket.flightticketbook.ParametersClass.AddAirport addAirport=new com.logarithm.airticket.flightticketbook.ParametersClass.AddAirport(name.getText().toString());
                    Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call2 = apiService.addAirport(TOKEN_ID_ADMIN,addAirport);
                    call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.Response>() {
                        @Override
                        public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.Response> response) {
                            try {
                                alertDialog.dismiss();
                                Log.i("MESSAGE",response.body().getMessage());
                                if (response.body().getSuccess()) {

                                    Toast.makeText(AddAirport.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),AdminDashboard.class));
                                    finish();
                                } else {
                                    Toast.makeText(AddAirport.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                                //   alertDialog.dismiss();

                            } catch (Exception e) {
                                Toast.makeText(AddAirport.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
//                            alertDialog.dismiss();

                            }
                        }

                        @Override
                        public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Throwable t) {
                            Toast.makeText(AddAirport.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                            alertDialog.dismiss();

                        }
                    });
                } else {
                    alertDialog.dismiss();
                    Toast.makeText(AddAirport.this, "Fields cannot be blank !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

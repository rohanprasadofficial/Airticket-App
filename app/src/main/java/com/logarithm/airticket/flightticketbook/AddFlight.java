package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class AddFlight extends AppCompatActivity {


    TextView name,flightNo,flightID;
    Button addFlight;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);


        name=findViewById(R.id.edt_name);
        flightNo=findViewById(R.id.edt_flightNumber);
        flightID=findViewById(R.id.edt_flightID);
        addFlight=findViewById(R.id.btn_add);


        addFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new SpotsDialog.Builder().setContext(AddFlight.this).setTheme(R.style.Custom).build();
                alertDialog.setMessage("Adding Flight... ");
                alertDialog.show();
                if (flightID.getText().length() > 0 && flightNo.getText().length() > 0 && flightID.length() >0 )  {
                    //   Credentials credentials=new Credentials(editTextUserId.getText().toString(),editTextPassword.getText().toString());
                    com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight credentials = new com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight(name.getText().toString(),flightNo.getText().toString(),flightID.getText().toString());
                    final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
                    Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call2 = apiService.addFlight(TOKEN_ID_ADMIN,credentials);
                    call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.Response>() {
                        @Override
                        public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.Response> response) {
                            try {
                                alertDialog.dismiss();
                                if (response.body().getSuccess()) {
                                  //  TOKEN_ID=response.body().getToken();
                                    Toast.makeText(AddFlight.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(),AdminDashboard.class));
                                    finish();
                                } else {
                                    Toast.makeText(AddFlight.this,response.body().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                                //   alertDialog.dismiss();

                            } catch (Exception e) {
                                Toast.makeText(AddFlight.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
//                            alertDialog.dismiss();

                            }
                        }

                        @Override
                        public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.Response> call, Throwable t) {
                            Toast.makeText(AddFlight.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                            alertDialog.dismiss();

                        }
                    });
                } else {
                    alertDialog.dismiss();
                    Toast.makeText(AddFlight.this, "Fields cannot be blank !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

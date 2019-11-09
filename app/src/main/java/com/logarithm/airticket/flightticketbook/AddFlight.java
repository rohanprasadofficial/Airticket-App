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


    TextView name,flightNo,flightID,source,dest,sourceDate,destDate,sourceTime,destTime,FPrice,BPrice,PPrice,EPrice;
    Button addFlight;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);


        name=findViewById(R.id.edt_name);
        flightNo=findViewById(R.id.edt_flightNumber);
        flightID=findViewById(R.id.edt_flightID);
        source=findViewById(R.id.Source);
        dest=findViewById(R.id.Destination);
        sourceDate=findViewById(R.id.sourceDate);
        sourceTime=findViewById(R.id.sourceTime);
        destDate=findViewById(R.id.DestDate);
        destTime=findViewById(R.id.destTime);
        FPrice=findViewById(R.id.FclassPrice);
        BPrice=findViewById(R.id.BclassPrice);
        PPrice=findViewById(R.id.PclassPrice);
        EPrice=findViewById(R.id.EclassPrice);
        addFlight=findViewById(R.id.btn_add);


        addFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new SpotsDialog.Builder().setContext(AddFlight.this).setTheme(R.style.Custom).build();
                alertDialog.setMessage("Adding Flight... ");
                alertDialog.show();
                if (flightID.getText().length() > 0 && flightNo.getText().length() > 0 && flightID.length() >0 && source.length() >0  && dest.length() >0  && sourceDate.length() >0  && sourceTime.length() >0  && destDate.length() >0  && destTime.length() >0  && FPrice.length() >0  && PPrice.length() >0  && BPrice.length() >0  && EPrice.length() >0  )  {
                    //   Credentials credentials=new Credentials(editTextUserId.getText().toString(),editTextPassword.getText().toString());
                    com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight credentials = new com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight(name.getText().toString(),flightNo.getText().toString(),flightID.getText().toString(),source.getText().toString(),dest.getText().toString(),sourceTime.getText().toString(),destTime.getText().toString(),sourceDate.getText().toString(),destDate.getText().toString(),FPrice.getText().toString(),BPrice.getText().toString(),PPrice.getText().toString(),EPrice.getText().toString());
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

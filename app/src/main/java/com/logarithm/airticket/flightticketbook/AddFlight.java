package com.logarithm.airticket.flightticketbook;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.logarithm.airticket.flightticketbook.ParametersClass.Credentials;
import com.logarithm.airticket.flightticketbook.RestAPI.APIClient;
import com.logarithm.airticket.flightticketbook.RestAPI.APIInterface;

import java.util.ArrayList;

import dmax.dialog.SpotsDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.logarithm.airticket.flightticketbook.LoginAdmin.TOKEN_ID_ADMIN;

public class AddFlight extends AppCompatActivity {


    TextView name,flightNo,flightID,source,dest,sourceDate,destDate,sourceTime,destTime,FPrice,BPrice,PPrice,EPrice;
    Button addFlight;
    AlertDialog alertDialog;
    ArrayList<String> fruits;
    AutoCompleteTextView actv;

    public String TO="Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoiYWRtaW4iLCJpZCI6IjVkYzJmY2Y0N2UzOGQ2MzY2NThkOGQ3NSIsImVtYWlsIjoiYWRtaW5AZ21haWwuY29tIiwicGFzc3dvcmQiOiIkMmEkMTAkNkM1ZTF0QnEyYjZCUkdtbGxPMTZnZXVVOEQzOFA1S1dkQkJRL0JDNGdOeEdGVjNsaC85S2UiLCJwcm9maWxlcGljIjoiaHR0cHM6Ly9lZGxpZmUuZWR1Lm12L3dwLWNvbnRlbnQvdXBsb2Fkcy8yMDE3LzA1LzIwMTYxMDE0XzU4MDA2YmZkNzZkY2YucG5nIiwiaWF0IjoxNTczMjkyNzc0fQ.p_79D_Hm1izze-4nb4TkJnjFOJRSyhwrkD6f6ZqNp10";
    AutoCompleteTextView actvv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_flight);
        fruits=new ArrayList<>();

        try {
            alertDialog = new SpotsDialog.Builder().setContext(AddFlight.this).setTheme(R.style.Custom).build();
            alertDialog.setMessage("Getting Airports info..");
            alertDialog.show();
            final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
            Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> call2 = apiService.getAllAirports(TOKEN_ID_ADMIN);
            call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport>() {
                @Override

                public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> response) {
                    try {
                        alertDialog.dismiss();
                        Log.i("JSON", response.body().getSuccess().toString());
                        if (response.body().getSuccess()) {

                            for(int i=0;i<response.body().getMessage().size();i++)
                            {
                                fruits.add(response.body().getMessage().get(i).getName());

                            }

                            alertDialog.dismiss();

                        } else {
                            Log.i("TEST", response.body().getMessage().toString());
                        }
                    } catch (Exception e) {
                        alertDialog.dismiss();
                        Toast.makeText(AddFlight.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();

                    }
                }

                @Override
                public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.DeleteAirport.DeleteAirport> call, Throwable t) {
                    alertDialog.dismiss();
                    Toast.makeText(AddFlight.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
        }



        name=findViewById(R.id.edt_name);
        flightNo=findViewById(R.id.edt_flightNumber);
        flightID=findViewById(R.id.edt_flightID);
        sourceDate=findViewById(R.id.sourceDate);
        sourceTime=findViewById(R.id.sourceTime);
        destDate=findViewById(R.id.DestDate);
        destTime=findViewById(R.id.destTime);
        FPrice=findViewById(R.id.FclassPrice);
        BPrice=findViewById(R.id.BclassPrice);
        PPrice=findViewById(R.id.PclassPrice);
        EPrice=findViewById(R.id.EclassPrice);
        addFlight=findViewById(R.id.btn_add);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fruits);

        //Getting the instance of AutoCompleteTextView
        actv = (AutoCompleteTextView) findViewById(R.id.Source);
        actv.setThreshold(1);//will start working from first character
        actv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        actv.setTextColor(Color.BLACK);

        ArrayAdapter<String> adapter_new = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fruits);

        //Getting the instance of AutoCompleteTextView
        actvv = (AutoCompleteTextView) findViewById(R.id.Destination);
        actvv.setThreshold(1);//will start working from first character
        actvv.setAdapter(adapter_new);//setting the adapter data into the AutoCompleteTextView
        actvv.setTextColor(Color.BLACK);



        addFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new SpotsDialog.Builder().setContext(AddFlight.this).setTheme(R.style.Custom).build();
                alertDialog.setMessage("Adding Flight... ");
                alertDialog.show();
                if (flightID.getText().length() > 0 && flightNo.getText().length() > 0 && flightID.length() >0 && actvv.length() >0  && actv.length() >0  && sourceDate.length() >0  && sourceTime.length() >0  && destDate.length() >0  && destTime.length() >0  && FPrice.length() >0  && PPrice.length() >0  && BPrice.length() >0  && EPrice.length() >0  )  {
                    //   Credentials credentials=new Credentials(editTextUserId.getText().toString(),editTextPassword.getText().toString());
                    com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight credentials = new com.logarithm.airticket.flightticketbook.ParametersClass.AddFlight(name.getText().toString(),flightNo.getText().toString(),flightID.getText().toString(),actv.getText().toString(),actvv.getText().toString(),sourceTime.getText().toString(),destTime.getText().toString(),sourceDate.getText().toString(),destDate.getText().toString(),FPrice.getText().toString(),BPrice.getText().toString(),PPrice.getText().toString(),EPrice.getText().toString());
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

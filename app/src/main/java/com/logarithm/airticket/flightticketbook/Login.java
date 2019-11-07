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


public class Login extends AppCompatActivity {


    public static String  TOKEN_ID=null;
    TextView edt_username,edt_pass,register;
    Button btn_login;
    AlertDialog alertDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edt_username=findViewById(R.id.edt_username);
        edt_pass=findViewById(R.id.edt_pass);
        btn_login=findViewById(R.id.btn_login);
        register=findViewById(R.id.registerView);
        Log.i("ACT ","LOGIN");


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Register.class));
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = new SpotsDialog.Builder().setContext(Login.this).setTheme(R.style.Custom).build();
                alertDialog.setMessage("Logging In... ");
                alertDialog.show();

                if (edt_pass.getText().length() > 0 && edt_username.getText().length() > 0) {

                    //   Credentials credentials=new Credentials(editTextUserId.getText().toString(),editTextPassword.getText().toString());
                    Credentials credentials = new Credentials(edt_username.getText().toString(), edt_pass.getText().toString());

                    final APIInterface apiService = APIClient.getClient().create(APIInterface.class);
                    Call<com.logarithm.airticket.flightticketbook.ModelClass.Login> call2 = apiService.login(credentials);
                    call2.enqueue(new Callback<com.logarithm.airticket.flightticketbook.ModelClass.Login>() {
                        @Override
                        public void onResponse(Call<com.logarithm.airticket.flightticketbook.ModelClass.Login> call, Response<com.logarithm.airticket.flightticketbook.ModelClass.Login> response) {
                            try {
                                alertDialog.dismiss();
                                if (response.body().getSuccess()) {
                                        TOKEN_ID=response.body().getToken();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        finish();
                                } else {
                                    Toast.makeText(Login.this,"Invalid Credentials !", Toast.LENGTH_SHORT).show();
                                }
                                //   alertDialog.dismiss();

                            } catch (Exception e) {
                                Toast.makeText(Login.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                                e.printStackTrace();
//                            alertDialog.dismiss();

                            }
                        }

                        @Override
                        public void onFailure(Call<com.logarithm.airticket.flightticketbook.ModelClass.Login> call, Throwable t) {
                            Toast.makeText(Login.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();

                            alertDialog.dismiss();

                        }
                    });
                } else {
                    alertDialog.dismiss();
                    Toast.makeText(Login.this, "Fields cannot be blank !", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}

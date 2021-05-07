package com.example.registerapiproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class login_activity1 extends AppCompatActivity {

    EditText user;
    EditText pass;
    Button login;
   SharedPreferences pref;
   Intent intent;
    @SuppressLint("CommitPrefEdits")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        user = findViewById(R.id.etLoginUserName);
        pass = findViewById(R.id.etLoginPassword);

        login = findViewById(R.id.btnLogin);
        pref=getSharedPreferences("user_detail",MODE_PRIVATE);
       /* Intent i=new Intent(login_activity1.this, RegisterActivity.class);
        if (pref.contains("username")&&pref.contains("password")){
            startActivity(i);
        }*/


        String value = pref.getString("Token",null);
        if (value == null) {

        } else {
            Intent intent = new Intent(login_activity1.this,MainActivity3.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=user.getText().toString();
                String password=pass.getText().toString();
                if (TextUtils.isEmpty(user.getText().toString())) {
                    Toast.makeText(getApplication(), "First Name is required", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(pass.getText().toString())) {
                    Toast.makeText(getApplication(), "Last Name is required", Toast.LENGTH_SHORT).show();
                } else {
                    getData(
                            user.getText().toString().trim(),
                            pass.getText().toString().trim());

                }
            }
        });
    }

    private void getData(String user, String pass) {

        ApiUtils.getAPIService().token(user,pass,"password").enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                  if(response.code()==200){
//                      Toast.makeText(login_activity1.this, ""+response.message(), Toast.LENGTH_SHORT).show();
//                  }
                 String abc =   response.body().getAccessToken();
                    SharedPreferences.Editor editor=pref.edit();
                    editor.putString("Token",abc);
                    editor.commit();

                Toast.makeText(login_activity1.this, "welcome", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(login_activity1.this, MainActivity3.class);
                startActivity(intent);

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(login_activity1.this, "ada"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}

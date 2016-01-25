package com.hackerkernel.rememberme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.username)EditText mUsername;
    @Bind(R.id.password) EditText mPassword;
    @Bind(R.id.login) Button mLogin;
    @Bind(R.id.goToRegister) TextView mGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //login code
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()){
                    T.show(getApplicationContext(), "Fill in All The Feilds");
                }
                else if (username.length() < 3){
                    T.show(getApplicationContext(),"username should be more than 3 letter");

                }
                else if (password.length() < 8){
                    T.show(getApplicationContext(),"password should be more than 8 letter");
                }

                SharedPreferences sp = getSharedPreferences(Keys.SP_NAME,MODE_PRIVATE);
            }
        });

        //when register is clicked
        mGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(),RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}

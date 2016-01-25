package com.hackerkernel.rememberme;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    @Bind(R.id.username)EditText mUsername;
    @Bind(R.id.password) EditText mPassword;
    @Bind(R.id.register)
    Button mRegister;
    @Bind(R.id.goToLogin)
    TextView mGoToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    T.show(getApplicationContext(), "Fill in All The Feilds");
                } else if (username.length() < 3) {
                    T.show(getApplicationContext(), "username should be more than 3 letter");

                } else if (password.length() < 8) {
                    T.show(getApplicationContext(), "password should be more than 8 letter");
                } else {
                    SharedPreferences sp = getSharedPreferences(Keys.SP_NAME,MODE_PRIVATE);
                    sp.edit().putString("username",username)
                            .putString("password",password)
                            .apply();
                    T.show(getApplication(),"Register susccelfull");
                }
            }
        });



    }
}

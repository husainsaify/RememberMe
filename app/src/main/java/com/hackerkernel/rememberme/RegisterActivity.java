package com.hackerkernel.rememberme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RegisterActivity extends AppCompatActivity {
    @Bind(R.id.username)EditText mUsername;
    @Bind(R.id.password) EditText mPassword;
    @Bind(R.id.register) Button mRegister;
    @Bind(R.id.goToLogin) TextView mGoToLogin;
    @Bind(R.id.toolbar_new) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(getString(R.string.register));
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();

                if (username.isEmpty() || password.isEmpty()) {
                    T.show(getApplicationContext(), "Fill in All The Fields");
                    return;

                } else if (username.length() < 3) {
                    T.show(getApplicationContext(), "username should be more than 3 letter");

                } else if (password.length() < 8) {
                    T.show(getApplicationContext(), "password should be more than 8 letter");


                }
                SharedPreferences isp = getSharedPreferences(Keys.SP_NAME, MODE_PRIVATE);
                String passwordsp = isp.getString(Keys.SP_PASSWORD, Keys.DEFAULT);
                String usernamesp = isp.getString(Keys.SP_USERNAME, Keys.DEFAULT);
                if (username.equals(usernamesp) || password.equals(passwordsp)) {

                    T.show(getApplicationContext(),"PLEASE SELECT A DIFFERENT USERNAME AND PASSWORD");

                } else {
                    SharedPreferences sp = getSharedPreferences(Keys.SP_NAME, MODE_PRIVATE);
                    sp.edit().putString(Keys.SP_USERNAME, username)
                            .putString(Keys.SP_PASSWORD, password)
                            .apply();
                    T.show(getApplication(), "Register successful");
                    //send user to home page
                    Intent intent = new Intent(getApplication(), HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

        //go to lognb
        mGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}

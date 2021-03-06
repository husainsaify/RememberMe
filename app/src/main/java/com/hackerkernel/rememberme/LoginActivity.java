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

public class LoginActivity extends AppCompatActivity {
    @Bind(R.id.toolbar_new) Toolbar mToolbar;

    @Bind(R.id.password) EditText mPassword;
    @Bind(R.id.login) Button mLogin;
    @Bind(R.id.goToRegister) TextView mGoToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(getString(R.string.app_name));

        //login code
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = mPassword.getText().toString().trim();

                if (password.isEmpty()) {
                    T.show(getApplicationContext(), "Fill in All The Feilds");
                } else if (password.length() < 8) {
                    T.show(getApplicationContext(), "password should be more than 8 letter");
                }

                SharedPreferences sp = getSharedPreferences(Keys.SP_NAME, MODE_PRIVATE);
                String passwordsp = sp.getString(Keys.SP_PASSWORD, Keys.DEFAULT);
                //check password = sharepreferences
                if (password.equals(passwordsp)){
                    Intent intent = new Intent(getApplication(), HomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }else{
                    T.show(getApplication(), "wrong user/pass");
                }
            }
        });

        //when register is clicked
        mGoToRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), RegisterActivity.class);
                startActivity(intent);

            }
        });
    }
}

package com.hackerkernel.rememberme;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    String mUsername;
    @Bind(R.id.username)
    TextView mUsernameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        SharedPreferences sp = getSharedPreferences(Keys.SP_NAME,MODE_PRIVATE);
        mUsername= sp.getString(Keys.SP_USERNAME,Keys.DEFAULT);
         T.show(getApplication(),mUsername);
        mUsernameView.setText(mUsername);


    }
}

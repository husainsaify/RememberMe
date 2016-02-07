package com.hackerkernel.rememberme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class UserNames extends AppCompatActivity {
    String mUsername;
    String mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_names);

        Intent intent = getIntent();
        mUsername = intent.getExtras().getString("username", Keys.DEFAULT);
        mCategory = intent.getExtras().getString("category", Keys.DEFAULT);

        //



        String[] username = {"hus","qut","qut"};

        String[] password = {"tas","mar","fat"};

        List <CredintialsPojo> list = new ArrayList<>();

        for (int i = 0; i <username.length; i++) {

            String currentu =username[i];
            String currentp = password[i];
            CredintialsPojo pojo = new CredintialsPojo();

            pojo.setEmail(currentu);
            pojo.setPassword(currentp);
            list.add(pojo);
        }
            T.show(getApplication(),list.size()+"");

    }
}

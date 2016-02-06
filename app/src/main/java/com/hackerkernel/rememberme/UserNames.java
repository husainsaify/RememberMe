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

        String[] usernameArray = {"murtaza","husain","qut"};
        String[] passwordArray = {"fatema","tasneem","mariya"};

        int i = 0;
        List<CredintialsPojo> list = new ArrayList<>();
        while (i <= 2){
            CredintialsPojo pojo = new CredintialsPojo();
            pojo.setEmail(usernameArray[i]);
            pojo.setPassword(passwordArray[i]);

            list.add(pojo);
            i++;
        }

        //display list
        for (int i1 = 0; i1 < list.size(); i1++) {
            CredintialsPojo pojo = list.get(i1);
            Log.d("HUS", "HUS: " + pojo.getEmail()+"/"+pojo.getPassword());
        }

    }
}

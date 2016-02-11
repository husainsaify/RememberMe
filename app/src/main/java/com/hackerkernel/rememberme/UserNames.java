package com.hackerkernel.rememberme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserNames extends AppCompatActivity {
    String mUsername;
    String mCategory;

    @Bind(R.id.listview) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_names);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mUsername = intent.getExtras().getString("username", Keys.DEFAULT);
        mCategory = intent.getExtras().getString("category", Keys.DEFAULT);

        Database db = new Database(this);

        List<CredintialsPojo> list = db.getkeys(mCategory,mUsername);

        List<String> stringList = new ArrayList<>();
    }
}

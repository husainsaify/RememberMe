package com.hackerkernel.rememberme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {

    String mUsername;
    String[] categoryname;

    @Bind(R.id.listview) ListView mListView;
    @Bind(R.id.toolbar_new) Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


        setSupportActionBar(mToolbar);
        assert getSupportActionBar() != null;
        getSupportActionBar().setTitle(getString(R.string.app_name));

        SharedPreferences sp = getSharedPreferences(Keys.SP_NAME, MODE_PRIVATE);
        mUsername = sp.getString(Keys.SP_USERNAME, Keys.DEFAULT);

        categoryname = getResources().getStringArray(R.array.category);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, categoryname);

        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedCategory = categoryname[position];
                Intent intent = new Intent(getApplication(), UserNames.class);
                intent.putExtra("username", mUsername);
                intent.putExtra("category", selectedCategory);
                startActivity(intent);
            }
        });


    }

    public void goToAddActivity(View view) {
        startActivity(new Intent(getApplicationContext(), AddActivity.class));
    }
}

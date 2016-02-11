package com.hackerkernel.rememberme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserNames extends AppCompatActivity {
    String mUsername;
    String mCategory;

    @Bind(R.id.listview) ListView mListView;
    @Bind(R.id.placeholder) TextView mPlaceholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_names);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mUsername = intent.getExtras().getString("username", Keys.DEFAULT);
        mCategory = intent.getExtras().getString("category", Keys.DEFAULT);

        Database db = new Database(this);

        final List<CredintialsPojo> list = db.getkeys(mCategory,mUsername);

        //hide listview and show placeholder
        if(list.size() <= 0){
            mPlaceholder.setVisibility(View.VISIBLE);
            mListView.setVisibility(View.GONE);
        }else{
            //show listview
            mPlaceholder.setVisibility(View.GONE);
            mListView.setVisibility(View.VISIBLE);

            //create mListView
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i <list.size() ; i++)
            {
                String email = list.get(i).getEmail();
                stringList.add(email);
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stringList);
            mListView.setAdapter(adapter);

            mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    String password = list.get(position).getPassword();

                    AlertDialog.Builder builder = new AlertDialog.Builder(UserNames.this);
                    builder.setTitle("Your Password Is")
                            .setMessage(password)
                            .setPositiveButton("OK", null);
                    AlertDialog dialog = builder.create();
                    dialog.show();

                }
            });
        }
    }
}

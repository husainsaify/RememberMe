package com.hackerkernel.rememberme;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddActivity extends AppCompatActivity {
    @Bind(R.id.spinner)
    Spinner mCategory;
    @Bind(R.id.email)
    EditText mEmail;
    @Bind(R.id.password)
    EditText mPassword;
    @Bind(R.id.save)
    Button mSave;

    private String[] category;
    private String selectedCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        category = getResources().getStringArray(R.array.category);

        mCategory.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedCategory = category[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                savedata(email,password,selectedCategory);
            }
        });

    }

    private void savedata(String email,String password,String category){
        T.show(getApplication(),"hus:: method rin");
    }
}

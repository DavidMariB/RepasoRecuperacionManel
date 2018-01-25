package com.dmb.repasorecuperacionmanel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowDataActivity extends AppCompatActivity {

    TextView tvName,tvAge,tvSex,tvReading,tvRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        tvName = findViewById(R.id.tvName);
        tvAge = findViewById(R.id.tvAge);
        tvSex = findViewById(R.id.tvSex);
        tvReading = findViewById(R.id.tvReading);
        tvRating = findViewById(R.id.tvRating);

        retrieveData();
    }

    public void retrieveData(){
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("userName"));
        tvAge.setText(intent.getStringExtra("userAge"));
        tvSex.setText(intent.getStringExtra("userSex"));
        tvReading.setText(intent.getStringExtra("userReading"));
        tvRating.setText(intent.getStringExtra("userRating"));
    }
}

package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wet.beastbots.R;

public class WaterUsageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_usage);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button totalUsageStatusButton = (Button) this.findViewById(R.id.total_usage_status_button);
        totalUsageStatusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(WaterUsageActivity.this, OverallUsageStatusActivity.class);
                //WaterUsageActivity.this.startActivity(intent);
            }

        });

    }
}
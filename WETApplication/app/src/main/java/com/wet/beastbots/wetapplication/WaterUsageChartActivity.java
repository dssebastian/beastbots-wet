package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.wet.beastbots.R;

public class WaterUsageChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_usage_chart);
        Button showerusageButton = (Button)this.findViewById(R.id.shower_usage_button);
        showerusageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "Clicked on help button",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(WaterUsageChartActivity.this,ShowerUsageActivity.class);
                WaterUsageChartActivity.this.startActivity(intent);
            }
        });
    }
}



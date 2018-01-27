package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.wet.beastbots.R;

public class FloorUsageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floor_usage);
        Button dishwasherButton= (Button) this.findViewById(R.id.dishwasher_button);
        dishwasherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FloorUsageActivity.this, "WET Dishwasher Usage", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(MainActivity.this, dishwasherButton.class);
                //MainActivity.this.startActivity(intent);
            }
        });
    }
}

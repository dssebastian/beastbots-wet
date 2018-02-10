package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.wet.beastbots.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button water_usageButton = (Button)this.findViewById(R.id.water_usage_button);
        water_usageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(MainActivity.this, "click_on_water_usage_button", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, WaterUsageActivity.class) ;
                MainActivity.this.startActivity(intent);
            }
        });

        Button helpButton = (Button)this.findViewById(R.id.help_button);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HelpActivity.class) ;
                MainActivity.this.startActivity(intent);

            }
        });

        Button donateButton = (Button)this.findViewById(R.id.donate_button);
        donateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DonateActivity.class) ;
                MainActivity.this.startActivity(intent);



            }
        });

        Button setupButton = (Button)this.findViewById(R.id.setup_button);
        setupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SetupActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
    }
}




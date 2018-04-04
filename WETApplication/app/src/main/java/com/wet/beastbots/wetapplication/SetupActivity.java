package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.wet.beastbots.R;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
        Button nameSensorButton = (Button) this.findViewById(R.id.name_sensors_button);
        nameSensorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, AddSensorsActivity.class);
                SetupActivity.this.startActivity(intent);
            }
        });

        Button nameFloorButton = (Button) this.findViewById(R.id.name_floors_button);
        nameFloorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, NameFloorsActivity.class);
                SetupActivity.this.startActivity(intent);
            }

        });

        Button sensorLocationButton = (Button) this.findViewById(R.id.sensor_location_button);
        sensorLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, SensorLocationActivity.class);
                SetupActivity.this.startActivity(intent);
            }

        });

        Button bluetoothPageButton = (Button) this.findViewById(R.id.bluetooth_page_button);
        bluetoothPageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SetupActivity.this, BluetoothConnectActivity.class);
                SetupActivity.this.startActivity(intent);

            }
        });


    }
}
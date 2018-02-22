package com.wet.beastbots.wetapplication;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wet.beastbots.R;

import java.util.List;

import me.aflak.bluetooth.Bluetooth;
import me.aflak.bluetooth.BluetoothCallback;
import me.aflak.bluetooth.CommunicationCallback;
import me.aflak.bluetooth.DiscoveryCallback;

public class BluetoothConnectorActivity extends AppCompatActivity {

    private Bluetooth bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bluetooth = new Bluetooth(getApplicationContext());
        if(!bluetooth.isEnabled())
            bluetooth.enable();

        bluetooth.setBluetoothCallback(new BluetoothCallback() {
            @Override
            public void onBluetoothTurningOn() {}

            @Override
            public void onBluetoothOn() {

            }

            @Override
            public void onBluetoothTurningOff() {}

            @Override
            public void onBluetoothOff() {}

            @Override
            public void onUserDeniedActivation() {
                // when using bluetooth.showEnableDialog()
                // you will also have to call bluetooth.onActivityResult()
            }
        });

        bluetooth.setDiscoveryCallback(new DiscoveryCallback() {

            @Override
            public void onFinish() {
                // scan finished
            }

            @Override
            public void onDevice(BluetoothDevice device) {
                // device found
            }

            @Override
            public void onPair(BluetoothDevice device) {
                // device paired
            }

            @Override
            public void onUnpair(BluetoothDevice device) {
                // device unpaired
            }

            @Override
            public void onError(String message) {
                // error occurred
            }
        });

        //This should be in the Scan Button's OnClick
        bluetooth.startScanning();
        //devices will be listed on a list view in the layout
        List<BluetoothDevice> devices = bluetooth.getPairedDevices();
        BluetoothDevice device = devices.get(2);
        //This should be in Pair Button's On Click
        bluetooth.pair(device);


        bluetooth.setCommunicationCallback(new CommunicationCallback() {
            @Override
            public void onConnect(BluetoothDevice device) {
                // device connected
            }

            @Override
            public void onDisconnect(BluetoothDevice device, String message) {
                // device disconnected
            }

            @Override
            public void onMessage(String message) {
                // message received (it has to end with a \n to be received)
            }

            @Override
            public void onError(String message) {
                // error occurred
            }

            @Override
            public void onConnectError(BluetoothDevice device, String message) {
                // error during connection
            }
        });

        bluetooth.connectToName("name");
        bluetooth.connectToAddress("address");
        bluetooth.connectToDevice(device);

        bluetooth.send("message");


    }

    @Override
    protected void onStart() {
        super.onStart();
        bluetooth.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bluetooth.onStop();
    }
}


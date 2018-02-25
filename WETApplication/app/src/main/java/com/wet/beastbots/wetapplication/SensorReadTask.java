package com.wet.beastbots.wetapplication;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.wet.beastbots.R;

import java.io.IOException;
import java.io.InputStream;

public class SensorReadTask extends AsyncTask<String, Integer, Long> {

    private BluetoothSocket btSocket = null;
    private BluetoothAdapter btAdapter = null;
    private InputStream inputStream = null;
    private Context context;


    public SensorReadTask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        btAdapter = BluetoothAdapter.getDefaultAdapter();
        try {
            inputStream = btSocket.getInputStream();
        } catch (IOException e) {
            Toast.makeText(context, "ERROR - Could not create bluetooth outstream", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected Long doInBackground(String... strings) {
        // Set up a pointer to the remote device using its address.
        BluetoothDevice device = btAdapter.getRemoteDevice(BluetoothConnectActivity.connectedDeviceAddress);

        //Attempt to create a bluetooth socket for comms
        try {
            btSocket = device.createRfcommSocketToServiceRecord(BluetoothConnectActivity.BTMODULEUUID);
        } catch (IOException e1) {
            Toast.makeText(context, "ERROR - Could not create Bluetooth socket", Toast.LENGTH_SHORT).show();
        }

        // Establish the connection.
        try {
            btSocket.connect();
        } catch (IOException e) {
            try {
                btSocket.close();        //If IO exception occurs attempt to close socket
            } catch (IOException e2) {
                Toast.makeText(context, "ERROR - Could not close Bluetooth socket", Toast.LENGTH_SHORT).show();
            }
        }

        // Create a data stream so we can talk to the device
        try {
            inputStream = btSocket.getInputStream();
        } catch (IOException e) {
            Toast.makeText(context, "ERROR - Could not create bluetooth outstream", Toast.LENGTH_SHORT).show();
        }
        return 0L;
    }

    private void Data(String message) {
        byte[] msgBuffer = message.getBytes();

        try {
            //attempt to place data on the outstream to the BT device
            inputStream.read(msgBuffer);
        } catch (IOException e) {
            //if the sending fails this is most likely because device is no longer there
            Toast.makeText(context, "ERROR - Device not found", Toast.LENGTH_SHORT).show();
        }
    }
}

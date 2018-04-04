package com.wet.beastbots.wetapplication;

/**
 * Created by johan on 3/30/18.
 */

public class BluetoothPublisher {
    private static final BluetoothPublisher ourInstance = new BluetoothPublisher();
    private ISensorDataPublish sensorDataPublisher;

    public static BluetoothPublisher getInstance() {
        return ourInstance;
    }

    private BluetoothPublisher() {
    }

    public void setPublisher(ISensorDataPublish publisher) {
        this.sensorDataPublisher = publisher;
    }

    public void publishData(String data) {
        if(sensorDataPublisher != null)
            sensorDataPublisher.onSensorData(data);
    }
}

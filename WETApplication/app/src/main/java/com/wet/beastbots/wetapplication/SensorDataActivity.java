package com.wet.beastbots.wetapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.widget.TextView;

import com.wet.beastbots.R;

/**
 * Created by johan on 3/28/18.
 */

public class SensorDataActivity extends AppCompatActivity {
    TextView dataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowsensor_data);

        dataTextView = (TextView) this.findViewById(R.id.flowsensor_data_text);
        //dataTextView.setMovementMethod(new ScrollingMovementMethod());

        BluetoothPublisher.getInstance().setPublisher(new ISensorDataPublish() {
            @Override
            public void onSensorData(String data) {
                dataTextView.append(data);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case android.R.id.home:
                setResult(Activity.RESULT_OK);
                this.finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_OK);
        this.finish();
    }
}

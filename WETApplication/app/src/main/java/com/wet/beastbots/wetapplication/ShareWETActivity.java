package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wet.beastbots.R;

public class ShareWETActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button shareWetButton = (Button) this.findViewById(R.id.share_button);
        shareWetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ShareWETActivity.this, "Thank you for your sharing WET", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"", "keshavwarrier@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "WET");
                i.putExtra(Intent.EXTRA_TEXT, "Type ");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }
                    catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(ShareWETActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

                    }

            }
        });

        Button sumbitbuttonquestion = (Button) this.findViewById(R.id.question_submit_button);
        sumbitbuttonquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText yourResponse = (EditText) ShareWETActivity.this.findViewById(R.id.question_response);
                int yourQuestion = Integer.parseInt(yourResponse.getText().toString().trim());
                Toast.makeText(ShareWETActivity.this, "Your question will be answered soon!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_SUBJECT, "The Water Efficiency Technologies");
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(ShareWETActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

}

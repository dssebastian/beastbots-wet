package com.wet.beastbots.wetapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.wet.beastbots.R;

public class FeedbackActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button sumbitbuttonfeedback = (Button) this.findViewById(R.id.feedback_submit_button);
        sumbitbuttonfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText yourResponse = (EditText) FeedbackActivity.this.findViewById(R.id.feedback_response);
                Toast.makeText(FeedbackActivity.this, "Thank you for your suggestion", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"johanmathew.george@gmail.com", "advaygoel@gmail.com", "jagdish.bakshi@gmail.com", "keshavwarrier@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "User Feedback");
                i.putExtra(Intent.EXTRA_TEXT   , yourResponse.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }
                    catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(FeedbackActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

                    }

            }
        });

        Button sumbitbuttonquestion = (Button) this.findViewById(R.id.question_submit_button);
        sumbitbuttonquestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText yourResponse = (EditText) FeedbackActivity.this.findViewById(R.id.question_response);
                int yourQuestion = Integer.parseInt(yourResponse.getText().toString().trim());
                Toast.makeText(FeedbackActivity.this, "Your question will be answered soon!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("message/rfc822");
                i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"johanmathew.george@gmail.com", "advaygoel@gmail.com", "jagdish.bakshi@gmail.com", "keshavwarrier@gmail.com"});
                i.putExtra(Intent.EXTRA_SUBJECT, "User Feedback");
                i.putExtra(Intent.EXTRA_TEXT   , yourResponse.getText().toString());
                try {
                    startActivity(Intent.createChooser(i, "Send mail..."));
                }
                catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(FeedbackActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

}

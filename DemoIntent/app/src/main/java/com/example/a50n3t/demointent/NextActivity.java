package com.example.a50n3t.demointent;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView numberTxt;
    TextView emailTxt;
    TextView uriTxt;

    Button btnCall;
    Button btnSms;
    Button btnEmail;
    Button btnUri;

    String number;
    String email;
    String uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        numberTxt = (TextView) findViewById(R.id.getNumber);
        emailTxt = (TextView) findViewById(R.id.getEmail);
        uriTxt = (TextView) findViewById(R.id.getUrl);

        btnCall = (Button) findViewById(R.id.callNumber);
        btnSms = (Button) findViewById(R.id.smsNumber);
        btnEmail = (Button) findViewById(R.id.sendEmail);
        btnUri = (Button) findViewById(R.id.accessUrl);

        number = getIntent().getStringExtra("Number");
        email = getIntent().getStringExtra("Email");
        uri = getIntent().getStringExtra("Url");

        numberTxt.setText(number);
        emailTxt.setText(email);
        uriTxt.setText(uri);
    }

    public void backMethod(View view) {

        Intent backIntent = new Intent(this,MainActivity.class);
        startActivity(backIntent);

    }

    public void callNumber(View view) {

        String number = numberTxt.getText().toString().trim();

        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null));
        startActivity(intent);
    }

    public void smsNumber(View view) {

        String number = numberTxt.getText().toString().trim();
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));

    }

    public void sendEmail(View view) {

        String email = emailTxt.getText().toString();

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:" + email));
        startActivity(Intent.createChooser(emailIntent, "Send mail"));

    }

    public void accessUrl(View view) {

        String url = "http://"+uriTxt.getText().toString();

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        Intent browserChooserIntent = Intent.createChooser(browserIntent , "Choose a browser");
        startActivity(browserChooserIntent );
    }
}

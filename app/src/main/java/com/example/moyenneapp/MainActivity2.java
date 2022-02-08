package com.example.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    String message ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
         message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView i1 = findViewById(R.id.textView3);
        i1.setText(message);
    }

    public void ToHome(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void composeSmsMessage(String Text ,String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setData(Uri.parse("smsto:"+phoneNumber)); // This ensures only SMS apps respond
        intent.putExtra("sms_body", Text);
        startActivity(intent);
    }

    public void SendSMS(View view) {
        /*Intent i = new Intent(this, MainActivity3.class);
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        startActivity(i);*/

        composeSmsMessage(message,"91587745");





    }
}
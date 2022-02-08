package com.example.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        TextView i1 = findViewById(R.id.textView3);
        i1.setText(message);
    }


    public void envoyer(View view) {
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);

    }
}
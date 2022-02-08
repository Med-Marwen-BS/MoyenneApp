package com.example.moyenneapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    AlertDialog.Builder builder;
    EditText note1 ;
    EditText note2;
    EditText note3;
    Button b1 ;
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        builder = new AlertDialog.Builder(this);

         note1 = findViewById(R.id.note1);
          note2 = findViewById(R.id.note2);
          note3 = findViewById(R.id.note3);
          b1 = findViewById(R.id.button);


        setContentView(R.layout.activity_main);

    }

    public void somme(View view) {
        note1 = findViewById(R.id.note1);
        note2 = findViewById(R.id.note2);
        note3 = findViewById(R.id.note3);
        if (TextUtils. isEmpty(note1. getText(). toString()) || TextUtils. isEmpty(note2. getText(). toString())
        || TextUtils. isEmpty(note3. getText(). toString())) {
            //Uncomment the below code to Set the message and title from the strings.xml file
            builder.setMessage(R.string.dialog_message) .setTitle(R.string.dialog_title);

            //Setting message manually and performing action on button click
            builder.setMessage(R.string.dialog_message)
                    .setCancelable(false)
                    .setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            //  Action for 'NO' Button
                            dialog.cancel();

                        }
                    });
            //Creating dialog box
            AlertDialog alert = builder.create();
            //Setting the title manually
            alert.setTitle(R.string.dialog_title);
            alert.show();

           /* Context context = getApplicationContext();
            CharSequence text = "Hello toast!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();*/
        }else {
            double moyenne = (Double.parseDouble(note1.getText().toString())+Double.parseDouble(note2.getText().toString())
                    +Double.parseDouble(note3.getText().toString()))/3;
            Intent intent = new Intent(this, MainActivity2.class);
            if(moyenne >= 10 ){
                String message = "Felicitation vous aver reussi avec la moyenne : "+moyenne;
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }else{

                String message = "Dommage vous n'aver pas reussi et  \nla moyenne : "+moyenne;
                intent.putExtra(EXTRA_MESSAGE, message);

                startActivity(intent);
            }
        }


    }
}
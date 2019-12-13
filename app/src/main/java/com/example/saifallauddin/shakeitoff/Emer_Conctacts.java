package com.example.saifallauddin.shakeitoff;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.SharedPreferences;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Emer_Conctacts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emer__conctacts);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button button = findViewById(R.id.updVals);

        EditText text1=(EditText)findViewById(R.id.Num1);
        text1.setText("9948279993");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText text1=(EditText)findViewById(R.id.Num1);
                final String s1=text1.getText().toString();
                EditText text2=(EditText)findViewById(R.id.Num2);
                final String s2=text2.getText().toString();
                EditText text3=(EditText)findViewById(R.id.Num3);
                final String s3=text3.getText().toString();
                EditText text4=(EditText)findViewById(R.id.Num4);
                final String s4=text4.getText().toString();
                EditText text5=(EditText)findViewById(R.id.Num5);
                final String s5=text5.getText().toString();

                String mblNumVar = s1 + ";" + s2 + ";"+ s3 + ";"+ s4 + ";"+ s5+";";

                String s = new String(android.os.Environment
                        .getExternalStorageDirectory()
                        + File.separator + "ShakeitOff" + File.separator);
                String textFile = "main.txt";
                if (!new File(s).exists()) {
                    new File(s).mkdir();
                }
                File f = new File(s + textFile);

                try {
                    FileOutputStream stream = new FileOutputStream(f);
                    try {
                        stream.write(mblNumVar.getBytes());
                    } finally {
                        stream.close();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


    }

}

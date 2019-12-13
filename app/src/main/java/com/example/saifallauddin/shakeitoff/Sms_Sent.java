package com.example.saifallauddin.shakeitoff;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class Sms_Sent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms__sent);
        String mblNumVar = "9490530658;8309452677;9948279993";
        Intent smsMsgAppVar = new Intent(Intent.ACTION_SENDTO);
        smsMsgAppVar.setData(Uri.parse("sms:" +  mblNumVar));
        smsMsgAppVar.putExtra("sms_body", "they are killing my ass");
    }

}

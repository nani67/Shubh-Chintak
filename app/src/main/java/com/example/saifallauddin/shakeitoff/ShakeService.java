package com.example.saifallauddin.shakeitoff;

import android.app.Service;
import android.content.Intent;

import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.hardware.SensorEventListener;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.content.Context;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ShakeService extends Service {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;
    public boolean twice;
    public boolean b;
    public ShakeService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        mShakeDetector = new ShakeDetector();
        mShakeDetector.setOnShakeListener(new ShakeDetector.OnShakeListener() {

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onShake(int count) {


                if(twice==false) {
                /*Intent i = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.example.saifallauddin.shakeitoff");
                getApplicationContext().startActivity(i);*/


                String mob1 = "";
                    try {

                        String s = new String(android.os.Environment
                                .getExternalStorageDirectory()
                                + File.separator + "ShakeitOff" + File.separator);

                        String textFile = "main.txt";

                         mob1 = new String(Files.readAllBytes(Paths.get(s+textFile)));
                         Log.d("Shake","Message failed" + mob1);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    //"7416923811;8309452677;9948279993;9491607789";
                    Intent smsMsgAppVar = new Intent(Intent.ACTION_SENDTO);
                    smsMsgAppVar.setData(Uri.parse("sms:" + mob1));
                    smsMsgAppVar.putExtra("sms_body", "Help me Please! 17.5203N 78.3674E");
                    startActivity(smsMsgAppVar);
               /* Intent i=new Intent(getApplicationContext(),Sms_Sent.class);
                startActivity(i);*/
               twice=true;
                }
            }

        });
        mSensorManager.registerListener(mShakeDetector, mAccelerometer, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onDestroy() {
        mSensorManager.unregisterListener(mShakeDetector);
        super.onDestroy();
    }
}
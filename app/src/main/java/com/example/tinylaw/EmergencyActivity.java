package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Camera;
import android.hardware.camera2.CameraManager;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyActivity extends AppCompatActivity {

    /*
    //Fields and constants
    private TextView mTextView;
    private ContentResolver contentResolver;
    private Window window;
    private final int userBrightness = 225;
    private final int brightness = 0;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initial state
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        Button stopButton = findViewById(R.id.exit);

        //Send texts to emergency contact

        //Start video recording
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, 1);
        }

        //Stop video on button press

        //Save video to gallery
        //Uri videoUri = <some intent, idrk>data.getData();

        //Everything in green is old code!!

        /**
        //Starting emergency response feature by checking settings permission
        if (checkSystemWritePermission()) {
            contentResolver = getContentResolver();
            window = getWindow();

            //Turns off auto-brightness
            try {
                Settings.System.putInt(contentResolver,
                        Settings.System.SCREEN_BRIGHTNESS_MODE, Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
            } catch (Exception e) {
                Log.e("Error", "No access");
            }

            //Stores user's current brightness setting
            //userBrightness = (int)window.getAttributes().screenBrightness;
            Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
            WindowManager.LayoutParams layout = window.getAttributes();

            //Sets minimum brightness to layout object and screen
            layout.screenBrightness = brightness;
            window.setAttributes(layout);
        } else {
            //Black screen
            int i = 0;
        }


        //Acquire emergency contacts, send initial message


        //Check for camera, start recording, save output vid file
        final int REQUEST_VIDEO_CAPTURE = 1;
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
        Intent getVideoIntent = newIntent(MediaStore.);
        Uri videoUri = intent.getData();
        videoView.setVideoURI(videoUri);


        //Send output vid file to emergency contacts

        //Wait for screen tap, right now this is just a time delay,
        //need to implement a screen-sized black button
        try {
            Thread.sleep(2000); //1000 milliseconds is one second.
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


        //Restores user's original brightness setting
        if (checkSystemWritePermission()) {
            contentResolver = getContentResolver();
            window = getWindow();
            Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, userBrightness);
            WindowManager.LayoutParams layout = window.getAttributes();
            //Sets minimum brightness to layout object and screen
            layout.screenBrightness = userBrightness;
            window.setAttributes(layout);
        } else {
            //Undo black screen
            int i = 0;
        }
         */

    }

    /**
    private boolean checkSystemWritePermission() {
        boolean val = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val = Settings.System.canWrite(this);
            Log.d("Permission:", "Can Write Settings: " + val);
            if(val){
                Toast.makeText(this, "Write allowed :-)", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Write not allowed :-(", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + this.getPackageName()));
                startActivity(intent);
            }
        }
        return val;
    }
     */
}


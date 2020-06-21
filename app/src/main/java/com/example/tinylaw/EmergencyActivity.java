package com.example.tinylaw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class EmergencyActivity extends AppCompatActivity {

    //Fields and constants
    private TextView mTextView;
    private ContentResolver contentResolver;
    private Window window;
    private int userBrightness;
    private final int brightness = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Initial state
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        mTextView = findViewById(R.id.text);
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
            userBrightness = (int)window.getAttributes().screenBrightness;
            Settings.System.putInt(contentResolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
            WindowManager.LayoutParams layout = window.getAttributes();
            //Sets minimum brightness to layout object and screen
            layout.screenBrightness = brightness;
            window.setAttributes(layout);

            //Acquire emergency contacts, send initial message

            //Start recording, save output vid file
            if (hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                //
            }

            //Send output vid file to emergency contacts

            //Restores user's original brightness setting
            layout.screenBrightness = userBrightness;
            window.setAttributes(layout);
        }
    }

    private boolean checkSystemWritePermission() {
        boolean retVal = true;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            retVal = Settings.System.canWrite(this);
            Log.d("Permission:", "Can Write Settings: " + retVal);
            if(retVal){
                Toast.makeText(this, "Write allowed :-)", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, "Write not allowed :-(", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS);
                intent.setData(Uri.parse("package:" + this.getPackageName()));
                startActivity(intent);
            }
        }
        return retVal;
    }
}


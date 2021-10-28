package com.zral.ikun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.os.Vibrator;
import android.app.Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image1 = (ImageView) findViewById(R.id.img1);
        Bitmap bitmap = getLoacalBitmap("ikun1.png");
        image1.setImageBitmap(bitmap);
        Vibrator vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        vibrator.vibrate(1000000);
    }

    private Bitmap getLoacalBitmap(String url) {
        AssetManager assetManager = getAssets();
        try (InputStream is = assetManager.open(url)) {
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
}
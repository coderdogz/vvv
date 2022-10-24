package com.zral.ikun;

import android.app.Service;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    private EditText EditText1;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String flag = "123";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView image1 = (ImageView) findViewById(R.id.img1);
        EditText1 = findViewById(R.id.EditText1);
        button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("flag", flag);
                Log.i("flag", String.valueOf(EditText1.getText()));
                if (String.valueOf(EditText1.getText()).equals(flag)) {
                    Bitmap bitmap = getLoacalBitmap();
                    image1.setImageBitmap(bitmap);
                    Vibrator vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
                    vibrator.vibrate(1000000);
                }else {
                    Toast.makeText(MainActivity.this,"你是豬嗎",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private Bitmap getLoacalBitmap() {
        AssetManager assetManager = getAssets();
        try (InputStream is = assetManager.open("ikun1.png")) {
            return BitmapFactory.decodeStream(is);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }
}
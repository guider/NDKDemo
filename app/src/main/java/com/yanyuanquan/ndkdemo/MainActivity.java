package com.yanyuanquan.ndkdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    static {

        System.loadLibrary("Lib");

    }

    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.c).setOnClickListener(this);
        findViewById(R.id.java).setOnClickListener(this);
        findViewById(R.id.origin).setOnClickListener(this);
        imageView = (ImageView) findViewById(R.id.image);
    }

    @Override
    public void onClick(View v) {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        switch (v.getId()) {
            case R.id.c:

                break;
            case R.id.java:
                bitmap = ImgaeUtil.getBitmapByJava(bitmap);

                break;
            default:

                break;
        }
        imageView.setImageBitmap(bitmap);
    }
}

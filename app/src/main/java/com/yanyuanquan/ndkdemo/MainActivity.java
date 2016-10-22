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
                bitmap = getBitmap(bitmap);
                break;
            case R.id.java:
                bitmap = ImgaeUtil.getBitmapByJava(bitmap);

                break;
            default:

                break;
        }
        imageView.setImageBitmap(bitmap);
    }

    private Bitmap getBitmap(Bitmap bitmap) {
        int h = bitmap.getHeight();
        int w = bitmap.getWidth();
        int[] arr = new int[bitmap.getWidth() * bitmap.getHeight()];
        for (int i = 0; i < bitmap.getWidth(); i++) {
            for (int j = 0; j < bitmap.getHeight(); j++) {
                arr[i * j + j] = bitmap.getPixel(i, j);
            }
        }

        int[] resultArr = JNIUtil.getBitmapByNDK(arr, bitmap.getWidth(), bitmap.getHeight());

        Bitmap resultBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
        for (int i = 0; i < resultArr.length; i++) {
            resultBitmap.setPixel(i % h, i / w, resultArr[i]);
        }

        return resultBitmap;
    }
}

package com.yanyuanquan.ndkdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    static {

        System.loadLibrary("Lib");

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
     TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(new JNIUtil().getString());

    }
}
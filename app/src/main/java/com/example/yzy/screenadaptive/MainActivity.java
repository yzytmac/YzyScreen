package com.example.yzy.screenadaptive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yzyscreenadaptive.ViewUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);
        ViewUtil.getInstance(this).setLayoutParams(mTv,1080/2,(1920-72)/2,0,0,0,0);
    }
}

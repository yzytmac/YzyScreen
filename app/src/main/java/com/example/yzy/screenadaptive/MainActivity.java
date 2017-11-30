package com.example.yzy.screenadaptive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.yzyscreenadaptive.ViewUtil;

public class MainActivity extends AppCompatActivity {

    private TextView mTv;
    private TextView mTv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTv = (TextView) findViewById(R.id.tv);
        mTv2 = (TextView) findViewById(R.id.tv2);
//        ViewUtil.getInstance(this,1080,1920).setLayoutParams(mTv,1080/10,(1920-72)/3,50,50,0,0);
//        ViewUtil.getInstance(this,1080,1920).setLayoutParams(mTv2,1080/10,(1920-72)/3,50,50,0,0);
    }
}

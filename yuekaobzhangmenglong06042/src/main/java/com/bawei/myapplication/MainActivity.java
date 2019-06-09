package com.bawei.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bawei.Base.BaseActivity;
import com.bawei.Fragment.Fragment1;
import com.bawei.Fragment.Fragment2;

public class MainActivity extends BaseActivity {
    private FrameLayout left;
    private RadioGroup radio;
    private RadioButton btn1, btn2;
    private Fragment2 fragment2;
    private Fragment1 fragment1;
    private FragmentManager manager;
    private ImageView phone;

    @Override
    public int onLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void OnInit() {
        left = findViewById(R.id.left);
        radio = findViewById(R.id.radio);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        phone = findViewById(R.id.phone);
    }

    @Override
    public void OnDasta() {
        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        manager = getSupportFragmentManager();
        manager.beginTransaction()
                .add(R.id.left, fragment1).show(fragment1)
                .add(R.id.left, fragment2).show(fragment2)
                .commit();
    }

    @Override
    public void OnLinstener() {
        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.btn1:
                        manager.beginTransaction().show(fragment1).hide(fragment2).commit();
                        break;
                    case R.id.btn2:
                        manager.beginTransaction().show(fragment2).hide(fragment1).commit();
                        break;
                }
            }
        });

    }



}

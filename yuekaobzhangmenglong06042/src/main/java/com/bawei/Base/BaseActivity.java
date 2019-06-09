package com.bawei.Base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.bawei.myapplication.R;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:09:52
 *@Description:
 * */public abstract class BaseActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(onLayout());
        onLayout();//添加布局
        OnInit();//初始化控件
        OnDasta();//添加数据
        OnLinstener();//添加监听
    }
    public abstract int onLayout();//添加布局
    public abstract void OnInit();//初始化控件
    public abstract void OnDasta();//添加数据
    public abstract void OnLinstener();//添加监听

}

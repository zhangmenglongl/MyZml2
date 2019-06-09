package com.bawei.Base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:09:57
 *@Description:
 * */public abstract class BaseFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate( onLayout(),null);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
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

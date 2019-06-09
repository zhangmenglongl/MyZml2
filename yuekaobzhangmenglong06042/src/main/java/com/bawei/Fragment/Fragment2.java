package com.bawei.Fragment;

import android.view.View;
import android.webkit.WebView;

import com.bawei.Base.BaseFragment;
import com.bawei.myapplication.R;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:09:57
 *@Description:
 * */public class Fragment2 extends BaseFragment {
     private WebView tab;
    @Override
    public int onLayout() {
        return R.layout.fragment2;
    }

    @Override
    public void OnInit() {
        tab=getActivity().findViewById(R.id.tab);
          tab.loadUrl("file:///android_asset/Baway_DetailView.html");

    }

    @Override
    public void OnDasta() {

    }

    @Override
    public void OnLinstener() {

    }
}

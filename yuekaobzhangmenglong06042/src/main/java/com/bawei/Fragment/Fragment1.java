package com.bawei.Fragment;

import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bawei.Adapter.MyAdapter;
import com.bawei.Base.BaseFragment;
import com.bawei.Base.MyList;
import com.bawei.Bean.BeanL;
import com.bawei.Bean.BeanT;
import com.bawei.HttpUtil.Httphtil;
import com.bawei.myapplication.R;
import com.bumptech.glide.Glide;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:09:57
 *@Description:
 * */public class Fragment1 extends BaseFragment {
    private PullToRefreshScrollView pull;
    private Banner ban;
    private MyList list_view;
    private ArrayList<BeanL> listl = new ArrayList<>();
    private ArrayList<BeanT> listt = new ArrayList<>();
    private String strt = "http://172.17.8.100/small/commodity/v1/bannerShow";
    private String strl = "http://172.17.8.100/movieApi/movie/v1/findHotMovieList?count=5&page=";
    private int page=1;
    private MyAdapter myAdapter;

    @Override
    public int onLayout() {
        return R.layout.fragment1;
    }

    @Override
    public void OnInit() {
        pull = getActivity().findViewById(R.id.pull);
        ban = getActivity().findViewById(R.id.ban);
        list_view = getActivity().findViewById(R.id.list_view);
    }

    @Override
    public void OnDasta() {
        setDataT();//轮播图展示
        myAdapter = new MyAdapter(listl, getActivity());
        list_view.setAdapter(myAdapter);
        setDataL();//list展示


    }

    private void setDataL() {
        Httphtil.getGyy(strl+page, new Httphtil.getFyy() {
            @Override
            public void getDyy(String s) {

                try {
                    JSONObject object = new JSONObject(s);

                    JSONArray result = object.getJSONArray("result");
                    for (int i = 0; i < result.length(); i++) {
                        JSONObject jsonObject = (JSONObject) result.get(i);
                        String imageUrl = jsonObject.getString("imageUrl");
                        String name = jsonObject.getString("name");
                        String summary = jsonObject.getString("summary");
                        listl.add(new BeanL(imageUrl, name, summary));
                    }
                    myAdapter.notifyDataSetChanged();
                    pull.onRefreshComplete();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private void setDataT() {
        Httphtil.getGyy(strt, new Httphtil.getFyy() {
            @Override
            public void getDyy(String s) {
                try {
                    JSONObject object = new JSONObject(s);
                    JSONArray result = object.getJSONArray("result");

                    for (int i = 0; i < result.length(); i++) {
                        JSONObject jsonObject = (JSONObject) result.get(i);
                        String imageUrl = jsonObject.getString("imageUrl");
                        String title = jsonObject.getString("title");
                        listt.add(new BeanT(imageUrl, title));
                    }
                    ban.setImageLoader(new ImageLoader() {
                        @Override
                        public void displayImage(Context context, Object path, ImageView imageView) {
                            BeanT beanT = (BeanT) path;
                            Glide.with(context).load(beanT.getImageUrl()).into(imageView);
                        }
                    });
                    ban.setImages(listt);
                    ban.isAutoPlay(true);
                    ban.setDelayTime(2000);
                    ban.start();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public void OnLinstener() {

    }
}

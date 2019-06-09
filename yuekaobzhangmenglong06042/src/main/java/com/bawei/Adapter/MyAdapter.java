package com.bawei.Adapter;

import android.content.Context;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.Bean.BeanL;
import com.bawei.myapplication.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:10:26
 *@Description:
 * */public class MyAdapter extends BaseAdapter {
     private ArrayList<BeanL> list;
     private Context context;

    public MyAdapter(ArrayList<BeanL> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch (getItemViewType(position)){
            case 0:
                ViewHolder1 holder1 = new ViewHolder1();
                if (convertView==null){
                    convertView = View.inflate(context,R.layout.list1,null);
                    holder1.img1 = convertView.findViewById(R.id.img1);
                    holder1.name1 = convertView.findViewById(R.id.name1);
                    holder1.pwd1 =convertView.findViewById(R.id.pwd1);
                    convertView.setTag(holder1);
                }
                else{
                   holder1 =(ViewHolder1) convertView.getTag();
                }
                holder1.name1.setText(list.get(position).getSummary());
                holder1.pwd1.setText(list.get(position).getName());
                Glide.with(context).load(list.get(position).getImageUrl()).into(holder1.img1);
                break;
            case 1:
                ViewHolder2 holder2 = new ViewHolder2();
                if (convertView==null){
                    convertView = View.inflate(context,R.layout.list2,null);
                    holder2.img2 = convertView.findViewById(R.id.img2);
                    holder2.name2 = convertView.findViewById(R.id.name2);
                    holder2.pwd2 =convertView.findViewById(R.id.pwd2);
                    convertView.setTag(holder2);
                }
                else{
                    holder2 =(ViewHolder2) convertView.getTag();
                }
                holder2.name2.setText(list.get(position).getSummary());
                holder2.pwd2.setText(list.get(position).getName());
                Glide.with(context).load(list.get(position).getImageUrl()).into(holder2.img2);
                break;
        }

        return convertView;
    }
    class ViewHolder1{
        private ImageView img1;
        private TextView name1,pwd1;
    }
    class ViewHolder2{
        private ImageView img2;
        private TextView name2,pwd2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return position % 2;
    }
}

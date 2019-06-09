package com.bawei.HttpUtil;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 *@Auther:张梦龙
 *@Date: 19/06/04
 *@Time:10:08
 *@Description:
 * */public class Httphtil {
     public static String getString(String strs){
         HttpURLConnection connection = null;
         try {
             URL url = new URL(strs);
            connection =(HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
             int code = connection.getResponseCode();
             if (code==200){
                 InputStream stream = connection.getInputStream();
                 BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
                 String str ="";
                 StringBuffer buffer = new StringBuffer();
                 while ((str=reader.readLine())!=null){
                     buffer.append(str);
                 }
                 reader.close();
                 return buffer.toString();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         connection.disconnect();
         return "";
     }
     public static  void  getGyy(String str, final getFyy fyy){
         new AsyncTask<String, Integer, String>() {
             @Override
             protected String doInBackground(String... strings) {
                 return getString(strings[0]);
             }

             @Override
             protected void onPostExecute(String s) {
                 super.onPostExecute(s);
                 fyy.getDyy(s);
             }
         }.execute(str);
     }
     public interface getFyy{
         void getDyy(String s);
     }
}

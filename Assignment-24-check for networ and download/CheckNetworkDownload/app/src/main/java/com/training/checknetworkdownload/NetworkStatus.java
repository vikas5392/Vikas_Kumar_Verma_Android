package com.training.checknetworkdownload;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetworkStatus {
  static String state=null;
  static String net_name=null;


    public static String networkName(Context context){
        ConnectivityManager cm=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo net_info=cm.getActiveNetworkInfo();
        if(net_info!=null&&net_info.isAvailable()&&net_info.isConnected()){
            if(net_info.getType()==ConnectivityManager.TYPE_WIFI)
            {
                net_name="Connected to WIFI";
            }
           else if(net_info.getType()==ConnectivityManager.TYPE_MOBILE)
            {
                net_name="Connected to Mobile Data";
            }
        }
    return net_name;}

}

package com.kiwilss.meituan.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * @author : Lss kiwilss
 * @FileName: Utils
 * @e-mail : kiwilss@163.com
 * @time : 2020/6/12
 * @desc : {DESCRIPTION}
 */
public class Utils {

    public static String getChannelName(Context context){
        if (context == null) {
            return null;
        }
        String channelName = null;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(
                        context.getPackageName(),
                        PackageManager.GET_META_DATA
                );
                    if (applicationInfo.metaData != null) {
                        channelName = applicationInfo.metaData.getString("ATMAN_CHANNEL");
                    }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelName;
    }
    /**
     * 获取渠道名
     *
     * @param ctx 此处习惯性的设置为activity，实际上context就可以
     * @return 如果没有获取成功，那么返回值为空
     */
    public static String getUMChannelName(Context ctx) {
        if (ctx == null) {
            return null;
        }
        String channelName = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                //注意此处为ApplicationInfo 而不是 ActivityInfo,因为友盟设置的meta-data是在application标签中，而不是某activity标签中，所以用ApplicationInfo
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        channelName = applicationInfo.metaData.getString("UMENG_CHANNEL");
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channelName;

    }
//    public static String getChannelName(Context context){
//        if(context == null){
//            return "";
//        }
//        return WalleChannelReader.getChannel(context,"");
//    }

}

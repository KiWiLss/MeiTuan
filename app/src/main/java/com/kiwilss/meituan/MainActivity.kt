package com.kiwilss.meituan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.meituan.utils.Utils
import com.umeng.analytics.AnalyticsConfig
import com.umeng.analytics.MobclickAgent





class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //获取自定义渠道名
        //Log.e("MMM", ": channel=" + Utils.getChannelName(this));
        //获取友盟渠道名
        Log.e("MMM", ": um--channel=" + Utils.getUMChannelName(this));

        //友盟提供的方法获取渠道名,要提前将渠道传给友盟,这个方法才能获取到渠道名称
        val channelName = AnalyticsConfig.getChannel(this)
        Log.e("MMM", ": um name=$channelName");
    }

    override fun onResume() {
        super.onResume()
        MobclickAgent.onResume(this)
    }

    override fun onPause() {
        super.onPause()
        MobclickAgent.onPause(this)
    }
}

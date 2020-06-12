package com.kiwilss.meituan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.meituan.utils.Utils
import com.meituan.android.walle.WalleChannelReader


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("MMM", ": channel=" + Utils.getChannelName(this));
        val channel = WalleChannelReader.getChannel(this.applicationContext)
        Log.e("MMM", ":walle= $channel");
            //获取渠道方法二 ji
        val channelInfo =
            WalleChannelReader.getChannelInfo(this.applicationContext)
        if (channelInfo != null) {
            val channel = channelInfo.channel
            val extraInfo = channelInfo.extraInfo
            Log.e("MMM", ": channel=$channel------info=$extraInfo");
        }
    }


}

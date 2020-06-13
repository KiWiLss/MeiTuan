/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: MyApp
 * Author:   kiwilss
 * Date:     2020/6/12 23:53
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss

import android.app.Application
import com.kiwilss.meituan.utils.Utils
import com.umeng.analytics.MobclickAgent
import com.umeng.commonsdk.UMConfigure


/**
 *@FileName: MyApp
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/6/12
 * @desc   : {DESCRIPTION}
 */
class MyApp : Application(){
    override fun onCreate() {
        super.onCreate()
        //初始化组件化基础库, 所有友盟业务SDK都必须调用此初始化接口。
//建议在宿主App的Application.onCreate函数中调用基础组件库初始化函数。

        //加入渠道名称,上传给友盟
        UMConfigure.init(this, "5ee3a498dbc2ec076dd4732b",
            Utils.getUMChannelName(this), UMConfigure.DEVICE_TYPE_PHONE, "")
        UMConfigure.setLogEnabled(true)
    }
}
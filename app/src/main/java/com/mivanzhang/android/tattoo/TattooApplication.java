package com.mivanzhang.android.tattoo;

import android.app.Application;

import com.wanjian.sak.config.Config;

/**
 * Created by zhangmeng on 2017/11/18.
 */

public class TattooApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Config config = new Config.Build(this).addLayer(new Tattoolayer(this)).build();
        com.wanjian.sak.SAK.init(this,config);
    }
}

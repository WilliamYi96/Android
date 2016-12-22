package com.example.dell1.purereading;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by williamyi on 2016/10/29.
 * Email:williamyi96@gmail.com
 */

public class WelcomeActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_welcome);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        };

        //如果设置了欢迎界面不显示，那么就直接从当前页面跳转到主页面
        if (!isShowWelcome(this)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            this.finish();
        } else {
            //pay attention to the use of new thread
            new Thread() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(2000);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    }

    public static final String APP_NAME = "PureReading";
    public static final String KEY_SHOW_WELCOME = "show_welcome";
    public static boolean isShowWelcome(Context context) {
        //1. 取得SP对象
        //what is the meaning of MODE_PRIVATE
        SharedPreferences sp = context.getSharedPreferences(APP_NAME, MODE_PRIVATE);
        //2. 按键值取数据并确定缺省值
        return sp.getBoolean(KEY_SHOW_WELCOME, true);
    }
}


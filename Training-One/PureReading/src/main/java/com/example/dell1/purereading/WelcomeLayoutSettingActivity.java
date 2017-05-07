package com.example.dell1.purereading;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

/**
 * Created by williamyi on 2016/11/2.
 * Email: williamyi96@gmail.com
 */

public class WelcomeLayoutSettingActivity extends AppCompatActivity {
    CheckBox cbShow;
    Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout_setting);

        cbShow = (CheckBox) findViewById(R.id.cbshow);
        //初始化CheckBox的状态
        cbShow.setChecked(WelcomeActivity.isShowWelcome(this));
        //what is the meaning of this pointer??

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //点击按钮后读取checkBox的状态并保存
                saveShowState(cbShow.isChecked());
                WelcomeLayoutSettingActivity.this.finish();
            }
        });
    }

    //保存欢迎界面的展示状态
    public void saveShowState(boolean state) {
        //1.获取SP对象, what is the use of SharedPreferences
        SharedPreferences sp = getSharedPreferences(WelcomeActivity.APP_NAME,MODE_PRIVATE);
        //2.通过SP对象的edit()得到editor对象
        SharedPreferences.Editor editor = sp.edit();
        //3.按键值存储数据
        editor.putBoolean(WelcomeActivity.KEY_SHOW_WELCOME, state);
        //4.存储完成之后将数据进行提交
        editor.commit();
    }
}


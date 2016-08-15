package com.example.dell1.actionbar;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取该Activity的ActionBar
        //只有当应用主题没有关闭ActionBar时，该代码才能返回ActionBar
        actionBar = getSupportActionBar();
    }
    //为“显示ActionBar”按钮定义事件处理方法
    public void showActionBar(View source) {
        //显示ActionBar
        actionBar.show();
    }
    //为“隐藏ActionBar"按钮定义事件处理方法
    public void hideActionBar(View source) {
        //隐藏ActionBar
        actionBar.hide();
    }
}

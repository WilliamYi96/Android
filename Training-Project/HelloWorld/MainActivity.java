package com.example.dell1.helloworld;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用activity_main.xml 文件定义的界面布局
        setContentView(R.layout.activity_main);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.Menu.menu_main, menu);
//        return true;
//    }

    public void clickHandler(View source) {
        //获取UI界中ID为R.id.show的文本框
        TextView tv = (TextView) findViewById(R.id.show);
        //改变文本框的文本内容
        tv.setText("Hello Android-" + new java.util.Date());
    }
}

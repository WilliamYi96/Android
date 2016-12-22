package com.example.dell1.purereading;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;

/**
 * Created by williamyi on 2016/10/29.
 * Email:williamyi96@gmail.com
 */

public class BookInfoEditActivity extends AppCompatActivity {
    EditText etName, etTime, etType, etURL, etRemarks;
    Button btnSave;
    int methodMode;
    int editMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info_edit);

        etName = (EditText) findViewById(R.id.etName);
        etTime = (EditText) findViewById(R.id.etTime);
        etType = (EditText) findViewById(R.id.etType);
        etURL = (EditText) findViewById(R.id.etURL);
        etRemarks = (EditText) findViewById(R.id.etRemarks);
        btnSave = (Button) findViewById(R.id.btnSave);
        init();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = etName.getText().toString();
                String time = etTime.getText().toString();
                String type = etType.getText().toString();
                String url = etURL.getText().toString();
                String remarks = etRemarks.getText().toString();
                switch (methodMode) {
                    case MainActivity.MODE_METHOD_SQL:
                        saveDataBySQL(name, time, type, url, remarks);
                        break;
                    case MainActivity.MODE_METHOD_ORM:
                        saveDataByORM(name, time, type, url, remarks);
                        break;
                    default:
                        Toast.makeText(BookInfoEditActivity.this, "error with method mode!", Toast.LENGTH_SHORT).show();
                        //how this can happen?
                }
                BookInfoEditActivity.this.finish();
            }
        });
    }

    //接受上个页面发送的数据并用于初始化界面
    int userID;

    //初始化
    void init() {
        Intent intent = getIntent();
        //what is the use of the function interger number
        methodMode = intent.getIntExtra(MainActivity.KEY_MODE_METHOD, -1);
        editMode = intent.getIntExtra(MainActivity.KEY_MODE_EDIT, -1);
        if (editMode == MainActivity.MODE_EDIT_UPDATE) {
            Bundle data = intent.getBundleExtra(MainActivity.KEY_DATA);
            userID = data.getInt(MainActivity.KEY_DATA_ID);
            String name = data.getString(MainActivity.KEY_DATA_NAME);
            String time = data.getString(MainActivity.KEY_DATA_TIME);
            etName.setText(name);

        }
    }

    //插入和修改数据的SQL实现
    void saveDataBySQL(String name, String time, String type, String url, String remarks) {
        //sql初始化
        //1. 创建工具类对象
        DBHelperSQL sqlHelper = new DBHelperSQL(this);
        //2.取得可写的数据库对象
        SQLiteDatabase dbWrite = sqlHelper.getWritableDatabase();
        //3.1构造一条数据
        ContentValues cv = new ContentValues();
        cv.put(DBHelperSQL.FIELD_NAME, name);
        cv.put(DBHelperSQL.FIELD_TIME, time);
        cv.put(DBHelperSQL.FIELD_TYPE, type);
        cv.put(DBHelperSQL.FIELD_URL, url);
        cv.put(DBHelperSQL.FIELD_REMARKS, remarks);
        switch (editMode) {
            case MainActivity.MODE_EDIT_ADD:
                //3.2调用insert方法写入数据库
                dbWrite.insert(DBHelperSQL.TABLE_NAME, null, cv);
                break;
            case MainActivity.MODE_EDIT_UPDATE:
                //3.3调用update方法更新数据
                dbWrite.update(DBHelperSQL.TABLE_NAME, cv, "id=?", new String[]{""+userID});
        }
        dbWrite.close();
        sqlHelper.close();
    }

    DBHelperORM helperORM;
    Dao<User, Integer> dao;

    //插入与修改数据的ORM实现
    void saveDataByORM(String name, String time, String type, String url, String remarks) {
        helperORM = new DBHelperORM(this);
        try {
            dao = helperORM.getUserDao();
            User user = new User(name, time, type, url, remarks);
            switch (editMode) {
                case MainActivity.MODE_EDIT_ADD:
                    try {
                        dao.create(user);
                    } catch (java.sql.SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                case MainActivity.MODE_EDIT_UPDATE:
                    user.setId(userID);
                    try {
                        dao.update(user);
                    } catch (java.sql.SQLException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Log.e("williamyi", "Fail to get UserDao");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (helperORM != null) helperORM = null;
        if (dao != null) dao = null;
    }
}
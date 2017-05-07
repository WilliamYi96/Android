package com.example.dell1.purereading;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by williamyi on 2016/10/29.
 * williamyi96@gmail.com
 */

public class DBHelperSQL extends SQLiteOpenHelper {
    //数据库名
    public static final String SQL_NAME = "db_sql";
    //表名
    public static final String TABLE_NAME = "user";
    //字段
    public static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_TIME = "time";
    public static final String FIELD_TYPE = "type";
    public static final String FIELD_URL = "url";
    public static final String FIELD_REMARKS = "remarks";

    public DBHelperSQL(Context context) {
        super(context, SQL_NAME, null, 1);
        //it is the correct use of SQL database
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //在数据库中建表
        //执行SQL语句，更多SQL语法可以搜索其他资料
        Log.e("williamyi", "create table " + TABLE_NAME);
        db.execSQL("CREATE TABLE " + TABLE_NAME + "(" +
                //主键id
                FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                //三个自定义字段
                FIELD_NAME + "TEXT DEFAULT \"\"," +
                FIELD_TIME + "TEXT ," +
                FIELD_TYPE + "TEXT ," +
                FIELD_URL + "TEXT ," +
                FIELD_REMARKS + "TEXT" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //数据库版本更新时需要进行的操作在这里进行
        Log.e("williamyi", "Sql is updated!");
    }
}


package com.example.dell1.purereading;

import com.j256.ormlite.field.DatabaseField;

/**
 * Created by dell1 on 2016/10/29.
 * Email:williamyi96@gmail.com
 */

public class User {
    //1. 加注解将该成员映射至数据库中的字段，generateId = true 表示主键
    @DatabaseField(generatedId = true)
    int id;
    //2. index表示排序依据
    @DatabaseField(index = true)
    String name;
    @DatabaseField
    String time;
    @DatabaseField
    String type;
    @DatabaseField
    String url;
    @DatabaseField
    String remarks;
    //3.必须有一个空的构造方法
    public User() {
        // needed by ormlite
    }
    //4.所有映射到数据库的成员必须有set与get方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    //what is the function of this method??
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", time=" + time +
                ", type=" + type +
                ", url=" + url +
                ", remarks='" + remarks + '\'' +
                '}';
    }

    public User(int id, String name, String time, String type, String url, String remarks) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.type = type;
        this.url = url;
        this.remarks = remarks;
    }
    //why there are one factor left out???
    public User(String name, String time, String type, String url, String remarks) {
        this.name = name;
        this.time = time;
        this.type = type;
        this.url = url;
        this.remarks = remarks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() { return time; }

    public void setTime(String time) { this.time = time; }

    public String getType() { return  type; }

    public void setType(String type) { this.type = type; }

    public String getURL() { return  url; }

    public void setURL(String url) { this.url = url; }

    public String getRemarks() { return remarks; }

    public void setRemarks(String remarks) { this.remarks = remarks; }
}

package com.bohanee.jcp.hrai.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Shivanshu Raj on 25-01-2023.
 */
@Entity
public class User {
    @PrimaryKey
    private int id=0;
    private String phoneNo;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(int id, String phoneNo) {
        this.id = id;
        this.phoneNo = phoneNo;
    }

    @Ignore
    public User(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Ignore
    public User(String phoneNo, String name) {
        this.phoneNo = phoneNo;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
}

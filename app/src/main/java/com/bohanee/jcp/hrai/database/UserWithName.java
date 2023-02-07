package com.bohanee.jcp.hrai.database;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Shivanshu Raj on 07-02-2023.
 */
@Entity
public class UserWithName {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String phoneNo;


    public UserWithName(int id, String name, String phoneNo) {
        this.id = id;
        this.name=name;
        this.phoneNo = phoneNo;
    }

    @Ignore
    public UserWithName(String name, String phoneNo) {
        this.name=name;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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


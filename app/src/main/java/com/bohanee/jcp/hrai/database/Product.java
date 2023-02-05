package com.bohanee.jcp.hrai.database;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

/**
 * Created by Shivanshu Raj on 09-10-2022.
 */
@Entity
public class Product {
    @PrimaryKey@NonNull
    private String productName;
    private int cp;
    private int sp;
    private int quantity;

    public Product(String productName, int sp, int quantity) {
        this.productName = productName;
        this.sp = sp;
        this.quantity = quantity;
    }

    @Ignore
    public Product(String productName, int cp, int sp, int quantity) {
        this.productName = productName;
        this.cp = cp;
        this.sp = sp;
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {
        this.cp = cp;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

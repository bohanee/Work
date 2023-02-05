package com.bohanee.jcp.hrai.database;

/**
 * Created by Shivanshu Raj on 27-01-2023.
 */

import androidx.room.Dao;
import androidx.room.Insert;


@Dao
public interface ProductDao {
//    @Query("SELECT * FROM productTable")
//    List<Product> loadAllTasks();

    @Insert
    void insertTask(Product product);
}


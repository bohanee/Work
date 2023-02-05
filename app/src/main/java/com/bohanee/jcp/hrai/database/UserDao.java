package com.bohanee.jcp.hrai.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

/**
 * Created by Shivanshu Raj on 27-01-2023.
 */
@Dao
public interface UserDao {
    @Insert
    void insertUser(User user);

    @Query("SELECT * FROM user WHERE id=:id")
    User loadUserById(int id);
    @Query("DELETE FROM user")
    void deleteTable();
}

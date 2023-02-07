package com.bohanee.jcp.hrai.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

/**
 * Created by Shivanshu Raj on 07-02-2023.
 */
@Dao
public interface UserWithNameDao {
    @Insert
    void insertUserWithName(UserWithName userWithName);

    @Query("SELECT * FROM userwithname WHERE id=:id")

    User loadUserWithNameById(int id);
    @Query("DELETE FROM userwithname")
    void deleteTable();
}

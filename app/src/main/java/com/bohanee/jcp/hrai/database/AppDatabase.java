package com.bohanee.jcp.hrai.database;

/**
 * Created by Shivanshu Raj on 24-01-2023.
 */

import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Product.class, User.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static final Object LOCK = new Object();
    private static final String  DATABASE_NAME = "productList";
    private static final String TAG = "TempDatabase";
    public static AppDatabase sInstance;

    public static AppDatabase getInstance(Context context) {
        if (sInstance == null) {
            synchronized (LOCK) {
                Log.d(TAG, "getInstance: Creating new database...");
                sInstance= Room.databaseBuilder(context, AppDatabase.class, AppDatabase.DATABASE_NAME)
                        .allowMainThreadQueries()
                        .build();
            }

        }
        Log.d(TAG, "getInstance: returning instance of the already instantiated database");
        return sInstance;

    }

    public abstract UserDao userDao();
}

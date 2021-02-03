package com.example.roomdbdemo;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Entity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDataBase extends RoomDatabase {

    /**
     * To access methods in the Dao...
     */
    public abstract UserDao userDao();

    /**
     * Instance build, return the instance of the room database to access the dao..
     */
    static UserDataBase  INSTANCE;
    public static  UserDataBase getINSTANCE(Context context)
    {
        INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                UserDataBase.class, "userDatabase").allowMainThreadQueries().build();
        return INSTANCE;
    }


}

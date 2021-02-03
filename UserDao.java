package com.example.roomdbdemo;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

/**
 * Annotation..
 * To show its an Dao
 */
@Dao
public interface UserDao {
    /**
     * This shows it can insert...
     * We passed in user object also..
     */
    @Insert
    void insertUser(User user);

    /**
     * This shows to delete...
     * We passed in user object also..
     */
    @Delete
    void deleteUser(User user);

    /**
     *
     * @return
     */
    @Query("SELECT * FROM User")
  LiveData<List<User>> SelectFrom();
}

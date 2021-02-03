package com.example.roomdbdemo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Annotation..
 * To show its an entity
 */
@Entity
public class User {
    /**
     * Primary key...
     * To generate numbers automatically..
     */
    @PrimaryKey (autoGenerate = true)
    int Id;

    /**
     * To change the name..
     */
    @ColumnInfo (name = "First Name")
    public String FirstName;

    /**
     * To change the name..
     */
    @ColumnInfo (name = "Last Name")
    public String LastName;

    /**
     * To change the name..
     */
    @ColumnInfo (name = "Age")
    public int Age;
}

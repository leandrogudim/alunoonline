package com.example.a1614290087.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

/**
 * Created by 1614290087 on 20/04/2018.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM usuario")
    public User[] todosUsuarios();

    @Insert
    public void inserir (User u);

    @Delete
    public void remover (User u);
}

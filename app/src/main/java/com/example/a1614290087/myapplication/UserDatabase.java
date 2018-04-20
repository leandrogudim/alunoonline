package com.example.a1614290087.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by 1614290087 on 20/04/2018.
 */

@Database(entities = {User.class,Evento.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase{
    public abstract UserDao dao();
}

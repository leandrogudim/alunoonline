package com.example.a1614290087.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by 1614290087 on 20/04/2018.
 */

@Entity(tableName = "usuario")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "matricula_usuario")
    public String matricula;

    @ColumnInfo(name = "nome_usuario")
    public String nome;
}

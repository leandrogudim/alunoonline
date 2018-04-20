package com.example.a1614290087.myapplication;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by 1614290087 on 20/04/2018.
 */

@Entity
public class Evento {
    @PrimaryKey
    public int id;

    @ColumnInfo(name = "nome_evento")
    public String nome;
}

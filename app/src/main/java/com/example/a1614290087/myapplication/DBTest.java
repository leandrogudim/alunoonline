package com.example.a1614290087.myapplication;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DBTest extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbtest);
        //TESTE DB FIREBASE FAIL
        /*
        TextView dbTest =
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");

        myRef.setValue("Hello, World!");
        */

        //DB DAO
        UserDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                UserDatabase.class,"arquivobancodedados")
                .allowMainThreadQueries().build();
        User u = new User();
        u.matricula = "X12341234";
        u.nome = "João";

        User u2 = new User();
        u.matricula = "X43214321";
        u.nome = "Maria";

        db.dao().inserir(u);
        db.dao().inserir(u2);

        User[] lista = db.dao().todosUsuarios();
        for (User x : lista){
            Log.d("APP", x.matricula);
        }
    }
}

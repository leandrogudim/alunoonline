package com.example.a1614290087.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RecuperarSenha extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recuperar_senha);

//        Button bt = (Button) findViewById(R.id.btnEnviar);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        Button bt = (Button) findViewById(R.id.btnVoltar);
        bt.setOnClickListener(new View.OnClickListener() {
                                  @Override
                                  public void onClick(View v) {
                                      finish();
                                  }
                              }

        );

        View criaConta = findViewById(R.id.criaConta);
        criaConta.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent t = new Intent(RecuperarSenha.this, CriarConta.class);
                startActivity(t);
            }
        });
    }
}


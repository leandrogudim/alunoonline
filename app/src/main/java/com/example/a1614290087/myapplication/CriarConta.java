package com.example.a1614290087.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CriarConta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        Button bt = (Button) findViewById(R.id.btnVoltar);
        bt.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View v) {
                                      finish();
                                  }
                              }

        );

        Button btOK = (Button) findViewById(R.id.btnConfirmar);
        btOK.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent t = new Intent(CriarConta.this, CadastroConcluido.class);
                startActivity(t);
            }
        });
    }
}

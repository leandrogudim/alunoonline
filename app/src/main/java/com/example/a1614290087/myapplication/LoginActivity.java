package com.example.a1614290087.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    private EditText txtEmail;
    private EditText txtSenha;
    CallbackManager callbackManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        txtEmail = findViewById(R.id.txtEmail);
        txtSenha = findViewById(R.id.txtSenha);

        Button bt = (Button) findViewById(R.id.btnLogin);
        bt.setOnClickListener(new View.OnClickListener() {

                                  @Override
                                  public void onClick(View v) {
                                      login();
                                  }
                              }

        );

        ImageView mapGoogle = findViewById(R.id.mapShortcut);
        mapGoogle.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent t = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(t);
            }
        });



        View criaConta = findViewById(R.id.criaConta);
        criaConta.setOnClickListener(new View.OnClickListener() {

                                       @Override
                                       public void onClick(View v) {
                                           Intent t = new Intent(LoginActivity.this, CriarConta.class);
                                           startActivity(t);
                                       }
                                   }

        );

        View recuperaSenha = findViewById(R.id.recuperarSenha);
        recuperaSenha.setOnClickListener(new View.OnClickListener() {

                                         @Override
                                         public void onClick(View v) {
                                             Intent t = new Intent(LoginActivity.this, RecuperarSenha.class);
                                             startActivity(t);
                                         }
                                     }

        );

        callbackManager = CallbackManager.Factory.create();



        LoginButton btnFacebookLogin = (LoginButton) findViewById(R.id.btnFacebook);
        btnFacebookLogin.setReadPermissions("email");


        // Callback registration
        btnFacebookLogin.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("A","SUCESSO!!");
    }

    private void login(){
        mAuth.signInWithEmailAndPassword(txtEmail.getText().toString(), txtSenha.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Não foi possível efetuar login", Toast.LENGTH_LONG).show();
                        } else {
                            Intent it = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(it);
                        }

                    }
                });
    }
}

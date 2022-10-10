package com.example.projetologin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relative);
        TextView cadastroTela = findViewById(R.id.textView5);
        EditText usuario = findViewById(R.id.editTextTextEmailAddress);
        EditText senha = findViewById(R.id.editTextTextPassword);
        Button entrar = findViewById(R.id.button);

        cadastroTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(MainActivity.this, CadastroActivity.class);
                startActivity(it);

            }
        });

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(usuario.getText().length() == 0 )
                {
                   usuario.setError("O campo usuario é obrigatorio");
                }else if(senha.getText().length() == 0 ){
                    senha.setError("O campo usuario é obrigatorio");

                }
            }
        });




    }
}



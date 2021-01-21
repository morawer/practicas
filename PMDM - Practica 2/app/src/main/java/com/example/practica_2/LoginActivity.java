package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().hide();
    }

    public void crearUsuario(View view) {
        Toast toast = Toast.makeText(this, "Función no disponible.", Toast.LENGTH_LONG );
        toast.show();
    }

    public void entrarButon (View view) {
        TextInputEditText usuario = (TextInputEditText) findViewById(R.id.user);
        TextInputEditText pass = (TextInputEditText) findViewById(R.id.password);


    }
}
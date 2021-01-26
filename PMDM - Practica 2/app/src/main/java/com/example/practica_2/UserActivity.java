package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.practica_2.db.ControladorDB;
import com.google.android.material.textfield.TextInputEditText;

public class UserActivity extends AppCompatActivity {

    ControladorDB dbUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        dbUser = new ControladorDB(this);
        getSupportActionBar().hide();

    }

    public void crearUsuario(View view) {

        TextInputEditText nombreUser = (TextInputEditText) findViewById(R.id.nombreUser);
        TextInputEditText passUser = (TextInputEditText) findViewById(R.id.passwordUser);

        String nombre = nombreUser.getText().toString();
        String pass = passUser.getText().toString();

        dbUser.addUser(nombre, pass);

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
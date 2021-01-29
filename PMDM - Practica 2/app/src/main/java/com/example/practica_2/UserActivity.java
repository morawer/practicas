package com.example.practica_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

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

        TextView tittle = (TextView)findViewById(R.id.titulo);
        Typeface font = Typeface.createFromAsset(getAssets(), "Rashkey.ttf");
        tittle.setTypeface(font);

    }

    public void crearUsuario(View view) {

        TextInputEditText nombreUser = (TextInputEditText) findViewById(R.id.nombreUser);
        TextInputEditText passUser = (TextInputEditText) findViewById(R.id.passwordUser);

        String nombre = nombreUser.getText().toString();
        String pass = passUser.getText().toString();

        if (dbUser.addUser(nombre, pass) == false) {
            Toast toast = Toast.makeText(this, R.string.usuarioExiste, Toast.LENGTH_LONG);
            toast.show();
        }

        Toast toast = Toast.makeText(this, R.string.usuarioCreado, Toast.LENGTH_LONG);
        toast.show();

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}